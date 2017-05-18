package com.github.xdptdr.tigrou;

import javax.resource.ResourceException;
import javax.resource.spi.ActivationSpec;
import javax.resource.spi.BootstrapContext;
import javax.resource.spi.Connector;
import javax.resource.spi.ResourceAdapter;
import javax.resource.spi.ResourceAdapterInternalException;
import javax.resource.spi.endpoint.MessageEndpointFactory;
import javax.transaction.xa.XAResource;

@Connector
public class TigrouResourceAdapter implements ResourceAdapter {

	@Override
	public void start(BootstrapContext ctx) throws ResourceAdapterInternalException {
		System.out.println(this.getClass().getName() + " start");
	}

	@Override
	public void stop() {
		System.out.println(this.getClass().getName() + " stop");
	}

	@Override
	public void endpointActivation(MessageEndpointFactory endpointFactory, ActivationSpec spec)
			throws ResourceException {
		System.out.println(this.getClass().getName() + " endpointActivation");
	}

	@Override
	public void endpointDeactivation(MessageEndpointFactory endpointFactory, ActivationSpec spec) {
		System.out.println(this.getClass().getName() + " endpointDeactivation");
	}

	@Override
	public XAResource[] getXAResources(ActivationSpec[] specs) throws ResourceException {
		System.out.println(this.getClass().getName() + " getXAResources");
		return null;
	}
	
	@Override
	public int hashCode() {
		return super.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}

}
