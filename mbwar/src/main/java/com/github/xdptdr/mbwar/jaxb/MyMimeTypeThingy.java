package com.github.xdptdr.mbwar.jaxb;

import java.awt.Image;

import javax.xml.bind.annotation.XmlMimeType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class MyMimeTypeThingy {

	private String name;
	private Image imageDataWithoutMimeType;
	private Image imageDataWithMimeType;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Image getImageDataWithoutMimeType() {
		return imageDataWithoutMimeType;
	}

	public void setImageDataWithoutMimeType(Image imageDataWithoutMimeType) {
		this.imageDataWithoutMimeType = imageDataWithoutMimeType;
	}

	@XmlMimeType("image/jpeg")
	public Image getImageDataWithMimeType() {
		return imageDataWithMimeType;
	}

	public void setImageDataWithMimeType(Image imageDataWithMimeType) {
		this.imageDataWithMimeType = imageDataWithMimeType;
	}

}
