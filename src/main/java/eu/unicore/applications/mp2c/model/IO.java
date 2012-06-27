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
 * 30.03.2012 14:58:24
 *
 */
public class IO {
	private boolean standard;
	private int standardSteps;
	private boolean standardSolutes;
	private int standardSolutesSteps;
	private boolean standardSolvent;
	private int standardSolventSteps;
	private boolean restartSolute;
	private int restartSoluteSteps;
	private String restartSoluteType;
	private boolean restartSolvent;
	private int restartSolventSteps;
	private String restartSolventType;
	private boolean historySolute;
	private int historySoluteSteps;
	private String historySoluteType;
	private boolean historySolvent;
	private int historySolventSteps;
	private String historySolventType;
	private boolean xyzSystem;
	private int xyzSystemSteps;
	private boolean xyzSolute;
	private int xyzSoluteSteps;
	private String xyzSoluteType;
	private boolean xyzSolvent;
	private int xyzSolventSteps;
	private String xyzSolventType;
	private boolean userOutput;
	private int userOutputSteps;

	/**
	 * @return the standard
	 */
	public boolean isStandard() {
		return standard;
	}

	/**
	 * @param standard
	 *            the standard to set
	 */
	public void setStandard(boolean standard) {
		this.standard = standard;
	}

	/**
	 * @return the standardSteps
	 */
	public int getStandardSteps() {
		return standardSteps;
	}

	/**
	 * @param standardSteps
	 *            the standardSteps to set
	 */
	public void setStandardSteps(int standardSteps) {
		this.standardSteps = standardSteps;
	}

	/**
	 * @return the standardSolutes
	 */
	public boolean isStandardSolutes() {
		return standardSolutes;
	}

	/**
	 * @param standardSolutes
	 *            the standardSolutes to set
	 */
	public void setStandardSolutes(boolean standardSolutes) {
		this.standardSolutes = standardSolutes;
	}

	/**
	 * @return the standardSolutesSteps
	 */
	public int getStandardSolutesSteps() {
		return standardSolutesSteps;
	}

	/**
	 * @param standardSolutesSteps
	 *            the standardSolutesSteps to set
	 */
	public void setStandardSolutesSteps(int standardSolutesSteps) {
		this.standardSolutesSteps = standardSolutesSteps;
	}

	/**
	 * @return the standardSolvent
	 */
	public boolean isStandardSolvent() {
		return standardSolvent;
	}

	/**
	 * @param standardSolvent
	 *            the standardSolvent to set
	 */
	public void setStandardSolvent(boolean standardSolvent) {
		this.standardSolvent = standardSolvent;
	}

	/**
	 * @return the standardSolventSteps
	 */
	public int getStandardSolventSteps() {
		return standardSolventSteps;
	}

