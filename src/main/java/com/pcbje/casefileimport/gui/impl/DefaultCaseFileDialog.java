package com.pcbje.casefileimport.gui.impl;

import com.pcbje.casefileimport.gui.CaseFileDialog;
import com.pcbje.casefileimport.gui.CaseFileParserModel;
import com.pcbje.casefileimport.parser.CaseFileParser;
import com.pcbje.casefileimport.parser.impl.CSVHeaderDefinedCaseFileParser;
import com.pcbje.casefileimport.parser.impl.CSVValueDefinedCaseFileParser;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Enumeration;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author pcbje
 */
public class DefaultCaseFileDialog implements CaseFileDialog {

    private File inputFile;
    private JFrame frame;
    private JTextField filePathField;
    private JTextField delimeterField;
    private JButton submitButton;
    private ButtonGroup parserGroup;

    public DefaultCaseFileDialog() {
        frame = new JFrame();
        
        JPanel panel = (JPanel) frame.getContentPane();
        
        panel.setLayout(new BorderLayout());
        panel.setBorder(new EmptyBorder(10, 10, 10, 10) );

        JPanel top = new JPanel(new BorderLayout());
        
        panel.add(top, BorderLayout.NORTH);
        
        top.add(new JLabel("File: "), BorderLayout.WEST);
        
        filePathField = new JTextField("");

        top.add(filePathField, BorderLayout.CENTER);

        JButton chooseFileButton = new JButton("Choose file");

        top.add(chooseFileButton, BorderLayout.EAST);
        
        final JFileChooser fc = new JFileChooser();

        chooseFileButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                int returnVal = fc.showOpenDialog(null);

                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    inputFile = fc.getSelectedFile();            
                    filePathField.setText(inputFile.getPath());
                } 

            }
        });

        JPanel parserPanel = new JPanel();

        JRadioButton headerButton = new JRadioButton("Defined in header");
        headerButton.setModel(new DefaultCaseFileParserModel(new CSVHeaderDefinedCaseFileParser()));
        headerButton.setSelected(true);
        
        parserPanel.add(headerButton);

        JRadioButton valueButton = new JRadioButton("Defined in value");
        valueButton.setModel(new DefaultCaseFileParserModel(new CSVValueDefinedCaseFileParser()));       
        
        parserPanel.add(valueButton);

        parserGroup = new ButtonGroup();
        parserGroup.add(headerButton);
        parserGroup.add(valueButton);
        
        panel.add(parserPanel, BorderLayout.CENTER);

        JPanel bottom = new JPanel(new BorderLayout());
        
        panel.add(bottom, BorderLayout.SOUTH);
        
        bottom.add(new JLabel("Delimeter: "), BorderLayout.WEST);
        
        delimeterField = new JTextField(",");

        bottom.add(delimeterField, BorderLayout.CENTER);
        
        submitButton = new JButton("Load");
        
        bottom.add(submitButton, BorderLayout.EAST);
    }

    public void showDialog() {        
        frame.setSize(new Dimension(340, 120));
        frame.setTitle("Copy to Maltego CaseFile");
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public void register(ActionListener listener) {
        submitButton.addActionListener(listener);
    }

    public void setInputFile(File file) throws FileNotFoundException {
        if (!file.exists()) {
            throw new FileNotFoundException("File doesn't exist.");
        }

        this.inputFile = file;
    }

    public File getInputFile() {
        return inputFile;
    }

    public void setDelimeter(String delimeter) {
        delimeterField.setText(delimeter);
    }

    public String getDelimeter() {
        return delimeterField.getText();
    }

    public void setFileParser(CaseFileParser format) {
        for (Enumeration e = parserGroup.getElements(); e.hasMoreElements();) {
            JRadioButton b = (JRadioButton) e.nextElement();
            if (((CaseFileParserModel) b.getModel()).getParser().getClass().getName().equals(format.getClass().getName())) {
                parserGroup.setSelected(b.getModel(), true);
            }


        }
    }

    public CaseFileParser getFileParser() {
        for (Enumeration e = parserGroup.getElements(); e.hasMoreElements();) {
            JRadioButton b = (JRadioButton) e.nextElement();
            if (b.getModel() == parserGroup.getSelection()) {
                return ((CaseFileParserModel) b.getModel()).getParser();
            }
        }
        return null;
    }
    
    public void success() {
        JOptionPane.showMessageDialog(null, "File copied to clipboard, you can now paste it into Maltego CaseFile!");
    }
    
    public void error(Exception e) {
        JOptionPane.showMessageDialog(null, e);
    }
    
    void fireEvent() {
        submitButton.doClick();
    }
}
