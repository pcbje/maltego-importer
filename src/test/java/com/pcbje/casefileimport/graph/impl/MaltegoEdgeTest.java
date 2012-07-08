package com.pcbje.casefileimport.graph.impl;

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

import com.pcbje.graphimport.graph.impl.MaltegoEdge;
import com.pcbje.graphimport.graph.impl.MaltegoNode;


/**
 *
 * @author pcbje
 */
public class MaltegoEdgeTest {
    
    @Test
    public void testSetEdgeSourceAndDestination() {
        MaltegoEdge edge = new MaltegoEdge("edge id", "edge label");
        
        MaltegoNode source = new MaltegoNode("src id", "srctype");        
        MaltegoNode target = new MaltegoNode("target id", "desttype");
        
        edge.setSourceNode(source);
        edge.setTargetNode(target);
        
        assertEquals("src id", edge.getSourceNode().getId());
        assertEquals("target id", edge.getTargetNode().getId());
        
        
    }
    
    @Test(expected = RuntimeException.class)
    public void testEdgeIdImmutable() {
        MaltegoEdge first = new MaltegoEdge("id", "label");        
        MaltegoEdge second = new MaltegoEdge("different id", "label");
        
        first.mergeWith(second);
    }
    
    @Test
    public void testEdgeLabelMutable() {
        MaltegoEdge first = new MaltegoEdge("id", "label");        
        MaltegoEdge second = new MaltegoEdge("id", "different label");
        
        first.mergeWith(second);
        
        assertEquals("different label", first.getLabel());
    }  
    
    @Test
    public void testEdgeMerge() {
        MaltegoEdge first = new MaltegoEdge("id", "label");       
        first.addAttribute("key 1", "value 1");
        first.addAttribute("key 2", "value 2");
        
        MaltegoEdge second = new MaltegoEdge("id", "different label");
        second.addAttribute("key 1", "value 3");
        second.addAttribute("key 3", "value 4");
        
        first.mergeWith(second);
        
        assertEquals("value 3", first.getAttribute("key 1"));
        assertEquals("value 2", first.getAttribute("key 2"));
        assertEquals("value 4", first.getAttribute("key 3"));
    }  
    
    @Test
    public void testGetEdgeGraphML() {
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.newDocument();
            
            MaltegoEdge edge = new MaltegoEdge("edge id", "edge label");
            
			MaltegoNode source = new MaltegoNode("src id","srctype");
            
			MaltegoNode target = new MaltegoNode("target id", "desttype");
            
            edge.setSourceNode(source);
            edge.setTargetNode(target);
            
            Element graphML = edge.getXML(doc);
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
            
            assertEquals("0", properties.getElementsByTagName("mtg:Property").item(0).getFirstChild().getTextContent());
            assertEquals("maltego.link.show-label", ((Element) properties.getElementsByTagName("mtg:Property").item(0)).getAttribute("name"));
            
            assertEquals("2", properties.getElementsByTagName("mtg:Property").item(1).getFirstChild().getTextContent());
            assertEquals("maltego.link.thickness", ((Element) properties.getElementsByTagName("mtg:Property").item(1)).getAttribute("name"));
            
            assertEquals(edge.getLabel(), properties.getElementsByTagName("mtg:Property").item(2).getFirstChild().getTextContent());
            assertEquals("maltego.link.manual.type", ((Element) properties.getElementsByTagName("mtg:Property").item(2)).getAttribute("name"));
            
            assertEquals("0", properties.getElementsByTagName("mtg:Property").item(3).getFirstChild().getTextContent());
            assertEquals("maltego.link.style", ((Element) properties.getElementsByTagName("mtg:Property").item(3)).getAttribute("name"));
            
            assertEquals("", properties.getElementsByTagName("mtg:Property").item(4).getFirstChild().getTextContent());
            assertEquals("maltego.link.manual.description", ((Element) properties.getElementsByTagName("mtg:Property").item(4)).getAttribute("name"));
            
            assertEquals("8421505", properties.getElementsByTagName("mtg:Property").item(5).getFirstChild().getTextContent());
            assertEquals("maltego.link.color", ((Element) properties.getElementsByTagName("mtg:Property").item(5)).getAttribute("name"));
            assertEquals("color", ((Element) properties.getElementsByTagName("mtg:Property").item(5)).getAttribute("type"));
            
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
