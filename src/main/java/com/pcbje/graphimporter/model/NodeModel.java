package com.pcbje.graphimporter.model;

import java.util.List;
import java.util.Map;

public interface NodeModel {
	public String getNodeId();
	public String getNodeType();	
	public Map<String, PropertyModel> getProperties();
	
	public void addEdge(EdgeModel edge);
	public List<EdgeModel> getEdges();
}
