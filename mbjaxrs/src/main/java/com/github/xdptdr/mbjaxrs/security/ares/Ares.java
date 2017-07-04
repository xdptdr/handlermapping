package com.github.xdptdr.mbjaxrs.security.ares;

import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.Principal;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Enumeration;

import javax.security.auth.x500.X500Principal;

public class Ares {
	public static void main(String[] args)
			throws KeyStoreException, NoSuchAlgorithmException, CertificateException, IOException {

		KeyStore ks = KeyStore.getInstance("Windows-ROOT");
		ks.load(null, null);
		System.out.println(ks.size());
		Enumeration<String> aliases = ks.aliases();
		while (aliases.hasMoreElements()) {
			String alias = aliases.nextElement();
			System.out.println(alias);
			Certificate cert = ks.getCertificate(alias);
			if (cert instanceof X509Certificate) {
				X509Certificate xcert = (X509Certificate) cert;

				System.out.println("  Basic constraints : " + Integer.toHexString(xcert.getBasicConstraints()));
				System.out.println("  Extendended key usage : " + xcert.getExtendedKeyUsage());
				System.out.println("  Alternative names : " + xcert.getIssuerAlternativeNames());
				System.out.println("  Issued Unique ID : " + xcert.getIssuerUniqueID());
				System.out.println("  Not after : " + xcert.getNotAfter());
				System.out.println("  Not before : " + xcert.getNotBefore());
				System.out.println("  Signature Algorithm name : " + xcert.getSigAlgName());
				System.out.println("  Signature Algorithm OID : " + xcert.getSigAlgOID());
				System.out.println("  Subject alternative names : " + xcert.getSubjectAlternativeNames());
				System.out.println("  Version : " + xcert.getVersion());

				Principal p = xcert.getIssuerDN();
				System.out.println("  Issuer DN : " + p.getName());

				p = xcert.getSubjectDN();
				System.out.println("  Subject DN : " + p.getName());

				X500Principal xp = xcert.getIssuerX500Principal();
				System.out.println("  Issuer X500 Principal : " + xp.getName());
				xp = xcert.getSubjectX500Principal();
				System.out.println("  Subject X500 Principal : " + xp.getName());

				System.out.print("  Key Usage : ");
				dumpBooleans(xcert.getKeyUsage());
				System.out.println();

				System.out.print("  Signature Algorithm Parameters :");
				dumpBytes(xcert.getSigAlgParams());
				System.out.println();

				System.out.print("  Signature :");
				dumpBytes(xcert.getSignature());
				System.out.println();

				System.out.println("  Serial Number : " + xcert.getSerialNumber());

				System.out.print("  Subject Unique ID :");
				dumpBooleans(xcert.getSubjectUniqueID());
				System.out.println();

				System.out.print("  TBS Certificate :");
				dumpBytes(xcert.getTBSCertificate());
				System.out.println();

			}
		}
	}

	private static void dumpBytes(byte[] bytes) {
		if (bytes == null) {
			System.out.print(" null");
			return;
		}
		for (byte b : bytes) {
			System.out.print(" ");
			String bs = Integer.toHexString(b & 0xFF);
			if (bs.length() == 1) {
				System.out.print("0");
			}
			System.out.print(bs);
		}

	}

	private static void dumpBooleans(boolean[] booleans) {
		if (booleans == null) {
			System.out.print("null");
			return;
		}
		for (boolean b : booleans) {
			System.out.print(b ? "1" : "0");
		}

	}
}
