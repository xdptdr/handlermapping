package com.github.xdptdr.mbwar.jaxrs.ort;

import java.io.IOException;

import javax.ejb.EJB;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;

@Provider
public class OrtContainerFilterPostMatching implements ContainerRequestFilter, ContainerResponseFilter {
	
	@EJB
	OrtTracer tracer;

	@Override
	public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext)
			throws IOException {
		tracer.trace("com.github.xdptdr.mbwar.jaxrs.ort.OrtContainerFilterPostMatching.filter(ContainerRequestContext, ContainerResponseContext)");
	}

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		tracer.trace("com.github.xdptdr.mbwar.jaxrs.ort.OrtContainerFilterPostMatching.filter(ContainerRequestContext)");
	}

}
