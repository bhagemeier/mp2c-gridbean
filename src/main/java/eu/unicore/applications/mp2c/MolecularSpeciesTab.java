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
import org.eclipse.core.databinding.beans.PojoObservables;
import org.eclipse.core.databinding.beans.PojoProperties;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.databinding.viewers.ObservableMapLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Table;

import eu.unicore.applications.mp2c.model.MolecularSpecies;

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
	private MolecularSpecies species;
	private Spinner spnNumberAtoms;
	private Table atomTable;
	private TableViewer atomTableViewer;
	private Table bondsTable;
	private TableViewer bondsTableViewer;
	private ScrolledComposite scrolledComposite;
	private Composite composite_1;

	/**
	 * Create the composite.
	 * 
	 * @param parent
	 * @param style
	 */
	public MolecularSpeciesTab(Composite parent, int style,
			MolecularSpecies _species) {
		super(parent, style);
		setLayout(new GridLayout(1, false));

		this.species = _species;

		molecularSpeciesComposite = createComposite(parent);
		molecularSpeciesComposite.setLayout(new StackLayout());

		scrolledComposite = new ScrolledComposite(molecularSpeciesComposite,
				SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		scrolledComposite.setExpandHorizontal(true);
		scrolledComposite.setExpandVertical(true);

		composite_1 = new Composite(scrolledComposite, SWT.NONE);
		composite_1.setLayout(new GridLayout(4, false));

		Label lblNumber = new Label(composite_1, SWT.NONE);
		lblNumber.setText("Number");

		spnNumberAtoms = new Spinner(composite_1, SWT.BORDER);

		Label lblSites = new Label(composite_1, SWT.NONE);
		lblSites.setSize(654, 544);
		lblSites.setText("Sites");

		spnNumberSites = new Spinner(composite_1, SWT.BORDER);
		spnNumberSites.setSize(654, 544);

		Label lblAtom = new Label(composite_1, SWT.NONE);
		lblAtom.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, false, 1,
				1));
		lblAtom.setSize(654, 544);
		lblAtom.setText("Atom");

		atomTableViewer = new TableViewer(composite_1, SWT.BORDER
				| SWT.FULL_SELECTION);
		atomTable = atomTableViewer.getTable();
		atomTable.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 3,
				1));
		atomTable.setSize(654, 544);
		atomTable.setLinesVisible(true);
		atomTable.setHeaderVisible(true);

		lblBonds = new Label(composite_1, SWT.NONE);
		lblBonds.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, false, 1,
				1));
		lblBonds.setSize(654, 544);
		lblBonds.setText("Bonds");

		bondsTableViewer = new TableViewer(composite_1, SWT.BORDER
				| SWT.FULL_SELECTION);
		bondsTable = bondsTableViewer.getTable();
		bondsTable.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true,
				3, 1));
		bondsTable.setSize(654, 544);
		bondsTable.setLinesVisible(true);
		bondsTable.setHeaderVisible(true);
		scrolledComposite.setContent(composite_1);
		scrolledComposite.setMinSize(composite_1.computeSize(SWT.DEFAULT,
				SWT.DEFAULT));

		m_bindingContext = initDataBindings();
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
		IObservableValue numberSpeciesObserveValue = PojoProperties.value(
				"number").observe(species);
		bindingContext.bindValue(observeSelectionSpnNumberAtomsObserveWidget,
				numberSpeciesObserveValue, null, null);
		//
		IObservableValue observeSelectionSpnNumberSitesObserveWidget = WidgetProperties
				.selection().observe(spnNumberSites);
		IObservableValue sitesSpeciesObserveValue = PojoProperties.value(
				"sites").observe(species);
		bindingContext.bindValue(observeSelectionSpnNumberSitesObserveWidget,
				sitesSpeciesObserveValue, null, null);
		//
		ObservableListContentProvider listContentProvider = new ObservableListContentProvider();
		IObservableMap observeMap = PojoObservables.observeMap(
				listContentProvider.getKnownElements(), MolecularSpecies.class,
				"atoms");
		atomTableViewer.setLabelProvider(new ObservableMapLabelProvider(
				observeMap));
		atomTableViewer.setContentProvider(listContentProvider);
		//
		IObservableList atomsSpeciesObserveList = PojoProperties.list("atoms")
				.observe(species);
		atomTableViewer.setInput(atomsSpeciesObserveList);
		//
		ObservableListContentProvider listContentProvider_1 = new ObservableListContentProvider();
		IObservableMap observeMap_1 = PojoObservables.observeMap(
				listContentProvider_1.getKnownElements(),
				MolecularSpecies.class, "bonds");
		bondsTableViewer.setLabelProvider(new ObservableMapLabelProvider(
				observeMap_1));
		bondsTableViewer.setContentProvider(listContentProvider_1);
		//
		IObservableList bondsSpeciesObserveList = PojoProperties.list("bonds")
				.observe(species);
		bondsTableViewer.setInput(bondsSpeciesObserveList);
		//
		return bindingContext;
	}

	/**
	 * @return
	 * 
	 */
	public MolecularSpecies getSpecies() {
		return species;
	}
}
