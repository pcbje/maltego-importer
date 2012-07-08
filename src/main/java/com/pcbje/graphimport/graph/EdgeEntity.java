package com.pcbje.graphimport.graph;

public interface EdgeEntity extends XMLEntity {
	public void setSourceNode(NodeEntity source);
	public NodeEntity getSourceNode();
	
	public void setTargetNode(NodeEntity target);
	public NodeEntity getTargetNode();
}
