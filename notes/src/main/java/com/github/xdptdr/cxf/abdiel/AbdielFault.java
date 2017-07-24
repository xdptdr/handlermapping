package com.github.xdptdr.cxf.abdiel;

import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.ws.addressing.FaultAction;

@FaultAction("faultAction")
public class AbdielFault extends Fault {

	private static final long serialVersionUID = 1L;

	public AbdielFault() {
		super((Throwable) null);
	}

}
