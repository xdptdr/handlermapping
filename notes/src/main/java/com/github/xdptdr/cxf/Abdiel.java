package com.github.xdptdr.cxf;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.namespace.QName;

import org.apache.cxf.message.Exchange;
import org.apache.cxf.message.ExchangeImpl;
import org.apache.cxf.message.Message;
import org.apache.cxf.message.MessageImpl;
import org.apache.cxf.ws.addressing.AddressingProperties;
import org.apache.cxf.ws.addressing.AttributedURIType;
import org.apache.cxf.ws.addressing.EndpointReferenceType;
import org.apache.cxf.ws.addressing.JAXWSAConstants;
import org.apache.cxf.ws.addressing.MAPAggregator;
import org.apache.cxf.ws.addressing.Names;
import org.apache.cxf.ws.addressing.WSAddressingFeature;
import org.apache.cxf.ws.addressing.WSAddressingFeature.AddressingResponses;
import org.apache.cxf.ws.addressing.impl.MAPAggregatorImpl;
import org.apache.cxf.ws.addressing.policy.MetadataConstants;
import org.apache.cxf.ws.policy.AssertionInfo;
import org.apache.cxf.ws.policy.AssertionInfoMap;
import org.apache.neethi.Assertion;
import org.apache.neethi.builders.PrimitiveAssertion;

public class Abdiel {

	private static final String REPLY_TO_GENERICITY = "replyToGenericity";
	private static final String FAULT_TO_GENERICITY = "faultToGenericity";
	private static final String ADDRESSING_RESPONSES = "addressingResponses";
	private static final String IS_REQUESTOR = "isRequestor";
	private static final String IS_OUTBOUND = "isOutbound";
	private static final String IS_FAULT = "isFault";
	private static final String ADDRESSING_DISABLED = "addressingDisabled";

	public static enum AdressGenericity {
		GENERIC_ANONYMOUS(Names.WSA_ANONYMOUS_ADDRESS), GENERIC_NONE(Names.WSA_NONE_ADDRESS), NOT_GENERIC("other");
		private final String address;

		AdressGenericity(String address) {
			this.address = address;
		}

		public String getAddress() {
			return address;
		}

	}

	public static class CodePath {

		private Map<String, Boolean> flags = new HashMap<>();
		private Map<String, Object> objects = new HashMap<>();

		public void sb(String id, boolean b) {
			flags.put(id, b);
		}

		public boolean gb(String id) {
			return Boolean.TRUE.equals(flags.get(id));
		}

		public void so(String key, Object value) {
			objects.put(key, value);
		}

		public Object go(String key) {
			return objects.get(key);
		}

	}

	public static void main(String[] args) {

		CodePath c = new CodePath();
		c.sb(ADDRESSING_DISABLED, false);
		c.sb(IS_FAULT, false);
		c.sb(IS_OUTBOUND, false);
		c.sb(IS_REQUESTOR, false);
		c.so(ADDRESSING_RESPONSES, WSAddressingFeature.AddressingResponses.ANONYMOUS);
		c.so(REPLY_TO_GENERICITY, AdressGenericity.GENERIC_NONE);
		c.so(FAULT_TO_GENERICITY, AdressGenericity.GENERIC_ANONYMOUS);

		Exchange exchange = new ExchangeImpl();

		Message message = new MessageImpl();
		message.setExchange(exchange);

		if (c.gb(ADDRESSING_DISABLED)) {
			message.put(MAPAggregator.ADDRESSING_DISABLED, true);
		}
		if (c.gb(IS_FAULT)) {
			if (c.gb(IS_OUTBOUND)) {
				message.getExchange().setOutFaultMessage(message);
			} else {
				message.getExchange().setInFaultMessage(message);
			}
		}
		if (c.gb(IS_OUTBOUND) && !c.gb(IS_FAULT)) {
			message.getExchange().setOutMessage(message);
		}
		if (c.gb(IS_REQUESTOR)) {
			message.put(Message.REQUESTOR_ROLE, true);
		}

		AddressingProperties maps = new AddressingProperties();

		if (c.gb(IS_OUTBOUND)) {
			message.put(JAXWSAConstants.ADDRESSING_PROPERTIES_OUTBOUND, maps);
		} else {
			message.put(JAXWSAConstants.ADDRESSING_PROPERTIES_INBOUND, maps);
		}

		AdressGenericity replyToAddressType = (AdressGenericity) c.go(REPLY_TO_GENERICITY);
		if (replyToAddressType != null) {
			AttributedURIType replyToAURIT = new AttributedURIType();
			replyToAURIT.setValue(replyToAddressType.getAddress());
			EndpointReferenceType replyToERT = new EndpointReferenceType();
			replyToERT.setAddress(replyToAURIT);
			maps.setReplyTo(replyToERT);
		}

		AdressGenericity faultToAddressType = (AdressGenericity) c.go(FAULT_TO_GENERICITY);
		if (faultToAddressType != null) {
			AttributedURIType faultToAURIT = new AttributedURIType();
			faultToAURIT.setValue(faultToAddressType.getAddress());
			EndpointReferenceType faultToERT = new EndpointReferenceType();
			faultToERT.setAddress(faultToAURIT);
			maps.setFaultTo(faultToERT);
		}

		AssertionInfoMap aim = new AssertionInfoMap(new ArrayList<>());
		addAssertion(aim, MetadataConstants.ADDRESSING_ASSERTION_QNAME);
		addAssertion(aim, MetadataConstants.USING_ADDRESSING_2004_QNAME);
		addAssertion(aim, MetadataConstants.USING_ADDRESSING_2005_QNAME);
		addAssertion(aim, MetadataConstants.USING_ADDRESSING_2006_QNAME);
		addAssertion(aim, MetadataConstants.ANON_RESPONSES_ASSERTION_QNAME);
		addAssertion(aim, MetadataConstants.NON_ANON_RESPONSES_ASSERTION_QNAME);

		message.put(AssertionInfoMap.class.getName(), aim);

		MAPAggregatorImpl mapAggregatorImpl = new MAPAggregatorImpl();

		WSAddressingFeature.AddressingResponses addressingResponses = (AddressingResponses) c.go(ADDRESSING_RESPONSES);
		if (addressingResponses != null) {
			mapAggregatorImpl.setAddressingResponses(addressingResponses);
		}

		mapAggregatorImpl.handleMessage(message);

	}

	private static void addAssertion(AssertionInfoMap aim, QName qn) {
		aim.put(qn, Collections.singleton(new AssertionInfo(new PrimitiveAssertion())));

	}
}
