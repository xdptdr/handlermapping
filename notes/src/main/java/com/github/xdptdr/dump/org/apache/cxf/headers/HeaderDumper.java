package com.github.xdptdr.dump.org.apache.cxf.headers;

import org.apache.cxf.headers.Header;

import com.github.xdptdr.dump.Dumper;

public class HeaderDumper {
	public static void dump(Object o) {
		Header m = (Header) o;
		Dumper.dump(m.getDataBinding());
		Dumper.dump(m.getDirection());
		Dumper.dump(m.getName());
		Dumper.dump(m.getObject());

	}
}
