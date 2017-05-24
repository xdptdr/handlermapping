package com.github.xdptdr.servlet.basic.stateless;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.github.xdptdr.ejb.basic.stateless.MyBasicStateless;
import com.github.xdptdr.ejb.basic.stateless.MyBasicStatelessLocalI;
import com.github.xdptdr.ejb.basic.stateless.MyBasicStatelessRemoteI;

@WebServlet("/testBasicStateless")
public class TestBasicStatelessServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@EJB
	private MyBasicStatelessRemoteI myStatelessRemote;

	@EJB
	private MyBasicStatelessLocalI myStatelessLocal;

	@EJB
	private MyBasicStateless myStateless;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PrintWriter pw = resp.getWriter();

		doStuff(req, resp);
		pw.println("Done.");
	}

	public void doStuff(HttpServletRequest req, HttpServletResponse resp) {

	}

}
