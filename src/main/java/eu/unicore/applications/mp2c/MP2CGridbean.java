package eu.unicore.applications.mp2c;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.xml.namespace.QName;

import com.intel.gpe.clients.api.Job;
import com.intel.gpe.clients.api.jsdl.gpe.GPEJob;
import com.intel.gpe.gridbeans.AbstractGridBean;
import com.intel.gpe.gridbeans.GridBeanException;
import com.intel.gpe.gridbeans.parameters.IGridBeanParameter;
import com.intel.gpe.gridbeans.parameters.IGridBeanParameterValue;
import com.intel.gpe.gridbeans.parameters.InputFileParameterValue;
import com.intel.gpe.gridbeans.parameters.processing.ParameterUtils;

public class MP2CGridbean extends AbstractGridBean {

	// final MP2CGridBeanParameter mp2cParam;

	private final Map<QName, String> QNAME_2_FILENAME = new HashMap<QName, String>();

	/**
	 * 
	 */
	private static final long serialVersionUID = 8649345969975447226L;

	private static final String NEWLINE = System.getProperty("line.separator");
	private static final String END_SECTION = "**end**" + NEWLINE + NEWLINE;

	/**
	 * BEWARE: MP2CGridBeanParameter and the input files have a mutual
	 * relationship. If a file is set by a user, then the respective GUI
	 * configuration should not be used.
	 */
	public MP2CGridbean() {
		// JAXBContextProvider.addPackage(getClass().getPackage());

		QNAME_2_FILENAME.put(MP2CGridBeanParameters.CONTROL_FILE_QNAME,
				MP2CGridBeanParameters.CONTROL_FILE_NAME);
		QNAME_2_FILENAME.put(MP2CGridBeanParameters.SOLUTE_FILE_QNAME,
				MP2CGridBeanParameters.SOLUTE_FILE_NAME);
		QNAME_2_FILENAME.put(MP2CGridBeanParameters.SOLVENT_FILE_QNAME,
				MP2CGridBeanParameters.SOLVENT_FILE_NAME);
		QNAME_2_FILENAME.put(MP2CGridBeanParameters.QUENCH_FILE_QNAME,
				MP2CGridBeanParameters.QUENCH_FILE_NAME);
		QNAME_2_FILENAME.put(MP2CGridBeanParameters.IO_FILE_QNAME,
				MP2CGridBeanParameters.IO_FILE_NAME);
		QNAME_2_FILENAME.put(MP2CGridBeanParameters.PARALLEL_FILE_QNAME,
				MP2CGridBeanParameters.PARALLEL_FILE_NAME);

		List<IGridBeanParameter> inputFiles = ParameterUtils
				.createFileParameters(new QName[] {
						MP2CGridBeanParameters.CONTROL_FILE_QNAME,
						MP2CGridBeanParameters.IO_FILE_QNAME,
						MP2CGridBeanParameters.QUENCH_FILE_QNAME,
						MP2CGridBeanParameters.SOLUTE_FILE_QNAME,
						MP2CGridBeanParameters.SOLVENT_FILE_QNAME,
						MP2CGridBeanParameters.PARALLEL_FILE_QNAME }, true);

		addControlParameters();

		for (IGridBeanParameter iGridBeanParameter : inputFiles) {
			addInputParameter(iGridBeanParameter);
//			set(iGridBeanParameter.getName(), new InputFileParameterValue(
			// QNAME_2_FILENAME.get(iGridBeanParameter.getName())));
		}

		// set local filename for each of the configuration files
		for (QName qn : QNAME_2_FILENAME.keySet()) {
			InputFileParameterValue ifpv;
			try {
				ifpv = new InputFileParameterValue(File.createTempFile(
						QNAME_2_FILENAME.get(qn) + "_", null).getAbsolutePath());
				ifpv.getTarget().setRelativePath(QNAME_2_FILENAME.get(qn));
				set(qn, ifpv);
			} catch (IOException e) {
				// must not happen, but swallowing is no solution
				// throw new GridBeanException(e);
				e.printStackTrace();
			}
		}

		new DefaultRealm();

	}

