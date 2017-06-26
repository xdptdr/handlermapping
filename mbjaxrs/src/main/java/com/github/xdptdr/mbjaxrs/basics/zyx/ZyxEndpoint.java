package com.github.xdptdr.mbjaxrs.basics.zyx;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;
import javax.ws.rs.ext.Providers;

@Provider
@Path("/zyx")
public class ZyxEndpoint {

	@GET
	@Produces("zyx/plain")
	public Response get(@Context Providers providers) {
		MediaType mt = new MediaType("zyx", "plain");
		ContextResolver<ZyxContext> resolver = providers.getContextResolver(ZyxContext.class, mt);
		ZyxContext context = resolver.getContext(null);
		return Response.ok(context.zyxIt()).build();
	}
}
