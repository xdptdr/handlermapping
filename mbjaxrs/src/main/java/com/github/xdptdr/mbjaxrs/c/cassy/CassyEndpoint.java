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
	public String get() {
		return "Hello from Cassy";
	}
	
	@CASSY
	public String cassy() {
		return "I have special powers !";
	}
}
