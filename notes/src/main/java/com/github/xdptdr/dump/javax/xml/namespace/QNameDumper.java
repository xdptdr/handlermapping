package com.github.xdptdr.dump.javax.xml.namespace;

import javax.xml.namespace.QName;

import com.github.xdptdr.dump.Dumper;

public class QNameDumper {
	public static void dump(Object o) {
		QName m = (QName) o;
		Dumper.dump("namespaceURI", m.getNamespaceURI());
		Dumper.dump("localPart", m.getLocalPart());
		Dumper.dump("prefix", m.getPrefix());
	}
}
