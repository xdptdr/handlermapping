package com.github.xdptdr.mbjaxrs2;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/rs2")
public class JAXRS2Application extends Application {
	@Override
	public Map<String, Object> getProperties() {
		Map<String, Object> properties = new HashMap<>();
		properties.put("resteasy.role.based.security", "true");
		return properties;
	}
}
