package com.pcbje.graphimporter.model.impl;

import java.util.Map;

import com.pcbje.graphimporter.model.EdgeModel;
import com.pcbje.graphimporter.model.EntityDefinition;
import com.pcbje.graphimporter.model.NodeModel;
import com.pcbje.graphimporter.model.PropertyModel;

public class MaltegoEdgeModel implements EdgeModel {
	private final String id;
	private final NodeModel sourceNode;
	private final NodeModel targetNode;
	
	private static EntityDefinition entityDefs;
	
	private final Map<String, PropertyModel> properties;
	
	public MaltegoEdgeModel(NodeModel sourceNode, NodeModel targetNode, String label) {
		this.id = sourceNode.getNodeId() + "_" + targetNode.getNodeId();
		this.sourceNode = sourceNode;
		this.targetNode = targetNode;
		
		if (entityDefs == null) {
			entityDefs = new MaltegoEntityDefinition();
		}
		
		properties = entityDefs.getProperties("link.manual-link");	
		
		properties.get("maltego.link.manual.type").setValue(label);
		properties.get("maltego.link.show-label").setValue("0");
		properties.get("maltego.link.thickness").setValue("2");
		properties.get("maltego.link.style").setValue("1");
		properties.get("maltego.link.color").setValue("8421505");
	}

	public String getId() {
		return id;
	}

	public NodeModel getSourceNode() {
		return sourceNode;
	}

	public NodeModel getTargetNode() {
		return targetNode;
	}

	public void setProperty(String key, PropertyModel property) {
		properties.put(key, property);
	}

	public Map<String, PropertyModel> getProperties() {
		return properties;
	}

}
