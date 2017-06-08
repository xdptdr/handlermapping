package com.github.xdptdr.mbwar.jaxrs.clients.later.bar;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;

public class InvokeBarGet {
	public static void main(String[] args) {
		Client client = ClientBuilder.newClient();
		Response response = client.target("http://localhost:8080/mbwar/rs/bar/get").request().get();
		System.out.println(response.readEntity(String.class));
	}
}