	/**
	 * 
	 */
	private void addControlParameters() {
		// IGridBeanParameter gbp = new GridBeanParameter(
		// MP2CGridBeanParameters.CTRL_RANDOM_SEED,
		// GridBeanParameterType.ENVIRONMENT_VARIABLE, true);
		// addInputParameter(gbp);
		// set(MP2CGridBeanParameters.CTRL_RANDOM_SEED, new Random().nextInt());
		
		QName[] controlParameters = new QName[] {
				MP2CGridBeanParameters.CTRL_BC_X,
				MP2CGridBeanParameters.CTRL_BC_Y,
				MP2CGridBeanParameters.CTRL_BC_Z,
				MP2CGridBeanParameters.CTRL_BOX_RATIO_X,
				MP2CGridBeanParameters.CTRL_BOX_RATIO_Y,
				MP2CGridBeanParameters.CTRL_BOX_RATIO_Z,
				MP2CGridBeanParameters.CTRL_COLL_STEPS_INTERVAL,
				MP2CGridBeanParameters.CTRL_COUPLING,
				MP2CGridBeanParameters.CTRL_EXTERNAL_FORCE,
				MP2CGridBeanParameters.CTRL_EXTERNAL_FORCE_X,
				MP2CGridBeanParameters.CTRL_EXTERNAL_FORCE_Y,
				MP2CGridBeanParameters.CTRL_EXTERNAL_FORCE_Z,
				MP2CGridBeanParameters.CTRL_LANGEVIN,
				MP2CGridBeanParameters.CTRL_LANGEVIN_GAMMA,
				MP2CGridBeanParameters.CTRL_RANDOM_SEED,
				MP2CGridBeanParameters.CTRL_RESTART_SOLUTE,
				MP2CGridBeanParameters.CTRL_RESTART_SOLVENT,
				MP2CGridBeanParameters.CTRL_SHEAR_RATE_X,
				MP2CGridBeanParameters.CTRL_SHEAR_RATE_Y,
				MP2CGridBeanParameters.CTRL_SHEAR_RATE_Z,
				MP2CGridBeanParameters.CTRL_SIM_SOLUTE,
				MP2CGridBeanParameters.CTRL_SIM_SOLVENT,
				MP2CGridBeanParameters.CTRL_STRICT_SCALING_STEPS,
				MP2CGridBeanParameters.CTRL_TEMPERATURE,
				MP2CGridBeanParameters.CTRL_TIMESTEPS };
		
		List<IGridBeanParameterValue> paramValues = ParameterUtils
				.createEnvParameterValues(controlParameters, new String[] {
				// boundary conditions x/y/z
				"PBC", "PBC", "PBC",
				// box ratios x y z
				"1", "1", "1",
				// timesteps, coupling (?)
				"5000", "0",
				// external force active/x/y/z
				"true", "0", "0", "0",
				// langevin
				"0", "0",
				// random seed
				Integer.toString(new Random().nextInt()),
				// restart solute/solvent
				"false", "false",
				// shear rates x y z
				"0", "0", "0",
				// simulate solute
				"true",
				// simulate solvent
				"true",
				// strict scaling steps
				"10000",
				// temperature
				"273",
				// timesteps
				"5000" });

		getInputParameters().addAll(
				ParameterUtils.createEnvParameters(controlParameters));

		for (int i = 0; i < controlParameters.length; i++) {
			set(controlParameters[i], paramValues.get(i));
		}
	}

	/**
	 * @see com.intel.gpe.gridbeans.AbstractGridBean#setupJobDefinition(com.intel.gpe.clients.api.Job)
	 */
	@Override
	public void setupJobDefinition(Job job) throws GridBeanException {
		super.setupJobDefinition(job);

		if (job instanceof GPEJob) {
			GPEJob gpeJob = (GPEJob) job;
			gpeJob.setApplicationName("MP2C");
			gpeJob.setApplicationVersion("1.0.0");

		}

		try {
			writeControlFile();
			writeIoFile();
		} catch (FileNotFoundException e) {
			throw new GridBeanException(e);
		} catch (IOException e) {
			throw new GridBeanException(e);
		}

	}

	/**
	 * 
	 */
	private void writeIoFile() {

	}

	/**
	 * @throws IOException
	 * 
	 */
	private void writeControlFile() throws IOException {
		OutputStream os = new FileOutputStream(
				((InputFileParameterValue) get(MP2CGridBeanParameters.CONTROL_FILE_QNAME))
						.getSource().getInternalString());

		writeCtrlSolute(os);
		writeCtrlSolvent(os);
		writeCtrlTimeSteps(os);
		writeCtrlTemperature(os);
		writeCtrlBoxRatio(os);
		writeCtrlBoundaries(os);
		writeCtrlShearRate(os);
		writeCtrlCollisionSteps(os);
		writeCtrlExternalForce(os);
		writeCtrlRestart(os);
		writeCtrlRandomSeed(os);
		writeCtrlLangevin(os);
		// The two following methods are stubs
		// writeCtrlThermostat(os);
		// writeCtrlMaxScal(os);

	}

