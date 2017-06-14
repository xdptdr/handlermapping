package com.github.xdptdr.mbwar.jaxrs.jey;

import java.util.Locale;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Variant;
import javax.ws.rs.ext.Provider;

@Provider
@Path("/iao")
public class IaoEndpoint {

	@GET
	@Path("/get")
	public Response jey() {
		return Response.ok().variant(new Variant(MediaType.APPLICATION_SVG_XML_TYPE, Locale.GERMAN, "UTF-8")).build();
	}
}
