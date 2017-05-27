package com.github.xdptdr.foo;

import java.io.IOException;
import java.io.InputStream;

public class FooInputStream extends InputStream {

	private int fooRead;

	@Override
	public int read() throws IOException {
		return fooRead;
	}

}
