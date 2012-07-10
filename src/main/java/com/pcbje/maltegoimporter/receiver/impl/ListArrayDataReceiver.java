package com.pcbje.maltegoimporter.receiver.impl;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.pcbje.maltegoimporter.graph.GraphEntity;
import com.pcbje.maltegoimporter.graph.impl.MaltegoEdge;
import com.pcbje.maltegoimporter.graph.impl.MaltegoGraph;
import com.pcbje.maltegoimporter.graph.impl.MaltegoNode;
import com.pcbje.maltegoimporter.model.EdgeModel;
import com.pcbje.maltegoimporter.model.NodeModel;
import com.pcbje.maltegoimporter.model.impl.MaltegoEdgeModel;
import com.pcbje.maltegoimporter.model.impl.MaltegoNodeModel;
import com.pcbje.maltegoimporter.receiver.DataReceiver;

public class ListArrayDataReceiver implements DataReceiver<List<String[]>> {
	
	private static int NODE_A_TYPE = 0;
	private static int NODE_A_VALUE = 1;
	private static int NODE_B_TYPE = 2;
	private static int NODE_B_VALUE = 3;
	private static int EDGE_LABEL = 4;
	
	public Element receive(Document doc, List<String[]> data) {
		
		List<NodeModel> nodes = new ArrayList<NodeModel>();
		List<EdgeModel> edges = new ArrayList<EdgeModel>();
		
		for (String[] record : data) {
			if (record.length != 5) {
				throw new RuntimeException("Invalid data format.");
			}
			
			NodeModel source = new MaltegoNodeModel(record[NODE_A_TYPE], record[NODE_A_VALUE]);
			NodeModel target = new MaltegoNodeModel(record[NODE_B_TYPE], record[NODE_B_VALUE]);
			EdgeModel edge = new MaltegoEdgeModel(source, target, record[EDGE_LABEL]);
			
			nodes.add(source);
			nodes.add(target);
			edges.add(edge);
		}
		
		GraphEntity graph = new MaltegoGraph();
		
		for (NodeModel node : nodes) {
			graph.addNode(new MaltegoNode(node));
		}
		
		for (EdgeModel edge : edges) {
			graph.addEdge(new MaltegoEdge(edge));
		}
		
		return graph.getGraphML(doc);
	}

}
