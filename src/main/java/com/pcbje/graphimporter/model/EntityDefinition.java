package com.pcbje.graphimporter.model;

import java.util.Map;

public interface EntityDefinition {
	public Map<String, PropertyModel> getProperties(String type);
}
