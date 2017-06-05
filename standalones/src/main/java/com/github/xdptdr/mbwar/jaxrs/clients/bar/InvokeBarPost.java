package com.github.xdptdr.mbwar.jaxrs.clients.bar;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class InvokeBarPost {
	public static void main(String[] args) {
		Client client = ClientBuilder.newClient();

		Response response = client.target("http://localhost:8080/mbwar/rs/bar/post").request()
				.post(Entity.entity("John Doe", MediaType.TEXT_PLAIN));

		System.out.println(response.readEntity(String.class));
	}
}
