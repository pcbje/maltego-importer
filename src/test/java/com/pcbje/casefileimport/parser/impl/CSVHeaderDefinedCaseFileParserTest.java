package com.pcbje.casefileimport.parser.impl;

import java.io.File;
import static junit.framework.Assert.assertNotNull;
import org.junit.Test;

/**
 *
 * @author pcbje
 */
public class CSVHeaderDefinedCaseFileParserTest {
    @Test
    public void testParsingOfFile() throws Exception {
        File testFile = new File(this.getClass().getResource("/header-defined.csv").getPath());
        
        CSVHeaderDefinedCaseFileParser parser = new CSVHeaderDefinedCaseFileParser();
        
        String result = parser.parse(testFile, ",");
        
        assertNotNull(result);
    }
}
