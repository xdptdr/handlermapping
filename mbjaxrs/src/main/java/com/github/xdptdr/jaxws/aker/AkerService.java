package com.github.xdptdr.jaxws.aker;

import javax.jws.WebService;

@WebService
public class AkerService implements AkerSEI {

	public String hello() {
		return "Hello from  Aker";
	};

}
