package com.github.xdptdr.mbwar.jaxb;

import javax.xml.bind.annotation.XmlAttachmentRef;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class MyXARThingy {

	private String name;

	@XmlAttachmentRef
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
