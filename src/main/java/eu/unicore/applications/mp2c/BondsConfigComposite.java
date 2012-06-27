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

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Text;

/**
 * @author bjoernh
 * 
 * @deprecated we're using a table for this now
 * 
 *             26.03.2012 13:35:06
 * 
 */
public class BondsConfigComposite extends Composite {
	private Text text;
	private Text text_1;
	private Text text_2;
	private Text text_3;

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public BondsConfigComposite(Composite parent, int style) {
		super(parent, style);
		setLayout(new GridLayout(5, false));

		Combo combo = new Combo(this, SWT.NONE);
		combo.setItems(new String[] { "Harmonic 1-2" });
		GridData gd_combo = new GridData(SWT.FILL, SWT.CENTER, true, false, 3,
				1);
		gd_combo.widthHint = 163;
		combo.setLayoutData(gd_combo);
		combo.select(0);

		Label lblTotalNumber = new Label(this, SWT.NONE);
		lblTotalNumber.setText("Total Number");

		Spinner spinner = new Spinner(this, SWT.BORDER);
		spinner.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false,
				1, 1));

		Label lblNewLabel = new Label(this, SWT.NONE);
		lblNewLabel.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, false,
				1, 1));
		lblNewLabel.setText("Range");
		new Label(this, SWT.NONE);
		new Label(this, SWT.NONE);

		Label lblK = new Label(this, SWT.NONE);
		lblK.setText("k");

		Label lblR = new Label(this, SWT.NONE);
		lblR.setText("r");

		text = new Text(this, SWT.BORDER);
		text.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));

		Label label = new Label(this, SWT.NONE);
		label.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false,
				1, 1));
		label.setText("-");

		text_1 = new Text(this, SWT.BORDER);
		text_1.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, true, false,
				1, 1));

		text_2 = new Text(this, SWT.BORDER);
		text_2.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1,
				1));

		text_3 = new Text(this, SWT.BORDER);
		text_3.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1,
				1));

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

}
