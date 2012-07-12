package com.pcbje.maltegoimporter.model;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * Model representing an edge in GraphML.
 * 
 * @author pcbje
 */
public interface EdgeModel extends PropertyHolderModel {
	/**
	 * @return the Id of the edge.
	 */
	public String getId();

	/**
	 * @return The type of the edge.
	 */
	public String getType();

	/**
	 * @return The node representing the source of the edge.
	 */
	public NodeModel getSourceNode();

	/**
	 * @return The node representing the target of the edge.
	 */
	public NodeModel getTargetNode();

	/**
	 * @param doc The document that will create the XML element.
	 * @return The edge data represented as GraphML. 
	 */
	public Element getGraphML(Document doc);
}
