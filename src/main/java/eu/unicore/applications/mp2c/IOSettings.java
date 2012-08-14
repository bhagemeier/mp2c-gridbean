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
package eu.unicore.applications.mp2c;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Spinner;

/**
 * @author bjoernh
 *
 * 26.03.2012 14:54:30
 *
 */
public class IOSettings extends Composite {

	private Button btnGeneral;
	private Button btnSolute;
	private Button btnSolvent;
	private Spinner spnGeneralSteps;
	private Spinner spnSoluteSteps;
	private Spinner spnSolventSteps;
	private Button btnRestartSolute;
	private Button btnRestartSolvent;
	private Combo cmbRestartSoluteType;
	private Combo cmbRestartSolventType;
	private Spinner spnRestartSoluteSteps;
	private Spinner spnRestartSolventSteps;
	private Button btnSoluteHistory;
	private Button btnSolventHistory;
	private Combo cmbSoluteHistoryType;
	private Combo cmbSolventHistoryType;
	private Spinner spnSoluteHistorySteps;
	private Spinner spnSolventHistorySteps;
	private Button btnGeneralXYZ;
	private Button btnSoluteXYZ;
	private Button btnSolventXYZ;
	private Spinner spnGeneralXYZSteps;
	private Spinner spnSoluteXYZSteps;
	private Spinner spnSolventXYZSteps;
	private Combo cmbSoluteXYZType;
	private Combo cmbSolventXYZType;
	private Spinner spnUserOutputSteps;
	private Button btnEndtoendDistances;

