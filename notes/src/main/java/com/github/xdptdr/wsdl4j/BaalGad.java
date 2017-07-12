package com.github.xdptdr.wsdl4j;

import java.io.PrintWriter;
import java.io.StringWriter;

import javax.wsdl.Definition;
import javax.wsdl.WSDLException;
import javax.wsdl.extensions.ExtensibilityElement;
import javax.wsdl.extensions.ExtensionRegistry;
import javax.wsdl.extensions.ExtensionSerializer;
import javax.xml.namespace.QName;

import com.ibm.wsdl.DefinitionImpl;
import com.ibm.wsdl.extensions.soap12.SOAP12AddressImpl;
import com.ibm.wsdl.extensions.soap12.SOAP12AddressSerializer;
import com.ibm.wsdl.extensions.soap12.SOAP12BindingImpl;
import com.ibm.wsdl.extensions.soap12.SOAP12BindingSerializer;
import com.ibm.wsdl.extensions.soap12.SOAP12BodyImpl;
import com.ibm.wsdl.extensions.soap12.SOAP12BodySerializer;
import com.ibm.wsdl.extensions.soap12.SOAP12Constants;
import com.ibm.wsdl.extensions.soap12.SOAP12FaultImpl;
import com.ibm.wsdl.extensions.soap12.SOAP12FaultSerializer;
import com.ibm.wsdl.extensions.soap12.SOAP12HeaderFaultImpl;
import com.ibm.wsdl.extensions.soap12.SOAP12HeaderImpl;
import com.ibm.wsdl.extensions.soap12.SOAP12HeaderSerializer;
import com.ibm.wsdl.extensions.soap12.SOAP12OperationImpl;
import com.ibm.wsdl.extensions.soap12.SOAP12OperationSerializer;

public class BaalGad {

	public static class Serializer {

		private Class<?> parentType;
		private QName elementType;
		private Definition definition = new DefinitionImpl();
		private ExtensionRegistry extensionRegistry = new ExtensionRegistry();

		public String serialize(ExtensionSerializer extensionSerializer, ExtensibilityElement extensibilityElement)
				throws WSDLException {

			StringWriter stringWriter = new StringWriter();
			PrintWriter printWriter = new PrintWriter(stringWriter);

			extensionSerializer.marshall(parentType, elementType, extensibilityElement, printWriter, definition,
					extensionRegistry);

			return stringWriter.toString();
		}

		public Class<?> getParentType() {
			return parentType;
		}

		public void setParentType(Class<?> parentType) {
			this.parentType = parentType;
		}

		public QName getElementType() {
			return elementType;
		}

		public void setElementType(QName elementType) {
			this.elementType = elementType;
		}

		public ExtensionRegistry getExtensionRegistry() {
			return extensionRegistry;
		}

		public Definition getDefinition() {
			return definition;
		}

	}

	private static void fooSer() throws WSDLException {

		Serializer serializer = new Serializer();
		serializer.getDefinition().addNamespace("soap12", SOAP12Constants.NS_URI_SOAP12);

		SOAP12AddressSerializer soap12AddressSerializer = new SOAP12AddressSerializer();
		SOAP12BindingSerializer soap12BindingSerializer = new SOAP12BindingSerializer();
		SOAP12BodySerializer soap12BodySerializer = new SOAP12BodySerializer();
		SOAP12FaultSerializer soap12FaultSerializer = new SOAP12FaultSerializer();
		SOAP12HeaderSerializer soap12HeaderSerializer = new SOAP12HeaderSerializer();
		SOAP12OperationSerializer soap12OperationSerializer = new SOAP12OperationSerializer();

		SOAP12AddressImpl soap12AddressImpl = new SOAP12AddressImpl();
		SOAP12BindingImpl soap12BindingImpl = new SOAP12BindingImpl();
		SOAP12BodyImpl soap12BodyImpl = new SOAP12BodyImpl();
		SOAP12FaultImpl soap12FaultImpl = new SOAP12FaultImpl();
		SOAP12HeaderFaultImpl soap12HeaderFaultImpl = new SOAP12HeaderFaultImpl();
		SOAP12HeaderImpl soap12HeaderImpl = new SOAP12HeaderImpl();
		SOAP12OperationImpl soap12OperationImpl = new SOAP12OperationImpl();

		System.out.println(serializer.serialize(soap12AddressSerializer, soap12AddressImpl));
		System.out.println(serializer.serialize(soap12BindingSerializer, soap12BindingImpl));
		System.out.println(serializer.serialize(soap12BodySerializer, soap12BodyImpl));
		System.out.println(serializer.serialize(soap12FaultSerializer, soap12FaultImpl));
		System.out.println(serializer.serialize(soap12HeaderSerializer, soap12HeaderImpl));
		System.out.println(serializer.serialize(soap12OperationSerializer, soap12OperationImpl));

	}

	private static void fooConstants() {
		SOAP12Constants.class.getName();
	}

	public static void main(String[] args) throws WSDLException {
		fooSer();
		fooConstants();
	}

}
