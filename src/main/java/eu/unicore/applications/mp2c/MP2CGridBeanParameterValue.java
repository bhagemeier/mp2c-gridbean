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

import javax.xml.bind.annotation.XmlRootElement;

import com.intel.gpe.clients.api.apps.ParameterMetaData;
import com.intel.gpe.gridbeans.parameters.IGridBeanParameterValue;

import eu.unicore.applications.mp2c.model.MP2CConfig;

/**
 * @author bjoernh
 *
 * 29.06.2012 08:07:48
 *
 */
@XmlRootElement
public class MP2CGridBeanParameterValue implements IGridBeanParameterValue {

	private MP2CConfig config;

	/**
	 * 
	 */
	public MP2CGridBeanParameterValue() {
		this.config = new MP2CConfig();
	}

	MP2CGridBeanParameterValue(MP2CConfig _config) {
		this.config = _config;
	}

	/**
	 * @see com.intel.gpe.gridbeans.parameters.IGridBeanParameterValue#getDisplayedString()
	 */
	@Override
	public String getDisplayedString() {
		return "MP2C Configuration";
	}

	/**
	 * @see com.intel.gpe.gridbeans.parameters.IGridBeanParameterValue#isInputParameter()
	 */
	@Override
	public boolean isInputParameter() {
		return true;
	}

	/**
	 * @see com.intel.gpe.gridbeans.parameters.IGridBeanParameterValue#resetProcessedValues()
	 */
	@Override
	public void resetProcessedValues() {
		// TODO Auto-generated method stub

	}

	/**
	 * @see com.intel.gpe.gridbeans.parameters.IGridBeanParameterValue#getMetaData()
	 */
	@Override
	public ParameterMetaData<MP2CGridBeanParameterValue> getMetaData() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @see java.lang.Object#clone()
	 */
	@Override
	public Object clone() throws CloneNotSupportedException {
		MP2CGridBeanParameterValue clone = new MP2CGridBeanParameterValue(
				(MP2CConfig) config.clone());
		return clone;
	}

	/**
	 * @return
	 */
	public MP2CConfig getConfig() {
		return config;
	}

	/**
	 * @param config
	 *            the config to set
	 */
	public void setConfig(MP2CConfig config) {
		this.config = config;
	}

}
