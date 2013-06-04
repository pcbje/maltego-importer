package com.pcbje.maltegoimporter.receiver.impl;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.pcbje.maltegoimporter.model.EdgeModel;
import com.pcbje.maltegoimporter.model.GraphModel;
import com.pcbje.maltegoimporter.model.NodeModel;
import com.pcbje.maltegoimporter.model.impl.MaltegoEdgeModel;
import com.pcbje.maltegoimporter.model.impl.MaltegoGraphModel;
import com.pcbje.maltegoimporter.model.impl.MaltegoNodeModel;
import com.pcbje.maltegoimporter.receiver.Receiver;

/**
 * Class for receiving a list of string arrays, parsing it, and returning a
 * GraphML object that, when converted to a string can be copied and pasted into
 * Maltego.
 * 
 * @author pcbje
 */
public class ListArrayReceiver implements Receiver<List<String[]>> {
	private static int NODE_A_TYPE = 0;
	private static int NODE_A_VALUE = 1;
	private static int NODE_B_TYPE = 2;
	private static int NODE_B_VALUE = 3;
	private static int EDGE_LABEL = 4;

	/**
	 * {@inheritDoc}
	 */
	public Element receive(Document doc, List<String[]> data) {

		List<NodeModel> nodes = new ArrayList<NodeModel>();
		List<EdgeModel> edges = new ArrayList<EdgeModel>();

		for (String[] record : data) {
			if (record.length != 5 && record.length != 4) {
				throw new RuntimeException("Invalid data format.");
			}
                        
                        String label = "";
                        
                        if (record.length == 5) {
                            label = record[EDGE_LABEL];
                        }

			NodeModel source = new MaltegoNodeModel(record[NODE_A_TYPE],
					record[NODE_A_VALUE]);
			NodeModel target = new MaltegoNodeModel(record[NODE_B_TYPE],
					record[NODE_B_VALUE]);
			EdgeModel edge = new MaltegoEdgeModel(source, target,
					label);

			nodes.add(source);
			nodes.add(target);
			edges.add(edge);
		}

		GraphModel graph = new MaltegoGraphModel();

		for (NodeModel node : nodes) {
			graph.addNode(node);
		}

		for (EdgeModel edge : edges) {
			graph.addEdge(edge);
		}

		return graph.getGraphML(doc);
	}

}
