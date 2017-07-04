package com.github.xdptdr.mbjaxrs.security.artemis;

import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;

public class Artemis {

	private static class CertWithAlias {
		private String alias;
		private Certificate cert;

		public CertWithAlias(String alias, Certificate cert) {
			this.alias = alias;
			this.cert = cert;
		}

		public String getAlias() {
			return alias;
		}

		public Certificate getCert() {
			return cert;
		}

	}

	public static void main(String[] args)
			throws KeyStoreException, NoSuchAlgorithmException, CertificateException, IOException {

		KeyStore ks = KeyStore.getInstance("Windows-ROOT");
		ks.load(null, null);
		Enumeration<String> aliases = ks.aliases();
		Date futureMax = null;
		Date pastMin = null;
		List<CertWithAlias> certs = new ArrayList<>();
		while (aliases.hasMoreElements()) {
			String alias = aliases.nextElement();
			Certificate cert = ks.getCertificate(alias);
			certs.add(new CertWithAlias(alias, cert));
			if (cert instanceof X509Certificate) {
				X509Certificate xcert = (X509Certificate) cert;
				Date future = xcert.getNotAfter();
				if (futureMax == null || future.after(futureMax)) {
					futureMax = future;
				}
				Date past = xcert.getNotBefore();
				if (pastMin == null || past.before(pastMin)) {
					pastMin = past;
				}
			}
		}

		Comparator<CertWithAlias> cmp = new Comparator<CertWithAlias>() {
			@Override
			public int compare(CertWithAlias o1, CertWithAlias o2) {

				if (o1 == null) {
					return (o2 == null) ? 0 : -1;
				}
				if (o2 == null) {
					return 1;
				}
				boolean x1 = !(o1.getCert() instanceof X509Certificate);
				boolean x2 = !(o2.getCert() instanceof X509Certificate);

				if (x1) {
					return x2 ? o1.getAlias().compareTo(o2.getAlias()) : -1;
				} else if (x2) {
					return 1;
				}

				X509Certificate xo1 = (X509Certificate) o1.getCert();
				X509Certificate xo2 = (X509Certificate) o2.getCert();

				Date past1 = xo1.getNotBefore();
				Date past2 = xo2.getNotBefore();

				int pastCmp = past1.compareTo(past2);
				if (pastCmp == 0) {
					Date future1 = xo1.getNotAfter();
					Date future2 = xo2.getNotAfter();
					int futureCmp = future1.compareTo(future2);
					if (futureCmp == 0) {
						return o1.getAlias().compareTo(o2.getAlias());
					} else {
						return futureCmp;
					}
				} else {
					return pastCmp;
				}
			}
		};
		Collections.sort(certs, cmp);

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

		final int maxCol = 150;
		for (CertWithAlias cwa : certs) {
			System.out.println(cwa.getAlias());
			Certificate cert = cwa.getCert();
			if (cert instanceof X509Certificate) {
				X509Certificate xcert = (X509Certificate) cert;
				System.out.println(xcert.getSigAlgName());
				Date past = xcert.getNotBefore();
				Date future = xcert.getNotAfter();
				System.out.println(sdf.format(past) + " - " + sdf.format(future));
				long pastTime = past.getTime();
				long futureTime = future.getTime();
				long futureMaxTime = futureMax.getTime();
				long pastMinTime = pastMin.getTime();
				long pastDelta = pastTime - pastMinTime;
				long futureDelta = futureTime - pastMinTime;
				double pastRatio = (double) pastDelta / (double) (futureMaxTime - pastMinTime) * (double) maxCol;
				double futureRatio = (double) futureDelta / (double) (futureMaxTime - pastMinTime) * (double) maxCol;
				int pastRatioI = (int) pastRatio;
				int futureRatioI = (int) futureRatio;
				System.out.print("|");
				for (int i = 0; i < maxCol; ++i) {
					if (i >= pastRatioI && i <= futureRatioI) {
						System.out.print("-");
					} else {
						System.out.print(" ");
					}
				}
				System.out.println("|");
			}
			System.out.println();
		}
	}

}
