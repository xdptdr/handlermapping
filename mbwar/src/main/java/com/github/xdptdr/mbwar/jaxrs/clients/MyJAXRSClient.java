package com.github.xdptdr.mbwar.jaxrs.clients;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;

public class MyJAXRSClient {
	public static void main(String[] args) {
		Client client = ClientBuilder.newClient();
		Response response = client.target("localhost:8080/mbwar/rs/foo/get").request().get();
		System.out.println(response.getEntity());
	}
}
