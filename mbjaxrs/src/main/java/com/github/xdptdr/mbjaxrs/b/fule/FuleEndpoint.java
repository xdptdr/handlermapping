package com.github.xdptdr.mbjaxrs.b.fule;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

@Provider
@Path("/fule")
public class FuleEndpoint {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@FULEUTF8
	@Path("/utf8")
	public Response getUTF8() {
		return Response.ok().build();
	}

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@FULELATIN9
	@Path("/latin9")
	public Response getLATIN9() {
		return Response.ok().build();
	}

}
