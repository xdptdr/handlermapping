package com.github.xdptdr.mbwar.jaxrs.ort;

import java.io.IOException;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.ext.Provider;
import javax.ws.rs.ext.ReaderInterceptor;
import javax.ws.rs.ext.ReaderInterceptorContext;
import javax.ws.rs.ext.WriterInterceptor;
import javax.ws.rs.ext.WriterInterceptorContext;

@Provider
public class OrtInterceptor implements ReaderInterceptor, WriterInterceptor {

	@Override
	public void aroundWriteTo(WriterInterceptorContext context) throws IOException, WebApplicationException {
		if (context.getHeaders().containsKey("com.github.xdptdr.mbwar.jaxrs.ort.OrtEndpoint")) {
			context.getHeaders().putSingle(
					"com.github.xdptdr.mbwar.jaxrs.ort.OrtInterceptor.aroundWriteTo(WriterInterceptorContext)",
					"Been there");
		}
		context.proceed();
	}

	@Override
	public Object aroundReadFrom(ReaderInterceptorContext context) throws IOException, WebApplicationException {
		if (context.getHeaders().containsKey("com.github.xdptdr.mbwar.jaxrs.ort.OrtEndpoint")) {
			context.getHeaders().putSingle(
					"com.github.xdptdr.mbwar.jaxrs.ort.OrtInterceptor.aroundReadFrom(ReaderInterceptorContext)",
					"Been there");
		}
		return context.proceed();
	}

}
