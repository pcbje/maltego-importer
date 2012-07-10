package com.pcbje.graphimporter.model.impl;

import static org.junit.Assert.assertEquals;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.pcbje.graphimporter.model.PropertyModel;

public class MaltegoLinkEntityDefinitionTest {
	MaltegoEntityDefinition type;

	@Before
	public void init() {
		type = new MaltegoEntityDefinition();
	}

	@Test
	public void testTypeDesktopComputer() {
		Map<String, PropertyModel> props = type
				.getProperties("link.manual-link");

		assertEquals(6, props.size());
		assertEquals(true, props.get("maltego.link.manual.type").isLabelProperty());
		assertEquals("Label", props.get("maltego.link.manual.type").getDisplayName());
		assertEquals("string", props.get("maltego.link.manual.type").getType());
		
		assertEquals(false, props.get("maltego.link.show-label").isLabelProperty());
		assertEquals("Show Label", props.get("maltego.link.show-label").getDisplayName());
		assertEquals("int", props.get("maltego.link.show-label").getType());
		
		assertEquals(false, props.get("maltego.link.thickness").isLabelProperty());
		assertEquals("Thickness", props.get("maltego.link.thickness").getDisplayName());
		assertEquals("int", props.get("maltego.link.thickness").getType());
		
		assertEquals(false, props.get("maltego.link.style").isLabelProperty());
		assertEquals("Style", props.get("maltego.link.style").getDisplayName());
		assertEquals("int", props.get("maltego.link.style").getType());
		
		assertEquals(false, props.get("maltego.link.manual.description").isLabelProperty());
		assertEquals("Description", props.get("maltego.link.manual.description").getDisplayName());
		assertEquals("string", props.get("maltego.link.manual.description").getType());
		
		assertEquals(false, props.get("maltego.link.color").isLabelProperty());
		assertEquals("Color", props.get("maltego.link.color").getDisplayName());
		assertEquals("color", props.get("maltego.link.color").getType());
	}
}
