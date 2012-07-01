package com.pcbje.casefileimport.parser;

import java.io.File;

/**
 *
 * @author pcbje
 */
public interface CaseFileParser {
    public String parse(File file, String delimeter) throws Exception;
}
