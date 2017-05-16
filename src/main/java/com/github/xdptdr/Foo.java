package com.github.xdptdr;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class Foo {
	public static void main(String[] args) throws NamingException, JMSException {
		InitialContext ic = new InitialContext();
		ConnectionFactory cf = (ConnectionFactory) ic.lookup("/ConnectionFactory");
		Queue orderQueue = (Queue) ic.lookup("/queues/OrderQueue");
		Connection connection = cf.createConnection();
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		MessageProducer producer = session.createProducer(orderQueue);
		MessageConsumer consumer = session.createConsumer(orderQueue);
		connection.start();
		TextMessage message = session.createTextMessage("This is an order");
		producer.send(message);
		TextMessage receivedMessage = (TextMessage) consumer.receive();
		System.out.println("Got order: " + receivedMessage.getText());

	}
}
