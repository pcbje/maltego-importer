package com.pcbje.graphimporter.graph.impl;

import java.util.HashMap;
import java.util.Map;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.pcbje.graphimporter.graph.PropertyEntity;

public class MaltegoProperty implements PropertyEntity {
	private final Map<String, String> propertyValues;
	
	private final String value;
	
	public MaltegoProperty(String name, String displayName, String type, String value) {
		propertyValues = new HashMap<String, String>();
		
		propertyValues.put("name", name);
		propertyValues.put("displayName", displayName);
		propertyValues.put("type", type);
		propertyValues.put("hidden", "false");
		propertyValues.put("nullable", "true");
		propertyValues.put("readonly", "false");
		
		this.value = value;
	}
	
	public String getPropertyValue(String key) {
		return propertyValues.get(key);
	}

	public String getValue() {
		return value;
	}
	
	public Element getGraphML(Document doc) {
		Element element = doc.createElement("mtg:Property");
        element.setAttribute("displayName", propertyValues.get("displayName"));
        element.setAttribute("hidden", propertyValues.get("hidden"));
        element.setAttribute("name", propertyValues.get("name"));
        element.setAttribute("nullable", propertyValues.get("nullable"));
        element.setAttribute("readonly", propertyValues.get("readonly"));
        element.setAttribute("type", propertyValues.get("type"));
        
        Element valueElement = doc.createElement("mtg:Value");
        valueElement.setTextContent(value);
        element.appendChild(valueElement);
        
        return element;
	}
}
