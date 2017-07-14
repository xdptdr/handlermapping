package com.github.xdptdr.cxf;

import java.io.IOException;

import org.apache.cxf.simple.SimpleServiceBuilder;

public class Abagtha {

	public static void main(String[] args) throws IOException {

		SimpleServiceBuilder simpleServiceBuilder = new SimpleServiceBuilder();
		simpleServiceBuilder.setServiceClass(Abagtha.class);
		simpleServiceBuilder.createService();

	}

}
