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

/**
 * @author bjoernh
 *
 * 30.03.2012 14:58:32
 *
 */
public class Control implements Cloneable {
	private boolean simulateSolute;
	private boolean simulateSolvent;
	private long timeSteps;
	private double temperature;
	private double boxDimX;
	private double boxDimY;
	private double boxDimZ;
	private String bcX;
	private String bcY;
	private String bcZ;
	private double boxRatioX;
	private double boxRatioY;
	private double boxRatioZ;
	private double shearRateX;
	private double shearRateY;
	private double shearRateZ;
	private int collisionSteps;
	private boolean externalForce;
	private double externalForceX;
	private double externalForceY;
	private double externalForceZ;
	private boolean restartSolute;
	private boolean restartSolvent;
	private int randomSeed;
	private boolean langevin;
	private double langevinGamma;
	private int coupling;
	private int strictScalingSteps;

	private static final String NEWLINE = System.getProperty("line.separator");
	private static final String END_SECTION = "**end**" + NEWLINE + NEWLINE;

	/**
	 * @return the simulateSolute
	 */
	public boolean isSimulateSolute() {
		return simulateSolute;
	}

	/**
	 * @param simulateSolute
	 *            the simulateSolute to set
	 */
	public void setSimulateSolute(boolean simulateSolute) {
		this.simulateSolute = simulateSolute;
	}

	/**
	 * @return the simulateSolvent
	 */
	public boolean isSimulateSolvent() {
		return simulateSolvent;
	}

	/**
	 * @param simulateSolvent
	 *            the simulateSolvent to set
	 */
	public void setSimulateSolvent(boolean simulateSolvent) {
		this.simulateSolvent = simulateSolvent;
	}

	/**
	 * @return the timeSteps
	 */
	public long getTimeSteps() {
		return timeSteps;
	}

	/**
	 * @param timeSteps
	 *            the timeSteps to set
	 */
	public void setTimeSteps(long timeSteps) {
		this.timeSteps = timeSteps;
	}

	/**
	 * @return the temperature
	 */
	public double getTemperature() {
		return temperature;
	}

