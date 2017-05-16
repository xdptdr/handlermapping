package com.github.xdptdr.jca;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

import javax.resource.cci.MappedRecord;

public class MyMappedRecord extends MyRecord implements MappedRecord {

	private static final long serialVersionUID = 1L;

	@Override
	public boolean isEmpty() {
		return false;
	}

	@Override
	public boolean containsKey(Object key) {
		return false;
	}

	@Override
	public boolean containsValue(Object value) {
		return false;
	}

	@Override
	public Object get(Object key) {
		return null;
	}

	@Override
	public Object put(Object key, Object value) {
		return null;
	}

	@Override
	public Object remove(Object key) {
		return null;
	}

	@Override
	public void putAll(@SuppressWarnings("rawtypes") Map m) {

	}

	@Override
	public void clear() {

	}

	@SuppressWarnings("rawtypes")
	@Override
	public Set keySet() {
		return null;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Collection values() {
		return null;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Set entrySet() {
		return null;
	}

	@Override
	public int size() {
		return 0;
	}

}
