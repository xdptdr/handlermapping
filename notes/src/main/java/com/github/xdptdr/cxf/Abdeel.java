package com.github.xdptdr.cxf;

import java.util.HashMap;
import java.util.Map;

import org.apache.cxf.Bus;
import org.apache.cxf.BusFactory;
import org.apache.cxf.bus.extension.ExtensionManagerBus;
import org.apache.cxf.bus.managers.PhaseManagerImpl;
import org.apache.cxf.feature.Feature;
import org.apache.cxf.helpers.HttpHeaderHelper;
import org.apache.cxf.message.Message;
import org.apache.cxf.message.MessageImpl;
import org.apache.cxf.phase.PhaseInterceptorChain;
import org.apache.cxf.transport.common.gzip.GZIPFeature;

public class Abdeel {
	public static void main(String[] args) {
		Bus bus = BusFactory.getDefaultBus();
		azzert(bus instanceof ExtensionManagerBus);

		bus.getInInterceptors().clear();
		bus.getInFaultInterceptors().clear();
		bus.getOutInterceptors().clear();
		bus.getOutFaultInterceptors().clear();

		azzert(bus.getFeatures().size() == 0);

		GZIPFeature gzipFeature = new GZIPFeature();
		azzert(gzipFeature instanceof Feature);

		gzipFeature.setForce(true);
		gzipFeature.initialize(bus);

		PhaseManagerImpl pmi = new PhaseManagerImpl();

		PhaseInterceptorChain pic = new PhaseInterceptorChain(pmi.getInPhases());
		pic.add(bus.getInInterceptors());

		Message message = new MessageImpl();
		Map<String, String> headers = new HashMap<>();
		// message.put(Message.HTTP_REQUEST_METHOD, "GET");
		message.put(Message.PROTOCOL_HEADERS, headers);
		headers.put("content-encoding", "");
		pic.doIntercept(message);

		// BeanValidationFeature.class.getName();
		// CertConstraintsFeature.class.getName();
		// ColocFeature.class.getName();
		// ConnectionFactoryFeature.class.getName();
		// FailoverFeature.class.getName();
		// LoadDistributorFeature.class.getName();
		// FastInfosetFeature.class.getName();
		// GZIPFeature.class.getName();
		// JAASAuthenticationFeature.class.getName();
		// JMSConfigFeature.class.getName();
		// LoggingFeature.class.getName();
		// ResponseTimeFeature.class.getName();
		// RMFeature.class.getName();
		// SchemaValidationFeature.class.getName();
		// StaxDataBindingFeature.class.getName();
		// StaxTransformFeature.class.getName();
		// WrappedFeature.class.getName();
		// WSAddressingFeature.class.getName();
		// WSPolicyFeature.class.getName();
		// XSLTFeature.class.getName();

	}

	private static void azzert(boolean b) {
		if (!b) {
			throw new RuntimeException("Assertion Error");
		}
	}
}
