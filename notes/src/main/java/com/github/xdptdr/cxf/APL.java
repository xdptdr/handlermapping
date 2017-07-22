package com.github.xdptdr.cxf;

import org.apache.cxf.ws.addressing.JAXWSAConstants;

public enum APL {
	
	INBOUND(JAXWSAConstants.ADDRESSING_PROPERTIES_INBOUND),

	OUTBOUND(JAXWSAConstants.ADDRESSING_PROPERTIES_OUTBOUND),

	CLIENT(JAXWSAConstants.CLIENT_ADDRESSING_PROPERTIES);

	private final String key;

	APL(String key) {
		this.key = key;
	}

	public String getKey() {
		return key;
	}

}
