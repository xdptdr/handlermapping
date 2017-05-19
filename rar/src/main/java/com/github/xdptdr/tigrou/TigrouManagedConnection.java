package com.github.xdptdr.tigrou;

import javax.resource.ResourceException;
import javax.resource.spi.ConnectionRequestInfo;
import javax.security.auth.Subject;

import com.github.xdptdr.jca.base.AbstractManagedConnection;

public class TigrouManagedConnection extends AbstractManagedConnection {

	public TigrouManagedConnection() {
	}

	@Override
	public Object getConnection(Subject subject, ConnectionRequestInfo cxRequestInfo) throws ResourceException {
		return new TigrouConnection();
	}

}
