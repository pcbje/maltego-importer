package com.pcbje.graphimporter.model.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.pcbje.graphimporter.model.EdgeModel;
import com.pcbje.graphimporter.model.EntityDefinition;
import com.pcbje.graphimporter.model.NodeModel;
import com.pcbje.graphimporter.model.PropertyModel;

public class MaltegoNodeModel implements NodeModel {
	private final String id;
	private final String type;
	
	private final List<EdgeModel> edges;
	
	private final Map<String, PropertyModel> properties;
	
	private static EntityDefinition entityDefs;
	
	public MaltegoNodeModel(String type, String label) {
		this.id = type + "_" + label;
		this.type = type;
		
		edges = new ArrayList<EdgeModel>();
		
		if (entityDefs == null) {
			entityDefs = new MaltegoEntityDefinition();
		}
		
		properties = entityDefs.getProperties(type);	
		
		for (PropertyModel property : properties.values()) {
			if (property.isLabelProperty()) {
				property.setValue(label);
			}
		}
	}

	public String getNodeId() {
		return id;
	}

	public String getNodeType() {
		return type;
	}
	
	public void setProperty(String key, PropertyModel property) {
		properties.put(key, property);
	}

	public Map<String, PropertyModel> getProperties() {
		return properties;
	}
	
	public void addEdge(EdgeModel edge) {
		edges.add(edge);
	}

	public List<EdgeModel> getEdges() {
		return edges;
	}

}
