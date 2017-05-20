package com.github.xdptdr.jee7;

import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Set;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.resource.ResourceException;
import javax.resource.cci.Connection;
import javax.resource.cci.ConnectionFactory;
import javax.resource.spi.ActivationSpec;
import javax.resource.spi.BootstrapContext;
import javax.resource.spi.ConfigProperty;
import javax.resource.spi.ConnectionEvent;
import javax.resource.spi.ConnectionEventListener;
import javax.resource.spi.ConnectionManager;
import javax.resource.spi.ConnectionRequestInfo;
import javax.resource.spi.Connector;
import javax.resource.spi.LocalTransaction;
import javax.resource.spi.ManagedConnection;
import javax.resource.spi.ManagedConnectionFactory;
import javax.resource.spi.ManagedConnectionMetaData;
import javax.resource.spi.ResourceAdapter;
import javax.resource.spi.ResourceAdapterAssociation;
import javax.resource.spi.ValidatingManagedConnectionFactory;
import javax.resource.spi.work.Work;
import javax.resource.spi.work.WorkManager;
import javax.security.auth.Subject;
import javax.sql.DataSource;
import javax.transaction.Transaction;
import javax.transaction.TransactionManager;
import javax.transaction.xa.XAException;
import javax.transaction.xa.XAResource;
import javax.transaction.xa.Xid;

public class Reading {

	public static enum RS {
		UNTOUCHED, STARTED, COMPLETED
	}

	private String section;
	private BootstrapContext boostrapContext;
	private WorkManager workManager;
	private ManagedConnectionFactory managedConnectionFactory;
	private ActivationSpec activationSpec;
	private Work work;
	private ResourceAdapter resourceAdapter;
	@SuppressWarnings("unused")
	private LocalTransaction localTransaction;
	private XAResource xaResource;
	private int recoverFlags;
	@SuppressWarnings("unused")
	private Xid[] xids;
	private DataSource dataSource;
	@SuppressWarnings("unused")
	private java.sql.Connection connectionSQL;
	@SuppressWarnings("rawtypes")
	private Set connectionSet;
	private Subject subject;
	private ConnectionFactory connectionFactory;
	private String jndiName;
	private Connection connection;
	private ConnectionManager connectionManager;
	private ConnectionRequestInfo connectionRequestInfo;
	private ManagedConnection managedConnection;
	private ConnectionEventListener connectionEventListener;
	private ManagedConnectionMetaData managedConnectionMetaData;
	private ConnectionEvent connectionEvent;
	private PrintWriter printWriter;
	private Xid xid;
	private int startFlags;
	private int endFlags;
	private boolean phaseCommitProtocol;
	private TransactionManager transactionManager;
	private Transaction transaction;

