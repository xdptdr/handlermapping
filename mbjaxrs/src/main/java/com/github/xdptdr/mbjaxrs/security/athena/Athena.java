package com.github.xdptdr.mbjaxrs.security.athena;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SignatureException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;

public class Athena {

	public static void main(String[] args)
			throws KeyStoreException, NoSuchAlgorithmException, CertificateException, IOException {

		KeyStore ks = KeyStore.getInstance("Windows-ROOT");
		ks.load(null, null);
		Enumeration<String> aliases = ks.aliases();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		while (aliases.hasMoreElements()) {
			String alias = aliases.nextElement();
			System.out.println(alias);
			Certificate cert = ks.getCertificate(alias);

			if (cert instanceof X509Certificate) {
				X509Certificate xcert = (X509Certificate) cert;
				Date past = xcert.getNotBefore();
				Date future = xcert.getNotAfter();

				System.out.println(xcert.getSigAlgName());
				System.out.println(sdf.format(past) + " - " + sdf.format(future));
			}

			try {
				cert.verify(cert.getPublicKey());
				System.out.println("Verified.");
			} catch (InvalidKeyException | NoSuchProviderException | SignatureException e) {
				System.out.println(e.getClass().getName() + " " + e.getMessage());
			}

			System.out.println();
		}
	}

}
