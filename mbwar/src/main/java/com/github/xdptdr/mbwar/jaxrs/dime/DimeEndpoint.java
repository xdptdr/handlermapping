package com.github.xdptdr.mbwar.jaxrs.dime;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

@Provider
@Path("/dime")
public class DimeEndpoint {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response get() {

		List<String> list = new ArrayList<>();
		list.add("hello");
		list.add("from");
		list.add("Dime");

		GenericEntity<List<String>> entity = new GenericEntity<List<String>>(list) {
		};
		
		return Response.ok(entity).build();
	}

}
