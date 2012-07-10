package com.pcbje.graphimporter.graph;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public interface GraphEntity {
	public void addNode(NodeEntity node);
	public void addEdge(EdgeEntity edge);
	public Element getGraphML(Document doc);
}
