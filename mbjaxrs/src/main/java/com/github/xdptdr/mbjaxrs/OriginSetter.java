package com.github.xdptdr.mbjaxrs;

import java.io.IOException;

import javax.annotation.Priority;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.ext.Provider;

@PreMatching
@Priority(Priorities.AUTHENTICATION)
@Provider
public class OriginSetter implements ContainerRequestFilter {

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		if (requestContext.getHeaders().containsKey("Origin")) {
			requestContext.getHeaders().putSingle("Origin", "http://localhost:8080");
		}
	}

}
