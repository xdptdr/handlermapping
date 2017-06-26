package com.github.xdptdr.mbjaxrs.basics.wux;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

@Provider
@Path("/wux")
public class WuxEndpoint {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public Response get(@QueryParam("p") WuxParam p) {
		
		byte[] bytes = p.getBytes();

		int len = bytes == null ? -1 : bytes.length;
		
		return Response.ok(len).build();
		
	}
}
