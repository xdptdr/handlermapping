package com.github.xdptdr.wsdl4j;

import javax.wsdl.Definition;
import javax.wsdl.Service;
import javax.wsdl.WSDLException;
import javax.wsdl.extensions.ExtensionRegistry;
import javax.wsdl.xml.WSDLReader;
import javax.wsdl.xml.WSDLWriter;
import javax.xml.namespace.QName;

import com.ibm.wsdl.factory.WSDLFactoryImpl;

public class BaalHamon {

	private static void foo() throws WSDLException {
		WSDLFactoryImpl wsdlFactoryImpl = new WSDLFactoryImpl();
		Definition definition = wsdlFactoryImpl.newDefinition();
		@SuppressWarnings("unused")
		ExtensionRegistry extensionRegistry = wsdlFactoryImpl.newPopulatedExtensionRegistry();
		@SuppressWarnings("unused")
		WSDLReader reader = wsdlFactoryImpl.newWSDLReader();
		WSDLWriter writer = wsdlFactoryImpl.newWSDLWriter();

		Service service = definition.createService();
		service.setQName(new QName("nsuri", "serviceName"));

		definition.addService(service);

		writer.writeWSDL(definition, System.out);
	}

	public static void main(String[] args) throws WSDLException {
		foo();
	}

}
