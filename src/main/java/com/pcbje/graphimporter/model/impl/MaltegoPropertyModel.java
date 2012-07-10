package com.pcbje.graphimporter.model.impl;

import com.pcbje.graphimporter.model.PropertyModel;

public class MaltegoPropertyModel implements PropertyModel {
	private final String name;
	private final String displayName;
	private final String type;
	private final String value;
	
	public MaltegoPropertyModel(String name, String displayName, String type, String value) {
		this.name = name;
		this.displayName = displayName;
		this.type = type;
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public String getDisplayName() {
		return displayName;
	}

	public String getType() {
		return type;
	}

	public String getValue() {
		return value;
	}

}
