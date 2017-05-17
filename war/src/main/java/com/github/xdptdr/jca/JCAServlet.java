package com.github.xdptdr.jca;

import java.io.IOException;
import java.io.PrintWriter;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.resource.spi.ManagedConnectionFactory;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/jcaservlet")
public class JCAServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PrintWriter pw = resp.getWriter();

		try {
			doStuff(req, resp);
			pw.println("Done.");
		} catch (NamingException e) {
			e.printStackTrace(pw);
		}
	}

	public void doStuff(HttpServletRequest req, HttpServletResponse resp) throws NamingException, IOException {
		Context context = new InitialContext();
		Object mcf =  context.lookup("java:/TransactionManager");
		if (mcf != null) {
			resp.getWriter().println(mcf.getClass().getName());
		} else {
			resp.getWriter().println("mcf is null");
		}
	}
}
