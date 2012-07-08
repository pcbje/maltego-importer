package com.pcbje.graphimporter.graph;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public interface GraphEntity {
	public Element getGraphML(Document doc);
}
