package com.github.xdptdr.mbwar.jaxrs.baby;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Priorities;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

@Provider
@Path("/baby")
public class BabyEndpoint {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public Response get() {

		Integer.valueOf(Priorities.AUTHENTICATION);
		Integer.valueOf(Priorities.AUTHORIZATION);
		Integer.valueOf(Priorities.ENTITY_CODER);
		Integer.valueOf(Priorities.HEADER_DECORATOR);
		Integer.valueOf(Priorities.USER);
		return Response.ok().header("BABY", "BABY").build();
	}

}
