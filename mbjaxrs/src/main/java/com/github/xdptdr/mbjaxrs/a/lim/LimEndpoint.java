package com.github.xdptdr.mbjaxrs.a.lim;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.CacheControl;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

@Provider
@Path("/lim")
public class LimEndpoint {

	private static final String CONTENT = "content";

	@GET
	@Path("/get/unset")
	@Produces(MediaType.TEXT_PLAIN)
	public Response get() {
		CacheControl cacheControl = new CacheControl();
		cacheControl.setNoTransform(false);
		return Response.ok().entity(Entity.text(CONTENT)).cacheControl(cacheControl).build();
	}

	@GET
	@Path("/get/maxAge")
	@Produces(MediaType.TEXT_PLAIN)
	public Response getMaxAge() {
		CacheControl cacheControl = new CacheControl();
		cacheControl.setNoTransform(false);
		cacheControl.setMaxAge(1000);
		return Response.ok().entity(Entity.text(CONTENT)).cacheControl(cacheControl).build();
	}

	@GET
	@Path("/get/sMaxAge")
	@Produces(MediaType.TEXT_PLAIN)
	public Response getSMaxAge() {
		CacheControl cacheControl = new CacheControl();
		cacheControl.setNoTransform(false);
		cacheControl.setSMaxAge(1000);
		return Response.ok().entity(Entity.text(CONTENT)).cacheControl(cacheControl).build();
	}

	@GET
	@Path("/get/mustRevalidate")
	@Produces(MediaType.TEXT_PLAIN)
	public Response getMustRevalidate() {
		CacheControl cacheControl = new CacheControl();
		cacheControl.setNoTransform(false);
		cacheControl.setMustRevalidate(true);
		return Response.ok().entity(Entity.text(CONTENT)).cacheControl(cacheControl).build();
	}

	@GET
	@Path("/get/noCache")
	@Produces(MediaType.TEXT_PLAIN)
	public Response getNoCache() {
		CacheControl cacheControl = new CacheControl();
		cacheControl.setNoTransform(false);
		cacheControl.setNoCache(true);
		return Response.ok().entity(Entity.text(CONTENT)).cacheControl(cacheControl).build();
	}

	@GET
	@Path("/get/noStore")
	@Produces(MediaType.TEXT_PLAIN)
	public Response getNoStore() {
		CacheControl cacheControl = new CacheControl();
		cacheControl.setNoTransform(false);
		cacheControl.setNoStore(true);
		return Response.ok().entity(Entity.text(CONTENT)).cacheControl(cacheControl).build();
	}

	@GET
	@Path("/get/noTransform")
	@Produces(MediaType.TEXT_PLAIN)
	public Response getNoTransform() {
		CacheControl cacheControl = new CacheControl();
		cacheControl.setNoTransform(true);
		return Response.ok().entity(Entity.text(CONTENT)).cacheControl(cacheControl).build();
	}

	@GET
	@Path("/get/private")
	@Produces(MediaType.TEXT_PLAIN)
	public Response getPrivate() {
		CacheControl cacheControl = new CacheControl();
		cacheControl.setNoTransform(false);
		cacheControl.setPrivate(true);
		return Response.ok().entity(Entity.text(CONTENT)).cacheControl(cacheControl).build();
	}

	@GET
	@Path("/get/proxyRevalidate")
	@Produces(MediaType.TEXT_PLAIN)
	public Response getProxyRevalidate() {
		CacheControl cacheControl = new CacheControl();
		cacheControl.setNoTransform(false);
		cacheControl.setProxyRevalidate(true);
		return Response.ok().entity(Entity.text(CONTENT)).cacheControl(cacheControl).build();
	}

	@GET
	@Path("/get/cacheExtension")
	@Produces(MediaType.TEXT_PLAIN)
	public Response getCacheExtension() {
		CacheControl cacheControl = new CacheControl();
		cacheControl.setNoTransform(false);
		cacheControl.getCacheExtension().put("cacheExtensionKey1", "cacheExtensionValue1");
		cacheControl.getCacheExtension().put("cacheExtensionKey2", null);
		cacheControl.getCacheExtension().put("cacheExtensionKey3", "cache extension value 3");
		return Response.ok().entity(Entity.text(CONTENT)).cacheControl(cacheControl).build();
	}

	@GET
	@Path("/get/noCacheFields")
	@Produces(MediaType.TEXT_PLAIN)
	public Response getNoCacheFields() {
		CacheControl cacheControl = new CacheControl();
		cacheControl.setNoTransform(false);
		cacheControl.setNoCache(true);
		cacheControl.getNoCacheFields().add("noCacheField1");
		cacheControl.getNoCacheFields().add("noCacheField2");
		return Response.ok().entity(Entity.text(CONTENT)).cacheControl(cacheControl).build();
	}

	@GET
	@Path("/get/privateFields")
	@Produces(MediaType.TEXT_PLAIN)
	public Response getPrivateFields() {
		CacheControl cacheControl = new CacheControl();
		cacheControl.setNoTransform(false);
		cacheControl.setPrivate(true);
		cacheControl.getPrivateFields().add("privateField1");
		cacheControl.getPrivateFields().add("privateField2");
		return Response.ok().entity(Entity.text(CONTENT)).cacheControl(cacheControl).build();
	}

}
