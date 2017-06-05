package com.github.xdptdr.mbwar.jaxrs.aze;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.ext.Provider;

@Provider
@Path("/aze")
public class AzeEndpoint {

	@GET
	@Path("/get")
	public String get() {
		return "Hello world";
	}

}
