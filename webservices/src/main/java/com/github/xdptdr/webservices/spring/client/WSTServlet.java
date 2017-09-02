package com.github.xdptdr.webservices.spring.client;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.StringReader;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.TransformerException;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.springframework.oxm.Marshaller;
import org.springframework.oxm.Unmarshaller;
import org.springframework.ws.WebServiceMessage;
import org.springframework.ws.WebServiceMessageFactory;
import org.springframework.ws.client.core.FaultMessageResolver;
import org.springframework.ws.client.core.SourceExtractor;
import org.springframework.ws.client.core.WebServiceMessageCallback;
import org.springframework.ws.client.core.WebServiceMessageExtractor;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.client.support.destination.DestinationProvider;
import org.springframework.ws.client.support.interceptor.ClientInterceptor;
import org.springframework.ws.soap.saaj.SaajAttachmentException;
import org.springframework.ws.soap.saaj.SaajSoapBodyException;
import org.springframework.ws.soap.saaj.SaajSoapElementException;
import org.springframework.ws.soap.saaj.SaajSoapEnvelopeException;
import org.springframework.ws.soap.saaj.SaajSoapFaultException;
import org.springframework.ws.soap.saaj.SaajSoapHeaderException;
import org.springframework.ws.soap.saaj.SaajSoapMessage;
import org.springframework.ws.soap.saaj.SaajSoapMessageCreationException;
import org.springframework.ws.soap.saaj.SaajSoapMessageException;
import org.springframework.ws.soap.saaj.SaajSoapMessageFactory;

@WebServlet("/spring/wst")
public class WSTServlet extends HttpServlet {

	public static class RequestCallback implements WebServiceMessageCallback {

		private HttpServletResponse resp;

		public RequestCallback(HttpServletResponse resp) {
			this.resp = resp;
		}

		@Override
		public void doWithMessage(WebServiceMessage message) throws IOException, TransformerException {

			if (message instanceof SaajSoapMessage) {
				SaajSoapMessage m = (SaajSoapMessage) message;
				
				
			}
			// String message = "<?xml version=\"1.0\"?><say
			// xmlns=\"http://ws.webservices.xdptdr.github.com/\"/>";
		}

	}

	public static class ResponseCallback implements WebServiceMessageCallback {

		private HttpServletResponse resp;

		public ResponseCallback(HttpServletResponse resp) {
			this.resp = resp;
		}

