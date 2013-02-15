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

import java.util.Arrays;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;

import com.intel.gpe.clients.api.Client;
import com.intel.gpe.gridbeans.plugins.DataSetException;
import com.intel.gpe.gridbeans.plugins.TranslationException;
import com.intel.gpe.gridbeans.plugins.translators.DoubleValueTranslator;
import com.intel.gpe.gridbeans.plugins.translators.StringValueTranslator;
import com.intel.gpe.gridbeans.plugins.validators.DoubleValueValidator;

/**
 * @author bjoernh
 * 
 *         23.03.2012 11:52:35
 * 
 */
public class GeneralSettingsGBPanel extends MP2CSWTGridBeanPanel {

	private GeneralSettings generalSettings;

	/**
	 * @param client
	 * @param name
	 */
	public GeneralSettingsGBPanel(Client client, String name) {
		super(client, name);
	}

	/**
	 * @see com.intel.gpe.gridbeans.plugins.swt.panels.ISWTGridBeanPanel#createControl(org.eclipse.swt.widgets.Composite)
	 */
	public void createControl(Composite parent) {
		try {
			generalSettings = new GeneralSettings(parent, SWT.NONE);
			setComponent(generalSettings);

			// Simulate Solute
			linkCheckButton(MP2CGridBeanParameters.CTRL_SIM_SOLUTE,
					generalSettings.getBtnSolute());

			// Timesteps
			linkSpinBox(MP2CGridBeanParameters.CTRL_TIMESTEPS,
					generalSettings.getNrTimeStepsSpinner());
			
			// Simulate solvent
			linkCheckButton(MP2CGridBeanParameters.CTRL_SIM_SOLVENT,
					generalSettings.getBtnSolvent());

			// Temperature
            linkTextField(MP2CGridBeanParameters.CTRL_TEMPERATURE,
					generalSettings.getTemperature());
            setValueTranslator(MP2CGridBeanParameters.CTRL_TEMPERATURE,
                    new DoubleValueTranslator());
            setValueValidator(MP2CGridBeanParameters.CTRL_TEMPERATURE,
                    new DoubleValueValidator());

			// External force
			linkCheckButton(MP2CGridBeanParameters.CTRL_EXTERNAL_FORCE,
					generalSettings.getBtnExternalForce());

			// Collision steps
			linkSpinBox(MP2CGridBeanParameters.CTRL_COLL_STEPS_INTERVAL,
					generalSettings.getCollisionSteps());

			// BOX RATIO X
			linkTextField(MP2CGridBeanParameters.CTRL_BOX_RATIO_X,
					generalSettings.getBrX());
			setValueTranslator(MP2CGridBeanParameters.CTRL_BOX_RATIO_X,
					new DoubleValueTranslator());
			setValueValidator(MP2CGridBeanParameters.CTRL_BOX_RATIO_X,
					new DoubleValueValidator());

			// BOX RATIO Y
			linkTextField(MP2CGridBeanParameters.CTRL_BOX_RATIO_Y,
					generalSettings.getBrY());
			setValueTranslator(MP2CGridBeanParameters.CTRL_BOX_RATIO_Y,
					new DoubleValueTranslator());
			setValueValidator(MP2CGridBeanParameters.CTRL_BOX_RATIO_Y,
					new DoubleValueValidator());

			// BOX RATIO Z
			linkTextField(MP2CGridBeanParameters.CTRL_BOX_RATIO_Z,
					generalSettings.getBrZ());
			setValueTranslator(MP2CGridBeanParameters.CTRL_BOX_RATIO_Z,
					new DoubleValueTranslator());
			setValueValidator(MP2CGridBeanParameters.CTRL_BOX_RATIO_Z,
					new DoubleValueValidator());

			// Boundary Condidtion X
			linkComboBox(MP2CGridBeanParameters.CTRL_BC_X,
					generalSettings.getBcX());
			setValueTranslator(MP2CGridBeanParameters.CTRL_BC_X,
					new StringValueTranslator());

			// Boundary Condidtion X
			linkComboBox(MP2CGridBeanParameters.CTRL_BC_Y,
					generalSettings.getBcY());
			setValueTranslator(MP2CGridBeanParameters.CTRL_BC_Y,
					new StringValueTranslator());

			// Boundary Condidtion X
			linkComboBox(MP2CGridBeanParameters.CTRL_BC_Z,
					generalSettings.getBcZ());
			setValueTranslator(MP2CGridBeanParameters.CTRL_BC_Z,
					new StringValueTranslator());

			try {
				setPossibleValues(MP2CGridBeanParameters.CTRL_BC_X,
						Arrays.asList(generalSettings.getBcX().getItems()));
				setPossibleValues(MP2CGridBeanParameters.CTRL_BC_Y,
						Arrays.asList(generalSettings.getBcY().getItems()));
				setPossibleValues(MP2CGridBeanParameters.CTRL_BC_Z,
						Arrays.asList(generalSettings.getBcZ().getItems()));
			} catch (TranslationException e) {
				// TODO react appropriately
				e.printStackTrace();
			}


			// EXT FORCE X
			linkTextField(MP2CGridBeanParameters.CTRL_EXTERNAL_FORCE_X,
					generalSettings.getExtForceX());
			setValueTranslator(MP2CGridBeanParameters.CTRL_EXTERNAL_FORCE_X,
					new DoubleValueTranslator());
			setValueValidator(MP2CGridBeanParameters.CTRL_EXTERNAL_FORCE_X,
					new DoubleValueValidator());

			// EXT FORCE Y
			linkTextField(MP2CGridBeanParameters.CTRL_EXTERNAL_FORCE_Y,
					generalSettings.getExtForceY());
			setValueTranslator(MP2CGridBeanParameters.CTRL_EXTERNAL_FORCE_Y,
					new DoubleValueTranslator());
			setValueValidator(MP2CGridBeanParameters.CTRL_EXTERNAL_FORCE_Y,
					new DoubleValueValidator());

			// EXT FORCE Z
			linkTextField(MP2CGridBeanParameters.CTRL_EXTERNAL_FORCE_Z,
					generalSettings.getExtForceZ());
			setValueTranslator(MP2CGridBeanParameters.CTRL_EXTERNAL_FORCE_Z,
					new DoubleValueTranslator());
			setValueValidator(MP2CGridBeanParameters.CTRL_EXTERNAL_FORCE_Z,
					new DoubleValueValidator());

			// SHEAR RATE X
			linkTextField(MP2CGridBeanParameters.CTRL_SHEAR_RATE_X,
					generalSettings.getShearRateX());
			setValueTranslator(MP2CGridBeanParameters.CTRL_SHEAR_RATE_X,
					new DoubleValueTranslator());
			setValueValidator(MP2CGridBeanParameters.CTRL_SHEAR_RATE_X,
					new DoubleValueValidator());

			// SHEAR RATE Y
			linkTextField(MP2CGridBeanParameters.CTRL_SHEAR_RATE_Y,
					generalSettings.getShearRateY());
			setValueTranslator(MP2CGridBeanParameters.CTRL_SHEAR_RATE_Y,
					new DoubleValueTranslator());
			setValueValidator(MP2CGridBeanParameters.CTRL_SHEAR_RATE_Y,
					new DoubleValueValidator());

			// SHEAR RATE Z
			linkTextField(MP2CGridBeanParameters.CTRL_SHEAR_RATE_Z,
					generalSettings.getShearRateZ());
			setValueTranslator(MP2CGridBeanParameters.CTRL_SHEAR_RATE_Z,
					new DoubleValueTranslator());
			setValueValidator(MP2CGridBeanParameters.CTRL_SHEAR_RATE_Z,
					new DoubleValueValidator());

			// Restart solute
			linkCheckButton(MP2CGridBeanParameters.CTRL_RESTART_SOLUTE,
					generalSettings.getBtnRestartSolute());

			// Restart solvent
			linkCheckButton(MP2CGridBeanParameters.CTRL_RESTART_SOLVENT,
					generalSettings.getBtnRestartSolvent());

			// Random seed
			linkSpinBox(MP2CGridBeanParameters.CTRL_RANDOM_SEED,
					generalSettings.getSpinnerRandomSeed());

		} catch (DataSetException e) {
			throw new RuntimeException(e);
		}
	}

}
