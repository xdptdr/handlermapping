package com.github.xdptdr.notes;

public class Notes {

	/*- http://docs.jboss.org/resteasy/docs/3.0.21.Final/userguide/html/Securing_JAX-RS_and_RESTeasy.html */

	/*-
		<context-param>
			<param-name>resteasy.role.based.security</param-name>
			<param-value>true</param-value>
		</context-param>
	 */

	/*-
		<security-constraint>
			<web-resource-collection>
				<web-resource-name>Resteasy</web-resource-name>
				<url-pattern>/security</url-pattern>
			</web-resource-collection>
			<auth-constraint>
				<role-name>admin</role-name>
				<role-name>user</role-name>
			</auth-constraint>
		</security-constraint>
		
		<login-config>
			<auth-method>BASIC</auth-method>
			<realm-name>Test</realm-name>
		</login-config>
		
		<security-role>
			<role-name>admin</role-name>
		</security-role>
		
		<security-role>
			<role-name>user</role-name>
		</security-role>
	 */

	/*- keytool -genkey -alias mydomain -keyalg rsa -keystore realm.jks */

	/*-
		wburke=user,admin
		loginclient=login
		oauthclient1=oauth,*
		oauthclient2=oauth,user
	 */

	/*- WEB-INF/resteasy-oauth.json
		{
		   "realm" : "mydomain",
		   "admin-role" : "admin",
		   "login-role" : "login",
		   "oauth-client-role" : "oauth",
		   "wildcard-role" : "*",
		   "realm-keystore" : "${jboss.server.config.dir}/realm.jks",
		   "realm-key-alias" : "mydomain",
		   "realm-keystore-password" : "password",
		   "realm-private-key-password" : "password",
		   "access-code-lifetime" : "300",
		   "token-lifetime" : "3600",
		   "truststore" : "${jboss.server.config.dir}/client-truststore.ts",
		   "truststore-password" : "password",
		   "resources" : [
		      "https://example.com/customer-portal",
		      "https://somewhere.com/product-portal"
		   ]
		} 
	 */

	/*- WEB-INF/jboss-web.xml
		<jboss-web>
		    <security-domain>java:/jaas/commerce</security-domain>
		    <valve>
		        <class-name>org.jboss.resteasy.skeleton.key.as7.OAuthAuthenticationServerValve</class-name>
		    </valve>
		</jboss-web>
	 */

	/*- WEB-INF/jboss-deployment-structure.xml
		<jboss-deployment-structure>
		    <deployment>
		        <dependencies>
		            <module name="org.jboss.resteasy.resteasy-jaxrs" services="import"/>
		            <module name="org.jboss.resteasy.resteasy-jackson-provider" services="import"/>
		            <module name="org.jboss.resteasy.skeleton-key"/>
		        </dependencies>
		    </deployment>
		</jboss-deployment-structure>
	 */

	/*- Skeleton 's OAUTH_FORM_ACTION request attribute */

	/*- login.jsp
		<form action="<%= request.getAttribute("OAUTH_FORM_ACTION")%>" method=post>
		    <p><strong>Please Enter Your User Name: </strong>
		    <input type="text" name="j_username" size="25">
		    <p><p><strong>Please Enter Your Password: </strong>
		    <input type="password" size="15" name="j_password">
		    <p><p>
		    <input type="submit" value="Submit">
		    <input type="reset" value="Reset">
		</form>
	 */

	/*- https://localhost:8443/auth-server/j_oauth_realm_info.html */

	/*- OAuthManagedResourceValve config
		{
		  "realm" : "mydomain",
		  "realm-public-key" : "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCO8XXyi7oAq5ecsYy+tJrl54N2TtKAkxuWEDmzvSPU+mUA2/3qHcxucZakG74Z49410tn5IIu2CXXlk9CuKcpXvKh+cPBzmC1Nmbd+4MelRVVZnvogyPICs8h3sNTAMNdfI6hDc5/MfVQQ9m5OZrKbNR3dY50mTi/ExnJ5IWPqxQIDAQAB",
		  "admin-role" : "admin",
		  "auth-url" : "https://localhost:8443/auth-server/login.jsp",
		  "code-url" : "https://localhost:8443/auth-server/j_oauth_resolve_access_code",
		  "truststore" : "REQUIRED",
		  "truststore-password" : "REQUIRED",
		  "client-id" : "REQUIRED",
		  "client-credentials" : {
		    "password" : "REQUIRED"
		  }
		}
	 */

	/*- WEB-INF/jboss-web.xml
		<jboss-web>
		    <valve>
		        <class-name>org.jboss.resteasy.skeleton.key.as7.OAuthManagedResourceValve</class-name>
		    </valve>
		</jboss-web>
	 */

	/*- WEB-INF/jboss-deployment-structure.xml
		<jboss-deployment-structure>
		    <deployment>
		        <dependencies>
		            <module name="org.jboss.resteasy.resteasy-jaxrs" services="import"/>
		            <module name="org.jboss.resteasy.resteasy-jackson-provider" services="import"/>
		            <module name="org.jboss.resteasy.skeleton-key"/>
		        </dependencies>
		    </deployment>
		</jboss-deployment-structure> 
	 */

