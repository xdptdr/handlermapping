package com.github.xdptdr.mbwar.jaxrs.servlet;

import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.DELETE;
import javax.ws.rs.Encoded;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.HEAD;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

@Provider
public class POJO {

	@Context
	Object context;

	@HeaderParam("")
	Object headerParam;

	@CookieParam("")
	Object cookieParam;

	@MatrixParam("")
	@Encoded
	Object matrixParam;

	@QueryParam("")
	@Encoded
	Object queryParam;

	@PathParam("")
	@Encoded
	Object pathParam;

	public POJO(@Context Object context, @HeaderParam("") Object headerParam, @CookieParam("") Object cookieParam,
			@MatrixParam("") Object matrixParam, @QueryParam("") Object queryParam, @PathParam("") Object pathParam) {
	}

	@Path("/tigrou")
	public void foo() {

	}

	@GET
	@Path("/tigrou")
	public void get() {
	}

	@GET
	@Path("/tigrou")
	public void getVoid() {
	}

	@GET
	@Path("/tigrou")
	public Response getResponse() {
		return null;
	}

	@GET
	@Path("/tigrou")
	public GenericEntity<String> getGenericStringEntity() {
		return null;
	}

	@GET
	@Path("/tigrou")
	public String getString() {
		return null;
	}

	@POST
	@Path("/tigrou")
	public void post(@FormParam("") String formParam, String body) {
	}

	@PUT
	@Path("/tigrou")
	public void put() {
	}

	@DELETE
	@Path("/tigrou")
	public void delete() {
	}

	@HEAD
	@Path("/tigrou")
	public void head() {
	}

	@OPTIONS
	@Path("/tigrou")
	public void options() {
	}

	@Path("/subResourceLocator")
	public POJOSub getSubResourceLocator() {
		return new POJOSub();
	}

	@Path("")
	@GET
	@Consumes("image/jpeg")
	@Produces({ "image/jpeg; qs=1", "text/plain; qs=0.5" })
	public String consumesAndProduces() {
		return null;
	}
}
