package com.pcbje.casefileimport.graph.impl;

import com.pcbje.casefileimport.graph.CaseFileEdge;
import com.pcbje.casefileimport.graph.CaseFileGraph;
import com.pcbje.casefileimport.graph.CaseFileNode;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 *
 * @author pcbje
 */
public class DefaultCaseFileGraph implements CaseFileGraph {

    private Map<String, CaseFileNode> nodes;
    private Map<String, CaseFileEdge> edges;

    public DefaultCaseFileGraph() {
        nodes = new HashMap<String, CaseFileNode>();
        edges = new HashMap<String, CaseFileEdge>();
    }

    public void addNode(String id, CaseFileNode node) {
        if (nodes.containsKey(id)) {
            nodes.get(id).mergeWith(node);
        } else {
            nodes.put(id, node);
        }
    }

    public CaseFileNode getNode(String id) {
        return nodes.get(id);
    }

    public Map<String, CaseFileNode> getNodes() {
        return nodes;
    }

    public void addEdge(String id, CaseFileEdge edge) {
        if (edges.containsKey(id)) {
            edges.get(id).mergeWith(edge);
        } else {
            edges.put(id, edge);
        }
    }

    public Map<String, CaseFileEdge> getEdges() {
        return edges;
    }

    public CaseFileEdge getEdge(String id) {
        return edges.get(id);
    }

    public Element getGraphML() {
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.newDocument();

            Element graphML = doc.createElement("graphml");
            graphML.setAttribute("xmlns", "http://graphml.graphdrawing.org/xmlns");
            graphML.setAttribute("xmlns:xsi", "http://www.w3.org/2001/XMLSchema-instance");
            graphML.setAttribute("xmlns:y", "http://www.yworks.com/xml/graphml");
            graphML.setAttribute("xsi:schemaLocation", "http://graphml.graphdrawing.org/xmlns http://www.yworks.com/xml/schema/graphml/1.1/ygraphml.xsd");

            Element versionInfo = doc.createElement("VersionInfo");
            versionInfo.setAttribute("createdBy", "Maltego CaseFile Community");
            versionInfo.setAttribute("subtitle", "");
            versionInfo.setAttribute("version", "1.0.1.2483");
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
            graphElement.setAttribute("edgedefault", "directed");
            graphElement.setAttribute("id", "G");

            for (CaseFileNode node : nodes.values()) {
                graphElement.appendChild(node.getGraphML(doc));
            }

            for (CaseFileEdge edge : edges.values()) {
                graphElement.appendChild(edge.getGraphML(doc));
            }

            graphML.appendChild(graphElement);

            return graphML;
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(DefaultCaseFileGraph.class.getName()).log(Level.SEVERE, null, ex);

            return null;
        }
    }

    public String getGraphMLAsString() throws Exception {
        Source source = new DOMSource(getGraphML());
        StringWriter stringWriter = new StringWriter();
        Result result = new StreamResult(stringWriter);
        TransformerFactory factory = TransformerFactory.newInstance();
        Transformer transformer = factory.newTransformer();
        transformer.transform(source, result);

        return stringWriter.getBuffer().toString();
    }

    private Node createKey(Document doc, String attrName, String f, String id, String yFilesType) {
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
