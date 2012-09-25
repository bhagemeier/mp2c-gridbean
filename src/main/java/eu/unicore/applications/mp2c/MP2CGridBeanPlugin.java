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

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import com.intel.gpe.clients.api.Client;
import com.intel.gpe.clients.api.async.IProgressListener;
import com.intel.gpe.gridbeans.parameters.IGridBeanParameterValue;
import com.intel.gpe.gridbeans.parameters.InputFileParameterValue;
import com.intel.gpe.gridbeans.plugins.DataSetException;
import com.intel.gpe.gridbeans.plugins.swt.SWTGridBeanPlugin;
import com.intel.gpe.util.defaults.preferences.INode;

import eu.unicore.applications.mp2c.model.Solute;

/**
 * @author bjoernh
 * 
 *         23.03.2012 11:48:52
 * 
 */
public class MP2CGridBeanPlugin extends SWTGridBeanPlugin {

	private static final String NEWLINE = System.getProperty("line.separator");
	private static final String END_SECTION = "**end**" + NEWLINE + NEWLINE;

	/**
	 * @see com.intel.gpe.gridbeans.plugins.swt.SWTGridBeanPlugin#initialize(com.intel.gpe.clients.api.Client,
	 *      com.intel.gpe.util.defaults.preferences.INode)
	 */
	@Override
	public void initialize(Client client, INode node) {
		super.initialize(client, node);

		addInputPanel(new GeneralSettingsGBPanel(client, "General"));
		addInputPanel(new SolventSettingsGBPanel(client, "Solvent"));
		addInputPanel(new IOSettingsGBPanel(client, "I/O"));
		addInputPanel(new ParallelExecutionSettingsGBPanel(client,
				"Parallel Execution"));
		
		String projectTmpDir = client.getFileFactory().getTemporaryDirName();
        File prTmp = new File(projectTmpDir);
		
        final InputFileParameterValue controlFileIn = new InputFileParameterValue(
                new File(prTmp, MP2CGridBeanParameters.CONTROL_FILE_NAME)
                        .getAbsolutePath());
        controlFileIn.getTarget().setRelativePath(
                MP2CGridBeanParameters.CONTROL_FILE_NAME);
        getGridBeanModel().set(MP2CGridBeanParameters.CONTROL_FILE_QNAME,
                controlFileIn);
        
        final InputFileParameterValue soluteFileIn = new InputFileParameterValue(
                new File(prTmp, MP2CGridBeanParameters.SOLUTE_FILE_NAME)
                        .getAbsolutePath());
        soluteFileIn.getTarget().setRelativePath(
                MP2CGridBeanParameters.SOLUTE_FILE_NAME);
        getGridBeanModel().set(MP2CGridBeanParameters.SOLUTE_FILE_QNAME,
                soluteFileIn);

        final InputFileParameterValue solventFileIn = new InputFileParameterValue(
                new File(prTmp, MP2CGridBeanParameters.SOLVENT_FILE_NAME)
                        .getAbsolutePath());
        solventFileIn.getTarget().setRelativePath(
                MP2CGridBeanParameters.SOLVENT_FILE_NAME);
        getGridBeanModel().set(MP2CGridBeanParameters.SOLVENT_FILE_QNAME,
                solventFileIn);

        final InputFileParameterValue quenchFileIn = new InputFileParameterValue(
                new File(prTmp, MP2CGridBeanParameters.QUENCH_FILE_NAME)
                        .getAbsolutePath());
        quenchFileIn.getTarget().setRelativePath(
                MP2CGridBeanParameters.QUENCH_FILE_NAME);
        getGridBeanModel().set(MP2CGridBeanParameters.QUENCH_FILE_QNAME,
                quenchFileIn);

        final InputFileParameterValue ioFileIn = new InputFileParameterValue(
                new File(prTmp, MP2CGridBeanParameters.IO_FILE_NAME)
                        .getAbsolutePath());
        ioFileIn.getTarget().setRelativePath(
                MP2CGridBeanParameters.IO_FILE_NAME);
        getGridBeanModel().set(MP2CGridBeanParameters.IO_FILE_QNAME, ioFileIn);

        final InputFileParameterValue parallelFileIn = new InputFileParameterValue(
                new File(prTmp, MP2CGridBeanParameters.PARALLEL_FILE_NAME)
                        .getAbsolutePath());
        parallelFileIn.getTarget().setRelativePath(
                MP2CGridBeanParameters.PARALLEL_FILE_NAME);
        getGridBeanModel().set(MP2CGridBeanParameters.PARALLEL_FILE_QNAME,
                parallelFileIn);
	}

