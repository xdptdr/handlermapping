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
		Connection connection = (Connection) connectionManager.allocateConnection(managedConnectionFactory, null);

		return connection;
	}

	@Override
	public Connection getConnection(ConnectionSpec connectionSpec) throws ResourceException {
		Connection connection = (Connection) connectionManager.allocateConnection(managedConnectionFactory, null);

		return connection;
	}

}
