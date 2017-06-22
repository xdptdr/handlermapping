package com.github.xdptdr.mbwar.jaxrs.ort;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

@Provider
@Path("/ort")
public class OrtEndpoint {

	@EJB
	OrtTracer tracer;

	@GET
	@Path("/get")
	@Produces(MediaType.APPLICATION_JSON)
	public Response get() {
		return Response.ok().entity(tracer.getEvents()).build();
	}
}
