package com.github.xdptdr.servlet.basic.singleton;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.github.xdptdr.ejb.basic.singleton.MyBasicSingleton;
import com.github.xdptdr.ejb.basic.singleton.MyBasicSingletonLocalI;
import com.github.xdptdr.ejb.basic.singleton.MyBasicSingletonRemoteI;

@WebServlet("/testBasicSingleton")
public class TestBasicSingletonServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@EJB
	private MyBasicSingletonRemoteI mySingletonRemote;

	@EJB
	private MyBasicSingletonLocalI mySingletonLocal;

	@EJB
	private MyBasicSingleton mySingleton;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PrintWriter pw = resp.getWriter();

		doStuff(req, resp);
		pw.println("Done.");
	}

	public void doStuff(HttpServletRequest req, HttpServletResponse resp) {

	}

}
