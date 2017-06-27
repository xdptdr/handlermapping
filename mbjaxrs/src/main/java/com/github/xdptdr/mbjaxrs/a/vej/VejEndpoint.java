package com.github.xdptdr.mbjaxrs.a.vej;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

@Provider
@Path("/vej")
public class VejEndpoint {

	@EJB
	private VejSingleton vejSingleton;

	@GET
	@Path("/logged")
	@Produces(MediaType.TEXT_PLAIN)
	@VejLogged
	public Response logged() {
		return Response.ok("Logged Hello from VEJ").build();
	}

	@GET
	@Path("/notlogged")
	@Produces(MediaType.TEXT_PLAIN)
	public Response notLogged() {
		return Response.ok("Not logged Hello from VEJ").build();
	}

	@GET
	@Path("/dump")
	@Produces(MediaType.APPLICATION_JSON)
	public Response dump() {
		return Response.ok(vejSingleton.getLog()).build();
	}
}
