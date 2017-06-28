package com.github.xdptdr.mbjaxrs.c.agate;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.Provider;

import org.jboss.resteasy.links.AddLinks;
import org.jboss.resteasy.links.LinkResource;

@Provider
@Path("/agate")
@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
public class AgateEndpoint {

	List<AgateResource> resources = new ArrayList<>();

	public AgateEndpoint() {
		resources.add(new AgateResource("Aze", "Land of Aze"));
		resources.add(new AgateResource("Bar", "Land of Bar"));
	}

	@GET
	@AddLinks
	@LinkResource(AgateResource.class)
	public List<AgateResource> get() {
		return resources;
	}

	@GET
	@AddLinks
	@Path("/agate/{id}")
	@LinkResource
	public AgateResource getById(@PathParam("id") Integer id) {
		return resources.get(id);
	}
}
