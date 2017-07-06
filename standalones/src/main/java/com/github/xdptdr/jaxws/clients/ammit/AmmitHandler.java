package com.github.xdptdr.jaxws.clients.ammit;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPException;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

public class AmmitHandler implements SOAPHandler<SOAPMessageContext> {

	@Override
	public boolean handleMessage(SOAPMessageContext context) {

		for (Entry<String, Object> entry : context.entrySet()) {
			StringBuffer buf = new StringBuffer();
			buf.append(entry.getKey());
			buf.append(" : ");
			Object value = entry.getValue();
			if (value != null) {
				if (value instanceof String) {
					buf.append(value);
				} else if (value instanceof Number) {
					buf.append(value);
				} else if (value instanceof Boolean) {
					buf.append(value);
				} else if (value instanceof QName) {
					buf.append(((QName) value).getPrefix() + " ; " + ((QName) value).getNamespaceURI() + " ; "
							+ ((QName) value).getLocalPart());
				} else if (value instanceof List) {
					buf.append("[?]");
				} else {
					Class<?> c = value.getClass();
					boolean sep = false;
					while (c != Object.class) {
						if (sep) {
							buf.append(" ");
						}
						buf.append(c.getName());
						c = c.getSuperclass();
						sep = true;
					}
				}
			}
			System.out.println(buf.toString());

		}

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
