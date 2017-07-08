package com.github.xdptdr.jaxws.amheh;

import javax.jws.WebService;

@WebService
public class Amheh implements AmhehSEI {

	@Override
	public String hello() {
		return "Hello from Amheh";
	}

}
