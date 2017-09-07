package com.github.xdptdr.webservices;

import com.github.xdptdr.webservices.i.Hello;

public class HelloImpl implements Hello {
	public String say() {
		return "Hello from "+this.getClass().getName();
	}
}
