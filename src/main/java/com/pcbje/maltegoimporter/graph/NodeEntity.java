package com.pcbje.maltegoimporter.graph;

import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public interface NodeEntity {
	public String getId();
	
	public void addProperty(PropertyEntity attribute);
	public List<PropertyEntity> getProperties();
	
	public Element getGraphML(Document doc);
}
