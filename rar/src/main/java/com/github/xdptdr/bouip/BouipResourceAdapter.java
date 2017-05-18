package com.github.xdptdr.bouip;

import javax.resource.ResourceException;
import javax.resource.spi.ActivationSpec;
import javax.resource.spi.BootstrapContext;
import javax.resource.spi.Connector;
import javax.resource.spi.ResourceAdapter;
import javax.resource.spi.ResourceAdapterInternalException;
import javax.resource.spi.endpoint.MessageEndpointFactory;
import javax.transaction.xa.XAResource;

@Connector
public class BouipResourceAdapter implements ResourceAdapter {

	public BouipResourceAdapter() {
	}

	@Override
	public void start(BootstrapContext ctx) throws ResourceAdapterInternalException {
		System.out.println(this.getClass().getName() + ": start");
	}

	@Override
	public void stop() {
		System.out.println(this.getClass().getName() + ": stop");
	}

	@Override
	public void endpointActivation(MessageEndpointFactory endpointFactory, ActivationSpec spec)
			throws ResourceException {
		System.out.println(this.getClass().getName() + ": endpointActivation");
	}

	@Override
	public void endpointDeactivation(MessageEndpointFactory endpointFactory, ActivationSpec spec) {
		System.out.println(this.getClass().getName() + ": endpointDeactivation");
	}

	@Override
	public XAResource[] getXAResources(ActivationSpec[] specs) throws ResourceException {
		System.out.println(this.getClass().getName() + ": getXAResources");
		return null;
	}

}