	/**
	 * @param _os
	 * @throws IOException
	 */
	private void writeCtrlSolute(OutputStream _os) throws IOException {
		StringBuilder sb = new StringBuilder();
		sb.append("**solute**      solutes are simulated").append(NEWLINE);
		sb.append(".").append(get(MP2CGridBeanParameters.CTRL_SIM_SOLUTE))
				.append(".").append(NEWLINE).append(NEWLINE);

		_os.write(sb.toString().getBytes());

	}

	/**
	 * @param _os
	 * @throws IOException
	 */
	private void writeCtrlSolvent(OutputStream _os) throws IOException {
		StringBuilder sb = new StringBuilder();
		sb.append("**solvent**      solvent is simulated").append(NEWLINE);
		sb.append(".").append(get(MP2CGridBeanParameters.CTRL_SIM_SOLVENT))
				.append(".").append(NEWLINE).append(NEWLINE);

		_os.write(sb.toString().getBytes());
	}

	/**
	 * @param _os
	 * @throws IOException
	 */
	private void writeCtrlTimeSteps(OutputStream _os) throws IOException {
		StringBuilder sb = new StringBuilder();
		sb.append("**nsteps**   number of time steps").append(NEWLINE);
		sb.append(get(MP2CGridBeanParameters.CTRL_TIMESTEPS)).append(NEWLINE)
				.append(NEWLINE);

		_os.write(sb.toString().getBytes());
	}

	/**
	 * @param _os
	 * @throws IOException
	 */
	private void writeCtrlTemperature(OutputStream _os) throws IOException {
		StringBuilder sb = new StringBuilder();
		sb.append("**temperature**  temperature in kT").append(NEWLINE);
		sb.append(get(MP2CGridBeanParameters.CTRL_TEMPERATURE)).append(NEWLINE)
				.append(NEWLINE);

		_os.write(sb.toString().getBytes());
	}

	/**
	 * @param _os
	 * @throws IOException
	 */
	private void writeCtrlBoxRatio(OutputStream _os) throws IOException {
		StringBuilder sb = new StringBuilder();

		sb.append("**box-ratio**    ratio of box-lengths").append(NEWLINE);
		sb.append(get(MP2CGridBeanParameters.CTRL_BOX_RATIO_X)).append(" ");
		sb.append(get(MP2CGridBeanParameters.CTRL_BOX_RATIO_Y)).append(" ");
		sb.append(get(MP2CGridBeanParameters.CTRL_BOX_RATIO_Z)).append(NEWLINE)
				.append(NEWLINE);

		_os.write(sb.toString().getBytes());
	}

	/**
	 * @param _os
	 * @throws IOException
	 */
	private void writeCtrlBoundaries(OutputStream _os) throws IOException {
		// TODO Generate correct mapping from human readable Strings to
		// application Strings
		StringBuilder sb = new StringBuilder();
		sb.append("**boundary**     boundary conditions").append(NEWLINE);
		sb.append(get(MP2CGridBeanParameters.CTRL_BC_X)).append(" ");
		sb.append(get(MP2CGridBeanParameters.CTRL_BC_Y)).append(" ");
		sb.append(get(MP2CGridBeanParameters.CTRL_BC_Z)).append(NEWLINE)
				.append(NEWLINE);

		_os.write(sb.toString().getBytes());
	}

	/**
	 * @param _os
	 * @throws IOException
	 */
	private void writeCtrlShearRate(OutputStream _os) throws IOException {
		StringBuilder sb = new StringBuilder();
		sb.append("**shear-rate**").append(NEWLINE);
		sb.append(get(MP2CGridBeanParameters.CTRL_SHEAR_RATE_X)).append(" ");
		sb.append(get(MP2CGridBeanParameters.CTRL_SHEAR_RATE_Y)).append(" ");
		sb.append(get(MP2CGridBeanParameters.CTRL_SHEAR_RATE_Z))
				.append(NEWLINE).append(NEWLINE);

		_os.write(sb.toString().getBytes());
	}

	/**
	 * @param _os
	 * @throws IOException
	 */
	private void writeCtrlCollisionSteps(OutputStream _os) throws IOException {
		StringBuilder sb = new StringBuilder();
		sb.append("**coll-step**    interval for collision steps").append(
				NEWLINE);
		sb.append(get(MP2CGridBeanParameters.CTRL_COLL_STEPS_INTERVAL)).append(
				NEWLINE);

		_os.write(sb.toString().getBytes());
	}

