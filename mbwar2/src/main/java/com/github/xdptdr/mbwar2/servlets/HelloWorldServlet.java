package com.github.xdptdr.mbwar2.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/helloworld")
public class HelloWorldServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	// jbossws-cxf-server : org.jboss.wsf.stack.cxf.metadata.MetadataBuilder.createDDEndpoint(Class<?>, ArchiveDeployment, Endpoint)
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getWriter().println("Hello world from mbwar2");
	}
}
