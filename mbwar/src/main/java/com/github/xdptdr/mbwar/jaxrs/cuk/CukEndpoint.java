package com.github.xdptdr.mbwar.jaxrs.cuk;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.Encoded;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.container.ResourceContext;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Configuration;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.ext.Provider;
import javax.ws.rs.ext.Providers;

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
	@Path("/get/queryparam/encoded")
	@Produces(MediaType.TEXT_PLAIN)
	public Response getQueryParamEncoded(@QueryParam("p") @Encoded String p) {
		return Response.ok(p).build();
	}

	@GET
	@Path("/get/queryparam/defaultvalue")
	@Produces(MediaType.TEXT_PLAIN)
	public Response getQueryParamDefaultValue(@QueryParam("p") @DefaultValue("cuk") String p) {
		return Response.ok(p).build();
	}

	@GET
	@Path("/get/pathparam/{p}")
	@Produces(MediaType.TEXT_PLAIN)
	public Response getPathParam(@PathParam("p") String p) {
		return Response.ok(p).build();
	}

	@GET
	@Path("/get/pathparam/{p}/encoded")
	@Produces(MediaType.TEXT_PLAIN)
	public Response getPathParamEncoded(@PathParam("p") @Encoded String p) {
		return Response.ok(p).build();
	}

	@GET
	@Path("/get/matrixparam")
	@Produces(MediaType.TEXT_PLAIN)
	public Response getMatrixParam(@MatrixParam("p") String p) {
		return Response.ok(p).build();
	}

	@GET
	@Path("/get/matrixparam/encoded")
	@Produces(MediaType.TEXT_PLAIN)
	public Response getMatrixParamEncoded(@MatrixParam("p") @Encoded String p) {
		return Response.ok(p).build();
	}

	@GET
	@Path("/get/matrixparam/defaultValue")
	@Produces(MediaType.TEXT_PLAIN)
	public Response getMatrixParamDefaultValue(@MatrixParam("p") @DefaultValue("cuk") String p) {
		return Response.ok(p).build();
	}

	@GET
	@Path("/get/cookieparam")
	@Produces(MediaType.TEXT_PLAIN)
	public Response getCookieParam(@CookieParam("p") String p) {
		return Response.ok(p).build();
	}

	@GET
	@Path("/get/cookieparam/defaultValue")
	@Produces(MediaType.TEXT_PLAIN)
	public Response getCookieParamDefaultValue(@CookieParam("p") @DefaultValue("cuk") String p) {
		return Response.ok(p).build();
	}

	@POST
	@Path("/post/formparam")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public Response getFormParam(@FormParam("p") String p) {
		return Response.ok(p).build();
	}

	@POST
	@Path("/post/formparam/defaultValue")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public Response getFormParamDefaultValue(@FormParam("p") @DefaultValue("cuk") String p) {
		return Response.ok(p).build();
	}

	@GET
	@Path("/get/headerparam")
	@Produces(MediaType.TEXT_PLAIN)
	public Response getHeaderParam(@HeaderParam("p") String p) {
		return Response.ok(p).build();
	}

	@GET
	@Path("/get/headerparam/defaultValue")
	@Produces(MediaType.TEXT_PLAIN)
	public Response getHeaderParamDefaultValue(@HeaderParam("p") @DefaultValue("cuk") String p) {
		return Response.ok(p).build();
	}

	@GET
	@Path("/get/context/application")
	@Produces(MediaType.TEXT_PLAIN)
	public Response getContextApplication(@Context Application application) {
		return Response.ok("something").build();
	}

	@GET
	@Path("/get/context/uriinfo")
	@Produces(MediaType.TEXT_PLAIN)
	public Response getContextUriInfo(@Context UriInfo uriInfo) {
		return Response.ok("something").build();
	}

	@GET
	@Path("/get/context/httpheaders")
	@Produces(MediaType.TEXT_PLAIN)
	public Response getContextHttpHeaders(@Context HttpHeaders httpHeaders) {
		return Response.ok("something").build();
	}

	@GET
	@Path("/get/context/request")
	@Produces(MediaType.TEXT_PLAIN)
	public Response getContextRequest(@Context Request request) {
		return Response.ok("something").build();
	}

	@GET
	@Path("/get/context/securitycontext")
	@Produces(MediaType.TEXT_PLAIN)
	public Response getContextSecurityContext(@Context SecurityContext securityContext) {
		return Response.ok("something").build();
	}

	@GET
	@Path("/get/context/providers")
	@Produces(MediaType.TEXT_PLAIN)
	public Response getContextProviders(@Context Providers providers) {
		return Response.ok("something").build();
	}

	@GET
	@Path("/get/context/resourcecontext")
	@Produces(MediaType.TEXT_PLAIN)
	public Response getContextResourceContext(@Context ResourceContext resourceContext) {
		return Response.ok("something").build();
	}

	@GET
	@Path("/get/context/configuration")
	@Produces(MediaType.TEXT_PLAIN)
	public Response getContextConfiguration(@Context Configuration configuration) {
		return Response.ok("something").build();
	}

	@GET
	@Path("/get/context/servletconfig")
	@Produces(MediaType.TEXT_PLAIN)
	public Response getContextServletConfig(@Context ServletConfig servletConfig) {
		return Response.ok("something").build();
	}

	@GET
	@Path("/get/context/servletcontext")
	@Produces(MediaType.TEXT_PLAIN)
	public Response getContextServletContext(@Context ServletContext servletContext) {
		return Response.ok("something").build();
	}

	@GET
	@Path("/get/context/httpservletrequest")
	@Produces(MediaType.TEXT_PLAIN)
	public Response getContextHttpServletRequest(@Context HttpServletRequest httpServletRequest) {
		return Response.ok("something").build();
	}

	@GET
	@Path("/get/context/httpservletresponse")
	@Produces(MediaType.TEXT_PLAIN)
	public Response getContextHttpServletResponse(@Context HttpServletResponse httpServletResponse) {
		return Response.ok("something").build();
	}
	
//	Accept
//	Accept-Charset
//	Accept-Encoding
//	Accept-Language
//	Allow
//	Authorization
//	Cache-Control
//	Content-Encoding
//	Content-Language
//	Content-Length
//	Content-Type
//	Cookie
//	Date
//	ETag
//	Expect
//	Expires
//	If-Match
//	If-Modified-Since
//	If-Unmodified-Since
//	Last-Modified
//	Location
//	Set-Cookie
//	Transfer-Encoding
//	Vary
//	WWW-Authenticate
	
}
