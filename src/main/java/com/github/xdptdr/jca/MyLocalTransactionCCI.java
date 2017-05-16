package com.github.xdptdr.jca;

import javax.resource.ResourceException;
import javax.resource.cci.LocalTransaction;

public class MyLocalTransactionCCI implements LocalTransaction {

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
