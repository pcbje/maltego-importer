package com.pcbje.graphimporter.graph.impl;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;


/**
 *
 * @author pcbje
 */
public class MaltegoEdgeTest {
    
    @Test
    public void testSetEdgeSourceAndDestination() {
        MaltegoNode source = new MaltegoNode("src id", "srctype");        
        MaltegoNode target = new MaltegoNode("target id", "desttype");
        
        MaltegoEdge edge = new MaltegoEdge("edge id", "edge type", source, target);
        
        assertEquals("src id", edge.getSourceNodeId());
        assertEquals("target id", edge.getTargetNodeId());
    }
    
    @Test(expected = RuntimeException.class)
    public void testEdgeIdImmutable() {
        MaltegoEdge first = new MaltegoEdge("edge id 1", "edge type", null, null);        
        MaltegoEdge second = new MaltegoEdge("edge id 2", "edge type", null, null);
        
        first.mergeWith(second);
    }
    
    @Test
    public void testGetEdgeGraphML() {
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.newDocument();
            
            MaltegoNode source = new MaltegoNode("src id","srctype");
            
			MaltegoNode target = new MaltegoNode("target id", "desttype");
            
            MaltegoEdge edge = new MaltegoEdge("edge id", "maltego.link.manual-link", source, target);
            edge.addProperty(new MaltegoProperty("maltego.link.manual.type", "Label", "string", "edge label"));
            
            Element graphML = edge.getGraphML(doc);
            assertNotNull(graphML);
            assertEquals("edge id", graphML.getAttribute("id"));
            assertEquals(source.getId(), graphML.getAttribute("source"));
            
            Element data = (Element) graphML.getElementsByTagName("data").item(0);
            assertNotNull(data);
            assertEquals("d6", data.getAttribute("key"));
            
            Element maltegoLink = (Element) data.getElementsByTagName("mtg:MaltegoLink").item(0);
            assertNotNull(maltegoLink);
            assertEquals("http://maltego.paterva.com/xml/mtgx", maltegoLink.getAttribute("xmlns:mtg"));
            assertEquals("maltego.link.manual-link", maltegoLink.getAttribute("type")); 
            
            Element properties = (Element) maltegoLink.getElementsByTagName("mtg:Properties").item(0);
            assertNotNull(properties);    
            
            Element showLabelProperty = (Element) properties.getElementsByTagName("mtg:Property").item(0);
            assertNotNull(showLabelProperty);
            assertNotNull(showLabelProperty.getAttribute("displayName"));
            assertNotNull(showLabelProperty.getAttribute("hidden"));
            assertNotNull(showLabelProperty.getAttribute("name"));
            assertNotNull(showLabelProperty.getAttribute("nullable"));
            assertNotNull(showLabelProperty.getAttribute("readonly"));
            assertNotNull(showLabelProperty.getAttribute("type"));       
            
            Element data1 = (Element) graphML.getElementsByTagName("data").item(1);
            assertNotNull(data1);
            Element linkRenderer = (Element) data1.getElementsByTagName("mtg:LinkRenderer").item(0);
            assertNotNull(linkRenderer);
            assertEquals("http://maltego.paterva.com/xml/mtgx", linkRenderer.getAttribute("xmlns:mtg"));
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(MaltegoEdgeTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
