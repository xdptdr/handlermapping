package com.github.xdptdr.cxf;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

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
import org.apache.cxf.ws.addressing.MAPAggregator;
import org.apache.cxf.ws.addressing.Names;
import org.apache.cxf.ws.addressing.ReferenceParametersType;
import org.apache.cxf.ws.addressing.RelatesToType;
import org.apache.cxf.ws.addressing.VersionTransformer.Names200408;
import org.apache.cxf.ws.addressing.soap.MAPCodec;
import org.apache.cxf.ws.addressing.soap.VersionTransformer;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.github.xdptdr.cxf.abdi.CodePath;
import com.github.xdptdr.cxf.abdi.DUP;
import com.github.xdptdr.cxf.abdi.MU;
import com.github.xdptdr.cxf.abdi.NURI;
import com.github.xdptdr.notes.N;

public class Abdi {

	private static final String DUMMY_REPLY = "dummyReply";
	private static final String REPLY_TO_TEXT_NODE = "replyToTextNode";
	private static final String DUMMY_TO = "dummyTo";
	private static final String TO_TEXT_NODE = "toTextNode";
	private static final String DUMMY_ACTION = "dummyAction";
	private static final String ACTION_TEXT_NODE = "actionTextNode";
	private static final String DUMMY_MESSAGE_ID = "dummyMessageId";
	private static final String DUMMY_NS = "dummyNs";
	private static final String MESSAGE_ID_TEXT_NODE = "messageIdTextNode";
	private static final String ADDRESSING_PROPERTIES_LOCATION = "addressingPropertiesLocation";
	private static final String IS_ADDRESSING_DISABLED = "isAddressingDisabled";
	private static final String T_DUPLICATE = "duplicate";
	private static final String FAULT_PROPERTY_NAME = "faultPropertyName";
	private static final String FAULT_PROPERTY_VALUE = "faultPropertyValue";
	private static final String FAULT_TO_ADDRESS = "faultToAddress";
	private static final String HAS_ACTION = "hasAction";
	private static final String HAS_FAULT_PROPERTY = "hasFaultProperty";
	private static final String HAS_FAULT_TO = "hasFaultTo";
	private static final String HAS_FROM = "hasFrom";
	private static final String HAS_MESSAGE_ID = "hasMessageId";
	private static final String HAS_MIME_HEADERS = "hasMimeHeaders";
	private static final String HAS_RELATES_TO = "hasRelatesTo";
	private static final String HAS_REPLY_TO = "hasReplyTo";
	private static final String HAS_TO = "hasTo";
	private static final String HAS_TO_REFERENCE_PARAMETERS = "hasToReferenceParameters";
	private static final String HAS_WSA_HEADER = "hasWSAHeader";
	private static final String HAS_WSA48_HEADER = "hasWsa48Header";
	private static final String IS_REPLY_TO_OPTIONAL = "isReplyToOptional";
	private static final String MIME_HEADER_VALUE = "mimeHeaderValue";
	private static final String L_MUST_UNDERSTAND = "mustUnderstand";
	private static final String NAMESPACE_URI = "namespaceURI";
	private static final String IS_ONEWAY = "isOneway";
	private static final String IS_OUTBOUND = "isOutbound";
	private static final String RELATES_TO_VALUE = "relatesToValue";
	private static final String REPLY_TO_ADDRESS = "replyToAddress";
	private static final String IS_REPLY_TO_NONE = "isReplyToNone";
	private static final String IS_REQUESTOR = "isRequestor";
	private static final String TO_ADDRESS = "toAddress";
	private static final String TO_REF_PARAM_NAME = "toRefParamName";
	private static final String TO_REF_PARAM_NS = "toRefParamNs";
	private static final String TO_REF_PARAM_VALUE = "toRefParamValue";
	private static final String WSA_HEADER_NAME = "wsaHeaderName";
	private static final String WSA_HEADER_VALUE = "wsaHeaderValue";
	private static final String WSA48_HEADER_NAME = "wsa48HeaderName";
	private static final String WSA48_HEADER_VALUE = "wsa48HeaderValue";

