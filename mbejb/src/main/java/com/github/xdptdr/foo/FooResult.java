package com.github.xdptdr.foo;

import javax.xml.transform.Result;

public class FooResult implements Result {

	private String fooSystemId;

	@Override
	public void setSystemId(String systemId) {

	}

	@Override
	public String getSystemId() {
		return fooSystemId;
	}

}
