package com.github.xdptdr.tigrou;

import java.io.Serializable;

import javax.naming.NamingException;
import javax.naming.Reference;
import javax.naming.Referenceable;
import javax.resource.ResourceException;
import javax.resource.cci.Connection;
import javax.resource.cci.ConnectionFactory;
import javax.resource.cci.ConnectionSpec;
import javax.resource.cci.RecordFactory;
import javax.resource.cci.ResourceAdapterMetaData;
import javax.resource.spi.ConnectionManager;
import javax.resource.spi.ManagedConnectionFactory;

public class TigrouConnectionFactory implements ConnectionFactory, Referenceable, Serializable {

	private static final long serialVersionUID = 1L;
	private Reference reference;
	private RecordFactory recordFactory;
	private ResourceAdapterMetaData metadata = new TigrouResourceAdapterMetaData();
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
	public void setReference(Reference reference) {
		this.reference = reference;
	}

	@Override
	public Reference getReference() throws NamingException {
		return reference;
	}

	@Override
	public Connection getConnection() throws ResourceException {
		return (Connection) connectionManager.allocateConnection(managedConnectionFactory, null);
	}

	@Override
	public Connection getConnection(ConnectionSpec properties) throws ResourceException {
		return (Connection) connectionManager.allocateConnection(managedConnectionFactory, null);
	}

	@Override
	public RecordFactory getRecordFactory() throws ResourceException {
		return recordFactory;
	}

	@Override
	public ResourceAdapterMetaData getMetaData() throws ResourceException {
		return metadata;
	}

}
