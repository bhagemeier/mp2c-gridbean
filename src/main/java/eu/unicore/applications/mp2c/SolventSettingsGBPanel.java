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
import com.intel.gpe.gridbeans.plugins.translators.DoubleValueTranslator;

/**
 * @author bjoernh
 * 
 *         26.03.2012 15:11:20
 * 
 */
public class SolventSettingsGBPanel extends MP2CSWTGridBeanPanel {

	private SolventSettings solventSettings;

	/**
	 * @param client
	 * @param name
	 * @param solvent2
	 */
	public SolventSettingsGBPanel(Client client, String name) {
		super(client, name);

	}

	/**
	 * @see com.intel.gpe.gridbeans.plugins.swt.panels.ISWTGridBeanPanel#createControl(org.eclipse.swt.widgets.Composite)
	 */
	public void createControl(Composite parent) {
		solventSettings = new SolventSettings(parent, SWT.NONE);
		setComponent(solventSettings);

		try {
			linkSpinBox(MP2CGridBeanParameters.SOLVENT_PPC,
					solventSettings.getSpnParticlesPerCell());

			linkSpinBox(MP2CGridBeanParameters.SOLVENT_PARTICLES,
					solventSettings.getSpnNrParticles());

			linkTextField(MP2CGridBeanParameters.SOLVENT_MASS,
					solventSettings.getTxtPartmass());
			setValueTranslator(MP2CGridBeanParameters.SOLVENT_MASS,
					new DoubleValueTranslator());

			linkTextField(MP2CGridBeanParameters.SOLVENT_LAMBDA,
					solventSettings.getTxtFreepath());
			setValueTranslator(MP2CGridBeanParameters.SOLVENT_LAMBDA,
					new DoubleValueTranslator());

			linkSpinBox(MP2CGridBeanParameters.SOLVENT_ALPHA,
					solventSettings.getRotAngle());

		} catch (DataSetException e) {
			throw new RuntimeException(e);
		}
	}

}
