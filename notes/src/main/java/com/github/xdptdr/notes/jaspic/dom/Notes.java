package com.github.xdptdr.notes.jaspic.dom;

import java.security.AccessControlContext;
import java.security.AccessControlException;
import java.security.AccessController;
import java.security.AlgorithmConstraints;
import java.security.AlgorithmParameterGenerator;
import java.security.AlgorithmParameterGeneratorSpi;
import java.security.AlgorithmParameters;
import java.security.AlgorithmParametersSpi;
import java.security.AllPermission;
import java.security.AuthProvider;
import java.security.BasicPermission;
import java.security.CodeSigner;
import java.security.CodeSource;
import java.security.CryptoPrimitive;
import java.security.DigestException;
import java.security.DigestInputStream;
import java.security.DigestOutputStream;
import java.security.DomainCombiner;
import java.security.DomainLoadStoreParameter;
import java.security.GeneralSecurityException;
import java.security.Guard;
import java.security.GuardedObject;
import java.security.Identity;
import java.security.IdentityScope;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.InvalidParameterException;
import java.security.Key;
import java.security.KeyException;
import java.security.KeyFactory;
import java.security.KeyFactorySpi;
import java.security.KeyManagementException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.KeyPairGeneratorSpi;
import java.security.KeyRep;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.KeyStoreSpi;
import java.security.MessageDigest;
import java.security.MessageDigestSpi;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PKCS12Attribute;
import java.security.Permission;
import java.security.PermissionCollection;
import java.security.Permissions;
import java.security.PolicySpi;
import java.security.Principal;
import java.security.PrivateKey;
import java.security.PrivilegedAction;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.security.ProtectionDomain;
import java.security.Provider;
import java.security.ProviderException;
import java.security.PublicKey;
import java.security.SecureClassLoader;
import java.security.SecureRandom;
import java.security.SecureRandomSpi;
import java.security.Security;
import java.security.SecurityPermission;
import java.security.Signature;
import java.security.SignatureException;
import java.security.SignatureSpi;
import java.security.SignedObject;
import java.security.Signer;
import java.security.Timestamp;
import java.security.URIParameter;
import java.security.UnrecoverableEntryException;
import java.security.UnrecoverableKeyException;
import java.security.UnresolvedPermission;
import java.security.acl.AclEntry;
import java.security.acl.AclNotFoundException;
import java.security.acl.Group;
import java.security.acl.LastOwnerException;
import java.security.acl.NotOwnerException;
import java.security.acl.Owner;
import java.security.cert.CRL;
import java.security.cert.CRLException;
import java.security.cert.CRLReason;
import java.security.cert.CRLSelector;
import java.security.cert.CertPath;
import java.security.cert.CertPathBuilder;
import java.security.cert.CertPathBuilderException;
import java.security.cert.CertPathBuilderResult;
import java.security.cert.CertPathBuilderSpi;
import java.security.cert.CertPathChecker;
import java.security.cert.CertPathParameters;
import java.security.cert.CertPathValidator;
import java.security.cert.CertPathValidatorException;
import java.security.cert.CertPathValidatorResult;
import java.security.cert.CertPathValidatorSpi;
import java.security.cert.CertSelector;
import java.security.cert.CertStore;
import java.security.cert.CertStoreException;
import java.security.cert.CertStoreParameters;
import java.security.cert.CertStoreSpi;
import java.security.cert.CertificateFactory;
import java.security.cert.CertificateFactorySpi;
import java.security.cert.CertificateRevokedException;
import java.security.cert.CollectionCertStoreParameters;
import java.security.cert.Extension;
import java.security.cert.LDAPCertStoreParameters;
import java.security.cert.PKIXBuilderParameters;
import java.security.cert.PKIXCertPathBuilderResult;
import java.security.cert.PKIXCertPathChecker;
import java.security.cert.PKIXCertPathValidatorResult;
import java.security.cert.PKIXParameters;
import java.security.cert.PKIXReason;
import java.security.cert.PKIXRevocationChecker;
import java.security.cert.PolicyNode;
import java.security.cert.PolicyQualifierInfo;
import java.security.cert.TrustAnchor;
import java.security.cert.X509CRL;
import java.security.cert.X509CRLEntry;
import java.security.cert.X509CRLSelector;
import java.security.cert.X509CertSelector;
import java.security.cert.X509Extension;
import java.security.interfaces.DSAKey;
import java.security.interfaces.DSAKeyPairGenerator;
import java.security.interfaces.DSAParams;
import java.security.interfaces.DSAPrivateKey;
import java.security.interfaces.ECKey;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.interfaces.RSAKey;
import java.security.interfaces.RSAMultiPrimePrivateCrtKey;
import java.security.interfaces.RSAPrivateCrtKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.DSAGenParameterSpec;
import java.security.spec.DSAParameterSpec;
import java.security.spec.DSAPrivateKeySpec;
import java.security.spec.DSAPublicKeySpec;
import java.security.spec.ECField;
import java.security.spec.ECFieldF2m;
import java.security.spec.ECFieldFp;
import java.security.spec.ECGenParameterSpec;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.ECPrivateKeySpec;
import java.security.spec.ECPublicKeySpec;
import java.security.spec.EllipticCurve;
import java.security.spec.EncodedKeySpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.InvalidParameterSpecException;
import java.security.spec.KeySpec;
import java.security.spec.MGF1ParameterSpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.PSSParameterSpec;
import java.security.spec.RSAKeyGenParameterSpec;
import java.security.spec.RSAMultiPrimePrivateCrtKeySpec;
import java.security.spec.RSAOtherPrimeInfo;
import java.security.spec.RSAPrivateCrtKeySpec;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;
import java.security.spec.X509EncodedKeySpec;

