package com.github.xdptdr.mbjaxrs.c.agate;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlRootElement;

import org.jboss.resteasy.links.RESTServiceDiscovery;

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class AgateResource {

	@XmlAttribute
	private String author;

	@XmlID
	@XmlAttribute
	private String title;

	@XmlElementRef
	private RESTServiceDiscovery rest;

	public AgateResource() {
	}

	public AgateResource(String author, String title) {
		this.author = author;
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public RESTServiceDiscovery getRest() {
		return rest;
	}

	public void setRest(RESTServiceDiscovery rest) {
		this.rest = rest;
	}

}
