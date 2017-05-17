package com.github.xdptdr.splout;

import javax.resource.ResourceException;
import javax.resource.cci.ConnectionMetaData;

import com.github.xdptdr.jca.MyManagedConnection;

public class SploutConnectionMetaData implements ConnectionMetaData {

	private String eisProductName = "eisProductName";
	private String eisProductVersion = "eisProductVersion";
	private String userName = "userName";
	private MyManagedConnection mc;

	public SploutConnectionMetaData(MyManagedConnection mc) {
		this.mc = mc;
	}

	@Override
	public String getEISProductName() throws ResourceException {
		throwIfDestroyed();
		return eisProductName;
	}

	@Override
	public String getEISProductVersion() throws ResourceException {
		throwIfDestroyed();
		return eisProductVersion;
	}

	@Override
	public String getUserName() throws ResourceException {
		throwIfDestroyed();
		return userName;
	}

	private void throwIfDestroyed() throws ResourceException {
		if (mc == null || mc.isDestroyed()) {
			throw new ResourceException("destroyed");
		}
	}
}
