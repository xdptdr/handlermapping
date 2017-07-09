package com.github.xdptdr.jaxws.amunet;

import javax.jws.WebService;
import javax.xml.ws.Holder;

@WebService
public class Amunet implements AmunetSEI {

	@Override
	public String hello(Holder<byte[]> bytes, Holder<byte[]> bytes1) {
		return "Hello from Amunet";
	}

}
