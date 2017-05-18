package com.github.xdptdr.jca;

import javax.naming.NamingException;
import javax.naming.Reference;
import javax.resource.ResourceException;
import javax.resource.cci.Connection;
import javax.resource.cci.ConnectionFactory;
import javax.resource.cci.ConnectionSpec;
import javax.resource.cci.RecordFactory;
import javax.resource.cci.ResourceAdapterMetaData;

import com.github.xdptdr.bouip.BouipConnection;

public class MyConnectionFactory implements ConnectionFactory {

	private static final long serialVersionUID = 1L;
	private Reference reference = new Reference("className");
	private Connection connection = new BouipConnection();
	private RecordFactory recordFactory = new MyRecordFactory();
	private ResourceAdapterMetaData resourceAdapterMetaData = new MyResourceAdapterMetaData();

	@Override
	public void setReference(Reference reference) {

	}

	@Override
	public Reference getReference() throws NamingException {
		return reference;
	}

	@Override
	public Connection getConnection() throws ResourceException {
		return connection;
	}

	@Override
	public Connection getConnection(ConnectionSpec properties) throws ResourceException {
		return connection;
	}

	@Override
	public RecordFactory getRecordFactory() throws ResourceException {
		return recordFactory;
	}

	@Override
	public ResourceAdapterMetaData getMetaData() throws ResourceException {
		return resourceAdapterMetaData;
	}

}
