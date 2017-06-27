package com.github.xdptdr.mbjaxrs.b.elym;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

@Provider
@Path("/elym")
public class ElymEndpoint {

	@GET
	@Path("/client")
	@Produces(MediaType.TEXT_PLAIN)
	public Response getc() {
		ElymCBean bean = new ElymCBean();
		return Response.ok(bean).build();
	}
	
	@GET
	@Path("/server")
	@Produces(MediaType.TEXT_PLAIN)
	public Response gets() {
		ElymCBean bean = new ElymSBean();
		return Response.ok(bean).build();
	}
}
