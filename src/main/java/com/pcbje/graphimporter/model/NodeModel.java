package com.pcbje.graphimporter.model;

import java.util.List;

public interface NodeModel {
	public String getNodeId();
	public String getNodeType();	
	public List<PropertyModel> getProperties();
	
	public void addEdge(EdgeModel edge);
	public List<EdgeModel> getEdges();
}
