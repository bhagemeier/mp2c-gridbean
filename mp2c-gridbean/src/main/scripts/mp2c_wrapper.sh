#!/bin/bash

# /*********************************************************************************
#  * Copyright (c) 2012 Forschungszentrum Juelich GmbH 
#  * All rights reserved.
#  * 
#  * Redistribution and use in source and binary forms, with or without
#  * modification, are permitted provided that the following conditions are met:
#  * 
#  * (1) Redistributions of source code must retain the above copyright notice,
#  * this list of conditions and the disclaimer at the end. Redistributions in
#  * binary form must reproduce the above copyright notice, this list of
#  * conditions and the following disclaimer in the documentation and/or other
#  * materials provided with the distribution.
#  * 
#  * (2) Neither the name of Forschungszentrum Juelich GmbH nor the names of its 
#  * contributors may be used to endorse or promote products derived from this 
#  * software without specific prior written permission.
#  * 
#  * DISCLAIMER
#  * 
#  * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
#  * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
#  * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
#  * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE
#  * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
#  * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
#  * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
#  * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
#  * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
#  * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
#  * POSSIBILITY OF SUCH DAMAGE.
#  ********************************************************************************/

# This script wraps the MP2C application configured in a UNICORE/X. It
# uses environment variables given by the client (end user client or
# workflow engine) to create input files for the actual application.

CTRL_FILE=mp2c_ctrl.inp
SLV_FILE=mp2c_slv.inp
PAR_FILE=mp2c_par.inp
IO_FILE=mp2c_io.inp
QUENCH_FILE=mp2c_quench.inp

# Generic writing of a plain param
# @param name the name as it appears in the configuration file
# @param value given as the expected env variable name
# @param file
# @param descr optional description
function writeParam() {
    # only write if variable has been defined
    if [ -z "`eval echo \\$$2`" ]; then
	return
    fi
    name=$1
    value=`eval echo \\$$2`
    file=${3}
    descr=${4:-""}

    echo '**'${name}'**          '${descr} >> ${file}
    echo ${value} >> ${file}
    echo >> ${file}
}

# Write the exit marker
# @param file
function writeExit() {
    echo '********' >> ${1}
    echo '**exit**' >> ${1}
    echo '********' >> ${1}
}

function resetFile() {
    truncate -s 0 ${1}
}


##################################################
## Everything related to the CTRL file          ##
##################################################
function writeCtrlFile() {
    resetFile ${CTRL_FILE}
    writeParam solute simulateSolute ${CTRL_FILE} 'solutes are simulated'
    writeParam solvent simulateSolvent ${CTRL_FILE} 'solvent is simulated'
    writeParam nsteps timesteps ${CTRL_FILE} 'number of time steps'
    writeParam temperature temperature ${CTRL_FILE} 'temperature in kT'
    box_ratio="${box_ratio_x} ${box_ratio_y} ${box_ratio_z}"
    writeParam box-ratio box_ratio ${CTRL_FILE} 'ratio of box-lengths'
    bc="${bc_x} ${bc_y} ${bc_z}"
    writeParam boundary bc ${CTRL_FILE} 'boundary conditions'
    shear_rate="${sr_x} ${sr_y} ${sr_z}"
    writeParam shear-rate shear_rate ${CTRL_FILE} ''
    writeParam coll-step coll_steps_interval ${CTRL_FILE} 'interval for collision steps'
    if [ ${external_force}="true" ]; then
	ext_force="${ef_x} ${ef_y} ${ef_z}"
	writeParam ext-force ext_force ${CTRL_FILE} 'external force'
    fi
    writeRestartConfig
    writeParam random-seed random_seed ${CTRL_FILE} 'random seed value'
    writeLangevinConfig
    writeThermostatConfig
    writeExit ${CTRL_FILE}
}

function writeRestartConfig() {
    echo '**restart**     switches to start from restart configurations' >> ${CTRL_FILE}
    echo '++solute++' >> ${CTRL_FILE}
    echo '.'${restartSolute}'.  .'${restartSolute}'.' >> ${CTRL_FILE}
    echo >> ${CTRL_FILE}
    echo '++solvent++' >> ${CTRL_FILE}
    echo '.'${restartSolvent}'.  .'${restartSolvent}'.' >> ${CTRL_FILE}
    echo '**end**'  >> ${CTRL_FILE}
}

function writeLangevinConfig() {
    if [ ${langevin}="true" ]; then
	echo '**langevin**          perform Langevin dynamics' >> ${CTRL_FILE}
	echo '++gamma++' >> ${CTRL_FILE}
	echo ${langevin_gamma}  >> ${CTRL_FILE}
	echo '**end**' >> ${CTRL_FILE}
    fi
}

