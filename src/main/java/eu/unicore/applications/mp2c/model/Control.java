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

/**
 * @author bjoernh
 *
 * 30.03.2012 14:58:32
 *
 */
public class Control {
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
	private double externalForces;
	private boolean restartSolute;
	private boolean restartSolvent;
	private double randomSeed;
	private boolean langevin;
	private double langevinGamma;
	private int coupling;
	private int strictScalingSteps;

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
	 * @return the externalForces
	 */
	public double getExternalForces() {
		return externalForces;
	}

	/**
	 * @param externalForces
	 *            the externalForces to set
	 */
	public void setExternalForces(double externalForces) {
		this.externalForces = externalForces;
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
	public double getRandomSeed() {
		return randomSeed;
	}

	/**
	 * @param randomSeed
	 *            the randomSeed to set
	 */
	public void setRandomSeed(double randomSeed) {
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

}
