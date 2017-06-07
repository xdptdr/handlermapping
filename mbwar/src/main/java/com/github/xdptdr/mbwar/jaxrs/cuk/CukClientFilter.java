package com.github.xdptdr.mbwar.jaxrs.cuk;

import java.io.IOException;

import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientRequestFilter;
import javax.ws.rs.client.ClientResponseContext;
import javax.ws.rs.client.ClientResponseFilter;
import javax.ws.rs.ext.Provider;

@Provider
public class CukClientFilter implements ClientRequestFilter, ClientResponseFilter{

	@Override
	public void filter(ClientRequestContext requestContext, ClientResponseContext responseContext) throws IOException {
		
	}

	@Override
	public void filter(ClientRequestContext requestContext) throws IOException {
		
	}

}
