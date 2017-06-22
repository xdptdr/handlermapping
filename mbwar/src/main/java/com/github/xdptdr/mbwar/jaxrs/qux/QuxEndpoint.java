package com.github.xdptdr.mbwar.jaxrs.qux;

import javax.ws.rs.OPTIONS;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

@Provider
@Path("/qux")
public class QuxEndpoint {

	private static final String TEXT = "HTTP does not define what OPTIONS is supposed to answer, but most implementations answer with a comma separated list of HTTP methods";

	@OPTIONS
	@Path("/options")
	@Produces(MediaType.TEXT_PLAIN)
	public Response get() {
		return Response.ok(TEXT).build();
	}
}
