package com.github.xdptdr.cxf;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import org.apache.cxf.binding.soap.Soap11;
import org.apache.cxf.binding.soap.SoapHeader;
import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.binding.soap.SoapVersion;
import org.apache.cxf.headers.Header;
import org.apache.cxf.message.Exchange;
import org.apache.cxf.message.ExchangeImpl;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.Phase;
import org.apache.cxf.ws.addressing.AddressingProperties;
import org.apache.cxf.ws.addressing.AttributedURIType;
import org.apache.cxf.ws.addressing.EndpointReferenceType;
import org.apache.cxf.ws.addressing.JAXWSAConstants;
import org.apache.cxf.ws.addressing.Names;
import org.apache.cxf.ws.addressing.ReferenceParametersType;
import org.apache.cxf.ws.addressing.RelatesToType;
import org.apache.cxf.ws.addressing.VersionTransformer.Names200408;
import org.apache.cxf.ws.addressing.soap.MAPCodec;
import org.apache.cxf.ws.addressing.soap.VersionTransformer;

import com.github.xdptdr.cxf.abdi.CodePath;
import com.github.xdptdr.cxf.abdi.DUP;
import com.github.xdptdr.cxf.abdi.MU;
import com.github.xdptdr.cxf.abdi.NURI;
import com.github.xdptdr.dump.Dumper;
import com.github.xdptdr.notes.N;

public class Abdi {

	private static final String NAMESPACE_URI = "namespaceURI";
	private static final String HAS_ACTION = "hasAction";
	private static final String REQUESTOR = "requestor";
	private static final String OUTBOUND = "outbound";
	private static final String ADDRESSING_DISABLED = "addressingDisabled";
	private static final String ONEWAY = "oneway";

	public static void main(String[] args) {

		CodePath c = new CodePath();
		c.s(OUTBOUND, true);

		MAPCodec mapCodec = new MAPCodec();
		N.azzert(Phase.PRE_PROTOCOL.equals(mapCodec.getPhase()));
		N.azzert(mapCodec.getUnderstoodHeaders() == VersionTransformer.HEADERS);
		SoapVersion ver = Soap11.getInstance();

		Exchange exchange = new ExchangeImpl();

		SoapMessage message = new SoapMessage(ver);
		message.setExchange(exchange);

		AddressingProperties maps = null;
		NURI nuri = c.g(NAMESPACE_URI, NURI.class);
		if (nuri == null) {
			maps = new AddressingProperties();
		} else {
			maps = new AddressingProperties(nuri.getNamespaceURI());
		}

		if (c.t(REQUESTOR)) {
			message.put(Message.REQUESTOR_ROLE, true);
			message.put(JAXWSAConstants.CLIENT_ADDRESSING_PROPERTIES, maps);
		}

		if (c.t(OUTBOUND)) {
			message.put(JAXWSAConstants.ADDRESSING_PROPERTIES_OUTBOUND, maps);
			exchange.setOutMessage(message);
		}

		if (!c.t(REQUESTOR) && !c.t(OUTBOUND)) {
			message.put(JAXWSAConstants.ADDRESSING_PROPERTIES_INBOUND, maps);
		}

		// message.put("org.apache.cxf.ws.addressing.map.fault.name", "itou");
		// message.put("org.apache.cxf.ws.addressing.map.fault.reason", "plou");

		// message.put("ws-addressing.write.optional.replyto", true);

		message.getHeaders().add(new Header(new QName(Names.WSA_NAMESPACE_NAME, "wsa"), "wsa"));
		message.getHeaders().add(new Header(new QName(Names200408.WSA_NAMESPACE_NAME, "wsa48"), "wsa48"));

		Map<String, List<String>> mh = new HashMap<>();
		List<String> mhl = new ArrayList<>();
		mhl.add("yaplam");

		mh.put("SOAPAction", mhl);
		message.put(Message.MIME_HEADERS, mh);

		AttributedURIType iri = new AttributedURIType();
		iri.setValue("toto");
		maps.setAction(iri);

		DUP dup = c.g("duplicate", DUP.class);
		if (dup != null) {
			maps.setDuplicate(dup.getQn());
		}

		List<MU> mus = c.l("mustUnderstand", MU.class);
		if (mus != null) {
			for (MU mu : mus) {
				maps.getMustUnderstand().add(mu.getQn());
			}
		}

		maps.setMessageID(iri);
		maps.setTo(iri);
		RelatesToType rel = new RelatesToType();
		maps.setRelatesTo(rel);

		AttributedURIType iri2 = new AttributedURIType();
		iri2.setValue(Names.WSA_NONE_ADDRESS + "titou");
		EndpointReferenceType ert = new EndpointReferenceType();
		ert.setAddress(iri2);
		maps.setReplyTo(ert);
		maps.setFrom(ert);
		EndpointReferenceType ertf = new EndpointReferenceType();
		ertf.setAddress(iri);
		maps.setFaultTo(ertf);
		EndpointReferenceType ertt = new EndpointReferenceType();
		ertt.setAddress(iri);
		ReferenceParametersType rpt = new ReferenceParametersType();
		rpt.getAny().add(new JAXBElement<String>(new QName("hello", "world"), String.class, "Hello"));
		ertt.setReferenceParameters(rpt);
		maps.setTo(ertt);

		mapCodec.handleMessage(message);

		if (c.t(HAS_ACTION)) {
			SoapHeader actionHeader = (SoapHeader) message
					.getHeader(new QName("http://www.w3.org/2005/08/addressing", "Action"));
			N.azzert(actionHeader != null);
			N.azzert(!actionHeader.isMustUnderstand());
			N.azzert(actionHeader.getActor() == null);
			JAXBElement<?> actionObject = (JAXBElement<?>) actionHeader.getObject();
			N.azzert(actionObject != null);
			Object v = actionObject.getValue();
			N.azzert(v == iri);
		}

		Dumper.dump("message",message);

		System.out.println("End.");

	}

}
