package com.github.xdptdr.jca;

import javax.resource.ResourceException;
import javax.resource.cci.Connection;
import javax.resource.cci.ConnectionMetaData;
import javax.resource.cci.Interaction;
import javax.resource.cci.LocalTransaction;
import javax.resource.cci.ResultSetInfo;

import com.github.xdptdr.splout.SploutConnectionMetaData;

public class MyConnection implements Connection {

	private Interaction interaction = new MyInteraction();
	private LocalTransaction localTransaction = new MyLocalTransactionCCI();
	private ConnectionMetaData connectionMetaData = new SploutConnectionMetaData(null);
	private ResultSetInfo resultSetInfo = new MyResultSetInfo();

	@Override
	public Interaction createInteraction() throws ResourceException {
		return interaction;
	}

	@Override
	public LocalTransaction getLocalTransaction() throws ResourceException {
		return localTransaction;
	}

	@Override
	public ConnectionMetaData getMetaData() throws ResourceException {
		return connectionMetaData;
	}

	@Override
	public ResultSetInfo getResultSetInfo() throws ResourceException {
		return resultSetInfo;
	}

	@Override
	public void close() throws ResourceException {

	}

}
