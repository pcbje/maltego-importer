package com.pcbje.maltegoimporter.model;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * Model representing a node in GraphML.
 * 
 * @author pcbje
 */
public interface NodeModel extends PropertyHolderModel {
	/**
	 * @return the Id of the node.
	 */
	public String getNodeId();
	
	/**
	 * Set a new node Id for this node.
	 * 
	 * @param string New node id.
	 */
	public void setNodeId(String string);

	/**
	 * @return The type of the node.
	 */
	public String getNodeType();
	
	/**
	 * Get the label of this node. The label is the value
	 * of one of the node's properties. Which property 
	 * that is label is defined in maltego-entities.xml.
	 * 
	 * @return Label of this node.
	 */
	public String getNodeLabel();

	/**
	 * @param doc The document that will create the XML element.
	 * @return The node data represented as GraphML. 
	 */
	public Element getGraphML(Document doc);
}
