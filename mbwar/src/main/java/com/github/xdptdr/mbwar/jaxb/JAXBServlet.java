package com.github.xdptdr.mbwar.jaxb;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

@WebServlet("/jaxb")
public class JAXBServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			resp.setContentType("application/xml");
			doStuff(req, resp);
		} catch (JAXBException e) {
			resp.getWriter().println(e.getMessage());
		}
	}

	private void doStuff(HttpServletRequest req, HttpServletResponse resp) throws JAXBException, IOException {

		JAXBContext ctx = JAXBContext.newInstance(MyThingy.class);
		ctx.generateSchema(new MySOR(resp.getWriter()));

	}

}
