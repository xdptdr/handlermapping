package com.github.xdptdr.jaxws.clients.amheh;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Scanner;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.handler.Handler;
import javax.xml.ws.handler.HandlerResolver;
import javax.xml.ws.handler.PortInfo;

import com.github.xdptdr.jaxws.amheh.AmhehSEI;
import com.github.xdptdr.utils.CLI;

public class AmhehCLI {

	public static enum Kind {
		SERVICE_NAME, WSDL
	}

	private static final String AMHEH_NAMESPACE = "http://amheh.jaxws.xdptdr.github.com/";

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
					AmhehSEI p = getPort();
					System.out.println(p.hello());

				} else if (CLI.match("w", args, 0)) {
					String wsdl = foo(Kind.WSDL);
					response = client.target(wsdl).request().get();
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

	private static AmhehSEI getPort() throws MalformedURLException {
		String serviceName = foo(Kind.SERVICE_NAME);
		URL l = new URL(foo(Kind.WSDL));
		QName qs = new QName(AMHEH_NAMESPACE, serviceName);
		Service s = Service.create(l, qs);
		HandlerResolver handlerResolver = new HandlerResolver() {
			@SuppressWarnings("rawtypes")
			@Override
			public List<Handler> getHandlerChain(PortInfo portInfo) {
				List<Handler> list = new ArrayList<>();
				list.add(new AmhehHandler());
				return list;
			}
		};
		s.setHandlerResolver(handlerResolver);

		return s.getPort(AmhehSEI.class);

	}

	private static String foo(Kind kind) {
		switch (kind) {
		case SERVICE_NAME:
			return "AmhehService";
		case WSDL:
			return "http://localhost:8080/mbwar/Amheh?wsdl";
		default:
			throw new IllegalArgumentException();
		}
	}

}
