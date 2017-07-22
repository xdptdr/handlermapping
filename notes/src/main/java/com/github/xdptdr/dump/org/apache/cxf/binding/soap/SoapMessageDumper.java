package com.github.xdptdr.dump.org.apache.cxf.binding.soap;

import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.headers.Header;
import org.apache.cxf.message.Attachment;

import com.github.xdptdr.dump.Dumper;

public class SoapMessageDumper {
	public static void dump(String id, Object o) {
		SoapMessage m = (SoapMessage) o;
		Dumper.dump(id + ".envelopeNs", m.getEnvelopeNs());
		for (Header h : m.getHeaders()) {
			Dumper.dump(id + ".header." + h.getName().getLocalPart(), h);
		}
		Dumper.dump(id + ".version", m.getVersion());
		Dumper.dump(id + ".attachmentMimeTypes", m.getAttachmentMimeType());
		if (m.getAttachments() != null) {
			for (Attachment a : m.getAttachments()) {
				Dumper.dump(id + ".attachment" + a);
			}
		}
		for (Class<?> f : m.getContentFormats()) {
			Dumper.dump(id + ".content", m.getContent(f));
		}
		for (String k : m.getContextualPropertyKeys()) {
			Dumper.dump(id + ".contextualProperty." + k, m.getContextualProperty(k));
		}
		Dumper.dump(id + ".destination", m.getDestination());
		Dumper.dump(id + ".exchange", m.getExchange());
		Dumper.dump(id + ".id", m.getId());
		Dumper.dump(id + ".interceptorChain", m.getInterceptorChain());
	}
}