	/**
	 * @param _os
	 * @throws IOException
	 */
	private void writeCtrlExternalForce(OutputStream _os) throws IOException {
		StringBuilder sb = new StringBuilder();
		Boolean extforceObj = (Boolean) get(MP2CGridBeanParameters.CTRL_EXTERNAL_FORCE);
		boolean extforce = false;
		if (extforceObj != null) {
			extforce = true;
		}
		if (!extforce) {
			sb.append("*Off*ext-force**     external force").append(NEWLINE);
		} else {
			sb.append("**ext-force**     external force").append(NEWLINE);
		}
		sb.append(get(MP2CGridBeanParameters.CTRL_EXTERNAL_FORCE_X))
				.append(" ")
				.append(get(MP2CGridBeanParameters.CTRL_EXTERNAL_FORCE_Y))
				.append(" ")
				.append(get(MP2CGridBeanParameters.CTRL_EXTERNAL_FORCE_Z))
				.append(NEWLINE)
				.append(NEWLINE);

		_os.write(sb.toString().getBytes());
	}

	/**
	 * @param os
	 * @throws IOException
	 */
	private void writeCtrlRestart(OutputStream os) throws IOException {
		StringBuilder sb = new StringBuilder();
		sb.append(
				"**restart**      switches to start from restart configurations")
				.append(NEWLINE);
		os.write(sb.toString().getBytes());
		writeRestartSolute(os);
		writeRestartSolvent(os);

		sb = new StringBuilder();
		sb.append(END_SECTION);
		os.write(sb.toString().getBytes());
	}

	/**
	 * @param os
	 * @throws IOException
	 */
	private void writeRestartSolute(OutputStream os) throws IOException {
		StringBuilder sb = new StringBuilder();
		sb.append("++solute++").append(NEWLINE);
		sb.append(".").append(get(MP2CGridBeanParameters.CTRL_RESTART_SOLUTE))
				.append(".");
		sb.append(" ");
		sb.append(".").append(get(MP2CGridBeanParameters.CTRL_RESTART_SOLUTE))
				.append(".").append(NEWLINE);

		os.write(sb.toString().getBytes());
	}

	/**
	 * @param os
	 * @throws IOException
	 */
	private void writeRestartSolvent(OutputStream os) throws IOException {
		StringBuilder sb = new StringBuilder();
		sb.append("++solvent++").append(NEWLINE);
		sb.append(".").append(get(MP2CGridBeanParameters.CTRL_RESTART_SOLVENT))
				.append(".");
		sb.append(" ");
		sb.append(".").append(get(MP2CGridBeanParameters.CTRL_RESTART_SOLVENT))
				.append(".").append(NEWLINE);

		os.write(sb.toString().getBytes());
	}

	/**
	 * @param _os
	 * @throws IOException
	 */
	private void writeCtrlRandomSeed(OutputStream _os) throws IOException {
		StringBuilder sb = new StringBuilder();
		sb.append("**random-seed**").append(NEWLINE);
		sb.append(get(MP2CGridBeanParameters.CTRL_RANDOM_SEED)).append(NEWLINE)
				.append(NEWLINE);

		_os.write(sb.toString().getBytes());

	}

	/**
	 * @param _os
	 * @throws IOException
	 */
	private void writeCtrlLangevin(OutputStream _os) throws IOException {
		StringBuilder sb = new StringBuilder();
		sb.append("*Off*langevin**    perform langevin dynamics").append(
				NEWLINE);
		sb.append("++gamma++").append(NEWLINE);
		sb.append("1.0").append(NEWLINE);
		sb.append(END_SECTION);

		_os.write(sb.toString().getBytes());

	}

	/**
	 * @param os
	 * @throws IOException
	 */
	private void writeCtrlThermostat(OutputStream os) throws IOException {
		StringBuilder sb = new StringBuilder();

		sb.append(
				"*Off*thermostat** at present only Berendsen weak-coupling version")
				.append(NEWLINE);
		sb.append("++coupl++     coupling constant").append(NEWLINE);
		sb.append("1000").append(NEWLINE);
		sb.append(END_SECTION);

		os.write(sb.toString().getBytes());
	}

	/**
	 * @param os
	 * @throws IOException
	 */
	private void writeCtrlMaxScal(OutputStream os) throws IOException {
		StringBuilder sb = new StringBuilder();
		sb.append("++max-scal++     max. number of steps for strict scaling")
				.append(NEWLINE);
		sb.append("10000").append(NEWLINE);
		sb.append(END_SECTION);

		os.write(sb.toString().getBytes());
	}

	/**
	 * @see com.intel.gpe.gridbeans.AbstractGridBean#parseJobDefinition(com.intel.gpe.clients.api.Job)
	 */
	@Override
	public void parseJobDefinition(Job job) throws GridBeanException {
		super.parseJobDefinition(job);
	}

	/**
	 * @see com.intel.gpe.gridbeans.IGridBean#getName()
	 */
	public String getName() {
		return "MP2C";
	}

}
