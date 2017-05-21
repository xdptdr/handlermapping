package com.github.xdptdr.jca;

import java.io.IOException;
import java.io.PrintWriter;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.resource.ResourceException;
import javax.resource.cci.Connection;
import javax.resource.cci.ConnectionFactory;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/test")
public class TestServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PrintWriter pw = resp.getWriter();

		try {
			doStuff(req, resp);
			pw.println("Done.");
		} catch (NamingException | ResourceException e) {
			e.printStackTrace(pw);
		}
	}

	public void doStuff(HttpServletRequest req, HttpServletResponse resp)
			throws NamingException, IOException, ResourceException {

		Context context = new InitialContext();
		ConnectionFactory mcf = (ConnectionFactory) context.lookup("java:/eis/MyEIS");

		Connection c1 = mcf.getConnection();
		Connection c2 = mcf.getConnection();

		resp.getWriter().println(c1 == c2 ? "connections are identical" : "connections are not identical");

		resp.getWriter().println(c1.getMetaData().getEISProductName());
		resp.getWriter().println(c1.getMetaData().getEISProductVersion());

		c1.close();
	}

}
