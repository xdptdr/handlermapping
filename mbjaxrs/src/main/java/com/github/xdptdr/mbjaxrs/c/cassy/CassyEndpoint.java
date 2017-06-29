package com.github.xdptdr.mbjaxrs.c.cassy;

import javax.ws.rs.GET;
import javax.ws.rs.OPTIONS;
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
	@CassyCORSDefault
	public String withCORS() {
		return "Hello from Cassy";
	}

	@GET
	@Path("/withCORSCustomized")
	@CassyCORSCustomized
	public String withCORSCustomized() {
		return "Hello from Cassy";
	}

	// not implementing @OPTIONS for /withoutCORS leaves the default one

	// having @CassyCORS on /withCORS" requires an implementation ; fortunately,
	// it is replaced by the CORS filter

	@OPTIONS
	@Path("/withCORS")
	@CassyCORSDefault
	public void optionsWithCORS() {
		// this is never executed
	}

	@OPTIONS
	@Path("/withCORSCustomized")
	@CassyCORSCustomized
	public void optionsWithCORSCustomized() {
		// this is never executed
	}

}
