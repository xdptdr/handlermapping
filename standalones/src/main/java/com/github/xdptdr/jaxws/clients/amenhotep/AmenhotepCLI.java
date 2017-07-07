package com.github.xdptdr.jaxws.clients.amenhotep;

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

import com.github.xdptdr.jaxws.amenhotep.AmenhotepBareSEI;
import com.github.xdptdr.jaxws.amenhotep.AmenhotepEncodedSEI;
import com.github.xdptdr.jaxws.amenhotep.AmenhotepRPCSEI;
import com.github.xdptdr.jaxws.amenhotep.AmenhotepSEI;
import com.github.xdptdr.utils.CLI;

public final class AmenhotepCLI {

	public static enum Variant {
		DEFAULT, RPC, ENCODED, BARE
	};

	public static enum Kind {
		SERVICE_NAME, WSDL
	}

	private static final String AMENHOTEP_NAMESPACE = "http://amenhotep.jaxws.xdptdr.github.com/";

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
					AmenhotepSEI p = getPort(variant);
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

	private static AmenhotepSEI getPort(Variant variant) throws MalformedURLException {
		String serviceName = foo(variant, Kind.SERVICE_NAME);
		URL l = new URL(foo(variant, Kind.WSDL));
		QName qs = new QName(AMENHOTEP_NAMESPACE, serviceName);
		Service s = Service.create(l, qs);
		HandlerResolver handlerResolver = new HandlerResolver() {
			@SuppressWarnings("rawtypes")
			@Override
			public List<Handler> getHandlerChain(PortInfo portInfo) {
				List<Handler> list = new ArrayList<>();
				list.add(new AmenhotepHandler());
				return list;
			}
		};
		s.setHandlerResolver(handlerResolver);
		switch (variant) {
		case BARE:
			return s.getPort(AmenhotepBareSEI.class);
		case ENCODED:
			return s.getPort(AmenhotepEncodedSEI.class);
		case RPC:
			return s.getPort(AmenhotepRPCSEI.class);
		case DEFAULT:
		}
		return s.getPort(AmenhotepSEI.class);

	}

	private static String foo(Variant variant, Kind kind) {
		switch (kind) {
		case SERVICE_NAME:
			switch (variant) {
			case DEFAULT:
				return "AmenhotepService";
			case BARE:
				return "AmenhotepBareService";
			case ENCODED:
				return "AmenhotepEncodedService";
			case RPC:
				return "AmenhotepRPCService";
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
