package com.github.xdptdr.cxf.abdiel;

import javax.xml.ws.WebFault;

@WebFault(targetNamespace = "webFaultNS", name = "webFaultLP")
public class AbdielThrowableWebFault extends Throwable {

	private static final long serialVersionUID = 1L;

	public AbdielThrowableWebFault() {
	}

}
