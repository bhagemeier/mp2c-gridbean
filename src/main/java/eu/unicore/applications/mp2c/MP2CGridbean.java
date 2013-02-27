package eu.unicore.applications.mp2c;

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

public class MP2CGridbean extends AbstractGridBean {

	final MP2CGridBeanParameter mp2cParam;

	private final Map<QName, String> QNAME_2_FILENAME = new HashMap<QName, String>();

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

		mp2cParam = new MP2CGridBeanParameter();
		MP2CGridBeanParameterValue mp2cParamValue = new MP2CGridBeanParameterValue();
		addInputParameter(mp2cParam);
		set(MP2CGridBeanParameter.MP2C_QNAME, mp2cParamValue);

		List<IGridBeanParameter> inputFiles = ParameterUtils
				.createFileParameters(new QName[] {
						MP2CGridBeanParameters.CONTROL_FILE_QNAME,
						MP2CGridBeanParameters.IO_FILE_QNAME,
						MP2CGridBeanParameters.QUENCH_FILE_QNAME,
						MP2CGridBeanParameters.SOLUTE_FILE_QNAME,
						MP2CGridBeanParameters.SOLVENT_FILE_QNAME,
						MP2CGridBeanParameters.PARALLEL_FILE_QNAME }, true);

		for (IGridBeanParameter iGridBeanParameter : inputFiles) {
			addInputParameter(iGridBeanParameter);
			// set(iGridBeanParameter.getName(), new InputFileParameterValue(
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

		// addPropertyChangeListener(MP2CGridBeanParameter.MP2C_QNAME, this);
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

	/**
	 * @see com.intel.gpe.gridbeans.AbstractGridBean#getIconURL()
	 */
	@Override
	public URL getIconURL() {
		return getClass().getResource("mp2c.gif");
	}

}
