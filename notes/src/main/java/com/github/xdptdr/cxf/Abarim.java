package com.github.xdptdr.cxf;

import java.io.OutputStream;
import java.util.SortedSet;
import java.util.TreeSet;

import javax.jws.WebMethod;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

import org.apache.cxf.Bus;
import org.apache.cxf.endpoint.Endpoint;
import org.apache.cxf.endpoint.EndpointException;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.frontend.WSDLGetInterceptor;
import org.apache.cxf.interceptor.Interceptor;
import org.apache.cxf.interceptor.StaxOutInterceptor;
import org.apache.cxf.jaxws.JaxWsServerFactoryBean;
import org.apache.cxf.jaxws.JaxwsServiceBuilder;
import org.apache.cxf.message.ExchangeImpl;
import org.apache.cxf.message.Message;
import org.apache.cxf.message.MessageImpl;
import org.apache.cxf.message.MessageUtils;
import org.apache.cxf.phase.Phase;
import org.apache.cxf.phase.PhaseInterceptorChain;
import org.apache.cxf.service.Service;
import org.apache.cxf.service.model.EndpointInfo;
import org.apache.cxf.service.model.ServiceInfo;
import org.apache.cxf.staxutils.StaxUtils;
import org.apache.cxf.wsdl.service.factory.ReflectionServiceFactoryBean;
import org.w3c.dom.Document;

public class Abarim {

	public static enum DoWith {
		SERVER, INTERCEPTOR, UTILS
	};

	private static JaxwsServiceBuilder jaxwsServiceBuilder;
	private static ServiceInfo serviceInfo;
	private static ReflectionServiceFactoryBean reflectionServiceFactoryBean;
	private static EndpointInfo endpointInfo;
	private static Endpoint freshEndpoint;
	private static Server server;
	private static WSDLGetInterceptor wsdlGetInterceptor;
	private static Message message;
	private static DoWith doWith = DoWith.SERVER;
	private static Service service;
	private static Endpoint serviceEndpoint;
	private static Bus bus;

	@WebMethod
	public String foo(String in) {
		return in + "!" + in;
	}

	private static void init() throws EndpointException {

		frobnicate(serviceInfo);
		frobnicate(server);
		frobnicate(message);

		jaxwsServiceBuilder = new JaxwsServiceBuilder();
		reflectionServiceFactoryBean = jaxwsServiceBuilder.getServiceFactory();
		bus = jaxwsServiceBuilder.getBus();
		jaxwsServiceBuilder.setServiceClass(Abarim.class);
		serviceInfo = jaxwsServiceBuilder.createService();
		endpointInfo = reflectionServiceFactoryBean.getEndpointInfo();
		freshEndpoint = reflectionServiceFactoryBean.createEndpoint(endpointInfo);
		service = reflectionServiceFactoryBean.getService();
		serviceEndpoint = service.getEndpoints().entrySet().iterator().next().getValue();
		azzert(freshEndpoint != serviceEndpoint);
	}

	private static void azzert(boolean b) {
		if (!b) {
			throw new RuntimeException("Assertion Error");
		}
	}

	private static void frobnicate(Object o) {

	}

	private static void withInterceptor() throws XMLStreamException {
		// org.apache.cxf.transport.ChainInitiationObserver.onMessage(Message)
		// service.getEndpoints()
		for (Interceptor<? extends Message> interceptor : serviceEndpoint.getInInterceptors()) {
			if (interceptor instanceof WSDLGetInterceptor) {
				wsdlGetInterceptor = (WSDLGetInterceptor) interceptor;
			}
		}
		if (wsdlGetInterceptor == null) {
			return;
		}

		Message message = new MessageImpl();

		ExchangeImpl exchange = new ExchangeImpl();
		exchange.setInMessage(message);
		exchange.put(Service.class, service);
		exchange.put(Endpoint.class, serviceEndpoint);
		exchange.put(Bus.class, bus);
		// exchange.put(Binding.class, getBinding());

		message.setExchange(exchange);
		SortedSet<Phase> phases = new TreeSet<>();
		message.setInterceptorChain(new PhaseInterceptorChain(phases));

		message.put(Message.HTTP_REQUEST_METHOD, "GET");
		message.put(Message.QUERY_STRING, "wsdl");
		message.put(Message.REQUEST_URL, "http://localhost:9000/Abarim");
		message.put(Message.PATH_INFO, "/Abarim/Abarim");

		wsdlGetInterceptor.handleMessage(message);

		Message outMessage = exchange.getOutMessage();
		Document doc = (Document) outMessage.get(WSDLGetInterceptor.DOCUMENT_HOLDER);

		XMLStreamWriter xwriter = StaxUtils.createXMLStreamWriter(System.out, "UTF-8");
		StaxUtils.writeDocument(doc, xwriter, true, false);
	}

	private static void withUtils() {
		// org.apache.cxf.frontend.WSDLGetUtils.writeWSDLDocument(Message,
		// Map<String, Definition>, Map<String, SchemaReference>, String,
		// String, EndpointInfo)
	}

	private static void startServer() {
		JaxWsServerFactoryBean jaxWsServerFactoryBean = new JaxWsServerFactoryBean();
		jaxWsServerFactoryBean.setServiceClass(jaxwsServiceBuilder.getServiceClass());
		jaxWsServerFactoryBean.setAddress("http://localhost:9000/Abarim");
		jaxWsServerFactoryBean.setServiceBean(new Abarim());
		server = jaxWsServerFactoryBean.create();
	}

	public static void main(String[] args) throws EndpointException, XMLStreamException {

		doWith = DoWith.INTERCEPTOR;

		init();
		switch (doWith) {
		case INTERCEPTOR:
			withInterceptor();
			break;
		case UTILS:
			withUtils();
			break;
		case SERVER:
			startServer();
			break;
		}

	}
}