import javax.security.auth.AuthPermission;
import javax.security.auth.DestroyFailedException;
import javax.security.auth.Destroyable;
import javax.security.auth.Policy;
import javax.security.auth.PrivateCredentialPermission;
import javax.security.auth.RefreshFailedException;
import javax.security.auth.Refreshable;
import javax.security.auth.Subject;
import javax.security.auth.SubjectDomainCombiner;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.ChoiceCallback;
import javax.security.auth.callback.ConfirmationCallback;
import javax.security.auth.callback.LanguageCallback;
import javax.security.auth.callback.NameCallback;
import javax.security.auth.callback.PasswordCallback;
import javax.security.auth.callback.TextInputCallback;
import javax.security.auth.callback.TextOutputCallback;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.kerberos.DelegationPermission;
import javax.security.auth.kerberos.KerberosKey;
import javax.security.auth.kerberos.KerberosPrincipal;
import javax.security.auth.kerberos.KerberosTicket;
import javax.security.auth.kerberos.KeyTab;
import javax.security.auth.kerberos.ServicePermission;
import javax.security.auth.login.AccountException;
import javax.security.auth.login.AccountExpiredException;
import javax.security.auth.login.AccountLockedException;
import javax.security.auth.login.AccountNotFoundException;
import javax.security.auth.login.AppConfigurationEntry;
import javax.security.auth.login.Configuration;
import javax.security.auth.login.ConfigurationSpi;
import javax.security.auth.login.CredentialException;
import javax.security.auth.login.CredentialExpiredException;
import javax.security.auth.login.CredentialNotFoundException;
import javax.security.auth.login.FailedLoginException;
import javax.security.auth.login.LoginContext;
import javax.security.auth.login.LoginException;
import javax.security.auth.message.AuthException;
import javax.security.auth.message.AuthStatus;
import javax.security.auth.message.ClientAuth;
import javax.security.auth.message.MessageInfo;
import javax.security.auth.message.MessagePolicy;
import javax.security.auth.message.ServerAuth;
import javax.security.auth.message.callback.CallerPrincipalCallback;
import javax.security.auth.message.callback.CertStoreCallback;
import javax.security.auth.message.callback.GroupPrincipalCallback;
import javax.security.auth.message.callback.PasswordValidationCallback;
import javax.security.auth.message.callback.PrivateKeyCallback;
import javax.security.auth.message.callback.SecretKeyCallback;
import javax.security.auth.message.callback.TrustStoreCallback;
import javax.security.auth.message.config.AuthConfig;
import javax.security.auth.message.config.AuthConfigFactory;
import javax.security.auth.message.config.AuthConfigProvider;
import javax.security.auth.message.config.ClientAuthConfig;
import javax.security.auth.message.config.ClientAuthContext;
import javax.security.auth.message.config.RegistrationListener;
import javax.security.auth.message.config.ServerAuthConfig;
import javax.security.auth.message.config.ServerAuthContext;
import javax.security.auth.message.module.ClientAuthModule;
import javax.security.auth.message.module.ServerAuthModule;
import javax.security.auth.spi.LoginModule;
import javax.security.auth.x500.X500Principal;
import javax.security.auth.x500.X500PrivateCredential;
import javax.security.cert.Certificate;
import javax.security.cert.CertificateEncodingException;
import javax.security.cert.CertificateException;
import javax.security.cert.CertificateExpiredException;
import javax.security.cert.CertificateNotYetValidException;
import javax.security.cert.CertificateParsingException;
import javax.security.cert.X509Certificate;
import javax.security.jacc.EJBMethodPermission;
import javax.security.jacc.EJBRoleRefPermission;
import javax.security.jacc.PolicyConfiguration;
import javax.security.jacc.PolicyConfigurationFactory;
import javax.security.jacc.PolicyContext;
import javax.security.jacc.PolicyContextException;
import javax.security.jacc.PolicyContextHandler;
import javax.security.jacc.WebResourcePermission;
import javax.security.jacc.WebRoleRefPermission;
import javax.security.jacc.WebUserDataPermission;
import javax.security.sasl.AuthenticationException;
import javax.security.sasl.AuthorizeCallback;
import javax.security.sasl.RealmCallback;
import javax.security.sasl.RealmChoiceCallback;
import javax.security.sasl.Sasl;
import javax.security.sasl.SaslClient;
import javax.security.sasl.SaslClientFactory;
import javax.security.sasl.SaslException;
import javax.security.sasl.SaslServer;
import javax.security.sasl.SaslServerFactory;

