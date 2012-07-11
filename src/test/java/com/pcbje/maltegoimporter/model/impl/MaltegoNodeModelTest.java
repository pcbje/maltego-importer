package com.pcbje.maltegoimporter.model.impl;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MaltegoNodeModelTest {
	@Test
	public void testThatMaltegoNodePropertiesAreSet() {
		MaltegoNodeModel node = new MaltegoNodeModel("Gun", "gunlabel");

		assertEquals("gunlabel", node.getProperties().get("Type").getValue());
	}

	@Test
	public void testThatMaltegoPrefixAreOptional() {
		MaltegoNodeModel node1 = new MaltegoNodeModel("IPv4Address",
				"127.0.0.1");
		MaltegoNodeModel node2 = new MaltegoNodeModel("maltego.IPv4Address",
				"127.0.0.1");

		assertEquals(node1.getProperties().get("IP Address").getValue(), node2
				.getProperties().get("IP Address").getValue());
	}
}
