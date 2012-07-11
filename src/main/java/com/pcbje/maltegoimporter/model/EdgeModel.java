package com.pcbje.maltegoimporter.model;

import java.util.Map;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public interface EdgeModel {
	public String getId();
	public String getType();
	public NodeModel getSourceNode();
	public NodeModel getTargetNode();
	
	public void setProperty(String key, PropertyModel property);
	public Map<String, PropertyModel> getProperties();
	
	public Element getGraphML(Document doc);
}
