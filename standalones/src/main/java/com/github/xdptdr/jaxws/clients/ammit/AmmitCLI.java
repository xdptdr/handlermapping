package com.github.xdptdr.jaxws.clients.ammit;

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
			HandlerResolver handlerResolver = new HandlerResolver() {
				@SuppressWarnings("rawtypes")
				@Override
				public List<Handler> getHandlerChain(PortInfo portInfo) {
					List<Handler> list = new ArrayList<>();
					list.add(new AmmitHandler());
					return list;
				}
			};
			s.setHandlerResolver(handlerResolver);
			p = s.getPort(AmmitSEI.class);
		}
		return p;
	}

}
