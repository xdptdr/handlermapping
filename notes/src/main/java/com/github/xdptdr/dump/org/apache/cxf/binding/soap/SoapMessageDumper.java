package com.github.xdptdr.dump.org.apache.cxf.binding.soap;

import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.headers.Header;
import org.apache.cxf.message.Attachment;

import com.github.xdptdr.dump.Dumper;

public class SoapMessageDumper {
	public static void dump(Object o) {
		SoapMessage m = (SoapMessage) o;
		Dumper.dump(m.getEnvelopeNs());
		for (Header h : m.getHeaders()) {
			Dumper.dump(h);
		}
		Dumper.dump(m.getVersion());
		Dumper.dump(m.getAttachmentMimeType());
		if (m.getAttachments() != null) {
			for (Attachment a : m.getAttachments()) {
				Dumper.dump(a);
			}
		}
		for (Class<?> f : m.getContentFormats()) {
			Dumper.dump(m.getContent(f));
		}
		for (String k : m.getContextualPropertyKeys()) {
			Dumper.dump(m.getContextualProperty(k));
		}
		Dumper.dump(m.getDestination());
		Dumper.dump(m.getExchange());
		Dumper.dump(m.getId());
		Dumper.dump(m.getInterceptorChain());
	}
}
