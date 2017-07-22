package com.github.xdptdr.dump.javax.xml.namespace;

import javax.xml.namespace.QName;

public class QNameDumper {
	public static void dump(String id, Object o) {
		QName m = (QName) o;

		String n = m.getNamespaceURI();
		String lp = m.getLocalPart();
		String p = m.getPrefix();
		
		if (p != null && p.length() > 0) {
			System.out.println(id + " : " + n + ":" + p + ":" + lp);
		} else {
			System.out.println(id + " : " + n + ":" + lp);
		}
	}
}
