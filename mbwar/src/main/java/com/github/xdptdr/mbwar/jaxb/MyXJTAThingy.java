package com.github.xdptdr.mbwar.jaxb;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlRootElement
public class MyXJTAThingy {

	private String name;

	@XmlJavaTypeAdapter(value = MyXmlAdapter.class)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