	/**
	 * @param args
	 * @throws ParserConfigurationException
	 * @throws DOMException
	 */
	public static void main(String[] args) throws DOMException, ParserConfigurationException {

		CodePath c = new CodePath();
		c.s(IS_ADDRESSING_DISABLED, false).s(NAMESPACE_URI, NURI.RECENT).s(IS_OUTBOUND, false)
				.s(ADDRESSING_PROPERTIES_LOCATION, null).s(HAS_REPLY_TO, true);

		MAPCodec mapCodec = new MAPCodec();
		N.azzert(Phase.PRE_PROTOCOL.equals(mapCodec.getPhase()));
		N.azzert(mapCodec.getUnderstoodHeaders() == VersionTransformer.HEADERS);
		SoapVersion ver = Soap11.getInstance();

		Exchange exchange = new ExchangeImpl();

		SoapMessage message = new SoapMessage(ver);
		message.setExchange(exchange);

		if (c.t(IS_ADDRESSING_DISABLED)) {
			message.put(MAPAggregator.ADDRESSING_DISABLED, true);
		}

		if (c.t(IS_REQUESTOR)) {
			message.put(Message.REQUESTOR_ROLE, true);
		}

		if (c.t(IS_OUTBOUND)) {
			exchange.setOutMessage(message);
		}

		APL apl = c.g(ADDRESSING_PROPERTIES_LOCATION, APL.class);
		if (apl != null) {
			AddressingProperties maps = new AddressingProperties();
			message.put(apl.getKey(), maps);

			NURI nuri = c.g(NAMESPACE_URI, NURI.class);
			if (nuri != null) {
				maps.exposeAs(nuri.getNamespaceURI());
			}

			if (c.t(HAS_ACTION)) {
				AttributedURIType actionAURIT = new AttributedURIType();
				actionAURIT.setValue("actionAURIT");
				maps.setAction(actionAURIT);
			}

			if (c.t(HAS_MESSAGE_ID)) {
				AttributedURIType messageIdAURIT = new AttributedURIType();
				messageIdAURIT.setValue("messageIdAURIT");
				maps.setMessageID(messageIdAURIT);
			}

			if (c.t(HAS_TO)) {
				AttributedURIType toAURIT = new AttributedURIType();
				toAURIT.setValue("toAURIT");
				maps.setMessageID(toAURIT);
			}

			if (c.t(HAS_RELATES_TO)) {
				RelatesToType rel = new RelatesToType();
				rel.setValue(RELATES_TO_VALUE);
				maps.setRelatesTo(rel);
			}
			if (c.t(HAS_REPLY_TO)) {
				AttributedURIType replyToAddressAURIT = new AttributedURIType();
				if (c.t(IS_REPLY_TO_NONE)) {
					replyToAddressAURIT.setValue(Names.WSA_NONE_ADDRESS);
				} else {
					replyToAddressAURIT.setValue(REPLY_TO_ADDRESS);
				}
				EndpointReferenceType replyToERT = new EndpointReferenceType();
				replyToERT.setAddress(replyToAddressAURIT);
				maps.setReplyTo(replyToERT);
			}

			if (c.t(HAS_FROM)) {
				AttributedURIType fromAddressAURIT = new AttributedURIType();
				fromAddressAURIT.setValue("fromAddress");
				EndpointReferenceType fromERT = new EndpointReferenceType();
				fromERT.setAddress(fromAddressAURIT);
				maps.setFrom(fromERT);
			}

			if (c.t(HAS_FAULT_TO)) {
				AttributedURIType faultToAURIT = new AttributedURIType();
				faultToAURIT.setValue(FAULT_TO_ADDRESS);
				EndpointReferenceType faultToERT = new EndpointReferenceType();
				faultToERT.setAddress(faultToAURIT);
				maps.setFaultTo(faultToERT);
			}

			if (c.t(HAS_TO)) {
				AttributedURIType toAURIT = new AttributedURIType();
				toAURIT.setValue(TO_ADDRESS);
				EndpointReferenceType toERT = new EndpointReferenceType();
				toERT.setAddress(toAURIT);
				if (c.t(HAS_TO_REFERENCE_PARAMETERS)) {
					ReferenceParametersType rpt = new ReferenceParametersType();
					rpt.getAny().add(new JAXBElement<String>(new QName(TO_REF_PARAM_NS, TO_REF_PARAM_NAME),
							String.class, TO_REF_PARAM_VALUE));
					toERT.setReferenceParameters(rpt);
				}

				maps.setTo(toERT);
			}

			DUP dup = c.g(T_DUPLICATE, DUP.class);
			if (dup != null) {
				maps.setDuplicate(dup.getQn());
			}

			List<MU> mus = c.l(L_MUST_UNDERSTAND, MU.class);
			if (mus != null) {
				for (MU mu : mus) {
					maps.getMustUnderstand().add(mu.getQn());
				}
			}

		} else {
			Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
			if (c.t(HAS_MESSAGE_ID)) {
				Element messageIdElement = doc.createElementNS(Names.WSA_NAMESPACE_NAME, Names.WSA_MESSAGEID_NAME);
				messageIdElement.appendChild(doc.createTextNode(MESSAGE_ID_TEXT_NODE));
				message.getHeaders().add(new SoapHeader(new QName(DUMMY_NS, DUMMY_MESSAGE_ID), messageIdElement));
			}
			if (c.t(HAS_ACTION)) {
				Element actionElement = doc.createElementNS(Names.WSA_NAMESPACE_NAME, Names.WSA_ACTION_NAME);
				actionElement.appendChild(doc.createTextNode(ACTION_TEXT_NODE));
				message.getHeaders().add(new SoapHeader(new QName(DUMMY_NS, DUMMY_ACTION), actionElement));
			}
			if (c.t(HAS_TO)) {
				Element toElement = doc.createElementNS(Names.WSA_NAMESPACE_NAME, Names.WSA_TO_NAME);
				toElement.appendChild(doc.createTextNode(TO_TEXT_NODE));
				message.getHeaders().add(new SoapHeader(new QName(DUMMY_NS, DUMMY_TO), toElement));
			}
			if (c.t(HAS_REPLY_TO)) {
				Element replyElement = doc.createElementNS(Names.WSA_NAMESPACE_NAME, Names.WSA_REPLYTO_NAME);
				Element addressElement = doc.createElementNS(Names.WSA_NAMESPACE_NAME, Names.WSA_ADDRESS_NAME);
				addressElement.appendChild(doc.createTextNode(REPLY_TO_TEXT_NODE));
				replyElement.appendChild(addressElement);
				message.getHeaders().add(new SoapHeader(new QName(DUMMY_NS, DUMMY_REPLY), replyElement));
			}
		}

		if (c.t(HAS_FAULT_PROPERTY)) {
			message.put("org.apache.cxf.ws.addressing.map.fault.name", FAULT_PROPERTY_NAME);
			message.put("org.apache.cxf.ws.addressing.map.fault.reason", FAULT_PROPERTY_VALUE);
		}

		if (c.t(IS_REPLY_TO_OPTIONAL)) {
			message.put("ws-addressing.write.optional.replyto", true);
		}

		if (c.t(HAS_WSA_HEADER)) {
			message.getHeaders()
					.add(new Header(new QName(Names.WSA_NAMESPACE_NAME, WSA_HEADER_NAME), WSA_HEADER_VALUE));
		}
		if (c.t(HAS_WSA48_HEADER)) {
			message.getHeaders()
					.add(new Header(new QName(Names200408.WSA_NAMESPACE_NAME, WSA48_HEADER_NAME), WSA48_HEADER_VALUE));
		}

		if (c.t(HAS_MIME_HEADERS)) {
			Map<String, List<String>> mimeHeaders = new HashMap<>();
			List<String> values = new ArrayList<>();
			values.add(MIME_HEADER_VALUE);
			mimeHeaders.put("SOAPAction", values);
			message.put(Message.MIME_HEADERS, mimeHeaders);
		}

		mapCodec.handleMessage(message);

		check(c, message);

		System.out.println("End.");

	}

