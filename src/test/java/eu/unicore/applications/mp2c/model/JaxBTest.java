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
package eu.unicore.applications.mp2c.model;

import java.io.File;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.junit.Test;

import eu.unicore.applications.mp2c.MP2CGridBeanParameter;
import eu.unicore.applications.mp2c.MP2CGridBeanParameterValue;

/**
 * @author bjoernh
 *
 * 29.06.2012 12:25:14
 *
 */
public class JaxBTest {
	@Test
	public void testJaxB() throws JAXBException {
		JAXBContext ctx = JAXBContext
				.newInstance("eu.unicore.applications.mp2c.model");

		MP2CConfig config = new MP2CConfig();
		
		Marshaller m = ctx.createMarshaller();
		Unmarshaller um = ctx.createUnmarshaller();

		File f = new File("/tmp/marshalled_config.jaxb");

		m.marshal(config, f);

		MP2CConfig newConfig = (MP2CConfig) um.unmarshal(f);

		m.marshal(newConfig, new File("/tmp/marshalled_config2.jaxb"));
	}

	@Test
	public void testJaxBGPV() throws JAXBException, IOException {
		JAXBContext ctx = JAXBContext
				.newInstance("eu.unicore.applications.mp2c");

		MP2CGridBeanParameterValue gbpv = new MP2CGridBeanParameterValue();
		MP2CConfig c = new MP2CConfig();
		gbpv.setConfig(c);

		ctx.createMarshaller().marshal(gbpv,
				File.createTempFile("jaxbtest", null));
	}

	@Test
	public void testJaxBGBP() throws JAXBException, IOException {
		MP2CGridBeanParameter gbp = new MP2CGridBeanParameter();
		
		JAXBContext ctx = JAXBContext
				.newInstance("eu.unicore.applications.mp2c");
		ctx.createMarshaller().marshal(gbp,
				File.createTempFile("jabx_gbp.xml", null));
	}
}
