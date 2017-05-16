package com.github.xdptdr.jca;

import java.util.Timer;

import javax.resource.spi.BootstrapContext;
import javax.resource.spi.UnavailableException;
import javax.resource.spi.XATerminator;
import javax.resource.spi.work.WorkContext;
import javax.resource.spi.work.WorkManager;
import javax.transaction.TransactionSynchronizationRegistry;

public class MyBootstrapContext implements BootstrapContext {

	private WorkManager workManager;
	private XATerminator xaTerminator;
	private TransactionSynchronizationRegistry transactionSynchronizationRegistry;

	public MyBootstrapContext() {
		workManager = new MyWorkManager();
		xaTerminator = new MyXATerminator();
		transactionSynchronizationRegistry = new MyTransactionSynchronizationRegistry();
	}

	@Override
	public WorkManager getWorkManager() {
		return workManager;
	}

	@Override
	public XATerminator getXATerminator() {
		return xaTerminator;
	}

	@Override
	public Timer createTimer() throws UnavailableException {
		return new Timer();
	}

	@Override
	public boolean isContextSupported(Class<? extends WorkContext> workContextClass) {
		return true;
	}

	@Override
	public TransactionSynchronizationRegistry getTransactionSynchronizationRegistry() {
		return transactionSynchronizationRegistry;
	}

}
