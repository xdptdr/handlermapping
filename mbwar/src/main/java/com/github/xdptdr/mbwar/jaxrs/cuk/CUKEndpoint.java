package com.github.xdptdr.mbwar.jaxrs.cuk;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HEAD;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.Provider;

@Provider
@Path("/cuks")
public class CUKEndpoint {

	Map<Integer, CUKBean> cuks = new HashMap<>();
	int cukMaxId = 0;

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response post(CUKBean cukBean) {
		cukBean.setId(cukMaxId);
		++cukMaxId;
		return Response.ok().entity(cukBean.getId()).build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response get(@QueryParam("id") int id) {
		if (cuks.containsKey(id)) {
			return Response.ok().entity(cuks.get(id)).build();
		} else {
			return Response.status(Status.NOT_FOUND).build();
		}
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response put(CUKBean cukBean) {
		if (cuks.containsKey(cukBean.getId())) {
			cuks.put(cukBean.getId(), cukBean);
			return Response.ok().build();
		} else {
			return Response.status(Status.NOT_FOUND).build();
		}
	}

	@DELETE
	public Response delete(@QueryParam("id") int id) {
		if (cuks.containsKey(id)) {
			cuks.remove(id);
			return Response.ok().build();
		} else {
			return Response.status(Status.NOT_FOUND).build();
		}
	}

	@HEAD
	public Response head(@QueryParam("id") int id) {
		if (cuks.containsKey(id)) {
			return Response.ok().build();
		} else {
			return Response.status(Status.NOT_FOUND).build();
		}
	}

}
