package com.github.xdptdr.jca;

import javax.resource.ResourceException;
import javax.resource.cci.Connection;
import javax.resource.cci.Interaction;
import javax.resource.cci.InteractionSpec;
import javax.resource.cci.Record;
import javax.resource.cci.ResourceWarning;

public class MyInteraction implements Interaction {

	private Connection connection = new MyConnection();
	private Record record = new MyRecord();
	private ResourceWarning resourceWarning = new ResourceWarning();

	@Override
	public void close() throws ResourceException {

	}

	@Override
	public Connection getConnection() {
		return connection;
	}

	@Override
	public boolean execute(InteractionSpec ispec, Record input, Record output) throws ResourceException {
		return false;
	}

	@Override
	public Record execute(InteractionSpec ispec, Record input) throws ResourceException {
		return record;
	}

	@Override
	public ResourceWarning getWarnings() throws ResourceException {
		return resourceWarning;
	}

	@Override
	public void clearWarnings() throws ResourceException {

	}

}
