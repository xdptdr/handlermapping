package com.github.xdptdr.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.github.xdptdr.ejb.TimerSingleton;
import com.github.xdptdr.ejb.TimerStateless;

@WebServlet(value = "/timer", loadOnStartup = 1)
public class TimerServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@EJB
	private TimerSingleton timerSingleton;

	@EJB
	private TimerStateless timerStateless;

	@Override
	public void init() throws ServletException {
		timerStateless.createTimer();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doStuff(req, resp);
	}

	private void doStuff(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		PrintWriter pw = resp.getWriter();
		pw.println(timerSingleton.getCounter());
		pw.println(timerStateless.getCounter());
	}
}
