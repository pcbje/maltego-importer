package com.pcbje.graphimporter.model.impl;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MaltegoEdgeModelTest {
	@Test
	public void testThatMaltegoEdgeColorIsSet() {
		MaltegoEdgeModel edge = new MaltegoEdgeModel(new MaltegoNodeModel(
				"Person", "a"), new MaltegoNodeModel("Person", "b"), "edgelabel");

		assertEquals("edgelabel", edge.getProperties().get("maltego.link.manual.type").getValue());
		assertEquals("8421505", edge.getProperties().get("maltego.link.color").getValue());
	}
}
