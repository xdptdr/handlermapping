package com.github.xdptdr.cxf;

import org.apache.cxf.Bus;
import org.apache.cxf.BusFactory;
import org.apache.cxf.bus.extension.ExtensionManagerBus;
import org.apache.cxf.feature.Feature;
import org.apache.cxf.transport.common.gzip.GZIPFeature;

public class Abdeel {
	public static void main(String[] args) {
		Bus bus = BusFactory.getDefaultBus();
		azzert(bus instanceof ExtensionManagerBus);
		azzert(bus.getFeatures().size() == 0);

		GZIPFeature gzipFeature = new GZIPFeature();
		gzipFeature.setForce(true);
		bus.getFeatures().add(gzipFeature);
		gzipFeature.initialize(bus);
		azzert(gzipFeature instanceof Feature);
		azzert(bus.getFeatures().size() == 1);
		azzert(bus.getFeatures().iterator().next() == gzipFeature);


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
