package com.github.xdptdr.cxf;

import java.util.HashMap;
import java.util.Map;

import javax.faces.flow.builder.ReturnBuilder;
import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import org.apache.cxf.Bus;
import org.apache.cxf.BusException;
import org.apache.cxf.BusFactory;
import org.apache.cxf.binding.soap.Soap11;
import org.apache.cxf.binding.soap.SoapHeader;
import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.binding.soap.SoapVersion;
import org.apache.cxf.headers.Header;
import org.apache.cxf.interceptor.Interceptor;
import org.apache.cxf.message.Exchange;
import org.apache.cxf.message.ExchangeImpl;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.Phase;
import org.apache.cxf.ws.addressing.AddressingProperties;
import org.apache.cxf.ws.addressing.AttributedURIType;
import org.apache.cxf.ws.addressing.JAXWSAConstants;
import org.apache.cxf.ws.addressing.MAPAggregator;
import org.apache.cxf.ws.addressing.Names;
import org.apache.cxf.ws.addressing.WSAddressingFeature;
import org.apache.cxf.ws.addressing.VersionTransformer.Names200403;
import org.apache.cxf.ws.addressing.VersionTransformer.Names200408;
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

import com.github.xdptdr.notes.N;

public class Abdi {

	private static final String NAMESPACE_URI = "namespaceURI";
	private static final String HAS_ACTION = "hasAction";
	private static final String REQUESTOR = "requestor";
	private static final String OUTBOUND = "outbound";
	private static final String ADDRESSING_DISABLED = "addressingDisabled";
	private static final String ONEWAY = "oneway";

	public static enum NURI {

		NULL(null),

		RECENT(Names.WSA_NAMESPACE_NAME),

		OLD(Names200408.WSA_NAMESPACE_NAME),

		OLDER(Names200403.WSA_NAMESPACE_NAME);

		private final String namespaceURI;

		private NURI(String namespaceURI) {
			this.namespaceURI = namespaceURI;
		}

		public String getNamespaceURI() {
			return namespaceURI;
		}

	};

	public static class CodePath {

		Map<String, Object> p = new HashMap<>();

		public CodePath() {
			p.put(NAMESPACE_URI, NURI.NULL);
		}

		public CodePath s(String id, Object b) {
			p.put(id, b);
			return this;
		}

		public boolean t(String id) {
			return Boolean.TRUE.equals(p.get(id));
		}

		@SuppressWarnings("unchecked")
		public <T> T g(String id, Class<T> clazz) {
			return (T) p.get(id);
		}

	}

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

		AddressingProperties addressingProperties = null;
		String namespaceURI = c.g(NAMESPACE_URI, NURI.class).getNamespaceURI();
		if (namespaceURI == null) {
			addressingProperties = new AddressingProperties();
		} else {
			addressingProperties = new AddressingProperties(namespaceURI);
		}

		if (c.t(REQUESTOR)) {
			message.put(Message.REQUESTOR_ROLE, true);
			message.put(JAXWSAConstants.CLIENT_ADDRESSING_PROPERTIES, addressingProperties);
		}

		if (c.t(OUTBOUND)) {
			message.put(JAXWSAConstants.ADDRESSING_PROPERTIES_OUTBOUND, addressingProperties);
			exchange.setOutMessage(message);
		}

		if (!c.t(REQUESTOR) && !c.t(OUTBOUND)) {
			message.put(JAXWSAConstants.ADDRESSING_PROPERTIES_INBOUND, addressingProperties);
		}

		AttributedURIType action = new AttributedURIType();
		action.setValue("toto");
		if (c.t(HAS_ACTION)) {
			addressingProperties.setAction(action);
		}

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
			N.azzert(v == action);
		}

		System.out.println("End.");

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
		N.azzert(!defaultMessageIdCache.checkUniquenessAndCacheId("foo"));
		N.azzert(defaultMessageIdCache.checkUniquenessAndCacheId("foo"));

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

	private static void foo(Object o) {

	}
}
