package com.pcbje.maltegoimporter.model;

import java.util.List;
import java.util.Map;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public interface NodeModel {
	public String getNodeId();
	public String getNodeType();
	
	public void setProperty(String key, PropertyModel property);
	public Map<String, PropertyModel> getProperties();
	
	public void addEdge(EdgeModel edge);
	public List<EdgeModel> getEdges();
	
	public Element getGraphML(Document doc);
}
