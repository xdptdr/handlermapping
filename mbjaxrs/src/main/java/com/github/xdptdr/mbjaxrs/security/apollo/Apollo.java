package com.github.xdptdr.mbjaxrs.security.apollo;

import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;

public class Apollo {
	public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeyException, SignatureException {

		byte[] contentBytes = "Hello".getBytes();
		System.out.print("Content bytes :");
		dumpBytes(contentBytes);

		System.out.println();

		KeyPairGenerator kpg = KeyPairGenerator.getInstance("DSA");

		KeyPair keyPair = kpg.generateKeyPair();

		PrivateKey privateKey = keyPair.getPrivate();
		PublicKey publicKey = keyPair.getPublic();

		System.out.println("Private key algorithm : " + privateKey.getAlgorithm());
		System.out.println("Private key format : " + privateKey.getFormat());
		byte[] privateKeyBytes = privateKey.getEncoded();
		if (privateKeyBytes != null) {
			dumpBytes(privateKeyBytes);
			System.out.println();
		} else {
			System.out.println(" Private key has no bytes");
		}
		System.out.println("Public key algorithm : " + publicKey.getAlgorithm());
		System.out.println("Public key format : " + publicKey.getFormat());
		byte[] publicKeyBytes = publicKey.getEncoded();
		if (publicKeyBytes != null) {
			dumpBytes(publicKeyBytes);
			System.out.println();
		} else {
			System.out.println(" Public key has no bytes");
		}

		Signature sig = Signature.getInstance("SHA256withDSA");
		sig.initSign(privateKey);
		sig.update(contentBytes);
		byte[] signature = sig.sign();
		System.out.print("Signature :");
		dumpBytes(signature);
		System.out.println();

		sig.initVerify(publicKey);
		sig.update(contentBytes);
		boolean result = sig.verify(signature);
		System.out.println("Signature verified ? " + (result ? "Yes !" : "No !"));

	}

	private static void dumpBytes(byte[] bytes) {
		for (byte b : bytes) {
			System.out.print(" ");
			String bs = Integer.toHexString(b & 0xFF);
			if (bs.length() == 1) {
				System.out.print("0");
			}
			System.out.print(bs);
		}

	}
}
