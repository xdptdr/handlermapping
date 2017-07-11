package com.github.xdptdr.wsdl4j;

import javax.xml.namespace.QName;

import com.ibm.wsdl.extensions.http.HTTPAddressImpl;
import com.ibm.wsdl.extensions.http.HTTPBindingImpl;
import com.ibm.wsdl.extensions.http.HTTPOperationImpl;
import com.ibm.wsdl.extensions.http.HTTPUrlEncodedImpl;
import com.ibm.wsdl.extensions.http.HTTPUrlReplacementImpl;

public class Baalath {

	private static void foo() {

		QName elementType = null;
		String locationURI = null;
		Boolean required = null;
		String verb = null;

		HTTPAddressImpl address = new HTTPAddressImpl();
		address.setElementType(elementType);
		address.setLocationURI(locationURI);
		address.setRequired(required);

		elementType = address.getElementType();
		locationURI = address.getLocationURI();
		required = address.getRequired();

		address.toString();

		HTTPBindingImpl binding = new HTTPBindingImpl();

		binding.setElementType(elementType);
		binding.setRequired(required);
		binding.setVerb(verb);

		elementType = binding.getElementType();
		required = binding.getRequired();
		verb = binding.getVerb();

		binding.toString();

		HTTPOperationImpl operation = new HTTPOperationImpl();

		operation.setElementType(elementType);
		operation.setLocationURI(locationURI);
		operation.setRequired(required);

		elementType = operation.getElementType();
		locationURI = operation.getLocationURI();
		required = operation.getRequired();

		operation.toString();

		HTTPUrlEncodedImpl urlEncoded = new HTTPUrlEncodedImpl();

		urlEncoded.setElementType(elementType);
		urlEncoded.setRequired(required);

		elementType = urlEncoded.getElementType();
		required = urlEncoded.getRequired();

		urlEncoded.toString();

		HTTPUrlReplacementImpl urlReplacement = new HTTPUrlReplacementImpl();

		urlReplacement.setElementType(elementType);
		urlReplacement.setRequired(required);

		elementType = urlReplacement.getElementType();
		required = urlReplacement.getRequired();

		
		urlReplacement.toString();

	}

	public static void main(String[] args) {
		foo();
	}

}
