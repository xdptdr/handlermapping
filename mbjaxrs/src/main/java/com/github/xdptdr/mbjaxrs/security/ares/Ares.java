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
				System.out.println("  Basic constraints : " + xcert.getBasicConstraints());
				// xcert.getBasicConstraints();
				// xcert.getExtendedKeyUsage();
				// xcert.getIssuerAlternativeNames();
				// Principal p = xcert.getIssuerDN();
				// xcert.getIssuerUniqueID();
				// xcert.getIssuerX500Principal();
				// xcert.getKeyUsage();
				// xcert.getNotAfter();
				// xcert.getNotBefore();
				// xcert.getSerialNumber();
				// xcert.getSigAlgName();
				// xcert.getSigAlgOID();
				// xcert.getSigAlgParams();
				// xcert.getSignature();
				// xcert.getSubjectAlternativeNames();
				// xcert.getSubjectDN();
				// xcert.getSubjectUniqueID();
				// xcert.getSubjectX500Principal();
				// xcert.getTBSCertificate();
				// xcert.getVersion();

			}
		}
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
