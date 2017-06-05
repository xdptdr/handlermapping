package com.github.xdptdr.mbwar.jaxrs;

import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Scanner;

import javax.ws.rs.Consumes;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.Provider;

@Provider
@Consumes(MediaType.TEXT_PLAIN)
public class FooMBR implements MessageBodyReader<Foo> {

	@Override
	public boolean isReadable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
		return type == Foo.class && MediaType.TEXT_PLAIN_TYPE.equals(mediaType);
	}

	@Override
	public Foo readFrom(Class<Foo> type, Type genericType, Annotation[] annotations, MediaType mediaType,
			MultivaluedMap<String, String> httpHeaders, InputStream entityStream)
			throws IOException, WebApplicationException {

		Scanner s = new Scanner(entityStream, "UTF-8");
		s.useDelimiter("\\A");
		String str = s.hasNext() ? s.next() : "";
		s.close();

		String[] parts = str.split(" ");

		Foo foo = new Foo();
		foo.setFirstName(parts.length >= 1 ? parts[0] : "");
		foo.setLastName(parts.length >= 2 ? parts[1] : "");
		return foo;
	}

}
