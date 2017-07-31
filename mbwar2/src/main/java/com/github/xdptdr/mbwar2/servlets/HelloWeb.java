package com.github.xdptdr.mbwar2.servlets;

import javax.jws.WebService;

@WebService
public class HelloWeb {
	public String hello(String name) {
		return "Hello " + name + " ! Welcome to " + this.getClass().getName();
	}
}
