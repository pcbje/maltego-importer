package com.pcbje.maltegoimporter.model.impl;

import java.util.Map;

import com.pcbje.maltegoimporter.model.EdgeModel;
import com.pcbje.maltegoimporter.model.EntityDefinition;
import com.pcbje.maltegoimporter.model.NodeModel;
import com.pcbje.maltegoimporter.model.PropertyModel;

public class MaltegoEdgeModel implements EdgeModel {
	private final String id;
	private final String type;
	
	private final NodeModel sourceNode;
	private final NodeModel targetNode;
	
	private static EntityDefinition entityDefs;
	
	private final Map<String, PropertyModel> properties;
	
	private static int ID_COUNTER = 0;
	
	public MaltegoEdgeModel(NodeModel sourceNode, NodeModel targetNode, String label) {
		this.id = "e" + Integer.toString(ID_COUNTER++);
		this.type = "maltego.link.manual-link";
		
		this.sourceNode = sourceNode;
		this.targetNode = targetNode;
		
		if (entityDefs == null) {
			entityDefs = new MaltegoEntityDefinition();
		}
		
		properties = entityDefs.getProperties("link.manual-link");	
		
		properties.get("maltego.link.manual.type").setValue(label);
		properties.get("maltego.link.show-label").setValue("0");
		properties.get("maltego.link.thickness").setValue("2");
		properties.get("maltego.link.style").setValue("0");
		properties.get("maltego.link.color").setValue("8421505");
	}

	public String getId() {
		return id;
	}
	
	public String getType() {
		return type;
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