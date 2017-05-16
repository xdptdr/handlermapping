package com.github.xdptdr.jca;

import java.io.IOException;

import javax.resource.ResourceException;
import javax.resource.cci.Connection;
import javax.resource.cci.ConnectionFactory;
import javax.resource.cci.LocalTransaction;
import javax.resource.spi.ActivationSpec;
import javax.resource.spi.BootstrapContext;
import javax.resource.spi.ConfigProperty;
import javax.resource.spi.ConnectionEventListener;
import javax.resource.spi.ConnectionManager;
import javax.resource.spi.Connector;
import javax.resource.spi.ManagedConnectionFactory;
import javax.resource.spi.ResourceAdapter;
import javax.resource.spi.ResourceAdapterAssociation;
import javax.resource.spi.endpoint.MessageEndpoint;
import javax.resource.spi.endpoint.MessageEndpointFactory;
import javax.resource.spi.work.WorkManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.xa.XAResource;

@WebServlet("/jcaservlet")
public class JCAServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			doStuff();
		} catch (ResourceException | NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
	}

	public void doStuff() throws ResourceException, NoSuchMethodException, SecurityException {

		// 3.5

		MessageEndpointFactory.class.getName();

		// RAR : Resource Adapter Archive

		// endpointActivation)

		ResourceAdapter.class.getName();

		MessageEndpoint.class.getName();

		// 5.3

		BootstrapContext bc = new MyBootstrapContext();
		WorkManager wm = bc.getWorkManager();

		ResourceAdapter ra = new MyResourceAdapter();
		ra.start(bc);
		ra.stop();

		// 5.3.1

		Connector.class.getName();

		MyConnectorAnnotatedClass con = new MyConnectorAnnotatedClass();

		ManagedConnectionFactory mcf = new MyManagedConnectionFactory();

		ActivationSpec as = new MyActivationSpec();

		// 5.3.2

		ResourceAdapterAssociation raa = new MyResourceAdapterAssociation();

		raa.setResourceAdapter(ra);
		raa.getResourceAdapter();

		{
			/*
			 * Prior to using a ManagedConnectionFactory JavaBean, the
			 * application server must create an association between the
			 * ManagedConnectionFactory JavaBean and a ResourceAdapter JavaBean,
			 * by calling the setResourceAdapter method on the
			 * ManagedConnectionFactory JavaBean.
			 */
			raa.setResourceAdapter(ra);

			// => does this mean that every ManagedConnectionFactory
			// implementation must also implement ResourceAdapterAssociation ?
		}

		// 5.3.3

		as.setResourceAdapter(ra);
		as.getResourceAdapter();

		/*
		 * The ResourceAdapterAssociation interface specifies the methods to
		 * associate an ActivationSpec JavaBean with a ResourceAdapter JavaBean.
		 */

		// => how ? ResourceAdapterAssociation only defines a ResourceAdapter
		// getter/setter

		{
			/*
			 * Prior to using an ActivationSpec JavaBean, the application server
			 * must create an association between the ActivationSpec JavaBean
			 * and a ResourceAdapter JavaBean, by calling the setResourceAdapter
			 * method on the ActivationSpec JavaBean.
			 */

			as.setResourceAdapter(ra);
		}

		// 5.3.4

		ra.stop();

		// 5.3.5

		ra.start(bc);
		// ...
		ra.stop();

		// 5.3.7.6

		// config-property-supports-dynamicupdates

		MyConfigPropertyAnnotatedClass.class.getMethod("getProp").getAnnotation(ConfigProperty.class)
				.supportsDynamicUpdates();

		// config-property-confidential

		MyConfigPropertyAnnotatedClass.class.getMethod("getProp").getAnnotation(ConfigProperty.class).confidential();

		// 6.3.1

		ConnectionFactory cf = new MyConnectionFactory();
		Connection c = new MyConnection();

		ConnectionManager cm = new MyConnectionManager();

		ConnectionEventListener cel = new MyConnectionEventListener();

		XAResource xar = new MyXAResource();
		LocalTransaction ltCCI = new MyLocalTransactionCCI();
		javax.resource.spi.LocalTransaction ltSPI = new MyLocalTransactionSPI();
		
		// 6.4
	}
}
