package com.github.xdptdr.splout;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.resource.spi.endpoint.MessageEndpointFactory;
import javax.resource.spi.work.Work;
import javax.resource.spi.work.WorkException;
import javax.resource.spi.work.WorkManager;

public class PollingSploutWork implements Work {

	private boolean active;
	private transient WorkManager workManager;
	private transient Map<MessageEndpointFactory, EndpointConsumer> endointConsumers;

	public PollingSploutWork(WorkManager workManager) {
		active = true;
		this.workManager = workManager;
		endointConsumers = new HashMap<>();
	}

	@Override
	public void run() {
		while (active) {
			try {
				pollEndpoints();
				Thread.sleep(1000);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	private void pollEndpoints() {
		synchronized (endointConsumers) {

			for (Entry<MessageEndpointFactory, EndpointConsumer> entry : endointConsumers.entrySet()) {
				EndpointConsumer consumer = entry.getValue();
				try {
					if (consumer.hasNewMessages()) {
						Message[] messages = consumer.getNewMessages();
						for (Message message : messages) {
							scheduleMessageDeliveryThread(consumer, message);
						}
					}
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}
	}

	private void scheduleMessageDeliveryThread(EndpointConsumer consumer, Message message) throws WorkException {
		Work work = new DeliverySploutWork(consumer, message);
		workManager.scheduleWork(work);
	}

	@Override
	public void release() {
		active = false;
	}

	public void stopPolling() {
		removeAllEndpointConsumers();
		active = false;
	}

	private void removeAllEndpointConsumers() {
		synchronized (endointConsumers) {
			for (Entry<MessageEndpointFactory, EndpointConsumer> entry : endointConsumers.entrySet()) {
				endointConsumers.remove(entry.getKey());
			}
		}
	}

	public void addEndpointConsumer(MessageEndpointFactory endpointFactory, EndpointConsumer ec) {
		synchronized (endointConsumers) {
			endointConsumers.put(endpointFactory, ec);
		}
	}

	public void removeEndpointConsumer(MessageEndpointFactory endpointFactory) {
		synchronized (endointConsumers) {
			endointConsumers.remove(endpointFactory);

		}

	}

}
