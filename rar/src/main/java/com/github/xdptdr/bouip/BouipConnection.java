package com.github.xdptdr.bouip;

import javax.resource.ResourceException;
import javax.resource.cci.Connection;
import javax.resource.cci.ConnectionMetaData;
import javax.resource.cci.Interaction;
import javax.resource.cci.LocalTransaction;
import javax.resource.cci.ResultSetInfo;

public class BouipConnection implements Connection {

	public BouipConnection() {
	}

	public BouipConnection(BouipManagedConnection managedConnection) {
	}

	@Override
	public Interaction createInteraction() throws ResourceException {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public LocalTransaction getLocalTransaction() throws ResourceException {
		return null;
	}

	@Override
	public ConnectionMetaData getMetaData() throws ResourceException {
		return new ConnectionMetaData() {
			@Override
			public String getEISProductName() {
				return "My Connector Platform";
			}

			@Override
			public String getEISProductVersion() {
				return "1.0";
			}

			@Override
			public String getUserName() {
				return "myUser";
			}
		};
	}

	@Override
	public ResultSetInfo getResultSetInfo() throws ResourceException {
		return null;
	}

	@Override
	public void close() throws ResourceException {
		throw new UnsupportedOperationException("Not supported yet.");
	}

}
