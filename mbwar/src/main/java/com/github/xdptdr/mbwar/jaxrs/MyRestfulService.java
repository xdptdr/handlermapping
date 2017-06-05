package com.github.xdptdr.mbwar.jaxrs;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.ext.Provider;

@Provider
@Path("/myRestfulService")
public class MyRestfulService {

	@GET
	@Path("/get")
	public String get() {
		return "Hello from " + this.getClass().getName();
	}
}
