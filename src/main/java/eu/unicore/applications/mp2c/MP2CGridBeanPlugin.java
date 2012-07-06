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

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import com.intel.gpe.clients.api.Client;
import com.intel.gpe.clients.api.async.IProgressListener;
import com.intel.gpe.gridbeans.parameters.InputFileParameterValue;
import com.intel.gpe.gridbeans.plugins.DataSetException;
import com.intel.gpe.gridbeans.plugins.swt.SWTGridBeanPlugin;
import com.intel.gpe.util.defaults.preferences.INode;

import eu.unicore.applications.mp2c.model.MP2CConfig;

/**
 * @author bjoernh
 * 
 *         23.03.2012 11:48:52
 * 
 */
public class MP2CGridBeanPlugin extends SWTGridBeanPlugin {

	/**
	 * @see com.intel.gpe.gridbeans.plugins.swt.SWTGridBeanPlugin#initialize(com.intel.gpe.clients.api.Client,
	 *      com.intel.gpe.util.defaults.preferences.INode)
	 */
	@Override
	public void initialize(Client client, INode node) {
		super.initialize(client, node);

		// Mp2c_1_0PackageImpl.init();
		// Mp2c_1_0Factory mp2cf = Mp2c_1_0Factory.eINSTANCE;
		// mp2c_1_0.MP2CConfig config = mp2cf.createMP2CConfig();
		// MP2CConfig config = new MP2CConfig();
		// Control control = new Control();
		// config.setControl(control);
		// IO io = new IO();
		// config.setIo(io);
		// Solute solute = new Solute();
		// config.setSolute(solute);
		// Solvent solvent = new Solvent();
		// config.setSolvent(solvent);
		// Parallel parallel = new Parallel(1);
		// config.setParallel(parallel);
		MP2CGridBeanParameterValue mp2cgbpv = (MP2CGridBeanParameterValue) getGridBeanModel()
				.get(
				MP2CGridBeanParameter.MP2C_QNAME);
		MP2CConfig config = mp2cgbpv.getConfig();

		addInputPanel(new GeneralSettingsGBPanel(client, "General",
				config.getControl()));
		addInputPanel(new SoluteSettingsGBPanel(client, "Solute",
				config.getSolute()));
		addInputPanel(new SolventSettingsGBPanel(client, "Solvent",
				config.getSolvent()));
		addInputPanel(new IOSettingsGBPanel(client, "I/O", config.getIo()));
		addInputPanel(new ParallelExecutionSettingsGBPanel(client,
				"Parallel Execution", config.getParallel()));
		// this is not part of the EMF model yet
		// addInputPanel(new ParallelExecutionSettingsGBPanel(client,
		// "Parallel execution", new Parallel(3)));

	}

	/**
	 * @see com.intel.gpe.gridbeans.plugins.swt.SWTGridBeanPlugin#saveDataToExternalSource(com.intel.gpe.clients.api.async.IProgressListener)
	 */
	@Override
	public void saveDataToExternalSource(IProgressListener progress)
			throws DataSetException {
		super.saveDataToExternalSource(progress);
		
		MP2CConfig config = ((MP2CGridBeanParameterValue) getGridBeanModel()
				.get(MP2CGridBeanParameter.MP2C_QNAME)).getConfig();

		// progress.beginTask("Writing MP2C configuration", 6);

		try {
			// progress.beginSubTask("Writing control file", 1);
			writeControlFile(
					config,
					new FileOutputStream(
					((InputFileParameterValue) getGridBeanModel().get(
							MP2CGridBeanParameters.CONTROL_FILE_QNAME))
							.getSource().getInternalString()));
			// progress.beginSubTask("Writing solvent file", 1);
			writeSolventFile(
					config,
					new FileOutputStream(
					((InputFileParameterValue) getGridBeanModel().get(
							MP2CGridBeanParameters.SOLVENT_FILE_QNAME))
							.getSource().getInternalString()));
			// progress.beginSubTask("Writing solute file", 1);
			writeSoluteFile(
					config,
					new FileOutputStream(
					((InputFileParameterValue) getGridBeanModel().get(
							MP2CGridBeanParameters.SOLUTE_FILE_QNAME))
							.getSource().getInternalString()));
			// progress.beginSubTask("Writing quench file", 1);
			writeQuenchFile(
					config,
					new FileOutputStream(
					((InputFileParameterValue) getGridBeanModel().get(
							MP2CGridBeanParameters.QUENCH_FILE_QNAME))
							.getSource().getInternalString()));
			// progress.beginSubTask("Writing io file", 1);
			writeIoFile(
					config,
					new FileOutputStream(
					((InputFileParameterValue) getGridBeanModel().get(
							MP2CGridBeanParameters.IO_FILE_QNAME))
							.getSource()
							.getInternalString()));
			// progress.beginSubTask("Writing parallel file", 1);
			writeParallelFile(
					config,
					new FileOutputStream(
					((InputFileParameterValue) getGridBeanModel().get(
							MP2CGridBeanParameters.PARALLEL_FILE_QNAME))
							.getSource().getInternalString()));

		} catch (FileNotFoundException e) {
			// TODO
			e.printStackTrace();
		} catch (IOException e) {
			// TODO
			e.printStackTrace();

		}
	}

	/**
	 * @param config
	 * @param fileOutputStream
	 * 
	 */
	private void writeParallelFile(MP2CConfig config,
			OutputStream fileOutputStream) {
		config.getParallel().write(fileOutputStream);

	}

	/**
	 * @param config
	 * @param fileOutputStream
	 * 
	 */
	private void writeIoFile(MP2CConfig config, OutputStream fileOutputStream) {
		config.getIo().write(fileOutputStream);
	}

	/**
	 * @param config
	 * @param fileOutputStream
	 * 
	 */
	private void writeQuenchFile(MP2CConfig config,
			OutputStream fileOutputStream) {
		config.getQuench().write(fileOutputStream);
	}

	/**
	 * @param config
	 * @param fileOutputStream
	 * 
	 */
	private void writeSolventFile(MP2CConfig config,
			OutputStream fileOutputStream) {
		config.getSolvent().write(fileOutputStream);
	}

	/**
	 * @param config
	 * @param fileOutputStream
	 * @throws IOException
	 * 
	 */
	private void writeSoluteFile(MP2CConfig config,
			OutputStream fileOutputStream)
			throws IOException {
		config.getSolute().write(fileOutputStream);
	}

	/**
	 * @param config
	 * @param fileOutputStream
	 * @throws IOException
	 * 
	 */
	private void writeControlFile(MP2CConfig config,
			FileOutputStream fileOutputStream)
			throws IOException {
		config.getControl().write(fileOutputStream);
	}


}
