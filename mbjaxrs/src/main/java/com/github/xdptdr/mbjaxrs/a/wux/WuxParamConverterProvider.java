package com.github.xdptdr.mbjaxrs.a.wux;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import javax.ws.rs.ext.ParamConverter;
import javax.ws.rs.ext.ParamConverterProvider;
import javax.ws.rs.ext.Provider;

@Provider
public class WuxParamConverterProvider implements ParamConverterProvider {

	@Override
	public <T> ParamConverter<T> getConverter(Class<T> rawType, Type genericType, Annotation[] annotations) {
		if (rawType == WuxParam.class) {
			WuxParamConverter wcp = new WuxParamConverter();
			return new ParamConverter<T>() {

				@Override
				public T fromString(String value) {
					WuxParam r = wcp.fromString(value);
					return rawType.cast(r);
				}

				@Override
				public String toString(T value) {
					return wcp.toString((WuxParam) value);
				}
			};
		}
		return null;
	}

}
