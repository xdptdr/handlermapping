package com.github.xdptdr.jaxws.amunet;

import javax.jws.WebParam;
import javax.jws.WebParam.Mode;
import javax.jws.WebService;
import javax.xml.ws.Holder;

@WebService
public interface AmunetSEI {
	public String hello(@WebParam(name = "titi", mode = Mode.OUT, partName = "toto") Holder<byte[]> bytes,
			@WebParam(name = "titi1", mode = Mode.OUT, partName = "toto1") Holder<byte[]> bytes1);
}
