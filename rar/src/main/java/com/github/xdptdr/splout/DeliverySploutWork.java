package com.github.xdptdr.splout;

import java.util.ArrayList;
import java.util.List;

import javax.resource.spi.work.Work;
import javax.resource.spi.work.WorkContext;
import javax.resource.spi.work.WorkContextProvider;

public class DeliverySploutWork implements Work, WorkContextProvider {

	private static final long serialVersionUID = 1L;
	private EndpointConsumer endpointConsumer;
	private Message message;
	private List<WorkContext> workContexts = new ArrayList<>();

	public DeliverySploutWork(EndpointConsumer ec, Message msg) {
		endpointConsumer = ec;
		this.message = msg;
	}

	@Override
	public void run() {
		try {
			endpointConsumer.deliverMessage(message);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public List<WorkContext> getWorkContexts() {
		return workContexts;
	}

	@Override
	public void release() {

	}

}
