package com.github.xdptdr.jaxws.clients;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.Executor;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.xml.bind.JAXBContext;
import javax.xml.namespace.QName;
import javax.xml.soap.SOAPMessage;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.ws.EndpointReference;
import javax.xml.ws.LogicalMessage;
import javax.xml.ws.RespectBindingFeature;
import javax.xml.ws.Service;
import javax.xml.ws.Service.Mode;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.handler.Handler;
import javax.xml.ws.handler.HandlerResolver;
import javax.xml.ws.handler.LogicalHandler;
import javax.xml.ws.handler.LogicalMessageContext;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.MessageContext.Scope;
import javax.xml.ws.handler.PortInfo;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;
import javax.xml.ws.soap.AddressingFeature;
import javax.xml.ws.soap.MTOMFeature;
import javax.xml.ws.wsaddressing.W3CEndpointReference;

import com.github.xdptdr.jaxws.ammit.AmmitSEI;
import com.github.xdptdr.utils.CLI;

public class AmmitCLI {

	private static final String AMMIT_SERVICE_NAME = "AmmitService";
	private static final String AMMIT_NAMESPACE = "http://ammit.jaxws.xdptdr.github.com/";
	private static final String AMMIT_WSDL = "http://localhost:8080/mbwar/Ammit?wsdl";
	private static AmmitSEI p;

	public static void main(String[] args) {

		Client client = ClientBuilder.newClient();

		Scanner command = new Scanner(System.in);

		System.out.println("Enter command:");

		boolean running = true;

		while (running) {
			String line = command.nextLine();
			Response response = null;
			try {
				args = line.split(" ");

				if (CLI.match("quit", args, 0)) {
					System.out.println("Done.");
					running = false;
				} else if (CLI.match("hello", args, 0)) {
					AmmitSEI p = getPort();
					System.out.println(p.hello());

				} else if (CLI.match("wsdl", args, 0)) {
					response = client.target(AMMIT_WSDL).request().get();
				}
				if (response != null) {
					System.out.println(Status.fromStatusCode(response.getStatus()));
					System.out.println(response.getMediaType());
					MultivaluedMap<String, String> headers = response.getStringHeaders();
					for (Entry<String, List<String>> header : headers.entrySet()) {
						for (String value : header.getValue()) {
							System.out.println(header.getKey() + " = " + value);
						}
					}
					if (response.hasEntity()) {
						System.out.println(response.readEntity(String.class));
					}
				}
			} catch (Exception ex) {
				System.out.println(ex.getClass().getName());
				System.out.println(ex.getMessage());
			}

		}

		command.close();

	}

	private static AmmitSEI getPort() throws MalformedURLException {
		if (p == null) {
			URL l = new URL(AMMIT_WSDL);
			QName qs = new QName(AMMIT_NAMESPACE, AMMIT_SERVICE_NAME);
			Service s = Service.create(l, qs);
			p = s.getPort(AmmitSEI.class);
		}
		return p;
	}

	public void foo() {
		QName qName = null;

		Service service = null;
		WebServiceFeature webServiceFeature = null;
		Class<?>[] features = new Class<?>[] { AddressingFeature.class, MTOMFeature.class,
				RespectBindingFeature.class, };
		URL url = null;
		String bindingId = null;
		String endpointAddress = null;
		Class<?> clazz = null;
		Mode mode = Mode.MESSAGE;
		mode = Mode.PAYLOAD;
		JAXBContext jaxbContext = null;
		EndpointReference endpointReference = null;
		Executor executor = null;
		HandlerResolver handlerResolver = null;
		W3CEndpointReference w3cEndpointReference = null;
		Result result = null;
		Source a = null;
		String systemId = null;

		service = Service.create(qName);
		service = Service.create(qName, webServiceFeature);
		service = Service.create(url, qName);
		service = Service.create(url, qName, webServiceFeature);

		service.addPort(qName, bindingId, endpointAddress);

		service.createDispatch(qName, clazz, mode);
		service.createDispatch(qName, clazz, mode, webServiceFeature);
		service.createDispatch(qName, jaxbContext, mode);
		service.createDispatch(qName, jaxbContext, mode, webServiceFeature);
		service.createDispatch(endpointReference, clazz, mode, webServiceFeature);
		service.createDispatch(endpointReference, jaxbContext, mode, webServiceFeature);

		executor = service.getExecutor();

		handlerResolver = service.getHandlerResolver();

		service.getPort(clazz);
		service.getPort(clazz, webServiceFeature);
		service.getPort(qName, clazz);
		service.getPort(qName, clazz, webServiceFeature);
		service.getPort(endpointReference, clazz, webServiceFeature);

		service.getPorts();

		service.getServiceName();

		service.getWSDLDocumentLocation();
		;

		service.setExecutor(executor);

		service.setHandlerResolver(handlerResolver);

		Object object = endpointReference.getPort(clazz, webServiceFeature);
		endpointReference.toString();

		endpointReference.readFrom(a);
		endpointReference.writeTo(result);

		if (endpointReference instanceof W3CEndpointReference) {
			w3cEndpointReference = (W3CEndpointReference) endpointReference;
		}

		systemId = a.getSystemId();
		a.setSystemId(systemId);

		systemId = result.getSystemId();
		result.setSystemId(systemId);

		handlerResolver = new HandlerResolver() {
			@Override
			public List<Handler> getHandlerChain(PortInfo portInfo) {

				String bindingId = null;
				QName qName = null;

				bindingId = portInfo.getBindingID();
				qName = portInfo.getPortName();
				qName = portInfo.getServiceName();

				List<Handler> list = new ArrayList<>();

				Handler handler = new Handler<MessageContext>() {

					@Override
					public boolean handleMessage(MessageContext context) {
						String name = null;
						Scope scope = Scope.APPLICATION;
						scope = Scope.HANDLER;

						context.getScope(name);
						context.setScope(name, scope);
						return false;
					}

					@Override
					public boolean handleFault(MessageContext context) {
						return false;
					}

					@Override
					public void close(MessageContext context) {
					}

				};

				Class<?>[] handlerClasses = new Class<?>[] { LogicalHandler.class, SOAPHandler.class };

				handler = new LogicalHandler<LogicalMessageContext>() {

					@Override
					public boolean handleMessage(LogicalMessageContext context) {
						LogicalMessage message = context.getMessage();
						Source z = message.getPayload();
						Object o = message.getPayload(jaxbContext);
						message.setPayload(z);
						message.setPayload(o, jaxbContext);
						return false;
					}

					@Override
					public boolean handleFault(LogicalMessageContext context) {
						return false;
					}

					@Override
					public void close(MessageContext context) {
					}
				};

				handler = new SOAPHandler<SOAPMessageContext>() {

					@Override
					public boolean handleMessage(SOAPMessageContext context) {
						boolean b = false;
						QName qName = null;
						context.getHeaders(qName, jaxbContext, b);
						SOAPMessage message = context.getMessage();
						Set<String> roles = context.getRoles();
						context.setMessage(message);
						
						return false;
					}

					@Override
					public boolean handleFault(SOAPMessageContext context) {
						return false;
					}

					@Override
					public void close(MessageContext context) {

					}

					@Override
					public Set<QName> getHeaders() {
						return null;
					}
				};

				list.add(handler);

				return list;
			}
		};
	}

}
