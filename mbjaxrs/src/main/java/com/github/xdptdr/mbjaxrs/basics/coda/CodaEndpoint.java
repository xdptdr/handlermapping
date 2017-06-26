package com.github.xdptdr.mbjaxrs.basics.coda;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

@Provider
@Path("/coda")
public class CodaEndpoint {
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public Response get() {
		return Response.ok().build();
	}
	
}
