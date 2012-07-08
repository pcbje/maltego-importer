package com.pcbje.graphimporter.graph;

import java.util.List;

public interface NodeEntity extends XMLEntity {
	public String getId();
	
	public void addProperty(PropertyEntity attribute);
	public List<PropertyEntity> getProperties();
}
