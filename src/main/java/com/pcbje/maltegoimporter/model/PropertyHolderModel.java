package com.pcbje.maltegoimporter.model;

import java.util.Map;

/**
 * Model representing an property holder (node and edge) in GraphML.
 * 
 * @author pcbje
 */
public interface PropertyHolderModel {
	/**
	 * @param propertyDisplayName
	 *            The display name of the property you want to alter the value
	 *            of. The display name is case sensitive.
	 * @param property
	 *            The new value of of the property with the given display name.
	 * @throws RuntimeException
	 *             If the node type doesn't have a property with that display
	 *             name.
	 */
	public void setProperty(String propertyDisplayName, String value);

	/**
	 * @return The map of properties added to this object.
	 */
	public Map<String, PropertyModel> getProperties();
}
