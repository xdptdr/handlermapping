package com.github.xdptdr.cxf;

import org.apache.cxf.Bus;
import org.apache.cxf.BusException;
import org.apache.cxf.BusFactory;
import org.apache.cxf.binding.soap.Soap11;
import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.binding.soap.SoapVersion;
import org.apache.cxf.interceptor.Interceptor;
import org.apache.cxf.message.Exchange;
import org.apache.cxf.message.ExchangeImpl;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.Phase;
import org.apache.cxf.ws.addressing.MAPAggregator;
import org.apache.cxf.ws.addressing.WSAddressingFeature;
import org.apache.cxf.ws.addressing.impl.AddressingFeatureApplier;
import org.apache.cxf.ws.addressing.impl.AddressingWSDLExtensionLoader;
import org.apache.cxf.ws.addressing.impl.DefaultMessageIdCache;
import org.apache.cxf.ws.addressing.impl.MAPAggregatorImpl;
import org.apache.cxf.ws.addressing.impl.MAPAggregatorImplLoader;
import org.apache.cxf.ws.addressing.policy.AddressingAssertionBuilder;
import org.apache.cxf.ws.addressing.policy.AddressingPolicyInterceptorProvider;
import org.apache.cxf.ws.addressing.policy.MetadataConstants;
import org.apache.cxf.ws.addressing.policy.UsingAddressingAssertionBuilder;
import org.apache.cxf.ws.addressing.soap.DecoupledFaultHandler;
import org.apache.cxf.ws.addressing.soap.MAPCodec;
import org.apache.cxf.ws.addressing.soap.VersionTransformer;
import org.apache.cxf.wsdl.WSDLManager;
import org.apache.cxf.wsdl11.WSDLManagerImpl;
import org.apache.neethi.AssertionBuilderFactory;
import org.w3c.dom.Element;

import com.github.xdptdr.cxf.Abdi.CodePath;
import com.github.xdptdr.notes.N;

public class Abdi {

	public static class CodePath {

		private boolean oneway;
		private boolean requestor;
		private boolean addressingDisabled;
		private boolean outbound;

		public CodePath oneway(boolean b) {
			this.oneway = b;
			return this;
		}

		public boolean isOneway() {
			return oneway;
		}

		public CodePath requestor(boolean b) {
			this.requestor = b;
			return this;
		}

		public boolean isRequestor() {
			return requestor;
		}

		public CodePath addressingDisabled(boolean b) {
			this.addressingDisabled = b;
			return this;
		}

		public boolean isAddressingDisabled() {
			return addressingDisabled;
		}

		public CodePath outbound(boolean b) {
			this.outbound = b;
			return this;

		}

		public boolean isOutbound() {
			return outbound;
		}

	}

	public static void main(String[] args) {

		CodePath codePath = new CodePath();
		codePath.addressingDisabled(false).outbound(true);

		MAPCodec mapCodec = new MAPCodec();
		N.azzert(Phase.PRE_PROTOCOL.equals(mapCodec.getPhase()));
		N.azzert(mapCodec.getUnderstoodHeaders() == VersionTransformer.HEADERS);
		SoapVersion ver = Soap11.getInstance();

		Exchange exchange = new ExchangeImpl();
		if (codePath.isOneway()) {
			exchange.setOneWay(true);
		}

		SoapMessage message = new SoapMessage(ver);
		message.setExchange(exchange);

		if (codePath.isAddressingDisabled()) {
			message.put(MAPAggregator.ADDRESSING_DISABLED, true);
		}
		
		if(codePath.isOutbound()) {
			exchange.setOutMessage(message);
		}

		mapCodec.handleMessage(message);

	}

