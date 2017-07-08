package com.github.xdptdr.jaxws.amenhotep;

import javax.jws.WebService;

@WebService
public class AmenhotepDefault implements AmenhotepDefaultSEI {

	@Override
	public String hello() {
		return "Hello from Amenhotep";
	}

}
