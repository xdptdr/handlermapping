package com.github.xdptdr.foo;

import java.sql.SQLException;
import java.sql.Struct;
import java.util.Map;

public class FooStruct implements Struct {

	private Object[] fooAttributes;
	private String fooSQLTypeName;

	@Override
	public String getSQLTypeName() throws SQLException {
		return fooSQLTypeName;
	}

	@Override
	public Object[] getAttributes() throws SQLException {
		return fooAttributes;
	}

	@Override
	public Object[] getAttributes(Map<String, Class<?>> map) throws SQLException {
		return fooAttributes;
	}

}