	/**
	 * Create the composite.
	 * 
	 * @param parent
	 * @param style
	 * @param io2
	 */
	public IOSettings(Composite parent, int style) {
		super(parent, style);
		setLayout(new GridLayout(1, false));


		Group grpStandardIo = new Group(this, SWT.NONE);
		grpStandardIo.setLayout(new GridLayout(2, false));
		grpStandardIo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false,
				false, 1, 1));
		grpStandardIo.setText("Standard I/O");

		btnGeneral = new Button(grpStandardIo, SWT.CHECK);
		btnGeneral.setText("General");

		spnGeneralSteps = new Spinner(grpStandardIo, SWT.BORDER);
		spnGeneralSteps.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
				false, 1, 1));

		btnSolute = new Button(grpStandardIo, SWT.CHECK);
		btnSolute.setText("Solute");

		spnSoluteSteps = new Spinner(grpStandardIo, SWT.BORDER);
		spnSoluteSteps.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false,
				false, 1, 1));

		btnSolvent = new Button(grpStandardIo, SWT.CHECK);
		btnSolvent.setText("Solvent");

		spnSolventSteps = new Spinner(grpStandardIo, SWT.BORDER);
		spnSolventSteps.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false,
				false, 1, 1));

		Group grpRestartInformation = new Group(this, SWT.NONE);
		grpRestartInformation.setLayout(new GridLayout(3, false));
		grpRestartInformation.setLayoutData(new GridData(SWT.FILL, SWT.CENTER,
				false, false, 1, 1));
		grpRestartInformation.setText("Restart Information");

		btnRestartSolute = new Button(grpRestartInformation, SWT.CHECK);
		btnRestartSolute.setText("Solute");

		cmbRestartSoluteType = new Combo(grpRestartInformation, SWT.NONE);
		cmbRestartSoluteType.setItems(new String[] { "Binary", "ASCII", "SION", "MPI", "5",
				"6" });
		cmbRestartSoluteType.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1,
				1));
		cmbRestartSoluteType.select(0);

		spnRestartSoluteSteps = new Spinner(grpRestartInformation,
				SWT.BORDER);

		btnRestartSolvent = new Button(grpRestartInformation, SWT.CHECK);
		btnRestartSolvent.setText("Solvent");

		cmbRestartSolventType = new Combo(grpRestartInformation, SWT.NONE);
		cmbRestartSolventType.setItems(new String[] { "Binary", "ASCII", "SION", "MPI", "5",
				"6" });
		cmbRestartSolventType.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false,
				1, 1));
		cmbRestartSolventType.select(0);

		spnRestartSolventSteps = new Spinner(grpRestartInformation,
				SWT.BORDER);

		Group grpHistory = new Group(this, SWT.NONE);
		grpHistory.setLayout(new GridLayout(4, false));
		grpHistory.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false,
				false, 1, 1));
		grpHistory.setText("History");
		new Label(grpHistory, SWT.NONE);

		btnSoluteHistory = new Button(grpHistory, SWT.CHECK);
		btnSoluteHistory.setText("Solute");

		cmbSoluteHistoryType = new Combo(grpHistory, SWT.NONE);
		cmbSoluteHistoryType.setItems(new String[] { "Binary", "ASCII", "SION", "MPI", "5",
				"6" });
		cmbSoluteHistoryType.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false,
				1, 1));
		cmbSoluteHistoryType.select(0);

		spnSoluteHistorySteps = new Spinner(grpHistory, SWT.BORDER);
		new Label(grpHistory, SWT.NONE);

		btnSolventHistory = new Button(grpHistory, SWT.CHECK);
		btnSolventHistory.setText("Solvent");

		cmbSolventHistoryType = new Combo(grpHistory, SWT.NONE);
		cmbSolventHistoryType.setItems(new String[] { "Binary", "ASCII", "SION", "MPI", "5",
				"6" });
		cmbSolventHistoryType.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false,
				1, 1));
		cmbSolventHistoryType.select(0);

		spnSolventHistorySteps = new Spinner(grpHistory, SWT.BORDER);

		Group grpXyzFile = new Group(this, SWT.NONE);
		grpXyzFile.setLayout(new GridLayout(5, false));
		grpXyzFile.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false,
				false, 1, 1));
		grpXyzFile.setText("XYZ File");
		new Label(grpXyzFile, SWT.NONE);
		new Label(grpXyzFile, SWT.NONE);

		btnGeneralXYZ = new Button(grpXyzFile, SWT.CHECK);
		btnGeneralXYZ.setText("General");
		new Label(grpXyzFile, SWT.NONE);

		spnGeneralXYZSteps = new Spinner(grpXyzFile, SWT.BORDER);
		new Label(grpXyzFile, SWT.NONE);
		new Label(grpXyzFile, SWT.NONE);

		btnSoluteXYZ = new Button(grpXyzFile, SWT.CHECK);
		btnSoluteXYZ.setText("Solute");

		cmbSoluteXYZType = new Combo(grpXyzFile, SWT.NONE);
		cmbSoluteXYZType.setItems(new String[] { "Binary", "ASCII", "SION", "MPI", "5",
				"6" });
		cmbSoluteXYZType.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false,
				1, 1));
		cmbSoluteXYZType.select(0);

		spnSoluteXYZSteps = new Spinner(grpXyzFile, SWT.BORDER);
		new Label(grpXyzFile, SWT.NONE);
		new Label(grpXyzFile, SWT.NONE);

		btnSolventXYZ = new Button(grpXyzFile, SWT.CHECK);
		btnSolventXYZ.setText("Solvent");

		cmbSolventXYZType = new Combo(grpXyzFile, SWT.NONE);
		cmbSolventXYZType.setItems(new String[] { "Binary", "ASCII", "SION", "MPI", "5",
				"6" });
		cmbSolventXYZType.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false,
				1, 1));
		cmbSolventXYZType.select(0);

		spnSolventXYZSteps = new Spinner(grpXyzFile, SWT.BORDER);

		Group grpUserSpecificOutput = new Group(this, SWT.NONE);
		grpUserSpecificOutput.setLayout(new GridLayout(3, false));
		grpUserSpecificOutput.setLayoutData(new GridData(SWT.FILL, SWT.CENTER,
				false, false, 1, 1));
		grpUserSpecificOutput.setText("User Specific Output");
		new Label(grpUserSpecificOutput, SWT.NONE);

		btnEndtoendDistances = new Button(grpUserSpecificOutput,
				SWT.CHECK);
		btnEndtoendDistances.setText("End-to-end distances");
		new Label(grpUserSpecificOutput, SWT.NONE);
		new Label(grpUserSpecificOutput, SWT.NONE);

		Label lblUserSpecificOutput = new Label(grpUserSpecificOutput, SWT.NONE);
		lblUserSpecificOutput.setText("User specific output interval");

		spnUserOutputSteps = new Spinner(grpUserSpecificOutput,
				SWT.BORDER);
		initDataBindings();

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
	protected DataBindingContext initDataBindings() {
		DataBindingContext bindingContext = new DataBindingContext();
		//
		return bindingContext;
	}

	public Button getBtnSolvent() {
		return btnSolvent;
	}

	public Button getBtnSoluteHistory() {
		return btnSoluteHistory;
	}

	public Button getBtnSolute() {
		return btnSolute;
	}

	public Spinner getSpnUserOutputSteps() {
		return spnUserOutputSteps;
	}

	public Button getBtnRestartSolute() {
		return btnRestartSolute;
	}

	public Combo getCmbRestartSoluteType() {
		return cmbRestartSoluteType;
	}

	public Combo getCmbSolventHistoryType() {
		return cmbSolventHistoryType;
	}

	public Spinner getSpnRestartSoluteSteps() {
		return spnRestartSoluteSteps;
	}

	public Spinner getSpnSoluteHistorySteps() {
		return spnSoluteHistorySteps;
	}

	public Combo getCmbSoluteXYZType() {
		return cmbSoluteXYZType;
	}

	public Spinner getSpnGeneralXYZSteps() {
		return spnGeneralXYZSteps;
	}

	public Spinner getSpnSoluteSteps() {
		return spnSoluteSteps;
	}

	public Button getBtnSolventHistory() {
		return btnSolventHistory;
	}

	public Combo getCmbRestartSolventType() {
		return cmbRestartSolventType;
	}

	public Spinner getSpnSolventHistorySteps() {
		return spnSolventHistorySteps;
	}

	public Spinner getSpnRestartSolventSteps() {
		return spnRestartSolventSteps;
	}

	public Button getBtnEndtoendDistances() {
		return btnEndtoendDistances;
	}

	public Button getBtnRestartSolvent() {
		return btnRestartSolvent;
	}

	public Spinner getSpnSoluteXYZSteps() {
		return spnSoluteXYZSteps;
	}

	public Spinner getSpnSolventXYZSteps() {
		return spnSolventXYZSteps;
	}

	public Combo getCmbSolventXYZType() {
		return cmbSolventXYZType;
	}

	public Spinner getSpnSolventSteps() {
		return spnSolventSteps;
	}

	public Button getBtnGeneralXYZ() {
		return btnGeneralXYZ;
	}

	public Combo getCmbSoluteHistoryType() {
		return cmbSoluteHistoryType;
	}

	public Button getBtnSolventXYZ() {
		return btnSolventXYZ;
	}

	public Button getBtnGeneral() {
		return btnGeneral;
	}

	public Spinner getSpnGeneralSteps() {
		return spnGeneralSteps;
	}

	public Button getBtnSoluteXYZ() {
		return btnSoluteXYZ;
	}
}
