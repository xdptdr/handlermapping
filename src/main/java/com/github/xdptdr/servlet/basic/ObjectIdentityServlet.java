package com.github.xdptdr.servlet.basic;

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

import com.github.xdptdr.ejb.basic.singleton.MyBasicSingleton;
import com.github.xdptdr.ejb.basic.singleton.MyBasicSingletonLocalI;
import com.github.xdptdr.ejb.basic.singleton.MyBasicSingletonRemoteI;
import com.github.xdptdr.ejb.basic.stateful.MyBasicStateful;
import com.github.xdptdr.ejb.basic.stateful.MyBasicStatefulLocalI;
import com.github.xdptdr.ejb.basic.stateful.MyBasicStatefulRemoteI;
import com.github.xdptdr.ejb.basic.stateless.MyBasicStateless;
import com.github.xdptdr.ejb.basic.stateless.MyBasicStatelessLocalI;
import com.github.xdptdr.ejb.basic.stateless.MyBasicStatelessRemoteI;

@WebServlet("/objectIdentity")
public class ObjectIdentityServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			doStuff(req, resp);
		} catch (NamingException e) {
			resp.getWriter().println(e.getMessage());
		}
	}

	private void doStuff(HttpServletRequest req, HttpServletResponse resp) throws NamingException, IOException {

		PrintWriter pw = resp.getWriter();

		Context ctx = new InitialContext();

		pw.println("Round 1");
		exp(pw, ctx);
		pw.println("Round 2");
		exp(pw, ctx);
		pw.println("Round 3");
		exp(pw, ctx);

	}

	private void exp(PrintWriter pw, Context ctx) throws NamingException {

		MyBasicSingleton myBasicSingleton = (MyBasicSingleton) ctx
				.lookup("java:module/MyBasicSingleton!com.github.xdptdr.ejb.basic.singleton.MyBasicSingleton");

		MyBasicSingletonLocalI myBasicSingletonLocalI = (MyBasicSingletonLocalI) ctx
				.lookup("java:module/MyBasicSingleton!com.github.xdptdr.ejb.basic.singleton.MyBasicSingletonLocalI");

		MyBasicSingletonRemoteI myBasicSingletonRemoteI = (MyBasicSingletonRemoteI) ctx
				.lookup("java:module/MyBasicSingleton!com.github.xdptdr.ejb.basic.singleton.MyBasicSingletonRemoteI");

		MyBasicStateful myBasicStateful = (MyBasicStateful) ctx
				.lookup("java:module/MyBasicStateful!com.github.xdptdr.ejb.basic.stateful.MyBasicStateful");

		MyBasicStatefulLocalI myBasicStatefulLocalI = (MyBasicStatefulLocalI) ctx
				.lookup("java:module/MyBasicStateful!com.github.xdptdr.ejb.basic.stateful.MyBasicStatefulLocalI");

		MyBasicStatefulRemoteI myBasicStatefulRemoteI = (MyBasicStatefulRemoteI) ctx
				.lookup("java:module/MyBasicStateful!com.github.xdptdr.ejb.basic.stateful.MyBasicStatefulRemoteI");

		MyBasicStateless myBasicStateless = (MyBasicStateless) ctx
				.lookup("java:module/MyBasicStateless!com.github.xdptdr.ejb.basic.stateless.MyBasicStateless");

		MyBasicStatelessLocalI myBasicStatelessLocalI = (MyBasicStatelessLocalI) ctx
				.lookup("java:module/MyBasicStateless!com.github.xdptdr.ejb.basic.stateless.MyBasicStatelessLocalI");

		MyBasicStatelessRemoteI myBasicStatelessRemoteI = (MyBasicStatelessRemoteI) ctx
				.lookup("java:module/MyBasicStateless!com.github.xdptdr.ejb.basic.stateless.MyBasicStatelessRemoteI");

		pw.println("IncPrint Singleton");
		exp(pw, myBasicSingleton, myBasicSingletonLocalI, myBasicSingletonRemoteI);

		pw.println("IncPrint Stateful");
		exp(pw, myBasicStateful, myBasicStatefulLocalI, myBasicStatefulRemoteI);

		pw.println("IncPrint Stateless");
		exp(pw, myBasicStateless, myBasicStatelessLocalI, myBasicStatelessRemoteI);
	}

	private void exp(PrintWriter pw, MyBasicStateless s, MyBasicStatelessLocalI sl, MyBasicStatelessRemoteI sr) {

		sr.remoteIncrement();

		printAll(pw, s, sl, sr);

		sl.localIncrement();

		printAll(pw, s, sl, sr);

		s.noViewIncrement();

		printAll(pw, s, sl, sr);

	}

	private void printAll(PrintWriter pw, MyBasicStateless s, MyBasicStatelessLocalI sl, MyBasicStatelessRemoteI sr) {
		pw.println(s.getNoViewCounter());
		pw.println(sl.getLocalCounter());
		pw.println(sr.getRemoteCounter());
		pw.println("---");
	}

	private void exp(PrintWriter pw, MyBasicStateful s, MyBasicStatefulLocalI sl, MyBasicStatefulRemoteI sr) {
		sr.remoteIncrement();

		printAll(pw, s, sl, sr);

		sl.localIncrement();

		printAll(pw, s, sl, sr);

		s.noViewIncrement();

		printAll(pw, s, sl, sr);
	}

	private void printAll(PrintWriter pw, MyBasicStateful s, MyBasicStatefulLocalI sl, MyBasicStatefulRemoteI sr) {
		pw.println(s.getNoViewCounter());
		pw.println(sl.getLocalCounter());
		pw.println(sr.getRemoteCounter());
		pw.println("---");

	}

	private void exp(PrintWriter pw, MyBasicSingleton s, MyBasicSingletonLocalI sl, MyBasicSingletonRemoteI sr) {
		sr.remoteIncrement();

		printAll(pw, s, sl, sr);

		sl.localIncrement();

		printAll(pw, s, sl, sr);

		s.noViewIncrement();

		printAll(pw, s, sl, sr);
	}

	private void printAll(PrintWriter pw, MyBasicSingleton s, MyBasicSingletonLocalI sl, MyBasicSingletonRemoteI sr) {
		pw.println(s.getNoViewCounter());
		pw.println(sl.getLocalCounter());
		pw.println(sr.getRemoteCounter());
		pw.println("---");

	}
}
