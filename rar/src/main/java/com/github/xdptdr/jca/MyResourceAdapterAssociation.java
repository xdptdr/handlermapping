package com.github.xdptdr.jca;

import javax.resource.ResourceException;
import javax.resource.spi.ResourceAdapter;
import javax.resource.spi.ResourceAdapterAssociation;

import com.github.xdptdr.splout.SploutResourceAdapter;

public class MyResourceAdapterAssociation implements ResourceAdapterAssociation {

	private ResourceAdapter resourceAdapter = new SploutResourceAdapter();

	@Override
	public ResourceAdapter getResourceAdapter() {
		return resourceAdapter;
	}

	@Override
	public void setResourceAdapter(ResourceAdapter ra) throws ResourceException {
		resourceAdapter = ra;

	}

}