	/**
	 * @param standardSolventSteps
	 *            the standardSolventSteps to set
	 */
	public void setStandardSolventSteps(int standardSolventSteps) {
		this.standardSolventSteps = standardSolventSteps;
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
	 * @return the restartSoluteSteps
	 */
	public int getRestartSoluteSteps() {
		return restartSoluteSteps;
	}

	/**
	 * @param restartSoluteSteps
	 *            the restartSoluteSteps to set
	 */
	public void setRestartSoluteSteps(int restartSoluteSteps) {
		this.restartSoluteSteps = restartSoluteSteps;
	}

	/**
	 * @return the restartSoluteType
	 */
	public String getRestartSoluteType() {
		return restartSoluteType;
	}

	/**
	 * @param restartSoluteType
	 *            the restartSoluteType to set
	 */
	public void setRestartSoluteType(String restartSoluteType) {
		this.restartSoluteType = restartSoluteType;
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
	 * @return the restartSolventSteps
	 */
	public int getRestartSolventSteps() {
		return restartSolventSteps;
	}

	/**
	 * @param restartSolventSteps
	 *            the restartSolventSteps to set
	 */
	public void setRestartSolventSteps(int restartSolventSteps) {
		this.restartSolventSteps = restartSolventSteps;
	}

	/**
	 * @return the restartSolventType
	 */
	public String getRestartSolventType() {
		return restartSolventType;
	}

	/**
	 * @param restartSolventType
	 *            the restartSolventType to set
	 */
	public void setRestartSolventType(String restartSolventType) {
		this.restartSolventType = restartSolventType;
	}

	/**
	 * @return the historySolute
	 */
	public boolean isHistorySolute() {
		return historySolute;
	}

	/**
	 * @param historySolute
	 *            the historySolute to set
	 */
	public void setHistorySolute(boolean historySolute) {
		this.historySolute = historySolute;
	}

	/**
	 * @return the historySoluteSteps
	 */
	public int getHistorySoluteSteps() {
		return historySoluteSteps;
	}

	/**
	 * @param historySoluteSteps
	 *            the historySoluteSteps to set
	 */
	public void setHistorySoluteSteps(int historySoluteSteps) {
		this.historySoluteSteps = historySoluteSteps;
	}

	/**
	 * @return the historySoluteType
	 */
	public String getHistorySoluteType() {
		return historySoluteType;
	}

	/**
	 * @param historySoluteType
	 *            the historySoluteType to set
	 */
	public void setHistorySoluteType(String historySoluteType) {
		this.historySoluteType = historySoluteType;
	}

	/**
	 * @return the historySolvent
	 */
	public boolean isHistorySolvent() {
		return historySolvent;
	}

	/**
	 * @param historySolvent
	 *            the historySolvent to set
	 */
	public void setHistorySolvent(boolean historySolvent) {
		this.historySolvent = historySolvent;
	}

	/**
	 * @return the historySolventSteps
	 */
	public int getHistorySolventSteps() {
		return historySolventSteps;
	}

	/**
	 * @param historySolventSteps
	 *            the historySolventSteps to set
	 */
	public void setHistorySolventSteps(int historySolventSteps) {
		this.historySolventSteps = historySolventSteps;
	}

	/**
	 * @return the historySolventType
	 */
	public String getHistorySolventType() {
		return historySolventType;
	}

	/**
	 * @param historySolventType
	 *            the historySolventType to set
	 */
	public void setHistorySolventType(String historySolventType) {
		this.historySolventType = historySolventType;
	}

	/**
	 * @return the xyzSystem
	 */
	public boolean isXyzSystem() {
		return xyzSystem;
	}

	/**
	 * @param xyzSystem
	 *            the xyzSystem to set
	 */
	public void setXyzSystem(boolean xyzSystem) {
		this.xyzSystem = xyzSystem;
	}

	/**
	 * @return the xyzSystemSteps
	 */
	public int getXyzSystemSteps() {
		return xyzSystemSteps;
	}

	/**
	 * @param xyzSystemSteps
	 *            the xyzSystemSteps to set
	 */
	public void setXyzSystemSteps(int xyzSystemSteps) {
		this.xyzSystemSteps = xyzSystemSteps;
	}

	/**
	 * @return the xyzSolute
	 */
	public boolean isXyzSolute() {
		return xyzSolute;
	}

	/**
	 * @param xyzSolute
	 *            the xyzSolute to set
	 */
	public void setXyzSolute(boolean xyzSolute) {
		this.xyzSolute = xyzSolute;
	}

	/**
	 * @return the xyzSoluteSteps
	 */
	public int getXyzSoluteSteps() {
		return xyzSoluteSteps;
	}

	/**
	 * @param xyzSoluteSteps
	 *            the xyzSoluteSteps to set
	 */
	public void setXyzSoluteSteps(int xyzSoluteSteps) {
		this.xyzSoluteSteps = xyzSoluteSteps;
	}

	/**
	 * @return the xyzSoluteType
	 */
	public String getXyzSoluteType() {
		return xyzSoluteType;
	}

	/**
	 * @param xyzSoluteType
	 *            the xyzSoluteType to set
	 */
	public void setXyzSoluteType(String xyzSoluteType) {
		this.xyzSoluteType = xyzSoluteType;
	}

	/**
	 * @return the xyzSolvent
	 */
	public boolean isXyzSolvent() {
		return xyzSolvent;
	}

	/**
	 * @param xyzSolvent
	 *            the xyzSolvent to set
	 */
	public void setXyzSolvent(boolean xyzSolvent) {
		this.xyzSolvent = xyzSolvent;
	}

	/**
	 * @return the xyzSolventSteps
	 */
	public int getXyzSolventSteps() {
		return xyzSolventSteps;
	}

	/**
	 * @param xyzSolventSteps
	 *            the xyzSolventSteps to set
	 */
	public void setXyzSolventSteps(int xyzSolventSteps) {
		this.xyzSolventSteps = xyzSolventSteps;
	}

	/**
	 * @return the xyzSolventType
	 */
	public String getXyzSolventType() {
		return xyzSolventType;
	}

	/**
	 * @param xyzSolventType
	 *            the xyzSolventType to set
	 */
	public void setXyzSolventType(String xyzSolventType) {
		this.xyzSolventType = xyzSolventType;
	}

	/**
	 * @return the userOutput
	 */
	public boolean isUserOutput() {
		return userOutput;
	}

	/**
	 * @param userOutput
	 *            the userOutput to set
	 */
	public void setUserOutput(boolean userOutput) {
		this.userOutput = userOutput;
	}

	/**
	 * @return the userOutputSteps
	 */
	public int getUserOutputSteps() {
		return userOutputSteps;
	}

	/**
	 * @param userOutputSteps
	 *            the userOutputSteps to set
	 */
	public void setUserOutputSteps(int userOutputSteps) {
		this.userOutputSteps = userOutputSteps;
	}
}
