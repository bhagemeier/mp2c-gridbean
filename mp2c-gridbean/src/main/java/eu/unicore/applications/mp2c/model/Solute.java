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

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * TODO This class is lacking support for non-bonded interactions. Read
 * documentation and implement it.
 * 
 * @author bjoernh
 * 
 *         30.03.2012 14:59:44
 * 
 */
public class Solute implements Cloneable {
	private static final String NEWLINE = System.getProperty("line.separator");
	private static final String END_SECTION = "++end++" + NEWLINE;
	private List<MolecularSpecies> molecularSpecies;
	private long molecules;
	private long partsPerMolecule;

	private boolean lj;
	private boolean lj_sp;
	private boolean lj_sf;
	private boolean lj_r0;
	private boolean lj_r0_sp;
	private boolean lj_r0_sf;

	// Could this information be redundant,
	// what about the length of the atoms list from
	// molecularSpecies?
	private long atoms;
	// Could this information be redundant,
	// what about the length of the bonds list from
	// molecularSpecies?
	private long bonds;

	/**
	 * 
	 */
	public Solute() {
		this.molecularSpecies = new ArrayList<MolecularSpecies>();
	}

	/**
	 * @return the molecularSpecies
	 */
	public List<MolecularSpecies> getMolecularSpecies() {
		return molecularSpecies;
	}

	/**
	 * @param molecularSpecies
	 *            the molecularSpecies to set
	 */
	public void setMolecularSpecies(List<MolecularSpecies> molecularSpecies) {
		this.molecularSpecies = molecularSpecies;
	}

	public void addMolecularSpecies(MolecularSpecies _molecularSpecies) {
		this.molecularSpecies.add(_molecularSpecies);
	}

	public void removeMolecularSpecies(MolecularSpecies _molecularSpecies) {
		this.molecularSpecies.remove(_molecularSpecies);
	}

	/**
	 * @return the molecules
	 */
	public long getMolecules() {
		return molecules;
	}

	/**
	 * @param molecules
	 *            the molecules to set
	 */
	public void setMolecules(long molecules) {
		this.molecules = molecules;
	}

	/**
	 * @return the partsPerMolecule
	 */
	public long getPartsPerMolecule() {
		return partsPerMolecule;
	}

	/**
	 * @param partsPerMolecule
	 *            the partsPerMolecule to set
	 */
	public void setPartsPerMolecule(long partsPerMolecule) {
		this.partsPerMolecule = partsPerMolecule;
	}

	/**
	 * @return the atoms
	 */
	public long getAtoms() {
		return atoms;
	}

	/**
	 * @param atoms
	 *            the atoms to set
	 */
	public void setAtoms(long atoms) {
		this.atoms = atoms;
	}

	/**
	 * @return the bonds
	 */
	public long getBonds() {
		return bonds;
	}

	/**
	 * @param bonds
	 *            the bonds to set
	 */
	public void setBonds(long bonds) {
		this.bonds = bonds;
	}

	/**
	 * @return the lj
	 */
	public boolean isLj() {
		return lj;
	}

	/**
	 * @param lj
	 *            the lj to set
	 */
	public void setLj(boolean lj) {
		this.lj = lj;
	}

	/**
	 * @return the lj_sp
	 */
	public boolean isLj_sp() {
		return lj_sp;
	}

	/**
	 * @param lj_sp
	 *            the lj_sp to set
	 */
	public void setLj_sp(boolean lj_sp) {
		this.lj_sp = lj_sp;
	}

	/**
	 * @return the lj_sf
	 */
	public boolean isLj_sf() {
		return lj_sf;
	}

	/**
	 * @param lj_sf
	 *            the lj_sf to set
	 */
	public void setLj_sf(boolean lj_sf) {
		this.lj_sf = lj_sf;
	}

	/**
	 * @return the lj_r0
	 */
	public boolean isLj_r0() {
		return lj_r0;
	}

	/**
	 * @param lj_r0
	 *            the lj_r0 to set
	 */
	public void setLj_r0(boolean lj_r0) {
		this.lj_r0 = lj_r0;
	}

	/**
	 * @return the lj_r0_sp
	 */
	public boolean isLj_r0_sp() {
		return lj_r0_sp;
	}

	/**
	 * @param lj_r0_sp
	 *            the lj_r0_sp to set
	 */
	public void setLj_r0_sp(boolean lj_r0_sp) {
		this.lj_r0_sp = lj_r0_sp;
	}

	/**
	 * @return the lj_r0_sf
	 */
	public boolean isLj_r0_sf() {
		return lj_r0_sf;
	}

