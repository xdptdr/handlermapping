package com.github.xdptdr.wsdl4j;

import java.util.List;

import javax.wsdl.Definition;
import javax.wsdl.WSDLException;
import javax.wsdl.extensions.ElementExtensible;
import javax.wsdl.factory.WSDLFactory;

public class BaalPerazim {

	private static void foo() throws WSDLException {

		WSDLFactory factory = WSDLFactory.newInstance();

		Definition definition = factory.newDefinition();

		ElementExtensible[] elements = new ElementExtensible[] { definition.createBinding(),
				definition.createBindingFault(), definition.createBindingInput(), definition.createBindingOperation(),
				definition.createBindingOutput(), definition.createFault(), definition.createImport(),
				definition.createInput(), definition.createMessage(), definition.createOperation(),
				definition.createOutput(), definition.createPart(), definition.createPort(),
				definition.createPortType(), definition.createService(), definition.createTypes() };

		for (ElementExtensible element : elements) {
			dump(element);

		}

	}

	private static void dump(ElementExtensible service) {
		@SuppressWarnings("rawtypes")
		List list = service.getExtensibilityElements();
		for (Object e : list) {
			System.out.println(e.getClass().getName());
		}
	}

	public static void main(String[] args) throws WSDLException {
		foo();
	}

}
