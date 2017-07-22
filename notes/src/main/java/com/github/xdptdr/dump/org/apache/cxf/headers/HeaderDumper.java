package com.github.xdptdr.dump.org.apache.cxf.headers;

import org.apache.cxf.headers.Header;

import com.github.xdptdr.dump.Dumper;

public class HeaderDumper {
	public static void dump(String id, Object o) {
		Header h = (Header) o;
		Dumper.dump(id + ".name", h.getName());
		Dumper.dump(id + ".direction", h.getDirection());
		Dumper.dump(id + ".object", h.getObject());
		Dumper.dump(id + ".dataBinding", h.getDataBinding());

	}

}
