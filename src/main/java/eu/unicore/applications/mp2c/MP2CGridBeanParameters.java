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

	static final QName CONTROL_FILE_QNAME = new QName(
	"http://www.unicore.eu/applications/mp2c", "controlFile");
	static final String CONTROL_FILE_NAME = "mp2c_ctrl.inp";
	static final QName SOLUTE_FILE_QNAME = new QName(
	"http://www.unicore.eu/applications/mp2c", "soluteFile");
	static final String SOLUTE_FILE_NAME = "mp2c_slt.inp";
	static final QName SOLVENT_FILE_QNAME = new QName(
	"http://www.unicore.eu/applications/mp2c", "solventFile");
	static final String SOLVENT_FILE_NAME = "mp2c_slv.inp";
	static final QName QUENCH_FILE_QNAME = new QName(
	"http://www.unicore.eu/applications/mp2c", "quenchFile");
	static final String QUENCH_FILE_NAME = "mp2c_quench.inp";
	static final QName IO_FILE_QNAME = new QName(
	"http://www.unicore.eu/applications/mp2c", "ioFile");
	static final String IO_FILE_NAME = "mp2c_io.inp";
	static final QName PARALLEL_FILE_QNAME = new QName(
	"http://www.unicore.eu/applications/mp2c", "quenchFile");
	static final String PARALLEL_FILE_NAME = "mp2c_par.inp";

	// The Control file
	static final QName CTRL_SIM_SOLUTE = new QName(
			"http://www.unicore.eu/applications/mp2c", "simulateSolute");
	static final QName CTRL_SIM_SOLVENT = new QName(
			"http://www.unicore.eu/applications/mp2c", "simulateSolvent");
	static final QName CTRL_TIMESTEPS = new QName(
			"http://www.unicore.eu/applications/mp2c", "timesteps");
	static final QName CTRL_TEMPERATURE = new QName(
			"http://www.unicore.eu/applications/mp2c", "temperature");
	static final QName CTRL_BOX_RATIO_X = new QName(
			"http://www.unicore.eu/applications/mp2c", "box_ratio_x");
	static final QName CTRL_BOX_RATIO_Y = new QName(
			"http://www.unicore.eu/applications/mp2c", "box_ratio_y");
	static final QName CTRL_BOX_RATIO_Z = new QName(
			"http://www.unicore.eu/applications/mp2c", "box_ratio_z");
	static final QName CTRL_BC_X = new QName(
			"http://www.unicore.eu/applications/mp2c", "bc_x");
	static final QName CTRL_BC_Y = new QName(
			"http://www.unicore.eu/applications/mp2c", "bc_y");
	static final QName CTRL_BC_Z = new QName(
			"http://www.unicore.eu/applications/mp2c", "bc_z");
	static final QName CTRL_SHEAR_RATE_X = new QName(
			"http://www.unicore.eu/applications/mp2c", "sr_x");
	static final QName CTRL_SHEAR_RATE_Y = new QName(
			"http://www.unicore.eu/applications/mp2c", "sr_y");
	static final QName CTRL_SHEAR_RATE_Z = new QName(
			"http://www.unicore.eu/applications/mp2c", "sr_z");
	static final QName CTRL_COLL_STEPS_INTERVAL = new QName(
			"http://www.unicore.eu/applications/mp2c", "coll_steps_interval");
	static final QName CTRL_EXTERNAL_FORCE = new QName(
			"http://www.unicore.eu/applications/mp2c", "external_force");
	static final QName CTRL_EXTERNAL_FORCE_X = new QName(
			"http://www.unicore.eu/applications/mp2c", "ef_x");
	static final QName CTRL_EXTERNAL_FORCE_Y = new QName(
			"http://www.unicore.eu/applications/mp2c", "ef_y");
	static final QName CTRL_EXTERNAL_FORCE_Z = new QName(
			"http://www.unicore.eu/applications/mp2c", "ef_z");
	static final QName CTRL_RESTART_SOLUTE = new QName(
			"http://www.unicore.eu/applications/mp2c", "restartSolute");
	static final QName CTRL_RESTART_SOLVENT = new QName(
			"http://www.unicore.eu/applications/mp2c", "restartSolvent");
	static final QName CTRL_RANDOM_SEED = new QName(
			"http://www.unicore.eu/applications/mp2c", "random_seed");
	static final QName CTRL_LANGEVIN = new QName(
			"http://www.unicore.eu/applications/mp2c", "langevin");
	static final QName CTRL_LANGEVIN_GAMMA = new QName(
			"http://www.unicore.eu/applications/mp2c", "langevin_gamma");
	static final QName CTRL_COUPLING = new QName(
			"http://www.unicore.eu/applications/mp2c", "coupling");
	static final QName CTRL_STRICT_SCALING_STEPS = new QName(
			"http://www.unicore.eu/applications/mp2c", "strict_scaling_steps");

	// The IO file
	static final QName IO_STANDARD_OUT = new QName(
			"http://www.unicore.eu/applications/mp2c", "standard_out");
	static final QName IO_STANDARD_OUT_STEPS = new QName(
			"http://www.unicore.eu/applications/mp2c", "standard_out_steps");
	static final QName IO_STANDARD_SOLUTES = new QName(
			"http://www.unicore.eu/applications/mp2c", "standard_solutes");
	static final QName IO_STANDARD_SOLUTES_STEPS = new QName(
			"http://www.unicore.eu/applications/mp2c", "standard_solutes_steps");
	static final QName IO_STANDARD_SOLVENT = new QName(
			"http://www.unicore.eu/applications/mp2c", "standard_solvent");
	static final QName IO_STANDARD_SOLVENT_STEPS = new QName(
			"http://www.unicore.eu/applications/mp2c", "standard_solvent_steps");
	static final QName IO_RESTART_SOLUTE = new QName(
			"http://www.unicore.eu/applications/mp2c", "restart_solute");
	static final QName IO_RESTART_SOLUTES_TYPE = new QName(
			"http://www.unicore.eu/applications/mp2c", "restart_solute_type");
	static final QName IO_RESTART_SOLUTE_STEPS = new QName(
			"http://www.unicore.eu/applications/mp2c", "restart_solute_steps");
	static final QName IO_RESTART_SOLVENT = new QName(
			"http://www.unicore.eu/applications/mp2c", "restart_solvent");
	static final QName IO_RESTART_SOLVENT_TYPE = new QName(
			"http://www.unicore.eu/applications/mp2c", "restart_solvent_type");
	static final QName IO_RESTART_SOLVENT_STEPS = new QName(
			"http://www.unicore.eu/applications/mp2c", "restart_solvent_steps");
	static final QName IO_HISTORY_SOLUTE = new QName(
			"http://www.unicore.eu/applications/mp2c", "history_solute");
	static final QName IO_HISTORY_SOLUTE_TYPE = new QName(
			"http://www.unicore.eu/applications/mp2c", "history_solute_type");
	static final QName IO_HISTORY_SOLUTE_STEPS = new QName(
			"http://www.unicore.eu/applications/mp2c", "history_solute_steps");
	static final QName IO_HISTORY_SOLVENT = new QName(
			"http://www.unicore.eu/applications/mp2c", "history_solvent");
	static final QName IO_HISTORY_SOLVENT_TYPE = new QName(
			"http://www.unicore.eu/applications/mp2c", "history_solvent_type");
	static final QName IO_HISTORY_SOLVENT_STEPS = new QName(
			"http://www.unicore.eu/applications/mp2c", "history_solvent_steps");
	static final QName IO_XYZ_SYSTEM = new QName(
			"http://www.unicore.eu/applications/mp2c", "xyz_system");
	static final QName IO_XYZ_SYSTEM_STEPS = new QName(
			"http://www.unicore.eu/applications/mp2c", "xyz_system_steps");
	static final QName IO_XYZ_SOLUTE = new QName(
			"http://www.unicore.eu/applications/mp2c", "xyz_solute");
	static final QName IO_XYZ_SOLUTE_TYPE = new QName(
			"http://www.unicore.eu/applications/mp2c", "xyz_solute_type");
	static final QName IO_XYZ_SOLUTE_STEPS = new QName(
			"http://www.unicore.eu/applications/mp2c", "xyz_solute_steps");
	static final QName IO_XYZ_SOLVENT = new QName(
			"http://www.unicore.eu/applications/mp2c", "xyz_solvent");
	static final QName IO_XYZ_SOLVENT_TYPE = new QName(
			"http://www.unicore.eu/applications/mp2c", "xyz_solvent_type");
	static final QName IO_XYZ_SOLVENT_STEPS = new QName(
			"http://www.unicore.eu/applications/mp2c", "xyz_solvent_steps");
	static final QName IO_USER_OUTPUT = new QName(
			"http://www.unicore.eu/applications/mp2c", "user_output");
	static final QName IO_USER_OUTPUT_STEPS = new QName(
			"http://www.unicore.eu/applications/mp2c", "user_output_steps");

	// The Solvent file
	static final QName SOLVENT_PPC = new QName(
			"http://www.unicore.eu/applications/mp2c", "solvent_ppc");
	static final QName SOLVENT_PARTICLES = new QName(
			"http://www.unicore.eu/applications/mp2c", "solvent_particles");
	static final QName SOLVENT_MASS = new QName(
			"http://www.unicore.eu/applications/mp2c", "solvent_mass");
	static final QName SOLVENT_LAMBDA = new QName(
			"http://www.unicore.eu/applications/mp2c", "solvent_lambda");
	static final QName SOLVENT_ALPHA = new QName(
			"http://www.unicore.eu/applications/mp2c", "solvent_alpha");

	// The Quench file
	static final QName QUENCH_INIT_DIM_X = new QName(
			"http://www.unicore.eu/applications/mp2c", "quench_init_dim_x");
	static final QName QUENCH_INIT_DIM_Y = new QName(
			"http://www.unicore.eu/applications/mp2c", "quench_init_dim_y");
	static final QName QUENCH_INIT_DIM_Z = new QName(
			"http://www.unicore.eu/applications/mp2c", "quench_init_dim_z");
	static final QName QUENCH_TGT_DIM_X = new QName(
			"http://www.unicore.eu/applications/mp2c", "quench_tgt_dim_x");
	static final QName QUENCH_TGT_DIM_Y = new QName(
			"http://www.unicore.eu/applications/mp2c", "quench_tgt_dim_y");
	static final QName QUENCH_TGT_DIM_Z = new QName(
			"http://www.unicore.eu/applications/mp2c", "quench_tgt_dim_z");
	static final QName QUENCH_DECR_X = new QName(
			"http://www.unicore.eu/applications/mp2c", "decr_x");
	static final QName QUENCH_DECR_Y = new QName(
			"http://www.unicore.eu/applications/mp2c", "decr_y");
	static final QName QUENCH_DECR_Z = new QName(
			"http://www.unicore.eu/applications/mp2c", "decr_z");
	
	// The parallel file
	static final QName PARALLEL = new QName(
			"http://www.unicore.eu/applications/mp2c", "parallel");

	// Solutes
	public static final QName SOLUTE_USUAL_LJP = new QName(
			"http://www.unicore.eu/applications/mp2c", "usual_ljp");
	public static final QName SOLUTE_SHIFTED_LJP = new QName(
			"http://www.unicore.eu/applications/mp2c", "shifted_ljp");
	public static final QName SOLUTE_RADIUS_SHIFTED_LJP = new QName(
			"http://www.unicore.eu/applications/mp2c", "radius_shifted_ljp");
	public static final QName SOLUTE_RADIUS_SHIFTED_SHIFTED_FORCE_LJP = new QName(
			"http://www.unicore.eu/applications/mp2c",
			"radius_shifted_shifted_force_ljp");
	public static final QName SOLUTE_SHIFTED_FORCE_LJP = new QName(
			"http://www.unicore.eu/applications/mp2c", "shifted_force_ljp");
	public static final QName SOLUTE_RADIUS_SHIFTED_LJP_SHIFTED = new QName(
			"http://www.unicore.eu/applications/mp2c",
			"radius_shifted_ljp_shifted");

}