	/**
	 * @see com.intel.gpe.gridbeans.plugins.swt.SWTGridBeanPlugin#saveDataToExternalSource(com.intel.gpe.clients.api.async.IProgressListener)
	 */
	@Override
	public void saveDataToExternalSource(IProgressListener progress)
			throws DataSetException {
		super.saveDataToExternalSource(progress);
		try {
		writeControlFile();
			saveSolventSettings();
		// saveIoSettings();
		writeParallelSettings();
		// progress.beginTask("Writing MP2C configuration", 6);
		} catch (IOException e) {
			// TODO handle exception
			// DataSetException will not do.
			e.printStackTrace();
		}
	
		}


	/**
	 * 
	 */
	private void saveSolventSettings() throws IOException {
		OutputStream os = new FileOutputStream(
				((InputFileParameterValue) getGridBeanModel().get(
						MP2CGridBeanParameters.SOLVENT_FILE_QNAME)).getSource()
						.getInternalString());


	}

	/**
	 * @throws IOException
	 * 
	 */
	private void writeParallelSettings() throws IOException {
		OutputStream os = new FileOutputStream(
				((InputFileParameterValue) getGridBeanModel().get(
						MP2CGridBeanParameters.IO_FILE_QNAME)).getSource()
						.getInternalString());
		
		StringBuilder sb = new StringBuilder();
		sb.append(getGridBeanModel().get(MP2CGridBeanParameters.PARALLEL));
		sb.append("     # dimension of parallel subdivision");

		os.close();
	}

	/**
	 * @throws IOException
	 * 
	 */
	private void writeControlFile() throws IOException {
		OutputStream os = new FileOutputStream(
				((InputFileParameterValue) getGridBeanModel().get(
						MP2CGridBeanParameters.CONTROL_FILE_QNAME)).getSource()
						.getInternalString());

		writeCtrlSolute(os);
		writeCtrlSolvent(os);
		writeCtrlTimeSteps(os);
		writeCtrlTemperature(os);
		writeCtrlBoxRatio(os);
		writeCtrlBoundaries(os);
		writeCtrlShearRate(os);
		writeCtrlCollisionSteps(os);
		writeCtrlExternalForce(os);
		writeCtrlRestart(os);
		writeCtrlRandomSeed(os);
		writeCtrlLangevin(os);
		// The two following methods are stubs
		// writeCtrlThermostat(os);
		// writeCtrlMaxScal(os);
		os.close();

	}

	/**
	 * @param _os
	 * @throws IOException
	 */
	private void writeCtrlSolute(OutputStream _os) throws IOException {
		StringBuilder sb = new StringBuilder();
		sb.append("**solute**      solutes are simulated").append(NEWLINE);
		sb.append(".")
				.append(getGridBeanModel().get(
						MP2CGridBeanParameters.CTRL_SIM_SOLUTE))
				.append(".").append(NEWLINE).append(NEWLINE);

		_os.write(sb.toString().getBytes());

	}

	/**
	 * @param _os
	 * @throws IOException
	 */
	private void writeCtrlSolvent(OutputStream _os) throws IOException {
		StringBuilder sb = new StringBuilder();
		sb.append("**solvent**      solvent is simulated").append(NEWLINE);
		sb.append(".")
				.append(getGridBeanModel().get(
						MP2CGridBeanParameters.CTRL_SIM_SOLVENT))
				.append(".").append(NEWLINE).append(NEWLINE);

		_os.write(sb.toString().getBytes());
	}

	/**
	 * @param _os
	 * @throws IOException
	 */
	private void writeCtrlTimeSteps(OutputStream _os) throws IOException {
		StringBuilder sb = new StringBuilder();
		sb.append("**nsteps**   number of time steps").append(NEWLINE);
		sb.append(getGridBeanModel().get(MP2CGridBeanParameters.CTRL_TIMESTEPS))
				.append(NEWLINE)
				.append(NEWLINE);

		_os.write(sb.toString().getBytes());
	}

