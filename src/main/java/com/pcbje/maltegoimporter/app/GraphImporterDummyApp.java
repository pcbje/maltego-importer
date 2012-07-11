package com.pcbje.maltegoimporter.app;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.pcbje.maltegoimporter.receiver.impl.CSVFileReceiver;

public class GraphImporterDummyApp {
	public static void main(String[] argv) {
		File input = new File(argv[0]);

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		try {
			builder = factory.newDocumentBuilder();
			Document document = builder.newDocument();
			Element element = new CSVFileReceiver().receive(document, input);
			TransformerFactory tranFactory = TransformerFactory.newInstance();
			Transformer aTransformer = tranFactory.newTransformer();
			Source src = new DOMSource(element);
			Result dest = new StreamResult(new File(argv[1]));
			aTransformer.transform(src, dest);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
