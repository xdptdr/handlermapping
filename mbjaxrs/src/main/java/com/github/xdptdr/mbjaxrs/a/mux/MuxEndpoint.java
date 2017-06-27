package com.github.xdptdr.mbjaxrs.a.mux;

import javax.ws.rs.BeanParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

@Provider
@Path("/mux")
public class MuxEndpoint {

	@GET
	@Path("/get")
	public Response get(@BeanParam MuxBean muxBean) {
		return Response.ok().entity(Entity.text(muxBean.getParam())).build();
	}

}