import com.github.xdptdr.notes.N;
import com.sun.mail.imap.ACL;

import javassist.tools.Callback;

@SuppressWarnings("deprecation")
public class Notes {

	private static void notes(N n) {

		/*- https://en.wikipedia.org/wiki/List_of_Greek_mythological_figures */

		/*- JASPIC : JSR 196 */

		/*- Message Processing Model */

		/*- SPI */

		/*- four points in the typical message interaction scenario */

		/*- authentication providers */

		/*- client authentication module */

		/*- server authentication module */

		/*-
		 * (1) client : secure
		 * (2) server : validate
		 * (3) server : dispatch request
		 * (4) server : secure
		 * (5) client : validate 
		 */

		/*- possible timelines :
		 * 12(52)*345
		 */

		/*- multi-message dialog */

		/*- challenge-response protocols */

		ClientAuthModule.class.getName();
		ServerAuthModule.class.getName();

		ClientAuthContext.class.getName();
		ServerAuthContext.class.getName();

		ClientAuthConfig.class.getName();
		ServerAuthConfig.class.getName();

		AuthConfigProvider.class.getName();

		AuthConfigFactory.class.getName();

		MessageInfo.class.getName();

		MessagePolicy.class.getName();

		Subject.class.getName();

		todoJseJavaSecurity(n);

		todoJseJavaxSecurityAuth(n);
		todoJseJavaxSecurityCert(n);
		todoJseJavaxSecuritySasl(n);

		todoJeeJavaxSecurityAuth(n);
		todoJeeJavaxSecurityJacc(n);

		java.security.Policy.class.getName();
	}

