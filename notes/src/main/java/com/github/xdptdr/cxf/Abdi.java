package com.github.xdptdr.cxf;

import org.apache.cxf.Bus;
import org.apache.cxf.interceptor.InterceptorProvider;
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
import org.apache.neethi.AssertionBuilderFactory;
import org.w3c.dom.Element;

public class Abdi {
	public static void main(String[] args) {

		AddressingFeatureApplier addressingFeatureApplier = new AddressingFeatureApplier();
		WSAddressingFeature feature = null;
		InterceptorProvider provider = null;
		Bus bus = null;
		addressingFeatureApplier.initializeProvider(feature, provider, bus);
		AddressingWSDLExtensionLoader addressingWSDLExtensionLoader = new AddressingWSDLExtensionLoader(bus);
		WSDLManager manager = null;
		Class<?> parentType = null;
		Class<?> elementType = null;
		addressingWSDLExtensionLoader.createExtensor(manager, parentType, elementType);

		MAPAggregator mag = null;
		MAPAggregatorImpl mapAggregatorImpl = new MAPAggregatorImpl(mag);
		DefaultMessageIdCache defaultMessageIdCache = new DefaultMessageIdCache();

		MAPAggregatorImplLoader mapAggregatorImplLoader = new MAPAggregatorImplLoader();
		MAPAggregator mapAggregator = mapAggregatorImplLoader.createImplementation(mapAggregatorImpl);

		AddressingAssertionBuilder addressingAssertionBuilder = new AddressingAssertionBuilder();
		Element elem = null;
		AssertionBuilderFactory factory = null;
		addressingAssertionBuilder.build(elem, factory);

		AddressingPolicyInterceptorProvider addressingPolicyInterceptorProvider = new AddressingPolicyInterceptorProvider();

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

		UsingAddressingAssertionBuilder usingAddressingAssertionBuilder = new UsingAddressingAssertionBuilder();
		Element element = null;
		AssertionBuilderFactory fact = null;
		usingAddressingAssertionBuilder.build(element, fact);

		DecoupledFaultHandler decoupledFaultHandler = new DecoupledFaultHandler();

		MAPCodec mapCodec = new MAPCodec();

		VersionTransformer versionTransformer = new VersionTransformer(mapCodec);

	}

	private static void foo(Object o) {

	}
}
