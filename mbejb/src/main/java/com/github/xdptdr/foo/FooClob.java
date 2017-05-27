package com.github.xdptdr.foo;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.sql.Clob;
import java.sql.SQLException;

public class FooClob implements Clob {

	private long fooLength;
	private String fooSubstring;
	private Reader fooReader = new FooReader();
	private InputStream fooInputStream = new FooInputStream();
	private long fooPosition;
	private int fooSetString;
	private OutputStream fooOutputStream = new FooOutputStream();
	private Writer fooWriter = new FooWriter();

	@Override
	public long length() throws SQLException {
		return fooLength;
	}

	@Override
	public String getSubString(long pos, int length) throws SQLException {
		return fooSubstring;
	}

	@Override
	public Reader getCharacterStream() throws SQLException {
		return fooReader;
	}

	@Override
	public InputStream getAsciiStream() throws SQLException {
		return fooInputStream;
	}

	@Override
	public long position(String searchstr, long start) throws SQLException {
		return fooPosition;
	}

	@Override
	public long position(Clob searchstr, long start) throws SQLException {
		return fooPosition;
	}

	@Override
	public int setString(long pos, String str) throws SQLException {
		return fooSetString;
	}

	@Override
	public int setString(long pos, String str, int offset, int len) throws SQLException {
		return fooSetString;
	}

	@Override
	public OutputStream setAsciiStream(long pos) throws SQLException {
		return fooOutputStream;
	}

	@Override
	public Writer setCharacterStream(long pos) throws SQLException {
		return fooWriter;
	}

	@Override
	public void truncate(long len) throws SQLException {

	}

	@Override
	public void free() throws SQLException {

	}

	@Override
	public Reader getCharacterStream(long pos, long length) throws SQLException {
		return fooReader;
	}

}