	private static void todoJseJavaSecurity(N n) {

		n.todo(AccessControlContext.class, AccessControlException.class, AccessController.class,
				AlgorithmConstraints.class, AlgorithmParameterGenerator.class, AlgorithmParameterGeneratorSpi.class,
				AlgorithmParameters.class, AlgorithmParametersSpi.class, AllPermission.class, AuthProvider.class,
				BasicPermission.class, java.security.cert.Certificate.class, CodeSigner.class, CodeSource.class,
				CryptoPrimitive.class, DigestException.class, DigestInputStream.class, DigestOutputStream.class,
				DomainCombiner.class, DomainLoadStoreParameter.class, GeneralSecurityException.class, Guard.class,
				GuardedObject.class, Identity.class, IdentityScope.class, InvalidAlgorithmParameterException.class,
				InvalidKeyException.class, InvalidParameterException.class, Key.class, KeyException.class,
				KeyFactory.class, KeyFactorySpi.class, KeyManagementException.class, KeyPair.class,
				KeyPairGenerator.class, KeyPairGeneratorSpi.class, KeyRep.class, KeyStore.class,
				KeyStoreException.class, KeyStoreSpi.class, MessageDigest.class, MessageDigestSpi.class,
				NoSuchAlgorithmException.class, NoSuchProviderException.class, Permission.class,
				PermissionCollection.class, Permissions.class, PKCS12Attribute.class, java.security.Policy.class,
				PolicySpi.class, Principal.class, PrivateKey.class, PrivilegedAction.class,
				PrivilegedActionException.class, PrivilegedExceptionAction.class, ProtectionDomain.class,
				Provider.class, ProviderException.class, PublicKey.class, SecureClassLoader.class, SecureRandom.class,
				SecureRandomSpi.class, Security.class, SecurityPermission.class, Signature.class,
				SignatureException.class, SignatureSpi.class, SignedObject.class, Signer.class, Timestamp.class,
				UnrecoverableEntryException.class, UnrecoverableKeyException.class, UnresolvedPermission.class,
				URIParameter.class);

		n.todo(ACL.class, AclEntry.class, AclNotFoundException.class, Group.class, LastOwnerException.class,
				NotOwnerException.class, Owner.class, Permission.class);

		n.todo(java.security.cert.Certificate.class, java.security.cert.CertificateEncodingException.class,
				java.security.cert.CertificateException.class, java.security.cert.CertificateExpiredException.class,
				CertificateFactory.class, CertificateFactorySpi.class,
				java.security.cert.CertificateNotYetValidException.class,
				java.security.cert.CertificateParsingException.class, CertificateRevokedException.class, CertPath.class,
				CertPathBuilder.class, CertPathBuilderException.class, CertPathBuilderResult.class,
				CertPathBuilderSpi.class, CertPathChecker.class, CertPathParameters.class, CertPathValidator.class,
				CertPathValidatorException.class, CertPathValidatorResult.class, CertPathValidatorSpi.class,
				CertSelector.class, CertStore.class, CertStoreException.class, CertStoreParameters.class,
				CertStoreSpi.class, CollectionCertStoreParameters.class, CRL.class, CRLException.class, CRLReason.class,
				CRLSelector.class, Extension.class, LDAPCertStoreParameters.class, PKIXBuilderParameters.class,
				PKIXCertPathBuilderResult.class, PKIXCertPathChecker.class, PKIXCertPathValidatorResult.class,
				PKIXParameters.class, PKIXReason.class, PKIXRevocationChecker.class, PolicyNode.class,
				PolicyQualifierInfo.class, TrustAnchor.class, java.security.cert.X509Certificate.class,
				X509CertSelector.class, X509CRL.class, X509CRLEntry.class, X509CRLSelector.class, X509Extension.class);

		n.todo(DSAKey.class, DSAKeyPairGenerator.class, DSAParams.class, DSAPrivateKey.class, DSAPrivateKey.class,
				ECKey.class, ECPrivateKey.class, ECPublicKey.class, RSAKey.class, RSAMultiPrimePrivateCrtKey.class,
				RSAPrivateCrtKey.class, RSAPrivateKey.class, RSAPrivateKey.class);

		n.todo(AlgorithmParameterSpec.class, DSAGenParameterSpec.class, DSAParameterSpec.class, DSAPrivateKeySpec.class,
				DSAPublicKeySpec.class, ECField.class, ECFieldF2m.class, ECFieldFp.class, ECGenParameterSpec.class,
				ECParameterSpec.class, ECPoint.class, ECPrivateKeySpec.class, ECPublicKeySpec.class,
				EllipticCurve.class, EncodedKeySpec.class, InvalidKeySpecException.class,
				InvalidParameterSpecException.class, KeySpec.class, MGF1ParameterSpec.class, PKCS8EncodedKeySpec.class,
				PSSParameterSpec.class, RSAKeyGenParameterSpec.class, RSAMultiPrimePrivateCrtKeySpec.class,
				RSAOtherPrimeInfo.class, RSAPrivateCrtKeySpec.class, RSAPrivateKeySpec.class, RSAPublicKeySpec.class,
				X509EncodedKeySpec.class);

	}

