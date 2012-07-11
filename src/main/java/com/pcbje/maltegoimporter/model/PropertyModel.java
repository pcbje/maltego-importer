package com.pcbje.maltegoimporter.model;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public interface PropertyModel {
	/**
	 * @return The name (Id) of the property.
	 */
	public String getName();

	/**
	 * @return The display name of the property.
	 */
	public String getDisplayName();

	/**
	 * @return The type of the property.
	 */
	public String getType();

	/**
	 * Set the value of this property.
	 * 
	 * @param value
	 *            The new value.
	 */
	public void setValue(String value);

	/**
	 * @return The value of this property.
	 */
	public String getValue();

	/**
	 * @return Is the value of this property used as label for an entity
	 *         (graph/edge) in the target application?
	 */
	public boolean isLabelProperty();

	/**
	 * @param doc The document that will create the XML element.
	 * @return The property data represented as GraphML. 
	 */
	public Element getGraphML(Document doc);
}
