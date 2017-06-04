package com.github.xdptdr.mbwar.jaxb;

import javax.xml.bind.annotation.XmlInlineBinaryData;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class MyXIBDThingy {

	private byte[] bytesA;
	private byte[] bytesB;

	public byte[] getBytesA() {
		return bytesA;
	}

	public void setBytesA(byte[] bytesA) {
		this.bytesA = bytesA;
	}

	@XmlInlineBinaryData
	public byte[] getBytesB() {
		return bytesB;
	}

	public void setBytesB(byte[] bytesB) {
		this.bytesB = bytesB;
	}

}
