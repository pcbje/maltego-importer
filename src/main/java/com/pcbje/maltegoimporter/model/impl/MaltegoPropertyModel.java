package com.pcbje.maltegoimporter.model.impl;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.pcbje.maltegoimporter.model.PropertyModel;

/**
 * Model representing a Maltego property in GraphML. This model is added to
 * nodes and edges and also holds what is shown as the node/edge label in
 * Maltego.
 * 
 * @author pcbje
 */
public class MaltegoPropertyModel implements PropertyModel {
	private final String name;
	private final String displayName;
	private final String type;

	private String value;

	private final boolean labelProperty;

	public MaltegoPropertyModel(String name, String displayName, String type,
			boolean labelProperty) {
		this.name = name;
		this.displayName = displayName;
		this.type = type;
		this.labelProperty = labelProperty;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getName() {
		return name;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getDisplayName() {
		return displayName;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getType() {
		return type;
	}

	/**
	 * {@inheritDoc}
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getValue() {
		return value;
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean isLabelProperty() {
		return labelProperty;
	}

	/**
	 * {@inheritDoc}
	 */
	public Element getGraphML(Document doc) {
		Element element = doc.createElement("mtg:Property");
		element.setAttribute("displayName", displayName);
		element.setAttribute("hidden", "false");
		element.setAttribute("name", name);
		element.setAttribute("nullable", "true");
		element.setAttribute("readonly", "false");
		element.setAttribute("type", type);

		Element valueElement = doc.createElement("mtg:Value");
		valueElement.setTextContent(value);
		element.appendChild(valueElement);

		return element;
	}
}
