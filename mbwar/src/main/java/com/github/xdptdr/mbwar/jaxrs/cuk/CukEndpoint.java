package com.github.xdptdr.mbwar.jaxrs.cuk;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.Provider;

@Provider
@Path("/cuk")
public class CukEndpoint {

	Map<Integer, CukBean> cuks = new HashMap<>();
	int cukMaxId = 0;

	public CukEndpoint() {
		cuks.put(0, new CukBean("cukAze"));
		cuks.put(1, new CukBean("cukBar"));
		cukMaxId = 2;
	}

	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public Response get() {
		return Response.ok().entity(cuks).build();
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response get(@PathParam("id") int id) {
		if (cuks.containsKey(id)) {
			return Response.ok().entity(cuks.get(id)).build();
		} else {
			return Response.status(Status.NOT_FOUND).build();
		}
	}

	@POST
	@Path("/")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN)
	public Response post(String content) {
		int id = cukMaxId;
		cuks.put(id, new CukBean(content));
		++cukMaxId;
		return Response.ok().entity(id).build();
	}

	@PUT
	@Path("/")
	@Consumes(MediaType.TEXT_PLAIN)
	public Response put(String contents) {
		cukMaxId = 0;
		cuks.clear();
		for (String content : contents.split(" ")) {
			cuks.put(cukMaxId, new CukBean(content.trim()));
			++cukMaxId;

		}
		return Response.ok().build();
	}

	@PUT
	@Path("/{id}")
	@Consumes(MediaType.TEXT_PLAIN)
	public Response put(@PathParam("id") int id, String contents) {
		cuks.put(id, new CukBean(contents));
		if (cukMaxId <= id) {
			cukMaxId = id + 1;
		}
		return Response.ok().build();
	}

	@DELETE
	@Path("/")
	public Response delete() {
		cuks.clear();
		cukMaxId = 0;
		return Response.ok().build();
	}

	@DELETE
	@Path("/{id}")
	public Response delete(@PathParam("id") int id) {
		if (cuks.containsKey(id)) {
			cuks.remove(id);
			return Response.ok().build();
		} else {
			return Response.status(Status.NOT_FOUND).build();
		}
	}

}
