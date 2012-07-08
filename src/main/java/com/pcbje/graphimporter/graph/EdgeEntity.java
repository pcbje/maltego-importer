package com.pcbje.graphimporter.graph;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public interface EdgeEntity {
	public void setSourceNode(NodeEntity source);
	public NodeEntity getSourceNode();
	
	public void setTargetNode(NodeEntity target);
	public NodeEntity getTargetNode();
	
	public Element getGraphML(Document doc);
}
