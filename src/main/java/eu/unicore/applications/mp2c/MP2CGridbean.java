package eu.unicore.applications.mp2c;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.namespace.QName;

import com.intel.gpe.clients.api.Job;
import com.intel.gpe.clients.api.jsdl.gpe.GPEJob;
import com.intel.gpe.gridbeans.AbstractGridBean;
import com.intel.gpe.gridbeans.GridBeanException;
import com.intel.gpe.gridbeans.parameters.IGridBeanParameter;
import com.intel.gpe.gridbeans.parameters.InputFileParameterValue;
import com.intel.gpe.gridbeans.parameters.processing.ParameterUtils;

import eu.unicore.applications.mp2c.model.MP2CConfig;

public class MP2CGridbean extends AbstractGridBean implements
		PropertyChangeListener {


	private final Map<QName, String> QNAME_2_FILENAME = new HashMap<QName, String>();

	private static final QName CONTROL_FILE_QNAME = new QName(
			"http://www.unicore.eu/applications/mp2c", "controlFile");
	private static final String CONTROL_FILE_NAME = "mp2c_ctrl.inp";

	private static final QName SOLUTE_FILE_QNAME = new QName(
			"http://www.unicore.eu/applications/mp2c", "soluteFile");
	private static final String SOLUTE_FILE_NAME = "mp2c_slt.inp";

	private static final QName SOLVENT_FILE_QNAME = new QName(
			"http://www.unicore.eu/applications/mp2c", "solventFile");
	private static final String SOLVENT_FILE_NAME = "mp2c_slv.inp";

	private static final QName QUENCH_FILE_QNAME = new QName(
			"http://www.unicore.eu/applications/mp2c", "quenchFile");
	private static final String QUENCH_FILE_NAME = "mp2c_quench.inp";

	private static final QName IO_FILE_QNAME = new QName(
			"http://www.unicore.eu/applications/mp2c", "ioFile");
	private static final String IO_FILE_NAME = "mp2c_io.inp";

	private static final QName PARALLEL_FILE_QNAME = new QName(
			"http://www.unicore.eu/applications/mp2c", "quenchFile");
	private static final String PARALLEL_FILE_NAME = "mp2c_par.inp";

	/**
	 * 
	 */
	private static final long serialVersionUID = 8649345969975447226L;

	/**
	 * BEWARE: MP2CGridBeanParameter and the input files have a mutual
	 * relationship. If a file is set by a user, then the respective GUI
	 * configuration should not be used.
	 */
	public MP2CGridbean() {
		QNAME_2_FILENAME.put(CONTROL_FILE_QNAME, CONTROL_FILE_NAME);
		QNAME_2_FILENAME.put(SOLUTE_FILE_QNAME, SOLUTE_FILE_NAME);
		QNAME_2_FILENAME.put(SOLVENT_FILE_QNAME, SOLVENT_FILE_NAME);
		QNAME_2_FILENAME.put(QUENCH_FILE_QNAME, QUENCH_FILE_NAME);
		QNAME_2_FILENAME.put(IO_FILE_QNAME, IO_FILE_NAME);
		QNAME_2_FILENAME.put(PARALLEL_FILE_QNAME, PARALLEL_FILE_NAME);

		addInputParameter(new MP2CGridBeanParameter());
		List<IGridBeanParameter> inputFiles = ParameterUtils
				.createFileParameters(new QName[] { CONTROL_FILE_QNAME,
						IO_FILE_QNAME, QUENCH_FILE_QNAME, SOLUTE_FILE_QNAME,
						SOLVENT_FILE_QNAME }, true);
		ParameterUtils.createFileParameterValues(new String[] { "", "", "", "",
				"" }, true);
		// ParameterUtils.
		set(CONTROL_FILE_QNAME, new InputFileParameterValue(CONTROL_FILE_NAME));
		set(IO_FILE_QNAME, new InputFileParameterValue(IO_FILE_NAME));
		set(QUENCH_FILE_QNAME, new InputFileParameterValue(QUENCH_FILE_NAME));
		set(SOLUTE_FILE_QNAME, new InputFileParameterValue(SOLUTE_FILE_NAME));
		set(SOLVENT_FILE_QNAME, new InputFileParameterValue(SOLVENT_FILE_NAME));
		set(PARALLEL_FILE_QNAME,
				new InputFileParameterValue(PARALLEL_FILE_NAME));

		// set local filename for each of the configuration files
		for (QName qn : QNAME_2_FILENAME.keySet()) {
				InputFileParameterValue ifpv;
				try {
					ifpv = new InputFileParameterValue(File.createTempFile(
							QNAME_2_FILENAME.get(qn) + "_", null)
							.getAbsolutePath());
					ifpv.getTarget().setRelativePath(QNAME_2_FILENAME.get(qn));
					set(qn, ifpv);
				} catch (IOException e) {
				// must not happen, but swallowing is no solution
				// throw new GridBeanException(e);
				}
			}


		for (IGridBeanParameter iGridBeanParameter : inputFiles) {
			addInputParameter(iGridBeanParameter);
		}

		new DefaultRealm();

		addPropertyChangeListener(MP2CGridBeanParameter.MP2C_QNAME, this);
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

			for (IGridBeanParameter inputParameter : getInputParameters()) {
				if (inputParameter.getName().equals(
						MP2CGridBeanParameter.MP2C_QNAME)) {
					MP2CGridBeanParameter mp2cParam = (MP2CGridBeanParameter) inputParameter;
					MP2CConfig config = mp2cParam.getConfig();

					// System.out.println(config.getRandomSeed());
					// System.out.println(config.getControl());
					// System.out.println(config.getIo());
					// System.out.println(config.getQuench());
					// System.out.println(config.getSolute());
					// System.out.println(config.getSolvent());
				} else if (inputParameter.getName().equals(CONTROL_FILE_QNAME)) {
					writeControlFile();
				} else if (inputParameter.getName().equals(SOLUTE_FILE_QNAME)) {
					writeSoluteFile();
				} else if (inputParameter.getName().equals(SOLVENT_FILE_QNAME)) {
					writeSolventFile();
				} else if (inputParameter.getName().equals(QUENCH_FILE_QNAME)) {
					writeQuenchFile();
				} else if (inputParameter.getName().equals(IO_FILE_QNAME)) {
					writeIoFile();
				} else if (inputParameter.getName().equals(PARALLEL_FILE_QNAME)) {
					writeParallelFile();
				}



			}
		}

	}


	/**
	 * 
	 */
	private void writeParallelFile() {
		System.out.println("Writing parallel configuration file.");
	}

	/**
	 * 
	 */
	private void writeIoFile() {
		System.out.println("Writing IO configuration file.");
	}

	/**
	 * 
	 */
	private void writeQuenchFile() {
		System.out.println("Writing quench configuration file.");
	}

	/**
	 * 
	 */
	private void writeSolventFile() {
		System.out.println("Writing solvent configuration file.");
	}

	/**
	 * 
	 */
	private void writeSoluteFile() {
		System.out.println("Writing solute configuration file.");
	}

	/**
	 * 
	 */
	private void writeControlFile() {
		System.out.println("Writing general configuration file.");
	}

	/**
	 * @see com.intel.gpe.gridbeans.IGridBean#getName()
	 */
	public String getName() {
		return "MP2C";
	}

	/**
	 * @see com.intel.gpe.gridbeans.AbstractGridBean#getIconURL()
	 */
	@Override
	public URL getIconURL() {
		return getClass().getResource("mp2c.png");
	}

	/**
	 * @see java.beans.PropertyChangeListener#propertyChange(java.beans.PropertyChangeEvent)
	 */
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		// TODO Auto-generated method stub
	}

}
