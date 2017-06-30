package com.github.xdptdr.notes.jaspic.dom;

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

import javassist.tools.Callback;

public class Notes {

	private static void notes(N n) {

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

		todoJseJavaxSecurityAuth(n);
		todoJseJavaxSecurityCert(n);
		todoJseJavaxSecuritySasl(n);

		todoJeeJavaxSecurityAuth(n);
		todoJeeJavaxSecurityJacc(n);

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
		notes(n);
		n.sumUp();
	}

}
