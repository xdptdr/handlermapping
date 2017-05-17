package com.github.xdptdr.splout;

import javax.resource.ResourceException;
import javax.resource.spi.ActivationSpec;
import javax.resource.spi.InvalidPropertyException;
import javax.resource.spi.ResourceAdapter;

public class MyActivationSpec implements ActivationSpec {

	private ResourceAdapter resourceAdapter = null;

	@Override
	public ResourceAdapter getResourceAdapter() {
		return resourceAdapter;
	}

	@Override
	public void setResourceAdapter(ResourceAdapter ra) throws ResourceException {
		resourceAdapter = ra;
	}

	@Override
	public void validate() throws InvalidPropertyException {

	}

}
