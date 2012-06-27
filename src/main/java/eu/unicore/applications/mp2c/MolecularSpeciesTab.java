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

import java.util.HashMap;

import mp2c_1_0.Atom;
import mp2c_1_0.Mp2c_1_0Factory;
import mp2c_1_0.Mp2c_1_0Package;
import mp2c_1_0.Mp2c_1_0Package.Literals;
import mp2c_1_0.provider.Mp2c_1_0ItemProviderAdapterFactory;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.emf.databinding.EMFProperties;
import org.eclipse.emf.databinding.edit.EMFEditProperties;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.jface.databinding.viewers.CellEditorProperties;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.databinding.viewers.ObservableMapCellLabelProvider;
import org.eclipse.jface.databinding.viewers.ObservableValueEditingSupport;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Table;

import eu.unicore.applications.mp2c.converters.EMFObservableValueEditingSupport;

/**
 * @author bjoernh
 * 
 *         26.03.2012 13:32:43
 * 
 */
public class MolecularSpeciesTab extends Composite {
	private DataBindingContext m_bindingContext;
	private Spinner spnNumberSites;
	private Composite molecularSpeciesComposite;
	private Label lblBonds;
	private mp2c_1_0.MolecularSpecies species;
	private Spinner spnNumberAtoms;
	private ScrolledComposite scrolledComposite;
	private Table atomTable;
	private TableViewer atomTableViewer;
	private Table bondsTable;
	private TableViewer bondsTableViewer;

