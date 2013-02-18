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

import mp2c_1_0.Atom;
import mp2c_1_0.MolecularSpecies;
import mp2c_1_0.Mp2c_1_0Factory;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

/**
 * @author bjoernh
 * 
 *         26.03.2012 13:32:43
 * 
 */
public class MolecularSpeciesTab extends Composite {

	private DataBindingContext m_bindingContext;
	private Spinner spnNumberSites;
	private Label lblBonds;
	private MolecularSpecies species;
	private Spinner spnNumberAtoms;
	private Table atomTable;
	private TableViewer atomTableViewer;
	private Table bondsTable;
	private TableViewer bondsTableViewer;
	private TableViewerColumn tvcAtomIdentifier;
	private TableViewerColumn tvcAtomSymbol;
	private TableViewerColumn tvcAtomRangeFrom;
	private TableViewerColumn tvcAtomRangeTo;
	private TableViewerColumn tvcAtomMass;
	private TableViewerColumn tvcAtomCharge;
	private TableViewerColumn tvcBondType;
	private TableViewerColumn tvcBondNumber;
	private TableViewerColumn tvcBondRangeFrom;
	private TableViewerColumn tvcBondRangeTo;
	private TableViewerColumn tvcBondR;
	private TableViewerColumn tvcBondK;
	private TableColumn tblclmnIdentifier;