	private static void check(CodePath c, SoapMessage m) {
		dumpHeaderNames(m);
		if (c.t(IS_ADDRESSING_DISABLED)) {
			checkNone(c, m);
		} else {
			checkNamespaces(c, m);
			checkProps(c, m);
			checkDuplicates(c, m);
			checkMustUnderstand(c, m);
		}

	}

	private static void checkNamespaces(CodePath c, SoapMessage m) {
		NURI nuri = c.g(NAMESPACE_URI, NURI.class);
		if (nuri == null) {
			nuri = NURI.RECENT;
		}
		String ns = nuri.getNamespaceURI();
		for (Header h : m.getHeaders()) {
			if (DUMMY_NS.equals(h.getName().getNamespaceURI())) {
				break;
			}
			N.azzert(ns.equals(h.getName().getNamespaceURI()));
		}
	}

	private static void dumpHeaderNames(SoapMessage m) {
		for (Header h : m.getHeaders()) {
			System.out.println(h.getName());
		}

	}

	private static void checkNone(CodePath c, SoapMessage m) {
		N.azzert(m.getHeaders().size() == 0);

	}

	private static void checkProps(CodePath c, SoapMessage m) {
		APL apl = c.g(ADDRESSING_PROPERTIES_LOCATION, APL.class);
		Set<String> headersFound = new HashSet<>();
		for (Header h : m.getHeaders()) {
			headersFound.add(h.getName().getLocalPart());
		}
		if (apl != null) {
			N.azzert(headersFound.contains(Names.WSA_ACTION_NAME) == c.t(HAS_ACTION));
			N.azzert(headersFound.contains(Names.WSA_TO_NAME) == c.t(HAS_TO));
			N.azzert(headersFound.contains(Names.WSA_MESSAGEID_NAME) == c.t(HAS_MESSAGE_ID));
			N.azzert(headersFound.contains(Names.WSA_REPLY_NAME) == c.t(HAS_REPLY_TO));
		} else {
			N.azzert(!headersFound.contains(Names.WSA_ACTION_NAME));
			N.azzert(!headersFound.contains(Names.WSA_TO_NAME));
			N.azzert(!headersFound.contains(Names.WSA_MESSAGEID_NAME));
			AddressingProperties maps = (AddressingProperties) m
					.getContextualProperty(JAXWSAConstants.ADDRESSING_PROPERTIES_INBOUND);
			N.azzert(maps != null);
			if (c.t(HAS_ACTION)) {
				N.azzert(maps.getAction() != null);
				N.azzert(ACTION_TEXT_NODE.equals(maps.getAction().getValue()));
			} else {
				N.azzert(maps.getAction() == null);
			}
			if (c.t(HAS_TO)) {
				N.azzert(maps.getTo() != null);
				N.azzert(TO_TEXT_NODE.equals(maps.getTo().getValue()));
			} else {
				N.azzert(maps.getTo() == null);
			}
			if (c.t(HAS_MESSAGE_ID)) {
				N.azzert(maps.getMessageID() != null);
				N.azzert(MESSAGE_ID_TEXT_NODE.equals(maps.getMessageID().getValue()));
			} else {
				N.azzert(maps.getMessageID() == null);
			}
			if (c.t(HAS_REPLY_TO)) {
				N.azzert(maps.getReplyTo() != null);
				N.azzert(maps.getReplyTo().getAddress() != null);
				N.azzert(REPLY_TO_TEXT_NODE.equals(maps.getReplyTo().getAddress().getValue()));
			} else {
				N.azzert(maps.getReplyTo() != null);
				N.azzert(maps.getReplyTo().getAddress() != null);
				N.azzert(Names.WSA_ANONYMOUS_ADDRESS.equals(maps.getReplyTo().getAddress().getValue()));
			}
		}
	}

