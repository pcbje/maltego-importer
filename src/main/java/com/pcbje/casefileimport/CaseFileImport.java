package com.pcbje.casefileimport;

import com.pcbje.casefileimport.gui.CaseFileDialog;
import com.pcbje.casefileimport.gui.impl.DefaultCaseFileDialog;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Hello world!
 *
 */
public class CaseFileImport 
{
    public static void main( String[] args ) 
    {
        final CaseFileDialog dialog = new DefaultCaseFileDialog();
        
        dialog.showDialog();
        
        dialog.register(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                try {
                    String caseFileData = dialog.getFileParser()
                            .parse(dialog.getInputFile(), dialog.getDelimeter());

                    Toolkit toolkit = Toolkit.getDefaultToolkit();
                    Clipboard clipboard = toolkit.getSystemClipboard();
                    StringSelection strSel = new StringSelection(caseFileData);
                    clipboard.setContents(strSel, null);

                    dialog.success();
                }
                catch(Exception cfe) {                   
                    Logger.getLogger(CaseFileImport.class.getName())
                            .log(Level.SEVERE, "Could not parse file", cfe);
                    
                    dialog.error(cfe);
                }
            }            
        });
    }
}
