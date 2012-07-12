package com.pcbje.maltegoimporter.model;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * Model representing a graph in GraphML.
 * 
 * @author pcbje
 */
public interface GraphModel {
	/**
	 * Add a node to the graph.
	 * 
	 * @param node The node to add.
	 */
	public void addNode(NodeModel node);

	/**
	 * Add an edge to the graph.
	 * 
	 * @param edge The edge to add.
	 */
	public void addEdge(EdgeModel edge);

	/**
	 * @param doc The document that will create the XML element.
	 * @return The graph data represented as GraphML. 
	 */
	public Element getGraphML(Document doc);
}
