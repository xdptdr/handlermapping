package com.github.xdptdr.mbwar.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.stream.XMLEventFactory;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.events.EndDocument;
import javax.xml.stream.events.StartDocument;

public class StaxServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (req == null) {
			doStuff(req, resp);
		}
	}

	private void doStuff(HttpServletRequest req, HttpServletResponse resp) {

		XMLEventFactory xmlEventFactory = XMLEventFactory.newFactory();
		XMLInputFactory xmlInputFactory = XMLInputFactory.newFactory();
		XMLOutputFactory xmlOutputFactory = XMLOutputFactory.newFactory();

		StartDocument sd = xmlEventFactory.createStartDocument();
		EndDocument ed = xmlEventFactory.createEndDocument();

	}
}
