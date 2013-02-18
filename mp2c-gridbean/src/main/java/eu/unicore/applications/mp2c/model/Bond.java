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
 *         30.03.2012 14:58:15
 * 
 */
public class Bond implements Cloneable {
    private String type;
    private int number;
    private int fromRange;
    private int toRange;
    private double k;
    private double r;

    private final PropertyChangeSupport pcs;

    public void addPropertyChangeListener(String _property,
            PropertyChangeListener _listener) {
        this.pcs.addPropertyChangeListener(_property, _listener);
    }

    public void removePropertyChangeListener(String _property,
            PropertyChangeListener _listener) {
        this.pcs.removePropertyChangeListener(_property, _listener);
    }

    /**
         * 
         */
    public Bond() {
        this("", 0, 0, 0, 0.0, 0.0);
    }

    /**
     * @param string
     * @param i
     * @param j
     * @param l
     * @param d
     * @param e
     */
    public Bond(String type, int number, int fromRange, int toRange, double k,
            double r) {
        this.pcs = new PropertyChangeSupport(this);
        this.type = type;
        this.number = number;
        this.fromRange = fromRange;
        this.toRange = toRange;
        this.k = k;
        this.r = r;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type
     *            the type to set
     */
    public void setType(String type) {
        pcs.firePropertyChange("type", this.type, type);
        this.type = type;
    }

    /**
     * @return the number
     */
    public int getNumber() {
        return number;
    }

    /**
     * @param number
     *            the number to set
     */
    public void setNumber(int number) {
        pcs.firePropertyChange("number", this.number, this.number = number);
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
        pcs.firePropertyChange("fromRange", this.fromRange,
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
        pcs.firePropertyChange("toRange", this.toRange, this.toRange = toRange);
    }

    /**
     * @return the k
     */
    public double getK() {
        return k;
    }

    /**
     * @param k
     *            the k to set
     */
    public void setK(double k) {
        pcs.firePropertyChange("k", this.k, this.k = k);
    }

    /**
     * @return the r
     */
    public double getR() {
        return r;
    }

    /**
     * @param r
     *            the r to set
     */
    public void setR(double r) {
        pcs.firePropertyChange("r", this.r, this.r = r);
    }

    /**
     * @see java.lang.Object#clone()
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
