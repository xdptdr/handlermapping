package com.github.xdptdr.mbwar.jaxrs.zyx;

import javax.ws.rs.Produces;
import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

@Provider
@Produces("zyx/plain")
public class ZyxContextResolver implements ContextResolver<ZyxContext> {

	public ZyxContextResolver() {
	}

	@Override
	public ZyxContext getContext(Class<?> type) {
		return new ZyxContextImpl();
	}

}
