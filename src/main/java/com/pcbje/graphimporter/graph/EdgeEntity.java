package com.pcbje.graphimporter.graph;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public interface EdgeEntity {
	public String getSourceNodeId();
	public String getTargetNodeId();
	
	public Element getGraphML(Document doc);
}
