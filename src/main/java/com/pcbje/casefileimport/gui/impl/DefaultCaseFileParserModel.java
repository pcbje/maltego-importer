package com.pcbje.casefileimport.gui.impl;

import com.pcbje.casefileimport.gui.CaseFileParserModel;
import com.pcbje.casefileimport.parser.CaseFileParser;
import javax.swing.JToggleButton.ToggleButtonModel;

/**
 *
 * @author pcbje
 */
class DefaultCaseFileParserModel extends ToggleButtonModel implements CaseFileParserModel {
    private CaseFileParser parser;
    
    public DefaultCaseFileParserModel(CaseFileParser parser) {
        super();
        
        this.parser = parser;
    }

    public CaseFileParser getParser() {
        return parser;
    }
}
