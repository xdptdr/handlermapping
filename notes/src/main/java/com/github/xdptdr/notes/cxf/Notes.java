package com.github.xdptdr.notes.cxf;

import com.github.xdptdr.cxf.Abdeel;
import com.github.xdptdr.notes.N;

public class Notes {
	/*-
		( ) cxf-services-sts-core
		( ) cxf-services-ws-discovery-api
		( ) cxf-xjc-boolean
		( ) cxf-xjc-bug986
		( ) cxf-xjc-dv
		( ) cxf-xjc-ts
		( ) cxf-xjc-runtime
		(x) cxf-core
		( ) cxf-rt-bindings-coloc
		(x) cxf-rt-bindings-object
		(x) cxf-rt-bindings-soap
		(x) cxf-rt-bindings-xml
		( ) cxf-rt-databinding-aegis
		(x) cxf-rt-databinding-jaxb
		( ) cxf-rt-features-clustering
		(x) cxf-rt-frontend-jaxws
		(x) cxf-rt-frontend-simple
		( ) cxf-rt-management
		(x) cxf-rt-security
		(x) cxf-rt-security-saml
		(x) cxf-rt-transports-http
		( ) cxf-rt-transports-http-hc
		( ) cxf-rt-transports-jms
		(x) cxf-rt-transports-local
		(x) cxf-rt-ws-addr
		(x) cxf-rt-wsdl
		( ) cxf-rt-ws-mex
		( ) cxf-rt-ws-policy
		( ) cxf-rt-ws-rm
		(x) cxf-rt-ws-security
		( ) cxf-tools-common
		( ) cxf-tools-java2ws
		( ) cxf-tools-validator
		( ) cxf-tools-wsdlto-core
		( ) cxf-tools-wsdlto-databinding-jaxb
		( ) cxf-tools-wsdlto-frontend-jaxws
	 */

	/*-
	 * https://en.wikipedia.org/wiki/List_of_biblical_names_starting_with_A
	 */

	private static void notes(N n) {

		// n.k(Abda.class, AbdaInterceptor.class).s(" illustrates how to use")
		// .k(Message.class, MessageImpl.class, Exchange.class,
		// ExchangeImpl.class, Interceptor.class)
		// .s(" to send and receive messages with interceptor through an
		// exchange");
		//
		// n.o(Aaron.class, BusFactory.class, Bus.class,
		// ExtensionManagerBus.class, Feature.class);
		//
		// n.o(Abba.class, DataBinding.class, EndpointProperties.class,
		// EndpointProperty.class, EvaluateAllEndpoints.class,
		// FactoryType.class, FastInfoset.class, GZIP.class, Logging.class,
		// Policies.class, Policy.class,
		// Provider.class, SchemaValidation.class, UseAsyncMethod.class,
		// WSDLDocumentation.class,
		// WSDLDocumentationCollection.class);
		//
		// n.o(Abaddon.class, AttachmentDataSource.class,
		// AttachmentDeserializer.class, AttachmentImpl.class,
		// AttachmentSerializer.class, AttachmentUtil.class,
		// Base64DecoderStream.class, ByteDataSource.class,
		// ContentDisposition.class, DelegatingInputStream.class,
		// ImageDataContentHandler.class,
		// LazyAttachmentCollection.class, LazyDataSource.class,
		// MimeBodyPartInputStream.class,
		// QuotedPrintableDecoderStream.class, Rfc5987Util.class);

		Abdeel.n(n);

	}

	private static void todos(N n) {
		Todos.todoCore(n);
		Todos.todoFrontendSimple(n);
		Todos.todoSecurity(n);
		Todos.todoSecuritySaml(n);
		Todos.todoWsdl(n);
		Todos.todoWsAddr(n);
		Todos.todoWsSecurity(n);
		Todos.todoTransportHttp(n);
		Todos.todoTransportLocal(n);
		Todos.todoBindingsObject(n);
		Todos.todoBindingsSoap(n);
		Todos.todoBindingsXml(n);
		Todos.todoDataBindingsJaxb(n);
	}

	public static void main(String[] args) {
		N n = new N();
		todos(n);
		notes(n);
		n.sumUp(true);
	}

}
