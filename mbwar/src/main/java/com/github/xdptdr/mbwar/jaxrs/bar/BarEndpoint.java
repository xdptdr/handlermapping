package com.github.xdptdr.mbwar.jaxrs.bar;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.Provider;

@Provider
@Path("/bar")
public class BarEndpoint {

	private BarBean barBean = new BarBean("Aze", "Bar");

	@GET
	@Path("/get")
	@Produces(MediaType.TEXT_PLAIN)
	public BarBean get() {
		return barBean;
	}

	@POST
	@Path("/post")
	@Consumes(MediaType.TEXT_PLAIN)
	public void post(BarBean barBean) {
		this.barBean = barBean;
	}
}