	/**
	 * @param temperature
	 *            the temperature to set
	 */
	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}

	public String getBcX() {
		return bcX;
	}

	public void setBcX(String bcX) {
		this.bcX = bcX;
	}

	public String getBcY() {
		return bcY;
	}

	public void setBcY(String bcY) {
		this.bcY = bcY;
	}

	public String getBcZ() {
		return bcZ;
	}

	public void setBcZ(String bcZ) {
		this.bcZ = bcZ;
	}

	/**
	 * @return the boxDimX
	 */
	public double getBoxDimX() {
		return boxDimX;
	}

	/**
	 * @param boxDimX
	 *            the boxDimX to set
	 */
	public void setBoxDimX(double boxDimX) {
		this.boxDimX = boxDimX;
	}

	/**
	 * @return the boxDimY
	 */
	public double getBoxDimY() {
		return boxDimY;
	}

	/**
	 * @param boxDimY
	 *            the boxDimY to set
	 */
	public void setBoxDimY(double boxDimY) {
		this.boxDimY = boxDimY;
	}

	/**
	 * @return the boxDimZ
	 */
	public double getBoxDimZ() {
		return boxDimZ;
	}

	/**
	 * @param boxDimZ
	 *            the boxDimZ to set
	 */
	public void setBoxDimZ(double boxDimZ) {
		this.boxDimZ = boxDimZ;
	}

	public double getBoxRatioX() {
		return boxRatioX;
	}

	public void setBoxRatioX(double boxRatioX) {
		this.boxRatioX = boxRatioX;
	}

	public double getBoxRatioY() {
		return boxRatioY;
	}

	public void setBoxRatioY(double boxRatioY) {
		this.boxRatioY = boxRatioY;
	}

	public double getBoxRatioZ() {
		return boxRatioZ;
	}

	public void setBoxRatioZ(double boxRatioZ) {
		this.boxRatioZ = boxRatioZ;
	}

	/**
	 * @return the externalForceX
	 */
	public double getExternalForceX() {
		return externalForceX;
	}

	/**
	 * @param externalForceX the externalForceX to set
	 */
	public void setExternalForceX(double externalForceX) {
		this.externalForceX = externalForceX;
	}

	/**
	 * @return the externalForceY
	 */
	public double getExternalForceY() {
		return externalForceY;
	}

	/**
	 * @param externalForceY
	 *            the externalForceY to set
	 */
	public void setExternalForceY(double externalForceY) {
		this.externalForceY = externalForceY;
	}

	/**
	 * @return the externalForceZ
	 */
	public double getExternalForceZ() {
		return externalForceZ;
	}

	/**
	 * @param externalForceZ
	 *            the externalForceZ to set
	 */
	public void setExternalForceZ(double externalForceZ) {
		this.externalForceZ = externalForceZ;
	}

	/**
	 * @return the shearRateX
	 */
	public double getShearRateX() {
		return shearRateX;
	}

	/**
	 * @param shearRateX
	 *            the shearRateX to set
	 */
	public void setShearRateX(double shearRateX) {
		this.shearRateX = shearRateX;
	}

	/**
	 * @return the shearRateY
	 */
	public double getShearRateY() {
		return shearRateY;
	}

	/**
	 * @param shearRateY
	 *            the shearRateY to set
	 */
	public void setShearRateY(double shearRateY) {
		this.shearRateY = shearRateY;
	}

	/**
	 * @return the shearRateZ
	 */
	public double getShearRateZ() {
		return shearRateZ;
	}

	/**
	 * @param shearRateZ
	 *            the shearRateZ to set
	 */
	public void setShearRateZ(double shearRateZ) {
		this.shearRateZ = shearRateZ;
	}

	/**
	 * @return the collisionSteps
	 */
	public int getCollisionSteps() {
		return collisionSteps;
	}

	/**
	 * @param collisionSteps
	 *            the collisionSteps to set
	 */
	public void setCollisionSteps(int collisionSteps) {
		this.collisionSteps = collisionSteps;
	}

	/**
	 * @return the restartSolute
	 */
	public boolean isRestartSolute() {
		return restartSolute;
	}

	/**
	 * @param restartSolute
	 *            the restartSolute to set
	 */
	public void setRestartSolute(boolean restartSolute) {
		this.restartSolute = restartSolute;
	}

	/**
	 * @return the restartSolvent
	 */
	public boolean isRestartSolvent() {
		return restartSolvent;
	}

	/**
	 * @param restartSolvent
	 *            the restartSolvent to set
	 */
	public void setRestartSolvent(boolean restartSolvent) {
		this.restartSolvent = restartSolvent;
	}

	/**
	 * @return the randomSeed
	 */
	public int getRandomSeed() {
		return randomSeed;
	}

	/**
	 * @param randomSeed
	 *            the randomSeed to set
	 */
	public void setRandomSeed(int randomSeed) {
		this.randomSeed = randomSeed;
	}

	/**
	 * @return the langevin
	 */
	public boolean isLangevin() {
		return langevin;
	}

	/**
	 * @param langevin
	 *            the langevin to set
	 */
	public void setLangevin(boolean langevin) {
		this.langevin = langevin;
	}

	/**
	 * @return the langevinGamma
	 */
	public double getLangevinGamma() {
		return langevinGamma;
	}

	/**
	 * @param langevinGamma
	 *            the langevinGamma to set
	 */
	public void setLangevinGamma(double langevinGamma) {
		this.langevinGamma = langevinGamma;
	}

	/**
	 * @return the coupling
	 */
	public int getCoupling() {
		return coupling;
	}

	/**
	 * @param coupling
	 *            the coupling to set
	 */
	public void setCoupling(int coupling) {
		this.coupling = coupling;
	}

	/**
	 * @return the strictScalingSteps
	 */
	public int getStrictScalingSteps() {
		return strictScalingSteps;
	}

	/**
	 * @param strictScalingSteps
	 *            the strictScalingSteps to set
	 */
	public void setStrictScalingSteps(int strictScalingSteps) {
		this.strictScalingSteps = strictScalingSteps;
	}

	public void write(OutputStream _os) throws IOException {
		writeHeader(_os);

		writeSolute(_os);
		writeSolvent(_os);
		writeTimeSteps(_os);
		writeTemperature(_os);
		writeBoxRatio(_os);
		writeBoundaries(_os);
		writeShearRate(_os);
		writeCollisionSteps(_os);
		writeExternalForce(_os);
		writeRestart(_os);
		writeRandomSeed(_os);
		writeLangevin(_os);
		writeThermostat(_os);
		writeMaxScal(_os);

		_os.flush();
	}

	/**
	 * @param _os
	 * @throws IOException
	 */
	private void writeHeader(OutputStream _os) throws IOException {
		String s = "#####################################" + NEWLINE +
				"# general control settings for MP2C" + NEWLINE +
 "#####################################" + NEWLINE + NEWLINE;

		_os.write(s.getBytes());
	}

	/**
	 * @param _os
	 * @throws IOException
	 */
	private void writeMaxScal(OutputStream _os) throws IOException {
		StringBuilder sb = new StringBuilder();
		sb.append("++max-scal++     max. number of steps for strict scaling")
				.append(NEWLINE);
		sb.append("10000").append(NEWLINE);
		sb.append(END_SECTION);

		_os.write(sb.toString().getBytes());
	}

	/**
	 * @param _os
	 * @throws IOException
	 */
	private void writeThermostat(OutputStream _os) throws IOException {
		StringBuilder sb = new StringBuilder();

		sb.append(
				"*Off*thermostat** at present only Berendsen weak-coupling version")
				.append(NEWLINE);
		sb.append("++coupl++     coupling constant").append(NEWLINE);
		sb.append("1000").append(NEWLINE);
		sb.append(END_SECTION);

		_os.write(sb.toString().getBytes());
	}

	/**
	 * @param _os
	 * @throws IOException
	 */
	private void writeLangevin(OutputStream _os) throws IOException {
		StringBuilder sb = new StringBuilder();
		sb.append("*Off*langevin**    perform langevin dynamics").append(
				NEWLINE);
		sb.append("++gamma++").append(NEWLINE);
		sb.append("1.0").append(NEWLINE);
		sb.append(END_SECTION);

		_os.write(sb.toString().getBytes());
	}

	/**
	 * @param _os
	 * @throws IOException
	 */
	private void writeRandomSeed(OutputStream _os) throws IOException {
		StringBuilder sb = new StringBuilder();
		sb.append("**random-seed**").append(NEWLINE);
		sb.append(randomSeed).append(NEWLINE).append(NEWLINE);

		_os.write(sb.toString().getBytes());
	}

	/**
	 * @param _os
	 * @throws IOException
	 */
	private void writeExternalForce(OutputStream _os) throws IOException {
		StringBuilder sb = new StringBuilder();
		if (!externalForce) {
			sb.append("*Off*ext-force**     external force").append(NEWLINE);
		} else {
			sb.append("**ext-force**     external force").append(NEWLINE);
		}
		sb.append(externalForceX).append(" ").append(externalForceY)
				.append(" ").append(externalForceZ).append(NEWLINE)
				.append(NEWLINE);

		_os.write(sb.toString().getBytes());
	}

	/**
	 * @param _os
	 * @throws IOException
	 */
	private void writeCollisionSteps(OutputStream _os) throws IOException {
		StringBuilder sb = new StringBuilder();
		sb.append("**coll-step**    interval for collision steps").append(
				NEWLINE);
		sb.append(collisionSteps).append(NEWLINE);

		_os.write(sb.toString().getBytes());

	}

	/**
	 * @param _os
	 * @throws IOException
	 */
	private void writeShearRate(OutputStream _os) throws IOException {
		StringBuilder sb = new StringBuilder();
		sb.append("**shear-rate**").append(NEWLINE);
		sb.append(shearRateX).append(" ");
		sb.append(shearRateY).append(" ");
		sb.append(shearRateZ).append(NEWLINE).append(NEWLINE);

		_os.write(sb.toString().getBytes());
	}

	/**
	 * @param _os
	 * @throws IOException
	 */
	private void writeBoundaries(OutputStream _os) throws IOException {
		// TODO Generate correct mapping from human readable Strings to
		// application Strings
		StringBuilder sb = new StringBuilder();
		sb.append("**boundary**     boundary conditions").append(NEWLINE);
		sb.append(bcX).append(" ");
		sb.append(bcY).append(" ");
		sb.append(bcZ).append(NEWLINE).append(NEWLINE);

		_os.write(sb.toString().getBytes());
	}

	/**
	 * @param _os
	 * @throws IOException
	 */
	private void writeBoxRatio(OutputStream _os) throws IOException {
		StringBuilder sb = new StringBuilder();

		sb.append("**box-ratio**    ratio of box-lengths").append(NEWLINE);
		sb.append(boxRatioX).append(" ");
		sb.append(boxRatioY).append(" ");
		sb.append(boxRatioZ).append(NEWLINE).append(NEWLINE);

		_os.write(sb.toString().getBytes());
	}

	/**
	 * @param _os
	 * @throws IOException
	 */
	private void writeTemperature(OutputStream _os) throws IOException {
		StringBuilder sb = new StringBuilder();
		sb.append("**temperature**  temperature in kT").append(NEWLINE);
		sb.append(temperature).append(NEWLINE).append(NEWLINE);

		_os.write(sb.toString().getBytes());
	}

	/**
	 * @param _os
	 * @throws IOException
	 */
	private void writeTimeSteps(OutputStream _os) throws IOException {
		StringBuilder sb = new StringBuilder();
		sb.append("**nsteps**   number of time steps").append(NEWLINE);
		sb.append(timeSteps).append(NEWLINE).append(NEWLINE);

		_os.write(sb.toString().getBytes());
	}

	/**
	 * @param _os
	 * @throws IOException
	 */
	private void writeSolvent(OutputStream _os) throws IOException {
		StringBuilder sb = new StringBuilder();
		sb.append("**solvent**      solvent is simulated").append(NEWLINE);
		sb.append(".").append(simulateSolvent).append(".").append(NEWLINE)
				.append(NEWLINE);

		_os.write(sb.toString().getBytes());
	}

	/**
	 * @param _os
	 * @throws IOException
	 */
	private void writeSolute(OutputStream _os) throws IOException {
		StringBuilder sb = new StringBuilder();
		sb.append("**solute**      solutes are simulated").append(NEWLINE);
		sb.append(".").append(simulateSolute).append(".").append(NEWLINE)
				.append(NEWLINE);

		_os.write(sb.toString().getBytes());
	}

	/**
	 * @param _os
	 * @throws IOException
	 */
	private void writeRestart(OutputStream _os) throws IOException {
		StringBuilder sb = new StringBuilder();
		sb.append(
				"**restart**      switches to start from restart configurations")
				.append(NEWLINE);
		_os.write(sb.toString().getBytes());
		writeRestartSolute(_os);
		writeRestartSolvent(_os);

		sb = new StringBuilder();
		sb.append(END_SECTION);
		_os.write(sb.toString().getBytes());
	}

	/**
	 * @param _os
	 * @throws IOException
	 */
	private void writeRestartSolvent(OutputStream _os) throws IOException {
		StringBuilder sb = new StringBuilder();
		sb.append("++solvent++").append(NEWLINE);
		sb.append(".").append(restartSolvent).append(".");
		sb.append(" ");
		sb.append(".").append(restartSolvent).append(".").append(NEWLINE);

		_os.write(sb.toString().getBytes());
	}

	/**
	 * @param _os
	 * @throws IOException
	 */
	private void writeRestartSolute(OutputStream _os) throws IOException {
		StringBuilder sb = new StringBuilder();
		sb.append("++solute++").append(NEWLINE);
		sb.append(".").append(restartSolute).append(".");
		sb.append(" ");
		sb.append(".").append(restartSolute).append(".").append(NEWLINE);

		_os.write(sb.toString().getBytes());
	}

	/**
	 * @see java.lang.Object#clone()
	 */
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
