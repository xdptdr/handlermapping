package com.github.xdptdr.foo;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.sql.SQLException;
import java.sql.SQLXML;

import javax.xml.transform.Result;
import javax.xml.transform.Source;

public class FooSQLXML implements SQLXML {

	private InputStream fooInputStream = new FooInputStream();
	private OutputStream fooOutputStream = new FooOutputStream();
	private Reader fooReader = new FooReader();
	private Writer fooWriter = new FooWriter();
	private String fooString;
	private Source fooSource = new FooSource();
	private Result fooResult = new FooResult();

	@Override
	public void free() throws SQLException {

	}

	@Override
	public InputStream getBinaryStream() throws SQLException {
		return fooInputStream;
	}

	@Override
	public OutputStream setBinaryStream() throws SQLException {
		return fooOutputStream;
	}

	@Override
	public Reader getCharacterStream() throws SQLException {
		return fooReader;
	}

	@Override
	public Writer setCharacterStream() throws SQLException {
		return fooWriter;
	}

	@Override
	public String getString() throws SQLException {
		return fooString;
	}

	@Override
	public void setString(String value) throws SQLException {

	}

	@Override
	public <T extends Source> T getSource(Class<T> sourceClass) throws SQLException {
		return (T) fooSource;
	}

	@Override
	public <T extends Result> T setResult(Class<T> resultClass) throws SQLException {
		return (T) fooResult;
	}

}
