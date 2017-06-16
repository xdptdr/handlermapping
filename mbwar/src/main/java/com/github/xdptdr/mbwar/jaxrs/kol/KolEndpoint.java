package com.github.xdptdr.mbwar.jaxrs.kol;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.EntityTag;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.Provider;

@Provider
@Path("/kol")
public class KolEndpoint {

	@GET
	@Path("/get")
	public Response get(@Context Request request) {

		EntityTag eTag = new EntityTag("toto", false);
		ResponseBuilder rb = request.evaluatePreconditions(eTag);
		if (rb != null) {
			return rb.build();
		} else {
			return Response.status(Status.FORBIDDEN).build();
		}
	}
}
