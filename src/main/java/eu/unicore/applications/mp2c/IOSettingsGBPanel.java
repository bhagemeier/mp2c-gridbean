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


import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;

import com.intel.gpe.clients.api.Client;
import com.intel.gpe.gridbeans.plugins.DataSetException;
import com.intel.gpe.gridbeans.plugins.translators.StringValueTranslator;

/**
 * @author bjoernh
 *
 * 26.03.2012 15:11:20
 *
 */
public class IOSettingsGBPanel extends MP2CSWTGridBeanPanel {


	/**
	 * @param client
	 * @param name
	 * @param io2
	 */
	public IOSettingsGBPanel(Client client, String name) {
		super(client, name);

	}

	/**
	 * @see com.intel.gpe.gridbeans.plugins.swt.panels.ISWTGridBeanPanel#createControl(org.eclipse.swt.widgets.Composite)
	 */
	public void createControl(Composite parent) {
		IOSettings io = new IOSettings(parent, SWT.NONE);
		setComponent(io);

		try {
		// standard io
		// std out
		linkCheckButton(MP2CGridBeanParameters.IO_STANDARD_OUT,
				io.getBtnGeneral());

		linkSpinBox(MP2CGridBeanParameters.IO_STANDARD_OUT_STEPS,
				io.getSpnGeneralSteps());


		// solute
		linkCheckButton(MP2CGridBeanParameters.IO_STANDARD_SOLUTES,
				io.getBtnSolute());

		linkSpinBox(MP2CGridBeanParameters.IO_STANDARD_SOLUTES_STEPS,
				io.getSpnSoluteSteps());

		// solvent
		linkCheckButton(MP2CGridBeanParameters.IO_STANDARD_SOLVENT,
				io.getBtnSolvent());

		linkSpinBox(MP2CGridBeanParameters.IO_STANDARD_SOLVENT_STEPS,
				io.getSpnSolventSteps());


		// restart information
		// solute
		linkCheckButton(MP2CGridBeanParameters.IO_RESTART_SOLUTE,
				io.getBtnRestartSolute());
		linkComboBox(MP2CGridBeanParameters.IO_RESTART_SOLUTES_TYPE,
				io.getCmbRestartSoluteType());
			setValueTranslator(MP2CGridBeanParameters.IO_RESTART_SOLUTES_TYPE,
					new StringValueTranslator());
		linkSpinBox(MP2CGridBeanParameters.IO_RESTART_SOLUTE_STEPS,
				io.getSpnRestartSoluteSteps());

		// solvent
		linkCheckButton(MP2CGridBeanParameters.IO_RESTART_SOLVENT,
				io.getBtnRestartSolute());
		linkComboBox(MP2CGridBeanParameters.IO_RESTART_SOLVENT_TYPE,
				io.getCmbRestartSoluteType());
			setValueTranslator(MP2CGridBeanParameters.IO_RESTART_SOLVENT_TYPE,
					new StringValueTranslator());

		linkSpinBox(MP2CGridBeanParameters.IO_RESTART_SOLVENT_STEPS,
				io.getSpnRestartSoluteSteps());

		// history
		// solute
		linkCheckButton(MP2CGridBeanParameters.IO_HISTORY_SOLUTE,
				io.getBtnSoluteHistory());
		linkComboBox(MP2CGridBeanParameters.IO_HISTORY_SOLUTE_TYPE,
				io.getCmbSoluteHistoryType());
			setValueTranslator(MP2CGridBeanParameters.IO_HISTORY_SOLUTE_TYPE,
					new StringValueTranslator());

		linkSpinBox(MP2CGridBeanParameters.IO_HISTORY_SOLUTE_STEPS,
				io.getSpnSoluteHistorySteps());

		// solvent
		linkCheckButton(MP2CGridBeanParameters.IO_HISTORY_SOLVENT,
				io.getBtnSolventHistory());
		linkComboBox(MP2CGridBeanParameters.IO_HISTORY_SOLVENT_TYPE,
				io.getCmbSolventHistoryType());
			setValueTranslator(MP2CGridBeanParameters.IO_HISTORY_SOLVENT_TYPE,
					new StringValueTranslator());

		linkSpinBox(MP2CGridBeanParameters.IO_HISTORY_SOLVENT_STEPS,
				io.getSpnSolventHistorySteps());

		// XYZ
		// general
		linkCheckButton(MP2CGridBeanParameters.IO_XYZ_SYSTEM,
				io.getBtnGeneral());
		linkSpinBox(MP2CGridBeanParameters.IO_XYZ_SYSTEM_STEPS,
				io.getSpnGeneralXYZSteps());

		// solute
		linkCheckButton(MP2CGridBeanParameters.IO_XYZ_SOLUTE,
				io.getBtnSoluteXYZ());
		linkComboBox(MP2CGridBeanParameters.IO_XYZ_SOLUTE_TYPE,
				io.getCmbSoluteXYZType());
			setValueTranslator(MP2CGridBeanParameters.IO_XYZ_SOLUTE_TYPE,
					new StringValueTranslator());

		linkSpinBox(MP2CGridBeanParameters.IO_XYZ_SOLUTE_STEPS,
				io.getSpnSoluteXYZSteps());

		// solvent
		linkCheckButton(MP2CGridBeanParameters.IO_XYZ_SOLVENT,
				io.getBtnSolventXYZ());
		linkComboBox(MP2CGridBeanParameters.IO_XYZ_SOLVENT_TYPE,
				io.getCmbSolventXYZType());
			setValueTranslator(MP2CGridBeanParameters.IO_XYZ_SOLVENT_TYPE,
					new StringValueTranslator());

		linkSpinBox(MP2CGridBeanParameters.IO_XYZ_SOLVENT_STEPS,
				io.getSpnSolventXYZSteps());

		// user specific output
		linkCheckButton(MP2CGridBeanParameters.IO_USER_OUTPUT,
				io.getBtnEndtoendDistances());
		linkSpinBox(MP2CGridBeanParameters.IO_USER_OUTPUT_STEPS,
				io.getSpnUserOutputSteps());

		} catch (DataSetException e) {
			// TODO Deal with it.
			e.printStackTrace();
		}

	}

}
