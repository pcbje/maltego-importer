package com.pcbje.casefileimport.parser.impl;

import com.pcbje.casefileimport.CaseFileException;
import com.pcbje.casefileimport.graph.CaseFileEdge;
import com.pcbje.casefileimport.graph.CaseFileGraph;
import com.pcbje.casefileimport.graph.CaseFileNode;
import com.pcbje.casefileimport.graph.impl.DefaultCaseFileEdge;
import com.pcbje.casefileimport.graph.impl.DefaultCaseFileGraph;
import com.pcbje.casefileimport.graph.impl.DefaultCaseFileNode;
import com.pcbje.casefileimport.parser.CaseFileParser;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 *
 * @author pcbje
 */
public class CSVValueDefinedCaseFileParser implements CaseFileParser {
    public String parse(File csvFile, String delimeter) throws Exception {
        FileInputStream fstream = new FileInputStream(csvFile);
        DataInputStream in = new DataInputStream(fstream);
        BufferedReader br = new BufferedReader(new InputStreamReader(in));

        CaseFileGraph graph = new DefaultCaseFileGraph();
        CaseFileNode source, target;
        CaseFileEdge edge;
        String[] data;
        String row;
        int counter = 0;

        while ((row = br.readLine()) != null) {
            data = row.split(delimeter);

            if (data.length != 6) {
                throw new CaseFileException("Row must contain excactly 3 "
                        + "columns (nodetype1, nodeid1, nodetype2, nodeid2, edgetype, edgeid), got: " + row);
            }
            
            String[] sourceData = data[0].split("\\.");
            String[] targetData = data[2].split("\\.");
            String[] edgeData = data[4].split("\\.");

            source = new DefaultCaseFileNode(data[1], sourceData[0], "maltego." + sourceData[1], data[1]);
            target = new DefaultCaseFileNode(data[3], targetData[0], "maltego." + targetData[1], data[3]);
           
            edge = new DefaultCaseFileEdge("e" + Integer.toString(counter++), data[5]);
            edge.setSourceNode(source);
            edge.setTargetNode(target);

            graph.addNode(source.getId(), source);
            graph.addNode(target.getId(), target);
            graph.addEdge(edge.getId(), edge);
        }

        in.close();

        return graph.getGraphMLAsString();
    }    
}
