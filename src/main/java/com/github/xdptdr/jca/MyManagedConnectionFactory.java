package com.github.xdptdr.jca;

import java.io.PrintWriter;
import java.util.Set;

import javax.resource.ResourceException;
import javax.resource.spi.ConnectionManager;
import javax.resource.spi.ConnectionRequestInfo;
import javax.resource.spi.ManagedConnection;
import javax.resource.spi.ManagedConnectionFactory;
import javax.security.auth.Subject;

public class MyManagedConnectionFactory implements ManagedConnectionFactory {

	private static final long serialVersionUID = 1L;

	private Object connectionFactory = new Object();

	private ManagedConnection managedConnection = new MyManagedConnection();

	private PrintWriter logWriter;

	@Override
	public Object createConnectionFactory(ConnectionManager cxManager) throws ResourceException {
		return connectionFactory;
	}

	@Override
	public Object createConnectionFactory() throws ResourceException {

		return connectionFactory;
	}

	@Override
	public ManagedConnection createManagedConnection(Subject subject, ConnectionRequestInfo cxRequestInfo)
			throws ResourceException {
		return managedConnection;
	}

	@Override
	public ManagedConnection matchManagedConnections(@SuppressWarnings("rawtypes") Set connectionSet, Subject subject,
			ConnectionRequestInfo cxRequestInfo) throws ResourceException {
		return managedConnection;
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
