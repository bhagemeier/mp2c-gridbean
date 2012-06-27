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

import com.intel.gpe.gridbeans.parameters.GridBeanParameter;
import com.intel.gpe.gridbeans.parameters.GridBeanParameterType;
import com.intel.gpe.gridbeans.parameters.IGridBeanParameter;

import eu.unicore.applications.mp2c.model.MP2CConfig;

/**
 * @author bjoernh
 *
 * 23.03.2012 11:22:39
 *
 */
public class MP2CGridBeanParameter extends GridBeanParameter implements
		IGridBeanParameter {

	public static final QName MP2C_QNAME = new QName(
			"http://www.unicore.eu/applications/mp2c",
			"GridBeanModel"); 
	MP2CConfig config = new MP2CConfig();

	/**
	 * @see com.intel.gpe.gridbeans.parameters.IGridBeanParameter#getName()
	 */
	public QName getName() {
		return MP2C_QNAME;
	}

	/**
	 * @see com.intel.gpe.gridbeans.parameters.IGridBeanParameter#getDisplayedName()
	 */
	public String getDisplayedName() {
		return "MP2C GridBeanModel";
	}

	/**
	 * @see com.intel.gpe.gridbeans.parameters.IGridBeanParameter#getType()
	 */
	public GridBeanParameterType getType() {
		return new GridBeanParameterType("MP2CGridBeanModel");
	}

	/**
	 * @see com.intel.gpe.gridbeans.parameters.IGridBeanParameter#isInputParameter()
	 */
	public boolean isInputParameter() {
		return true;
	}

	/**
	 * @return the config
	 */
	public MP2CConfig getConfig() {
		return config;
	}

}
