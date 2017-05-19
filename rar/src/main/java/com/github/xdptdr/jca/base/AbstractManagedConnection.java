package com.github.xdptdr.jca.base;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.resource.NotSupportedException;
import javax.resource.ResourceException;
import javax.resource.spi.ConnectionEventListener;
import javax.resource.spi.ConnectionRequestInfo;
import javax.resource.spi.LocalTransaction;
import javax.resource.spi.ManagedConnection;
import javax.resource.spi.ManagedConnectionMetaData;
import javax.security.auth.Subject;
import javax.transaction.xa.XAResource;

public abstract class AbstractManagedConnection implements ManagedConnection {

	private PrintWriter logWriter;
	private List<ConnectionEventListener> listeners = new ArrayList<>();

	@Override
	public Object getConnection(Subject subject, ConnectionRequestInfo cxRequestInfo) throws ResourceException {
		return null;
	}

	@Override
	public void destroy() throws ResourceException {

	}

	@Override
	public void cleanup() throws ResourceException {

	}

	@Override
	public void associateConnection(Object connection) throws ResourceException {

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
		throw new NotSupportedException("getXAResource not supported");
	}

	@Override
	public LocalTransaction getLocalTransaction() throws ResourceException {
		throw new NotSupportedException("getLocalTransaction not supported");
	}

	@Override
	public ManagedConnectionMetaData getMetaData() throws ResourceException {
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

}
