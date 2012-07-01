package com.pcbje.casefileimport.graph.impl;

import com.pcbje.casefileimport.CaseFileException;
import com.pcbje.casefileimport.graph.CaseFileNode;
import java.util.HashMap;
import java.util.Map;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 * @author pcbje
 */
public class DefaultCaseFileNode implements CaseFileNode {

    private final String id;
    private final String type;
    private final String group;
    
    private String label;
    private Map<String, String> attributes;

    public DefaultCaseFileNode(String id, String group, String type, String label) {
        if (!type.contains("maltego.") || type.contains(" ")) {
            throw new CaseFileException("Invalid node type " + type + "!");
        }

        this.id = id;
        this.group = group;
        this.type = type;
        this.label = label;

        attributes = new HashMap<String, String>();
    }

    public void addAttribute(String key, String value) {
        attributes.put(key, value);
    }

    public String getAttribute(String key) {
        return attributes.get(key);
    }

    public Map<String, String> getAttributes() {
        return attributes;
    }

    public String getId() {
        return id;
    }
    
    public String getGroup() {
        return group;
    }

    public String getType() {
        return type;
    }

    public String getLabel() {
        return label;
    }

    public void mergeWith(CaseFileNode otherNode) {
        if (!id.equals(otherNode.getId())) {
            throw new CaseFileException("Trying to change node ID from "
                    + id + " to " + otherNode.getId() + " for node " + id);
        }
        
        if (!group.equals(otherNode.getGroup())) {
            throw new CaseFileException("Trying to change node group from "
                    + group + " to " + otherNode.getGroup() + " for node " + id);
        }

        if (!type.equals(otherNode.getType())) {
            throw new CaseFileException("Trying to change node type from "
                    + type + " to " + otherNode.getType() + " for node " + id);
        }

        this.label = otherNode.getLabel();

        for (String key : otherNode.getAttributes().keySet()) {
            attributes.put(key, otherNode.getAttribute(key));
        }
    }

    public String getGroupDisplayName() {
        return group;
    }

    public String getGroupName() {
        return getGroupDisplayName().toLowerCase();
    }

    public Element getGraphML(Document doc) {
        Element node = doc.createElement("node");
        node.setAttribute("id", id);

        Element data = doc.createElement("data");
        data.setAttribute("key", "d4");
        node.appendChild(data);

        Element maltegoEntity = doc.createElement("mtg:MaltegoEntity");
        maltegoEntity.setAttribute("xmlns:mtg", "http://maltego.paterva.com/xml/mtgx");
        maltegoEntity.setAttribute("type", type);
        data.appendChild(maltegoEntity);

        Element properties = doc.createElement("mtg:Properties");
        maltegoEntity.appendChild(properties);

        Element labelProperty = doc.createElement("mtg:Property");
        labelProperty.setAttribute("displayName", getGroupDisplayName());
        labelProperty.setAttribute("hidden", "false");
        labelProperty.setAttribute("name", getGroupName());
        labelProperty.setAttribute("nullable", "true");
        labelProperty.setAttribute("readonly", "false");
        labelProperty.setAttribute("type", "string");
        properties.appendChild(labelProperty);

        Element labelPropertyValue = doc.createElement("mtg:Value");
        labelPropertyValue.setTextContent(label);
        labelProperty.appendChild(labelPropertyValue);

        return node;
    }
}
