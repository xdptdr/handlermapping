package com.github.xdptdr.mbwar.jaxrs.jey;

import java.util.Calendar;
import java.util.TimeZone;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

@Provider
@Path("/jey")
public class JeyEndpoint {

	@GET
	@Path("/get")
	public Response get() {
		NewCookie newCookie = new NewCookie("cookieName", "cookieValue", "/get", "localhost", 5, "cookieComment", 25,
				Calendar.getInstance(TimeZone.getTimeZone("UTC")).getTime(), true, true);
		return Response.ok().cookie(newCookie).build();
	}
}
