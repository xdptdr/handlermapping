package com.github.xdptdr.mbjaxrs.basics.gok;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Link;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

@Provider
@Path("/gok")
public class GokEndpoint {

	@GET
	@Path("/get")
	public Response gok() {
		Link link = Link.fromPath("/link").rel("rel").type("type").title("title").build();
		return Response.ok().links(link).build();
	}
}
