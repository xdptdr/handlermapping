package com.github.xdptdr.jca;

import java.io.IOException;
import java.io.PrintWriter;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.resource.ResourceException;
import javax.resource.cci.Connection;
import javax.resource.cci.ConnectionFactory;
import javax.resource.cci.Interaction;
import javax.resource.cci.InteractionSpec;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/connectionHandle")
public class ConnectionHandleServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public static enum What {
		GET_CONNECTION_1, GET_CONNECTION_2, CLOSE_CONNECTION_1, CLOSE_CONNECTION_2, CREATE_INTERACTION_1, CREATE_INTERACTION_2

	}

	private Connection connection1;
	private Connection connection2;
	private Interaction interaction1;
	private Interaction interaction2;;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			doStuff(req, resp);
		} catch (NamingException | ResourceException e) {
			throw new ServletException(e);
		}
	}

	private void doStuff(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, NamingException, ResourceException {
		PrintWriter pw = resp.getWriter();

		Context context = new InitialContext();
		ConnectionFactory mcf = (ConnectionFactory) context.lookup("java:/eis/MyEIS");

		switch (What.valueOf(req.getParameter("what"))) {
		case GET_CONNECTION_1:
			connection1 = mcf.getConnection();
			break;
		case GET_CONNECTION_2:
			connection2 = mcf.getConnection();
			break;
		case CREATE_INTERACTION_1:
			interaction1 = connection1.createInteraction();
			break;
		case CREATE_INTERACTION_2:
			interaction2 = connection1.createInteraction();
			break;
		case CLOSE_CONNECTION_1:
			connection1.close();
			break;
		case CLOSE_CONNECTION_2:
			connection2.close();
			break;
		}
	}

}
