package com.pcbje.maltegoimporter.model;

public interface PropertyModel {
	public String getName();
	public String getDisplayName();
	public String getType();
	
	public void setValue(String value);
	public String getValue();
	
	public boolean isLabelProperty();	
}
