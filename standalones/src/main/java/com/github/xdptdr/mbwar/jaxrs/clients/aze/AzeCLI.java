package com.github.xdptdr.mbwar.jaxrs.clients.aze;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;

public class AzeCLI {
	public static void main(String[] args) {
		Client client = ClientBuilder.newClient();
		Response response = client.target("http://localhost:8080/mbwar/rs/aze/get").request().get();
		System.out.println(response.readEntity(String.class));
	}
}
