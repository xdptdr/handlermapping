package com.github.xdptdr.splout;

import java.io.Serializable;

import javax.naming.NamingException;
import javax.naming.Reference;
import javax.naming.Referenceable;
import javax.resource.spi.ConnectionManager;
import javax.resource.spi.ManagedConnectionFactory;

public class SploutConnectionFactory implements Serializable, Referenceable {

	private static final long serialVersionUID = 1L;
	private ManagedConnectionFactory mcf;
	private ConnectionManager cm;
	private Reference reference;

	public SploutConnectionFactory(ManagedConnectionFactory mcf, ConnectionManager cm) {
		this.mcf = mcf;
		if (cm == null) {
			this.cm = new SploutConnectionManager();
		} else {
			this.cm = cm;
		}
	}

	@Override
	public Reference getReference() throws NamingException {
		return reference;
	}

	public void setReference(Reference reference) {
		this.reference = reference;
	}

}
