package com.github.xdptdr.jca;

import java.io.Externalizable;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.security.Principal;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Set;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.naming.Referenceable;
import javax.resource.AdministeredObjectDefinition;
import javax.resource.AdministeredObjectDefinitions;
import javax.resource.ConnectionFactoryDefinition;
import javax.resource.ConnectionFactoryDefinitions;
import javax.resource.ResourceException;
import javax.resource.cci.Connection;
import javax.resource.cci.ConnectionFactory;
import javax.resource.cci.ConnectionMetaData;
import javax.resource.cci.ConnectionSpec;
import javax.resource.cci.IndexedRecord;
import javax.resource.cci.Interaction;
import javax.resource.cci.InteractionSpec;
import javax.resource.cci.LocalTransaction;
import javax.resource.cci.MappedRecord;
import javax.resource.cci.MessageListener;
import javax.resource.cci.Record;
import javax.resource.cci.RecordFactory;
import javax.resource.cci.ResourceAdapterMetaData;
import javax.resource.cci.ResourceWarning;
import javax.resource.cci.ResultSetInfo;
import javax.resource.spi.Activation;
import javax.resource.spi.ActivationSpec;
import javax.resource.spi.AdministeredObject;
import javax.resource.spi.BootstrapContext;
import javax.resource.spi.ConfigProperty;
import javax.resource.spi.ConnectionDefinition;
import javax.resource.spi.ConnectionDefinitions;
import javax.resource.spi.ConnectionEvent;
import javax.resource.spi.ConnectionEventListener;
import javax.resource.spi.ConnectionManager;
import javax.resource.spi.ConnectionRequestInfo;
import javax.resource.spi.Connector;
import javax.resource.spi.LazyAssociatableConnectionManager;
import javax.resource.spi.LazyEnlistableConnectionManager;
import javax.resource.spi.ManagedConnection;
import javax.resource.spi.ManagedConnectionFactory;
import javax.resource.spi.ManagedConnectionMetaData;
import javax.resource.spi.ResourceAdapter;
import javax.resource.spi.ResourceAdapterAssociation;
import javax.resource.spi.TransactionSupport;
import javax.resource.spi.ValidatingManagedConnectionFactory;
import javax.resource.spi.endpoint.MessageEndpoint;
import javax.resource.spi.endpoint.MessageEndpointFactory;
import javax.resource.spi.security.PasswordCredential;
import javax.resource.spi.work.ExecutionContext;
import javax.resource.spi.work.HintsContext;
import javax.resource.spi.work.TransactionContext;
import javax.resource.spi.work.Work;
import javax.resource.spi.work.WorkContext;
import javax.resource.spi.work.WorkContextLifecycleListener;
import javax.resource.spi.work.WorkContextProvider;
import javax.resource.spi.work.WorkEvent;
import javax.resource.spi.work.WorkException;
import javax.resource.spi.work.WorkListener;
import javax.resource.spi.work.WorkManager;
import javax.resource.spi.work.WorkRejectedException;
import javax.security.auth.Subject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transaction;
import javax.transaction.TransactionManager;
import javax.transaction.TransactionSynchronizationRegistry;
import javax.transaction.xa.XAException;
import javax.transaction.xa.XAResource;
import javax.transaction.xa.Xid;

import org.ietf.jgss.GSSCredential;
import org.omg.CORBA.portable.Streamable;

import com.github.xdptdr.bouip.BouipConnection;
import com.github.xdptdr.bouip.FSWResourceAdapter;
import com.github.xdptdr.splout.MyManagedConnectionFactory;
import com.github.xdptdr.splout.MyWork;
import com.github.xdptdr.splout.SploutActivationSpec;
import com.github.xdptdr.splout.SploutConnectionManager;
import com.github.xdptdr.splout.SploutConnectionRequestInfo;

