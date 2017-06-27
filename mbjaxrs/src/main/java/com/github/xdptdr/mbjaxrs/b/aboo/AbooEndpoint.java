package com.github.xdptdr.mbjaxrs.b.aboo;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

@Provider
@Path("/aboo")
public class AbooEndpoint {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public Response get() throws AbooException {
		throw new AbooException("Aboo says No !");
	}
}
