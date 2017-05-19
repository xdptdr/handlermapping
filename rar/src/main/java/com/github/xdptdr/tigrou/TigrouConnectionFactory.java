package com.github.xdptdr.tigrou;

import javax.resource.ResourceException;
import javax.resource.cci.Connection;
import javax.resource.cci.ConnectionSpec;
import javax.resource.spi.ConnectionManager;
import javax.resource.spi.ManagedConnectionFactory;

import com.github.xdptdr.jca.base.AbstractConnectionFactory;

public class TigrouConnectionFactory extends AbstractConnectionFactory {

	private static final long serialVersionUID = 1L;

	private ConnectionManager connectionManager;
	private ManagedConnectionFactory managedConnectionFactory;

	public TigrouConnectionFactory() {
	}

	public TigrouConnectionFactory(ManagedConnectionFactory managedConnectionFactory,
			ConnectionManager connectionManager) {
		this.connectionManager = connectionManager;
		this.managedConnectionFactory = managedConnectionFactory;
	}

	@Override
	public Connection getConnection() throws ResourceException {
		return (Connection) connectionManager.allocateConnection(managedConnectionFactory, null);
	}

	@Override
	public Connection getConnection(ConnectionSpec properties) throws ResourceException {
		return (Connection) connectionManager.allocateConnection(managedConnectionFactory, null);
	}

}
