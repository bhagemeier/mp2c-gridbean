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

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Spinner;

import com.intel.gpe.clients.api.Client;
import com.intel.gpe.gridbeans.plugins.DataSetException;
import com.intel.gpe.gridbeans.plugins.IDataControl;
import com.intel.gpe.gridbeans.plugins.swt.panels.SWTGridBeanPanel;
import com.intel.gpe.gridbeans.plugins.translators.BooleanToStringValueTranslator;
import com.intel.gpe.gridbeans.plugins.translators.IntegerValueTranslator;
import com.intel.gpe.util.defaults.preferences.INode;

/**
 * @author bjoernh
 *
 * 23.07.2012 15:40:28
 *
 */
public abstract class MP2CSWTGridBeanPanel extends SWTGridBeanPanel {

	/**
	 * @param client
	 * @param name
	 */
	public MP2CSWTGridBeanPanel(Client client, String name) {
		super(client, name);
	}

	/**
	 * @param client
	 * @param name
	 * @param node
	 */
	public MP2CSWTGridBeanPanel(Client client, String name, INode node) {
		super(client, name, node);
	}

	/**
	 * And set appropriate IntegarValueTranslator
	 * 
	 * @param _key
	 * @param _spinner
	 * @throws DataSetException
	 */
	protected void linkSpinBox(QName _key, Spinner _spinner)
			throws DataSetException {
		IDataControl control = new SWTSpinBoxControl(getClient(), _key,
				_spinner);
		linkDataControl(_key, control);

		setValueTranslator(_key, new IntegerValueTranslator());
	}

	/**
	 * And set the value translator automatically
	 * 
	 * @see com.intel.gpe.gridbeans.plugins.swt.panels.SWTGridBeanPanel#linkCheckButton(javax.xml.namespace.QName,
	 *      org.eclipse.swt.widgets.Button)
	 */
	@Override
	public void linkCheckButton(QName key, Button checkBox) {
	
		super.linkCheckButton(key, checkBox);
		try {
			setValueTranslator(key, new BooleanToStringValueTranslator());
		} catch (DataSetException e) {
			throw new RuntimeException(e);
		}
	}

}