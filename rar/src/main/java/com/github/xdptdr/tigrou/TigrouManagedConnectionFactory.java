package com.github.xdptdr.tigrou;

import javax.resource.ResourceException;
import javax.resource.cci.Connection;
import javax.resource.cci.ConnectionFactory;
import javax.resource.spi.ConnectionDefinition;
import javax.resource.spi.ConnectionManager;
import javax.resource.spi.ConnectionRequestInfo;
import javax.resource.spi.ManagedConnection;
import javax.security.auth.Subject;

import com.github.xdptdr.jca.base.AbstractManagedConnectionFactory;

@ConnectionDefinition(connectionImpl = TigrouConnection.class, connection = Connection.class, connectionFactoryImpl = TigrouConnectionFactory.class, connectionFactory = ConnectionFactory.class)
public class TigrouManagedConnectionFactory extends AbstractManagedConnectionFactory {

	private static final long serialVersionUID = 1L;

	public TigrouManagedConnectionFactory() {
	}

	@Override
	public Object createConnectionFactory(ConnectionManager cxManager) throws ResourceException {
		return new TigrouConnectionFactory(this, cxManager);
	}

	@Override
	public ManagedConnection createManagedConnection(Subject subject, ConnectionRequestInfo cxRequestInfo)
			throws ResourceException {
		return new TigrouManagedConnection();
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
