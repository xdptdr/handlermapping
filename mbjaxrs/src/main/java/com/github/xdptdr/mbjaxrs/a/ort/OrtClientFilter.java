package com.github.xdptdr.mbjaxrs.a.ort;

import java.io.IOException;

import javax.ejb.EJB;
import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientRequestFilter;
import javax.ws.rs.client.ClientResponseContext;
import javax.ws.rs.client.ClientResponseFilter;
import javax.ws.rs.ext.Provider;

@Provider
public class OrtClientFilter implements ClientRequestFilter, ClientResponseFilter {

	@EJB
	OrtTracer tracer;
	
	@Override
	public void filter(ClientRequestContext requestContext, ClientResponseContext responseContext) throws IOException {
		tracer.trace("com.github.xdptdr.mbwar.jaxrs.ort.OrtClientFilter.filter(ClientRequestContext, ClientResponseContext)");
	}

	@Override
	public void filter(ClientRequestContext requestContext) throws IOException {
		tracer.trace("com.github.xdptdr.mbwar.jaxrs.ort.OrtClientFilter.filter(ClientRequestContext)");
	}

}
