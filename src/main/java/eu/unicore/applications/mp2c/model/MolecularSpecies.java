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

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;



/**
 * @author bjoernh
 *
 * 30.03.2012 14:58:57
 *
 */
public class MolecularSpecies implements Cloneable {
	private List<Atom> atoms;
	private List<Bond> bonds;

	private int number;
	private int sites;

	public void addAtom(Atom _atom) {
		createAtomsListIfNeeded();
		atoms.add(_atom);
	}

	/**
	 * 
	 */
	private void createAtomsListIfNeeded() {
		if (this.atoms == null) {
			this.atoms = new ArrayList<Atom>();
		}
	}

	public void removeAtom(Atom _atom) {
		createAtomsListIfNeeded();
			atoms.remove(_atom);

	}

	public void addBond(Bond _bond) {
		createBondsListIfNeede();
			bonds.add(_bond);

	}

	/**
	 * 
	 */
	private void createBondsListIfNeede() {
		if (this.bonds == null) {
			this.bonds = new ArrayList<Bond>();
		}

	}

	public void removeBond(Bond _bond) {
		if (bonds != null) {
			bonds.remove(_bond);
		}
	}

	/**
	 * @return the atoms
	 */
	public List<Atom> getAtoms() {
		createAtomsListIfNeeded();
		return atoms;
	}

	/**
	 * @param atoms
	 *            the atoms to set
	 */
	public void setAtoms(List<Atom> atoms) {
		this.atoms = atoms;
	}

	/**
	 * @return the bonds
	 */
	public List<Bond> getBonds() {
		createBondsListIfNeede();
		return bonds;
	}

	/**
	 * @param bonds
	 *            the bonds to set
	 */
	public void setBonds(List<Bond> bonds) {
		this.bonds = bonds;
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
		this.number = number;
	}

	/**
	 * @return the sites
	 */
	public int getSites() {
		return sites;
	}

	/**
	 * @param sites
	 *            the sites to set
	 */
	public void setSites(int sites) {
		this.sites = sites;
	}

	public void write(OutputStream _os) {

	}

	/**
	 * @see java.lang.Object#clone()
	 */
	@Override
	protected Object clone() throws CloneNotSupportedException {
		MolecularSpecies clone = (MolecularSpecies) super.clone();
		clone.atoms = new ArrayList<Atom>();
		for (Atom atom : atoms) {
			clone.atoms.add((Atom) atom.clone());
		}
		clone.bonds = new ArrayList<Bond>();
		for (Bond bond : bonds) {
			clone.bonds.add((Bond) bond.clone());
		}
		
		return clone;
	}
}
