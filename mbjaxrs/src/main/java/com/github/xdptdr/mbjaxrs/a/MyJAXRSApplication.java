package com.github.xdptdr.mbjaxrs.a;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import org.jboss.resteasy.plugins.interceptors.CorsFilter;

@ApplicationPath("/rs")
public class MyJAXRSApplication extends Application {
	@Override
	public Set<Object> getSingletons() {

		CorsFilter filter = new CorsFilter();
		filter.getAllowedOrigins().add("*");
		filter.setAllowedMethods("GET,PUT,POST,DELETE,OPTIONS");

		Set<Object> singletons = new HashSet<>();
		singletons.add(filter);
		return singletons;
	}
}
