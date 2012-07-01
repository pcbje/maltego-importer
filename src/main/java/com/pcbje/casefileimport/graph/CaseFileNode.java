package com.pcbje.casefileimport.graph;

import java.util.Map;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 * @author pcbje
 */
public interface CaseFileNode {
    public String getId();
    public String getGroup();
    public String getType();
    public String getLabel();
    
    public void addAttribute(String key, String value);
    public String getAttribute(String key);
    public Map<String, String> getAttributes();
    
    public void mergeWith(CaseFileNode otherNode);
    
    /**
     * Get type display name formatted for the CaseFile GraphML format.
     * 
     * @return 
     */
    public String getGroupDisplayName();
    
    /**
     * Get type name formatted for the CaseFile GraphML format.
     * 
     * @return 
     */
    public String getGroupName();
    
    public Element getGraphML(Document doc);
}   