	/**
	 * @param _os
	 * @throws IOException
	 */
	private void writeCtrlTemperature(OutputStream _os) throws IOException {
		StringBuilder sb = new StringBuilder();
		sb.append("**temperature**  temperature in kT").append(NEWLINE);
		sb.append(
				getGridBeanModel().get(MP2CGridBeanParameters.CTRL_TEMPERATURE))
				.append(NEWLINE)
				.append(NEWLINE);

		_os.write(sb.toString().getBytes());
	}

	/**
	 * @param _os
	 * @throws IOException
	 */
	private void writeCtrlBoxRatio(OutputStream _os) throws IOException {
		StringBuilder sb = new StringBuilder();

		sb.append("**box-ratio**    ratio of box-lengths").append(NEWLINE);
		sb.append(
				getGridBeanModel().get(MP2CGridBeanParameters.CTRL_BOX_RATIO_X))
				.append(" ");
		sb.append(
				getGridBeanModel().get(MP2CGridBeanParameters.CTRL_BOX_RATIO_Y))
				.append(" ");
		sb.append(
				getGridBeanModel().get(MP2CGridBeanParameters.CTRL_BOX_RATIO_Z))
				.append(NEWLINE)
				.append(NEWLINE);

		_os.write(sb.toString().getBytes());
	}

	/**
	 * @param _os
	 * @throws IOException
	 */
	private void writeCtrlBoundaries(OutputStream _os) throws IOException {
		// TODO Generate correct mapping from human readable Strings to
		// application Strings
		StringBuilder sb = new StringBuilder();
		sb.append("**boundary**     boundary conditions").append(NEWLINE);
		sb.append(getGridBeanModel().get(MP2CGridBeanParameters.CTRL_BC_X))
				.append(" ");
		sb.append(getGridBeanModel().get(MP2CGridBeanParameters.CTRL_BC_Y))
				.append(" ");
		sb.append(getGridBeanModel().get(MP2CGridBeanParameters.CTRL_BC_Z))
				.append(NEWLINE)
				.append(NEWLINE);

		_os.write(sb.toString().getBytes());
	}

	/**
	 * @param _os
	 * @throws IOException
	 */
	private void writeCtrlShearRate(OutputStream _os) throws IOException {
		StringBuilder sb = new StringBuilder();
		sb.append("**shear-rate**").append(NEWLINE);
		sb.append(
				getGridBeanModel()
						.get(MP2CGridBeanParameters.CTRL_SHEAR_RATE_X)).append(
				" ");
		sb.append(
				getGridBeanModel()
						.get(MP2CGridBeanParameters.CTRL_SHEAR_RATE_Y)).append(
				" ");
		sb.append(
				getGridBeanModel()
						.get(MP2CGridBeanParameters.CTRL_SHEAR_RATE_Z))
				.append(NEWLINE).append(NEWLINE);

		_os.write(sb.toString().getBytes());
	}

	/**
	 * @param _os
	 * @throws IOException
	 */
	private void writeCtrlCollisionSteps(OutputStream _os) throws IOException {
		StringBuilder sb = new StringBuilder();
		sb.append("**coll-step**    interval for collision steps").append(
				NEWLINE);
		sb.append(
				getGridBeanModel().get(
						MP2CGridBeanParameters.CTRL_COLL_STEPS_INTERVAL))
				.append(
				NEWLINE);

		_os.write(sb.toString().getBytes());
	}

	/**
	 * @param _os
	 * @throws IOException
	 */
	private void writeCtrlExternalForce(OutputStream _os) throws IOException {
		StringBuilder sb = new StringBuilder();
		// TODO check whether this works, I actually expect a String from get()
		Boolean extforceObj = (Boolean) getGridBeanModel().get(
				MP2CGridBeanParameters.CTRL_EXTERNAL_FORCE);
		boolean extforce = false;
		if (extforceObj != null) {
			extforce = true;
		}
		if (!extforce) {
			sb.append("*Off*ext-force**     external force").append(NEWLINE);
		} else {
			sb.append("**ext-force**     external force").append(NEWLINE);
		}
		sb.append(
				getGridBeanModel().get(
						MP2CGridBeanParameters.CTRL_EXTERNAL_FORCE_X))
				.append(" ")
				.append(getGridBeanModel().get(
						MP2CGridBeanParameters.CTRL_EXTERNAL_FORCE_Y))
				.append(" ")
				.append(getGridBeanModel().get(
						MP2CGridBeanParameters.CTRL_EXTERNAL_FORCE_Z))
				.append(NEWLINE).append(NEWLINE);

		_os.write(sb.toString().getBytes());
	}

