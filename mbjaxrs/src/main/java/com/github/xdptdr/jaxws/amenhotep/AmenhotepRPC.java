package com.github.xdptdr.jaxws.amenhotep;

import javax.jws.WebService;

@WebService
public class AmenhotepRPC implements AmenhotepRPCSEI {

	@Override
	public String hello() {
		return "Hello from AmenhotepRPC";
	}

}
