package com.github.xdptdr.cxf.abdiel;

import javax.xml.ws.WebFault;

import org.apache.cxf.interceptor.Fault;

@WebFault(targetNamespace = "webFaultNS", name = "webFaultLP")
public class AbdielWebFault extends Fault {

	private static final long serialVersionUID = 1L;

	public AbdielWebFault() {
		super((Throwable) null);
	}

}
