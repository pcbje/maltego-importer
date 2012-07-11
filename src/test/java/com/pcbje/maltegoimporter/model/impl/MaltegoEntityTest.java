package com.pcbje.maltegoimporter.model.impl;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import com.pcbje.maltegoimporter.model.EntityDefinition;

public class MaltegoEntityTest {
	private static EntityDefinition entityDefs;

	@Before
	public void init() {
		if (entityDefs == null) {
			entityDefs = new MaltegoEntityDefinition();
		}
	}

	@Test
	public void testThatEnumValuesAreCorrect() {
		for (MaltegoEntity entity : MaltegoEntity.values()) {
			entityDefs.getProperties(entity.getName());
		}
	}

	@Test
	public void testThatAllEntitiesInXmlFileAreIncludedInEnum()
			throws Exception {
		DocumentBuilderFactory factory = null;
		DocumentBuilder builder = null;

		factory = DocumentBuilderFactory.newInstance();
		builder = factory.newDocumentBuilder();

		Document types = builder.parse(new InputSource(this.getClass()
				.getClassLoader().getResource("maltego-entities.xml")
				.openStream()));

		NodeList list = types.getChildNodes().item(0).getChildNodes();

		List<String> enums = new ArrayList<String>();
				
		for (MaltegoEntity entity : MaltegoEntity.values()) {
			enums.add(entity.getName());
		}

		for (int i = 0; i < list.getLength(); i++) {
			if (!list.item(i).getNodeName().startsWith("#")
					&& !enums.contains(list.item(i).getNodeName())) {
				fail("Enums don't include type: " + list.item(i).getNodeName()
						+ " (enum size: " + enums.size() + ")");
			}
		}
	}
}
