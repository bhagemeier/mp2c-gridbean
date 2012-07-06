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

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author bjoernh
 * 
 *         30.03.2012 15:00:05
 * 
 * 
 */
@XmlRootElement
public class MP2CConfig implements Cloneable {
	private Solvent solvent;
	private Solute solute;

	private Quench quench;

	private IO io;

	private Control control;

	private Parallel parallel;

	/**
	 * 
	 */
	public MP2CConfig() {
		solvent = new Solvent();
		solute = new Solute();
		quench = new Quench();
		io = new IO();
		control = new Control();
		parallel = new Parallel(3);
	}

	public Control getControl() {
		return control;
	}

	public IO getIo() {
		return io;
	}

	public Quench getQuench() {
		return quench;
	}

	public Solute getSolute() {
		return solute;
	}
	public Solvent getSolvent() {
		return solvent;
	}
	public void setControl(Control control) {
		this.control = control;
	}
	public void setIo(IO io) {
		this.io = io;
	}
	public void setQuench(Quench quench) {
		this.quench = quench;
	}

	public void setSolute(Solute solute) {
		this.solute = solute;
	}

	public void setSolvent(Solvent solvent) {
		this.solvent = solvent;
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(solvent.toString());
		sb.append(System.getProperty("line.separator"));
		sb.append(solute.toString());
		sb.append(System.getProperty("line.separator"));
		sb.append(quench.toString());
		sb.append(System.getProperty("line.separator"));
		sb.append(io.toString());
		sb.append(System.getProperty("line.separator"));
		sb.append(control.toString());
		return sb.toString();
	}

	/**
	 * @return the parallel
	 */
	public Parallel getParallel() {
		return parallel;
	}

	/**
	 * @param parallel
	 */
	public void setParallel(Parallel parallel) {
		// TODO Auto-generated method stub

	}

	/**
	 * @see java.lang.Object#clone()
	 */
	@Override
	public Object clone() throws CloneNotSupportedException {
		MP2CConfig clone = (MP2CConfig) super.clone();
		clone.control = (Control) control.clone();
		clone.io = (IO) io.clone();
		clone.parallel = (Parallel) parallel.clone();
		clone.quench = (Quench) quench.clone();
		clone.solute = (Solute) solute.clone();
		clone.solvent = (Solvent) solvent.clone();

		return clone;
	}
}
