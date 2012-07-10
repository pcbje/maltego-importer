package com.pcbje.graphimporter.model;

public interface EdgeModel {
	public String getId();
	public String getLabel();
	public NodeModel getTargetNode();
}
