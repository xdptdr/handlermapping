package com.github.xdptdr.mbwar.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.github.xdptdr.mbejb.api.MainI;

@WebServlet(value = "/main", loadOnStartup = 1)
public class MainServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@EJB
	private MainI mb;

	@Override
	public void init() throws ServletException {
		mb.register("main");
	}

	@Override
	public void destroy() {
		mb.unregister("main");
	}

	@Override
	protected void doGet(HttpServletRequest q, HttpServletResponse r) throws ServletException, IOException {
		doStuff(q, r);
	}

	private void doStuff(HttpServletRequest q, HttpServletResponse r) throws IOException {
		r.getWriter().println(mb.mapToString());
	}
}
