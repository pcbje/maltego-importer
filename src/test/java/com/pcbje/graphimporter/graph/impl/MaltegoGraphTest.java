package com.pcbje.graphimporter.graph.impl;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.pcbje.graphimporter.graph.impl.MaltegoEdge;
import com.pcbje.graphimporter.graph.impl.MaltegoGraph;
import com.pcbje.graphimporter.graph.impl.MaltegoNode;

/**
 *
 * @author pcbje
 */
public class MaltegoGraphTest {
    @Test
    public void testAddNodeIsMerged() {
        MaltegoGraph graph = new MaltegoGraph();
        MaltegoNode first = new MaltegoNode("id", "type");
        
        MaltegoNode second = new MaltegoNode("id", "type");
        
        graph.addNode("id", first);
        graph.addNode("id", second);
        
        assertEquals(1, graph.getNodes().size());
    }
    
    @Test
    public void testAddEdgeIsMerges() {
        MaltegoGraph graph = new MaltegoGraph();
        
        MaltegoEdge first = new MaltegoEdge("id", "oldlabel");
        MaltegoEdge second = new MaltegoEdge("id", "newlabel");
        
        graph.addEdge(first.getId(), first);
        graph.addEdge(second.getId(), second);
        
        assertEquals(1, graph.getEdges().size());
    }
    
    @Test
    public void testGetGraphMLSimple() throws ParserConfigurationException {
        MaltegoGraph graph = new MaltegoGraph();
        
        MaltegoNode first = new MaltegoNode("node 1", "type1");
        MaltegoNode second = new MaltegoNode("node 2", "type2");
                
        graph.addNode(first.getId(), first);
        graph.addNode(second.getId(), second);
        
        MaltegoEdge edge = new MaltegoEdge("edge 1", "edge label 1");
        edge.setSourceNode(first);
        edge.setTargetNode(second);
        
        graph.addEdge(edge.getId(), edge);
        
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
        Document doc = docBuilder.newDocument();
        
        Element graphML = graph.getGraphML(doc);
        assertNotNull(graphML);
        assertEquals("http://graphml.graphdrawing.org/xmlns", graphML.getAttribute("xmlns"));
        assertEquals("http://www.w3.org/2001/XMLSchema-instance", graphML.getAttribute("xmlns:xsi"));
        assertEquals("http://www.yworks.com/xml/graphml", graphML.getAttribute("xmlns:y"));
        assertEquals("http://graphml.graphdrawing.org/xmlns http://www.yworks.com/xml/schema/graphml/1.1/ygraphml.xsd", graphML.getAttribute("xsi:schemaLocation"));
                
        Element versionInfo = (Element) graphML.getElementsByTagName("VersionInfo").item(0);
        assertNotNull(versionInfo);
        assertEquals("Maltego CaseFile Community", versionInfo.getAttribute("createdBy"));
        assertEquals("", versionInfo.getAttribute("subtitle"));
        assertEquals("1.0.1.2483", versionInfo.getAttribute("version"));
        
        Element d0 = (Element) graphML.getElementsByTagName("key").item(0);
        assertNotNull(d0);
        assertEquals("graphml", d0.getAttribute("for"));
        assertEquals("d0", d0.getAttribute("id"));
        assertEquals("resources", d0.getAttribute("yfiles.type"));
        
        Element d1 = (Element) graphML.getElementsByTagName("key").item(1);
        assertNotNull(d1);
        assertEquals("port", d1.getAttribute("for"));
        assertEquals("d1", d1.getAttribute("id"));
        assertEquals("portgraphics", d1.getAttribute("yfiles.type"));
        
        Element d2 = (Element) graphML.getElementsByTagName("key").item(2);
        assertNotNull(d2);
        assertEquals("port", d2.getAttribute("for"));
        assertEquals("d2", d2.getAttribute("id"));
        assertEquals("portgeometry", d2.getAttribute("yfiles.type"));
        
        Element d3 = (Element) graphML.getElementsByTagName("key").item(3);
        assertNotNull(d3);
        assertEquals("port", d3.getAttribute("for"));
        assertEquals("d3", d3.getAttribute("id"));
        assertEquals("portuserdata", d3.getAttribute("yfiles.type"));
        
        Element d4 = (Element) graphML.getElementsByTagName("key").item(4);
        assertNotNull(d4);
        assertEquals("node", d4.getAttribute("for"));
        assertEquals("d4", d4.getAttribute("id"));
        assertEquals("", d4.getAttribute("yfiles.type"));
        assertEquals("MaltegoEntity", d4.getAttribute("attr.name"));
        
        Element d5 = (Element) graphML.getElementsByTagName("key").item(5);
        assertNotNull(d5);
        assertEquals("node", d5.getAttribute("for"));
        assertEquals("d5", d5.getAttribute("id"));
        assertEquals("nodegraphics", d5.getAttribute("yfiles.type"));
        
        Element d6 = (Element) graphML.getElementsByTagName("key").item(6);
        assertNotNull(d6);
        assertEquals("edge", d6.getAttribute("for"));
        assertEquals("d6", d6.getAttribute("id"));
        assertEquals("", d6.getAttribute("yfiles.type"));
        assertEquals("MaltegoLink", d6.getAttribute("attr.name"));
        
        Element d7 = (Element) graphML.getElementsByTagName("key").item(7);
        assertNotNull(d7);
        assertEquals("edge", d7.getAttribute("for"));
        assertEquals("d7", d7.getAttribute("id"));
        assertEquals("edgegraphics", d7.getAttribute("yfiles.type"));
        
        Element graphElement = (Element) graphML.getElementsByTagName("graph").item(0);
        assertEquals("directed", graphElement.getAttribute("edgedefault"));
        assertEquals("G", graphElement.getAttribute("id"));
        assertNotNull(graphElement);
        
        assertEquals(2, graphElement.getElementsByTagName("node").getLength());
        assertEquals(1, graphElement.getElementsByTagName("edge").getLength());
    }
}
