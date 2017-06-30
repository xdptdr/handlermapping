package com.github.xdptdr.mbjaxrs2.flowers.abelia;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.Provider;

@Provider
@Path("/flowers/abelia")
public class AbeliaEndpoint {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String get() {
		return "Hello from Abelia";
	}
}
