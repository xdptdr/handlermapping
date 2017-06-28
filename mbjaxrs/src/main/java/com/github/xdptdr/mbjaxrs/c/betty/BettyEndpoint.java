package com.github.xdptdr.mbjaxrs.c.betty;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.Provider;

import org.jboss.resteasy.annotations.providers.jackson.Formatted;

@Provider
@Path("/betty")
@Produces({ MediaType.APPLICATION_JSON })
public class BettyEndpoint {

	private BettyBean bean = new BettyBean();

	@GET
	@Formatted
	@Path("/formatted")
	public BettyBean getFormatted() {
		return bean;
	}

	@GET
	@Path("/notformatted")
	public BettyBean getNotFormatted() {
		return bean;
	}
}
