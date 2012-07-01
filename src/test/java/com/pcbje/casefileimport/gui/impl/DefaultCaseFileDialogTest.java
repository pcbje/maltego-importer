package com.pcbje.casefileimport.gui.impl;

import com.pcbje.casefileimport.gui.CaseFileDialog;
import com.pcbje.casefileimport.parser.CaseFileParser;
import com.pcbje.casefileimport.parser.impl.CSVValueDefinedCaseFileParser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import static junit.framework.Assert.assertEquals;
import org.junit.Test;



/**
 *
 * @author pcbje
 */
public class DefaultCaseFileDialogTest {
    
    @Test
    public void testGetFile() throws Exception {
        CaseFileDialog dialog = new DefaultCaseFileDialog();
        
        File file = new File(this.getClass().getResource("/original.xml").getPath());
        
        dialog.setInputFile(file);       
        
        assertEquals(file, dialog.getInputFile());        
    }
    
    @Test(expected = FileNotFoundException.class)
    public void testExceptionIsThrownIfFileDoesNotExist() throws Exception {
        CaseFileDialog dialog = new DefaultCaseFileDialog();
        
        File file = new File("bogus.xml");
        
        dialog.setInputFile(file);               
    }
    
    @Test
    public void testFileIsNotSetIfFileDoesNotExist() {
        CaseFileDialog dialog = new DefaultCaseFileDialog();
        
        File file = new File("bogus.xml");
        try {
            dialog.setInputFile(file);
            assertEquals(null, dialog.getInputFile());
        } catch (FileNotFoundException ex) {
            
        }        
    }
    
    @Test
    public void testRegisterListener() throws Exception {
        final DefaultCaseFileDialog dialog = new DefaultCaseFileDialog();
        
        ActionListener listener = new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                dialog.setDelimeter("random");
            }
        };
        
        dialog.register(listener);
        
        dialog.fireEvent();
        
        Thread.sleep(100);
        
        assertEquals("random", dialog.getDelimeter());
    }
    
    @Test
    public void testFileParserIsSet() {
        final DefaultCaseFileDialog dialog = new DefaultCaseFileDialog();
        
        CaseFileParser parser = new CSVValueDefinedCaseFileParser();
        
        dialog.setFileParser(parser);
        
        assertEquals(parser.getClass(), dialog.getFileParser().getClass());
    }
}