		@Override
		public void doWithMessage(WebServiceMessage message) throws IOException, TransformerException {
			resp.getWriter().println("Request");
			resp.getWriter().println(tos(message));
			resp.getWriter().println(message.getClass().getName());
		}

	}

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doStuff(req, resp);
	}

	private void doStuff(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		foo2(req, resp);
	}

	public void foo1(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		try {
			WebServiceTemplate wst = new WebServiceTemplate();
			wst.setDefaultUri("http://localhost:8080/webservices/HelloService");
			String message = "<?xml version=\"1.0\"?><say xmlns=\"http://ws.webservices.xdptdr.github.com/\"/>";
			final ByteArrayOutputStream baos = new ByteArrayOutputStream();
			wst.sendSourceAndReceiveToResult(new StreamSource(new StringReader(message)), new StreamResult(baos));
			resp.getWriter().println(baos.toString());
		} catch (Exception ex) {
			resp.getWriter().print(ex.getClass().getName() + " : " + ex.getMessage());
		}
	}

	public void foo2(HttpServletRequest req, HttpServletResponse resp) throws IOException {

		resp.setContentType("text/plain");
		try {
			WebServiceTemplate wst = new WebServiceTemplate();
			wst.setDefaultUri("http://localhost:8080/webservices/HelloService");

			WebServiceMessageCallback webServiceMessageCallbackRequest = new RequestCallback(resp);
			WebServiceMessageCallback webServiceMessageCallbackResponse = new ResponseCallback(resp);
			wst.sendAndReceive(webServiceMessageCallbackRequest, webServiceMessageCallbackResponse);
		} catch (Exception ex) {
			resp.getWriter().print(ex.getClass().getName() + " : " + ex.getMessage());
		}
	}

	private static String tos(Object o) {
		if (o == null) {
			return "n$";
		} else {
			return "c$" + o.getClass().getName();
		}
	}

	public void foo9() {

		String uri = null;
		String defaultUri = null;
		DestinationProvider destinationProvider = null;
		FaultMessageResolver faultMessageResolver = null;
		ClientInterceptor[] interceptors = null;

		Marshaller marshaller = null;
		Unmarshaller unmarshaller = null;
		WebServiceMessageFactory webServiceMessageFactory = null;

		Object requestPayload = null;
		WebServiceMessageCallback webServiceMessageCallbackRequest = null;
		WebServiceMessageCallback webServiceMessageCallbackResponse = null;

		WebServiceMessageExtractor<Object> webServiceMessageExtractor = null;

		Source source = null;
		SourceExtractor<Object> sourceExtractor = null;
		Result responseResult = null;

		boolean checkConnectionForError = false;
		boolean checkConnectionForFault = false;

		WebServiceTemplate wst = new WebServiceTemplate();
		wst = new WebServiceTemplate(marshaller);
		wst = new WebServiceTemplate(marshaller, unmarshaller);
		wst = new WebServiceTemplate(webServiceMessageFactory);

		defaultUri = wst.getDefaultUri();
		destinationProvider = wst.getDestinationProvider();
		faultMessageResolver = wst.getFaultMessageResolver();
		interceptors = wst.getInterceptors();
		marshaller = wst.getMarshaller();
		unmarshaller = wst.getUnmarshaller();

		wst.marshalSendAndReceive(requestPayload);
		wst.marshalSendAndReceive(requestPayload, webServiceMessageCallbackResponse);
		wst.marshalSendAndReceive(uri, requestPayload);
		wst.marshalSendAndReceive(uri, requestPayload, webServiceMessageCallbackResponse);

		wst.sendAndReceive(webServiceMessageCallbackRequest, webServiceMessageCallbackResponse);
		wst.sendAndReceive(webServiceMessageCallbackRequest, webServiceMessageExtractor);
		wst.sendAndReceive(uri, webServiceMessageCallbackRequest, webServiceMessageCallbackResponse);
		wst.sendAndReceive(uri, webServiceMessageCallbackRequest, webServiceMessageExtractor);

		wst.sendSourceAndReceive(source, sourceExtractor);
		wst.sendSourceAndReceive(source, webServiceMessageCallbackRequest, sourceExtractor);
		wst.sendSourceAndReceive(uri, source, sourceExtractor);
		wst.sendSourceAndReceive(uri, source, webServiceMessageCallbackRequest, sourceExtractor);

		wst.sendSourceAndReceiveToResult(source, responseResult);
		wst.sendSourceAndReceiveToResult(source, webServiceMessageCallbackRequest, responseResult);
		wst.sendSourceAndReceiveToResult(uri, source, responseResult);
		wst.sendSourceAndReceiveToResult(uri, source, webServiceMessageCallbackRequest, responseResult);

		wst.setCheckConnectionForError(checkConnectionForError);
		wst.setCheckConnectionForFault(checkConnectionForFault);

		wst.setDefaultUri(defaultUri);

		wst.setDestinationProvider(destinationProvider);
		wst.setFaultMessageResolver(faultMessageResolver);
		wst.setInterceptors(interceptors);
		wst.setMarshaller(marshaller);
		wst.setUnmarshaller(unmarshaller);
	}

	public void foo() {

		Class<?>[] classes = null;

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

		classes = new Class<?>[] { SaajAttachmentException.class, SaajSoapBodyException.class,
				SaajSoapElementException.class, SaajSoapEnvelopeException.class, SaajSoapFaultException.class,
				SaajSoapHeaderException.class, SaajSoapMessage.class, SaajSoapMessageCreationException.class,
				SaajSoapMessageException.class, SaajSoapMessageFactory.class };

	}
}
