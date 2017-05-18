package com.github.xdptdr.jca;

import javax.resource.ResourceException;
import javax.resource.spi.ResourceAdapter;
import javax.resource.spi.ResourceAdapterAssociation;

import com.github.xdptdr.bouip.BouipResourceAdapter;

public class MyResourceAdapterAssociation implements ResourceAdapterAssociation {

	private ResourceAdapter resourceAdapter = new BouipResourceAdapter();

	@Override
	public ResourceAdapter getResourceAdapter() {
		return resourceAdapter;
	}

	@Override
	public void setResourceAdapter(ResourceAdapter ra) throws ResourceException {
		resourceAdapter = ra;

	}

}
