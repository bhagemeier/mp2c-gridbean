/*********************************************************************************
 * Copyright (c) 2013 Forschungszentrum Juelich GmbH 
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

import org.junit.BeforeClass;
import org.junit.Test;

import com.intel.gpe.gridbeans.plugins.TranslationException;
import com.intel.gpe.gridbeans.plugins.UnsupportedProtocolException;

/**
 * @author bjoernh
 * 
 *         14.02.2013 15:38:02
 * 
 */
public class IOTypeTranslatorTest {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * Test method for
	 * {@link eu.unicore.applications.mp2c.IOTypeTranslator#translateTo(java.lang.Object)}
	 * .
	 * 
	 * @throws UnsupportedProtocolException
	 * @throws TranslationException
	 */
	@Test
	public void testTranslateTo() throws TranslationException,
			UnsupportedProtocolException {
		final IOTypeTranslator ioTrslt = new IOTypeTranslator();
		for (int i = 1; i < 6; i++) {
			System.out.println(Integer.toString(i) + " translates to "
					+ ioTrslt.translateTo(Integer.toString(i)));
		}
	}

	/**
	 * Test method for
	 * {@link eu.unicore.applications.mp2c.IOTypeTranslator#translateFrom(java.lang.Object, java.lang.Object)}
	 * .
	 * 
	 * @throws TranslationException
	 */
	@Test
	public void testTranslateFrom() throws TranslationException {
		final IOTypeTranslator ioTrslt = new IOTypeTranslator();
		for (String userType : IOTypeTranslator.getUserRepresentations()) {
			System.out.println(userType + " maps to "
					+ ioTrslt.translateFrom(userType, null));
		}
	}

	/**
	 * Test method for
	 * {@link eu.unicore.applications.mp2c.IOTypeTranslator#getInternalRepresentations()}
	 * .
	 */
	@Test
	public void testGetInternalRepresentations() {
		String[] userReps = IOTypeTranslator.getInternalRepresentations();
		for (String string : userReps) {
			System.out.println(string);
		}
	}

}
