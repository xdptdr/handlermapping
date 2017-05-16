package com.github.xdptdr.jca;

import javax.resource.ResourceException;
import javax.resource.spi.ConnectionManager;
import javax.resource.spi.ConnectionRequestInfo;
import javax.resource.spi.ManagedConnectionFactory;

public class MyConnectionManager implements ConnectionManager {

	private static final long serialVersionUID = 1L;

	@Override
	public Object allocateConnection(ManagedConnectionFactory mcf, ConnectionRequestInfo cxRequestInfo)
			throws ResourceException {
		return null;
	}

}
