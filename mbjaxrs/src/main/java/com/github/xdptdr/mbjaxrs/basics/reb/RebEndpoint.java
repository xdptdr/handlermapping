package com.github.xdptdr.mbjaxrs.basics.reb;

import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

@Provider
@Path("/reb")
public class RebEndpoint {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public Response get(@CookieParam("rebCookie") String cookie) {
		if (cookie != null) {
			return Response.ok("Found reb cookie " + cookie).build();
		} else {
			return Response.ok("Found no reb cookie").build();
		}
	}
}
