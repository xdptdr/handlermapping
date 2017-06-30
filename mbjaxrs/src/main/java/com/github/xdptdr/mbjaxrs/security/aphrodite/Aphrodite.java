package com.github.xdptdr.mbjaxrs.security.aphrodite;

import java.security.AlgorithmParameterGenerator;
import java.security.AlgorithmParameters;
import java.security.KeyFactory;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Policy;
import java.security.Policy.Parameters;
import java.security.Provider;
import java.security.SecureRandom;
import java.security.Security;
import java.security.Signature;

public class Aphrodite {
	public static void main(String[] args) throws NoSuchAlgorithmException, KeyStoreException {

		String algorithm = null;
		String type = null;

		// AccessControlContext context = AccessController.getContext();
		// context.checkPermission(new AllPermission());

		// AlgorithmParameterGenerator.getInstance(algorithm);
		//
		// AlgorithmParameters.getInstance(algorithm);
		//
		// KeyFactory.getInstance(algorithm);
		//
		// KeyPairGenerator.getInstance(algorithm);
		//
		// KeyStore.getInstance(type);
		//
		// MessageDigest.getInstance(algorithm);

		// Policy policy = Policy.getPolicy();
		// policy.getParameters();
		// policy.getProvider();
		// policy.getType();
		//
		// SecureRandom.getInstance(algorithm);

//		for (Provider provider : Security.getProviders()) {
			// System.out.println(provider.getInfo());
			// System.out.println(provider.getName());
//			System.out.println(provider.getServices().size());
//			System.out.println(provider.getVersion());
			
//		}
		
		Signature.getInstance(algorithm);
		
		

	}
}