public class DummyServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			doStuff();
		} catch (ResourceException | NoSuchMethodException | SecurityException | NamingException | XAException
				| InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}

	public void doStuff() throws ResourceException, NoSuchMethodException, SecurityException, NamingException,
			XAException, InstantiationException, IllegalAccessException {

		// 3.5

		MessageEndpointFactory.class.getName();

		// RAR : Resource Adapter Archive

		// endpointActivation)

		ResourceAdapter.class.getName();

		MessageEndpoint.class.getName();

		// 5.3

		BootstrapContext bc = new MyBootstrapContext();
		WorkManager wm = bc.getWorkManager();

		ResourceAdapter ra = new FSWResourceAdapter();
		ra.start(bc);
		ra.stop();

		// 5.3.1

		Connector.class.getName();

		FSWResourceAdapter con = new FSWResourceAdapter();

		ManagedConnectionFactory mcf = new MyManagedConnectionFactory();

		ActivationSpec as = new SploutActivationSpec();

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
		Connection c = new BouipConnection();

		ConnectionManager cm = new SploutConnectionManager();

		ConnectionEventListener cel = new MyConnectionEventListener();

		XAResource xar = new MyXAResource();
		LocalTransaction ltCCI = new MyLocalTransactionCCI();
		javax.resource.spi.LocalTransaction ltSPI = new MyLocalTransactionSPI();

		// 6.4.1

		// res-ref-name: eis/MyEIS
		// res-type: javax.resource.cci.ConnectionFactory
		// res-auth: Application
		// res-auth: Container

		Context context = new InitialContext();
		Object lookedUp = context.lookup("java:comp/env/eis/MyEIS");

		// 6.4.3

		{
			Connection connection = null;
			try {
				connection = cf.getConnection();
			} finally {
				if (connection != null) {
					connection.close();
				}
			}
		}

		// 6.5

		ConnectionManager.class.getName();
		ManagedConnectionFactory.class.getName();
		ManagedConnection.class.getName();
		ManagedConnectionMetaData.class.getName();
		ConnectionEventListener.class.getName();
		javax.resource.spi.LocalTransaction.class.getName();

		ConnectionFactory.class.getName();
		Connection.class.getName();

		XAResource.class.getName();

		// 6.5.1

		{
			Connection connection = cf.getConnection();
			connection.close();
		}

		// 6.5.1.1

		ConnectionRequestInfo cri = new SploutConnectionRequestInfo();
		cm.allocateConnection(mcf, cri);

		// 6.5.1.3

		// Object stored in JNDI must be Serializable

		Referenceable r = new MyReferenceableRESOURCE();

		/*
		 * A connection factory implementation class must implement the
		 * interface javax.resource.Referenceable.
		 */

		// 6.5.2

		cm.allocateConnection(mcf, cri);

		// 6.5.3

		Subject subject = new Subject();
		{
			ConnectionFactory connectionFactory = (ConnectionFactory) mcf.createConnectionFactory();
			mcf.createManagedConnection(subject, cri);
		}

		// 6.5.3.4

		ValidatingManagedConnectionFactory vmcf = new MyValidatingManagedConnectionFactory();
		Set connections = null;
		vmcf.getInvalidConnections(connections);

		// 6.5.3.5

		ManagedConnection managedConnection = mcf.createManagedConnection(subject, null);
		XAResource xaResource = managedConnection.getXAResource();
		xaResource.recover(0);

		// 6.5.4

		managedConnection.getXAResource();
		managedConnection.getLocalTransaction();

		Connection flop = (Connection) managedConnection.getConnection(subject, cri);
		/*
		 * A ManagedConnection instance may use the getConnection method to
		 * change the state of the physical connection based on the Subject and
		 * ConnectionRequestInfo arguments, i.e. for re-authentication
		 */
		managedConnection.addConnectionEventListener(cel);
		managedConnection.removeConnectionEventListener(cel); // think abuot
																// synchronized

		ManagedConnectionMetaData metadata = managedConnection.getMetaData();

		// 6.5.4.3

		ManagedConnection blop = mcf.matchManagedConnections(connections, subject, cri);

		// 6.5.4.4

		managedConnection.cleanup();

		// 6.5.6

		ConnectionEvent ce = new ConnectionEvent(managedConnection, 0);
		cel.localTransactionStarted(ce);
		cel.localTransactionCommitted(ce);
		cel.localTransactionRolledback(ce);
		cel.connectionErrorOccurred(ce);
		cel.connectionClosed(ce);

		// 6.5.7

		new Integer(ConnectionEvent.LOCAL_TRANSACTION_STARTED);
		new Integer(ConnectionEvent.LOCAL_TRANSACTION_COMMITTED);
		new Integer(ConnectionEvent.LOCAL_TRANSACTION_ROLLEDBACK);
		new Integer(ConnectionEvent.CONNECTION_ERROR_OCCURRED);
		new Integer(ConnectionEvent.CONNECTION_CLOSED);

		// 6.6

		PrintWriter pw = null;
		mcf.setLogWriter(pw);
		mcf.getLogWriter();

		managedConnection.setLogWriter(pw);
		managedConnection.getLogWriter();

		// 6.8.3.2

		managedConnection.destroy();

		// 6.10.1

		ManagedConnectionFactory.class.getName();
		ManagedConnection.class.getName();
		ManagedConnectionMetaData.class.getName();
		ConnectionManager.class.getName();

		// 7.1

		// Two types of transaction management:
		// - transaction manager external to the resource manager : JTA or XA
		// - transaction manager internal to the resource manager :local
		// transactions*

		XAResource.class.getName();

		// 7.2.1

		// interesting paragraph about how transactions work across several
		// resource managers

		// 7.2.2

		// - container managed transaction
		// - component managed transaction

		// 7.3

		xaResource = managedConnection.getXAResource();
		javax.resource.spi.LocalTransaction lt = managedConnection.getLocalTransaction();

		// 7.3.2

		// X/Open CAE Specification -- Distributed Transaction Processing: the
		// XA Specification, X/Open document

		// 7.4

		// JTA : Java Transaction API
		// JTS : Java Transaction Service
		// - binds CORBA OTS 1.1 using IIOP
		// - CORBA: Common Object Request Broker Architecture
		// - OTS: Object Transaction Service
		// - IIOP : Internet Inter-ORB protocol
		// - ORB : Object Request Broker

		// 7.4.1

		TransactionManager.class.getName();
		Transaction.class.getName();

		// 7.6.2.2

		// one phase commit

		Xid xid = new MyXid();
		xaResource.commit(xid, true);

		// 7.6.2.3

		// two phase commit

		// 2PC Protocol Definition
		// OSI TP
		// - TP: Transaction Protocol
		// ISO92

		xaResource.prepare(xid);
		xaResource.forget(xid);

		// 7.6.2.4

		xaResource.start(xid, 0);
		xaResource.end(xid, 0);

		// 7.6.3

		// JTA, JTS, X/Open

		// 7.7

		javax.resource.spi.LocalTransaction.class.getName();
		LocalTransaction.class.getName();

		// 7.13

		TransactionSupport.TransactionSupportLevel.NoTransaction.name();
		TransactionSupport.TransactionSupportLevel.LocalTransaction.name();
		TransactionSupport.TransactionSupportLevel.XATransaction.name();

		TransactionSupport ts = new MyTransactionSupport();
		ts.getTransactionSupport();

		// 7.14

		TransactionSynchronizationRegistry tsr = TransactionSynchronizationRegistry.class.newInstance();
		bc.getTransactionSynchronizationRegistry();

		// 7.16.1

		LazyAssociatableConnectionManager lacm = new MyLazyAssociatableConnectionManager();

		// 7.16.2

		LazyEnlistableConnectionManager lecm = new MyLazyEnlistableConnectionManager();

		// 8.4

		// res-auth : Application or Container

		// 8.5

		// BasicPassword
		// Kerbv5

		// authentication-mechanism-type

		// 8.5.2

		// Configured Identity
		// Principal Mapping
		// Caller Impersonation
		// Credentials Mapping

		// 8.6.3

		// JAAS

		// 9

		Subject.class.getName();
		Principal.class.getName();
		GSSCredential.class.getName();
		PasswordCredential.class.getName();

		// 10.3

		wm = bc.getWorkManager();

		Work work = new MyWork();
		wm.doWork(work);
		wm.startWork(work);
		wm.scheduleWork(work);

		work.run();
		work.release();

		WorkEvent we = new WorkEvent(null, 0, work, new WorkException());
		we.getType();
		we.getWork();
		we.getStartDuration();
		we.getException();

		ExecutionContext ec = new ExecutionContext();
		ec.getXid();
		ec.getTransactionTimeout();

		WorkListener wl = new MyWorkListener();
		wl.workAccepted(we);
		wl.workStarted(we);
		wl.workCompleted(we);
		wl.workRejected(we);

		WorkRejectedException wre = new WorkRejectedException();
		wre.getErrorCode();
		wre.setErrorCode("errorCode");

		// 11

		WorkContext wc = new MyWorkContext();
		wc.getName();
		wc.getDescription();

		WorkContextProvider wcp = new MyWorkContextProvider();
		wcp.getWorkContexts();

		// 11.5

		TransactionContext tc = new TransactionContext();
		tc.getName();
		tc.getDescription();
		tc.getTransactionTimeout();
		tc.getXid();

		// 11.6

		HintsContext hc = new HintsContext();
		hc.getDescription();
		hc.getHints();
		hc.getName();

		// 11.6.1.1

		new Boolean(HintsContext.NAME_HINT.equals("javax.resource.name"));
		new Boolean(HintsContext.LONGRUNNING_HINT.equals("javax.resource.LongRunning"));

		// 11.7

		WorkContextLifecycleListener wcll = new MyWorkContextLifecycleListener();

		// 13

		MessageEndpointFactory endpointFactory = MessageEndpointFactory.class.newInstance();

		ra.endpointActivation(endpointFactory, as);
		ra.endpointDeactivation(endpointFactory, as);
		ra.getXAResources(new ActivationSpec[] { as });

		as.validate();

		Method method = Class.class.getMethod("forName", String.class);
		endpointFactory.createEndpoint(xaResource);
		endpointFactory.isDeliveryTransacted(method);

		MessageEndpoint me = MessageEndpoint.class.newInstance();
		me.beforeDelivery(method);
		me.afterDelivery();
		me.release();

		// 13.4.1

		// mdb.xml

		// 13.7 : JMS use case

		// sample JMS resource adapter deployment descriptor

		// 13.8 : Non JMS use case

		// 17

		ConnectionFactory.class.getName();
		Connection.class.getName();
		ConnectionSpec.class.getName();
		LocalTransaction.class.getName();

		Interaction.class.getName();
		InteractionSpec.class.getName();

		MessageListener.class.getName();

		Record.class.getName();
		MappedRecord.class.getName();
		IndexedRecord.class.getName();
		RecordFactory.class.getName();
		Streamable.class.getName();
		ResultSet.class.getName();

		ResultSetMetaData.class.getName();

		ConnectionMetaData.class.getName();
		ResourceAdapterMetaData.class.getName();
		ResultSetInfo.class.getName();

		ResourceException.class.getName();
		ResourceWarning.class.getName();

		// 18.3.1

		// metadata-complete
		// Connector 1.6 Deployment Descriptor (ra.xml)

		// resourceadapter-class

		new Boolean(new FSWResourceAdapter() instanceof ResourceAdapter);
		FSWResourceAdapter.class.getAnnotation(Connector.class).description();
		FSWResourceAdapter.class.getAnnotation(Connector.class).displayName();
		FSWResourceAdapter.class.getAnnotation(Connector.class).smallIcon();
		FSWResourceAdapter.class.getAnnotation(Connector.class).largeIcon();
		FSWResourceAdapter.class.getAnnotation(Connector.class).vendorName();
		FSWResourceAdapter.class.getAnnotation(Connector.class).eisType();
		FSWResourceAdapter.class.getAnnotation(Connector.class).version();
		FSWResourceAdapter.class.getAnnotation(Connector.class).licenseDescription();
		FSWResourceAdapter.class.getAnnotation(Connector.class).licenseRequired();
		FSWResourceAdapter.class.getAnnotation(Connector.class).authMechanisms();
		FSWResourceAdapter.class.getAnnotation(Connector.class).reauthenticationSupport();
		FSWResourceAdapter.class.getAnnotation(Connector.class).securityPermissions();
		FSWResourceAdapter.class.getAnnotation(Connector.class).transactionSupport();
		FSWResourceAdapter.class.getAnnotation(Connector.class).requiredWorkContexts();

		MyConfigPropertyAnnotatedClass.class.getAnnotation(ConfigProperty.class).type();
		MyConfigPropertyAnnotatedClass.class.getAnnotation(ConfigProperty.class).description();
		MyConfigPropertyAnnotatedClass.class.getAnnotation(ConfigProperty.class).defaultValue();
		MyConfigPropertyAnnotatedClass.class.getAnnotation(ConfigProperty.class).ignore();
		MyConfigPropertyAnnotatedClass.class.getAnnotation(ConfigProperty.class).supportsDynamicUpdates();
		MyConfigPropertyAnnotatedClass.class.getAnnotation(ConfigProperty.class).confidential();

		ResourceAdapter.class.getName();
		ManagedConnectionFactory.class.getName();
		AdministeredObject.class.getName();
		ActivationSpec.class.getName();

		// 18.6

		ManagedConnectionFactory.class.getAnnotation(ConnectionDefinition.class).connectionFactory();
		ManagedConnectionFactory.class.getAnnotation(ConnectionDefinition.class).connectionFactoryImpl();
		ManagedConnectionFactory.class.getAnnotation(ConnectionDefinition.class).connection();
		ManagedConnectionFactory.class.getAnnotation(ConnectionDefinition.class).connectionImpl();

		ManagedConnectionFactory.class.getAnnotation(ConnectionDefinitions.class).value();

		// 18.7

		ActivationSpec.class.getAnnotation(Activation.class).messageListeners();

		// 18.8

		MyAdministeredObject.class.getAnnotation(AdministeredObject.class).adminObjectInterfaces();

		// if the annotation is missing, the following interfaces are ignored
		// when determining the admin object interfaces
		Serializable.class.getName();
		Externalizable.class.getName();
		ResourceAdapterAssociation.class.getName();
		// if there are multiple remaining interfaces, the annotation is
		// mandatory

		// 18.9

		ConnectionFactoryDefinition.class.getName();
		AdministeredObjectDefinition.class.getName();

		/*
		 * When a resource adapter RAR packaged within a Java EE application EAR
		 * needs to be referenced, the resource adapter name may be prefixed
		 * with a “#” character to portably refer to the embedded resource
		 * adapter within the EAR. As an example, a Servlet bundled in an
		 * enterprise archive EAR, may access the embedded resource adapter
		 * foo.rar in the EAR, by using the name “#foo”.
		 */

		// 18.9.1

		// connection-factory

		Class.class.getAnnotation(ConnectionFactoryDefinition.class).name();
		Class.class.getAnnotation(ConnectionFactoryDefinition.class).description();
		Class.class.getAnnotation(ConnectionFactoryDefinition.class).resourceAdapter();
		Class.class.getAnnotation(ConnectionFactoryDefinition.class).interfaceName();
		Class.class.getAnnotation(ConnectionFactoryDefinition.class).transactionSupport();
		Class.class.getAnnotation(ConnectionFactoryDefinition.class).maxPoolSize();
		Class.class.getAnnotation(ConnectionFactoryDefinition.class).minPoolSize();
		Class.class.getAnnotation(ConnectionFactoryDefinition.class).properties();

		// 18.9.2

		Class.class.getAnnotation(ConnectionFactoryDefinitions.class).value();

		// 18.9.3

		// administered-object

		Class.class.getAnnotation(AdministeredObjectDefinition.class).name();
		Class.class.getAnnotation(AdministeredObjectDefinition.class).description();
		Class.class.getAnnotation(AdministeredObjectDefinition.class).resourceAdapter();
		Class.class.getAnnotation(AdministeredObjectDefinition.class).className();
		Class.class.getAnnotation(AdministeredObjectDefinition.class).interfaceName();
		Class.class.getAnnotation(AdministeredObjectDefinition.class).properties();

		// 18.9.4

		Class.class.getAnnotation(AdministeredObjectDefinitions.class).value();

		// 19.4.1

		MessageEndpointFactory.class.getName();
		ActivationSpec.class.getName();
		ManagedConnection.class.getName();

		// 19.4.2

		ResourceAdapter.class.getName();
		ManagedConnectionFactory.class.getName();
		ConnectionRequestInfo.class.getName();
		Principal.class.getName();
		GSSCredential.class.getName();
		PasswordCredential.class.getName();
		Record.class.getName();

		// 20

		// Resource Adapter Archive : *.rar

		// Deployment descriptor : META-INF/ra.xml

		// 20.4

	}
}