	public static void foo() throws BusException {

		WSAddressingFeature wsAddressingFeature = new WSAddressingFeature();
		Bus bus = BusFactory.getDefaultBus();
		bus.getInInterceptors().clear();
		bus.getInFaultInterceptors().clear();
		bus.getOutInterceptors().clear();
		bus.getOutFaultInterceptors().clear();

		WSDLManager wsdlManager = new WSDLManagerImpl();
		Element elem = null;
		AssertionBuilderFactory factory = null;
		Element element = null;
		AssertionBuilderFactory fact = null;

		// complex
		MAPAggregatorImpl mapAggregatorImpl = null;

		// complex
		MAPCodec mapCodec = null;

		// simple
		AddressingFeatureApplier addressingFeatureApplier = new AddressingFeatureApplier();
		addressingFeatureApplier.initializeProvider(wsAddressingFeature, bus, bus);
		for (Interceptor<? extends Message> interceptor : bus.getInInterceptors()) {
			if (interceptor instanceof MAPAggregatorImpl) {
				mapAggregatorImpl = (MAPAggregatorImpl) interceptor;
			}
			if (interceptor instanceof MAPCodec) {
				mapCodec = (MAPCodec) interceptor;
			}
		}

		bus.setExtension(wsdlManager, WSDLManager.class);
		AddressingWSDLExtensionLoader addressingWSDLExtensionLoader = new AddressingWSDLExtensionLoader(bus);

		DefaultMessageIdCache defaultMessageIdCache = new DefaultMessageIdCache();
		azzert(!defaultMessageIdCache.checkUniquenessAndCacheId("foo"));
		azzert(defaultMessageIdCache.checkUniquenessAndCacheId("foo"));

		// simple
		// effectively returns clones of MAPAggregator
		MAPAggregatorImplLoader mapAggregatorImplLoader = new MAPAggregatorImplLoader();
		MAPAggregator mapAggregator = mapAggregatorImplLoader.createImplementation(mapAggregatorImpl);

		// simple
		UsingAddressingAssertionBuilder usingAddressingAssertionBuilder = new UsingAddressingAssertionBuilder();
		usingAddressingAssertionBuilder.build(element, fact);

		// complex
		AddressingAssertionBuilder addressingAssertionBuilder = new AddressingAssertionBuilder();
		addressingAssertionBuilder.build(elem, factory);

		// simple
		// adds MAP_AGGREGATOR and MAP_CODEC to all interceptors
		AddressingPolicyInterceptorProvider addressingPolicyInterceptorProvider = new AddressingPolicyInterceptorProvider();

		// mild
		DecoupledFaultHandler decoupledFaultHandler = new DecoupledFaultHandler();

		// mild
		VersionTransformer versionTransformer = new VersionTransformer(mapCodec);

		foo(MetadataConstants.ADDR_POLICY_2004_NAMESPACE_URI);
		foo(MetadataConstants.ADDR_WSDL_2005_NAMESPACE_URI);
		foo(MetadataConstants.ADDR_WSDL_2006_NAMESPACE_URI);
		foo(MetadataConstants.ADDRESSING_ASSERTION_QNAME);
		foo(MetadataConstants.ADDRESSING_ASSERTION_QNAME_0705);
		foo(MetadataConstants.ADDRESSING_ELEM_NAME);
		foo(MetadataConstants.ANON_RESPONSES_ASSERTION_QNAME);
		foo(MetadataConstants.ANON_RESPONSES_ASSERTION_QNAME_0705);
		foo(MetadataConstants.ANON_RESPONSES_ELEM_NAME);
		foo(MetadataConstants.NAMESPACE_URI);
		foo(MetadataConstants.NAMESPACE_URI_0705);
		foo(MetadataConstants.NON_ANON_RESPONSES_ASSERTION_QNAME);
		foo(MetadataConstants.NON_ANON_RESPONSES_ASSERTION_QNAME_0705);
		foo(MetadataConstants.NON_ANON_RESPONSES_ELEM_NAME);
		foo(MetadataConstants.USING_ADDRESSING_2004_QNAME);
		foo(MetadataConstants.USING_ADDRESSING_2005_QNAME);
		foo(MetadataConstants.USING_ADDRESSING_2006_QNAME);
		foo(MetadataConstants.USING_ADDRESSING_ELEM_NAME);

	}

	private static void azzert(boolean b) {
		if (!b) {
			throw new RuntimeException("Assertion Error");
		}

	}

	private static void foo(Object o) {

	}
}
