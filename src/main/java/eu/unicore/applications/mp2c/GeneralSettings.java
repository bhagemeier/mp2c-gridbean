package eu.unicore.applications.mp2c;

import java.util.Random;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.core.databinding.beans.PojoProperties;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Text;

public class GeneralSettings extends Composite {
	private DataBindingContext m_bindingContext;
	private Text extForceX;
	private Text extForceY;
	private Text extForceZ;
	private Text shearRateX;
	private Text shearRateY;
	private Text shearRateZ;
	private Text brX;
	private Text brY;
	private Text brZ;
	private Spinner spinnerRandomSeed;
	private Combo bcX;
	private Combo bcY;
	private Combo bcZ;
	private Button btnRestartSolute;
	private Button btnRestartSolvent;
	private Button btnSolute;
	private Button btnSolvent;
	private Button btnExternalForce;
	private Spinner nrTimeStepsSpinner;
	private Text temperature;
	private Spinner collisionSteps;

	/**
	 * Create the composite.
	 * 
	 * @param parent
	 * @param style
	 * @param generalConfig2
	 */
	public GeneralSettings(Composite parent, int style) {
		super(parent, style);
		setLayout(new GridLayout(1, false));

		Group grpGeneral = new Group(this, SWT.NONE);
		grpGeneral.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true,
				1, 1));
		grpGeneral.setText("General");
		grpGeneral.setLayout(new GridLayout(3, false));

		btnSolute = new Button(grpGeneral, SWT.CHECK);
		btnSolute.setText("Solute");

		Label lblNrSteps = new Label(grpGeneral, SWT.NONE);
		lblNrSteps.setText("Number of Timesteps");

		nrTimeStepsSpinner = new Spinner(grpGeneral, SWT.BORDER);
		GridData gd_nrTimeStepsSpinner = new GridData(SWT.FILL, SWT.CENTER,
				false, false, 1, 1);
		gd_nrTimeStepsSpinner.widthHint = 48;
		nrTimeStepsSpinner.setLayoutData(gd_nrTimeStepsSpinner);
		nrTimeStepsSpinner.setMaximum(Integer.MAX_VALUE);

		btnSolvent = new Button(grpGeneral, SWT.CHECK);
		btnSolvent.setText("Solvent");

		Label lblTemperature = new Label(grpGeneral, SWT.NONE);
		lblTemperature.setText("Temperature");

		temperature = new Text(grpGeneral, SWT.BORDER);
		GridData gd_temperature = new GridData(SWT.FILL, SWT.CENTER, false,
				false, 1, 1);
		gd_temperature.widthHint = 73;
		temperature.setLayoutData(gd_temperature);

		btnExternalForce = new Button(grpGeneral, SWT.CHECK);

		btnExternalForce.setText("External force");

		Label lblCollisionSteps = new Label(grpGeneral, SWT.NONE);
		lblCollisionSteps.setText("Collision steps");

		collisionSteps = new Spinner(grpGeneral, SWT.BORDER);
		GridData gd_collisionSteps = new GridData(SWT.FILL, SWT.CENTER, true,
				true, 1, 1);
		gd_collisionSteps.widthHint = 71;
		collisionSteps.setLayoutData(gd_collisionSteps);

		Group grpDimensions = new Group(this, SWT.NONE);
		grpDimensions.setLayout(new GridLayout(5, false));
		grpDimensions.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true,
				true, 1, 1));
		grpDimensions.setText("Dimensions");
		new Label(grpDimensions, SWT.NONE);
		new Label(grpDimensions, SWT.NONE);

		Label lblXaxis = new Label(grpDimensions, SWT.NONE);
		lblXaxis.setText("X-Axis");

		Label lblYaxis = new Label(grpDimensions, SWT.NONE);
		lblYaxis.setText("Y-Axis");

		Label lblZaxis = new Label(grpDimensions, SWT.NONE);
		lblZaxis.setText("Z-Axis");
		new Label(grpDimensions, SWT.NONE);

		Label lblBoxRatio = new Label(grpDimensions, SWT.NONE);
		lblBoxRatio.setText("Box ratio");

		brX = new Text(grpDimensions, SWT.BORDER);
		brX.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		brY = new Text(grpDimensions, SWT.BORDER);
		brY.setLayoutData(new GridData(SWT.FILL, SWT.BOTTOM, true, false, 1, 1));

		brZ = new Text(grpDimensions, SWT.BORDER);
		brZ.setLayoutData(new GridData(SWT.FILL, SWT.BOTTOM, true, false, 1, 1));
		new Label(grpDimensions, SWT.NONE);

		Label lblBoundaryConditions = new Label(grpDimensions, SWT.NONE);
		lblBoundaryConditions.setText("Boundary conditions");

		bcX = new Combo(grpDimensions, SWT.READ_ONLY);
		bcX.setItems(new String[] { "PBC", "BBC", "RBC", "SBC" });
		bcX.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		bcX.select(1);

		bcY = new Combo(grpDimensions, SWT.READ_ONLY);
		bcY.setItems(new String[] { "PBC", "BBC", "RBC", "SBC" });
		bcY.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		bcY.select(1);

		bcZ = new Combo(grpDimensions, SWT.READ_ONLY);
		bcZ.setItems(new String[] { "PBC", "BBC", "RBC", "SBC" });
		bcZ.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		bcZ.select(1);
		new Label(grpDimensions, SWT.NONE);

		Label lblExternalForce = new Label(grpDimensions, SWT.NONE);
		lblExternalForce.setText("External force");

		extForceX = new Text(grpDimensions, SWT.BORDER);
		extForceX.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false,
				1, 1));

		extForceY = new Text(grpDimensions, SWT.BORDER);
		extForceY.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false,
				1, 1));

		extForceZ = new Text(grpDimensions, SWT.BORDER);
		extForceZ.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false,
				1, 1));
		new Label(grpDimensions, SWT.NONE);

		Label lblShearRate = new Label(grpDimensions, SWT.NONE);
		lblShearRate.setText("Shear rate");

		shearRateX = new Text(grpDimensions, SWT.BORDER);
		shearRateX.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
				false, 1, 1));

		shearRateY = new Text(grpDimensions, SWT.BORDER);
		shearRateY.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
				false, 1, 1));

		shearRateZ = new Text(grpDimensions, SWT.BORDER);
		shearRateZ.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
				false, 1, 1));

		Group grpOther = new Group(this, SWT.NONE);
		grpOther.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1,
				1));
		grpOther.setText("Other");
		grpOther.setLayout(new GridLayout(5, false));

		btnRestartSolute = new Button(grpOther, SWT.CHECK);
		btnRestartSolute.setText("Restart solute");
		new Label(grpOther, SWT.NONE);

		Label lblRandomSeed = new Label(grpOther, SWT.NONE);
		lblRandomSeed.setText("Random seed");

		spinnerRandomSeed = new Spinner(grpOther, SWT.BORDER);
		spinnerRandomSeed.setMaximum(Integer.MAX_VALUE);
		spinnerRandomSeed.setMinimum(-2147483648);
		// gridbean model
		// spinnerRandomSeed.setSelection(generalConfig.getRandomSeed());

		Button btnRandomize = new Button(grpOther, SWT.NONE);
		btnRandomize.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				spinnerRandomSeed.setSelection(new Random().nextInt());
			}
		});
		btnRandomize.setText("Randomize");

		btnRestartSolvent = new Button(grpOther, SWT.CHECK);
		btnRestartSolvent.setText("Restart solvent");

		Label fillLabel = new Label(grpOther, SWT.NONE);
		fillLabel.setText("  ");
		fillLabel.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false,
				1, 1));
		new Label(grpOther, SWT.NONE);
		new Label(grpOther, SWT.NONE);
		new Label(grpOther, SWT.NONE);

		// Button btnPrintconfig = new Button(this, SWT.NONE);
		// btnPrintconfig.addSelectionListener(new SelectionAdapter() {
		// @Override
		// public void widgetSelected(SelectionEvent e) {
		// System.out.println(generalConfig.toString());
		// }
		// });
		// btnPrintconfig.setText("PrintConfig");
		m_bindingContext = initDataBindings();

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

	protected DataBindingContext initDataBindings() {
		DataBindingContext bindingContext = new DataBindingContext();
		//
		IObservableValue observeSelectionBtnExternalForceObserveWidget_3 = WidgetProperties
				.selection().observe(btnExternalForce);
		IObservableValue enabledExtForceXObserveValue = PojoProperties.value(
				"enabled").observe(extForceX);
		bindingContext.bindValue(
				observeSelectionBtnExternalForceObserveWidget_3,
				enabledExtForceXObserveValue, null, new UpdateValueStrategy(
						UpdateValueStrategy.POLICY_NEVER));
		//
		IObservableValue observeSelectionBtnExternalForceObserveWidget_2 = WidgetProperties
				.selection().observe(btnExternalForce);
		IObservableValue enabledExtForceYObserveValue = PojoProperties.value(
				"enabled").observe(extForceY);
		bindingContext.bindValue(
				observeSelectionBtnExternalForceObserveWidget_2,
				enabledExtForceYObserveValue, null, new UpdateValueStrategy(
						UpdateValueStrategy.POLICY_NEVER));
		//
		IObservableValue observeSelectionBtnExternalForceObserveWidget_1 = WidgetProperties
				.selection().observe(btnExternalForce);
		IObservableValue enabledExtForceZObserveValue = PojoProperties.value(
				"enabled").observe(extForceZ);
		bindingContext.bindValue(
				observeSelectionBtnExternalForceObserveWidget_1,
				enabledExtForceZObserveValue, null, new UpdateValueStrategy(
						UpdateValueStrategy.POLICY_NEVER));
		//
		return bindingContext;
	}

	public Button getBtnSolute() {
		return btnSolute;
	}

	public Spinner getCollisionSteps() {
		return collisionSteps;
	}

	public Spinner getNrTimeStepsSpinner() {
		return nrTimeStepsSpinner;
	}

	public Button getBtnSolvent() {
		return btnSolvent;
	}

	public Text getTemperature() {
		return temperature;
	}

	public Button getBtnExternalForce() {
		return btnExternalForce;
	}

	public Text getShearRateY() {
		return shearRateY;
	}

	public Combo getBcY() {
		return bcY;
	}

	public Text getExtForceX() {
		return extForceX;
	}

	public Combo getBcX() {
		return bcX;
	}

	public Text getBrZ() {
		return brZ;
	}

	public Text getShearRateX() {
		return shearRateX;
	}

	public Text getBrX() {
		return brX;
	}

	public Text getExtForceZ() {
		return extForceZ;
	}

	public Text getExtForceY() {
		return extForceY;
	}

	public Text getShearRateZ() {
		return shearRateZ;
	}

	public Text getBrY() {
		return brY;
	}

	public Combo getBcZ() {
		return bcZ;
	}

	public Spinner getSpinnerRandomSeed() {
		return spinnerRandomSeed;
	}

	public Button getBtnRestartSolute() {
		return btnRestartSolute;
	}

	public Button getBtnRestartSolvent() {
		return btnRestartSolvent;
	}
}
