package com.github.xdptdr.jca;

import javax.resource.ResourceException;
import javax.resource.cci.ConnectionMetaData;

public class MyConnectionMetaData implements ConnectionMetaData {

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
	public String getUserName() throws ResourceException {
		return userName;
	}

}
