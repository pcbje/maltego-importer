package com.pcbje.graphimporter.model;

import java.util.Map;

public interface EdgeModel {
	public String getId();
	public String getType();
	public NodeModel getSourceNode();
	public NodeModel getTargetNode();
	
	public void setProperty(String key, PropertyModel property);
	public Map<String, PropertyModel> getProperties();
}
