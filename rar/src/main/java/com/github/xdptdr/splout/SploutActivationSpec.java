package com.github.xdptdr.splout;

import java.io.Serializable;

import javax.resource.ResourceException;
import javax.resource.spi.Activation;
import javax.resource.spi.ActivationSpec;
import javax.resource.spi.InvalidPropertyException;
import javax.resource.spi.ResourceAdapter;

@Activation(messageListeners = { SploutMessageListener.class })
public class SploutActivationSpec implements ActivationSpec, Serializable {

	private static final long serialVersionUID = 1L;

	private ResourceAdapter resourceAdapter;

	public SploutActivationSpec() {
	}

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
