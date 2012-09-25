package eu.unicore.applications.mp2c;

import java.net.URL;
import java.util.List;
import java.util.Random;

import javax.xml.namespace.QName;

import com.intel.gpe.clients.api.Job;
import com.intel.gpe.clients.api.jsdl.gpe.GPEJob;
import com.intel.gpe.gridbeans.AbstractGridBean;
import com.intel.gpe.gridbeans.GridBeanException;
import com.intel.gpe.gridbeans.parameters.IGridBeanParameterValue;
import com.intel.gpe.gridbeans.parameters.processing.ParameterUtils;

public class MP2CGridbean extends AbstractGridBean {

	// final MP2CGridBeanParameter mp2cParam;


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
		addControlParameters();
		addSolventParameters();
		addSoluteParameters();
		addIoParameters();
		addParallelParameters();

		new DefaultRealm();

	}

	/**
	 * 
	 */
	private void addSoluteParameters() {
		QName[] soluteParameters = new QName[] {
				MP2CGridBeanParameters.SOLUTE_RADIUS_SHIFTED_LJP,
				MP2CGridBeanParameters.SOLUTE_RADIUS_SHIFTED_LJP_SHIFTED,
				MP2CGridBeanParameters.SOLUTE_RADIUS_SHIFTED_SHIFTED_FORCE_LJP,
				MP2CGridBeanParameters.SOLUTE_SHIFTED_FORCE_LJP,
				MP2CGridBeanParameters.SOLUTE_SHIFTED_LJP,
				MP2CGridBeanParameters.SOLUTE_USUAL_LJP };

		List<IGridBeanParameterValue> soluteParamValues = ParameterUtils
				.createEnvParameterValues(soluteParameters, new String[] {
						// MP2CGridBeanParameters.SOLUTE_RADIUS_SHIFTED_LJP
						"false",
						// MP2CGridBeanParameters.SOLUTE_RADIUS_SHIFTED_LJP_SHIFTED
						"false",
						// MP2CGridBeanParameters.SOLUTE_RADIUS_SHIFTED_SHIFTED_FORCE_LJP
						"false",
						// MP2CGridBeanParameters.SOLUTE_SHIFTED_FORCE_LJP
						"false",
						// MP2CGridBeanParameters.SOLUTE_SHIFTED_LJP
						"false",
						// MP2CGridBeanParameters.SOLUTE_USUAL_LJP
						"false"
				});

		getInputParameters().addAll(
				ParameterUtils.createEnvParameters(soluteParameters));
		for (int i = 0; i < soluteParameters.length; i++) {
			set(soluteParameters[i], soluteParamValues.get(i));
		}
	}

	/**
	 * 
	 */
	private void addParallelParameters() {
		QName[] parallelParameters = new QName[] { MP2CGridBeanParameters.PARALLEL };

		List<IGridBeanParameterValue> parParamValues = ParameterUtils
				.createEnvParameterValues(
				parallelParameters, new String[] { "3" });

		addInputParameter(ParameterUtils
				.createEnvParameters(parallelParameters).get(0));
		set(MP2CGridBeanParameters.PARALLEL, parParamValues.get(0));
	}

	/**
	 * 
	 */
	private void addIoParameters() {
		QName[] ioParameters = new QName[] {
				MP2CGridBeanParameters.IO_HISTORY_SOLUTE,
				MP2CGridBeanParameters.IO_HISTORY_SOLUTE_STEPS,
				MP2CGridBeanParameters.IO_HISTORY_SOLUTE_TYPE,
				MP2CGridBeanParameters.IO_HISTORY_SOLVENT,
				MP2CGridBeanParameters.IO_HISTORY_SOLVENT_STEPS,
				MP2CGridBeanParameters.IO_HISTORY_SOLVENT_TYPE,
				MP2CGridBeanParameters.IO_RESTART_SOLUTE,
				MP2CGridBeanParameters.IO_RESTART_SOLUTE_STEPS,
				MP2CGridBeanParameters.IO_RESTART_SOLUTES_TYPE,
				MP2CGridBeanParameters.IO_RESTART_SOLVENT,
				MP2CGridBeanParameters.IO_RESTART_SOLVENT_STEPS,
				MP2CGridBeanParameters.IO_RESTART_SOLVENT_TYPE,
				MP2CGridBeanParameters.IO_STANDARD_OUT,
				MP2CGridBeanParameters.IO_STANDARD_OUT_STEPS,
				MP2CGridBeanParameters.IO_STANDARD_SOLUTES,
				MP2CGridBeanParameters.IO_STANDARD_SOLUTES_STEPS,
				MP2CGridBeanParameters.IO_STANDARD_SOLVENT,
				MP2CGridBeanParameters.IO_STANDARD_SOLVENT_STEPS,
				MP2CGridBeanParameters.IO_USER_OUTPUT,
				MP2CGridBeanParameters.IO_USER_OUTPUT_STEPS,
				MP2CGridBeanParameters.IO_XYZ_SOLUTE,
				MP2CGridBeanParameters.IO_XYZ_SOLUTE_STEPS,
				MP2CGridBeanParameters.IO_XYZ_SOLUTE_TYPE,
				MP2CGridBeanParameters.IO_XYZ_SOLVENT,
				MP2CGridBeanParameters.IO_XYZ_SOLVENT_STEPS,
				MP2CGridBeanParameters.IO_XYZ_SOLVENT_TYPE,
				MP2CGridBeanParameters.IO_XYZ_SYSTEM,
				MP2CGridBeanParameters.IO_XYZ_SYSTEM_STEPS };
		
		String[] ioInitValues = new String[] {
//				MP2CGridBeanParameters.IO_HISTORY_SOLUTE,
				"true",
//				MP2CGridBeanParameters.IO_HISTORY_SOLUTE_STEPS,
				"100",
//				MP2CGridBeanParameters.IO_HISTORY_SOLUTE_TYPE,
				"binary",
//				MP2CGridBeanParameters.IO_HISTORY_SOLVENT,
				"true",
//				MP2CGridBeanParameters.IO_HISTORY_SOLVENT_STEPS,
				"100",
//				MP2CGridBeanParameters.IO_HISTORY_SOLVENT_TYPE,
				"binary",
//				MP2CGridBeanParameters.IO_RESTART_SOLUTE,
				"false",
//				MP2CGridBeanParameters.IO_RESTART_SOLUTE_STEPS,
				"100",
//				MP2CGridBeanParameters.IO_RESTART_SOLUTES_TYPE,
				"binary",
//				MP2CGridBeanParameters.IO_RESTART_SOLVENT,
				"false",
//				MP2CGridBeanParameters.IO_RESTART_SOLVENT_STEPS,
				"100",
//				MP2CGridBeanParameters.IO_RESTART_SOLVENT_TYPE,
				"binary",
//				MP2CGridBeanParameters.IO_STANDARD_OUT,
				"true",
//				MP2CGridBeanParameters.IO_STANDARD_OUT_STEPS,
				"50",
//				MP2CGridBeanParameters.IO_STANDARD_SOLUTES,
				"true",
//				MP2CGridBeanParameters.IO_STANDARD_SOLUTES_STEPS,
				"50",
//				MP2CGridBeanParameters.IO_STANDARD_SOLVENT,
				"true",
//				MP2CGridBeanParameters.IO_STANDARD_SOLVENT_STEPS,
				"50",
//				MP2CGridBeanParameters.IO_USER_OUTPUT,
				"false",
//				MP2CGridBeanParameters.IO_USER_OUTPUT_STEPS,
				"100",
//				MP2CGridBeanParameters.IO_XYZ_SOLUTE,
				"false",
//				MP2CGridBeanParameters.IO_XYZ_SOLUTE_STEPS,
				"100",
//				MP2CGridBeanParameters.IO_XYZ_SOLUTE_TYPE,
				"binary",
//				MP2CGridBeanParameters.IO_XYZ_SOLVENT,
				"false",
//				MP2CGridBeanParameters.IO_XYZ_SOLVENT_STEPS,
				"100",
//				MP2CGridBeanParameters.IO_XYZ_SOLVENT_TYPE,
				"binary",
//				MP2CGridBeanParameters.IO_XYZ_SYSTEM,
				"false",
//				MP2CGridBeanParameters.IO_XYZ_SYSTEM_STEPS
				"100" };
		
		List<IGridBeanParameterValue> ioInitParamValues = ParameterUtils.createEnvParameterValues(ioParameters, ioInitValues);
		
		getInputParameters().addAll(ParameterUtils.createEnvParameters(ioParameters));
		for (int i = 0; i < ioInitValues.length; i++) {
			set(ioParameters[i], ioInitParamValues.get(i));
		}
	}

	/**
	 * 
	 */
	private void addSolventParameters() {
		QName[] solventParameters = new QName[] {
				MP2CGridBeanParameters.SOLVENT_ALPHA,
				MP2CGridBeanParameters.SOLVENT_LAMBDA,
				MP2CGridBeanParameters.SOLVENT_MASS,
				MP2CGridBeanParameters.SOLVENT_PARTICLES,
				MP2CGridBeanParameters.SOLVENT_PPC
		};
		
		List<IGridBeanParameterValue> slvParmValues = ParameterUtils.createEnvParameterValues(solventParameters, new String[] {
						// alpha
				"0",
						// lambda
				"0",
						// mass
				"1",
						// particles
				"1000",
						// particles per cell
						"50" });
		
		getInputParameters().addAll(
				ParameterUtils.createEnvParameters(solventParameters));
		for (int i = 0; i < solventParameters.length; i++) {
			set(solventParameters[i], slvParmValues.get(i));
		}
	}

	private void addControlParameters() {
               
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

	}

	/**
	 * @see com.intel.gpe.gridbeans.AbstractGridBean#getIconURL()
	 */
	@Override
	public URL getIconURL() {
		return getClass().getResource("mp2c.gif");
	}


	/**
	 * @see com.intel.gpe.gridbeans.IGridBean#getName()
	 */
	public String getName() {
		return "MP2C";
	}

}
