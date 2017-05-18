package com.github.xdptdr.tigrou;

import javax.resource.ResourceException;
import javax.resource.spi.ManagedConnectionMetaData;

public class TigrouManagedConnectionMetaData implements ManagedConnectionMetaData {

	@Override
	public String getEISProductName() throws ResourceException {
		return "tigrou";
	}

	@Override
	public String getEISProductVersion() throws ResourceException {
		return "1.0";
	}

	@Override
	public int getMaxConnections() throws ResourceException {
		return 1;
	}

	@Override
	public String getUserName() throws ResourceException {
		return null;
	}

}
