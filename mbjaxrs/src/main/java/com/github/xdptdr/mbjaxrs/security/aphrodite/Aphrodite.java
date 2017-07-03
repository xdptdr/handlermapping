package com.github.xdptdr.mbjaxrs.security.aphrodite;

import java.security.Provider;
import java.security.Provider.Service;
import java.security.Security;

public class Aphrodite {
	public static void main(String[] args) {

		for (Provider provider : Security.getProviders()) {
			System.out.println("= " + provider.getName() + " =");
			for (Service service : provider.getServices()) {
				System.out.println(service.getType() + " - " + service.getAlgorithm());
			}
			System.out.println();
		}

	}
}
