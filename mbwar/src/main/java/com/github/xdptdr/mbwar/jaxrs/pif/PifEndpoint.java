package com.github.xdptdr.mbwar.jaxrs.pif;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

@Provider
@Path("/pif")
public class PifEndpoint {

	private PifBean pifBean = new PifBean("Aze", "Bar");

	@GET
	@Path("/get")
	@Produces(MediaType.TEXT_PLAIN)
	public Response get() {
		return Response.ok(pifBean).build();
	}

	@POST
	@Path("/post")
	@Consumes(MediaType.TEXT_PLAIN)
	public Response post(PifBean pifBean) {
		this.pifBean = pifBean;
		return Response.ok().build();
	}
}
