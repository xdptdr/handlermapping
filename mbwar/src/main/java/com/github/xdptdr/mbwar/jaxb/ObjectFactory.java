package com.github.xdptdr.mbwar.jaxb;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;

@XmlRegistry
public class ObjectFactory {

	JAXBElement<String> youpi;

	@XmlElementDecl(name = "tada")
	public JAXBElement<String> getYoupi() {
		return youpi;
	}

	public void setYoupi(JAXBElement<String> youpi) {
		this.youpi = youpi;
	}

}
