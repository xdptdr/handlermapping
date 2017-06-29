package com.github.xdptdr.mbjaxrs.c.cassy;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;

import org.jboss.resteasy.plugins.interceptors.CorsFilter;

@Provider
@CassyCORSDefault
public class CassyCORSDefaultFilter implements ContainerRequestFilter, ContainerResponseFilter {

	private CorsFilter filter;

	public CassyCORSDefaultFilter() {
		filter = new CorsFilter();
		filter.getAllowedOrigins().add("http://cassy.local");
	}

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		filter.filter(requestContext);
	}

	@Override
	public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext)
			throws IOException {
		filter.filter(requestContext, responseContext);
	}

}
