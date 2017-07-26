package com.github.xdptdr.cxf.phi;

import javax.wsdl.Binding;
import javax.wsdl.Definition;
import javax.wsdl.Input;
import javax.wsdl.Message;
import javax.wsdl.Operation;
import javax.wsdl.OperationType;
import javax.wsdl.Part;
import javax.wsdl.Port;
import javax.wsdl.PortType;
import javax.wsdl.Service;
import javax.wsdl.Types;
import javax.wsdl.WSDLException;
import javax.wsdl.extensions.schema.Schema;
import javax.wsdl.factory.WSDLFactory;
import javax.xml.XMLConstants;
import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.cxf.Bus;
import org.apache.cxf.BusFactory;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.apache.cxf.wsdl.WSDLManager;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.ibm.wsdl.extensions.schema.SchemaImpl;
import com.ibm.wsdl.extensions.soap.SOAPBindingImpl;

public class VirgilAldrich {
	public static void main(String[] args) throws WSDLException, ParserConfigurationException {

		/*-
			org.apache.cxf.transport.http.HTTPTransportFactory
			http://cxf.apache.org/transports/http/configuration
			http://schemas.xmlsoap.org/wsdl/http/
			http://cxf.apache.org/transports/http
			http://schemas.xmlsoap.org/wsdl/http
			
			org.apache.cxf.transport.jms.JMSTransportFactory
			http://cxf.apache.org/transports/jms
			http://cxf.apache.org/transports/jms/configuration
			
			http://cxf.apache.org/transports/udp
			org.jboss.wsf.stack.cxf.addons.transports.udp.UDPTransportFactory
			
			http://cxf.apache.org/transports/local
			org.apache.cxf.transport.local.LocalTransportFactory
			
			org.apache.cxf.binding.soap.SoapTransportFactory
			http://schemas.xmlsoap.org/soap/http
			http://schemas.xmlsoap.org/wsdl/soap12/
			http://www.w3.org/2010/soapjms/
			http://schemas.xmlsoap.org/soap/
			http://schemas.xmlsoap.org/wsdl/soap/http
			http://schemas.xmlsoap.org/wsdl/soap/
			http://www.w3.org/2003/05/soap/bindings/HTTP/
		
		 */

		QName definitionQN = new QName("definitionNS", "definitionLP");
		QName serviceQN = new QName("portNS", "serviceLP");
		QName portTypeQN = new QName("portTypeNS", "portTypeLP");
		QName bindingQN = new QName("bindingNS", "bindingLP");
		QName portQN = new QName("portNS", "portLP");
		QName messageQN = new QName("messageNS", "messageLP");
		QName partQN = new QName("partNS", "partLP");
		QName typeQN = new QName("typeNS", "typeLP");

		Bus bus = BusFactory.getDefaultBus();

		JaxWsDynamicClientFactory jaxWsDynamicClientFactory = JaxWsDynamicClientFactory.newInstance(bus);
		jaxWsDynamicClientFactory.setAllowElementReferences(false);
		WSDLFactory wsdlFactory = WSDLFactory.newInstance();

		Definition definition = wsdlFactory.newDefinition();
		definition.setQName(definitionQN);
		definition.setDocumentBaseURI("documentBaseURI");
		definition.setTargetNamespace("targetNamespace");

		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document d = db.newDocument();

		Element schemaElement = d.createElement("schema");
		schemaElement.setAttribute("targetNamespace", "partNS");

		Element elementElement = d.createElementNS(XMLConstants.W3C_XML_SCHEMA_NS_URI, "element");
		elementElement.setAttribute("name", "partLP");
		schemaElement.appendChild(elementElement);

		Element complexTypeElement = d.createElementNS(XMLConstants.W3C_XML_SCHEMA_NS_URI, "complexType");
		elementElement.appendChild(complexTypeElement);

		Element sequenceElement = d.createElementNS(XMLConstants.W3C_XML_SCHEMA_NS_URI, "sequence");
		complexTypeElement.appendChild(sequenceElement);

		Element subElementElement = d.createElementNS(XMLConstants.W3C_XML_SCHEMA_NS_URI, "element");
		subElementElement.setAttribute("name", "subElementName");
		subElementElement.setAttribute("type", "string");
		sequenceElement.appendChild(subElementElement);

		Schema schema = new SchemaImpl();
		schema.setElementType(partQN);
		schema.setElement(schemaElement);

		Types types = definition.createTypes();
		types.addExtensibilityElement(schema);
		definition.setTypes(types);

		// partQN

		Part part = definition.createPart();
		part.setName("partName");
		part.setElementName(partQN);
		part.setTypeName(null);

		Message message = definition.createMessage();
		message.setQName(messageQN);
		message.addPart(part);

		Input input = definition.createInput();
		input.setName("input");
		input.setMessage(message);

		Operation operation = definition.createOperation();
		operation.setName("partLP");
		operation.setInput(input);
		operation.setStyle(OperationType.ONE_WAY);

		PortType portType = definition.createPortType();
		portType.setQName(portTypeQN);
		portType.addOperation(operation);
		definition.addPortType(portType);

		SOAPBindingImpl soapBinding = new SOAPBindingImpl();

		soapBinding.setTransportURI("http://schemas.xmlsoap.org/wsdl/soap/");

		Binding binding = definition.createBinding();
		binding.setQName(bindingQN);
		binding.setPortType(portType);
		binding.addExtensibilityElement(soapBinding);

		Port port = definition.createPort();
		port.setName("portLP");
		port.setBinding(binding);

		Service service = definition.createService();
		service.setQName(serviceQN);
		service.addPort(port);

		definition.addService(service);

		bus.getExtension(WSDLManager.class).addDefinition("wsdlUrl", definition);

		@SuppressWarnings("unused")
		Client client = jaxWsDynamicClientFactory.createClient("wsdlUrl", serviceQN, portQN);

	}

}
