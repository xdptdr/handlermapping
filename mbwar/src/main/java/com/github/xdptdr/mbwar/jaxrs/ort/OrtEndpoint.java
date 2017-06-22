package com.github.xdptdr.mbwar.jaxrs.ort;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

@Provider
@Path("/ort")
public class OrtEndpoint {

	@GET
	@Path("/get")
	public Response get() {
		return Response.ok().build();
	}
}
