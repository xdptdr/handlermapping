package com.github.xdptdr.mbwar.jaxb;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class MyXmlAdapter extends XmlAdapter<char[], String> {

	@Override
	public String unmarshal(char[] v) throws Exception {
		if (v == null) {
			return null;
		}
		return new String(v);
	}

	@Override
	public char[] marshal(String v) throws Exception {
		if (v == null) {
			return null;
		}
		return v.toCharArray();
	}

}
