package com.github.xdptdr.cxf.abdi;

import org.apache.cxf.Bus;
import org.apache.cxf.BusException;
import org.apache.cxf.BusFactory;
import org.apache.cxf.interceptor.Interceptor;
import org.apache.cxf.message.Message;
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

import com.github.xdptdr.notes.N;

public class FOO {
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
