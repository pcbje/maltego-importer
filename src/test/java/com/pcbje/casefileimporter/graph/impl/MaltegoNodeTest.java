package com.pcbje.casefileimporter.graph.impl;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.pcbje.graphimporter.graph.PropertyEntity;
import com.pcbje.graphimporter.graph.impl.MaltegoNode;
import com.pcbje.graphimporter.graph.impl.MaltegoProperty;

/**
 * 
 * @author pcbje
 */
public class MaltegoNodeTest {

	@Test
	public void testNodeMergeAttributes() {
		MaltegoNode first = new MaltegoNode("id", "type");
		first.addProperty(new MaltegoProperty("a", "b", "c", "d"));
		first.addProperty(new MaltegoProperty("e", "f", "g", "h"));

		MaltegoNode second = new MaltegoNode("id", "type");
		first.addProperty(new MaltegoProperty("i", "j", "k", "L"));
		first.addProperty(new MaltegoProperty("m", "n", "o", "p"));

		first.mergeWith(second);

		List<PropertyEntity> props = first.getProperties();

		assertEquals("b", props.get(0).getPropertyValue("displayName"));
		assertEquals("g", props.get(1).getPropertyValue("type"));
		assertEquals("L", props.get(2).getValue());
		assertEquals("a", props.get(0).getPropertyValue("name"));
	}

	@Test(expected = RuntimeException.class)
	public void testNodeIdImmutable() {
		MaltegoNode first = new MaltegoNode("id", "type");
		MaltegoNode second = new MaltegoNode("different id", "type");

		first.mergeWith(second);
	}

	@Test(expected = RuntimeException.class)
	public void testNodeTypeImmutable() {
		MaltegoNode first = new MaltegoNode("id", "type");
		MaltegoNode second = new MaltegoNode("id", "differenttype");

		first.mergeWith(second);
	}

	@Test
	public void testGetNodeGraphML() throws ParserConfigurationException {

		DocumentBuilderFactory docFactory = DocumentBuilderFactory
				.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
		Document doc = docBuilder.newDocument();

		MaltegoNode node = new MaltegoNode("node id", "nodetype");

		node.addProperty(new MaltegoProperty("a", "b", "c", "node label"));

		Element graphML = node.getGraphML(doc);
		assertNotNull(graphML);
		assertEquals("node id", graphML.getAttribute("id"));
		Element data = (Element) graphML.getElementsByTagName("data").item(0);
		assertNotNull(data);
		assertNotNull(data.getAttribute("key"));

		Element maltegoDefaultNode = (Element) data.getElementsByTagName(
				"mtg:MaltegoEntity").item(0);
		assertNotNull(maltegoDefaultNode);
		assertEquals("http://maltego.paterva.com/xml/mtgx",
				maltegoDefaultNode.getAttribute("xmlns:mtg"));
		assertEquals("nodetype", maltegoDefaultNode.getAttribute("type"));

		Element properties = (Element) maltegoDefaultNode.getElementsByTagName(
				"mtg:Properties").item(0);
		assertNotNull(properties);

		Element labelProperty = (Element) properties.getElementsByTagName(
				"mtg:Property").item(0);
		assertNotNull(labelProperty);
		assertNotNull(labelProperty.getAttribute("displayName"));
		assertNotNull(labelProperty.getAttribute("hidden"));
		assertNotNull(labelProperty.getAttribute("name"));
		assertNotNull(labelProperty.getAttribute("nullable"));
		assertNotNull(labelProperty.getAttribute("readonly"));
		assertNotNull(labelProperty.getAttribute("type"));

		Element labelPropertyValue = (Element) labelProperty
				.getElementsByTagName("mtg:Value").item(0);
		assertNotNull(labelPropertyValue);
		assertEquals("node label", labelPropertyValue.getTextContent());
	}
}
