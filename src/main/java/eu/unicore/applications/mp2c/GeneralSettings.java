package eu.unicore.applications.mp2c;

import java.util.Random;

import mp2c_1_0.Control;
import mp2c_1_0.Mp2c_1_0Package.Literals;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.core.databinding.beans.PojoProperties;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.databinding.EMFObservables;
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

import eu.unicore.applications.mp2c.converters.DoubleToStringConverter;
import eu.unicore.applications.mp2c.converters.StringToDoubleConverter;

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
	private Control generalConfig;
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
	private Spinner temperature;
	private Spinner collisionSteps;

	/**
	 * Create the composite.
	 * 
	 * @param parent
	 * @param style
	 * @param generalConfig2
	 */
	public GeneralSettings(Composite parent, int style,
 Control generalConfig2) {
		super(parent, style);
		setLayout(new GridLayout(1, false));
		
		this.generalConfig = generalConfig2;
		
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
		GridData gd_nrTimeStepsSpinner = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
		gd_nrTimeStepsSpinner.widthHint = 48;
		nrTimeStepsSpinner.setLayoutData(gd_nrTimeStepsSpinner);
		nrTimeStepsSpinner.setMaximum(100000);
		
		btnSolvent = new Button(grpGeneral, SWT.CHECK);
		btnSolvent.setText("Solvent");
		
		Label lblTemperature = new Label(grpGeneral, SWT.NONE);
		lblTemperature.setText("Temperature");
		
		temperature = new Spinner(grpGeneral, SWT.BORDER);
		GridData gd_temperature = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
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
		
		bcX = new Combo(grpDimensions, SWT.NONE);
		bcX.setItems(new String[] {"Periodic", "Bounce-back", "Reflective", "Shear"});
		bcX.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		bcX.select(1);
		
		bcY = new Combo(grpDimensions, SWT.NONE);
		bcY.setItems(new String[] {"Periodic", "Bounce-back", "Reflective", "Shear"});
		bcY.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		bcY.select(1);
		
		bcZ = new Combo(grpDimensions, SWT.NONE);
		bcZ.setItems(new String[] {"Periodic", "Bounce-back", "Reflective", "Shear"});
		bcZ.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		bcZ.select(1);
		new Label(grpDimensions, SWT.NONE);
		
		Label lblExternalForce = new Label(grpDimensions, SWT.NONE);
		lblExternalForce.setText("External force");
		
		extForceX = new Text(grpDimensions, SWT.BORDER);
		extForceX.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		extForceY = new Text(grpDimensions, SWT.BORDER);
		extForceY.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		extForceZ = new Text(grpDimensions, SWT.BORDER);
		extForceZ.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(grpDimensions, SWT.NONE);
		
		Label lblShearRate = new Label(grpDimensions, SWT.NONE);
		lblShearRate.setText("Shear rate");
		
		shearRateX = new Text(grpDimensions, SWT.BORDER);
		shearRateX.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		shearRateY = new Text(grpDimensions, SWT.BORDER);
		shearRateY.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		shearRateZ = new Text(grpDimensions, SWT.BORDER);
		shearRateZ.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
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
		
		Button btnRandomize = new Button(grpOther, SWT.NONE);
		btnRandomize.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				spinnerRandomSeed.setSelection(new Random().nextInt());
			}
		});
		btnRandomize.setText("Randomize");
		new Label(grpOther, SWT.NONE);
		
		Label fillLabel = new Label(grpOther, SWT.NONE);
		fillLabel.setText("  ");
		fillLabel.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(grpOther, SWT.NONE);
		new Label(grpOther, SWT.NONE);
		new Label(grpOther, SWT.NONE);
		
		btnRestartSolvent = new Button(grpOther, SWT.CHECK);
		btnRestartSolvent.setText("Restart solvent");
		new Label(grpOther, SWT.NONE);
		new Label(grpOther, SWT.NONE);
		new Label(grpOther, SWT.NONE);
		new Label(grpOther, SWT.NONE);
		
		Button btnPrintconfig = new Button(this, SWT.NONE);
		btnPrintconfig.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				System.out.println(generalConfig.toString());
			}
		});
		btnPrintconfig.setText("PrintConfig");
		m_bindingContext = initDataBindings();

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
	protected DataBindingContext initDataBindings() {
		DataBindingContext bindingContext = new DataBindingContext();
		//
		IObservableValue observeSelectionBcXObserveWidget = WidgetProperties
				.selection().observe(bcX);
		IObservableValue generalConfigBoundaryConditionsObserveValue = EMFObservables
				.observeValue(generalConfig,
						Literals.CONTROL__BOUNDARY_CONDITION_X);
		bindingContext.bindValue(observeSelectionBcXObserveWidget,
				generalConfigBoundaryConditionsObserveValue, null, null);
		//
		IObservableValue observeSelectionBcYObserveWidget = WidgetProperties
				.selection().observe(bcY);
		IObservableValue generalConfigBoundaryConditionYObserveValue = EMFObservables
				.observeValue(generalConfig,
						Literals.CONTROL__BOUNDARY_CONDITION_Y);
		bindingContext.bindValue(observeSelectionBcYObserveWidget,
				generalConfigBoundaryConditionYObserveValue, null, null);
		//
		IObservableValue observeSelectionBcZObserveWidget = WidgetProperties
				.selection().observe(bcZ);
		IObservableValue generalConfigBoundaryConditionZObserveValue = EMFObservables
				.observeValue(generalConfig,
						Literals.CONTROL__BOUNDARY_CONDITION_Z);
		bindingContext.bindValue(observeSelectionBcZObserveWidget,
				generalConfigBoundaryConditionZObserveValue, null, null);
		//
		IObservableValue observeTextBrXObserveWidget = WidgetProperties.text(
				SWT.Modify).observe(brX);
		IObservableValue generalConfigBoxRatioXObserveValue = EMFObservables
				.observeValue(generalConfig, Literals.CONTROL__BOX_RATIO_X);
		UpdateValueStrategy strategy_1 = new UpdateValueStrategy();
		strategy_1.setConverter(new StringToDoubleConverter());
		UpdateValueStrategy strategy = new UpdateValueStrategy();
		strategy.setConverter(new DoubleToStringConverter());
		bindingContext.bindValue(observeTextBrXObserveWidget,
				generalConfigBoxRatioXObserveValue, strategy_1, strategy);
		//
		IObservableValue observeTextBrYObserveWidget = WidgetProperties.text(
				SWT.Modify).observe(brY);
		IObservableValue generalConfigBoxRatioYObserveValue = EMFObservables
				.observeValue(generalConfig, Literals.CONTROL__BOX_RATIO_Y);
		UpdateValueStrategy strategy_2 = new UpdateValueStrategy();
		strategy_2.setConverter(new StringToDoubleConverter());
		UpdateValueStrategy strategy_3 = new UpdateValueStrategy();
		strategy_3.setConverter(new DoubleToStringConverter());
		bindingContext.bindValue(observeTextBrYObserveWidget,
				generalConfigBoxRatioYObserveValue, strategy_2, strategy_3);
		//
		IObservableValue observeTextBrZObserveWidget = WidgetProperties.text(
				SWT.Modify).observe(brZ);
		IObservableValue generalConfigBoxRatioZObserveValue = EMFObservables
				.observeValue(generalConfig, Literals.CONTROL__BOX_RATIO_Z);
		UpdateValueStrategy strategy_4 = new UpdateValueStrategy();
		strategy_4.setConverter(new StringToDoubleConverter());
		UpdateValueStrategy strategy_5 = new UpdateValueStrategy();
		strategy_5.setConverter(new DoubleToStringConverter());
		bindingContext.bindValue(observeTextBrZObserveWidget,
				generalConfigBoxRatioZObserveValue, strategy_4, strategy_5);
		//
		IObservableValue observeSelectionBtnExternalForceObserveWidget = WidgetProperties
				.selection().observe(btnExternalForce);
		IObservableValue generalConfigExternalForceObserveValue = EMFObservables
				.observeValue(generalConfig, Literals.CONTROL__EXTERNAL_FORCE);
		bindingContext.bindValue(observeSelectionBtnExternalForceObserveWidget,
				generalConfigExternalForceObserveValue, null, null);
		//
		IObservableValue observeTextExtForceXObserveWidget = WidgetProperties
				.text(SWT.Modify).observe(extForceX);
		IObservableValue generalConfigExternalForceXObserveValue = EMFObservables
				.observeValue(generalConfig, Literals.CONTROL__EXTERNAL_FORCE_X);
		UpdateValueStrategy strategy_6 = new UpdateValueStrategy();
		strategy_6.setConverter(new StringToDoubleConverter());
		UpdateValueStrategy strategy_7 = new UpdateValueStrategy();
		strategy_7.setConverter(new DoubleToStringConverter());
		bindingContext
				.bindValue(observeTextExtForceXObserveWidget,
						generalConfigExternalForceXObserveValue, strategy_6,
						strategy_7);
		//
		IObservableValue observeTextExtForceYObserveWidget = WidgetProperties
				.text(SWT.Modify).observe(extForceY);
		IObservableValue generalConfigExternalForceYObserveValue = EMFObservables
				.observeValue(generalConfig, Literals.CONTROL__EXTERNAL_FORCE_Y);
		UpdateValueStrategy strategy_8 = new UpdateValueStrategy();
		strategy_8.setConverter(new StringToDoubleConverter());
		UpdateValueStrategy strategy_9 = new UpdateValueStrategy();
		strategy_9.setConverter(new DoubleToStringConverter());
		bindingContext
				.bindValue(observeTextExtForceYObserveWidget,
						generalConfigExternalForceYObserveValue, strategy_8,
						strategy_9);
		//
		IObservableValue observeTextExtForceZObserveWidget = WidgetProperties
				.text(SWT.Modify).observe(extForceZ);
		IObservableValue generalConfigExternalForceZObserveValue = EMFObservables
				.observeValue(generalConfig, Literals.CONTROL__EXTERNAL_FORCE_Z);
		UpdateValueStrategy strategy_10 = new UpdateValueStrategy();
		strategy_10.setConverter(new StringToDoubleConverter());
		UpdateValueStrategy strategy_11 = new UpdateValueStrategy();
		strategy_11.setConverter(new DoubleToStringConverter());
		bindingContext.bindValue(observeTextExtForceZObserveWidget,
				generalConfigExternalForceZObserveValue, strategy_10,
				strategy_11);
		//
		IObservableValue observeTextShearRateXObserveWidget = WidgetProperties
				.text(SWT.Modify).observe(shearRateX);
		IObservableValue generalConfigShearRateXObserveValue = EMFObservables
				.observeValue(generalConfig, Literals.CONTROL__SHEAR_RATE_X);
		UpdateValueStrategy strategy_12 = new UpdateValueStrategy();
		strategy_12.setConverter(new StringToDoubleConverter());
		UpdateValueStrategy strategy_13 = new UpdateValueStrategy();
		strategy_13.setConverter(new DoubleToStringConverter());
		bindingContext.bindValue(observeTextShearRateXObserveWidget,
				generalConfigShearRateXObserveValue, strategy_12, strategy_13);
		//
		IObservableValue observeTextShearRateYObserveWidget = WidgetProperties
				.text(SWT.Modify).observe(shearRateY);
		IObservableValue generalConfigShearRateYObserveValue = EMFObservables
				.observeValue(generalConfig, Literals.CONTROL__SHEAR_RATE_Y);
		UpdateValueStrategy strategy_14 = new UpdateValueStrategy();
		strategy_14.setConverter(new StringToDoubleConverter());
		UpdateValueStrategy strategy_15 = new UpdateValueStrategy();
		strategy_15.setConverter(new DoubleToStringConverter());
		bindingContext.bindValue(observeTextShearRateYObserveWidget,
				generalConfigShearRateYObserveValue, strategy_14, strategy_15);
		//
		IObservableValue observeTextShearRateZObserveWidget = WidgetProperties
				.text(SWT.Modify).observe(shearRateZ);
		IObservableValue generalConfigShearRateZObserveValue = EMFObservables
				.observeValue(generalConfig, Literals.CONTROL__SHEAR_RATE_Z);
		UpdateValueStrategy strategy_16 = new UpdateValueStrategy();
		strategy_16.setConverter(new StringToDoubleConverter());
		UpdateValueStrategy strategy_17 = new UpdateValueStrategy();
		strategy_17.setConverter(new DoubleToStringConverter());
		bindingContext.bindValue(observeTextShearRateZObserveWidget,
				generalConfigShearRateZObserveValue, strategy_16, strategy_17);
		//
		IObservableValue observeSelectionBtnRestartSoluteObserveWidget = WidgetProperties
				.selection().observe(btnRestartSolute);
		IObservableValue generalConfigRestartSoluteObserveValue = EMFObservables
				.observeValue(generalConfig, Literals.CONTROL__RESTART_SOLUTE);
		bindingContext.bindValue(observeSelectionBtnRestartSoluteObserveWidget,
				generalConfigRestartSoluteObserveValue, null, null);
		//
		IObservableValue observeSelectionBtnRestartSolventObserveWidget = WidgetProperties
				.selection().observe(btnRestartSolvent);
		IObservableValue generalConfigRestartSolventObserveValue = EMFObservables
				.observeValue(generalConfig, Literals.CONTROL__RESTART_SOLVENT);
		bindingContext.bindValue(
				observeSelectionBtnRestartSolventObserveWidget,
				generalConfigRestartSolventObserveValue, null, null);
		//
		IObservableValue observeSelectionSpinnerRandomSeedObserveWidget = WidgetProperties
				.selection().observe(spinnerRandomSeed);
		IObservableValue generalConfigRandomSeedObserveValue = EMFObservables
				.observeValue(generalConfig, Literals.CONTROL__RANDOM_SEED);
		bindingContext.bindValue(
				observeSelectionSpinnerRandomSeedObserveWidget,
				generalConfigRandomSeedObserveValue, null, null);
		//
		IObservableValue observeSelectionBtnSoluteObserveWidget = WidgetProperties
				.selection().observe(btnSolute);
		IObservableValue generalConfigSimulateSoluteObserveValue = EMFObservables
				.observeValue(generalConfig, Literals.CONTROL__SIMULATE_SOLUTE);
		bindingContext.bindValue(observeSelectionBtnSoluteObserveWidget,
				generalConfigSimulateSoluteObserveValue, null, null);
		//
		IObservableValue observeSelectionBtnSolventObserveWidget = WidgetProperties
				.selection().observe(btnSolvent);
		IObservableValue generalConfigSimulateSolventObserveValue = EMFObservables
				.observeValue(generalConfig, Literals.CONTROL__SIMULATE_SOLVENT);
		bindingContext.bindValue(observeSelectionBtnSolventObserveWidget,
				generalConfigSimulateSolventObserveValue, null, null);
		//
		IObservableValue observeSelectionNrTimeStepsSpinnerObserveWidget = WidgetProperties
				.selection().observe(nrTimeStepsSpinner);
		IObservableValue generalConfigTimeStepsObserveValue = EMFObservables
				.observeValue(generalConfig, Literals.CONTROL__TIME_STEPS);
		bindingContext.bindValue(
				observeSelectionNrTimeStepsSpinnerObserveWidget,
				generalConfigTimeStepsObserveValue, null, null);
		//
		IObservableValue observeSelectionTemperatureObserveWidget = WidgetProperties
				.selection().observe(temperature);
		IObservableValue generalConfigTemperatureObserveValue = EMFObservables
				.observeValue(generalConfig, Literals.CONTROL__TEMPERATURE);
		bindingContext.bindValue(observeSelectionTemperatureObserveWidget,
				generalConfigTemperatureObserveValue, null, null);
		//
		IObservableValue observeSelectionCollisionStepsObserveWidget = WidgetProperties
				.selection().observe(collisionSteps);
		IObservableValue generalConfigCollisionStepsIntervalObserveValue = EMFObservables
				.observeValue(generalConfig,
						Literals.CONTROL__COLLISION_STEPS_INTERVAL);
		bindingContext.bindValue(observeSelectionCollisionStepsObserveWidget,
				generalConfigCollisionStepsIntervalObserveValue, null, null);
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
}
