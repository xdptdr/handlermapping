package com.github.xdptdr.mbjaxrs.security.demeter;

import java.net.URL;
import java.security.CodeSigner;
import java.security.CodeSource;
import java.security.Permission;
import java.security.PermissionCollection;
import java.security.Principal;
import java.security.ProtectionDomain;
import java.security.Timestamp;
import java.security.cert.CertPath;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.Enumeration;
import java.util.Iterator;

import gnu.getopt.LongOpt;

public class Demeter {
	public static void main(String[] args) {

		Class<LongOpt> clazz = LongOpt.class;
		c("Inspecting class: ");
		cln(clazz.getName());

		ProtectionDomain protectionDomain = clazz.getProtectionDomain();
		c("Protection domain: ");
		if (protectionDomain == null) {
			cln("not found");
		} else {
			cln("found");
			Principal[] principals = protectionDomain.getPrincipals();
			c("Principals : ");
			if (principals == null) {
				cln("not found");
			} else {
				cln("found " + principals.length);
				// TODO : inspect principals
			}
			PermissionCollection permissionCollection = protectionDomain.getPermissions();
			c("Permissions : ");
			if (permissionCollection == null) {
				cln("not found");
			} else {
				cln("found");
				cln("Iterating over permissions...");
				Enumeration<Permission> permissions = permissionCollection.elements();
				while (permissions.hasMoreElements()) {
					Permission permission = permissions.nextElement();
					if (permission == null) {
						cln("Found null permission");
					} else {
						c("Found permission: ");
						cln(permission.getName());
						String actions = permission.getActions();
						if (actions == null || "".equals(actions.trim())) {
							cln("No actions for this permission");
						} else {
							c("Actions for this permission: ");
							cln(actions);
						}
					}
				}
				cln("Iteration over permissions : completed");
			}
			CodeSource codeSource = protectionDomain.getCodeSource();
			c("Code source : ");
			if (codeSource == null) {
				cln("not found");
			} else {
				cln("found");
				URL location = codeSource.getLocation();
				c("Code source location : ");
				if (location == null) {
					cln("not found");
				} else {
					cln(location.toString());
				}
				Certificate[] certificates = codeSource.getCertificates();
				c("Certificates : ");
				if (certificates == null) {
					cln("not found");
				} else {
					cln("found " + certificates.length);
					if (certificates.length > 0) {
						cln("Iterating over certificates...");
						for (Certificate certificate : certificates) {
							if (certificate == null) {
								cln("Found null certificate");
							} else {
								String type = certificate.getType();
								if (type == null) {
									cln("Found certificate with null type");
								} else {
									c("Found certificate with type : ");
									cln(type);
									switch (type) {
									case "X.509":
										X509Certificate xcert = (X509Certificate) certificate;
										cln("X509 certificate found");
										break;
									default:
										cln("This type is not handled");
									}
								}
							}
						}
						cln("Iteration over certificates : completed");
					}
				}
				CodeSigner[] codeSigners = codeSource.getCodeSigners();
				c("Code signers : ");
				if (codeSigners == null) {
					cln("not found");
				} else {
					cln("found " + codeSigners.length);
					if (codeSigners.length > 0) {
						cln("Iterating over code signers");
						for (CodeSigner codeSigner : codeSigners) {
							if (codeSigner == null) {
								cln("Found null code signer");
							} else {
								Timestamp timestamp = codeSigner.getTimestamp();
								c("Timestamp : ");
								if (timestamp == null) {
									cln("not found");
								} else {
									cln("found");
								}
								CertPath certPath = codeSigner.getSignerCertPath();
								c("Cert path : ");
								if (certPath == null) {
									cln("not found");
								} else {
									c("found");
									String type = certPath.getType();
									c("Cert path type : ");
									if (type == null) {
										cln("not found");
									} else {
										cln(type);
									}
									Iterator<String> encodings = certPath.getEncodings();
									c("Encodings : ");
									if (encodings == null) {
										cln("not found");
									} else {
										cln("found");
										cln("Iterating over encodings");
										while (encodings.hasNext()) {
											String encoding = encodings.next();
											cln(encoding);
										}
										cln("Iteration over encodings : completed");
									}
								}
							}
						}
						cln("Iteration over code signers : completed");
					}
				}
			}
		}

	}

	private static void cln(String name) {
		c(name + "\n");
	}

	private static void c(String string) {
		for (int i = 0; i < string.length(); ++i) {
			System.out.print(string.charAt(i));
			System.out.flush();
			// sleep(50);
		}
		// sleep(500);
	}

	private static void sleep(int t) {
		try {
			Thread.sleep(t);
		} catch (InterruptedException e) {
		}

	}
}
