package com.github.xdptdr.foo;

import javax.xml.transform.Source;

public class FooSource implements Source {

	private String fooSystemId;

	@Override
	public void setSystemId(String systemId) {

	}

	@Override
	public String getSystemId() {
		return fooSystemId;
	}

}
