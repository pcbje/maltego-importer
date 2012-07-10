package com.pcbje.graphimporter.receiver;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public interface DataReceiver<T> {
	public Element receive(Document doc, T data);
}
