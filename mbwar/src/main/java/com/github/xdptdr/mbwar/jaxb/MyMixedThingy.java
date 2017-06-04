package com.github.xdptdr.mbwar.jaxb;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlMixed;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class MyMixedThingy {

	private List<Object> elements = new ArrayList<>();

	@XmlElementRef(name = "thingy", type = MyThingy.class)
	@XmlMixed
	public List<Object> getElements() {
		return elements;
	}

	public void setElements(List<Object> elements) {
		this.elements = elements;
	}

}
