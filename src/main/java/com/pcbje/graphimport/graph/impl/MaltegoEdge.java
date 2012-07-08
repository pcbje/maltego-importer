package com.pcbje.graphimport.graph.impl;

import java.util.HashMap;
import java.util.Map;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.pcbje.graphimport.graph.EdgeEntity;
import com.pcbje.graphimport.graph.NodeEntity;

/**
 *
 * @author pcbje
 */
public class MaltegoEdge implements EdgeEntity {

    private final String id;
    private String label;
    private Map<String, String> attributes;
    private NodeEntity sourceNode;
    private NodeEntity targetNode;

    public MaltegoEdge(String id, String label) {
        this.id = id;
        this.label = label;

        attributes = new HashMap<String, String>();
    }

    public String getId() {
        return id;
    }

    public String getLabel() {
        return label;
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

    public void addAttribute(String key, String value) {
        attributes.put(key, value);
    }

    public Map<String, String> getAttributes() {
        return attributes;
    }

    public String getAttribute(String key) {
        return attributes.get(key);
    }

    public void mergeWith(MaltegoEdge otherEdge) {
        if (!id.equals(otherEdge.getId())) {
            throw new RuntimeException("Trying to change edge ID from "
                    + id + " to " + otherEdge.getId() + " for edge " + id);
        }

        label = otherEdge.getLabel();

        for (String key : otherEdge.getAttributes().keySet()) {
            attributes.put(key, otherEdge.getAttribute(key));
        }
    }

    public Element getXML(Document doc) {
        Element edge = doc.createElement("edge");
        edge.setAttribute("id", id);
        edge.setAttribute("source", sourceNode.getId());
        edge.setAttribute("target", targetNode.getId());

        Element data = doc.createElement("data");
        data.setAttribute("key", "d6");
        edge.appendChild(data);

        Element maltegoLink = doc.createElement("mtg:MaltegoLink");
        maltegoLink.setAttribute("xmlns:mtg", "http://maltego.paterva.com/xml/mtgx");
        maltegoLink.setAttribute("type", "maltego.link.manual-link");
        data.appendChild(maltegoLink);

        Element properties = doc.createElement("mtg:Properties");
        maltegoLink.appendChild(properties);

        properties.appendChild(createProperty(doc, "0", "Show Label", "false", "maltego.link.show-label", "true", "false", "int"));
        properties.appendChild(createProperty(doc, "2", "Thickness", "false", "maltego.link.thickness", "true", "false", "int"));
        properties.appendChild(createProperty(doc, label, "Label", "false", "maltego.link.manual.type", "true", "false", "string"));
        properties.appendChild(createProperty(doc, "0", "Style", "false", "maltego.link.style", "true", "false", "int"));
        properties.appendChild(createProperty(doc, "", "Description", "false", "maltego.link.manual.description", "true", "false", "string"));
        properties.appendChild(createProperty(doc, "8421505", "Color", "false", "maltego.link.color", "true", "false", "color"));

        Element data2 = doc.createElement("data");
        data2.setAttribute("id", "d7");
        edge.appendChild(data2);

        Element linkRenderer = doc.createElement("mtg:LinkRenderer");
        linkRenderer.setAttribute("xmlns:mtg", "http://maltego.paterva.com/xml/mtgx");
        data2.appendChild(linkRenderer);

        return edge;
    }

    private Element createProperty(Document doc, String value, String displayName, String hidden, String name, String nullable, String readonly, String type) {
        Element property = doc.createElement("mtg:Property");
        property.setAttribute("displayName", displayName);
        property.setAttribute("hidden", hidden);
        property.setAttribute("name", name);
        property.setAttribute("nullable", nullable);
        property.setAttribute("readonly", readonly);
        property.setAttribute("type", type);

        Element valueElement = doc.createElement("mtg:Value");
        valueElement.setTextContent(value);
        property.appendChild(valueElement);

        return property;
    }
}
