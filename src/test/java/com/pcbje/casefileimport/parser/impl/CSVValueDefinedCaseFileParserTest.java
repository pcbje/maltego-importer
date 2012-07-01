package com.pcbje.casefileimport.parser.impl;

import java.io.File;
import static junit.framework.Assert.assertNotNull;
import org.junit.Test;

/**
 *
 * @author pcbje
 */
public class CSVValueDefinedCaseFileParserTest {
    @Test
    public void testParsingOfFile() throws Exception {
        File testFile = new File(this.getClass().getResource("/value-defined.csv").getPath());
        
        CSVValueDefinedCaseFileParser parser = new CSVValueDefinedCaseFileParser();
        
        String result = parser.parse(testFile, ",");
        
        assertNotNull(result);
    }
}