	/**
	 * Create the composite.
	 * 
	 * @param parent
	 * @param style
	 */
	public MolecularSpeciesTab(Composite parent, int style,
			MolecularSpecies species2) {
		super(parent, style);
		setLayout(new GridLayout(5, false));

		this.species = species2;

		createComposite(parent);

		Label lblNumber = new Label(this, SWT.NONE);
		lblNumber.setText("Number");

		spnNumberAtoms = new Spinner(this, SWT.BORDER);

		Label lblSites = new Label(this, SWT.NONE);
		lblSites.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false,
				1, 1));
		lblSites.setSize(654, 544);
		lblSites.setText("Sites");
		new Label(this, SWT.NONE);

		spnNumberSites = new Spinner(this, SWT.BORDER);
		spnNumberSites.setSize(654, 544);

		Label lblAtom = new Label(this, SWT.NONE);
		lblAtom.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, false, 1,
				1));
		lblAtom.setSize(654, 544);
		lblAtom.setText("Atom");

		atomTableViewer = new TableViewer(this, SWT.BORDER | SWT.FULL_SELECTION
				| SWT.MULTI | SWT.V_SCROLL | SWT.H_SCROLL);

		atomTableViewer.setContentProvider(new ArrayContentProvider());

		atomTable = atomTableViewer.getTable();
		atomTable.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 4,
				1));
		atomTable.setSize(654, 544);
		atomTable.setLinesVisible(true);
		atomTable.setHeaderVisible(true);

		Menu menu_1 = new Menu(atomTable);
		atomTable.setMenu(menu_1);

		MenuItem mntmAddAtom = new MenuItem(menu_1, SWT.NONE);
		mntmAddAtom.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				species.getAtoms().add(Mp2c_1_0Factory.eINSTANCE.createAtom());
				atomTableViewer.refresh();
			}
		});
		mntmAddAtom.setText("Add Atom");

		MenuItem mntmRemoveAtom = new MenuItem(menu_1, SWT.NONE);
		mntmRemoveAtom.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				for (TableItem atomTi : atomTable.getSelection()) {
					species.getAtoms().remove(atomTi.getData());

				}
				atomTableViewer.refresh();
			}
		});
		mntmRemoveAtom.setText("Remove Atom");

		tvcAtomIdentifier = new TableViewerColumn(atomTableViewer, SWT.NONE);
		tvcAtomIdentifier.setLabelProvider(new ColumnLabelProvider() {
			public Image getImage(Object element) {
				// TODO Auto-generated method stub
				return null;
			}

			public String getText(Object element) {
				return element == null ? "" : ((Atom) element).getIdentifier();
			}
		});
		tblclmnIdentifier = tvcAtomIdentifier.getColumn();
		tblclmnIdentifier.setWidth(100);
		tblclmnIdentifier.setText("Identifier");

		tvcAtomSymbol = new TableViewerColumn(atomTableViewer, SWT.NONE);
		tvcAtomSymbol.setLabelProvider(new ColumnLabelProvider() {
			public Image getImage(Object element) {
				// TODO Auto-generated method stub
				return null;
			}

			public String getText(Object element) {
				return element == null ? "" : ((Atom) element).getSymbol();
			}
		});
		TableColumn tblclmnSymbol = tvcAtomSymbol.getColumn();
		tblclmnSymbol.setWidth(100);
		tblclmnSymbol.setText("Symbol");

		tvcAtomRangeFrom = new TableViewerColumn(atomTableViewer, SWT.NONE);
		tvcAtomRangeFrom.setLabelProvider(new ColumnLabelProvider() {
			public Image getImage(Object element) {
				// TODO Auto-generated method stub
				return null;
			}

			public String getText(Object element) {
				return element == null ? "" : Integer.toString(((Atom) element)
						.getFromRange());
			}
		});
		TableColumn tblclmnRangeFrom_1 = tvcAtomRangeFrom.getColumn();
		tblclmnRangeFrom_1.setWidth(100);
		tblclmnRangeFrom_1.setText("Range From");

		tvcAtomRangeTo = new TableViewerColumn(atomTableViewer, SWT.NONE);
		tvcAtomRangeTo.setLabelProvider(new ColumnLabelProvider() {
			public Image getImage(Object element) {
				// TODO Auto-generated method stub
				return null;
			}

			public String getText(Object element) {
				return element == null ? "" : Integer.toString(((Atom) element)
						.getToRange());
			}
		});
		TableColumn tblclmnRangeTo_1 = tvcAtomRangeTo.getColumn();
		tblclmnRangeTo_1.setWidth(100);
		tblclmnRangeTo_1.setText("Range To");

		tvcAtomMass = new TableViewerColumn(atomTableViewer, SWT.NONE);
		tvcAtomMass.setLabelProvider(new ColumnLabelProvider() {
			public Image getImage(Object element) {
				// TODO Auto-generated method stub
				return null;
			}

			public String getText(Object element) {
				return element == null ? "" : Double.toString(((Atom) element)
						.getMass());
			}
		});
		TableColumn tblclmnMass = tvcAtomMass.getColumn();
		tblclmnMass.setWidth(100);
		tblclmnMass.setText("Mass");

		tvcAtomCharge = new TableViewerColumn(atomTableViewer, SWT.NONE);
		tvcAtomCharge.setLabelProvider(new ColumnLabelProvider() {
			public Image getImage(Object element) {
				// TODO Auto-generated method stub
				return null;
			}

			public String getText(Object element) {
				return element == null ? "" : Double.toString(((Atom) element)
						.getCharge());
			}
		});
		TableColumn tblclmnCharge = tvcAtomCharge.getColumn();
		tblclmnCharge.setWidth(100);
		tblclmnCharge.setText("Charge");

		lblBonds = new Label(this, SWT.NONE);
		lblBonds.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, false, 1,
				1));
		lblBonds.setSize(654, 544);
		lblBonds.setText("Bonds");

		bondsTableViewer = new TableViewer(this, SWT.BORDER
				| SWT.FULL_SELECTION);
		bondsTable = bondsTableViewer.getTable();
		bondsTable.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true,
				4, 1));
		bondsTable.setSize(654, 544);
		bondsTable.setLinesVisible(true);
		bondsTable.setHeaderVisible(true);

		tvcBondType = new TableViewerColumn(bondsTableViewer, SWT.NONE);
		TableColumn tblclmnBondType = tvcBondType.getColumn();
		tblclmnBondType.setWidth(100);
		tblclmnBondType.setText("Type");

		tvcBondNumber = new TableViewerColumn(bondsTableViewer, SWT.NONE);
		TableColumn tblclmnBondNumber = tvcBondNumber.getColumn();
		tblclmnBondNumber.setWidth(100);
		tblclmnBondNumber.setText("Number");

		tvcBondRangeFrom = new TableViewerColumn(bondsTableViewer, SWT.NONE);
		TableColumn tblclmnRangeFrom = tvcBondRangeFrom.getColumn();
		tblclmnRangeFrom.setWidth(100);
		tblclmnRangeFrom.setText("Range From");

		tvcBondRangeTo = new TableViewerColumn(bondsTableViewer, SWT.NONE);
		TableColumn tblclmnRangeTo = tvcBondRangeTo.getColumn();
		tblclmnRangeTo.setWidth(100);
		tblclmnRangeTo.setText("Range To");

		tvcBondR = new TableViewerColumn(bondsTableViewer, SWT.NONE);
		TableColumn tblclmnR = tvcBondR.getColumn();
		tblclmnR.setWidth(100);
		tblclmnR.setText("r");

		tvcBondK = new TableViewerColumn(bondsTableViewer, SWT.NONE);
		TableColumn tblclmnK = tvcBondK.getColumn();
		tblclmnK.setWidth(50);
		tblclmnK.setText("k");

		Menu menu = new Menu(bondsTable);
		bondsTable.setMenu(menu);

		MenuItem mntmAddBond = new MenuItem(menu, SWT.NONE);
		mntmAddBond.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				species.getBonds().add(Mp2c_1_0Factory.eINSTANCE.createBond());
				bondsTableViewer.refresh();
			}
		});
		mntmAddBond.setText("Add bond");

		MenuItem mntmRemoveBond = new MenuItem(menu, SWT.NONE);
		mntmRemoveBond.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				for (TableItem bondTi : bondsTable.getSelection()) {
					species.getBonds().remove(bondTi.getData());
				}
				bondsTableViewer.refresh();
			}
		});
		mntmRemoveBond.setText("Remove bond");
		bondsTableViewer.setContentProvider(new ArrayContentProvider());

		m_bindingContext = initDataBindings();
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

	/**
	 * @wbp.factory
	 */
	public static Composite createComposite(Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new GridLayout(5, false));
		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false,
				1, 1));
		return composite;
	}

	/**
	 * @return
	 * 
	 */
	public MolecularSpecies getSpecies() {
		return species;
	}

	protected DataBindingContext initDataBindings() {
		DataBindingContext bindingContext = new DataBindingContext();
		//
		return bindingContext;
	}
}
