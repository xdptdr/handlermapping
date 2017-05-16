package com.github.xdptdr.jca;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Synchronization;
import javax.transaction.TransactionSynchronizationRegistry;

public class MyTransactionSynchronizationRegistry implements TransactionSynchronizationRegistry {

	private Object key = new Object();
	private boolean rollbackOnly;
	private List<Synchronization> synchronizations = new ArrayList<>();
	private Map<Object, Object> resources = new HashMap<>();

	public MyTransactionSynchronizationRegistry() {
	}

	@Override
	public Object getTransactionKey() {
		return key;
	}

	@Override
	public int getTransactionStatus() {
		return 0;
	}

	@Override
	public boolean getRollbackOnly() throws IllegalStateException {
		return rollbackOnly;
	}

	@Override
	public void setRollbackOnly() throws IllegalStateException {
		rollbackOnly = true;
	}

	@Override
	public void registerInterposedSynchronization(Synchronization sync) throws IllegalStateException {
		synchronizations.add(sync);
	}

	@Override
	public Object getResource(Object key) throws IllegalStateException {
		return resources.get(key);
	}

	@Override
	public void putResource(Object key, Object value) throws IllegalStateException {
		resources.put(key, value);
	}

}
