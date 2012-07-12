package com.pcbje.maltegoimporter.receiver.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.pcbje.maltegoimporter.receiver.Receiver;

/**
 * Class for receiving a CSV file, parsing it, and returning a GraphML object that, when
 * converted to a string can be copied and pasted into Maltego.
 * 
 * @author pcbje
 * 
 */
public class CSVFileReceiver implements Receiver<File> {
	Logger logger = Logger.getLogger(CSVFileReceiver.class.getName());

	/**
	 * {@inheritDoc}
	 */
	public Element receive(Document doc, File data) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(data));

			List<String[]> records = new ArrayList<String[]>();

			String line;
			String[] arr;

			while ((line = br.readLine()) != null) {
				arr = line.trim().split(",");

				for (int i = 0; i < arr.length; i++) {
					arr[i] = arr[i].trim();
				}

				records.add(arr);
			}

			br.close();

			return new ListArrayReceiver().receive(doc, records);

		} catch (FileNotFoundException e) {
			logger.log(Level.WARNING, e.getMessage(), e);
		} catch (IOException e) {
			logger.log(Level.WARNING, e.getMessage(), e);
		}

		return null;
	}

}
