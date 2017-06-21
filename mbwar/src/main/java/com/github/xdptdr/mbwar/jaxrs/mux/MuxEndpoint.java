package com.github.xdptdr.mbwar.jaxrs.mux;

import javax.ws.rs.BeanParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.Provider;

@Provider
@Path("/mux")
public class MuxEndpoint {

	@GET
	@Path("/get")
	@Produces(MediaType.TEXT_PLAIN)
	public String get(@BeanParam MuxBean muxBean) {
		return muxBean.getParam();
	}

}
