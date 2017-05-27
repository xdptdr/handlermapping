package com.github.xdptdr.foo;

import java.io.IOException;
import java.io.Reader;

public class FooReader extends Reader {

	private int fooRead;

	@Override
	public int read(char[] cbuf, int off, int len) throws IOException {
		return fooRead;
	}

	@Override
	public void close() throws IOException {

	}

}
