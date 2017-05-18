package com.github.xdptdr.tigrou;

import java.io.PrintWriter;
import java.util.Set;

import javax.resource.ResourceException;
import javax.resource.cci.Connection;
import javax.resource.cci.ConnectionFactory;
import javax.resource.spi.ConnectionDefinition;
import javax.resource.spi.ConnectionManager;
import javax.resource.spi.ConnectionRequestInfo;
import javax.resource.spi.ManagedConnection;
import javax.resource.spi.ManagedConnectionFactory;
import javax.resource.spi.ResourceAdapter;
import javax.resource.spi.ResourceAdapterAssociation;
import javax.security.auth.Subject;

@ConnectionDefinition(connectionImpl = TigrouConnection.class, connection = Connection.class, connectionFactoryImpl = TigrouConnectionFactory.class, connectionFactory = ConnectionFactory.class)
public class TigrouManagedConnectionFactory implements ManagedConnectionFactory, ResourceAdapterAssociation {

	private static final long serialVersionUID = 1L;
	private PrintWriter logWriter;
	private ResourceAdapter resourceAdapter;

	public TigrouManagedConnectionFactory() {
	}
	
	@Override
	public Object createConnectionFactory(ConnectionManager cxManager) throws ResourceException {
		return new TigrouConnectionFactory(this, cxManager);
	}

	@Override
	public Object createConnectionFactory() throws ResourceException {
		throw new ResourceException("This resource adapter doesn't support non-managed environments");
	}

	@Override
	public ManagedConnection createManagedConnection(Subject subject, ConnectionRequestInfo cxRequestInfo)
			throws ResourceException {
		return new TigrouManagedConnection(this);
	}

	@Override
	public ManagedConnection matchManagedConnections(@SuppressWarnings("rawtypes") Set connectionSet, Subject subject,
			ConnectionRequestInfo cxRequestInfo) throws ResourceException {
		for (Object connection : connectionSet) {
			if (connection instanceof TigrouManagedConnection) {
				return (ManagedConnection) connection;
			}
		}
		return null;
	}

	@Override
	public void setLogWriter(PrintWriter out) throws ResourceException {
		logWriter = out;
	}

	@Override
	public PrintWriter getLogWriter() throws ResourceException {
		return logWriter;
	}

	@Override
	public ResourceAdapter getResourceAdapter() {
		return resourceAdapter;
	}

	@Override
	public void setResourceAdapter(ResourceAdapter ra) throws ResourceException {
		resourceAdapter = ra;

	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}
}
