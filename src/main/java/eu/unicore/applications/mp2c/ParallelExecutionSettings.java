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
import org.eclipse.core.databinding.beans.PojoProperties;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Spinner;

import eu.unicore.applications.mp2c.model.Parallel;

/**
 * @author bjoernh
 *
 * 26.03.2012 15:05:51
 *
 */
public class ParallelExecutionSettings extends Composite {
	private DataBindingContext m_bindingContext;

	private Parallel parallel;
	private Button btndimensionalCut;
	private Spinner parDimSpinner;

	/**
	 * Create the composite.
	 * 
	 * @param parent
	 * @param style
	 * @param parallel
	 */
	public ParallelExecutionSettings(Composite parent, int style,
			Parallel _parallel) {
		super(parent, style);
		setLayout(new GridLayout(1, false));

		this.parallel = _parallel;

		Group grpDimensionOfParallel = new Group(this, SWT.NONE);
		grpDimensionOfParallel.setLayoutData(new GridData(SWT.FILL, SWT.TOP,
				true, true, 1, 1));
		grpDimensionOfParallel.setText("Dimension of parallel subdivision");
		grpDimensionOfParallel.setLayout(new GridLayout(3, false));

		btndimensionalCut = new Button(grpDimensionOfParallel, SWT.RADIO);
		btndimensionalCut.setEnabled(false);
		btndimensionalCut.setText("1-dimensional cut");
		new Label(grpDimensionOfParallel, SWT.NONE);
		new Label(grpDimensionOfParallel, SWT.NONE);

		Button btndimensionalCut_1 = new Button(grpDimensionOfParallel,
				SWT.RADIO);
		btndimensionalCut_1.setEnabled(false);
		btndimensionalCut_1.setText("2-dimensional cut");
		new Label(grpDimensionOfParallel, SWT.NONE);

		parDimSpinner = new Spinner(grpDimensionOfParallel, SWT.BORDER);
		parDimSpinner.setPageIncrement(1);
		parDimSpinner.setMaximum(3);
		parDimSpinner.setMinimum(1);

		Button btndimensionalCut_2 = new Button(grpDimensionOfParallel,
				SWT.RADIO);
		btndimensionalCut_2.setEnabled(false);
		btndimensionalCut_2.setText("3-dimensional cut");
		new Label(grpDimensionOfParallel, SWT.NONE);
		new Label(grpDimensionOfParallel, SWT.NONE);
		m_bindingContext = initDataBindings();

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
	protected DataBindingContext initDataBindings() {
		DataBindingContext bindingContext = new DataBindingContext();
		//
		IObservableValue observeSelectionParDimSpinnerObserveWidget = WidgetProperties
				.selection().observe(parDimSpinner);
		IObservableValue dimParallelObserveValue = PojoProperties.value("dim")
				.observe(parallel);
		bindingContext.bindValue(observeSelectionParDimSpinnerObserveWidget,
				dimParallelObserveValue, null, null);
		//
		return bindingContext;
	}
}
