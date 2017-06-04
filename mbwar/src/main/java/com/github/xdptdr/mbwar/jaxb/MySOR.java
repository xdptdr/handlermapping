package com.github.xdptdr.mbwar.jaxb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.xml.bind.SchemaOutputResolver;
import javax.xml.transform.Result;
import javax.xml.transform.stream.StreamResult;

public class MySOR extends SchemaOutputResolver {

	private PrintWriter writer;

	public MySOR(PrintWriter writer) {
		this.writer = writer;
	}

	@Override
	public Result createOutput(String namespaceUri, String suggestedFileName) throws IOException {
		StreamResult sr = new StreamResult(writer);
		sr.setSystemId("MySOR");
		return sr;
	}

}
