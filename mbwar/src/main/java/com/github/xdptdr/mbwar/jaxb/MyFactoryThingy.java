package com.github.xdptdr.mbwar.jaxb;

import javax.xml.bind.annotation.XmlType;

@XmlType(name = "youplala", propOrder = { "name",
		"address" }, factoryClass = MyFactoryThingyFactory.class, factoryMethod = "create")

public class MyFactoryThingy {
	private String name;
	private String address;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
