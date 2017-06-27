package com.github.xdptdr.mbjaxrs.a.kol;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HEAD;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.EntityTag;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.Provider;

@Provider
@Path("/kol")
public class KolEndpoint {

	Map<Integer, KolBean> kols = new HashMap<>();
	Map<Integer, Integer> versions = new HashMap<>();
	int kolMaxId = 0;

	public KolEndpoint() {
		kols.put(0, new KolBean("kolAze"));
		kols.put(1, new KolBean("kolBar"));
		modified(0);
		modified(1);
		kolMaxId = 2;
	}

	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public Response get() {
		return Response.ok().entity(kols).build();
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response get(@PathParam("id") int id, @Context Request request) {

		EntityTag eTag = new EntityTag(versions.containsKey(id) ? versions.get(id).toString() : "1", true);
		ResponseBuilder r = request.evaluatePreconditions(eTag);
		if (r != null) {
			return r.build();
		}

		if (kols.containsKey(id)) {
			return Response.ok().entity(kols.get(id)).tag(eTag).build();
		} else {
			return Response.status(Status.NOT_FOUND).build();
		}
	}

	@HEAD
	@Path("/")
	public Response head() {
		return Response.ok().build();
	}

	@HEAD
	@Path("/{id}")
	public Response head(@PathParam("id") int id) {

		if (kols.containsKey(id)) {
			return Response.ok().build();
		} else {
			return Response.status(Status.NOT_FOUND).build();
		}
	}

	@POST
	@Path("/")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN)
	public Response post(String content) {
		int id = kolMaxId;
		kols.put(id, new KolBean(content));
		modified(id);
		++kolMaxId;
		return Response.ok().entity(id).build();
	}

	@PUT
	@Path("/")
	@Consumes(MediaType.TEXT_PLAIN)
	public Response put(String contents) {
		kolMaxId = 0;
		kols.clear();
		for (String content : contents.split(" ")) {
			kols.put(kolMaxId, new KolBean(content.trim()));
			modified(kolMaxId);
			++kolMaxId;

		}
		return Response.ok().build();
	}

	@PUT
	@Path("/{id}")
	@Consumes(MediaType.TEXT_PLAIN)
	public Response put(@PathParam("id") int id, String contents) {
		kols.put(id, new KolBean(contents));
		modified(id);
		if (kolMaxId <= id) {
			kolMaxId = id + 1;
		}
		return Response.ok().build();
	}

	@DELETE
	@Path("/")
	public Response delete() {
		for (Integer id : kols.keySet()) {
			modified(id);
		}
		kols.clear();
		kolMaxId = 0;
		return Response.ok().build();
	}

	@DELETE
	@Path("/{id}")
	public Response delete(@PathParam("id") int id) {
		if (kols.containsKey(id)) {
			kols.remove(id);
			modified(id);
			return Response.ok().build();
		} else {
			return Response.status(Status.NOT_FOUND).build();
		}
	}

	private void modified(int id) {
		if (!versions.containsKey(id)) {
			versions.put(id, 1);
		} else {
			versions.put(id, versions.get(id) + 1);
		}
	}
}
