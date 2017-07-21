package com.github.xdptdr.cxf.abdi;

import org.apache.cxf.ws.addressing.Names;
import org.apache.cxf.ws.addressing.VersionTransformer.Names200403;
import org.apache.cxf.ws.addressing.VersionTransformer.Names200408;

public enum NURI {

	RECENT(Names.WSA_NAMESPACE_NAME),

	OLD(Names200408.WSA_NAMESPACE_NAME),

	OLDER(Names200403.WSA_NAMESPACE_NAME);

	private final String namespaceURI;

	private NURI(String namespaceURI) {
		this.namespaceURI = namespaceURI;
	}

	public String getNamespaceURI() {
		return namespaceURI;
	}

}