	/*- https://localhost:8443/auth-server/j_oauth_realm_info.html */

	/*- BearerTokenAuthenticatorValve config
		{
		  "realm" : "mydomain",
		  "realm-public-key" : "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCO8XXyi7oAq5ecsYy+tJrl54N2TtKAkxuWEDmzvSPU+mUA2/3qHcxucZakG74Z49410tn5IIu2CXXlk9CuKcpXvKh+cPBzmC1Nmbd+4MelRVVZnvogyPICs8h3sNTAMNdfI6hDc5/MfVQQ9m5OZrKbNR3dY50mTi/ExnJ5IWPqxQIDAQAB",
		}
	 */

	/*- WEB-INF/jboss-web.xml 
		<jboss-web>
		    <valve>
		        <class-name>org.jboss.resteasy.skeleton.key.as7.BearerTokenAuthenticatorValve</class-name>
		    </valve>
		</jboss-web> 
	 */

	/*- WEB-INF/jboss-deployment-structure.xml
		<jboss-deployment-structure>
		    <deployment>
		        <dependencies>
		            <module name="org.jboss.resteasy.resteasy-jaxrs" services="import"/>
		            <module name="org.jboss.resteasy.resteasy-jackson-provider" services="import"/>
		            <module name="org.jboss.resteasy.skeleton-key"/>
		        </dependencies>
		    </deployment>
		</jboss-deployment-structure>
	 */

	/*-
		ResteasyClient client = new ResteasyClientBuilder().truststore(truststore).build();
	
	    Form form = new Form().param("grant_type", "client_credentials");
	    ResteasyWebTarget target = client.target("https://localhost:8443/auth-server/j_oauth_token_grant");
	    target.configuration().register(new BasicAuthentication("bburke@redhat.com", "password"));
	    AccessTokenResponse res = target.request().post(Entity.form(form), AccessTokenResponse.class);
	 */

	/*-
		try {
	       Response response = client.target("https://localhost:8443/database/products").request().header(HttpHeaders.AUTHORIZATION, "Bearer " + res.getToken()).get();
	       String xml = response.readEntity(String.class);
	    } finally {
	       client.close();
	    }
	 */

	/*
	 * - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	 */
	
	/*- https://docs.jboss.org/author/pages/viewpage.action?pageId=66322705 */
	
	/*-
	 * - JSSE (pure Java)
	 * - OpenSSL (native)
	 */
	
	/*- JSSE */
	
	/*- keytool -genkey -alias foo -keyalg RSA -keystore foo.keystore -validity 10950
		Keystore password: secret
		First and last name : foo.acme.com
		Name of organizational unit : Foo
		Name of your organization : acme corp
		Name of city or locality : Duckburg
		Name of state or province : Duckburg
		Two-letter country code  : WD
		Password for <deva> secret : secret
	 */
	
	/*-
		<subsystem xmlns="urn:jboss:domain:web:1.1" default-virtual-server="default-host" native="false">
			<connector name="http" protocol="HTTP/1.1" scheme="http" socket-binding="http"  redirect-port="443" />
			<connector name="https" scheme="https" protocol="HTTP/1.1" socket-binding="https" enable-lookups="false" secure="true">
				<ssl name="foo-ssl" password="secret" protocol="TLSv1" key-alias="foo" certificate-key-file="../standalone/configuration/foo.keystore" />
			</connector>
		</subsystem>
	 */
	
	/*- OpenSSL */
	
	/*- openssl genrsa -des3 -out foo.pem 1024
		Passphrase : secret
	 */
	
	/*- openssl req -new -x509 -key foo.pem -out foo-cert.pem -days 10950
		Country name : WD
		State or province : Duckburg
		Locality : Duckburg
		Organization : Acme Corp
		Organizational unit : Foo
		Common name : foo.acme.com
		Email address :
	 */
	
	/*- openssl pkcs12 -export -in foo-cert.pem -inkey foo.pem  -out foo.p12 */
	
	/*-
		<subsystem xmlns="urn:jboss:domain:web:1.1" default-virtual-server="default-host" native="true">
			<connector name="http" protocol="HTTP/1.1" scheme="http" socket-binding="http" redirect-port="443" />
			<connector name="https" scheme="https" protocol="HTTP/1.1" socket-binding="https" enable-lookups="false" secure="true">
				<ssl name="foo-ssl" password="secret" certificate-key-file="../standalone/configuration/foo.pem" certificate-file="../standalone/configuration/foo-cert.pem"/>
			</connector>
		</subsystem>
	 */

	/*- Port configuration */
	
	/*-
		<socket-binding-group name="standard-sockets" default-interface="public" ...>
			<socket-binding name="http" port="80" />
			<socket-binding name="https" port="443" />
			...
		</socket-binding-group>
	*/
	
	/*- https://docs.jboss.org/author/display/WFLY10/How+do+I+migrate+my+application+from+AS7+to+WildFly */
	
	/*
	 * - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	 */
}
