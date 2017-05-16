package com.github.xdptdr.jca;

import javax.resource.ResourceException;
import javax.resource.spi.LazyEnlistableConnectionManager;
import javax.resource.spi.ManagedConnection;

public class MyLazyEnlistableConnectionManager implements LazyEnlistableConnectionManager {

	@Override
	public void lazyEnlist(ManagedConnection mc) throws ResourceException {

	}

}
