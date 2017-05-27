package com.github.xdptdr.foo;

import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.SQLException;

public class FooBlob implements Blob {

	private long fooLength;
	private byte[] fooBytes;
	private InputStream fooInputStream;
	private long fooPosition;
	private int fooSetBytes;
	private OutputStream fooOutputStream;

	@Override
	public long length() throws SQLException {
		return fooLength;
	}

	@Override
	public byte[] getBytes(long pos, int length) throws SQLException {
		return fooBytes;
	}

	@Override
	public InputStream getBinaryStream() throws SQLException {
		return fooInputStream;
	}

	@Override
	public long position(byte[] pattern, long start) throws SQLException {
		return fooPosition;
	}

	@Override
	public long position(Blob pattern, long start) throws SQLException {
		return fooPosition;
	}

	@Override
	public int setBytes(long pos, byte[] bytes) throws SQLException {
		return fooSetBytes;
	}

	@Override
	public int setBytes(long pos, byte[] bytes, int offset, int len) throws SQLException {
		return fooSetBytes;
	}

	@Override
	public OutputStream setBinaryStream(long pos) throws SQLException {
		return fooOutputStream;
	}

	@Override
	public void truncate(long len) throws SQLException {

	}

	@Override
	public void free() throws SQLException {

	}

	@Override
	public InputStream getBinaryStream(long pos, long length) throws SQLException {
		return fooInputStream;
	}

}
