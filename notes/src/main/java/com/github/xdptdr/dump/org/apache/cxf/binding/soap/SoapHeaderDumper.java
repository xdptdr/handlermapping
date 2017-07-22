package com.github.xdptdr.dump.org.apache.cxf.binding.soap;

import org.apache.cxf.binding.soap.SoapHeader;

import com.github.xdptdr.dump.Dumper;
import com.github.xdptdr.dump.org.apache.cxf.headers.HeaderDumper;

public class SoapHeaderDumper {
	public static void dump(String id, Object o) {
		SoapHeader h = (SoapHeader) o;
		HeaderDumper.dump(id, h);
		Dumper.dump(id + ".actor", h.getActor());
		Dumper.dump(id + ".mustUnderstand", h.isMustUnderstand());
	}
}
