package com.pcbje.graphimporter.model.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.pcbje.graphimporter.model.NodeType;
import com.pcbje.graphimporter.model.PropertyModel;

public class MaltegoNodeType implements NodeType {
	private Element types;

	public MaltegoNodeType() {
		DocumentBuilderFactory factory = null;
		DocumentBuilder builder = null;

		try {
			factory = DocumentBuilderFactory.newInstance();
			builder = factory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}

		try {
			types = (Element) builder.parse(
					new InputSource(ClassLoader.class
							.getResourceAsStream("maltego-node-types.xml")))
					.getFirstChild();

		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public List<PropertyModel> getProperties(String type, String label) {
		if (types.getElementsByTagName(type).getLength() == 0) {
			throw new RuntimeException("I don't know the nodetype " + type
					+ ".");
		}

		Element nodeType = (Element) types.getElementsByTagName(type).item(0);

		NodeList propertyElements = nodeType.getElementsByTagName("property");

		List<PropertyModel> properties = new ArrayList<PropertyModel>();

		Element property;

		for (int c = 0; c < propertyElements.getLength(); c++) {
			property = (Element) propertyElements.item(c);

			properties.add(new MaltegoPropertyModel(property
					.getAttribute("name"), property.getAttribute("displayName"),
					property.getAttribute("type"), property
							.getAttribute("value")));
		}
		
		return properties;
	}

}
