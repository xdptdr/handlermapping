package com.github.xdptdr.jaxws.aker;

import javax.jws.WebService;

@WebService
public class Aker implements AkerSEI {

	@Override
	public String hello() {
		return "Hello from  Aker";
	};

}
