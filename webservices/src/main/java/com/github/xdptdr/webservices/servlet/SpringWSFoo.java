package com.github.xdptdr.webservices.servlet;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Properties;

import javax.mail.internet.AddressException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;

import org.springframework.ws.WebServiceMessage;
import org.springframework.ws.soap.saaj.SaajSoapMessage;
import org.springframework.ws.transport.WebServiceConnection;
import org.springframework.ws.transport.http.HttpComponentsConnection;
import org.springframework.ws.transport.http.HttpComponentsMessageSender;
import org.springframework.ws.transport.mail.MailMessageSender;

@WebServlet("/swf")
public class SpringWSFoo extends HttpServlet {

	public static enum WHICH {
		HELLO, HCC, FOO
	}

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			doStuff(req, resp);
		} catch (URISyntaxException | AddressException | SOAPException e) {
			resp.getWriter().println(e.getClass().getName() + " : " + e.getMessage());
		}
	}

	private void doStuff(HttpServletRequest req, HttpServletResponse resp) throws IOException, URISyntaxException, AddressException, SOAPException {
		switch (WHICH.valueOf(req.getParameter("which"))) {
		case HELLO:
			hello(req, resp);
			break;
		case HCC:
			hcc(req, resp);
			break;
		case FOO:
			foo(req, resp);
			break;
		}

	}

	private void foo(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, AddressException, URISyntaxException, SOAPException {

		final String from = System.getProperty("from");
		final String imap = System.getProperty("imap");
		final String smtp = System.getProperty("smtp");
		final String to = System.getProperty("to");
		final String subject = System.getProperty("subject");

		Properties props = new Properties();
		props.setProperty("mail.smtp.starttls.enable", "true");
		MailMessageSender mms = new MailMessageSender();
		mms.setFrom(from);
		mms.setStoreUri(imap);
		mms.setTransportUri(smtp);
		mms.setJavaMailProperties(props);
		WebServiceConnection conn = mms.createConnection(new URI(to + "?subject=" + subject));

		resp.getWriter().println(conn.getClass().getName());
		resp.getWriter().println(from);
		resp.getWriter().println(imap);
		resp.getWriter().println(smtp);
		resp.getWriter().println(to);
		resp.getWriter().println(subject);

		SOAPMessage soapMessage = MessageFactory.newInstance().createMessage();
//		soapMessage.getSOAPHeader().addNotUnderstoodHeaderElement(new QName("foo", "bar"));
		WebServiceMessage message = new SaajSoapMessage(soapMessage);
		conn.send(message);
		conn.close();
		// long receiveSleepTime = 0;
		// mms.setReceiveSleepTime(receiveSleepTime);

		// Session session = null;
		// mms.setSession(session);

		// mms.supports(uri);

		// MailMessageReceiver mmr = new MailMessageReceiver();
		// MailMessageSender mms = new MailMessageSender();
		// // MailReceiverConnection mrc = new MailReceiverConnection();
		// // MailSenderConnection msc = new MailSenderConnection();
		// MailTransportConstants.class.getName();
		// MailTransportException.class.getName();
	}

	private void hcc(HttpServletRequest req, HttpServletResponse resp) throws URISyntaxException, IOException {
		HttpComponentsMessageSender cms = new HttpComponentsMessageSender();

		URI uri = new URI("mailto:xavierdpt@gmail.com");
		WebServiceConnection con = cms.createConnection(uri);
		azzert(con instanceof HttpComponentsConnection);
		resp.getWriter().println(con.getClass().getName());

		// HttpClient httpClient = cms.getHttpClient();
		// cms.setHttpClient(httpClient);

		// AuthScope authScope = null;
		// cms.setAuthScope(authScope);

		// Credentials credentials = null;
		// cms.setCredentials(credentials);

		// Map<String, String> maxConnectionsPerHost = null;
		// cms.setMaxConnectionsPerHost(maxConnectionsPerHost);

		// int maxTotalConnections = 0;
		// cms.setMaxTotalConnections(maxTotalConnections);

		// int timeout = 0;
		// cms.setConnectionTimeout(timeout);
		// cms.setReadTimeout(timeout);

	}

	private void hello(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.getWriter().println("Hello from Spring WS Foo");
	}

	private void azzert(boolean b) {
		if (!b) {
			throw new RuntimeException("Assertion error");
		}
	}
}
