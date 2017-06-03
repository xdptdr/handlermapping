package com.github.xdptdr.mbwar.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/JPAServlet")
public class JPAServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@EJB
	private JPABeanI mb;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			mb.create();
			for (MyEntity entity : mb.getAll()) {
				resp.getWriter().println(entity.toString());
			}
		} catch (Exception ex) {
			log(ex);
		}
	}

	private void log(Exception ex) {
	}
}
