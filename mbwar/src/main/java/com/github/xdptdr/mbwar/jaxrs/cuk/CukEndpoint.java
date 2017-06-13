package com.github.xdptdr.mbwar.jaxrs.cuk;

import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

@Provider
@Path("/cuk")
public class CukEndpoint {

	@GET
	@Path("/get/queryparam")
	@Produces(MediaType.TEXT_PLAIN)
	public Response getQueryParam(@QueryParam("p") String p) {
		return Response.ok(p).build();
	}

	@GET
	@Path("/get/pathparam/{p}")
	@Produces(MediaType.TEXT_PLAIN)
	public Response getPathParam(@PathParam("p") String p) {
		return Response.ok(p).build();
	}

	@GET
	@Path("/get/matrixparam")
	@Produces(MediaType.TEXT_PLAIN)
	public Response getMatrixParam(@MatrixParam("p") String p) {
		return Response.ok(p).build();
	}

	@GET
	@Path("/get/cookieparam")
	@Produces(MediaType.TEXT_PLAIN)
	public Response getCookieParam(@CookieParam("p") String p) {
		return Response.ok(p).build();
	}

	@POST
	@Path("/post/formparam")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public Response getFormParam(@FormParam("p") String p) {
		return Response.ok(p).build();
	}

	@GET
	@Path("/get/headerparam")
	@Produces(MediaType.TEXT_PLAIN)
	public Response getHeaderParam(@HeaderParam("p") String p) {
		return Response.ok(p).build();
	}

	

	

	

	

	

	

	

	

	

	

	

	

	// Accept
	// Accept-Charset
	// Accept-Encoding
	// Accept-Language
	// Allow
	// Authorization
	// Cache-Control
	// Content-Encoding
	// Content-Language
	// Content-Length
	// Content-Type
	// Cookie
	// Date
	// ETag
	// Expect
	// Expires
	// If-Match
	// If-Modified-Since
	// If-Unmodified-Since
	// Last-Modified
	// Location
	// Set-Cookie
	// Transfer-Encoding
	// Vary
	// WWW-Authenticate

}
