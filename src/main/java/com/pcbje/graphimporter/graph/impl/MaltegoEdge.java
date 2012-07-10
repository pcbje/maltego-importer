package com.pcbje.graphimporter.graph.impl;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.pcbje.graphimporter.graph.EdgeEntity;
import com.pcbje.graphimporter.graph.NodeEntity;
import com.pcbje.graphimporter.graph.PropertyEntity;
import com.pcbje.graphimporter.model.EdgeModel;
import com.pcbje.graphimporter.model.PropertyModel;

/**
 *
 * @author pcbje
 */
public class MaltegoEdge implements EdgeEntity {	
    private final String id;
    private final String type;
    
    private String sourceNodeId;
    private String targetNodeId;

    private final List<PropertyEntity> properties;
    
    public MaltegoEdge(EdgeModel model) {
    	this.id = model.getId();
    	this.type = model.getType();
    	
    	this.sourceNodeId = model.getSourceNode().getNodeId();
    	this.targetNodeId = model.getTargetNode().getNodeId();
    	
    	properties = new ArrayList<PropertyEntity>();
    	
    	for (PropertyModel property : model.getProperties().values()) {
    		properties.add(new MaltegoProperty(property));
    	}
    }

    public MaltegoEdge(String id, String type, NodeEntity sourceNode, NodeEntity targetNode) {    	
    	this.id = id;
    	this.type = type;
    	
    	properties = new ArrayList<PropertyEntity>();
    }

    public String getSourceNodeId() {
        return sourceNodeId;
    }
    
    public String getTargetNodeId() {
        return targetNodeId;
    }

    public void addProperty(PropertyEntity property) {
        properties.add(property);
    }

    public List<PropertyEntity> getProperties() {
        return properties;
    }

    public void mergeWith(MaltegoEdge otherEdge) {
        if (!id.equals(otherEdge.id)) {
            throw new RuntimeException("Trying to change edge ID from "
                    + id + " to " + otherEdge.id + " for edge " + id);
        }

        for (PropertyEntity property : otherEdge.getProperties()) {
            properties.add(property);
        }
    }

    public Element getGraphML(Document doc) {
        Element edge = doc.createElement("edge");
        edge.setAttribute("id", id);
        edge.setAttribute("source", sourceNodeId);
        edge.setAttribute("target", targetNodeId);

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
      
        for (PropertyEntity property : properties) {
        	propertiesElement.appendChild(property.getGraphML(doc));
        }       

        return edge;
    }
}
