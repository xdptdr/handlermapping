package com.github.xdptdr.jaxws.amenhotep;

import javax.jws.WebService;

@WebService
public class AmenhotepEncoded implements AmenhotepEncodedSEI {

	@Override
	public String hello() {
		return "Hello from Ammit";
	}

}
