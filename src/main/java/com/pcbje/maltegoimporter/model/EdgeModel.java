package com.pcbje.maltegoimporter.model;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public interface EdgeModel extends PropertyHolderModel {
	public String getId();

	public String getType();

	public NodeModel getSourceNode();

	public NodeModel getTargetNode();

	public Element getGraphML(Document doc);
}
