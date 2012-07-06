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

/**
 * This file contains constants and other information shared by several of the
 * classes of this GridBean.
 * 
 * @author bjoernh
 * 
 *         29.06.2012 09:42:05
 * 
 */
public class MP2CGridBeanParameters {

	static final QName CONTROL_FILE_QNAME = new QName(
	"http://www.unicore.eu/applications/mp2c", "controlFile");
	static final String CONTROL_FILE_NAME = "mp2c_ctrl.inp";
	static final QName SOLUTE_FILE_QNAME = new QName(
	"http://www.unicore.eu/applications/mp2c", "soluteFile");
	static final String SOLUTE_FILE_NAME = "mp2c_slt.inp";
	static final QName SOLVENT_FILE_QNAME = new QName(
	"http://www.unicore.eu/applications/mp2c", "solventFile");
	static final String SOLVENT_FILE_NAME = "mp2c_slv.inp";
	static final QName QUENCH_FILE_QNAME = new QName(
	"http://www.unicore.eu/applications/mp2c", "quenchFile");
	static final String QUENCH_FILE_NAME = "mp2c_quench.inp";
	static final QName IO_FILE_QNAME = new QName(
	"http://www.unicore.eu/applications/mp2c", "ioFile");
	static final String IO_FILE_NAME = "mp2c_io.inp";
	static final QName PARALLEL_FILE_QNAME = new QName(
	"http://www.unicore.eu/applications/mp2c", "quenchFile");
	static final String PARALLEL_FILE_NAME = "mp2c_par.inp";

}
