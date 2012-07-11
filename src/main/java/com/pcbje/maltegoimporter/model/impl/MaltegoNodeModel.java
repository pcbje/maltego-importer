package com.pcbje.maltegoimporter.model.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.pcbje.maltegoimporter.model.EdgeModel;
import com.pcbje.maltegoimporter.model.NodeModel;
import com.pcbje.maltegoimporter.model.PropertyModel;

public class MaltegoNodeModel implements NodeModel {
	private final String id;
	private final String type;

	private final List<EdgeModel> edges;

	private final Map<String, PropertyModel> properties;

	private static MaltegoEntityDefinition entityDefs;

	private static int ID_COUNTER = 0;

	public MaltegoNodeModel(String type, String label) {
		this.id = "n" + Integer.toString(ID_COUNTER++);
		
		if (!type.contains("maltego.")) {
			type = "maltego." + type;
		}
		
		this.type = type;

		edges = new ArrayList<EdgeModel>();

		if (entityDefs == null) {
			entityDefs = new MaltegoEntityDefinition();
		}

		properties = entityDefs.getProperties(this.type);

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

	/**
	 * {@inheritDoc}
	 */
	public void setProperty(String propertyDisplayName, String value) {
		PropertyModel property = properties.get(propertyDisplayName);

		if (property == null) {
			throw new RuntimeException("No properties of node type '" + type
					+ "' has the display name '" + propertyDisplayName + "'");
		}

		property.setValue(value);
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
