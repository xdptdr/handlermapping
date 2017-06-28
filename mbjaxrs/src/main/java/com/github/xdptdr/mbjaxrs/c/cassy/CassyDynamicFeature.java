package com.github.xdptdr.mbjaxrs.c.cassy;

import javax.ws.rs.container.DynamicFeature;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.FeatureContext;
import javax.ws.rs.ext.Provider;

import org.jboss.resteasy.plugins.interceptors.CorsFilter;

@Provider
public class CassyDynamicFeature implements DynamicFeature {

	@Override
	public void configure(ResourceInfo resourceInfo, FeatureContext context) {
		if (resourceInfo.getResourceClass() == CassyEndpoint.class
				&& resourceInfo.getResourceMethod().isAnnotationPresent(CassyCORS.class)) {
			CorsFilter filter = new CorsFilter();
			filter.getAllowedOrigins().add("http://cassy.local");
			context.register(filter);
		}
	}

}
