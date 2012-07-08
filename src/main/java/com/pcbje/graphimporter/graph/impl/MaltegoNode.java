package com.pcbje.graphimporter.graph.impl;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.pcbje.graphimporter.graph.NodeEntity;
import com.pcbje.graphimporter.graph.PropertyEntity;

/**
 *
 * @author pcbje
 */
public class MaltegoNode implements NodeEntity {
    private final String id;
    private final String type;    
        
    private List<PropertyEntity> properties;

    public MaltegoNode(String id, String type) {
        this.id = id;
        this.type = type;

        properties = new ArrayList<PropertyEntity>();
    }

    public void addProperty(PropertyEntity attribute) {
        properties.add(attribute);
    }

    public List<PropertyEntity> getProperties() {
        return properties;
    }

    public String getId() {
        return id;
    }
    

    public String getType() {
        return type;
    }



    public void mergeWith(MaltegoNode otherNode) {
        if (!id.equals(otherNode.getId())) {
            throw new RuntimeException("Trying to change node ID from "
                    + id + " to " + otherNode.getId() + " for node " + id);
        }

        if (!type.equals(otherNode.getType())) {
            throw new RuntimeException("Trying to change node type from "
                    + type + " to " + otherNode.getType() + " for node " + id);
        }        

        for (PropertyEntity property : otherNode.getProperties()) {
            properties.add(property);
        }
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

        Element props = doc.createElement("mtg:Properties");

        for (PropertyEntity property : properties) {
        	props.appendChild(property.getGraphML(doc));
        }
        
        maltegoEntity.appendChild(props);

        return node;
    }
}
