package com.pcbje.maltegoimporter.model;

import java.util.Map;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public interface EdgeModel {
	public String getId();
	public String getType();
	public NodeModel getSourceNode();
	public NodeModel getTargetNode();
	
	/**
	 * @param propertyDisplayName The display name of the property you want to alter the value of.
	 * @param property The new value of of the property with the given display name.
	 * @throws RuntimeException If the node type doesn't have a property with that display name.
	 */
	public void setProperty(String propertyDisplayName, String value);
	
	public Map<String, PropertyModel> getProperties();
	
	public Element getGraphML(Document doc);
}
