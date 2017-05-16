package com.github.xdptdr.jca;

import javax.naming.NamingException;
import javax.naming.Reference;
import javax.naming.Referenceable;

public class MyReferenceableNAMING implements Referenceable{

	private Reference reference;

	@Override
	public Reference getReference() throws NamingException {
		return reference ;
	}

}
