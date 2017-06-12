package com.github.xdptdr.mbwar.jaxrs.clients.cuk;

import java.util.List;
import java.util.Map.Entry;
import java.util.Scanner;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

public class InvokeCuk {

	private static final String CUK = "http://localhost:8080/mbwar/rs/cuk";

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
					if (match("qp", args, 1)) {
						if (match("e", args, 2)) {
							String p = get(args, 3);
							response = client.target(CUK + "/get/queryparam/encoded?p=" + p).request().get();
						} else if (match("d", args, 2)) {
							String p = get(args, 3);
							if ("".equals(p)) {
								response = client.target(CUK + "/get/queryparam/defaultvalue").request().get();
							} else {
								response = client.target(CUK + "/get/queryparam/defaultvalue?p=" + p).request().get();
							}
						} else if (match("ne", args, 2) || match("nd", args, 2)) {
							String p = get(args, 3);
							response = client.target(CUK + "/get/queryparam?p=" + p).request().get();
						} else {
							String p = get(args, 2);
							response = client.target(CUK + "/get/queryparam?p=" + p).request().get();
						}
					} else if (match("pp", args, 1)) {
						if (match("e", args, 2)) {
							String p = get(args, 3);
							response = client.target(CUK + "/get/pathparam/" + p + "/encoded").request().get();
						} else if (match("ne", args, 2)) {
							String p = get(args, 3);
							response = client.target(CUK + "/get/pathparam/" + p).request().get();
						} else {
							String p = get(args, 2);
							response = client.target(CUK + "/get/pathparam/" + p).request().get();
						}
					} else if (match("mp", args, 1)) {
						if (match("e", args, 2)) {
							String p = get(args, 3);
							response = client.target(CUK + "/get/matrixparam/encoded;p=" + p).request().get();
						} else if (match("d", args, 2)) {
							String p = get(args, 3);
							if ("".equals(p)) {
								response = client.target(CUK + "/get/matrixparam/defaultvalue").request().get();
							} else {
								response = client.target(CUK + "/get/matrixparam/defaultvalue;p=" + p).request().get();
							}
						} else if (match("ne", args, 2) || match("nd", args, 2)) {
							String p = get(args, 3);
							response = client.target(CUK + "/get/matrixparam;p=" + p).request().get();
						} else {
							String p = get(args, 2);
							response = client.target(CUK + "/get/matrixparam;p=" + p).request().get();
						}
					} else if (match("cp", args, 1)) {
						if (match("d", args, 2)) {
							String p = get(args, 3);
							if ("".equals(p)) {
								response = client.target(CUK + "/get/cookieparam/defaultvalue").request().get();
							} else {
								response = client.target(CUK + "/get/cookieparam/defaultvalue").request().cookie("p", p)
										.get();
							}
						} else if (match("nd", args, 2)) {
							String p = get(args, 3);
							response = client.target(CUK + "/get/cookieparam").request().cookie("p", p).get();
						} else {
							String p = get(args, 2);
							response = client.target(CUK + "/get/cookieparam").request().cookie("p", p).get();
						}
					} else if (match("c", args, 1)) {
						if (match("hsr", args, 2)) {
							response = client.target(CUK + "/get/context/httpservletrequest").request().get();
						} else if (match("c", args, 2)) {
							response = client.target(CUK + "/get/context/configuration").request().get();
						}
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
