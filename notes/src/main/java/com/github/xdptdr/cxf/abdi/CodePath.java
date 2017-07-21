package com.github.xdptdr.cxf.abdi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CodePath {

	Map<String, Object> p = new HashMap<>();

	public CodePath() {
	}

	public CodePath s(String id, Object b) {
		p.put(id, b);
		return this;
	}

	public boolean t(String id) {
		return Boolean.TRUE.equals(p.get(id));
	}

	@SuppressWarnings("unchecked")
	public <T> T g(String id, Class<T> clazz) {
		return (T) p.get(id);
	}

	@SuppressWarnings("unchecked")
	public <T> List<T> l(String id, Class<T> class1) {
		return (List<T>) p.get(id);
	}

}
