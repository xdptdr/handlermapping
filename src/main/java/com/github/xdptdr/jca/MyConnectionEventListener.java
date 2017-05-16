package com.github.xdptdr.jca;

import javax.resource.spi.ConnectionEvent;
import javax.resource.spi.ConnectionEventListener;

public class MyConnectionEventListener implements ConnectionEventListener {

	@Override
	public void connectionClosed(ConnectionEvent event) {

	}

	@Override
	public void localTransactionStarted(ConnectionEvent event) {

	}

	@Override
	public void localTransactionCommitted(ConnectionEvent event) {

	}

	@Override
	public void localTransactionRolledback(ConnectionEvent event) {

	}

	@Override
	public void connectionErrorOccurred(ConnectionEvent event) {

	}

}
