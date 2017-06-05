package com.github.xdptdr.mbwar.jaxrs;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.nio.charset.Charset;

import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;

@Provider
@Produces(MediaType.TEXT_PLAIN)
public class FooMBW implements MessageBodyWriter<Foo> {

	@Override
	public boolean isWriteable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
		return type == Foo.class && MediaType.TEXT_PLAIN_TYPE.equals(mediaType);
	}

	@Override
	public long getSize(Foo t, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
		return -1;
	}

	@Override
	public void writeTo(Foo t, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType,
			MultivaluedMap<String, Object> httpHeaders, OutputStream entityStream)
			throws IOException, WebApplicationException {
		StringBuffer buf = new StringBuffer();
		buf.append(t.getFirstName());
		buf.append(" ");
		buf.append(t.getLastName());
		entityStream.write(buf.toString().getBytes(Charset.forName("UTF-8")));

	}

}
