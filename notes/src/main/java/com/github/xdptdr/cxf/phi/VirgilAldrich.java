package com.github.xdptdr.cxf.phi;

import javax.wsdl.Binding;
import javax.wsdl.Definition;
import javax.wsdl.Port;
import javax.wsdl.PortType;
import javax.wsdl.Service;
import javax.wsdl.WSDLException;
import javax.wsdl.factory.WSDLFactory;
import javax.xml.namespace.QName;

import org.apache.cxf.Bus;
import org.apache.cxf.BusFactory;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.apache.cxf.wsdl.WSDLManager;

import com.ibm.wsdl.extensions.soap.SOAPBindingImpl;

public class VirgilAldrich {
	public static void main(String[] args) throws WSDLException {
		Bus bus = BusFactory.getDefaultBus();

		JaxWsDynamicClientFactory jaxWsDynamicClientFactory = JaxWsDynamicClientFactory.newInstance(bus);

		final WSDLFactory wsdlFactory = WSDLFactory.newInstance();

		Definition definition = wsdlFactory.newDefinition();
		Service service = definition.createService();
		service.setQName(new QName("serviceNS", "serviceLP"));
		definition.addService(service);

		final Port port = definition.createPort();
		final Binding binding = definition.createBinding();
		port.setBinding(binding);
		final PortType portType = definition.createPortType();
		binding.setPortType(portType);
		portType.setQName(new QName("portTypeNS", "portTypeLP"));
		binding.setQName(new QName("bindingNS", "bindingLP"));
		service.addPort(port);
		definition.addPortType(portType);

		SOAPBindingImpl soapBinding = new SOAPBindingImpl();
		soapBinding.setTransportURI("soapBindingTransportURI");
		binding.addExtensibilityElement(soapBinding);

		bus.getExtension(WSDLManager.class).addDefinition("wsdlUrl", definition);

		Client client = jaxWsDynamicClientFactory.createClient("wsdlUrl", new QName("serviceNS", "serviceLP"),
				new QName("portNS", "portLP"));

	}

}
