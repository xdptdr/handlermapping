package com.github.xdptdr.cxf;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPOutputStream;

import org.apache.cxf.Bus;
import org.apache.cxf.BusFactory;
import org.apache.cxf.bus.extension.ExtensionManagerBus;
import org.apache.cxf.bus.managers.PhaseManagerImpl;
import org.apache.cxf.feature.Feature;
import org.apache.cxf.message.Message;
import org.apache.cxf.message.MessageImpl;
import org.apache.cxf.phase.PhaseInterceptorChain;
import org.apache.cxf.transport.common.gzip.GZIPFeature;

public class Abdeel {

	public static enum Path {

		GET(true, false, false, false), GZIP_NOT_REQUESTOR(false, true, false, false), XGZIP_NOT_REQUESTOR(false, false,
				true, false);

		private boolean get;
		private boolean gzip;
		private boolean xgzip;
		private boolean requestor;

		Path(boolean isGet, boolean isGzip, boolean isXGzip, boolean isRequestor) {
			this.get = isGet;
			this.gzip = isGzip;
			this.xgzip = isXGzip;
			this.requestor = isRequestor;
		}

		public boolean isGet() {
			return get;
		}

		public boolean isGzip() {
			return gzip;
		}

		public boolean isXgzip() {
			return xgzip;
		}

		public boolean isRequestor() {
			return requestor;
		}

	};

	public static void main(String[] args) throws IOException {

		Path path = Path.GZIP_NOT_REQUESTOR;

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
		Map<String, List<String>> headers = new HashMap<>();
		if (path == Path.GET) {
			message.put(Message.HTTP_REQUEST_METHOD, "GET");
		}
		if (path == Path.GZIP_NOT_REQUESTOR || path == Path.XGZIP_NOT_REQUESTOR) {
			message.put(Message.PROTOCOL_HEADERS, headers);
			if (path == Path.GZIP_NOT_REQUESTOR) {
				headers.put("content-encoding", Arrays.asList(new String[] { "gzip" }));

				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				GZIPOutputStream gout = new GZIPOutputStream(baos);
				gout.write("hello".getBytes());
				InputStream is = new ByteArrayInputStream(baos.toByteArray());

				message.setContent(InputStream.class, is);

				message.put(Message.REQUESTOR_ROLE, true);
			} else if (path == Path.XGZIP_NOT_REQUESTOR) {
				headers.put("content-encoding", Arrays.asList(new String[] { "xgzip" }));
			}
		}
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
