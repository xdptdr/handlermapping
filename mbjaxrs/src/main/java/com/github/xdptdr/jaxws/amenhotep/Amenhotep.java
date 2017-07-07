package com.github.xdptdr.jaxws.amenhotep;

import javax.jws.WebService;

@WebService
public class Amenhotep implements AmenhotepSEI {

	@Override
	public String hello() {
		return "Hello from Amenhotep";
	}

}
