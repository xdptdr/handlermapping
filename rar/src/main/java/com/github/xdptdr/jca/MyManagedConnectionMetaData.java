package com.github.xdptdr.jca;

import javax.resource.ResourceException;
import javax.resource.spi.ManagedConnectionMetaData;

public class MyManagedConnectionMetaData implements ManagedConnectionMetaData {

	private String eisProductName = "eisProductName";
	private String eisProductVersion = "eisProductVersion";
	private String userName = "userName";

	@Override
	public String getEISProductName() throws ResourceException {
		return eisProductName;
	}

	@Override
	public String getEISProductVersion() throws ResourceException {
		return eisProductVersion;
	}

	@Override
	public int getMaxConnections() throws ResourceException {
		return 1;
	}

	@Override
	public String getUserName() throws ResourceException {
		return userName;
	}

}
