package com.github.xdptdr.jaxws.clients.amenhotep;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Map.Entry;

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
import com.github.xdptdr.jaxws.clients.ammit.AmmitHandler;
import com.github.xdptdr.utils.CLI;

public final class AmenhotepCLI {

	public static enum Variant {
		DEFAULT, RPC, ENCODED, BARE
	};

	public static enum Kind {
		SERVICE_NAME, NAMESPACE, WSDL
	}

	private static final String AMENHOTEP_SERVICE_NAME = "AmmitService";
	private static final String AMENHOTEP_NAMESPACE = "http://ammit.jaxws.xdptdr.github.com/";
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

				} else if (CLI.match("w", args, 0)) {
					String variantS = CLI.get(args, 1);
					Variant variant = Variant.DEFAULT;
					switch (variantS) {
					case "r":
						variant = Variant.RPC;
						break;
					case "e":
						variant = Variant.ENCODED;
						break;
					case "b":
						variant = Variant.BARE;
						break;
					}

					String wsdl = foo(variant, Kind.WSDL);
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

	private static AmmitSEI getPort() throws MalformedURLException {
		if (p == null) {
			URL l = new URL(foo(Variant.DEFAULT, Kind.WSDL));
			QName qs = new QName(AMENHOTEP_NAMESPACE, AMENHOTEP_SERVICE_NAME);
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

	private static String foo(Variant variant, Kind kind) {
		switch (kind) {
		case NAMESPACE:
			switch (variant) {
			case DEFAULT:
			case BARE:
			case ENCODED:
			case RPC:
			default:
				throw new IllegalArgumentException();
			}
		case SERVICE_NAME:
			switch (variant) {
			case DEFAULT:
			case BARE:
			case ENCODED:
			case RPC:
			default:
				throw new IllegalArgumentException();
			}
		case WSDL:
			switch (variant) {
			case DEFAULT:
				return "http://localhost:8080/mbwar/Amenhotep?wsdl";
			case BARE:
				return "http://localhost:8080/mbwar/AmenhotepBare?wsdl";
			case ENCODED:
				return "http://localhost:8080/mbwar/AmenhotepEncoded?wsdl";
			case RPC:
				return "http://localhost:8080/mbwar/AmenhotepRPC?wsdl";
			default:
				throw new IllegalArgumentException();
			}
		default:
			throw new IllegalArgumentException();
		}
	}

}
