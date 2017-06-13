package com.github.xdptdr.mbwar.utils;

import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.ws.rs.RuntimeType;
import javax.ws.rs.core.Configuration;

public class Infos {

	public static Map<String, String> get(URI uri) {
		Map<String, String> map = new HashMap<>();
		map.put("authority", uri.getAuthority());
		map.put("fragment", uri.getFragment());
		map.put("host", uri.getHost());
		map.put("path", uri.getPath());
		map.put("port", Integer.toString(uri.getPort()));
		map.put("query", uri.getQuery());
		map.put("rawAuthority", uri.getRawAuthority());
		map.put("rawFragment", uri.getRawFragment());
		map.put("rawPath", uri.getRawPath());
		map.put("rawQuery", uri.getRawQuery());
		map.put("rawSchemeSpecificPart", uri.getRawSchemeSpecificPart());
		map.put("rawUserInfo", uri.getRawUserInfo());
		map.put("scheme", uri.getScheme());
		map.put("schemeSpecificPart", uri.getSchemeSpecificPart());
		map.put("userInfo", uri.getUserInfo());
		map.put("absolute", Boolean.toString(uri.isAbsolute()));
		map.put("opaque", Boolean.toString(uri.isOpaque()));
		map.put("asciiString", uri.toASCIIString());
		map.put("string", uri.toString());
		return map;
	}

	public static String stringify(Object o) {
		if (o == null) {
			return "n$";
		} else if (o instanceof String) {
			return "s$" + o;
		} else {
			return "c$" + o.getClass().getName();
		}
	}

	public static Map<String, Object> get(Configuration c) {
		Map<String, Object> infos = new HashMap<>();

		List<String> classes = new ArrayList<>();
		for (Class<?> clazz : c.getClasses()) {
			classes.add(clazz.getName());
		}
		infos.put("classes", classes);

		List<String> instances = new ArrayList<>();
		for (Object instance : c.getInstances()) {
			instances.add(instance.getClass().getName());
		}
		infos.put("instances", instances);

		Map<String, String> properties = new HashMap<>();
		for (Entry<String, Object> entry : c.getProperties().entrySet()) {
			properties.put(entry.getKey(), Infos.stringify(entry.getValue()));

		}
		infos.put("properties", properties);

		RuntimeType runtimeType = c.getRuntimeType();
		infos.put("runtimeType", runtimeType);

		return infos;
	}

}