function writeThermostatConfig() {
    if [ ${thermostat}="true" ]; then
	echo '**thermostat**     at present only Berendsen weak-coupling version' >> ${CTRL_FILE}
	echo '++coupl++          coupling constant' >> ${CTRL_FILE}
	echo ${thermostat_coupling} >> ${CTRL_FILE}
	echo >> ${CTRL_FILE}
	echo '++max-scal++         max. number of steps for strict scaling' >> ${CTRL_FILE}
	echo ${max_scal} >> ${CTRL_FILE}
	echo '**end**' >> ${CTRL_FILE}
    fi
}

##################################################
## Everything related to the SLV file           ##
##################################################
function writeSolventFile() {
    writeParam "part:cell" solvent_ppc ${SLV_FILE} 'average number particles/cell'
    writeParam particles solvent_particles ${SLV_FILE} 'number of solvent particles'
    writeParam mass solvent_mass ${SLV_FILE} 'mass of solvent particles'
    writeParam lambda solvent_lambda ${SLV_FILE} 'collision length'
    writeParam alpha solvent_alpha ${SLV_FILE} 'scattering angle'
    writeExit ${SLV_FILE}
}

##################################################
## Everything related to the IO file            ##
##################################################
function writeIoFile() {
    echo "# I/O settings" >> ${IO_FILE}

    echo "# general standard I/O" >> ${IO_FILE}
    echo "."${standard_out}".    # l_std" >> ${IO_FILE}
    echo ${standard_out_steps}"     # intv_std" >> ${IO_FILE}

    echo "# standard I/O for solutes" >> ${IO_FILE}
    echo "."${standard_solutes}".    # l_std_slt" >> ${IO_FILE}
    echo ${standard_solutes_steps}"     # intv_std_slt" >> ${IO_FILE}

    echo "# standard I/O for solvent" >> ${IO_FILE}
    echo "."${standard_solvent}".    # l_std_slv" >> ${IO_FILE}
    echo ${standard_solvent_steps}"     # intv_std_slv" >> ${IO_FILE}

    echo "# restart information for solute" >> ${IO_FILE}
    echo "."${write_restart_solute}". "${restart_solute_type}"   # l_res_slt, s_res_slt" >> ${IO_FILE}
    echo ${restart_solute_steps}"     # intv_res_slt" >> ${IO_FILE}

    echo "# restart information for solvent" >> ${IO_FILE}
    echo "."${write_restart_solvent}". "${restart_solvent_type}"   #  l_res_slv, s_res_slv" >> ${IO_FILE}
    echo ${restart_solvent_steps}"     # intv_res_slv" >> ${IO_FILE}

    echo "# history information for solute" >> ${IO_FILE}
    echo "."${history_solute}". "${history_solute_type}"   # l_his_slt" >> ${IO_FILE}
    echo ${history_solute_steps}"     # intv_his_slt" >> ${IO_FILE}

    echo "# history information for solvent" >> ${IO_FILE}
    echo "."${history_solvent}". "${history_solvent_type}"   # l_his_slv" >> ${IO_FILE}
    echo ${history_solvent_steps}"     # intv_his_slv" >> ${IO_FILE}

    echo "# xyz file for the whole system" >> ${IO_FILE}
    echo "."${xyz_system}".    # l_xyz" >> ${IO_FILE}
    echo ${xyz_system_steps}"     # intv_xyz" >> ${IO_FILE}

    echo "# xyz file for solute" >> ${IO_FILE}
    echo "."${xyz_solute}". "${xyz_solute_type}"   # l_xyz_slt" >> ${IO_FILE}
    echo ${xyz_solute_steps}"     # intv_xyz_slt" >> ${IO_FILE}

    echo "# xyz file for solvent" >> ${IO_FILE}
    echo "."${xyz_solvent}". "${xyz_solvent_type}"   # l_xyz_slv" >> ${IO_FILE}
    echo ${xyz_solvent_steps}"     # intv_xyz_slv" >> ${IO_FILE}

    echo "# user specific output" >> ${IO_FILE}
    echo "."${user_output}".    # l_usr_1" >> ${IO_FILE}
    echo ${standard_out_steps}"     # intv_usr_1" >> ${IO_FILE}
}

##################################################
## Everything related to the quench file        ##
##################################################
function writeQuenchFile() {
 # TODO: this has changed and I'm waiting for Rene's input
    true
}

##################################################
## Everything related to the parallel file      ##
##################################################
function writeParallelFile() {
    echo ${parallel}'          # dimension of parallel subdivision' >> ${PAR_FILE}
}



writeCtrlFile
writeSolventFile
writeIoFile
writeQuenchFile
writeParallelFile

