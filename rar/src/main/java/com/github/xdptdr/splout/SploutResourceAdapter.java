package com.github.xdptdr.splout;

import java.io.Serializable;

import javax.resource.ResourceException;
import javax.resource.spi.ActivationSpec;
import javax.resource.spi.BootstrapContext;
import javax.resource.spi.Connector;
import javax.resource.spi.ResourceAdapter;
import javax.resource.spi.ResourceAdapterInternalException;
import javax.resource.spi.endpoint.MessageEndpointFactory;
import javax.resource.spi.work.Work;
import javax.resource.spi.work.WorkManager;
import javax.resource.spi.work.WorkRejectedException;
import javax.transaction.xa.XAResource;

@Connector
public class SploutResourceAdapter implements ResourceAdapter, Serializable {

	private static final long serialVersionUID = 1L;

	private String server;
	private String port;

	private transient WorkManager workManager;

	private Work pollingThread;

	public SploutResourceAdapter() {
	}

	@Override
	public void start(BootstrapContext ctx) throws ResourceAdapterInternalException {

		try {
			workManager = ctx.getWorkManager();
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new ResourceAdapterInternalException(ex);
		}

		try {
			pollingThread = new PollingSploutWork(workManager);
			workManager.scheduleWork(pollingThread);
		} catch (WorkRejectedException ex) {
			throw new ResourceAdapterInternalException(ex);
		} catch (Exception ex) {
			throw new ResourceAdapterInternalException(ex);
		}
	}

	@Override
	public void stop() {
		try {
			((PollingSploutWork) pollingThread).stopPolling();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public void endpointActivation(MessageEndpointFactory endpointFactory, ActivationSpec spec)
			throws ResourceException {
		try {
			EndpointConsumer ec = new EndpointConsumer(endpointFactory, (SploutActivationSpec) spec);
			((PollingSploutWork) pollingThread).addEndpointConsumer(endpointFactory, ec);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public void endpointDeactivation(MessageEndpointFactory endpointFactory, ActivationSpec spec) {
		((PollingSploutWork) pollingThread).removeEndpointConsumer(endpointFactory);
	}

	@Override
	public XAResource[] getXAResources(ActivationSpec[] specs) throws ResourceException {
		return null;
	}

	public String getServer() {
		return server;
	}

	public void setServer(String server) {
		this.server = server;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

}
