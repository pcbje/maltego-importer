package com.pcbje.graphimporter.model.impl;

import java.util.ArrayList;
import java.util.List;

import com.pcbje.graphimporter.model.EdgeModel;
import com.pcbje.graphimporter.model.NodeModel;
import com.pcbje.graphimporter.model.PropertyModel;

public class MaltegoNodeModel implements NodeModel {
	private final String id;
	private final String type;
	
	private final List<EdgeModel> edges;
	
	private final List<PropertyModel> properties;
	
	public MaltegoNodeModel(String type, String label) {
		this.id = label;
		this.type = type;
		
		edges = new ArrayList<EdgeModel>();
		
		properties = new MaltegoNodeType().getProperties(type, label);
	}

	public String getNodeId() {
		return id;
	}

	public String getNodeType() {
		return type;
	}

	public List<PropertyModel> getProperties() {
		return properties;
	}
	
	public void addEdge(EdgeModel edge) {
		edges.add(edge);
	}

	public List<EdgeModel> getEdges() {
		return edges;
	}

}
