package com.github.xdptdr.tigrou;

import javax.resource.ResourceException;
import javax.resource.cci.Connection;
import javax.resource.cci.ConnectionMetaData;
import javax.resource.cci.Interaction;
import javax.resource.cci.LocalTransaction;
import javax.resource.cci.ResultSetInfo;
import javax.resource.spi.ManagedConnection;
import javax.resource.spi.ManagedConnectionFactory;

public class TigrouConnection implements Connection {

	private ManagedConnection managedConnection;
	private ManagedConnectionFactory managedConnectionFactory;

	public TigrouConnection(ManagedConnection managedConnection, ManagedConnectionFactory managedConnectionFactory) {
		this.managedConnection = managedConnection;
		this.managedConnectionFactory = managedConnectionFactory;
	}

	@Override
	public Interaction createInteraction() throws ResourceException {
		return null;
	}

	@Override
	public LocalTransaction getLocalTransaction() throws ResourceException {
		return null;
	}

	@Override
	public ConnectionMetaData getMetaData() throws ResourceException {
		return null;
	}

	@Override
	public ResultSetInfo getResultSetInfo() throws ResourceException {
		return null;
	}

	@Override
	public void close() throws ResourceException {

	}

	public void setManagedConnection(ManagedConnection managedConnection) {
		this.managedConnection = managedConnection;

	}

}
