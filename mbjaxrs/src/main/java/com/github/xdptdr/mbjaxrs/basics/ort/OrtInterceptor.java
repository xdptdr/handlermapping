package com.github.xdptdr.mbjaxrs.basics.ort;

import java.io.IOException;

import javax.ejb.EJB;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.ext.Provider;
import javax.ws.rs.ext.ReaderInterceptor;
import javax.ws.rs.ext.ReaderInterceptorContext;
import javax.ws.rs.ext.WriterInterceptor;
import javax.ws.rs.ext.WriterInterceptorContext;

@Provider
public class OrtInterceptor implements ReaderInterceptor, WriterInterceptor {

	@EJB
	OrtTracer tracer;

	@Override
	public void aroundWriteTo(WriterInterceptorContext context) throws IOException, WebApplicationException {
		tracer.trace("com.github.xdptdr.mbwar.jaxrs.ort.OrtInterceptor.aroundWriteTo(WriterInterceptorContext)");
		context.proceed();
	}

	@Override
	public Object aroundReadFrom(ReaderInterceptorContext context) throws IOException, WebApplicationException {
		tracer.trace("com.github.xdptdr.mbwar.jaxrs.ort.OrtInterceptor.aroundReadFrom(ReaderInterceptorContext)");
		return context.proceed();
	}

}
