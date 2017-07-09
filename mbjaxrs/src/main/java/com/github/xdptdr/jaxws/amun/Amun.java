package com.github.xdptdr.jaxws.amun;

import javax.jws.WebService;

@WebService
public class Amun implements AmunSEI {

	@Override
	public String hello() {
		return "Hello from Amun";
	}

}
