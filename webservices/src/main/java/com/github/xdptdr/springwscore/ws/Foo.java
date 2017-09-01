package com.github.xdptdr.springwscore.ws;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.StringReader;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.springframework.ws.client.core.WebServiceTemplate;

@WebServlet("/springwscore/ws")
public class Foo extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doStuff(req, resp);
	}

	private void doStuff(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		WebServiceTemplate wst = new WebServiceTemplate();
		wst.setDefaultUri("http://localhost:8080/webservices/HelloService");
		String message = "foo";
		final ByteArrayOutputStream baos = new ByteArrayOutputStream();
		wst.sendSourceAndReceiveToResult(new StreamSource(new StringReader(message)), new StreamResult(baos));
		resp.getWriter().println(baos.toString());
	}

	public void foo() {
		// Class<?>[] classes = new Class<?>[] {
		// FaultAwareWebServiceMessage.class, InvalidXmlException.class,
		// NoEndpointFoundException.class, WebServiceException.class,
		// WebServiceMessage.class,
		// WebServiceMessageException.class, WebServiceMessageFactory.class };
		//
		// classes = new Class<?>[] { WebServiceClientException.class,
		// WebServiceFaultException.class,
		// WebServiceIOException.class, WebServiceTransformerException.class,
		// WebServiceTransportException.class };
		//
		// classes = new Class<?>[] { FaultMessageResolver.class,
		// SimpleFaultMessageResolver.class, SourceExtractor.class,
		// WebServiceMessageCallback.class, WebServiceMessageExtractor.class,
		// WebServiceOperations.class,
		// WebServiceTemplate.class };

	}
}
