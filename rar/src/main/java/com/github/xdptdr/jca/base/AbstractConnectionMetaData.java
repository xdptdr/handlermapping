package com.github.xdptdr.jca.base;

import javax.resource.ResourceException;
import javax.resource.cci.ConnectionMetaData;

public abstract class AbstractConnectionMetaData implements ConnectionMetaData {

	@Override
	public String getEISProductName() throws ResourceException {
		return null;
	}

	@Override
	public String getEISProductVersion() throws ResourceException {
		return null;
	}

	@Override
	public String getUserName() throws ResourceException {
		return null;
	}

}
