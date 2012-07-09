package com.pcbje.graphimporter.graph.impl;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.pcbje.graphimporter.graph.EdgeEntity;
import com.pcbje.graphimporter.graph.NodeEntity;
import com.pcbje.graphimporter.graph.PropertyEntity;

/**
 *
 * @author pcbje
 */
public class MaltegoEdge implements EdgeEntity {	
    private final String id;
    private final String type;
    private final List<PropertyEntity> properties;
    private NodeEntity sourceNode;
    private NodeEntity targetNode;

    public MaltegoEdge(String id, String label) {    	
        this.id = id;
        
        type = "maltego.link.manual-link";

        properties = new ArrayList<PropertyEntity>();
        
        properties.add(new MaltegoProperty("maltego.link.manual.type", "Label", "string", label));
        properties.add(new MaltegoProperty("maltego.link.show-label", "Show label", "int", "1"));
        properties.add(new MaltegoProperty("maltego.link.thickness", "Thickness", "int", "2"));
        properties.add(new MaltegoProperty("maltego.link.style", "Style", "int", "0"));
        properties.add(new MaltegoProperty("maltego.link.manual.description", "Description", "string", ""));
        properties.add(new MaltegoProperty("maltego.link.color", "Color", "color", "8421505"));
    }

    public String getId() {
        return id;
    }

    public void setSourceNode(NodeEntity sourceNode) {
        this.sourceNode = sourceNode;
    }

    public NodeEntity getSourceNode() {
        return sourceNode;
    }

    public void setTargetNode(NodeEntity targetNode) {
        this.targetNode = targetNode;
    }

    public NodeEntity getTargetNode() {
        return targetNode;
    }

    public void addProperty(PropertyEntity property) {
        properties.add(property);
    }

    public List<PropertyEntity> getProperties() {
        return properties;
    }

    public void mergeWith(MaltegoEdge otherEdge) {
        if (!id.equals(otherEdge.getId())) {
            throw new RuntimeException("Trying to change edge ID from "
                    + id + " to " + otherEdge.getId() + " for edge " + id);
        }

        for (PropertyEntity property : otherEdge.getProperties()) {
            properties.add(property);
        }
    }

    public Element getGraphML(Document doc) {
        Element edge = doc.createElement("edge");
        edge.setAttribute("id", id);
        edge.setAttribute("source", sourceNode.getId());
        edge.setAttribute("target", targetNode.getId());

        Element data = doc.createElement("data");
        data.setAttribute("key", "d6");
        edge.appendChild(data);
        
        Element data2 = doc.createElement("data");
        data2.setAttribute("id", "d7");
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
