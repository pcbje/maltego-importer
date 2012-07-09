package com.pcbje.graphimporter.graph;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public interface PropertyEntity {
	public String getPropertyValue(String key);
	
	public String getValue();
	
	public Element getGraphML(Document doc);
}