	private static void todoJseJavaxSecurityAuth(N n) {

		n.todo(AuthPermission.class, Destroyable.class, DestroyFailedException.class, Policy.class,
				PrivateCredentialPermission.class, Refreshable.class, RefreshFailedException.class, Subject.class,
				SubjectDomainCombiner.class);

		n.todo(Callback.class, CallbackHandler.class, ChoiceCallback.class, ConfirmationCallback.class,
				LanguageCallback.class, NameCallback.class, PasswordCallback.class, TextInputCallback.class,
				TextOutputCallback.class, UnsupportedCallbackException.class);

		n.todo(DelegationPermission.class, KerberosKey.class, KerberosPrincipal.class, KerberosTicket.class,
				KeyTab.class, ServicePermission.class);

		n.todo(AccountException.class, AccountExpiredException.class, AccountLockedException.class,
				AccountNotFoundException.class, AppConfigurationEntry.class, Configuration.class,
				ConfigurationSpi.class, CredentialException.class, CredentialExpiredException.class,
				CredentialNotFoundException.class, FailedLoginException.class, LoginContext.class,
				LoginException.class);

		n.todo(LoginModule.class);

		n.todo(X500Principal.class, X500PrivateCredential.class);
	}

	private static void todoJseJavaxSecurityCert(N n) {

		n.todo(Certificate.class, CertificateEncodingException.class, CertificateException.class,
				CertificateExpiredException.class, CertificateNotYetValidException.class,
				CertificateParsingException.class, X509Certificate.class);

	}

	private static void todoJseJavaxSecuritySasl(N n) {

		n.todo(AuthenticationException.class, AuthorizeCallback.class, RealmCallback.class, RealmChoiceCallback.class,
				Sasl.class, SaslClient.class, SaslClientFactory.class, SaslException.class, SaslServer.class,
				SaslServerFactory.class);
	}

	private static void todoJeeJavaxSecurityAuth(N n) {

		n.todo(AuthException.class, AuthStatus.class, ClientAuth.class, MessageInfo.class, MessagePolicy.class,
				ServerAuth.class);

		n.todo(CallerPrincipalCallback.class, CertStoreCallback.class, GroupPrincipalCallback.class,
				PasswordValidationCallback.class, PrivateKeyCallback.class, SecretKeyCallback.class,
				TrustStoreCallback.class);

		n.todo(AuthConfig.class, AuthConfigFactory.class, AuthConfigProvider.class, ClientAuthConfig.class,
				ClientAuthContext.class, RegistrationListener.class, ServerAuthConfig.class, ServerAuthContext.class);

		n.todo(ClientAuthModule.class, ServerAuthModule.class);

	}

	private static void todoJeeJavaxSecurityJacc(N n) {

		n.todo(EJBMethodPermission.class, EJBRoleRefPermission.class, PolicyConfiguration.class,
				PolicyConfigurationFactory.class, PolicyContext.class, PolicyContextException.class,
				PolicyContextHandler.class, WebResourcePermission.class, WebRoleRefPermission.class,
				WebUserDataPermission.class);

	}

	public static void main(String[] args) {
		N n = new N();
		n.setIgnoreDups(true);
		notes(n);
		n.sumUp();
	}

}
