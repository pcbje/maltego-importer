package com.pcbje.casefileimport.gui;

import com.pcbje.casefileimport.parser.CaseFileParser;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;

/**
 *
 * @author pcbje
 */
public interface CaseFileDialog {
    public void showDialog();
    public void register(ActionListener listener);    
    public void setInputFile(File file) throws FileNotFoundException;
    public File getInputFile();
    public void setDelimeter(String delimeter);
    public String getDelimeter();
    public void setFileParser(CaseFileParser format);
    public CaseFileParser getFileParser();  
    public void success();
    public void error(Exception e);
}
