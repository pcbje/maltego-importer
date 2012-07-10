package com.pcbje.maltegoimporter.model.impl;

import com.pcbje.maltegoimporter.model.PropertyModel;

public class MaltegoPropertyModel implements PropertyModel {
	private final String name;
	private final String displayName;
	private final String type;
	
	private String value;
	
	private final boolean labelProperty;
	
	public MaltegoPropertyModel(String name, String displayName, String type, boolean labelProperty) {
		this.name = name;
		this.displayName = displayName;
		this.type = type;		
		this.labelProperty = labelProperty;
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
	
	public void setValue(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public boolean isLabelProperty() {
		return labelProperty;
	}
}
