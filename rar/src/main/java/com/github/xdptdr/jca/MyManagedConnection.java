package com.github.xdptdr.jca;

import java.io.PrintWriter;

import javax.resource.ResourceException;
import javax.resource.spi.ConnectionEventListener;
import javax.resource.spi.ConnectionRequestInfo;
import javax.resource.spi.LocalTransaction;
import javax.resource.spi.ManagedConnection;
import javax.resource.spi.ManagedConnectionMetaData;
import javax.security.auth.Subject;
import javax.transaction.xa.XAResource;

public class MyManagedConnection implements ManagedConnection {

	private Object connection = new Object();
	private XAResource xaResource = new MyXAResource();
	private LocalTransaction localTransaction = new MyLocalTransactionSPI();
	private ManagedConnectionMetaData managedConnectionMetaData = new MyManagedConnectionMetaData();
	private PrintWriter logWriter;

	@Override
	public Object getConnection(Subject subject, ConnectionRequestInfo cxRequestInfo) throws ResourceException {
		return connection;
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

	}

	@Override
	public void removeConnectionEventListener(ConnectionEventListener listener) {

	}

	@Override
	public XAResource getXAResource() throws ResourceException {
		return xaResource;
	}

	@Override
	public LocalTransaction getLocalTransaction() throws ResourceException {
		return localTransaction;
	}

	@Override
	public ManagedConnectionMetaData getMetaData() throws ResourceException {
		return managedConnectionMetaData;
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
