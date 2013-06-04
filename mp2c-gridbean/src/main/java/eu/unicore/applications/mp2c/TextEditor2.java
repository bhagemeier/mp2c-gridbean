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
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;

/**
 * @author bjoernh
 *
 * 01.10.2012 15:25:45
 *
 */
public class TextEditor2 extends Composite {
    private Text text;

    /**
     * 
     */
    TextEditor2(Composite parent, int style) {
        super(parent, style);
        setLayout(new GridLayout(2, false));
        new Label(this, SWT.NONE);

        Composite composite = new Composite(this, SWT.NONE);
        composite.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false,
                1, 1));
        composite.setLayout(new GridLayout(2, false));

        ToolBar fileToolBar = new ToolBar(composite, SWT.FLAT | SWT.RIGHT);

        final ToolItem tltmFile = new ToolItem(fileToolBar, SWT.DROP_DOWN);
        tltmFile.setText("File");

        final Menu fileMenu = new Menu(fileToolBar);
        fileToolBar.setMenu(fileMenu);

        tltmFile.addSelectionListener(new SelectionAdapter() {

            /**
             * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
             */
            @Override
            public void widgetSelected(SelectionEvent e) {
                // fileMenu.setLocation(tltmFile);
                System.out.println(tltmFile.getBounds());
                fileMenu.setVisible(true);
            }
        });

        MenuItem mntmOpen = new MenuItem(fileMenu, SWT.NONE);
        mntmOpen.setText("Open");

        MenuItem mntmSave = new MenuItem(fileMenu, SWT.NONE);
        mntmSave.setText("Save");

        ToolBar editToolBar = new ToolBar(composite, SWT.FLAT | SWT.RIGHT);

        final ToolItem tltmEdit = new ToolItem(editToolBar, SWT.DROP_DOWN);
        tltmEdit.setText("Edit");

        final Menu editMenu = new Menu(editToolBar);
        editToolBar.setMenu(editMenu);

        tltmEdit.addSelectionListener(new SelectionAdapter() {
            /**
             * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
             */
            @Override
            public void widgetSelected(SelectionEvent e) {
                // System.out.println(tltmEdit.getBounds());
                // System.out.println(tltmEdit.getParent().getLocation());
                editMenu.setVisible(true);
            }
        });

        MenuItem mntmUndo = new MenuItem(editMenu, SWT.NONE);
        mntmUndo.setText("Undo");


        text = new Text(this, SWT.BORDER | SWT.MULTI);
        GridData gd_text = new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1);
        gd_text.widthHint = 439;
        text.setLayoutData(gd_text);
    }
}
