package com.github.xdptdr.jca;

import java.io.IOException;
import java.io.PrintWriter;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/jcaservlet")
public class JCAServlet extends HttpServlet {
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

	public void doStuff(HttpServletRequest req, HttpServletResponse resp) throws NamingException {
		Context context = new InitialContext();
		Object lookedUp = context.lookup("java:comp/env/eis/MyEIS");
	}
}
