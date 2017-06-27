package com.github.xdptdr.mbwar.jaxrs.clients.foo;

import java.util.List;
import java.util.Map.Entry;
import java.util.Scanner;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

public class FooCLI {

	private static final String FOO = "http://localhost:8080/mbwar/rs/foo";

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

				if (match("quit", args, 0)) {
					System.out.println("Done.");
					running = false;

				} else if (match("get", args, 0)) {
					if (match("hsr", args, 1)) {
						response = client.target(FOO + "/get/context/httpservletrequest").request().get();
					} else if (match("c", args, 1)) {
						response = client.target(FOO + "/get/context/configuration").request().get();
					} else if (match("ui", args, 1)) {
						response = client.target(FOO + "/get/context/uriinfo").request().get();
					} else if (match("a", args, 1)) {
						response = client.target(FOO + "/get/context/application").request().get();
					}
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

	private static boolean match(String cmd, String[] args, int i) {
		return cmd.equals(getL(args, i));
	}

	private static String getL(String[] args, int i) {
		return get(args, i).toLowerCase();

	}

	private static String get(String[] args, int i) {
		if (i >= args.length) {
			return "";
		}
		return args[i].trim();
	}
}
