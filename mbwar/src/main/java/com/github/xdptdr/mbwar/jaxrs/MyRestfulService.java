package com.github.xdptdr.mbwar.jaxrs;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.Provider;

@Provider
@Path("/myRestfulService")
public class MyRestfulService {

	private Foo foo = new Foo("Foo", "Bar");

	@GET
	@Path("/get")
	public String get() {
		return "Hello from " + this.getClass().getName();
	}

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/getFoo")
	public Foo getFoo() {
		return foo;
	}

	@POST
	@Path("/saveFoo")
	public void saveFoo() {
	}
}
