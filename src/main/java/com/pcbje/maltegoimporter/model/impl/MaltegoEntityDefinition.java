package com.pcbje.maltegoimporter.model.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import com.pcbje.maltegoimporter.model.EntityDefinition;
import com.pcbje.maltegoimporter.model.PropertyModel;

public class MaltegoEntityDefinition implements EntityDefinition {
	private Logger logger = Logger.getLogger(MaltegoEntityDefinition.class
			.getName());

	private Document types;

	public MaltegoEntityDefinition() {
		DocumentBuilderFactory factory = null;
		DocumentBuilder builder = null;

		try {
			factory = DocumentBuilderFactory.newInstance();
			builder = factory.newDocumentBuilder();

			types = builder.parse(new InputSource(this.getClass()
					.getClassLoader().getResource("maltego-entities.xml")
					.openStream()));
		} catch (Exception e) {
			logger.log(Level.WARNING, e.getMessage(), e);
		}
	}

	public Map<String, PropertyModel> getProperties(String type) {
		if (types.getElementsByTagName(type).getLength() == 0) {
			throw new RuntimeException("I don't know the nodetype " + type
					+ ".");
		}

		Element nodeType = (Element) types.getElementsByTagName(type).item(0);

		NodeList propertyElements = nodeType.getElementsByTagName("property");

		Map<String, PropertyModel> properties = new HashMap<String, PropertyModel>();

		Element property;

		for (int c = 0; c < propertyElements.getLength(); c++) {
			property = (Element) propertyElements.item(c);

			properties.put(
					property.getAttribute("name"),
					new MaltegoPropertyModel(property.getAttribute("name"),
							property.getAttribute("displayName"), property
									.getAttribute("type"), property
									.getAttribute("label").equals("true")));
		}

		return properties;
	}

}
