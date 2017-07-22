package com.github.xdptdr.dump.javax.xml.bind;

import javax.xml.bind.JAXBElement;

import com.github.xdptdr.dump.Dumper;

public class JAXBElementDumper {
	public static void dump(String id, Object o) {
		JAXBElement<?> e = (JAXBElement<?>) o;
		Dumper.dump(id + ".name", e.getName());
		Dumper.dump(id + ".scope", e.getScope());
		Dumper.dump(id + ".isGlobalScope", e.isGlobalScope());
		Dumper.dump(id + ".isNil", e.isNil());
		Dumper.dump(id + ".isTypeSubstituted", e.isTypeSubstituted());
		Dumper.dump(id + ".declaredType", e.getDeclaredType());
		Dumper.dump(id + ".value", e.getValue());

	}
}
