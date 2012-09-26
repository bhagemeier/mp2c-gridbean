/*********************************************************************************
 * Copyright (c) 2012 Forschungszentrum Juelich GmbH 
 * All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * 
 * (1) Redistributions of source code must retain the above copyright notice,
 * this list of conditions and the disclaimer at the end. Redistributions in
 * binary form must reproduce the above copyright notice, this list of
 * conditions and the following disclaimer in the documentation and/or other
 * materials provided with the distribution.
 * 
 * (2) Neither the name of Forschungszentrum Juelich GmbH nor the names of its 
 * contributors may be used to endorse or promote products derived from this 
 * software without specific prior written permission.
 * 
 * DISCLAIMER
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 ********************************************************************************/
package eu.unicore.applications.mp2c;

import javax.xml.namespace.QName;

/**
 * This file contains constants and other information shared by several of the
 * classes of this GridBean.
 * 
 * @author bjoernh
 * 
 *         29.06.2012 09:42:05
 * 
 */
public class MP2CGridBeanParameters {

    static final String NS = "http://www.unicore.eu/applications/mp2c";

    static final QName CONTROL_FILE_QNAME = new QName(NS, "controlFile");
    static final String CONTROL_FILE_NAME = "mp2c_ctrl.inp";
    static final QName SOLUTE_FILE_QNAME = new QName(NS, "soluteFile");
    static final String SOLUTE_FILE_NAME = "mp2c_slt.inp";
    static final QName SOLVENT_FILE_QNAME = new QName(NS, "solventFile");
    static final String SOLVENT_FILE_NAME = "mp2c_slv.inp";
    static final QName QUENCH_FILE_QNAME = new QName(NS, "quenchFile");
    static final String QUENCH_FILE_NAME = "mp2c_quench.inp";
    static final QName IO_FILE_QNAME = new QName(NS, "ioFile");
    static final String IO_FILE_NAME = "mp2c_io.inp";
    static final QName PARALLEL_FILE_QNAME = new QName(NS, "quenchFile");
    static final String PARALLEL_FILE_NAME = "mp2c_par.inp";

    // The Control file
    static final QName CTRL_SIM_SOLUTE = new QName(NS, "simulateSolute");
    static final QName CTRL_SIM_SOLVENT = new QName(NS, "simulateSolvent");
    static final QName CTRL_TIMESTEPS = new QName(NS, "timesteps");
    static final QName CTRL_TEMPERATURE = new QName(NS, "temperature");
    static final QName CTRL_BOX_RATIO_X = new QName(NS, "box_ratio_x");
    static final QName CTRL_BOX_RATIO_Y = new QName(NS, "box_ratio_y");
    static final QName CTRL_BOX_RATIO_Z = new QName(NS, "box_ratio_z");
    static final QName CTRL_BC_X = new QName(NS, "bc_x");
    static final QName CTRL_BC_Y = new QName(NS, "bc_y");
    static final QName CTRL_BC_Z = new QName(NS, "bc_z");
    static final QName CTRL_SHEAR_RATE_X = new QName(NS, "sr_x");
    static final QName CTRL_SHEAR_RATE_Y = new QName(NS, "sr_y");
    static final QName CTRL_SHEAR_RATE_Z = new QName(NS, "sr_z");
    static final QName CTRL_COLL_STEPS_INTERVAL = new QName(NS,
            "coll_steps_interval");
    static final QName CTRL_EXTERNAL_FORCE = new QName(NS, "external_force");
    static final QName CTRL_EXTERNAL_FORCE_X = new QName(NS, "ef_x");
    static final QName CTRL_EXTERNAL_FORCE_Y = new QName(NS, "ef_y");
    static final QName CTRL_EXTERNAL_FORCE_Z = new QName(NS, "ef_z");
    static final QName CTRL_RESTART_SOLUTE = new QName(NS, "restartSolute");
    static final QName CTRL_RESTART_SOLVENT = new QName(NS, "restartSolvent");
    static final QName CTRL_RANDOM_SEED = new QName(NS, "random_seed");
    static final QName CTRL_LANGEVIN = new QName(NS, "langevin");
    static final QName CTRL_LANGEVIN_GAMMA = new QName(NS, "langevin_gamma");
    static final QName CTRL_COUPLING = new QName(NS, "coupling");
    static final QName CTRL_MAX_SCAL = new QName(NS, "max_scal");