	/**
	 * @param lj_r0_sf
	 *            the lj_r0_sf to set
	 */
	public void setLj_r0_sf(boolean lj_r0_sf) {
		this.lj_r0_sf = lj_r0_sf;
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("A solute with " + atoms
				+ " atoms");
		sb.append(" and " + bonds + " bonds.");
		sb.append(System.getProperty("line.separator"));
		sb.append("lj: " + lj);
		sb.append(System.getProperty("line.separator"));
		sb.append("lj_r0: " + lj_r0);
		sb.append(System.getProperty("line.separator"));
		sb.append("lj_r0_sf: " + lj_r0_sf);
		sb.append(System.getProperty("line.separator"));
		sb.append("lj_r0_sp: " + lj_r0_sp);
		sb.append(System.getProperty("line.separator"));
		sb.append("lj_sf: " + lj_sf);
		sb.append(System.getProperty("line.separator"));
		sb.append("lj_sp: " + lj_sp);

		return sb.toString();
	}

	public void write(OutputStream _os) throws IOException {
		writeHeader(_os);
		writeAllSpecies(_os);

	}

	/**
	 * @param _os
	 * @throws IOException
	 */
	private void writeAllSpecies(OutputStream _os) throws IOException {
		StringBuilder sb = new StringBuilder();
		sb.append("**species** number of molecular species").append(NEWLINE);
		sb.append(molecularSpecies.size()).append("            # n_mol_spec")
				.append(NEWLINE).append(NEWLINE);

		_os.write(sb.toString().getBytes());

		int i = 1;
		for (MolecularSpecies species : molecularSpecies) {
			writeSpecies(species, i++, _os);
		}
	}

	/**
	 * @param species
	 * @param _os
	 * @throws IOException
	 */
	private void writeSpecies(MolecularSpecies species, int i, OutputStream _os)
			throws IOException {
		StringBuilder sb = new StringBuilder();
		
		sb.append("#####################################").append(NEWLINE)
				.append("**molecule** parameters for species ").append(i)
				.append(NEWLINE)
				.append("#####################################")
				.append(NEWLINE).append(NEWLINE);
		
		sb.append("++number++   number of molecules").append(NEWLINE);
		sb.append(species.getNumber()).append(NEWLINE).append(NEWLINE);
		
		sb.append("++sites++ number of particles in a molecule")
				.append(NEWLINE);
		sb.append(species.getSites()).append(NEWLINE).append(NEWLINE);
		
		sb.append(
				"++atom++   identifier, range, mass and charge of individual sites "
						+ "(first 2 numbers give the range of sites)")
				.append(NEWLINE);
		
		_os.write(sb.toString().getBytes());
		
		for (Atom atom : species.getAtoms()) {
			writeAtom(atom, _os);
		}
		
		sb = new StringBuilder();
		sb.append("++end++").append(NEWLINE).append(NEWLINE);

		_os.write(sb.toString().getBytes()); // atoms

		sb = new StringBuilder();

		sb.append("++bond++").append(NEWLINE);

		_os.write(sb.toString().getBytes());

		for (Bond bond : species.getBonds()) {
			writeBond(bond, _os);
		}

		sb = new StringBuilder();
		sb.append("++end++").append(NEWLINE);
		_os.write(sb.toString().getBytes()); // bonds

		sb = new StringBuilder();
		sb.append("**finish** molecule ").append(i).append(NEWLINE);
		_os.write(sb.toString().getBytes());
	}

	/**
	 * @param bond
	 * @param _os
	 * @throws IOException
	 */
	private void writeBond(Bond bond, OutputStream _os) throws IOException {
		StringBuilder sb = new StringBuilder();

		sb.append("%%").append(bond.getType()).append("%%").append(NEWLINE);
		sb.append(bond.getNumber()).append(NEWLINE);
		sb.append(bond.getFromRange()).append(" ");
		sb.append(bond.getToRange()).append(" ");
		sb.append(bond.getK()).append(" ");
		sb.append(bond.getR()).append(" ");
		sb.append(NEWLINE);

		_os.write(sb.toString().getBytes());
	}

	/**
	 * @param atom
	 * @throws IOException
	 */
	private void writeAtom(Atom atom, OutputStream _os) throws IOException {
		StringBuilder sb = new StringBuilder();

		sb.append(atom.getIdentifier()).append(" ");
		sb.append(atom.getSymbol()).append(" ");
		sb.append(atom.getFromRange()).append(" ");
		sb.append(atom.getToRange()).append(" ");
		sb.append(atom.getMass()).append(" ");
		sb.append(atom.getCharge()).append(" ");
		sb.append(NEWLINE);

		_os.write(sb.toString().getBytes());
	}

	/**
	 * @param _os
	 * @throws IOException
	 */
	private void writeHeader(OutputStream _os) throws IOException {
		_os.write(("#####################################" + NEWLINE +
				"# solute settings" + NEWLINE +
				"#####################################" + NEWLINE + NEWLINE).getBytes());
	}

	/**
	 * @see java.lang.Object#clone()
	 */
	@Override
	protected Object clone() throws CloneNotSupportedException {
		Solute clone = (Solute) super.clone();
		clone.molecularSpecies = new ArrayList<MolecularSpecies>();
		for (MolecularSpecies species : molecularSpecies) {
			clone.molecularSpecies.add(species);
		}

		return clone;
	}
}
