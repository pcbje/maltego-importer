package com.pcbje.maltegoimporter.receiver.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.pcbje.maltegoimporter.receiver.DataReceiver;

public class CSVFileDataReceiver implements DataReceiver<File> {

	public Element receive(Document doc, File data) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(data));

			List<String[]> records = new ArrayList<String[]>();

			String line;

			while ((line = br.readLine()) != null) {
				records.add(line.trim().split(","));
			}

			return new ListArrayDataReceiver().receive(doc, records);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

}
