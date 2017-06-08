package com.github.xdptdr.mbwar.jaxrs.bar;

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
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.Provider;

import com.github.xdptdr.mbwar.jaxrs.bar.BAR;
import com.github.xdptdr.mbwar.jaxrs.bar.BarBean;

@Provider
@Path("/bar")
public class BarEndpoint {

	Map<Integer, BarBean> bars = new HashMap<>();
	int barMaxId = 0;

	public BarEndpoint() {
		bars.put(0, new BarBean("barAze"));
		bars.put(1, new BarBean("barBar"));
		barMaxId = 2;
	}

	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public Response get() {
		return Response.ok().entity(bars).build();
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response get(@PathParam("id") int id) {
		if (bars.containsKey(id)) {
			return Response.ok().entity(bars.get(id)).build();
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
		if (bars.containsKey(id)) {
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
		int id = barMaxId;
		bars.put(id, new BarBean(content));
		++barMaxId;
		return Response.ok().entity(id).build();
	}

	@PUT
	@Path("/")
	@Consumes(MediaType.TEXT_PLAIN)
	public Response put(String contents) {
		barMaxId = 0;
		bars.clear();
		for (String content : contents.split(" ")) {
			bars.put(barMaxId, new BarBean(content.trim()));
			++barMaxId;

		}
		return Response.ok().build();
	}

	@PUT
	@Path("/{id}")
	@Consumes(MediaType.TEXT_PLAIN)
	public Response put(@PathParam("id") int id, String contents) {
		bars.put(id, new BarBean(contents));
		if (barMaxId <= id) {
			barMaxId = id + 1;
		}
		return Response.ok().build();
	}

	@DELETE
	@Path("/")
	public Response delete() {
		bars.clear();
		barMaxId = 0;
		return Response.ok().build();
	}

	@DELETE
	@Path("/{id}")
	public Response delete(@PathParam("id") int id) {
		if (bars.containsKey(id)) {
			bars.remove(id);
			return Response.ok().build();
		} else {
			return Response.status(Status.NOT_FOUND).build();
		}
	}

	@BAR
	@Path("/")
	@Produces(MediaType.TEXT_PLAIN)
	public Response bar() {
		return Response.ok().entity("This endpoint has BAR power !").build();
	}

}
