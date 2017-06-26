package com.github.xdptdr.mbwar.jaxrs.clients.vej;

import java.io.InputStream;
import java.util.Scanner;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

import com.github.xdptdr.utils.CLI;

public class YzeCLI {

	private static final String YZE = "http://localhost:8080/mbwar/rs/yze";

	public static void main(String[] args) {

		Client client = ClientBuilder.newClient();

		Scanner command = new Scanner(System.in);

		System.out.println("Enter command:");

		boolean running = true;

		while (running) {
			String line = command.nextLine();
			try {
				args = line.split(" ");

				if (CLI.match("quit", args, 0)) {
					System.out.println("Done.");
					running = false;

				} else if (CLI.match("get", args, 0)) {
					String len = CLI.get(args, 1);
					InputStream is = client.target(YZE).queryParam("len", len).request().get(InputStream.class);
					int b = 0;
					while ((b = is.read()) != -1) {
						System.out.write(b);
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
