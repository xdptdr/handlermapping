package com.github.xdptdr.wsdl4j;

import java.io.PrintWriter;
import java.io.StringWriter;

import javax.wsdl.Definition;
import javax.wsdl.WSDLException;
import javax.wsdl.extensions.ExtensibilityElement;
import javax.wsdl.extensions.ExtensionRegistry;
import javax.wsdl.extensions.ExtensionSerializer;
import javax.xml.namespace.QName;

import com.ibm.wsdl.Constants;
import com.ibm.wsdl.DefinitionImpl;
import com.ibm.wsdl.extensions.http.HTTPAddressImpl;
import com.ibm.wsdl.extensions.http.HTTPAddressSerializer;
import com.ibm.wsdl.extensions.http.HTTPBindingImpl;
import com.ibm.wsdl.extensions.http.HTTPBindingSerializer;
import com.ibm.wsdl.extensions.http.HTTPConstants;
import com.ibm.wsdl.extensions.http.HTTPOperationImpl;
import com.ibm.wsdl.extensions.http.HTTPUrlEncodedImpl;
import com.ibm.wsdl.extensions.http.HTTPUrlReplacementImpl;

public class Baalath {

	public static class StringWriterHolder {

		private StringWriter stringWriter;
		private PrintWriter printWriter;

		public PrintWriter getNew() {
			if (stringWriter == null) {
				stringWriter = new StringWriter();
				printWriter = new PrintWriter(stringWriter);
			}
			return printWriter;
		}

		public String consume() {
			String str = stringWriter.toString();
			printWriter.close();
			stringWriter = null;
			printWriter = null;
			return str;
		}

	}

	private static void fooImpl() {

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

	private static void fooSer() throws WSDLException {

		StringWriterHolder holder = new StringWriterHolder();

		QName elementType = null;
		ExtensionRegistry extensionRegistry = null;
		Class<?> parentType = null;

		Definition definition = new DefinitionImpl();
		definition.addNamespace("http", HTTPConstants.NS_URI_HTTP);
		definition.addNamespace("wsdl", Constants.NS_URI_WSDL);

		{
			HTTPAddressSerializer httpAddressSerializer = new HTTPAddressSerializer();
			HTTPAddressImpl httpAddressImpl = new HTTPAddressImpl();

			serialize(httpAddressSerializer, parentType, elementType, httpAddressImpl, holder, definition,
					extensionRegistry);

			httpAddressImpl.setRequired(false);

			serialize(httpAddressSerializer, parentType, elementType, httpAddressImpl, holder, definition,
					extensionRegistry);

			httpAddressImpl.setLocationURI("titou");

			serialize(httpAddressSerializer, parentType, elementType, httpAddressImpl, holder, definition,
					extensionRegistry);

			httpAddressImpl.setElementType(new QName("yipee", "yopla"));
			serialize(httpAddressSerializer, parentType, elementType, httpAddressImpl, holder, definition,
					extensionRegistry);
		}

		{
			HTTPBindingSerializer httpBindingSerializer = new HTTPBindingSerializer();
			HTTPBindingImpl httpBindingImpl = new HTTPBindingImpl();

			serialize(httpBindingSerializer, parentType, elementType, httpBindingImpl, holder, definition,
					extensionRegistry);
		}

	}

	private static void serialize(ExtensionSerializer extensionSerializer, Class<?> parentType, QName elementType,
			ExtensibilityElement extensibilityElement, StringWriterHolder holder, Definition definition,
			ExtensionRegistry extensionRegistry) throws WSDLException {
		extensionSerializer.marshall(parentType, elementType, extensibilityElement, holder.getNew(), definition,
				extensionRegistry);
		System.out.println(holder.consume());

	}

	public static void main(String[] args) throws WSDLException {
		fooSer();
	}

}
