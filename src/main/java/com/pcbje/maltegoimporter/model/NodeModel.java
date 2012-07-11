package com.pcbje.maltegoimporter.model;

import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public interface NodeModel extends PropertyHolderModel {
	public String getNodeId();

	public String getNodeType();

	public void addEdge(EdgeModel edge);

	public List<EdgeModel> getEdges();

	public Element getGraphML(Document doc);
}
