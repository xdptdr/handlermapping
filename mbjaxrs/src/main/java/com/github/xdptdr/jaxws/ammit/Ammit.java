package com.github.xdptdr.jaxws.ammit;

import javax.jws.WebService;

@WebService
public class Ammit implements AmmitSEI {

	@Override
	public String hello() {
		return "Hello from Ammit";
	}

}
