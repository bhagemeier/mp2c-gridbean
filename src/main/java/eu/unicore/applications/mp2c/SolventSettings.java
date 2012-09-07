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
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Text;

/**
 * @author bjoernh
 *
 * 26.03.2012 14:51:28
 *
 */
public class SolventSettings extends Composite {
	private DataBindingContext m_bindingContext;
	private Text txtPartmass;
	private Text txtFreepath;
	private Spinner spnParticlesPerCell;
	private Spinner spnNrParticles;
	private Spinner rotAngle;

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public SolventSettings(Composite parent, int style) {
		super(parent, style);
		setLayout(new GridLayout(2, false));

		Label lblParticlesPerCollision = new Label(this, SWT.NONE);
		lblParticlesPerCollision.setText("Particles per collision cell");

		spnParticlesPerCell = new Spinner(this, SWT.BORDER);

		Label lblNumberOfParticles = new Label(this, SWT.NONE);
		lblNumberOfParticles.setText("Number of particles");

		spnNrParticles = new Spinner(this, SWT.BORDER);

		Label lblMassOfParticles = new Label(this, SWT.NONE);
		lblMassOfParticles.setText("Mass of particles");

		txtPartmass = new Text(this, SWT.BORDER);
		txtPartmass.setText("partMass");
		txtPartmass.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
				false, 1, 1));

		Label lblFreePathOf = new Label(this, SWT.NONE);
		lblFreePathOf.setText("Free path of a particle");

		txtFreepath = new Text(this, SWT.BORDER);
		txtFreepath.setText("freePath");
		txtFreepath.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
				false, 1, 1));

		Label lblRotationAngle = new Label(this, SWT.NONE);
		lblRotationAngle.setText(" Rotation angle");

		rotAngle = new Spinner(this, SWT.BORDER);
		rotAngle.setMaximum(360);
		m_bindingContext = initDataBindings();

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
	protected DataBindingContext initDataBindings() {
		DataBindingContext bindingContext = new DataBindingContext();
		return bindingContext;
	}

	public Spinner getSpnParticlesPerCell() {
		return spnParticlesPerCell;
	}

	public Spinner getSpnNrParticles() {
		return spnNrParticles;
	}

	public Text getTxtPartmass() {
		return txtPartmass;
	}

	public Text getTxtFreepath() {
		return txtFreepath;
	}

	public Spinner getRotAngle() {
		return rotAngle;
	}
}
