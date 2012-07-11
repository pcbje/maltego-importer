package com.pcbje.maltegoimporter.model;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public interface GraphModel {
	public void addNode(NodeModel node);

	public void addEdge(EdgeModel edge);

	public Element getGraphML(Document doc);
}
