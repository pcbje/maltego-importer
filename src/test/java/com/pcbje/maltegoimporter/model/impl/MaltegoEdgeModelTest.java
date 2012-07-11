package com.pcbje.maltegoimporter.model.impl;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.pcbje.maltegoimporter.model.impl.MaltegoEdgeModel;
import com.pcbje.maltegoimporter.model.impl.MaltegoNodeModel;

public class MaltegoEdgeModelTest {
	@Test
	public void testThatMaltegoEdgeColorIsSet() {
		MaltegoEdgeModel edge = new MaltegoEdgeModel(new MaltegoNodeModel(
				"Person", "a"), new MaltegoNodeModel("Person", "b"), "edgelabel");

		assertEquals("edgelabel", edge.getProperties().get("Label").getValue());
		assertEquals("8421505", edge.getProperties().get("Color").getValue());
	}
	
	@Test
	public void testSetValidAttribute() {
		MaltegoEdgeModel edge = new MaltegoEdgeModel(new MaltegoNodeModel(
				"Person", "a"), new MaltegoNodeModel("Person", "b"), "edgelabel");
		
		edge.setProperty("Thickness", "some-thickness");
		
		assertEquals("some-thickness", edge.getProperties().get("Thickness").getValue());
	}
	
	@Test(expected=RuntimeException.class)
	public void testSettingNonExistingPropertyThrowsException() {
		MaltegoEdgeModel edge = new MaltegoEdgeModel(new MaltegoNodeModel(
				"Person", "a"), new MaltegoNodeModel("Person", "b"), "edgelabel");
		
		edge.setProperty("DoesNotExist", "Some value");
	}
}
