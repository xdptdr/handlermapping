package com.github.xdptdr.splout;

import java.io.Serializable;

import javax.resource.ResourceException;
import javax.resource.spi.ConnectionManager;
import javax.resource.spi.ConnectionRequestInfo;
import javax.resource.spi.ManagedConnection;
import javax.resource.spi.ManagedConnectionFactory;

public class SploutConnectionManager implements ConnectionManager, Serializable {

	private static final long serialVersionUID = 1L;

	public SploutConnectionManager() {
	}

	@Override
	public Object allocateConnection(ManagedConnectionFactory mcf, ConnectionRequestInfo cxRequestInfo)
			throws ResourceException {
		ManagedConnection mc = mcf.createManagedConnection(null, cxRequestInfo);
		return mc.getConnection(null, cxRequestInfo);
	}

}
