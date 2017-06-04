package com.github.xdptdr.mbwar.jaxb;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlIDREF;

public class MyThingyWithIds {

	private String name;

	private String id;

	private MyThingyWithIds theOtherOne;

	private List<MyThingyWithIds> theOtherOnes = new ArrayList<>();

	@XmlAttribute
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@XmlAttribute
	@XmlID
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@XmlIDREF
	public MyThingyWithIds getTheOtherOne() {
		return theOtherOne;
	}

	public void setTheOtherOne(MyThingyWithIds theOtherOne) {
		this.theOtherOne = theOtherOne;
	}

	@XmlIDREF
	public List<MyThingyWithIds> getTheOtherOnes() {
		return theOtherOnes;
	}

	public void setTheOtherOnes(List<MyThingyWithIds> theOtherOnes) {
		this.theOtherOnes = theOtherOnes;
	}

}
