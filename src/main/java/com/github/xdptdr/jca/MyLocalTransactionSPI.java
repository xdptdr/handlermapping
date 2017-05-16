package com.github.xdptdr.jca;

import javax.resource.ResourceException;
import javax.resource.spi.LocalTransaction;

public class MyLocalTransactionSPI implements LocalTransaction {

	@Override
	public void begin() throws ResourceException {
	}

	@Override
	public void commit() throws ResourceException {
	}

	@Override
	public void rollback() throws ResourceException {
	}

}
