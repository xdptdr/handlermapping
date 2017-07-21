package com.github.xdptdr.cxf.abdi;

import javax.xml.namespace.QName;

import org.apache.cxf.ws.addressing.Names;

public enum MU {

	ACTION(Names.WSA_ACTION_QNAME),

	MESSAGEID(Names.WSA_MESSAGEID_QNAME),

	TO(Names.WSA_TO_QNAME),

	REPLYTO(Names.WSA_REPLYTO_QNAME),

	RELATESTO(Names.WSA_RELATESTO_QNAME),

	FROM(Names.WSA_FROM_QNAME),

	FAULTTO(Names.WSA_FAULTTO_QNAME);

	private final QName qn;

	MU(QName qn) {
		this.qn = qn;
	}

	public QName getQn() {
		return qn;
	}

}
