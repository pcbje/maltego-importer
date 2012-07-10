package com.pcbje.graphimporter.model;

import java.util.List;

public interface NodeType {
	public List<PropertyModel> getProperties(String type, String label);
}
