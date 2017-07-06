package com.github.xdptdr.jaxws.clients.ammit;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPException;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

public class AmmitHandler implements SOAPHandler<SOAPMessageContext> {

	@SuppressWarnings({ "unused", "rawtypes" })
	@Override
	public boolean handleMessage(SOAPMessageContext context) {
		try {
			context.getMessage().writeTo(System.out);
		} catch (SOAPException | IOException e) {
			e.printStackTrace();
		}
		System.out.println();
		System.out.println();

		return true;
	}

	@Override
	public boolean handleFault(SOAPMessageContext context) {
		return true;
	}

	@Override
	public void close(MessageContext context) {
	}

	@Override
	public Set<QName> getHeaders() {
		return new HashSet<>();
	}

}
