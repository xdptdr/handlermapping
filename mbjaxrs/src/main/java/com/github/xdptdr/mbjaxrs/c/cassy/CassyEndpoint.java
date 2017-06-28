package com.github.xdptdr.mbjaxrs.c.cassy;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.Provider;

@Provider
@Path("/cassy")
@Produces({ MediaType.TEXT_PLAIN })
public class CassyEndpoint {

	@GET
	@Path("/withoutCORS")
	public String withoutCORS() {
		return "Hello from Cassy";
	}

	@GET
	@Path("/withCORS")
	@CassyCORS
	public String withCORS() {
		return "Hello from Cassy";
	}

}
