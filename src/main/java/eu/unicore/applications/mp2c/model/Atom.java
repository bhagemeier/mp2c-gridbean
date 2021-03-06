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

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * @author bjoernh
 * 
 *         30.03.2012 14:58:07
 * 
 */
public class Atom implements Cloneable {
	private String identifier;
	private String symbol;
	private int fromRange;
	private int toRange;
	private double mass;
	private double charge;

	private final PropertyChangeSupport propertyChangeSupport;

	public void addPropertyChangeListener(String _propertyName,
			PropertyChangeListener _listener) {
		propertyChangeSupport.addPropertyChangeListener(_propertyName,
				_listener);
	}

	public void addPropertyChangeListener(PropertyChangeListener _listener) {
		propertyChangeSupport.addPropertyChangeListener(_listener);
	}

	public void removePropertyChangeListener(String _propertyName,
			PropertyChangeListener _listener) {
		propertyChangeSupport.removePropertyChangeListener(_propertyName,
				_listener);
	}

	public void removePropertyChangeListener(PropertyChangeListener _listener) {
		propertyChangeSupport.removePropertyChangeListener(_listener);
	}

	/**
     * 
     */
	public Atom() {
		this("Oxygen", "O", 0, 0, 0.0, 0.0);
	}

	/**
	 * @param string
	 * @param string2
	 * @param i
	 * @param j
	 * @param d
	 * @param e
	 */
	public Atom(String _identifier, String _symbol, int _fromRange,
			int _toRange, double _mass, double _charge) {
		propertyChangeSupport = new PropertyChangeSupport(this);
		this.identifier = _identifier;
		this.symbol = _symbol;
		this.fromRange = _fromRange;
		this.toRange = _toRange;
		this.mass = _mass;
		this.charge = _charge;
	}

	/**
	 * @return the identifier
	 */
	public String getIdentifier() {
		return identifier;
	}

	/**
	 * @param identifier
	 *            the identifier to set
	 */
	public void setIdentifier(String identifier) {
		propertyChangeSupport.firePropertyChange("identifier", this.identifier,
				identifier);
		this.identifier = identifier;
	}

	/**
	 * @return the symbol
	 */
	public String getSymbol() {
		return symbol;
	}

	/**
	 * @param symbol
	 *            the symbol to set
	 */
	public void setSymbol(String symbol) {
		propertyChangeSupport.firePropertyChange("symbol", this.symbol, symbol);
		this.symbol = symbol;
	}

	/**
	 * @return the fromRange
	 */
	public int getFromRange() {
		return fromRange;
	}

	/**
	 * @param fromRange
	 *            the fromRange to set
	 */
	public void setFromRange(int fromRange) {
		propertyChangeSupport.firePropertyChange("fromRange", this.fromRange,
				this.fromRange = fromRange);
	}

	/**
	 * @return the toRange
	 */
	public int getToRange() {
		return toRange;
	}

	/**
	 * @param toRange
	 *            the toRange to set
	 */
	public void setToRange(int toRange) {
		propertyChangeSupport.firePropertyChange("toRange", this.toRange,
				this.toRange = toRange);
	}

	/**
	 * @return the mass
	 */
	public double getMass() {
		return mass;
	}

	/**
	 * @param mass
	 *            the mass to set
	 */
	public void setMass(double mass) {
		propertyChangeSupport.firePropertyChange("mass", this.mass,
				this.mass = mass);
	}

	/**
	 * @return the charge
	 */
	public double getCharge() {
		return charge;
	}

	/**
	 * @param charge
	 *            the charge to set
	 */
	public void setCharge(double charge) {
		propertyChangeSupport.firePropertyChange("charge", this.charge,
				this.charge = charge);
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		final String nl = System.getProperty("line.separator");
		sb.append("Atom").append(nl).append("Identifier: " + identifier)
				.append(nl).append("Charge: " + charge).append(nl);
		sb.append("From " + fromRange + " to " + toRange).append(nl);
		sb.append("Mass: " + mass).append(nl);
		sb.append("Symbol: " + symbol);
		return sb.toString();
	}

	/**
	 * @see java.lang.Object#clone()
	 */
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
