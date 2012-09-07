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

import java.util.List;

import javax.xml.namespace.QName;

import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.widgets.Spinner;

import com.intel.gpe.clients.api.Client;
import com.intel.gpe.gridbeans.plugins.DataSetException;
import com.intel.gpe.gridbeans.plugins.TranslationException;
import com.intel.gpe.gridbeans.plugins.UnsupportedProtocolException;
import com.intel.gpe.gridbeans.plugins.swt.controls.SWTDataControl;

/**
 * @author bjoernh
 *
 * 19.07.2012 15:29:19
 *
 */
public class SWTSpinBoxControl extends SWTDataControl implements
 ModifyListener {

	private final Spinner spinner;
	private String value;

	/**
	 * @param client
	 * @param _key
	 * @param _spinner
	 */
	public SWTSpinBoxControl(Client client, QName _key, Spinner _spinner) {
		super(client, _key, _spinner);
		this.spinner = _spinner;
		this.value = Integer.toString(spinner.getSelection());
		_spinner.addModifyListener(this);
		listenTo = true;
	}


	/**
	 * @see com.intel.gpe.gridbeans.plugins.IDataControl#setValue(java.lang.Object)
	 */
	@Override
	public void setValue(Object value) throws TranslationException,
			UnsupportedProtocolException, DataSetException {
		listenTo = false;
		this.value = (String) translateTo(value);
		if (!spinner.isDisposed()) {
			String text = this.value == null ? "0" : this.value;
			spinner.setSelection(Integer.parseInt(text));
		}
		listenTo = true;
	}

	/**
	 * @see com.intel.gpe.gridbeans.plugins.IDataControl#getValue()
	 */
	@Override
	public Object getValue() throws DataSetException {
		return value;
	}

	/**
	 * @see com.intel.gpe.gridbeans.plugins.IDataControl#setPossibleValues(java.util.List)
	 */
	@Override
	public void setPossibleValues(List values) throws TranslationException,
			DataSetException {
		// Do nothing

	}

	/**
	 * @see org.eclipse.swt.events.ModifyListener#modifyText(org.eclipse.swt.events.ModifyEvent)
	 */
	@Override
	public void modifyText(ModifyEvent arg0) {
		if (!listenTo)
			return;
		if (arg0.getSource() == spinner) {
			value = Integer.toString(spinner.getSelection());
		}
		fireValueChange();
	}

}
