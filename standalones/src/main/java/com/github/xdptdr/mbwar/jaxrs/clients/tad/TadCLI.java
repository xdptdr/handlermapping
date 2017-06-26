package com.github.xdptdr.mbwar.jaxrs.clients.tad;

import java.util.List;
import java.util.Map.Entry;
import java.util.Scanner;

import javax.ws.rs.client.AsyncInvoker;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.InvocationCallback;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.github.xdptdr.utils.CLI;

public class TadCLI {

	private static final String TAD = "http://localhost:8080/mbwar/rs/tad";

	private static class LastAsyncInvocationResult {

		private Response response;

		public LastAsyncInvocationResult() {
		}

		public Response getResponse() {
			return response;
		}

		public void setResponse(Response response) {
			this.response = response;
		}

	}

	public static void main(String[] args) {

		Client client = ClientBuilder.newClient();

		Scanner command = new Scanner(System.in);

		LastAsyncInvocationResult lastResult = new LastAsyncInvocationResult();

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

				} else if (CLI.match("long", args, 0) || CLI.match("short", args, 0)
						|| CLI.match("threshold", args, 0)) {
					WebTarget target = client.target(TAD + "/{timeout}");
					int timeout = 0;
					switch (CLI.get(args, 0)) {
					case "long":
						timeout = 1500;
						break;
					case "short":
						timeout = 500;
						break;
					case "threshold":
						timeout = 1000;
						break;
					}
					AsyncInvoker asyncInvoker = target.resolveTemplate("timeout", timeout).request().async();
					asyncInvoker.get(new InvocationCallback<Response>() {
						@Override
						public void completed(Response response) {
							System.out.println("Got a response.");
							lastResult.setResponse(response);
						}

						@Override
						public void failed(Throwable throwable) {
							System.out.println("Something went wrong.");
							throwable.printStackTrace();
							lastResult.setResponse(null);
						}
					});
				} else if (CLI.match("result", args, 0)) {
					response = lastResult.getResponse();
					if (response == null) {
						System.out.println("No last response.");
					}
				} else if (CLI.match("logs", args, 0)) {
					response = client.target(TAD).request().get();
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
