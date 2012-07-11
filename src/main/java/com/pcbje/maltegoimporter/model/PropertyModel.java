package com.pcbje.maltegoimporter.model;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public interface PropertyModel {
	public String getName();
	public String getDisplayName();
	public String getType();
	
	public void setValue(String value);
	public String getValue();
	
	public boolean isLabelProperty();	
	
	public Element getGraphML(Document doc);
}
