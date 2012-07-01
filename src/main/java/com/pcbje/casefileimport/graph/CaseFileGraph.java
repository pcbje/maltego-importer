package com.pcbje.casefileimport.graph;

import java.util.Map;
import org.w3c.dom.Element;

/**
 *
 * @author pcbje
 */
public interface CaseFileGraph {
    public void addNode(String id, CaseFileNode node);    
    public Map<String, CaseFileNode> getNodes();    
    public CaseFileNode getNode(String id);
    
    public void addEdge(String id, CaseFileEdge edge);
    public Map<String, CaseFileEdge> getEdges();   
    public CaseFileEdge getEdge(String id);
    
    public Element getGraphML();
    public String getGraphMLAsString() throws Exception;
}
