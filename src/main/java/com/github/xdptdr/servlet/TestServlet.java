package com.github.xdptdr.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.resource.ResourceException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.github.xdptdr.ejb.MyStateless;

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

		Context ctx = new InitialContext();
		MyStateless ms = (MyStateless) ctx.lookup("java:module/MyStateless");
		resp.getWriter().println(ms.choupinette("choupine"));

	}

}
