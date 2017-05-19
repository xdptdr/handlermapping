package com.github.xdptdr.jca.base;

import java.io.PrintWriter;
import java.util.Set;

import javax.resource.NotSupportedException;
import javax.resource.ResourceException;
import javax.resource.spi.ConnectionManager;
import javax.resource.spi.ConnectionRequestInfo;
import javax.resource.spi.ManagedConnection;
import javax.resource.spi.ManagedConnectionFactory;
import javax.resource.spi.ResourceAdapter;
import javax.resource.spi.ResourceAdapterAssociation;
import javax.security.auth.Subject;

public abstract class AbstractManagedConnectionFactory implements ManagedConnectionFactory, ResourceAdapterAssociation {

	private static final long serialVersionUID = 1L;

	private ResourceAdapter resourceAdapter;
	private PrintWriter logWriter;

	@Override
	public ResourceAdapter getResourceAdapter() {
		return resourceAdapter;
	}

	@Override
	public void setResourceAdapter(ResourceAdapter ra) throws ResourceException {
		resourceAdapter = ra;
	}

	@Override
	public Object createConnectionFactory(ConnectionManager cxManager) throws ResourceException {
		return null;
	}

	@Override
	public Object createConnectionFactory() throws ResourceException {
		throw new NotSupportedException("createConnectionFactory without a connectionManager not supported");
	}

	@Override
	public ManagedConnection createManagedConnection(Subject subject, ConnectionRequestInfo cxRequestInfo)
			throws ResourceException {
		return null;
	}

	@Override
	public ManagedConnection matchManagedConnections(@SuppressWarnings("rawtypes") Set connectionSet, Subject subject,
			ConnectionRequestInfo cxRequestInfo) throws ResourceException {
		throw new NotSupportedException("matchManagedConnections not supported");
	}

	@Override
	public void setLogWriter(PrintWriter out) throws ResourceException {
		logWriter = out;
	}

	@Override
	public PrintWriter getLogWriter() throws ResourceException {
		return logWriter;
	}

}
