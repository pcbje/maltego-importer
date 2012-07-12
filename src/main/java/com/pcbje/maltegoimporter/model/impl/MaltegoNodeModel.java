package com.pcbje.maltegoimporter.model.impl;

import java.util.Map;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.pcbje.maltegoimporter.model.NodeModel;
import com.pcbje.maltegoimporter.model.PropertyModel;

/**
 * Model representing a Maltego node in GraphML.
 * 
 * @author pcbje
 */
public class MaltegoNodeModel implements NodeModel {
	private String id;
	
	private final String type;
	private final String label;

	private final Map<String, PropertyModel> properties;

	private static MaltegoEntityDefinition entityDefs;

	private static int ID_COUNTER = 0;

	public MaltegoNodeModel(String type, String label) {
		this.id = "n" + Integer.toString(ID_COUNTER++);
		
		if (!type.startsWith("maltego.")) {
			type = "maltego." + type;
		}		
		
		this.type = type;
		this.label = label;

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

	/**
	 * {@inheritDoc}
	 */
	public String getNodeId() {
		return id;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public void setNodeId(String id) {
		this.id = id;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getNodeType() {
		return type;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public String getNodeLabel() {
		return label;
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

	/**
	 * {@inheritDoc}
	 */
	public Map<String, PropertyModel> getProperties() {
		return properties;
	}

	/**
	 * {@inheritDoc}
	 */
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
