package com.github.xdptdr.servlet.basic.stateful;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.github.xdptdr.ejb.basic.stateful.MyBasicStateful;
import com.github.xdptdr.ejb.basic.stateful.MyBasicStatefulLocalI;
import com.github.xdptdr.ejb.basic.stateful.MyBasicStatefulRemoteI;

@WebServlet("/testBasicStateful")
public class TestBasicStatefulServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@EJB
	private MyBasicStatefulRemoteI myStatefulRemote;

	@EJB
	private MyBasicStatefulLocalI myStatefulLocal;

	@EJB
	private MyBasicStateful myStateful;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PrintWriter pw = resp.getWriter();

		doStuff(req, resp);
		pw.println("Done.");
	}

	public void doStuff(HttpServletRequest req, HttpServletResponse resp) {

	}

}
