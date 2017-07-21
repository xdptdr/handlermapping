package com.github.xdptdr.dump.org.apache.cxf.binding.soap;

import org.apache.cxf.binding.soap.SoapHeader;

import com.github.xdptdr.dump.Dumper;
import com.github.xdptdr.dump.org.apache.cxf.headers.HeaderDumper;

public class SoapHeaderDumper {
	public static void dump(Object o) {
		SoapHeader m = (SoapHeader) o;
		Dumper.dump(m.getActor());
		Dumper.dump(m.isMustUnderstand());
		HeaderDumper.dump(o);
	}
}
