package com.github.xdptdr.jca;

import javax.resource.ResourceException;
import javax.resource.cci.ResultSetInfo;

public class MyResultSetInfo implements ResultSetInfo {

	@Override
	public boolean updatesAreDetected(int type) throws ResourceException {
		return false;
	}

	@Override
	public boolean insertsAreDetected(int type) throws ResourceException {
		return false;
	}

	@Override
	public boolean deletesAreDetected(int type) throws ResourceException {
		return false;
	}

	@Override
	public boolean supportsResultSetType(int type) throws ResourceException {
		return false;
	}

	@Override
	public boolean supportsResultTypeConcurrency(int type, int concurrency) throws ResourceException {
		return false;
	}

	@Override
	public boolean othersUpdatesAreVisible(int type) throws ResourceException {
		return false;
	}

	@Override
	public boolean othersDeletesAreVisible(int type) throws ResourceException {
		return false;
	}

	@Override
	public boolean othersInsertsAreVisible(int type) throws ResourceException {
		return false;
	}

	@Override
	public boolean ownUpdatesAreVisible(int type) throws ResourceException {
		return false;
	}

	@Override
	public boolean ownInsertsAreVisible(int type) throws ResourceException {
		return false;
	}

	@Override
	public boolean ownDeletesAreVisible(int type) throws ResourceException {
		return false;
	}

}
