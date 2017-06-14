package com.github.xdptdr.mbwar.jaxrs.clients.hej;

import java.util.List;
import java.util.Map.Entry;
import java.util.Scanner;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.github.xdptdr.utils.CLI;

public class HejCLI {

	private static final String HEJ = "http://localhost:8080/mbwar/rs/hej";

	/**
	 * @param args
	 */
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
				} else if (CLI.match("post", args, 0)) {
					Form form = new Form();
					form.param("p", "aze");
					form.param("p", "bar");
					form.param("q", "cuk");
					response = client.target(HEJ + "/post").request().post(Entity.form(form));
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
