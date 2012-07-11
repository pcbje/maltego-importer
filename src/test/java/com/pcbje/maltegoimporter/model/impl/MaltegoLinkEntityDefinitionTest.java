package com.pcbje.maltegoimporter.model.impl;

import static org.junit.Assert.assertEquals;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.pcbje.maltegoimporter.model.PropertyModel;
import com.pcbje.maltegoimporter.model.impl.MaltegoEntityDefinition;

public class MaltegoLinkEntityDefinitionTest {
	MaltegoEntityDefinition type;

	@Before
	public void init() {
		type = new MaltegoEntityDefinition();
	}

	@Test
	public void testTypeDesktopComputer() {
		Map<String, PropertyModel> props = type
				.getProperties("maltego.link.manual-link");

		assertEquals(6, props.size());
		assertEquals(true, props.get("Label").isLabelProperty());
		assertEquals("Label", props.get("Label").getDisplayName());
		assertEquals("string", props.get("Label").getType());
		
		assertEquals(false, props.get("Show Label").isLabelProperty());
		assertEquals("Show Label", props.get("Show Label").getDisplayName());
		assertEquals("int", props.get("Show Label").getType());
		
		assertEquals(false, props.get("Thickness").isLabelProperty());
		assertEquals("Thickness", props.get("Thickness").getDisplayName());
		assertEquals("int", props.get("Thickness").getType());
		
		assertEquals(false, props.get("Style").isLabelProperty());
		assertEquals("Style", props.get("Style").getDisplayName());
		assertEquals("int", props.get("Style").getType());
		
		assertEquals(false, props.get("Description").isLabelProperty());
		assertEquals("Description", props.get("Description").getDisplayName());
		assertEquals("string", props.get("Description").getType());
		
		assertEquals(false, props.get("Color").isLabelProperty());
		assertEquals("Color", props.get("Color").getDisplayName());
		assertEquals("color", props.get("Color").getType());
	}
}
