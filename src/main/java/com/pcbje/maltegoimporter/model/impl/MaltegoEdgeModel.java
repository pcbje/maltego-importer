package com.pcbje.maltegoimporter.model.impl;

import java.util.Map;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.pcbje.maltegoimporter.model.EdgeModel;
import com.pcbje.maltegoimporter.model.NodeModel;
import com.pcbje.maltegoimporter.model.PropertyModel;

/**
 * Model representing a Maltego edge in GraphML.
 * 
 * @author pcbje
 */
public class MaltegoEdgeModel implements EdgeModel {
	private final String id;
	private final String type;
	
	private final NodeModel sourceNode;
	private final NodeModel targetNode;
	
	private static MaltegoEntityDefinition entityDefs;
	
	private final Map<String, PropertyModel> properties;
	
	private static int ID_COUNTER = 0;
	
	public MaltegoEdgeModel(NodeModel sourceNode, NodeModel targetNode, String label) {
		this.id = "e" + Integer.toString(ID_COUNTER++);
		
		this.type = "maltego.link.manual-link";
		
		this.sourceNode = sourceNode;
		this.targetNode = targetNode;
		
		if (entityDefs == null) {
			entityDefs = new MaltegoEntityDefinition();
		}
		
		properties = entityDefs.getProperties(this.type);	
		
		properties.get("Label").setValue(label);
		properties.get("Show Label").setValue("0");
		properties.get("Thickness").setValue("2");
		properties.get("Style").setValue("0");
		properties.get("Description").setValue("");
		properties.get("Color").setValue("8421505");
	}

	/**
	 * {@inheritDoc}
	 */
	public String getId() {
		return id;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public String getType() {
		return type;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public NodeModel getSourceNode() {
		return sourceNode;
	}

	/**
	 * {@inheritDoc}
	 */
	public NodeModel getTargetNode() {
		return targetNode;
	}

	/**
	 * {@inheritDoc}
	 */
	public void setProperty(String propertyDisplayName, String value) {
		PropertyModel property = properties.get(propertyDisplayName);

		if (property == null) {
			throw new RuntimeException("No properties of node type '" + type
					+ "' has the display name '" + propertyDisplayName + "'");
		}

		property.setValue(value);
	}

	/**
	 * {@inheritDoc}
	 */
	public Map<String, PropertyModel> getProperties() {
		return properties;
	}

	/**
	 * {@inheritDoc}
	 */
	public Element getGraphML(Document doc) {
        Element edge = doc.createElement("edge");
        edge.setAttribute("id", id);
        edge.setAttribute("source", sourceNode.getNodeId());
        edge.setAttribute("target", targetNode.getNodeId());

        Element data = doc.createElement("data");
        data.setAttribute("key", "d6");
        edge.appendChild(data);
        
        Element data2 = doc.createElement("data");
        data2.setAttribute("key", "d7");
        edge.appendChild(data2);
        
        Element linkRenderer = doc.createElement("mtg:LinkRenderer");
        linkRenderer.setAttribute("xmlns:mtg", "http://maltego.paterva.com/xml/mtgx");
        data2.appendChild(linkRenderer);

        Element maltegoLink = doc.createElement("mtg:MaltegoLink");
        maltegoLink.setAttribute("xmlns:mtg", "http://maltego.paterva.com/xml/mtgx");
        maltegoLink.setAttribute("type", type);
        data.appendChild(maltegoLink);

        Element propertiesElement = doc.createElement("mtg:Properties");
        maltegoLink.appendChild(propertiesElement);
      
        for (PropertyModel property : properties.values()) {
        	propertiesElement.appendChild(property.getGraphML(doc));
        }       

        return edge;
    }
}
