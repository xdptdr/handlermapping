package com.github.xdptdr.jca;

import javax.resource.ResourceException;
import javax.resource.spi.ConnectionRequestInfo;
import javax.resource.spi.LazyAssociatableConnectionManager;
import javax.resource.spi.ManagedConnectionFactory;

public class MyLazyAssociatableConnectionManager implements LazyAssociatableConnectionManager {

	@Override
	public void associateConnection(Object connection, ManagedConnectionFactory mcf, ConnectionRequestInfo cxReqInfo)
			throws ResourceException {

	}

	@Override
	public void inactiveConnectionClosed(Object connection, ManagedConnectionFactory mcf) {

	}

}
