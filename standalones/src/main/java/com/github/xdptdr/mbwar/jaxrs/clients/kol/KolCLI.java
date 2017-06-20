package com.github.xdptdr.mbwar.jaxrs.clients.kol;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

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

public class KolCLI {

	private static final String KOL = "http://localhost:8080/mbwar/rs/kol";

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
					if (CLI.match("all", args, 1)) {
						response = client.target(KOL).request().get();
					} else {
						Integer id = Integer.valueOf(CLI.get(args, 1));
						EntityTag etag = etags.get(id);
						Builder rb = client.target(KOL + "/" + id).request();
						if (etag != null) {
							rb = rb.header(HttpHeaders.IF_NONE_MATCH, etag.toString());
						}
						response = rb.get();
						etag = response.getEntityTag();
						if (etag != null) {
							etags.put(id, etag);
						}

					}
				} else if (CLI.match("head", args, 0)) {
					if (CLI.match("all", args, 1)) {
						response = client.target(KOL).request().head();
					} else {
						Integer id = Integer.valueOf(CLI.get(args, 1));
						response = client.target(KOL + "/" + id).request().head();

					}
				} else if (CLI.match("put", args, 0)) {
					if (CLI.match("all", args, 1)) {
						StringBuffer content = new StringBuffer();
						boolean sep = false;
						for (int i = 2; i < args.length; ++i) {
							if (sep) {
								content.append(" ");

							}
							content.append(CLI.get(args, i));
							sep = true;
						}
						response = client.target(KOL).request().put(Entity.text(content.toString()));
					} else {
						Integer id = Integer.valueOf(CLI.get(args, 1));
						String content = CLI.get(args, 2);
						response = client.target(KOL + "/" + id).request().put(Entity.text(content));
					}
				} else if (CLI.match("post", args, 0)) {
					String content = CLI.get(args, 1);
					response = client.target(KOL).request().post(Entity.text(content));
				} else if (CLI.match("delete", args, 0)) {
					if (CLI.match("all", args, 1)) {
						response = client.target(KOL).request().delete();
					} else {
						Integer id = Integer.valueOf(CLI.get(args, 1));
						response = client.target(KOL + "/" + id).request().delete();
					}
				} else if (CLI.match("options", args, 0)) {
					response = client.target(KOL).request().options();
				} else if (CLI.match("bar", args, 0)) {
					response = client.target(KOL).request()
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
}
