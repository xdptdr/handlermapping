package com.github.xdptdr.webservices.ws;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Action;
import javax.xml.ws.soap.Addressing;
import javax.xml.ws.soap.AddressingFeature.Responses;

@WebService
@Addressing(required = true, enabled = true, responses = Responses.NON_ANONYMOUS)
public class HelloAddressing {

	@WebMethod
	@Action(input="say", output="listen")
	public String say() {
		return "Hello !";
	}

}