	@SuppressWarnings("unused")
	public void reading() throws ResourceException, NamingException, SQLException, XAException {

		section("1.4", RS.COMPLETED);

		/*
		 * JDBC 3.0 specifies the relationship of JDBC to the SPI specified in
		 * JCA.
		 */

		section("2.2.1", RS.COMPLETED);

		/*
		 * JCA reduces the scope of the integration problem from m*n to m+n
		 */

		section("5", RS.COMPLETED);
		section("5.3", RS.COMPLETED);

		/* application server implements BootstrapContext and WorkManager */

		section("5.3.1", RS.COMPLETED);

		/*
		 * implementation class name of the resource adapter is specified in the
		 * resource adapter deployment descriptor or trough the Connector
		 * annotation
		 */

		Connector.class.isAnnotation();

		/* a resource adapter must be a JavaBean */

		/* the resource adapter bean is created during deployment */

		/* bootstrapping a resource adapter involves calling its start method */

		resourceAdapter.start(boostrapContext);

		/*
		 * resource adapters are singleton beans, but may be replicated when
		 * using several jvms
		 */

		/*
		 * resource adapters must implement the equals method so that the
		 * container may distinguish between multiple instances of a resource
		 * adapter configured differently (my interpretation)
		 */

		resourceAdapter.equals(resourceAdapter);

		/*
		 * the BootstrapContext contains references to application servers
		 * facilities, such as the WorkManager
		 */

		boostrapContext.getWorkManager();
		boostrapContext.getTransactionSynchronizationRegistry();
		boostrapContext.getXATerminator();

		/*
		 * within the start method, a resource adapter may use the work manager,
		 * but should avoid using doWork
		 */

		/* the call to start should be fast */

		{ // within start
			workManager = boostrapContext.getWorkManager();
			workManager.doWork(work); // avoid
			workManager.scheduleWork(work); // prefer
			workManager.startWork(work); // prefer
		}

		/*
		 * a resource adapter may hold references to a ManagedConnectionFactory,
		 * an ActivationSpec, or other private objects
		 */

		/* ManagedConnectionFactory provides outbound connectivity */

		/* ActivationSpec provides inbound connectivity */

		/*
		 * A ResourceAdapter may hold references to several
		 * ManagedConnectionFactory and several ActivationSpec
		 */

		section("5.3.2", RS.COMPLETED);

		/* ManagedConnectionFactory represents outbound connectivity */

		/*
		 * implementing ResourceAdapterAssociation allows a
		 * ManagedConnectionFactory instance to be linked to its ResourceAdapter
		 */

		{

			((ResourceAdapterAssociation) managedConnectionFactory).setResourceAdapter(resourceAdapter);
		}

		/*
		 * setResourceAdapter must be called only once, the association must not
		 * change after
		 */

		section("5.3.3", RS.COMPLETED);

		/* ActivationSpec represents outbound connectivity */

		{

			activationSpec.setResourceAdapter(resourceAdapter);

		}

		section("5.3.4", RS.COMPLETED);

		/*
		 * a resource adapter may shutdown because the it is being undeployed or
		 * because the application server is being shutdown
		 */

		section("5.3.4.1", RS.COMPLETED);

		/* phase 1 includes deactivating all messages endpoints */

		/*
		 * there may be a delay because some applications may still be using the
		 * resource adapter at the time shutdown is requested
		 */

		section("5.3.4.2", RS.COMPLETED);

		// phase 2 includes stopping the resource adapter
		{
			resourceAdapter.stop();
		}

		// exceptions during stopping are logged at best

		section("5.3.5", RS.COMPLETED);

		{
			resourceAdapter.start(boostrapContext);
			// ...
			resourceAdapter.stop();
		}

		section("5.3.6", RS.COMPLETED);

		/*
		 * resource adapter specific objects should register them with the
		 * resource adapter
		 */

		{
			((ResourceAdapterAssociation) managedConnectionFactory).setResourceAdapter(resourceAdapter);
			activationSpec.setResourceAdapter(resourceAdapter);

		}

		/*
		 * the resource adapter threads should periodically poll the resource
		 * adapter state, and use bounded blocking I/O
		 */

		section("5.3.7", RS.COMPLETED);

		/* the resource adapter instance is created during deployment */

		/*
		 * ManagedConnectionFactory and ActivationSpec can be instantiated any
		 * time during the lifetime of the resource adapter
		 */

		section("5.3.7.3", RS.COMPLETED);

		/*
		 * if a resource adapter and a managed connection factory both define
		 * the bean property P
		 * 
		 * and if P is defined on the resource adapter's configuration
		 * 
		 * then the managed connection factory will inherit the value specified
		 * on the resource adapter specification
		 */

		section("5.3.7.4", RS.COMPLETED);

		/* above also applies to instances of ActivationSpec */

		section("5.3.7.5", RS.COMPLETED);

		/*
		 * since resource adapters, managed connection factories and activation
		 * specifications are java beans, they can use the Bean Validation
		 * annotations
		 */

		section("5.3.7.6", RS.COMPLETED);

		/*
		 * dynamic configuration properties : use
		 * config-property-supports-dynamicupdates in XML or the following:
		 */

		constructANewInstanceOf(ConfigProperty.class).supportsDynamicUpdates();

		/*
		 * JavaBean Validation should be performed each time a dynamic resource
		 * property is modified
		 */

		/*
		 * application servers are not required to support dynamic resource
		 * adapter configuration
		 */

		/*
		 * confidential properties can be indicated with
		 * config-property-confidential in XML or the follownig:
		 */

		constructANewInstanceOf(ConfigProperty.class).confidential();

		section("5.3.7.7", RS.COMPLETED);

		section("5.3.8", RS.COMPLETED);

		/* lifecycle management may also be used in a non-managed environment */

		section("6", RS.STARTED);
		section("6.1", RS.COMPLETED);
		section("6.2", RS.COMPLETED);
		section("6.3", RS.COMPLETED);
		section("6.3.1", RS.COMPLETED);

		toReadAgain();

		section("6.4", RS.COMPLETED);

		section("6.4.1", RS.COMPLETED);
		/*
		 * The following information are necessary to describe an EJB connection
		 * factory reference in the deployment descriptor
		 */

		// res-ref-name : JNDI name
		// res-type : javax.resource.cci.ConnectionFactory
		// res-auth : one of : Application, Container

		{ // during deployment
			resourceAdapter = constructANewInstanceOf(ResourceAdapter.class);
		}

		{ // within application
			Context context = new InitialContext();
			connectionFactory = (ConnectionFactory) context.lookup(jndiName);
		}

		{ // what the application server do to binds the jndi name
			connection = connectionFactory.getConnection();
		}

		{// the application uses the connection
			connection.getMetaData();
			// etc..
			connection.close();
		}

		section("6.4.2", RS.COMPLETED);

		/* not many details here */

		section("6.4.3", RS.COMPLETED);

		/* connection handles are lightweight object */

		/*
		 * creation of connection handles does not necessarily imply creation of
		 * underlying physical connection
		 */

		/* ManagedConnection represents the underlying physical connection */

		/* caching connection handles has no benefit */

		{ // recommend pattern :
			try {
				connection = connectionFactory.getConnection();
			} finally {
				if (connection != null) {
					connection.close();
				}
			}
		}

		section("6.5", RS.COMPLETED);
		section("6.5.1", RS.COMPLETED);

		{ // connection factory is used to get connections
			connection = connectionFactory.getConnection();
		}

		/* resource adapters are not required to use CCI, but are advised to */

		{
			// a resource adapter may use DataSource or javax.sql.Connection
			// instead, or anything else

			java.sql.Connection connectionSQL = dataSource.getConnection();
		}

		section("6.5.1.1", RS.COMPLETED);

		/*
		 * in JDBC, the implementation of DataSource is provided by the
		 * application server
		 */

		/*
		 * in JCA, it would have been required to be provided by the resource
		 * adapter (a JDBC driver in this case)
		 */

		/*
		 * the connection factory should delegate the getConnection method to
		 * the connectionManager
		 */

		{ // i.e., calling this:
			connectionFactory.getConnection();
			// should imply this call
			connectionManager.allocateConnection(managedConnectionFactory, connectionRequestInfo);
		}

		section("6.5.1.2", RS.COMPLETED);

		// ConnectionRequestInfo is extended to contain resource
		// adapter-specific properties

		/*
		 * all connections properties should be preconfigured so that the
		 * application components do not have to request specific parameters for
		 * getting the connection
		 */

		section("6.5.1.3", RS.COMPLETED);

		/*
		 * a resource adapter is allowed to expect null in lieu of a
		 * ConnectionRequestInfo
		 */

		connectionManager.allocateConnection(managedConnectionFactory, null);

		/*
		 * implementations of ConnectionFactory must implements Serializable and
		 * Referenceable to be stored in JNDI
		 */

		/*
		 * an implementation of Connection must use an instance of
		 * ManagedConnection as the underlying physical connection
		 */

		section("6.5.2", RS.COMPLETED);

		section("6.5.2.1", RS.COMPLETED);

		{ // called by an implementation of ConnectionFactory
			connectionManager.allocateConnection(managedConnectionFactory, connectionRequestInfo);
		}

		section("6.5.2.2", RS.COMPLETED);

		/* an implementation of ConnectionManager is required */

		{ // called when a new connection is required
			managedConnection = managedConnectionFactory.createManagedConnection(subject, connectionRequestInfo);
		}

		{ // called to try retrieving an existing connection
			managedConnection = managedConnectionFactory.matchManagedConnections(connectionSet, subject,
					connectionRequestInfo);
		}

		/* implementations of ConnectionManager must implements Serializable */

		/* an implementation of ConnectionManager is required */

		toReadAgain();

		section("6.5.3", RS.COMPLETED);

		section("6.5.3.1", RS.COMPLETED);

		{ // should create a connection factory instance initialized with the
			// managed connection factory

			// this return the default connection factory instance which must be
			// used only in non managed context
			managedConnectionFactory.createConnectionFactory();
		}

		{ // creates naw physical connection
			managedConnectionFactory.createManagedConnection(subject, connectionRequestInfo);
		}

		{ // called by the application server for connection pooling

			// may throw NotSupportedException to notify the application server
			// that connection pooling is not available
			managedConnectionFactory.matchManagedConnections(connectionSet, subject, connectionRequestInfo);

		}

		section("6.5.3.2", RS.COMPLETED);

		// an implementation of ManagedConnectionFactory is required

		// ManagedConnectionFactory implementations must overried equals and
		// hashCode

		section("6.5.3.3", RS.COMPLETED);

		//

		section("6.5.3.4", RS.COMPLETED);

		/*
		 * A ManagedConnectionFactory may implement
		 * ValidatingManagedConnectionFactory if it supports invalid connection
		 * detection
		 */
		{
			@SuppressWarnings("rawtypes")
			Set invalidConnections = ((ValidatingManagedConnectionFactory) managedConnectionFactory)
					.getInvalidConnections(connectionSet);
		}

		section("6.5.3.5", RS.COMPLETED);

		{
			// for the purpose of transactionality, this must be supported,
			// since the application server may not have all the information
			// required at the time of transaction recovery
			managedConnection = managedConnectionFactory.createManagedConnection(subject, null);
			xaResource = managedConnection.getXAResource();
			xids = xaResource.recover(recoverFlags);

		}

		section("6.5.4", RS.COMPLETED);

		/* ManagedConnection represent a physical connection to the EIS */

		/*
		 * JCA allows several ManagedConnection to be multiplexed over the same
		 * real physical connection
		 */

		/*
		 * in a managed environment, an application server pools managed
		 * connection
		 */

		{ // ManagedConnection defines the following methods for
			// transactionality
			xaResource = managedConnection.getXAResource();
			localTransaction = managedConnection.getLocalTransaction();
		}

		section("6.5.4.1", RS.COMPLETED);

		{ // creates a new connection handle

			// this may be used for re-authentication
			connection = (Connection) managedConnection.getConnection(subject, connectionRequestInfo);
		}

		{
			managedConnection.addConnectionEventListener(connectionEventListener);
		}

		{ // better synchronize on the listeners to avoid threading issues
			managedConnection.removeConnectionEventListener(connectionEventListener);
		}

		{
			managedConnectionMetaData = managedConnection.getMetaData();
		}

		section("6.5.4.2", RS.COMPLETED);

		{ // both handles are valid until closes
			Object c1 = managedConnection.getConnection(subject, connectionRequestInfo);
			Object c2 = managedConnection.getConnection(subject, connectionRequestInfo);
		}

		/* ManagedConnection instances should be thread safe */

		/*
		 * there should be at most one active connection per ManagedConnection
		 * instances
		 */

		toReadAgain();

		section("6.5.4.3", RS.COMPLETED);

		{// connectionSet is provided by the application server ; it should
			// contains only managed connections instances that have no
			// connection handle
			managedConnection = managedConnectionFactory.matchManagedConnections(connectionSet, subject,
					connectionRequestInfo);
		}

		/*
		 * A connection request can lead to the creation of additional
		 * connection handles for a ManagedConnection instance that already has
		 * one or more existing connection handles. In this case, the
		 * application server should take the responsibility of checking whether
		 * or not the chosen ManagedConnection instance can service such a
		 * request. Refer to Section 7.9, “Connection Sharing” on page 7-32 for
		 * details.
		 * 
		 */

		toReadAgain();

		section("6.5.4.4", RS.COMPLETED);
		{ // called to recycle the managed connection in the pool
			managedConnection.cleanup();
		}

		/*
		 * cleanup must invalidate all connectio handles created with the
		 * managed connection
		 */

		/*
		 * cleanup should prepare a managed connection for availability in the
		 * pool
		 */

		/*
		 * cleanup should not cause the resource adapter to close the physical
		 * pipe
		 */

		{ // called to really remove the managed connection
			managedConnection.destroy();
		}
		section("6.5.4.5", RS.COMPLETED);

		/* An implementation of ManagedConnection is required */

		section("6.5.5", RS.COMPLETED);

		section("6.5.5.1", RS.COMPLETED);

		managedConnectionMetaData.getEISProductName();
		managedConnectionMetaData.getEISProductVersion();
		managedConnectionMetaData.getUserName();

		{ // max number of concurrent connections that the EIS support
			managedConnectionMetaData.getMaxConnections();
		}

		section("6.5.5.2", RS.COMPLETED);

		/* an implementation of managedConnectionMetaData is required */

		section("6.5.6", RS.COMPLETED);
		section("6.5.6.1", RS.COMPLETED);

		connectionEventListener.localTransactionStarted(connectionEvent);
		connectionEventListener.localTransactionCommitted(connectionEvent);
		connectionEventListener.localTransactionRolledback(connectionEvent);

		{ // causes the application server to destroy the corresponding managed
			// connection
			connectionEventListener.connectionErrorOccurred(connectionEvent);
		}

		{ // upon connectionClosed, the application server decides whether to
			// put the connection back in the pool or not
			connectionEventListener.connectionClosed(connectionEvent);
		}

		/* event processing may be asynchronous */

		section("6.5.7", RS.COMPLETED);

		{ // managed connection which generated the event
			Object source = connectionEvent.getSource();
		}

		{ // connection handle associated with the managed connection ; required
			// for CONNECTION_CLOSED
			Object handle = connectionEvent.getConnectionHandle();
		}

		new Integer(ConnectionEvent.LOCAL_TRANSACTION_STARTED);
		new Integer(ConnectionEvent.LOCAL_TRANSACTION_COMMITTED);
		new Integer(ConnectionEvent.LOCAL_TRANSACTION_ROLLEDBACK);
		new Integer(ConnectionEvent.CONNECTION_ERROR_OCCURRED);
		new Integer(ConnectionEvent.CONNECTION_CLOSED);

		section("6.6", RS.COMPLETED);

		section("6.6.1", RS.COMPLETED);

		managedConnectionFactory.setLogWriter(printWriter);
		printWriter = managedConnectionFactory.getLogWriter();

		section("6.6.2", RS.COMPLETED);

		managedConnection.setLogWriter(printWriter);
		printWriter = managedConnection.getLogWriter();

		/*
		 * logwriter may be null while the connection is made available in the
		 * pool
		 */

		section("6.7", RS.COMPLETED);

		{ // instanciation happens in this order

			// application component
			connection = connectionFactory.getConnection();

			// connection factory ask the managed connection factory
			connection = (Connection) connectionManager.allocateConnection(managedConnectionFactory,
					connectionRequestInfo);

			// application server can decide to a create a new managed
			// connection
			managedConnection = managedConnectionFactory.createManagedConnection(subject, connectionRequestInfo);

			// the managed connection does create the new connection
			connection = (Connection) managedConnection.getConnection(subject, connectionRequestInfo);

		}

		section("6.8", RS.COMPLETED);
		section("6.8.1", RS.COMPLETED);

		{
			connection = connectionFactory.getConnection();
			connection = (Connection) connectionManager.allocateConnection(managedConnectionFactory,
					connectionRequestInfo);
			managedConnectionFactory.createManagedConnection(subject, connectionRequestInfo);
			managedConnection.addConnectionEventListener(connectionEventListener);
			xaResource = managedConnection.getXAResource();
			// enlist resource ?
			xaResource.start(xid, startFlags);
			managedConnection.getConnection(subject, connectionRequestInfo);

		}

		section("6.8.2", RS.COMPLETED);

		{
			// within application server
			connection = connectionFactory.getConnection();

			// within connection factory

			connection = (Connection) connectionManager.allocateConnection(managedConnectionFactory,
					connectionRequestInfo);

			// within application server
			managedConnection = managedConnectionFactory.matchManagedConnections(connectionSet, subject,
					connectionRequestInfo);
			managedConnection.addConnectionEventListener(connectionEventListener);
			managedConnection.setLogWriter(printWriter);
			xaResource = managedConnection.getXAResource();
			// ?? Transaction enlist resource ?

			// within transaction manager
			xaResource.start(xid, startFlags);

			// within application server
			managedConnection.getConnection(subject, connectionRequestInfo);
		}

		toReadAgain();

		section("6.8.3", RS.COMPLETED);

		{

			// application component
			connection.close();

			// managed connection
			connectionEventListener.connectionClosed(connectionEvent);

			// application server
			// Transaction.delistResource ??
			xaResource.end(xid, endFlags);

			managedConnection.cleanup();

		}

		section("6.8.3.1", RS.COMPLETED);
		section("6.8.3.2", RS.COMPLETED);

		section("6.9", RS.COMPLETED);

		toReadAgain();

		section("6.9.1", RS.COMPLETED);

		{
			ConnectionFactory connectionFactory = (ConnectionFactory) managedConnectionFactory
					.createConnectionFactory();
			connection = connectionFactory.getConnection();
			connection.close();

		}

		section("6.9.2", RS.COMPLETED);

		{
			// application client
			connection = connectionFactory.getConnection();

			// connection factory
			connection = (Connection) connectionManager.allocateConnection(managedConnectionFactory,
					connectionRequestInfo);

			// connection manager
			managedConnection = managedConnectionFactory.createManagedConnection(subject, connectionRequestInfo);
			managedConnection.getConnection(subject, connectionRequestInfo);

		}

		section("6.10", RS.COMPLETED);

		section("6.10.1", RS.COMPLETED);

		// implementation of the following are required

		ManagedConnectionFactory.class.getName();
		ManagedConnection.class.getName();
		ManagedConnectionMetaData.class.getName();

		// ManagedConnection must use the following only in the managed case

		ConnectionEvent.class.getName();
		ConnectionEventListener.class.getName();

		// a default implementation of the following is required

		ConnectionManager.class.getName();

		/*
		 * a resource adapter is not allowed to support its own internal pooling
		 */

		section("6.10.2", RS.COMPLETED);

		section("7", RS.STARTED);
		section("7.1", RS.COMPLETED);

		/* JTA , XA */
		/* local transactions */

		// JTA => XAResource

		section("7.2", RS.COMPLETED);

		section("7.2.1", RS.COMPLETED);

		section("7.2.2", RS.COMPLETED);

		section("7.3", RS.COMPLETED);
		section("7.3.1", RS.COMPLETED);

		// JTA
		xaResource = managedConnection.getXAResource();

		// local transactions
		localTransaction = managedConnection.getLocalTransaction();

		section("7.3.2", RS.COMPLETED);

		xaResource.commit(xid, phaseCommitProtocol);
		xaResource.end(xid, endFlags);
		xaResource.forget(xid);
		xaResource.prepare(xid);
		xaResource.recover(recoverFlags);
		xaResource.rollback(xid);
		xaResource.start(xid, startFlags);

		section("7.3.2.1", RS.COMPLETED);

		/*
		 * A resource adapter typically implements the XAResource interface
		 * using a lowlevel library available for the underlying EIS resource
		 * manager
		 */

		/*
		 * there should be a 1-1 relationship between XAResource instances and
		 * ManagedConnection instances
		 */

		/*
		 * The XAResource instance used during the transaction completion
		 * process need not be the one initially enlisted with the transaction
		 * manager for this transaction.
		 */

		section("7.3.3", RS.COMPLETED);

		localTransaction.begin();
		localTransaction.rollback();
		localTransaction.commit();

		section("7.4", RS.COMPLETED);

		// JTA, JTS

		section("7.4.1", RS.COMPLETED);

		TransactionManager.class.getName();
		Transaction.class.getName();

		section("7.5", RS.COMPLETED);
		section("7.6", RS.STARTED);

		section("7.6.1", RS.STARTED);

		section("7.6.2", RS.UNTOUCHED);
		section("7.6.2.1", RS.UNTOUCHED);
		section("7.6.2.2", RS.UNTOUCHED);
		section("7.6.2.3", RS.UNTOUCHED);
		section("7.6.2.4", RS.UNTOUCHED);
		section("7.6.2.5", RS.UNTOUCHED);
		section("7.6.2.6", RS.UNTOUCHED);
		section("7.6.2.7", RS.UNTOUCHED);
		section("7.6.2.8", RS.UNTOUCHED);
		section("7.6.3", RS.UNTOUCHED);
		section("7.6.3.1", RS.UNTOUCHED);
		section("7.6.3.2", RS.UNTOUCHED);
		section("7.6.3.3", RS.UNTOUCHED);
		section("7.6.3.4", RS.UNTOUCHED);
		section("7.6.4", RS.UNTOUCHED);
		section("7.6.5", RS.UNTOUCHED);
		section("7.6.6", RS.UNTOUCHED);
		section("7.7", RS.UNTOUCHED);
		section("7.7.1", RS.UNTOUCHED);
		section("7.7.2", RS.UNTOUCHED);
		section("7.7.2.1", RS.UNTOUCHED);
		section("7.8", RS.UNTOUCHED);
		section("7.8.1", RS.UNTOUCHED);
		section("7.8.2", RS.UNTOUCHED);
		section("7.8.3", RS.UNTOUCHED);
		section("7.8.3.1", RS.UNTOUCHED);
		section("7.9", RS.UNTOUCHED);
		section("7.9.1", RS.UNTOUCHED);
		section("7.9.1.1", RS.UNTOUCHED);
		section("7.9.1.2", RS.UNTOUCHED);
		section("7.10", RS.UNTOUCHED);
		section("7.10.1", RS.UNTOUCHED);
		section("7.10.2", RS.UNTOUCHED);
		section("7.10.3", RS.UNTOUCHED);
		section("7.11", RS.UNTOUCHED);
		section("7.11.1", RS.UNTOUCHED);
		section("7.11.2", RS.UNTOUCHED);
		section("7.11.3", RS.UNTOUCHED);
		section("7.12", RS.UNTOUCHED);
		section("7.12.1", RS.UNTOUCHED);
		section("7.13", RS.UNTOUCHED);
		section("7.14", RS.UNTOUCHED);
		section("7.15", RS.UNTOUCHED);
		section("7.15.1", RS.UNTOUCHED);
		section("7.15.1.1", RS.UNTOUCHED);
		section("7.15.2", RS.UNTOUCHED);
		section("7.16", RS.UNTOUCHED);
		section("7.16.1", RS.UNTOUCHED);
		section("7.16.1.1", RS.UNTOUCHED);
		section("7.16.2", RS.UNTOUCHED);
		section("7.16.2.1", RS.UNTOUCHED);

		section("8", RS.UNTOUCHED);
		section("8.1", RS.UNTOUCHED);
		section("8.2", RS.UNTOUCHED);
		section("8.3", RS.UNTOUCHED);
		section("8.4", RS.UNTOUCHED);
		section("8.4.1", RS.UNTOUCHED);
		section("8.4.2", RS.UNTOUCHED);
		section("8.5", RS.UNTOUCHED);
		section("8.5.1", RS.UNTOUCHED);
		section("8.5.2", RS.UNTOUCHED);
		section("8.5.3", RS.UNTOUCHED);
		section("8.5.4", RS.UNTOUCHED);
		section("8.6", RS.UNTOUCHED);
		section("8.6.1", RS.UNTOUCHED);
		section("8.6.2", RS.UNTOUCHED);
		section("8.6.3", RS.UNTOUCHED);
		section("8.6.4", RS.UNTOUCHED);
		section("8.6.5", RS.UNTOUCHED);
		section("8.6.6", RS.UNTOUCHED);
		section("9", RS.UNTOUCHED);
		section("9.1", RS.UNTOUCHED);
		section("9.1.1", RS.UNTOUCHED);
		section("9.1.2", RS.UNTOUCHED);
		section("9.1.3", RS.UNTOUCHED);
		section("9.1.4", RS.UNTOUCHED);
		section("9.1.4.1", RS.UNTOUCHED);
		section("9.1.4.2", RS.UNTOUCHED);
		section("9.1.5", RS.UNTOUCHED);
		section("9.1.5.1", RS.UNTOUCHED);
		section("9.1.6", RS.UNTOUCHED);
		section("9.1.7", RS.UNTOUCHED);
		section("9.1.8", RS.UNTOUCHED);
		section("9.1.8.1", RS.UNTOUCHED);
		section("9.1.8.2", RS.UNTOUCHED);
		section("9.1.9", RS.UNTOUCHED);
		section("9.2", RS.UNTOUCHED);
		section("9.2.1", RS.UNTOUCHED);
		section("9.2.2", RS.UNTOUCHED);
		section("10", RS.UNTOUCHED);
		section("10.1", RS.UNTOUCHED);
		section("10.2", RS.UNTOUCHED);
		section("10.3", RS.UNTOUCHED);
		section("10.3.1", RS.UNTOUCHED);
		section("10.3.2", RS.UNTOUCHED);
		section("10.3.3", RS.UNTOUCHED);
		section("10.3.3.1", RS.UNTOUCHED);
		section("10.3.3.2", RS.UNTOUCHED);
		section("10.3.3.3", RS.UNTOUCHED);
		section("10.3.3.4", RS.UNTOUCHED);
		section("10.3.3.5", RS.UNTOUCHED);
		section("10.3.3.6", RS.UNTOUCHED);
		section("10.3.4", RS.UNTOUCHED);
		section("10.3.4.1", RS.UNTOUCHED);
		section("10.3.5", RS.UNTOUCHED);
		section("10.3.6", RS.UNTOUCHED);
		section("10.3.7", RS.UNTOUCHED);
		section("10.3.8", RS.UNTOUCHED);
		section("10.3.9", RS.UNTOUCHED);
		section("10.3.10", RS.UNTOUCHED);
		section("10.3.11", RS.UNTOUCHED);
		section("10.3.11.1", RS.UNTOUCHED);
		section("10.3.11.2", RS.UNTOUCHED);
		section("10.3.11.3", RS.UNTOUCHED);
		section("11", RS.UNTOUCHED);
		section("11.1", RS.UNTOUCHED);
		section("11.2", RS.UNTOUCHED);
		section("11.3", RS.UNTOUCHED);
		section("11.3.1", RS.UNTOUCHED);
		section("11.3.2", RS.UNTOUCHED);
		section("11.4", RS.UNTOUCHED);
		section("11.4.1", RS.UNTOUCHED);
		section("11.4.2", RS.UNTOUCHED);
		section("11.4.3", RS.UNTOUCHED);
		section("11.5", RS.UNTOUCHED);
		section("11.6", RS.UNTOUCHED);
		section("11.6.1", RS.UNTOUCHED);
		section("11.6.1.1", RS.UNTOUCHED);
		section("11.6.1.2", RS.UNTOUCHED);
		section("11.7", RS.UNTOUCHED);
		section("11.8", RS.UNTOUCHED);
		section("12", RS.UNTOUCHED);
		section("12.1", RS.UNTOUCHED);
		section("12.2", RS.UNTOUCHED);
		section("13", RS.UNTOUCHED);
		section("13.1", RS.UNTOUCHED);
		section("13.2", RS.UNTOUCHED);
		section("13.3", RS.UNTOUCHED);
		section("13.4", RS.UNTOUCHED);
		section("13.4.1", RS.UNTOUCHED);
		section("13.4.2", RS.UNTOUCHED);
		section("13.4.2.1", RS.UNTOUCHED);
		section("13.4.2.2", RS.UNTOUCHED);
		section("13.4.2.3", RS.UNTOUCHED);
		section("13.4.2.4", RS.UNTOUCHED);
		section("13.4.3", RS.UNTOUCHED);
		section("13.4.4", RS.UNTOUCHED);
		section("13.4.5", RS.UNTOUCHED);
		section("13.4.6", RS.UNTOUCHED);
		section("13.4.7", RS.UNTOUCHED);
		section("13.4.8", RS.UNTOUCHED);
		section("13.4.9", RS.UNTOUCHED);
		section("13.4.9.1", RS.UNTOUCHED);
		section("13.5", RS.UNTOUCHED);
		section("13.5.1", RS.UNTOUCHED);
		section("13.5.1.1", RS.UNTOUCHED);
		section("13.5.2", RS.UNTOUCHED);
		section("13.5.3", RS.UNTOUCHED);
		section("13.5.4", RS.UNTOUCHED);
		section("13.5.4.1", RS.UNTOUCHED);
		section("13.5.5", RS.UNTOUCHED);
		section("13.5.6", RS.UNTOUCHED);
		section("13.5.7", RS.UNTOUCHED);
		section("13.5.8", RS.UNTOUCHED);
		section("13.5.9", RS.UNTOUCHED);
		section("13.6", RS.UNTOUCHED);
		section("13.7", RS.UNTOUCHED);
		section("13.7.1", RS.UNTOUCHED);
		section("13.7.1.1", RS.UNTOUCHED);
		section("13.7.1.2", RS.UNTOUCHED);
		section("13.7.1.3", RS.UNTOUCHED);
		section("13.7.2", RS.UNTOUCHED);
		section("13.7.2.1", RS.UNTOUCHED);
		section("13.7.2.2", RS.UNTOUCHED);
		section("13.8", RS.UNTOUCHED);
		section("13.8.1", RS.UNTOUCHED);
		section("13.8.2", RS.UNTOUCHED);
		section("13.8.3", RS.UNTOUCHED);
		section("13.8.3.1", RS.UNTOUCHED);
		section("13.8.4", RS.UNTOUCHED);
		section("13.8.5", RS.UNTOUCHED);
		section("14", RS.UNTOUCHED);
		section("14.1", RS.UNTOUCHED);
		section("14.2", RS.UNTOUCHED);
		section("14.3", RS.UNTOUCHED);
		section("14.3.0.1", RS.UNTOUCHED);
		section("15", RS.UNTOUCHED);
		section("15.1", RS.UNTOUCHED);
		section("15.2", RS.UNTOUCHED);
		section("15.3", RS.UNTOUCHED);
		section("15.4", RS.UNTOUCHED);
		section("15.4.1", RS.UNTOUCHED);
		section("15.4.2", RS.UNTOUCHED);
		section("15.4.3", RS.UNTOUCHED);
		section("15.4.4", RS.UNTOUCHED);
		section("15.4.5", RS.UNTOUCHED);
		section("15.4.6", RS.UNTOUCHED);
		section("15.4.7", RS.UNTOUCHED);
		section("16", RS.UNTOUCHED);
		section("16.1", RS.UNTOUCHED);
		section("16.2", RS.UNTOUCHED);
		section("16.3", RS.UNTOUCHED);
		section("16.4", RS.UNTOUCHED);
		section("16.4.1", RS.UNTOUCHED);
		section("16.4.2", RS.UNTOUCHED);
		section("16.4.3", RS.UNTOUCHED);
		section("16.4.4", RS.UNTOUCHED);
		section("16.4.5", RS.UNTOUCHED);
		section("16.4.5.1", RS.UNTOUCHED);
		section("16.4.5.2", RS.UNTOUCHED);
		section("16.4.6", RS.UNTOUCHED);
		section("16.4.7", RS.UNTOUCHED);
		section("16.5", RS.UNTOUCHED);
		section("16.5.1", RS.UNTOUCHED);
		section("16.5.2", RS.UNTOUCHED);
		section("17", RS.UNTOUCHED);
		section("17.1", RS.UNTOUCHED);
		section("17.2", RS.UNTOUCHED);
		section("17.3", RS.UNTOUCHED);
		section("17.3.1", RS.UNTOUCHED);
		section("17.3.2", RS.UNTOUCHED);
		section("17.3.3", RS.UNTOUCHED);
		section("17.4", RS.UNTOUCHED);
		section("17.4.1", RS.UNTOUCHED);
		section("17.5", RS.UNTOUCHED);
		section("17.5.1", RS.UNTOUCHED);
		section("17.5.1.1", RS.UNTOUCHED);
		section("17.5.2", RS.UNTOUCHED);
		section("17.5.3", RS.UNTOUCHED);
		section("17.5.3.1", RS.UNTOUCHED);
		section("17.6", RS.UNTOUCHED);
		section("17.6.1", RS.UNTOUCHED);
		section("17.6.2", RS.UNTOUCHED);
		section("17.6.2.1", RS.UNTOUCHED);
		section("17.6.2.2", RS.UNTOUCHED);
		section("17.6.2.3", RS.UNTOUCHED);
		section("17.6.2.4", RS.UNTOUCHED);
		section("17.6.2.5", RS.UNTOUCHED);
		section("17.6.2.6", RS.UNTOUCHED);
		section("17.6.3", RS.UNTOUCHED);
		section("17.6.3.1", RS.UNTOUCHED);
		section("17.7", RS.UNTOUCHED);
		section("17.7.1", RS.UNTOUCHED);
		section("17.7.1.1", RS.UNTOUCHED);
		section("17.7.2", RS.UNTOUCHED);
		section("17.8", RS.UNTOUCHED);
		section("17.9", RS.UNTOUCHED);
		section("17.9.1", RS.UNTOUCHED);
		section("17.9.2", RS.UNTOUCHED);
		section("17.10", RS.UNTOUCHED);
		section("17.10.1", RS.UNTOUCHED);
		section("17.10.1.1", RS.UNTOUCHED);
		section("17.10.1.2", RS.UNTOUCHED);
		section("17.10.1.3", RS.UNTOUCHED);
		section("17.10.1.4", RS.UNTOUCHED);
		section("17.10.2", RS.UNTOUCHED);
		section("17.10.3", RS.UNTOUCHED);
		section("17.10.3.1", RS.UNTOUCHED);
		section("17.11", RS.UNTOUCHED);
		section("17.11.1", RS.UNTOUCHED);
		section("17.11.1.1", RS.UNTOUCHED);
		section("17.11.1.2", RS.UNTOUCHED);
		section("17.11.1.3", RS.UNTOUCHED);
		section("17.11.1.4", RS.UNTOUCHED);
		section("17.11.1.5", RS.UNTOUCHED);
		section("17.11.1.6", RS.UNTOUCHED);
		section("17.11.1.7", RS.UNTOUCHED);
		section("17.11.1.8", RS.UNTOUCHED);
		section("17.11.2", RS.UNTOUCHED);
		section("17.11.3", RS.UNTOUCHED);
		section("17.12", RS.UNTOUCHED);
		section("17.12.1", RS.UNTOUCHED);
		section("17.12.2", RS.UNTOUCHED);
		section("17.12.3", RS.UNTOUCHED);
		section("17.12.4", RS.UNTOUCHED);
		section("17.12.5", RS.UNTOUCHED);
		section("18", RS.UNTOUCHED);
		section("18.1", RS.UNTOUCHED);
		section("18.2", RS.UNTOUCHED);
		section("18.3", RS.UNTOUCHED);
		section("18.3.1", RS.UNTOUCHED);
		section("18.3.2", RS.UNTOUCHED);
		section("18.3.3", RS.UNTOUCHED);
		section("18.4", RS.UNTOUCHED);
		section("18.4.1", RS.UNTOUCHED);
		section("18.4.2", RS.UNTOUCHED);
		section("18.4.3", RS.UNTOUCHED);
		section("18.4.4", RS.UNTOUCHED);
		section("18.5", RS.UNTOUCHED);
		section("18.5.1", RS.UNTOUCHED);
		section("18.6", RS.UNTOUCHED);
		section("18.6.1", RS.UNTOUCHED);
		section("18.7", RS.UNTOUCHED);
		section("18.7.1", RS.UNTOUCHED);
		section("18.8", RS.UNTOUCHED);
		section("18.9", RS.UNTOUCHED);
		section("18.9.1", RS.UNTOUCHED);
		section("18.9.1.1", RS.UNTOUCHED);
		section("18.9.2", RS.UNTOUCHED);
		section("18.9.2.1", RS.UNTOUCHED);
		section("18.9.3", RS.UNTOUCHED);
		section("18.9.3.1", RS.UNTOUCHED);
		section("18.9.4", RS.UNTOUCHED);
		section("18.9.4.1", RS.UNTOUCHED);
		section("19", RS.UNTOUCHED);
		section("19.1", RS.UNTOUCHED);
		section("19.2", RS.UNTOUCHED);
		section("19.3", RS.UNTOUCHED);
		section("19.4", RS.UNTOUCHED);
		section("19.4.1", RS.UNTOUCHED);
		section("19.4.2", RS.UNTOUCHED);
		section("20", RS.UNTOUCHED);
		section("20.1", RS.UNTOUCHED);
		section("20.2", RS.UNTOUCHED);
		section("20.2.0.1", RS.UNTOUCHED);
		section("20.2.0.2", RS.UNTOUCHED);
		section("20.2.0.3", RS.UNTOUCHED);
		section("20.2.0.4", RS.UNTOUCHED);
		section("20.3", RS.UNTOUCHED);
		section("20.4", RS.UNTOUCHED);
		section("20.4.1", RS.UNTOUCHED);
		section("20.4.2", RS.UNTOUCHED);
		section("20.4.2.1", RS.UNTOUCHED);
		section("20.4.2.2", RS.UNTOUCHED);
		section("20.4.2.3", RS.UNTOUCHED);
		section("20.4.2.4", RS.UNTOUCHED);
		section("20.5", RS.UNTOUCHED);
		section("20.5.1", RS.UNTOUCHED);
		section("20.5.1.1", RS.UNTOUCHED);
		section("20.5.2", RS.UNTOUCHED);
		section("20.5.2.1", RS.UNTOUCHED);
		section("20.5.3", RS.UNTOUCHED);
		section("20.5.4", RS.UNTOUCHED);
		section("20.6", RS.UNTOUCHED);
		section("20.6.1", RS.UNTOUCHED);
		section("20.6.1.1", RS.UNTOUCHED);
		section("20.6.1.2", RS.UNTOUCHED);
		section("20.6.1.3", RS.UNTOUCHED);
		section("20.6.2", RS.UNTOUCHED);
		section("20.6.3", RS.UNTOUCHED);
		section("20.6.3.1", RS.UNTOUCHED);
		section("20.6.3.2", RS.UNTOUCHED);
		section("20.6.3.3", RS.UNTOUCHED);
		section("20.6.4", RS.UNTOUCHED);
		section("20.7", RS.UNTOUCHED);
		section("21", RS.UNTOUCHED);
		section("21.1", RS.UNTOUCHED);
		section("21.2", RS.UNTOUCHED);
		section("21.3", RS.UNTOUCHED);
		section("21.3.1", RS.UNTOUCHED);
		section("21.4", RS.UNTOUCHED);
		section("21.4.1", RS.UNTOUCHED);
		section("21.5", RS.UNTOUCHED);
		section("22", RS.UNTOUCHED);
		section("22.1", RS.UNTOUCHED);
		section("22.2", RS.UNTOUCHED);
		section("22.2.1", RS.UNTOUCHED);
		section("22.3", RS.UNTOUCHED);
		section("22.4", RS.UNTOUCHED);
		section("23", RS.UNTOUCHED);
		section("23.1", RS.UNTOUCHED);
		section("23.1.1", RS.UNTOUCHED);
		section("23.1.1.1", RS.UNTOUCHED);
		section("23.1.1.2", RS.UNTOUCHED);
		section("23.2", RS.UNTOUCHED);
		section("23.2.1", RS.UNTOUCHED);
		section("23.2.1.1", RS.UNTOUCHED);
		section("24", RS.UNTOUCHED);
		section("24.A", RS.UNTOUCHED);
		section("24.A.1", RS.UNTOUCHED);
		section("24.A.2", RS.UNTOUCHED);
		section("24.A.3", RS.UNTOUCHED);
		section("24.B", RS.UNTOUCHED);
		section("24.B.1", RS.UNTOUCHED);
		section("24.B.2", RS.UNTOUCHED);
		section("24.B.2.1", RS.UNTOUCHED);
		section("24.B.2.2", RS.UNTOUCHED);
		section("24.C", RS.UNTOUCHED);
		section("24.C.1", RS.UNTOUCHED);
		section("24.C.1.1", RS.UNTOUCHED);
		section("24.C.1.2", RS.UNTOUCHED);
		section("24.C.1.3", RS.UNTOUCHED);
		section("24.C.2", RS.UNTOUCHED);
		section("24.C.2.1", RS.UNTOUCHED);
		section("24.C.2.2", RS.UNTOUCHED);
		section("24.C.2.3", RS.UNTOUCHED);
		section("24.C.2.4", RS.UNTOUCHED);
		section("24.C.3", RS.UNTOUCHED);
		section("24.C.3.1", RS.UNTOUCHED);
		section("24.C.3.2", RS.UNTOUCHED);
		section("24.C.3.3", RS.UNTOUCHED);
		section("24.D", RS.UNTOUCHED);
		section("24.D.1", RS.UNTOUCHED);
		section("24.D.2", RS.UNTOUCHED);
		section("24.D.3", RS.UNTOUCHED);
		section("24.D.3.1", RS.UNTOUCHED);
		section("24.D.3.2", RS.UNTOUCHED);
		section("24.D.3.2.1", RS.UNTOUCHED);
		section("24.D.3.2.2", RS.UNTOUCHED);
		section("24.D.3.2.3", RS.UNTOUCHED);
		section("24.D.4", RS.UNTOUCHED);
		section("24.D.4.1", RS.UNTOUCHED);
		section("24.D.5.1", RS.UNTOUCHED);
		section("24.D.5.2", RS.UNTOUCHED);
		section("24.D.5.3", RS.UNTOUCHED);
		section("24.D.5.4", RS.UNTOUCHED);
		section("24.D.5.5", RS.UNTOUCHED);
		section("24.E", RS.UNTOUCHED);
		section("24.F", RS.UNTOUCHED);
		section("24.F.1", RS.UNTOUCHED);
		section("24.F.2", RS.UNTOUCHED);
		section("24.F.3", RS.UNTOUCHED);
		section("24.F.4", RS.UNTOUCHED);
		section("24.F.5", RS.UNTOUCHED);
		section("24.G", RS.UNTOUCHED);
		section("24.G.1", RS.UNTOUCHED);
		section("24.G.2", RS.UNTOUCHED);
		section("24.G.3", RS.UNTOUCHED);
		section("24.G.4", RS.UNTOUCHED);
		section("24.H", RS.UNTOUCHED);
		section("24.H.1", RS.UNTOUCHED);
		section("24.H.2", RS.UNTOUCHED);
		section("24.H.3", RS.UNTOUCHED);
		section("24.H.4", RS.UNTOUCHED);
		section("24.I", RS.UNTOUCHED);
		section("24.I.1", RS.UNTOUCHED);

	}

	private void toReadAgain() {
		// TODO Auto-generated method stub

	}

	private <T> T constructANewInstanceOf(Class<T> clazz) {
		return null;
	}

	public String getSection() {
		return section;
	}

	private void section(String section, RS readingStatus) {
		this.section = section;
	}
}
