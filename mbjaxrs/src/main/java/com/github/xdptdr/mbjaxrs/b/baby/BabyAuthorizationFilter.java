package com.github.xdptdr.mbjaxrs.b.baby;

import java.io.IOException;

import javax.annotation.Priority;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;

@Provider
@Priority(Priorities.AUTHORIZATION)
public class BabyAuthorizationFilter implements ContainerResponseFilter {

	@Override
	public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) throws IOException {
		if (responseContext.getHeaders().containsKey("BABY")) {
			responseContext.getHeaders().add("PRIORITY", "AUTHORIZATION");
		}
	}

}
