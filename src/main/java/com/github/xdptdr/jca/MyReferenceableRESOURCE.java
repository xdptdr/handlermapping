package com.github.xdptdr.jca;

import javax.naming.Reference;
import javax.resource.Referenceable;

public class MyReferenceableRESOURCE extends MyReferenceableNAMING implements Referenceable {

	private Reference reference;

	@Override
	public void setReference(Reference reference) {
		this.reference = reference;		
	}



}
