package com.pcbje.maltegoimporter.model.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.pcbje.maltegoimporter.model.EdgeModel;
import com.pcbje.maltegoimporter.model.EntityDefinition;
import com.pcbje.maltegoimporter.model.NodeModel;
import com.pcbje.maltegoimporter.model.PropertyModel;

public class MaltegoNodeModel implements NodeModel {
	private final String id;
	private final String type;
	
	private final List<EdgeModel> edges;
	
	private final Map<String, PropertyModel> properties;
	
	private static EntityDefinition entityDefs;
	
	private static int ID_COUNTER = 0;
	
	public MaltegoNodeModel(String type, String label) {
		this.id = "n" + Integer.toString(ID_COUNTER++);
		this.type = "maltego." + type;
		
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
	
	public Element getGraphML(Document doc) {
		Element node = doc.createElement("node");
		node.setAttribute("id", id);

		Element data = doc.createElement("data");
		data.setAttribute("key", "d4");
		node.appendChild(data);

		Element maltegoEntity = doc.createElement("mtg:MaltegoEntity");
		maltegoEntity.setAttribute("xmlns:mtg",
				"http://maltego.paterva.com/xml/mtgx");
		maltegoEntity.setAttribute("type", type);
		data.appendChild(maltegoEntity);

		Element props = doc.createElement("mtg:Properties");

		for (PropertyModel property : properties.values()) {
			props.appendChild(property.getGraphML(doc));
		}

		maltegoEntity.appendChild(props);

		return node;
	}

}
