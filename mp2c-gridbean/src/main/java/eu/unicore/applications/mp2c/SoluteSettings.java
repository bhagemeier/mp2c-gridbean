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

import mp2c_1_0.Mp2c_1_0Factory;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;

/**
 * @author bjoernh
 * 
 *         26.03.2012 13:30:44
 * 
 */
public class SoluteSettings extends Composite {
	private DataBindingContext m_bindingContext;

	private mp2c_1_0.Solute solute;
	private Button btnUsualLjp;
	private Button btnShiftedLjp;
	private Button btnLjShiftedForce;
	private Button btnRadiusShiftedLjp;
	private Button btnRadiusShiftedLjShifted;
	private Button btnRadiusShiftedLjShiftedForce;
	private Group group;
	private Group grpVanderwaalsPotentials;

	/**
	 * Create the composite.
	 * 
	 * @param parent
	 * @param style
	 * @param solute2
	 */
	public SoluteSettings(Composite parent, int style, mp2c_1_0.Solute solute2) {
		super(parent, style);
		setLayout(new GridLayout(2, false));

		this.solute = solute2;

		Group grpMolecularSpecies = new Group(this, SWT.NONE);
		grpMolecularSpecies.setLayoutData(new GridData(SWT.FILL, SWT.FILL,
				true, true, 1, 2));
		grpMolecularSpecies.setText("Molecular Species");
		grpMolecularSpecies.setLayout(new FillLayout(SWT.HORIZONTAL));

		final TabFolder tabFolder = new TabFolder(grpMolecularSpecies,
				SWT.BORDER);

		Button btnAddSpecies = new Button(this, SWT.NONE);
		btnAddSpecies.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				// Add a Molecular species Tab
				TabItem ti = new TabItem(tabFolder, SWT.NONE);
				ti.setText("Molecular Species");
				// MolecularSpecies species = new MolecularSpecies();
				mp2c_1_0.MolecularSpecies species = Mp2c_1_0Factory.eINSTANCE
						.createMolecularSpecies();
				solute.getSpecies().add(species);
				MolecularSpeciesTab molSpecTab = new MolecularSpeciesTab(
						tabFolder, SWT.NONE, species);
				ti.setControl(molSpecTab);
			}
		});
		btnAddSpecies.setLayoutData(new GridData(SWT.FILL, SWT.TOP, false,
				false, 1, 1));
		btnAddSpecies.setText("Add species");

		Button btnRemoveSpecies = new Button(this, SWT.NONE);
		btnRemoveSpecies
				.setToolTipText("Remove the currently selected molecular species.");
		btnRemoveSpecies.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				// Remove currently selected Molecular Species Tab
				if (tabFolder.getSelectionIndex() >= 0) {
					TabItem ti = tabFolder.getItem(tabFolder
							.getSelectionIndex());
					MolecularSpeciesTab mst = (MolecularSpeciesTab) ti
							.getControl();
					solute.getSpecies().remove(mst.getSpecies());
					ti.dispose();
				}
			}
		});
		btnRemoveSpecies.setLayoutData(new GridData(SWT.FILL, SWT.TOP, false,
				false, 1, 1));
		btnRemoveSpecies.setText("Remove species");

		group = new Group(this, SWT.NONE);
		group.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 2, 1));
		group.setLayout(new GridLayout(1, false));

		grpVanderwaalsPotentials = new Group(group, SWT.NONE);
		grpVanderwaalsPotentials.setText("Van-der-Waals Potentials");
		grpVanderwaalsPotentials.setLayoutData(new GridData(SWT.FILL,
				SWT.CENTER, true, true, 1, 1));
		grpVanderwaalsPotentials.setLayout(new GridLayout(3, false));

		btnShiftedLjp = new Button(grpVanderwaalsPotentials, SWT.CHECK);
		btnShiftedLjp.setText("Shifted LJP");
		new Label(grpVanderwaalsPotentials, SWT.NONE);

		btnUsualLjp = new Button(grpVanderwaalsPotentials, SWT.CHECK);
		btnUsualLjp.setText("Usual LJP");

		btnRadiusShiftedLjp = new Button(grpVanderwaalsPotentials, SWT.CHECK);
		btnRadiusShiftedLjp.setText("Radius Shifted LJP");
		new Label(grpVanderwaalsPotentials, SWT.NONE);

		btnLjShiftedForce = new Button(grpVanderwaalsPotentials, SWT.CHECK);
		btnLjShiftedForce.setText("LJ Shifted Force");

		btnRadiusShiftedLjShiftedForce = new Button(grpVanderwaalsPotentials,
				SWT.CHECK);
		btnRadiusShiftedLjShiftedForce
				.setText("Radius Shifted LJ Shifted Force");
		new Label(grpVanderwaalsPotentials, SWT.NONE);

		btnRadiusShiftedLjShifted = new Button(grpVanderwaalsPotentials,
				SWT.CHECK);
		btnRadiusShiftedLjShifted.setLayoutData(new GridData(SWT.FILL,
				SWT.FILL, false, false, 1, 1));
		btnRadiusShiftedLjShifted.setText("Radius Shifted LJ Shifted");
		m_bindingContext = initDataBindings();

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

	protected DataBindingContext initDataBindings() {
		DataBindingContext bindingContext = new DataBindingContext();
		//

		//
		return bindingContext;
	}

	public Button getBtnUsualLjp() {
		return btnUsualLjp;
	}

	public Button getBtnShiftedLjp() {
		return btnShiftedLjp;
	}

	public Button getBtnRadiusShiftedLjp() {
		return btnRadiusShiftedLjp;
	}

	public Button getBtnRadiusShiftedLjShiftedForce() {
		return btnRadiusShiftedLjShiftedForce;
	}

	public Button getBtnLjShiftedForce() {
		return btnLjShiftedForce;
	}

	public Button getBtnRadiusShiftedLjShifted() {
		return btnRadiusShiftedLjShifted;
	}
}
