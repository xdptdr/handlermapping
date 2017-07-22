package com.github.xdptdr.dump.org.apache.cxf.ws.addressing;

import org.apache.cxf.ws.addressing.AttributedURIType;

import com.github.xdptdr.dump.Dumper;

public class AttributedURITypeDumper {
	public static void dump(String id, Object o) {
		AttributedURIType a = (AttributedURIType) o;
		Dumper.dump(id + ".value", a.getValue());
		Dumper.dump(id + ".otherAttributes", a.getOtherAttributes());
	}
}
