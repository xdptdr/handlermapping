package com.github.xdptdr.tigrou;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.resource.NotSupportedException;
import javax.resource.ResourceException;
import javax.resource.cci.Connection;
import javax.resource.spi.ConnectionEventListener;
import javax.resource.spi.ConnectionRequestInfo;
import javax.resource.spi.LocalTransaction;
import javax.resource.spi.ManagedConnection;
import javax.resource.spi.ManagedConnectionFactory;
import javax.resource.spi.ManagedConnectionMetaData;
import javax.security.auth.Subject;
import javax.transaction.xa.XAResource;

public class TigrouManagedConnection implements ManagedConnection {

	private ManagedConnectionFactory managedConnectionFactory;
	private Set<Connection> connections = new HashSet<>();
	private List<ConnectionEventListener> listeners = new ArrayList<>();
	private PrintWriter logWriter;

	public TigrouManagedConnection(ManagedConnectionFactory managedConnectionFactory) {
		this.managedConnectionFactory = managedConnectionFactory;
	}

	@Override
	public Object getConnection(Subject subject, ConnectionRequestInfo cxRequestInfo) throws ResourceException {
		TigrouConnection connection = new TigrouConnection(this, managedConnectionFactory);
		connections.add(connection);
		return connection;
	}

	@Override
	public void destroy() throws ResourceException {

	}

	@Override
	public void cleanup() throws ResourceException {
		for (Connection connection : connections) {
			((TigrouConnection) connection).setManagedConnection(null);
		}
		connections.clear();
	}

	@Override
	public void associateConnection(Object connection) throws ResourceException {
		if (connection == null || !(connection instanceof TigrouConnection)) {
			throw new ResourceException("invalid connection supplied");
		}
		((TigrouConnection) connection).setManagedConnection(this);
		connections.add((Connection) connection);
	}

	@Override
	public void addConnectionEventListener(ConnectionEventListener listener) {
		if (listener == null) {
			throw new IllegalArgumentException("listener cannot be null");
		}
		listeners.add(listener);
	}

	@Override
	public void removeConnectionEventListener(ConnectionEventListener listener) {
		if (listener == null) {
			throw new IllegalArgumentException("listener cannot be null");
		}
		listeners.remove(listener);
	}

	@Override
	public XAResource getXAResource() throws ResourceException {
		throw new NotSupportedException("GetXAResource not supported");
	}

	@Override
	public LocalTransaction getLocalTransaction() throws ResourceException {
		throw new NotSupportedException("LocalTransaction not supported");
	}

	@Override
	public ManagedConnectionMetaData getMetaData() throws ResourceException {
		return new TigrouManagedConnectionMetaData();
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
