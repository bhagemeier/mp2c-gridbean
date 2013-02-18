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

import mp2c_1_0.Solute;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;

import com.intel.gpe.clients.api.Client;
import com.intel.gpe.clients.api.async.IProgressListener;
import com.intel.gpe.gridbeans.plugins.DataSetException;

/**
 * @author bjoernh
 * 
 *         26.03.2012 15:11:20
 * 
 */
public class SoluteSettingsGBPanel extends MP2CSWTGridBeanPanel {

	private Solute solute;
	private SoluteSettings soluteSettings;

	/**
	 * @param client
	 * @param name
	 * @param solute2
	 */
	public SoluteSettingsGBPanel(Client client, String name, Solute solute2) {
		super(client, name);

		this.solute = solute2;
	}

	/**
	 * @see com.intel.gpe.gridbeans.plugins.swt.panels.ISWTGridBeanPanel#createControl(org.eclipse.swt.widgets.Composite)
	 */
	public void createControl(Composite parent) {
		soluteSettings = new SoluteSettings(parent, SWT.NONE, solute);
		setComponent(soluteSettings);

		linkCheckButton(MP2CGridBeanParameters.SOLUTE_RADIUS_SHIFTED_LJP,
				soluteSettings.getBtnRadiusShiftedLjp());
		linkCheckButton(
				MP2CGridBeanParameters.SOLUTE_RADIUS_SHIFTED_SHIFTED_FORCE_LJP,
				soluteSettings.getBtnRadiusShiftedLjShiftedForce());
		linkCheckButton(MP2CGridBeanParameters.SOLUTE_SHIFTED_FORCE_LJP,
				soluteSettings.getBtnLjShiftedForce());
		linkCheckButton(MP2CGridBeanParameters.SOLUTE_SHIFTED_LJP,
				soluteSettings.getBtnShiftedLjp());
		linkCheckButton(
				MP2CGridBeanParameters.SOLUTE_RADIUS_SHIFTED_LJP_SHIFTED,
				soluteSettings.getBtnRadiusShiftedLjShifted());
		linkCheckButton(MP2CGridBeanParameters.SOLUTE_USUAL_LJP,
				soluteSettings.getBtnUsualLjp());

	}

	/**
	 * @see com.intel.gpe.gridbeans.plugins.GenericGridBeanPanel#saveDataToExternalSource(com.intel.gpe.clients.api.async.IProgressListener)
	 */
	@Override
	public void saveDataToExternalSource(IProgressListener progress)
			throws DataSetException {
		// TODO Auto-generated method stub
		super.saveDataToExternalSource(progress);
	}

}
