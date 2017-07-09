package com.github.xdptdr.jaxws.clients.amunet;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map.Entry;
import java.util.Scanner;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.xml.namespace.QName;
import javax.xml.ws.Holder;
import javax.xml.ws.Service;

import com.github.xdptdr.jaxws.amunet.AmunetSEI;
import com.github.xdptdr.utils.CLI;

public class AmunetCLI {

	private static final String NAMESPACE = "http://amunet.jaxws.xdptdr.github.com/";
	private static final String SERVICE_NAME = "AmunetService";
	private static final String WSDL = "http://localhost:8080/mbwar/Amunet?wsdl";

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
					AmunetSEI p = getPort();
					System.out.println(
							p.hello(new Holder<byte[]>(new byte[] { 0 }), new Holder<byte[]>(new byte[] { 0 })));

				} else if (CLI.match("w", args, 0)) {
					response = client.target(WSDL).request().get();
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

	private static AmunetSEI getPort() throws MalformedURLException {
		URL l = new URL(WSDL);
		QName qs = new QName(NAMESPACE, SERVICE_NAME);
		Service s = Service.create(l, qs);
		return s.getPort(AmunetSEI.class);

	}

}
