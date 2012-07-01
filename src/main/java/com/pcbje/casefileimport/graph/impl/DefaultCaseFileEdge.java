package com.pcbje.casefileimport.graph.impl;

import com.pcbje.casefileimport.CaseFileException;
import com.pcbje.casefileimport.graph.CaseFileEdge;
import com.pcbje.casefileimport.graph.CaseFileNode;
import java.util.HashMap;
import java.util.Map;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 * @author pcbje
 */
public class DefaultCaseFileEdge implements CaseFileEdge {

    private final String id;
    private String label;
    private Map<String, String> attributes;
    private CaseFileNode sourceNode;
    private CaseFileNode targetNode;

    public DefaultCaseFileEdge(String id, String label) {
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

    public void setSourceNode(CaseFileNode sourceNode) {
        this.sourceNode = sourceNode;
    }

    public CaseFileNode getSourceNode() {
        return sourceNode;
    }

    public void setTargetNode(CaseFileNode targetNode) {
        this.targetNode = targetNode;
    }

    public CaseFileNode getTargetNode() {
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

    public void mergeWith(CaseFileEdge otherEdge) {
        if (!id.equals(otherEdge.getId())) {
            throw new CaseFileException("Trying to change edge ID from "
                    + id + " to " + otherEdge.getId() + " for edge " + id);
        }

        label = otherEdge.getLabel();

        for (String key : otherEdge.getAttributes().keySet()) {
            attributes.put(key, otherEdge.getAttribute(key));
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
