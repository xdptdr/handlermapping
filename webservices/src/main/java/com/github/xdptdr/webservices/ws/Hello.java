package com.github.xdptdr.webservices.ws;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class Hello {

	@WebMethod
	public String say() {
		return "Hello !";
	}
}
