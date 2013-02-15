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
import java.io.IOException;

import javax.xml.namespace.QName;

import com.intel.gpe.clients.api.Client;
import com.intel.gpe.clients.api.async.IProgressListener;
import com.intel.gpe.gridbeans.parameters.FileParameterValue;
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
		// addInputPanel(new TextEditorGBPanel(client, "Solute"));
		Solute solute = new Solute();
		addInputPanel(new SoluteSettingsGBPanel(client, "Solute", solute));

		String projectTmpDir = client.getFileFactory().getTemporaryDirName();
		File prTmp = new File(projectTmpDir);

		setInputFileIfUnset(prTmp, MP2CGridBeanParameters.SOLUTE_FILE_QNAME,
				MP2CGridBeanParameters.SOLUTE_FILE_NAME);
	}

	/**
	 * @param _prTmp
	 * @param controlFileName
	 * @param controlFileQname
	 */
	private void setInputFileIfUnset(File _prTmp, QName _fileQname,
			String _fileName) {
		if ((((FileParameterValue) getGridBeanModel().get(_fileQname))
				.getSource().getInternalString() == null)
				|| (((FileParameterValue) getGridBeanModel().get(_fileQname))
						.getSource().getInternalString().isEmpty())) {
			final InputFileParameterValue controlFileIn = new InputFileParameterValue(
					new File(_prTmp, _fileName).getAbsolutePath());
			controlFileIn.getTarget().setRelativePath(_fileName);
			getGridBeanModel().set(_fileQname, controlFileIn);
		}
	}

	/**
	 * @see com.intel.gpe.gridbeans.plugins.swt.SWTGridBeanPlugin#saveDataToExternalSource(com.intel.gpe.clients.api.async.IProgressListener)
	 */
	@Override
	public void saveDataToExternalSource(IProgressListener progress)
			throws DataSetException {
		super.saveDataToExternalSource(progress);
		try {
			saveSoluteSettings();
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
	private void saveSoluteSettings() throws IOException {
		// TODO Auto-generated method stub

	}

}
