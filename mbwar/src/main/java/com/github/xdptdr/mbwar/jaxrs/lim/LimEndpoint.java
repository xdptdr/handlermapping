package com.github.xdptdr.mbwar.jaxrs.lim;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.CacheControl;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

@Provider
@Path("/lim")
public class LimEndpoint {

	@GET
	@Path("/get")
	@Produces(MediaType.TEXT_PLAIN)
	public Response get(@QueryParam("mustRevalidate") boolean mustRevalidate, @QueryParam("noCache") boolean noCache,
			@QueryParam("noStore") boolean noStore, @QueryParam("noTransform") boolean noTransform,
			@QueryParam("private") boolean pprivate, @QueryParam("proxyRevalidate") boolean proxyRevalidate,
			@QueryParam("maxAge") int maxAge, @QueryParam("sMaxAge") int sMaxAge

	) {
		CacheControl cacheControl = new CacheControl();
		cacheControl.setMaxAge(maxAge);
		cacheControl.setMustRevalidate(mustRevalidate);
		cacheControl.setNoCache(noCache);
		cacheControl.setNoStore(noStore);
		cacheControl.setNoTransform(noTransform);
		cacheControl.setPrivate(pprivate);
		cacheControl.setProxyRevalidate(proxyRevalidate);
		cacheControl.setSMaxAge(sMaxAge);

		Map<String, Object> infos = new HashMap<>();
		infos.put("cacheExtension", cacheControl.getCacheExtension());
		infos.put("noCacheFields", cacheControl.getNoCacheFields());
		infos.put("privateFields", cacheControl.getPrivateFields());

		return Response.ok().entity(Entity.text("content")).cacheControl(cacheControl).build();
	}

}
