package com.pcbje.graphimporter.graph.impl;

import java.util.HashMap;
import java.util.Map;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import com.pcbje.graphimporter.graph.EdgeEntity;
import com.pcbje.graphimporter.graph.GraphEntity;
import com.pcbje.graphimporter.graph.NodeEntity;

/**
 * 
 * @author pcbje
 */
public class MaltegoGraph implements GraphEntity {
	private final String graphId;
	private final String createdBy;
	private final String subtitle;
	private final String version;
	private final String edgeDefault;

	private final Map<String, MaltegoNode> nodes;
	private final Map<String, MaltegoEdge> edges;

	public MaltegoGraph() {
		graphId = "G";
		createdBy = "Maltego CaseFile Community";
		subtitle = "";
		version = "1.0.1.2483";
		edgeDefault = "directed";

		nodes = new HashMap<String, MaltegoNode>();
		edges = new HashMap<String, MaltegoEdge>();
	}

	public void addNode(String id, MaltegoNode node) {
		if (nodes.containsKey(id)) {
			nodes.get(id).mergeWith(node);
		} else {
			nodes.put(id, node);
		}
	}

	public MaltegoNode getNode(String id) {
		return nodes.get(id);
	}

	public Map<String, MaltegoNode> getNodes() {
		return nodes;
	}

	public void addEdge(String id, MaltegoEdge edge) {
		if (edges.containsKey(id)) {
			edges.get(id).mergeWith(edge);
		} else {
			edges.put(id, edge);
		}
	}

	public Map<String, MaltegoEdge> getEdges() {
		return edges;
	}

	public MaltegoEdge getEdge(String id) {
		return edges.get(id);
	}

	public Element getGraphML(Document doc) {
		Element graphML = doc.createElement("graphml");
		graphML.setAttribute("xmlns", "http://graphml.graphdrawing.org/xmlns");
		graphML.setAttribute("xmlns:xsi",
				"http://www.w3.org/2001/XMLSchema-instance");
		graphML.setAttribute("xmlns:y", "http://www.yworks.com/xml/graphml");
		graphML.setAttribute(
				"xsi:schemaLocation",
				"http://graphml.graphdrawing.org/xmlns http://www.yworks.com/xml/schema/graphml/1.1/ygraphml.xsd");

		Element versionInfo = doc.createElement("VersionInfo");
		versionInfo.setAttribute("createdBy", createdBy);
		versionInfo.setAttribute("subtitle", subtitle);
		versionInfo.setAttribute("version", version);
		graphML.appendChild(versionInfo);

		graphML.appendChild(createKey(doc, null, "graphml", "d0", "resources"));
		graphML.appendChild(createKey(doc, null, "port", "d1", "portgraphics"));
		graphML.appendChild(createKey(doc, null, "port", "d2", "portgeometry"));
		graphML.appendChild(createKey(doc, null, "port", "d3", "portuserdata"));
		graphML.appendChild(createKey(doc, "MaltegoEntity", "node", "d4", null));
		graphML.appendChild(createKey(doc, null, "node", "d5", "nodegraphics"));
		graphML.appendChild(createKey(doc, "MaltegoLink", "edge", "d6", null));
		graphML.appendChild(createKey(doc, null, "edge", "d7", "edgegraphics"));

		Element graphElement = doc.createElement("graph");
		graphElement.setAttribute("edgedefault", edgeDefault);
		graphElement.setAttribute("id", graphId);

		for (NodeEntity node : nodes.values()) {
			graphElement.appendChild(node.getGraphML(doc));
		}

		for (EdgeEntity edge : edges.values()) {
			graphElement.appendChild(edge.getGraphML(doc));
		}

		graphML.appendChild(graphElement);

		return graphML;
	}

	private Node createKey(Document doc, String attrName, String f, String id,
			String yFilesType) {
		Element key = doc.createElement("key");

		if (attrName != null) {
			key.setAttribute("attr.name", attrName);
		}

		key.setAttribute("for", f);
		key.setAttribute("id", id);
		if (yFilesType != null) {
			key.setAttribute("yfiles.type", yFilesType);
		}
		return key;
	}
}
