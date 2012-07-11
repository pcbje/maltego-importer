package com.pcbje.maltegoimporter.model;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public interface NodeModel extends PropertyHolderModel {
	/**
	 * @return the Id of the node.
	 */
	public String getNodeId();
	
	public void setNodeId(String string);

	/**
	 * @return The type of the node.
	 */
	public String getNodeType();
	

	public String getNodeLabel();

	/**
	 * @param doc The document that will create the XML element.
	 * @return The node data represented as GraphML. 
	 */
	public Element getGraphML(Document doc);
}