	private static void checkDuplicates(CodePath c, SoapMessage m) {
		Map<String, Integer> headerCounts = new HashMap<>();

		for (Header h : m.getHeaders()) {
			Integer p = headerCounts.get(h.getName().getLocalPart());
			if (p == null) {
				p = 0;
			}
			headerCounts.put(h.getName().getLocalPart(), p + 1);
		}

		DUP dup = c.g(T_DUPLICATE, DUP.class);
		if (dup != null) {
			switch (dup) {
			case ACTION:
				if (!c.t(HAS_ACTION)) {
					break;
				}
			case FAULTTO:
				if (!c.t(HAS_FAULT_TO)) {
					break;
				}
			case FROM:
				if (!c.t(HAS_FROM)) {
					break;
				}
			case MESSAGEID:
				if (!c.t(HAS_MESSAGE_ID)) {
					break;
				}
			case RELATESTO:
				if (!c.t(HAS_RELATES_TO)) {
					break;
				}
			case REPLYTO:
				if (!c.t(HAS_REPLY_TO)) {
					break;
				}
			case TO:
				if (!c.t(HAS_TO)) {
					break;
				}
			default:
				N.azzert(new Integer(2).equals(headerCounts.get(dup.getQn().getLocalPart())));

			}

		} else {
			for (Header h : m.getHeaders()) {
				N.azzert(headerCounts.get(h.getName().getLocalPart()) == 1);
			}
		}

	}

	private static void checkMustUnderstand(CodePath c, SoapMessage m) {
		List<MU> mus = c.l(L_MUST_UNDERSTAND, MU.class);
		if (mus != null) {
			Set<String> muSet = new HashSet<>();
			for (MU mu : mus) {
				muSet.add(mu.getQn().getLocalPart());
			}

			for (Header h : m.getHeaders()) {
				if (h instanceof SoapHeader) {
					N.azzert(((SoapHeader) h).isMustUnderstand() == muSet.contains(h.getName().getLocalPart()));
				}
			}
		} else {
			for (Header h : m.getHeaders()) {
				if (h instanceof SoapHeader) {
					N.azzert(!((SoapHeader) h).isMustUnderstand());
				}
			}
		}
	}

}
