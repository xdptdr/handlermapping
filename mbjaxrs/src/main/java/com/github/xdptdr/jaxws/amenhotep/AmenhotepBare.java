package com.github.xdptdr.jaxws.amenhotep;

import javax.jws.WebService;

@WebService
public class AmenhotepBare implements AmenhotepBareSEI {

	@Override
	public String hello() {
		return "Hello from Ammit";
	}

}
