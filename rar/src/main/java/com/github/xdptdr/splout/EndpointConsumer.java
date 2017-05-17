package com.github.xdptdr.splout;

import javax.resource.spi.endpoint.MessageEndpoint;
import javax.resource.spi.endpoint.MessageEndpointFactory;

public class EndpointConsumer {

	private MessageEndpointFactory endpointFactory;
	private SploutActivationSpec activationSpec;
	private MailServerFolder folder;

	public EndpointConsumer(MessageEndpointFactory endpointFactory, SploutActivationSpec spec) {
		this.endpointFactory = endpointFactory;
		this.activationSpec = spec;
		try {
			folder = new MailServerFolder(activationSpec);
		} catch (AuthenticationFailedException ie) {
			throw ie;
		} catch (Exception ex) {
			throw ex;
		}

	}

	public void deliverMessage(Message message) {
		MessageEndpoint endpoint = null;
		try {
			if ((endpoint = endpointFactory.createEndpoint(null)) != null) {
				((SploutMessageListener) endpoint).onMessage();
			}
		} catch (Throwable ex) {
			ex.printStackTrace();
		} finally {
			if (endpoint != null) {
				endpoint.release();
			}
		}

	}

	public boolean hasNewMessages() {
		return true;
	}

	public Message[] getNewMessages() {
		return new Message[] {};
	}

}
