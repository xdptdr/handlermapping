package com.github.xdptdr.jca.base;

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

public abstract class AbstractConnectionFactory implements ConnectionFactory, Referenceable, Serializable {

	private static final long serialVersionUID = 1L;

	private Reference reference;

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
		return null;
	}

	@Override
	public Connection getConnection(ConnectionSpec properties) throws ResourceException {
		return null;
	}

	@Override
	public RecordFactory getRecordFactory() throws ResourceException {
		return null;
	}

	@Override
	public ResourceAdapterMetaData getMetaData() throws ResourceException {
		return null;
	}

}
