package com.github.xdptdr.cxf.abda;

import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.interceptor.Interceptor;
import org.apache.cxf.message.Message;
import org.apache.cxf.message.MessageImpl;

public class AbdaInterceptor implements Interceptor<Message> {

	public static final String CONTENT = AbdaInterceptor.class.getName() + ".content";

	@Override
	public void handleMessage(Message message) throws Fault {
		String input = (String) message.get(CONTENT);
		Message output = new MessageImpl();
		output.put(CONTENT, input + "!" + input);
		message.getExchange().setOutMessage(output);
	}

	@Override
	public void handleFault(Message message) {

	}

}