    // The IO file
    static final QName IO_STANDARD_OUT = new QName(NS, "standard_out");
    static final QName IO_STANDARD_OUT_STEPS = new QName(NS,
            "standard_out_steps");
    static final QName IO_STANDARD_SOLUTES = new QName(NS, "standard_solutes");
    static final QName IO_STANDARD_SOLUTES_STEPS = new QName(NS,
            "standard_solutes_steps");
    static final QName IO_STANDARD_SOLVENT = new QName(NS, "standard_solvent");
    static final QName IO_STANDARD_SOLVENT_STEPS = new QName(NS,
            "standard_solvent_steps");
    static final QName IO_RESTART_SOLUTE = new QName(NS, "restart_solute");
    static final QName IO_RESTART_SOLUTES_TYPE = new QName(NS,
            "restart_solute_type");
    static final QName IO_RESTART_SOLUTE_STEPS = new QName(NS,
            "restart_solute_steps");
    static final QName IO_RESTART_SOLVENT = new QName(NS, "restart_solvent");
    static final QName IO_RESTART_SOLVENT_TYPE = new QName(NS,
            "restart_solvent_type");
    static final QName IO_RESTART_SOLVENT_STEPS = new QName(NS,
            "restart_solvent_steps");
    static final QName IO_HISTORY_SOLUTE = new QName(NS, "history_solute");
    static final QName IO_HISTORY_SOLUTE_TYPE = new QName(NS,
            "history_solute_type");
    static final QName IO_HISTORY_SOLUTE_STEPS = new QName(NS,
            "history_solute_steps");
    static final QName IO_HISTORY_SOLVENT = new QName(NS, "history_solvent");
    static final QName IO_HISTORY_SOLVENT_TYPE = new QName(NS,
            "history_solvent_type");
    static final QName IO_HISTORY_SOLVENT_STEPS = new QName(NS,
            "history_solvent_steps");
    static final QName IO_XYZ_SYSTEM = new QName(NS, "xyz_system");
    static final QName IO_XYZ_SYSTEM_STEPS = new QName(NS, "xyz_system_steps");
    static final QName IO_XYZ_SOLUTE = new QName(NS, "xyz_solute");
    static final QName IO_XYZ_SOLUTE_TYPE = new QName(NS, "xyz_solute_type");
    static final QName IO_XYZ_SOLUTE_STEPS = new QName(NS, "xyz_solute_steps");
    static final QName IO_XYZ_SOLVENT = new QName(NS, "xyz_solvent");
    static final QName IO_XYZ_SOLVENT_TYPE = new QName(NS, "xyz_solvent_type");
    static final QName IO_XYZ_SOLVENT_STEPS = new QName(NS, "xyz_solvent_steps");
    static final QName IO_USER_OUTPUT = new QName(NS, "user_output");
    static final QName IO_USER_OUTPUT_STEPS = new QName(NS, "user_output_steps");

    // The Solvent file
    static final QName SOLVENT_PPC = new QName(NS, "solvent_ppc");
    static final QName SOLVENT_PARTICLES = new QName(NS, "solvent_particles");
    static final QName SOLVENT_MASS = new QName(NS, "solvent_mass");
    static final QName SOLVENT_LAMBDA = new QName(NS, "solvent_lambda");
    static final QName SOLVENT_ALPHA = new QName(NS, "solvent_alpha");

    // The Quench file
    static final QName QUENCH_INIT_DIM_X = new QName(NS, "quench_init_dim_x");
    static final QName QUENCH_INIT_DIM_Y = new QName(NS, "quench_init_dim_y");
    static final QName QUENCH_INIT_DIM_Z = new QName(NS, "quench_init_dim_z");
    static final QName QUENCH_TGT_DIM_X = new QName(NS, "quench_tgt_dim_x");
    static final QName QUENCH_TGT_DIM_Y = new QName(NS, "quench_tgt_dim_y");
    static final QName QUENCH_TGT_DIM_Z = new QName(NS, "quench_tgt_dim_z");
    static final QName QUENCH_DECR_X = new QName(NS, "decr_x");
    static final QName QUENCH_DECR_Y = new QName(NS, "decr_y");
    static final QName QUENCH_DECR_Z = new QName(NS, "decr_z");

    // The parallel file
    static final QName PARALLEL = new QName(NS, "parallel");

    // Solutes
    public static final QName SOLUTE_USUAL_LJP = new QName(NS, "usual_ljp");
    public static final QName SOLUTE_SHIFTED_LJP = new QName(NS, "shifted_ljp");
    public static final QName SOLUTE_RADIUS_SHIFTED_LJP = new QName(NS,
            "radius_shifted_ljp");
    public static final QName SOLUTE_RADIUS_SHIFTED_SHIFTED_FORCE_LJP = new QName(
            NS, "radius_shifted_shifted_force_ljp");
    public static final QName SOLUTE_SHIFTED_FORCE_LJP = new QName(NS,
            "shifted_force_ljp");
    public static final QName SOLUTE_RADIUS_SHIFTED_LJP_SHIFTED = new QName(NS,
            "radius_shifted_ljp_shifted");
    public static final QName CTRL_THERMOSTAT = new QName(NS, "thermostat");
    public static QName CTRL_THERMOSTAT_COUPL;

}
