package com.pcbje.maltegoimporter.receiver;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public interface Receiver<T> {
	public Element receive(Document doc, T data);
}
