package com.github.xdptdr.tigrou;

import javax.resource.ResourceException;
import javax.resource.cci.ConnectionMetaData;

import com.github.xdptdr.jca.base.AbstractConnection;

public class TigrouConnection extends AbstractConnection {

	private ConnectionMetaData metadata = new TigrouConnectionMetaData();

	@Override
	public ConnectionMetaData getMetaData() throws ResourceException {
		return metadata;
	}

}
