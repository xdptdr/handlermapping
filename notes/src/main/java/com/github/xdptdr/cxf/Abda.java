package com.github.xdptdr.cxf;

import org.apache.cxf.interceptor.Interceptor;
import org.apache.cxf.message.Exchange;
import org.apache.cxf.message.ExchangeImpl;
import org.apache.cxf.message.Message;
import org.apache.cxf.message.MessageImpl;

public class Abda {
	public static void main(String[] args) {

		Exchange exchange = new ExchangeImpl();

		Message in = new MessageImpl();
		in.setExchange(exchange);
		in.put(AbdaInterceptor.CONTENT, "foo");

		Interceptor<Message> interceptor = new AbdaInterceptor();
		interceptor.handleMessage(in);

		Message out = exchange.getOutMessage();

		System.out.println(out.get(AbdaInterceptor.CONTENT));

	}
}
