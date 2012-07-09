package com.pcbje.casefileimporter.graph.impl;

import static org.junit.Assert.assertEquals;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.pcbje.graphimporter.graph.impl.MaltegoProperty;

public class MaltegoPropertyTest {
	@Test
	public void testMaltegoPropertyValues() {
		MaltegoProperty prop = new MaltegoProperty("namevalue", "displaynamevalue", "typevalue", "valuevalue");
		
		assertEquals("namevalue", prop.getPropertyValue("name"));
		assertEquals("displaynamevalue", prop.getPropertyValue("displayName"));
		assertEquals("typevalue", prop.getPropertyValue("type"));
		assertEquals("valuevalue", prop.getValue());
		assertEquals("false", prop.getPropertyValue("hidden"));
		assertEquals("true", prop.getPropertyValue("nullable"));
		assertEquals("false", prop.getPropertyValue("readonly"));
	}
	
	@Test
	public void testMaltegoPropertyXml() throws ParserConfigurationException {
		MaltegoProperty prop = new MaltegoProperty("namevalue", "displaynamevalue", "typevalue", "valuevalue");
		
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
        Document doc = docBuilder.newDocument();
		
		Element e = prop.getGraphML(doc);
		
		assertEquals("namevalue", e.getAttribute("name"));
		assertEquals("displaynamevalue", e.getAttribute("displayName"));
		assertEquals("typevalue", e.getAttribute("type"));
		assertEquals("false", e.getAttribute("hidden"));
		assertEquals("true", e.getAttribute("nullable"));
		assertEquals("false", e.getAttribute("readonly"));
		
		assertEquals(1, e.getChildNodes().getLength());
		
		Element c = (Element) e.getChildNodes().item(0);
		
		assertEquals("mtg:Value", c.getNodeName());
		
		assertEquals("valuevalue", e.getTextContent());
	}
}
