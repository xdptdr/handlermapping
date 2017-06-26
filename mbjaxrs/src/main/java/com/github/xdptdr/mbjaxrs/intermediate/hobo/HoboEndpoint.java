package com.github.xdptdr.mbjaxrs.intermediate.hobo;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

@Provider
@Path("/hobo")
public class HoboEndpoint {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public Response get() {

		MediaType.APPLICATION_ATOM_XML.length();
		MediaType.APPLICATION_FORM_URLENCODED.length();
		MediaType.APPLICATION_JSON.length();
		MediaType.APPLICATION_OCTET_STREAM.length();
		MediaType.APPLICATION_SVG_XML.length();
		MediaType.APPLICATION_XHTML_XML.length();
		MediaType.APPLICATION_XML.length();
		MediaType.MEDIA_TYPE_WILDCARD.length();
		MediaType.MULTIPART_FORM_DATA.length();
		MediaType.TEXT_HTML.length();
		MediaType.TEXT_PLAIN.length();
		MediaType.TEXT_XML.length();
		MediaType.WILDCARD.length();

		return Response.ok().build();
	}

}