	/**
	 * @param os
	 * @throws IOException
	 */
	private void writeCtrlRestart(OutputStream os) throws IOException {
		StringBuilder sb = new StringBuilder();
		sb.append(
				"**restart**      switches to start from restart configurations")
				.append(NEWLINE);
		os.write(sb.toString().getBytes());
		writeRestartSolute(os);
		writeRestartSolvent(os);

		sb = new StringBuilder();
		sb.append(END_SECTION);
		os.write(sb.toString().getBytes());
	}

	/**
	 * @param os
	 * @throws IOException
	 */
	private void writeRestartSolute(OutputStream os) throws IOException {
		StringBuilder sb = new StringBuilder();
		sb.append("++solute++").append(NEWLINE);
		sb.append(".")
				.append(getGridBeanModel().get(
						MP2CGridBeanParameters.CTRL_RESTART_SOLUTE))
				.append(".");
		sb.append(" ");
		sb.append(".")
				.append(getGridBeanModel().get(
						MP2CGridBeanParameters.CTRL_RESTART_SOLUTE))
				.append(".").append(NEWLINE);

		os.write(sb.toString().getBytes());
	}

	/**
	 * @param os
	 * @throws IOException
	 */
	private void writeRestartSolvent(OutputStream os) throws IOException {
		StringBuilder sb = new StringBuilder();
		sb.append("++solvent++").append(NEWLINE);
		sb.append(".")
				.append(getGridBeanModel().get(
						MP2CGridBeanParameters.CTRL_RESTART_SOLVENT))
				.append(".");
		sb.append(" ");
		sb.append(".")
				.append(getGridBeanModel().get(
						MP2CGridBeanParameters.CTRL_RESTART_SOLVENT))
				.append(".").append(NEWLINE);

		os.write(sb.toString().getBytes());
	}

	/**
	 * @param _os
	 * @throws IOException
	 */
	private void writeCtrlRandomSeed(OutputStream _os) throws IOException {
		StringBuilder sb = new StringBuilder();
		sb.append("**random-seed**").append(NEWLINE);
		sb.append(
				getGridBeanModel().get(MP2CGridBeanParameters.CTRL_RANDOM_SEED))
				.append(NEWLINE)
				.append(NEWLINE);

		_os.write(sb.toString().getBytes());

	}

	/**
	 * @param _os
	 * @throws IOException
	 */
	private void writeCtrlLangevin(OutputStream _os) throws IOException {
		StringBuilder sb = new StringBuilder();
		sb.append("*Off*langevin**    perform langevin dynamics").append(
				NEWLINE);
		sb.append("++gamma++").append(NEWLINE);
		sb.append("1.0").append(NEWLINE);
		sb.append(END_SECTION);

		_os.write(sb.toString().getBytes());

	}

	/**
	 * @param os
	 * @throws IOException
	 */
	private void writeCtrlThermostat(OutputStream os) throws IOException {
		StringBuilder sb = new StringBuilder();

		sb.append(
				"*Off*thermostat** at present only Berendsen weak-coupling version")
				.append(NEWLINE);
		sb.append("++coupl++     coupling constant").append(NEWLINE);
		sb.append("1000").append(NEWLINE);
		sb.append(END_SECTION);

		os.write(sb.toString().getBytes());
	}

	/**
	 * @param os
	 * @throws IOException
	 */
	private void writeCtrlMaxScal(OutputStream os) throws IOException {
		StringBuilder sb = new StringBuilder();
		sb.append("++max-scal++     max. number of steps for strict scaling")
				.append(NEWLINE);
		sb.append("10000").append(NEWLINE);
		sb.append(END_SECTION);

		os.write(sb.toString().getBytes());
	}


}
