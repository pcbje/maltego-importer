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
public class CSVHeaderDefinedCaseFileParser implements CaseFileParser {

    public String parse(File csvFile, String delimeter) throws Exception {
        FileInputStream fstream = new FileInputStream(csvFile);
        DataInputStream in = new DataInputStream(fstream);
        BufferedReader br = new BufferedReader(new InputStreamReader(in));

        String header = br.readLine();

        String[] types = header.split(delimeter);

        if (types.length != 3) {
            throw new CaseFileException("Header must contain excactly 3 columns "
                    + "(nodetype1, nodetype2, edgetype), got: "
                    + header + "(" + types.length + ")");
        }

        String[][] headerData = new String[3][2];

        for (int i = 0; i < types.length - 1; i++) {
            headerData[i] = types[i].split("\\.");

            headerData[i][1] = "maltego." + headerData[i][1];
        }

        CaseFileGraph graph = new DefaultCaseFileGraph();
        CaseFileNode source, target;
        CaseFileEdge edge;
        String[] data;
        String row;
        int counter = 0;

        while ((row = br.readLine()) != null) {
            data = row.split(delimeter);

            if (data.length != 3) {
                throw new CaseFileException("Row must contain excactly 3 "
                        + "columns (nodeid1, nodeid2, edgeid), got: " + row);
            }

            source = new DefaultCaseFileNode(data[0], headerData[0][0], headerData[0][1], data[0]);
            target = new DefaultCaseFileNode(data[1], headerData[1][0], headerData[1][1], data[1]);
            edge = new DefaultCaseFileEdge("e" + Integer.toString(counter++), data[2]);
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
