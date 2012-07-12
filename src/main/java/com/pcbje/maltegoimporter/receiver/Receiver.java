package com.pcbje.maltegoimporter.receiver;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * Interface for receiving data from some other resource, such as CSV files or
 * JSON over HTTP, etc.
 * 
 * @author pcbje
 * 
 * @param <T>
 */
public interface Receiver<T> {
	/**
	 * Create a GraphML object that can be copied into Maltego when converted to
	 * a string.
	 * 
	 * @param doc
	 *            Document object that will be used to create all XML elements.
	 * @param data
	 *            The input data that will be represented in the GraphML result.
	 * @return An XML object that can be converted into a String and pasted into
	 *         Maltego.
	 */
	public Element receive(Document doc, T data);
}
