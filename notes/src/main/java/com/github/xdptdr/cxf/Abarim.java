package com.github.xdptdr.cxf;

import java.util.SortedSet;
import java.util.TreeSet;

import javax.jws.WebMethod;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

import org.apache.cxf.Bus;
import org.apache.cxf.endpoint.Endpoint;
import org.apache.cxf.endpoint.EndpointException;
import org.apache.cxf.frontend.WSDLGetInterceptor;
import org.apache.cxf.interceptor.Interceptor;
import org.apache.cxf.jaxws.JaxwsServiceBuilder;
import org.apache.cxf.message.ExchangeImpl;
import org.apache.cxf.message.Message;
import org.apache.cxf.message.MessageImpl;
import org.apache.cxf.phase.Phase;
import org.apache.cxf.phase.PhaseInterceptorChain;
import org.apache.cxf.service.Service;
import org.apache.cxf.service.model.EndpointInfo;
import org.apache.cxf.staxutils.StaxUtils;
import org.apache.cxf.wsdl.service.factory.ReflectionServiceFactoryBean;
import org.w3c.dom.Document;

import com.github.xdptdr.cxf.abarim.AbarimCompare;

public class Abarim {

	public static enum DoWith {
		INTERCEPTOR
	};

	private static JaxwsServiceBuilder jaxwsServiceBuilder;
	private static ReflectionServiceFactoryBean reflectionServiceFactoryBean;
	private static EndpointInfo endpointInfo;
	private static Endpoint freshEndpoint;
	private static WSDLGetInterceptor wsdlGetInterceptor;
	private static Service service;
	private static Endpoint serviceEndpoint;
	private static Bus bus;

	@WebMethod
	public String foo(String in) {
		return in + "!" + in;
	}

	private static void init() throws EndpointException {

		jaxwsServiceBuilder = new JaxwsServiceBuilder();
		reflectionServiceFactoryBean = jaxwsServiceBuilder.getServiceFactory();
		bus = jaxwsServiceBuilder.getBus();
		jaxwsServiceBuilder.setServiceClass(Abarim.class);
		jaxwsServiceBuilder.createService();
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

	private static void withInterceptor() throws XMLStreamException {
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

	public static void main(String[] args) throws EndpointException, XMLStreamException {

		init();
		withInterceptor();
		
		AbarimCompare.compare(freshEndpoint, serviceEndpoint);

	}
}