	/**
	 * Create the composite.
	 * 
	 * @param parent
	 * @param style
	 */
	public MolecularSpeciesTab(Composite parent, int style,
			mp2c_1_0.MolecularSpecies _species) {
		super(parent, style);
		setLayout(new GridLayout(1, false));

		this.species = _species;

		Atom atom = Mp2c_1_0Factory.eINSTANCE.createAtom();
		atom.setIdentifier("Nitrogen");
		atom.setSymbol("N");
		species.getAtoms().add(atom);

		scrolledComposite = new ScrolledComposite(this, SWT.BORDER
				| SWT.H_SCROLL | SWT.V_SCROLL);
		scrolledComposite.setAlwaysShowScrollBars(true);
		scrolledComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true,
				true, 1, 1));
		scrolledComposite.setExpandHorizontal(true);
		scrolledComposite.setExpandVertical(true);

		molecularSpeciesComposite = createComposite(scrolledComposite);
		GridLayout gridLayout = (GridLayout) molecularSpeciesComposite
				.getLayout();
		gridLayout.numColumns = 4;

		Label lblNumber = new Label(molecularSpeciesComposite, SWT.NONE);
		lblNumber.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1));
		lblNumber.setText("Number");

		spnNumberAtoms = new Spinner(molecularSpeciesComposite, SWT.BORDER);

		Label lblSites = new Label(molecularSpeciesComposite, SWT.NONE);
		lblSites.setText("Sites");

		spnNumberSites = new Spinner(molecularSpeciesComposite, SWT.BORDER);

		Label lblAtom = new Label(molecularSpeciesComposite, SWT.NONE);
		lblAtom.setText("Atom");

		new Label(molecularSpeciesComposite, SWT.NONE);
		new Label(molecularSpeciesComposite, SWT.NONE);
		new Label(molecularSpeciesComposite, SWT.NONE);

		atomTableViewer = new TableViewer(molecularSpeciesComposite, SWT.BORDER
				| SWT.FULL_SELECTION);
		atomTable = atomTableViewer.getTable();
		atomTable.setLinesVisible(true);
		atomTable.setHeaderVisible(true);
		atomTable.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1,
				1));
		new Label(molecularSpeciesComposite, SWT.NONE);
		new Label(molecularSpeciesComposite, SWT.NONE);
		new Label(molecularSpeciesComposite, SWT.NONE);

		lblBonds = new Label(molecularSpeciesComposite, SWT.NONE);
		lblBonds.setText("Bonds");
		new Label(molecularSpeciesComposite, SWT.NONE);
		new Label(molecularSpeciesComposite, SWT.NONE);
		new Label(molecularSpeciesComposite, SWT.NONE);

		bondsTableViewer = new TableViewer(molecularSpeciesComposite,
				SWT.BORDER | SWT.FULL_SELECTION);
		bondsTable = bondsTableViewer.getTable();
		bondsTable.setLinesVisible(true);
		bondsTable.setHeaderVisible(true);
		bondsTable.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true,
				1, 1));

		// cf.
		// http://www.vogella.com/code/de.vogella.databinding.emf.table/src/de/vogella/databinding/emf/table/ExampleTableViewer.html
		// The table viewer
		ObservableListContentProvider atomCp = new ObservableListContentProvider();
		// AdapterFactoryContentProvider atomCp = new
		// AdapterFactoryContentProvider(
		// new Mp2c_1_0ItemProviderAdapterFactory());

		HashMap<EAttribute, String> atomAttributeMap = new HashMap<EAttribute, String>();
		atomAttributeMap.put(Mp2c_1_0Package.Literals.ATOM__IDENTIFIER,
				"Identifier");
		atomAttributeMap.put(Mp2c_1_0Package.Literals.ATOM__SYMBOL, "Symbol");
		atomAttributeMap.put(Mp2c_1_0Package.Literals.ATOM__FROM_RANGE,
				"Range From");
		atomAttributeMap.put(Mp2c_1_0Package.Literals.ATOM__TO_RANGE,
				"Range To");
		atomAttributeMap.put(Mp2c_1_0Package.Literals.ATOM__MASS, "Mass");
		atomAttributeMap.put(Mp2c_1_0Package.Literals.ATOM__CHARGE, "Charge");

		m_bindingContext = initDataBindings();

		EditingDomain ed = new AdapterFactoryEditingDomain(
				new Mp2c_1_0ItemProviderAdapterFactory(),
				new BasicCommandStack());

		Mp2c_1_0ItemProviderAdapterFactory af = new Mp2c_1_0ItemProviderAdapterFactory();
		// atomTableViewer
		// .setContentProvider(new AdapterFactoryContentProvider(af));
		// atomTableViewer.setLabelProvider(new
		// AdapterFactoryLabelProvider(af));

		for (EAttribute attribute : atomAttributeMap.keySet()) {
			TableViewerColumn tvc = new TableViewerColumn(atomTableViewer,
					SWT.LEAD);
			IObservableMap map = EMFProperties.value(attribute).observeDetail(
					atomCp.getKnownElements());
			// tvc.setLabelProvider(new PropertyColumnLabelProvider(
			// new AdapterFactoryContentProvider(af), atomAttributeMap
			// .get(attribute)));
			tvc.setLabelProvider(new ObservableMapCellLabelProvider(map));
			tvc.getColumn().setText(atomAttributeMap.get(attribute));
			tvc.getColumn().setWidth(80);
			// org.eclipse.jface.viewers.CellEditor ce = new TextCellEditor(
			// atomTable);
			// tvc.setEditingSupport(new PropertyEditingSupport(tvc.getViewer(),
			// new AdapterFactoryContentProvider(af), attribute));
			TextCellEditor ce = new TextCellEditor(atomTable);
			// This forum post helped me determine what IValueProperty needs to
			// go in the create method.
			// http://www.eclipse.org/forums/index.php/m/542335/
			tvc.setEditingSupport(EMFObservableValueEditingSupport.create(tvc
					.getViewer(), m_bindingContext, ce, CellEditorProperties
					.control().value(WidgetProperties.text(SWT.Modify)),
					EMFEditProperties.value(ed, attribute)));
		}

		// atomTableViewer.setContentProvider(ArrayContentProvider.getInstance());
		atomTableViewer.setContentProvider(atomCp);
		atomTableViewer.setInput(EMFProperties.list(
				Mp2c_1_0Package.Literals.MOLECULAR_SPECIES__ATOMS).observe(
				_species));

		// atomTableViewer.setLabelProvider(new
		// AdapterFactoryLabelProvider(af));

		// The bonds viewer
		ObservableListContentProvider bondsCp = new ObservableListContentProvider();
		HashMap<EAttribute, String> bondsAttributeMap = new HashMap<EAttribute, String>();
		bondsAttributeMap.put(Mp2c_1_0Package.Literals.BOND__TYPE, "Type");
		bondsAttributeMap.put(Mp2c_1_0Package.Literals.BOND__NUMBER, "Number");
		bondsAttributeMap.put(Mp2c_1_0Package.Literals.BOND__TO_RANGE,
				"Range To");
		bondsAttributeMap.put(Mp2c_1_0Package.Literals.BOND__FROM_RANGE,
				"Range From");
		bondsAttributeMap.put(Mp2c_1_0Package.Literals.BOND__K, "k-Param");
		bondsAttributeMap.put(Mp2c_1_0Package.Literals.BOND__R, "r-Param");

		for (EAttribute attribute : bondsAttributeMap.keySet()) {
			TableViewerColumn tvc = new TableViewerColumn(bondsTableViewer,
					SWT.LEFT);
			IObservableMap map = EMFProperties.value(attribute).observeDetail(
					bondsCp.getKnownElements());
			tvc.setLabelProvider(new ObservableMapCellLabelProvider(map));
			tvc.getColumn().setText(bondsAttributeMap.get(attribute));
			tvc.getColumn().setWidth(80);
			tvc.setEditingSupport(ObservableValueEditingSupport.create(tvc
					.getViewer(), m_bindingContext, new TextCellEditor(
					bondsTable), CellEditorProperties.control(), EMFProperties
					.value(attribute)));
		}

		bondsTableViewer.setContentProvider(bondsCp);
		bondsTableViewer.setInput(EMFProperties.list(
				Mp2c_1_0Package.Literals.MOLECULAR_SPECIES__BONDS).observe(
				_species));

		new Label(molecularSpeciesComposite, SWT.NONE);
		new Label(molecularSpeciesComposite, SWT.NONE);
		new Label(molecularSpeciesComposite, SWT.NONE);
		scrolledComposite.setContent(molecularSpeciesComposite);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

	public Composite getMolecularSpeciesComposite() {
		return molecularSpeciesComposite;
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

	protected DataBindingContext initDataBindings() {
		DataBindingContext bindingContext = new DataBindingContext();
		//
		IObservableValue observeSelectionSpnNumberAtomsObserveWidget = WidgetProperties
				.selection().observe(spnNumberAtoms);
		IObservableValue speciesNumberObserveValue = EMFObservables
				.observeValue(species, Literals.MOLECULAR_SPECIES__NUMBER);
		bindingContext.bindValue(observeSelectionSpnNumberAtomsObserveWidget,
				speciesNumberObserveValue, null, null);
		//
		IObservableValue observeSelectionSpnNumberSitesObserveWidget = WidgetProperties
				.selection().observe(spnNumberSites);
		IObservableValue speciesSitesObserveValue = EMFObservables
				.observeValue(species, Literals.MOLECULAR_SPECIES__SITES);
		bindingContext.bindValue(observeSelectionSpnNumberSitesObserveWidget,
				speciesSitesObserveValue, null, null);
		//
		return bindingContext;
	}
}
