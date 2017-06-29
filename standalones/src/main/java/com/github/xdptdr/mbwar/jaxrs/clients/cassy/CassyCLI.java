package com.github.xdptdr.mbwar.jaxrs.clients.cassy;

import java.util.List;
import java.util.Scanner;
import java.util.Map.Entry;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.github.xdptdr.utils.CLI;

public class CassyCLI {

	private static final String CASSY = "http://localhost:8080/mbwar/rs/cassy";

	public static void main(String[] args) {

		System.setProperty("sun.net.http.allowRestrictedHeaders", "true");

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

				} else if (CLI.match("a0", args, 0)) {
					response = client.target(CASSY + "/withoutCORS").request().get();
				} else if (CLI.match("a1", args, 0)) {
					response = client.target(CASSY + "/withCORS").request().get();
				} else if (CLI.match("a2", args, 0)) {
					response = client.target(CASSY + "/withCORSCustomized").request().get();
				} else if (CLI.match("b0", args, 0)) {
					response = client.target(CASSY + "/withoutCORS").request().header("Origin", "http://cassycli.local")
							.get();
				} else if (CLI.match("b1", args, 0)) {
					response = client.target(CASSY + "/withCORS").request().header("Origin", "http://cassycli.local")
							.get();
				} else if (CLI.match("b2", args, 0)) {
					response = client.target(CASSY + "/withCORSCustomized").request()
							.header("Origin", "http://cassycli.local").get();
				} else if (CLI.match("c0", args, 0)) {
					response = client.target(CASSY + "/withoutCORS").request().header("Origin", "http://cassy.local")
							.get();
				} else if (CLI.match("c1", args, 0)) {
					response = client.target(CASSY + "/withCORS").request().header("Origin", "http://cassy.local")
							.get();
				} else if (CLI.match("c2", args, 0)) {
					response = client.target(CASSY + "/withCORSCustomized").request()
							.header("Origin", "http://cassy.local").get();
				} else if (CLI.match("d0", args, 0)) {
					response = client.target(CASSY + "/withoutCORS").request().header("Origin", "http://cassy.local")
							.options();
				} else if (CLI.match("d1", args, 0)) {
					response = client.target(CASSY + "/withCORS").request().header("Origin", "http://cassy.local")
							.options();
				} else if (CLI.match("d2", args, 0)) {
					response = client.target(CASSY + "/withCORSCustomized").request()
							.header("Origin", "http://cassy.local").options();
				} else if (CLI.match("e0", args, 0)) {
					response = client.target(CASSY + "/withoutCORS").request().header("Origin", "http://cassy.local")
							.header("Access-Control-Request-Method", "CASSY")
							.header("Access-Control-Request-Headers", "X-CASSY").options();
				} else if (CLI.match("e1", args, 0)) {
					response = client.target(CASSY + "/withCORS").request().header("Origin", "http://cassy.local")
							.header("Access-Control-Request-Method", "CASSY")
							.header("Access-Control-Request-Headers", "X-CASSY").options();
				} else if (CLI.match("e2", args, 0)) {
					response = client.target(CASSY + "/withCORSCustomized").request()
							.header("Origin", "http://cassy.local").header("Access-Control-Request-Method", "CASSY")
							.header("Access-Control-Request-Headers", "X-CASSY").options();
				} else if (CLI.match("f0", args, 0)) {
					response = client.target(CASSY + "/withoutCORS").request().header("Origin", "http://cassy.local")
							.get();
				} else if (CLI.match("f1", args, 0)) {
					response = client.target(CASSY + "/withCORS").request().header("Origin", "http://cassy.local")
							.get();
				} else if (CLI.match("f2", args, 0)) {
					response = client.target(CASSY + "/withCORSCustomized").request()
							.header("Origin", "http://cassy.local").get();
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

}
