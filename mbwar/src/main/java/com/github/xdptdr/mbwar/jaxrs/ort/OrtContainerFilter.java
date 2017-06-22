package com.github.xdptdr.mbwar.jaxrs.ort;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;

public class OrtContainerFilter implements ContainerRequestFilter, ContainerResponseFilter {

	@Override
	public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext)
			throws IOException {
		responseContext.getHeaders().putSingle("ortContainerResponseFilter", "Been there");
		;
	}

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {

	}

}
