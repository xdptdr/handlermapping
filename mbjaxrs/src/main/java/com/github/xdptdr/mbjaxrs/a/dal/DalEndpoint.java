package com.github.xdptdr.mbjaxrs.a.dal;

import javax.ws.rs.Encoded;
import javax.ws.rs.GET;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

@Provider
@Path("/dal")
public class DalEndpoint {

	@GET
	@Path("/get/queryparam")
	@Produces(MediaType.TEXT_PLAIN)
	public Response getQueryParamEncoded(@QueryParam("p") @Encoded String p) {
		return Response.ok(p).build();
	}

	@GET
	@Path("/get/pathparam/{p}")
	@Produces(MediaType.TEXT_PLAIN)
	public Response getPathParamEncoded(@PathParam("p") @Encoded String p) {
		return Response.ok(p).build();
	}

	@GET
	@Path("/get/matrixparam")
	@Produces(MediaType.TEXT_PLAIN)
	public Response getMatrixParamEncoded(@MatrixParam("p") @Encoded String p) {
		return Response.ok(p).build();
	}
}
