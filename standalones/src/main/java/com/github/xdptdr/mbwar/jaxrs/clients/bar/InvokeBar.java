package com.github.xdptdr.mbwar.jaxrs.clients.bar;

import java.util.List;
import java.util.Map.Entry;
import java.util.Scanner;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

public class InvokeBar {

	private static final String BAR = "http://localhost:8080/mbwar/rs/bar";

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
					if (match("all", args, 1)) {
						response = client.target(BAR).request().get();
					} else {
						Integer id = Integer.valueOf(get(args, 1));
						response = client.target(BAR + "/" + id).request().get();

					}
				} else if (match("head", args, 0)) {
					if (match("all", args, 1)) {
						response = client.target(BAR).request().head();
					} else {
						Integer id = Integer.valueOf(get(args, 1));
						response = client.target(BAR + "/" + id).request().head();

					}
				} else if (match("put", args, 0)) {
					if (match("all", args, 1)) {
						StringBuffer content = new StringBuffer();
						boolean sep = false;
						for (int i = 2; i < args.length; ++i) {
							if (sep) {
								content.append(" ");

							}
							content.append(get(args, i));
							sep = true;
						}
						response = client.target(BAR).request().put(Entity.text(content.toString()));
					} else {
						Integer id = Integer.valueOf(get(args, 1));
						String content = get(args, 2);
						response = client.target(BAR + "/" + id).request().put(Entity.text(content));
					}
				} else if (match("post", args, 0)) {
					String content = get(args, 1);
					response = client.target(BAR).request().post(Entity.text(content));
				} else if (match("delete", args, 0)) {
					if (match("all", args, 1)) {
						response = client.target(BAR).request().delete();
					} else {
						Integer id = Integer.valueOf(get(args, 1));
						response = client.target(BAR + "/" + id).request().delete();
					}
				} else if (match("options", args, 0)) {
					response = client.target(BAR).request().options();
				} else if (match("bar", args, 0)) {
					response = client.target(BAR).request()
							.property("jersey.config.client.httpUrlConnection.setMethodWorkaround", true)
							.accept(MediaType.TEXT_PLAIN_TYPE).method("BAR");
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