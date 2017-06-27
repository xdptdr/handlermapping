package com.github.xdptdr.mbjaxrs.a.eta;

import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

@Provider
@Path("/eta")
public class EtaEndpoint {
	@GET
	@Path("/get/queryparam")
	@Produces(MediaType.TEXT_PLAIN)
	public Response getQueryParamDefaultValue(@QueryParam("p") @DefaultValue("eta") String p) {
		return Response.ok(p).build();
	}

	@GET
	@Path("/get/matrixparam")
	@Produces(MediaType.TEXT_PLAIN)
	public Response getMatrixParamDefaultValue(@MatrixParam("p") @DefaultValue("eta") String p) {
		return Response.ok(p).build();
	}

	@GET
	@Path("/get/cookieparam")
	@Produces(MediaType.TEXT_PLAIN)
	public Response getCookieParamDefaultValue(@CookieParam("p") @DefaultValue("eta") String p) {
		return Response.ok(p).build();
	}

	@POST
	@Path("/post/formparam")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public Response getFormParamDefaultValue(@FormParam("p") @DefaultValue("eta") String p) {
		return Response.ok(p).build();
	}

	@GET
	@Path("/get/headerparam")
	@Produces(MediaType.TEXT_PLAIN)
	public Response getHeaderParamDefaultValue(@HeaderParam("p") @DefaultValue("eta") String p) {
		return Response.ok(p).build();
	}
}
