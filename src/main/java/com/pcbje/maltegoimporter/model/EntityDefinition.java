package com.pcbje.maltegoimporter.model;

import java.util.Map;

public interface EntityDefinition {
	public Map<String, PropertyModel> getProperties(String type);
}
