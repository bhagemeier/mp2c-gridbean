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

import eu.unicore.applications.mp2c.converters.DoubleToStringConverter;
import eu.unicore.applications.mp2c.converters.StringToDoubleConverter;
import eu.unicore.applications.mp2c.model.Control;

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
		spinnerRandomSeed.setSelection(generalConfig.getRandomSeed());
		
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
		fillLabel.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
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
		IObservableValue observeSelectionBtnSoluteObserveWidget = WidgetProperties
				.selection().observe(btnSolute);
		IObservableValue simulateSoluteGeneralConfigObserveValue = PojoProperties
				.value("simulateSolute").observe(generalConfig);
		bindingContext.bindValue(observeSelectionBtnSoluteObserveWidget,
				simulateSoluteGeneralConfigObserveValue, null, null);
		//
		IObservableValue observeSelectionNrTimeStepsSpinnerObserveWidget = WidgetProperties
				.selection().observe(nrTimeStepsSpinner);
		IObservableValue timeStepsGeneralConfigObserveValue = PojoProperties
				.value("timeSteps").observe(generalConfig);
		bindingContext.bindValue(
				observeSelectionNrTimeStepsSpinnerObserveWidget,
				timeStepsGeneralConfigObserveValue, null, null);
		//
		IObservableValue observeSelectionBtnSolventObserveWidget = WidgetProperties
				.selection().observe(btnSolvent);
		IObservableValue simulateSolventGeneralConfigObserveValue = PojoProperties
				.value("simulateSolvent").observe(generalConfig);
		bindingContext.bindValue(observeSelectionBtnSolventObserveWidget,
				simulateSolventGeneralConfigObserveValue, null, null);
		//
		IObservableValue observeSelectionTemperatureObserveWidget = WidgetProperties
				.selection().observe(temperature);
		IObservableValue temperatureGeneralConfigObserveValue = PojoProperties
				.value("temperature").observe(generalConfig);
		bindingContext.bindValue(observeSelectionTemperatureObserveWidget,
				temperatureGeneralConfigObserveValue, null, null);
		//
		IObservableValue observeSelectionCollisionStepsObserveWidget = WidgetProperties
				.selection().observe(collisionSteps);
		IObservableValue collisionStepsGeneralConfigObserveValue = PojoProperties
				.value("collisionSteps").observe(generalConfig);
		bindingContext.bindValue(observeSelectionCollisionStepsObserveWidget,
				collisionStepsGeneralConfigObserveValue, null, null);
		//
		IObservableValue observeTextBrXObserveWidget = WidgetProperties.text(
				SWT.Modify).observe(brX);
		IObservableValue boxRatioXGeneralConfigObserveValue = PojoProperties
				.value("boxRatioX").observe(generalConfig);
		UpdateValueStrategy strategy = new UpdateValueStrategy();
		strategy.setConverter(new StringToDoubleConverter());
		UpdateValueStrategy strategy_1 = new UpdateValueStrategy();
		strategy_1.setConverter(new DoubleToStringConverter());
		bindingContext.bindValue(observeTextBrXObserveWidget,
				boxRatioXGeneralConfigObserveValue, strategy, strategy_1);
		//
		IObservableValue observeTextBrYObserveWidget = WidgetProperties.text(
				SWT.Modify).observe(brY);
		IObservableValue boxRatioYGeneralConfigObserveValue = PojoProperties
				.value("boxRatioY").observe(generalConfig);
		UpdateValueStrategy strategy_2 = new UpdateValueStrategy();
		strategy_2.setConverter(new StringToDoubleConverter());
		UpdateValueStrategy strategy_3 = new UpdateValueStrategy();
		strategy_3.setConverter(new DoubleToStringConverter());
		bindingContext.bindValue(observeTextBrYObserveWidget,
				boxRatioYGeneralConfigObserveValue, strategy_2, strategy_3);
		//
		IObservableValue observeTextBrZObserveWidget = WidgetProperties.text(
				SWT.Modify).observe(brZ);
		IObservableValue boxRatioZGeneralConfigObserveValue = PojoProperties
				.value("boxRatioZ").observe(generalConfig);
		UpdateValueStrategy strategy_4 = new UpdateValueStrategy();
		strategy_4.setConverter(new StringToDoubleConverter());
		UpdateValueStrategy strategy_5 = new UpdateValueStrategy();
		strategy_5.setConverter(new DoubleToStringConverter());
		bindingContext.bindValue(observeTextBrZObserveWidget,
				boxRatioZGeneralConfigObserveValue, strategy_4, strategy_5);
		//
		IObservableValue observeSelectionBcXObserveWidget = WidgetProperties
				.selection().observe(bcX);
		IObservableValue bcXGeneralConfigObserveValue = PojoProperties.value(
				"bcX").observe(generalConfig);
		bindingContext.bindValue(observeSelectionBcXObserveWidget,
				bcXGeneralConfigObserveValue, null, null);
		//
		IObservableValue observeSelectionBcYObserveWidget = WidgetProperties
				.selection().observe(bcY);
		IObservableValue bcYGeneralConfigObserveValue = PojoProperties.value(
				"bcY").observe(generalConfig);
		bindingContext.bindValue(observeSelectionBcYObserveWidget,
				bcYGeneralConfigObserveValue, null, null);
		//
		IObservableValue observeSelectionBcZObserveWidget = WidgetProperties
				.selection().observe(bcZ);
		IObservableValue bcZGeneralConfigObserveValue = PojoProperties.value(
				"bcZ").observe(generalConfig);
		bindingContext.bindValue(observeSelectionBcZObserveWidget,
				bcZGeneralConfigObserveValue, null, null);
		//
		IObservableValue observeTextExtForceXObserveWidget = WidgetProperties
				.text(SWT.Modify).observe(extForceX);
		IObservableValue externalForceXGeneralConfigObserveValue = PojoProperties
				.value("externalForceX").observe(generalConfig);
		UpdateValueStrategy strategy_6 = new UpdateValueStrategy();
		strategy_6.setConverter(new StringToDoubleConverter());
		UpdateValueStrategy strategy_7 = new UpdateValueStrategy();
		strategy_7.setConverter(new DoubleToStringConverter());
		bindingContext
				.bindValue(observeTextExtForceXObserveWidget,
						externalForceXGeneralConfigObserveValue, strategy_6,
						strategy_7);
		//
		IObservableValue observeTextExtForceYObserveWidget = WidgetProperties
				.text(SWT.Modify).observe(extForceY);
		IObservableValue externalForceYGeneralConfigObserveValue = PojoProperties
				.value("externalForceY").observe(generalConfig);
		UpdateValueStrategy strategy_8 = new UpdateValueStrategy();
		strategy_8.setConverter(new StringToDoubleConverter());
		UpdateValueStrategy strategy_9 = new UpdateValueStrategy();
		strategy_9.setConverter(new DoubleToStringConverter());
		bindingContext
				.bindValue(observeTextExtForceYObserveWidget,
						externalForceYGeneralConfigObserveValue, strategy_8,
						strategy_9);
		//
		IObservableValue observeTextExtForceZObserveWidget = WidgetProperties
				.text(SWT.Modify).observe(extForceZ);
		IObservableValue externalForceZGeneralConfigObserveValue = PojoProperties
				.value("externalForceZ").observe(generalConfig);
		UpdateValueStrategy strategy_10 = new UpdateValueStrategy();
		strategy_10.setConverter(new StringToDoubleConverter());
		UpdateValueStrategy strategy_11 = new UpdateValueStrategy();
		strategy_11.setConverter(new DoubleToStringConverter());
		bindingContext.bindValue(observeTextExtForceZObserveWidget,
				externalForceZGeneralConfigObserveValue, strategy_10,
				strategy_11);
		//
		IObservableValue observeTextShearRateXObserveWidget = WidgetProperties
				.text(SWT.Modify).observe(shearRateX);
		IObservableValue shearRateXGeneralConfigObserveValue = PojoProperties
				.value("shearRateX").observe(generalConfig);
		UpdateValueStrategy strategy_12 = new UpdateValueStrategy();
		strategy_12.setConverter(new StringToDoubleConverter());
		UpdateValueStrategy strategy_13 = new UpdateValueStrategy();
		strategy_13.setConverter(new DoubleToStringConverter());
		bindingContext.bindValue(observeTextShearRateXObserveWidget,
				shearRateXGeneralConfigObserveValue, strategy_12, strategy_13);
		//
		IObservableValue observeTextShearRateYObserveWidget = WidgetProperties
				.text(SWT.Modify).observe(shearRateY);
		IObservableValue shearRateYGeneralConfigObserveValue = PojoProperties
				.value("shearRateY").observe(generalConfig);
		UpdateValueStrategy strategy_14 = new UpdateValueStrategy();
		strategy_14.setConverter(new StringToDoubleConverter());
		UpdateValueStrategy strategy_15 = new UpdateValueStrategy();
		strategy_15.setConverter(new DoubleToStringConverter());
		bindingContext.bindValue(observeTextShearRateYObserveWidget,
				shearRateYGeneralConfigObserveValue, strategy_14, strategy_15);
		//
		IObservableValue observeTextShearRateZObserveWidget = WidgetProperties
				.text(SWT.Modify).observe(shearRateZ);
		IObservableValue shearRateZGeneralConfigObserveValue = PojoProperties
				.value("shearRateZ").observe(generalConfig);
		UpdateValueStrategy strategy_16 = new UpdateValueStrategy();
		strategy_16.setConverter(new StringToDoubleConverter());
		UpdateValueStrategy strategy_17 = new UpdateValueStrategy();
		strategy_17.setConverter(new DoubleToStringConverter());
		bindingContext.bindValue(observeTextShearRateZObserveWidget,
				shearRateZGeneralConfigObserveValue, strategy_16, strategy_17);
		//
		IObservableValue observeSelectionSpinnerRandomSeedObserveWidget = WidgetProperties
				.selection().observe(spinnerRandomSeed);
		IObservableValue randomSeedGeneralConfigObserveValue = PojoProperties
				.value("randomSeed").observe(generalConfig);
		bindingContext.bindValue(
				observeSelectionSpinnerRandomSeedObserveWidget,
				randomSeedGeneralConfigObserveValue, null, null);
		//
		return bindingContext;
	}
}
