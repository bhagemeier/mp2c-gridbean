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

import mp2c_1_0.Control;
import mp2c_1_0.Mp2c_1_0Factory;
import mp2c_1_0.impl.Mp2c_1_0PackageImpl;

import com.intel.gpe.clients.api.Client;
import com.intel.gpe.gridbeans.plugins.swt.SWTGridBeanPlugin;
import com.intel.gpe.util.defaults.preferences.INode;

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

		Mp2c_1_0PackageImpl.init();
		Mp2c_1_0Factory mp2cf = Mp2c_1_0Factory.eINSTANCE;
		mp2c_1_0.MP2CConfig config = mp2cf.createMP2CConfig();
		Control control = mp2cf.createControl();
		config.setControl(control);
		mp2c_1_0.IO io = mp2cf.createIO();
		config.setIo(io);
		mp2c_1_0.Solute solute = mp2cf.createSolute();
		config.setSolute(solute);
		mp2c_1_0.Solvent solvent = mp2cf.createSolvent();
		config.setSolvent(solvent);


		addInputPanel(new GeneralSettingsGBPanel(client, "General", control));
		addInputPanel(new SoluteSettingsGBPanel(client, "Solute", solute));
		addInputPanel(new SolventSettingsGBPanel(client, "Solvent", solvent));
		addInputPanel(new IOSettingsGBPanel(client, "I/O", io));
		// this is not part of the EMF model yet
		// addInputPanel(new ParallelExecutionSettingsGBPanel(client,
		// "Parallel execution", new Parallel(3)));

	}

}
