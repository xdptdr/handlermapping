package com.github.xdptdr.mbwar.jaxrs.clients.lim;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.core.EntityTag;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.github.xdptdr.utils.CLI;

public class LimCLI {

	private static final String LIM = "http://localhost:8080/mbwar/rs/lim";

	public static void main(String[] args) {

		Map<Integer, EntityTag> etags = new HashMap<Integer, EntityTag>();

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

				} else if (CLI.match("get", args, 0)) {
					if (CLI.match("u", args, 1)) {
						response = client.target(LIM + "/get/unset").request().get();
					} else if (CLI.match("ma", args, 1)) {
						response = client.target(LIM + "/get/maxAge").request().get();
					} else if (CLI.match("sma", args, 1)) {
						response = client.target(LIM + "/get/sMaxAge").request().get();
					} else if (CLI.match("mr", args, 1)) {
						response = client.target(LIM + "/get/mustRevalidate").request().get();
					} else if (CLI.match("nc", args, 1)) {
						response = client.target(LIM + "/get/noCache").request().get();
					} else if (CLI.match("ns", args, 1)) {
						response = client.target(LIM + "/get/noStore").request().get();
					} else if (CLI.match("nt", args, 1)) {
						response = client.target(LIM + "/get/noTransform").request().get();
					} else if (CLI.match("p", args, 1)) {
						response = client.target(LIM + "/get/private").request().get();
					} else if (CLI.match("pr", args, 1)) {
						response = client.target(LIM + "/get/proxyRevalidate").request().get();
					} else if (CLI.match("ce", args, 1)) {
						response = client.target(LIM + "/get/cacheExtension").request().get();
					} else if (CLI.match("ncf", args, 1)) {
						response = client.target(LIM + "/get/noCacheFields").request().get();
					} else if (CLI.match("pf", args, 1)) {
						response = client.target(LIM + "/get/privateFields").request().get();
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
}
