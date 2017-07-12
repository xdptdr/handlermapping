package com.github.xdptdr.wsdl4j;

import javax.wsdl.WSDLException;
import javax.wsdl.factory.WSDLFactory;

import com.ibm.wsdl.factory.WSDLFactoryImpl;

public class Baali {

	private static void foo() throws WSDLException {
		WSDLFactory factory = WSDLFactory.newInstance();
		azzert(factory instanceof WSDLFactoryImpl);
		factory = WSDLFactory.newInstance(WSDLFactoryImpl.class.getName());
		azzert(factory instanceof WSDLFactoryImpl);
		factory = WSDLFactory.newInstance(WSDLFactoryImpl.class.getName(), Baali.class.getClassLoader());
		azzert(factory instanceof WSDLFactoryImpl);
	}

	private static void azzert(boolean b) {
		if (!b) {
			throw new RuntimeException("Assertion error");
		}
	}

	public static void main(String[] args) throws WSDLException {
		foo();
	}

}
