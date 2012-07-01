package com.pcbje.casefileimport.graph;

import java.util.Map;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 * @author pcbje
 */
public interface CaseFileEdge {    
    public void setSourceNode(CaseFileNode sourceNode);
    public CaseFileNode getSourceNode();
    
    public void setTargetNode(CaseFileNode destinationNode);
    public CaseFileNode getTargetNode();
    
    public String getId();
    public String getLabel();
    
    public void addAttribute(String key, String value);
    public Map<String, String> getAttributes();
    public String getAttribute(String key);
    
    public void mergeWith(CaseFileEdge otherEdge);
    
    public Element getGraphML(Document doc);
}
