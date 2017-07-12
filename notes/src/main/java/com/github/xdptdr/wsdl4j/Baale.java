package com.github.xdptdr.wsdl4j;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.List;

import javax.wsdl.Definition;
import javax.wsdl.WSDLException;
import javax.wsdl.extensions.ExtensibilityElement;
import javax.wsdl.extensions.ExtensionRegistry;
import javax.wsdl.extensions.ExtensionSerializer;
import javax.xml.namespace.QName;

import com.ibm.wsdl.Constants;
import com.ibm.wsdl.DefinitionImpl;
import com.ibm.wsdl.extensions.soap.SOAPAddressImpl;
import com.ibm.wsdl.extensions.soap.SOAPAddressSerializer;
import com.ibm.wsdl.extensions.soap.SOAPBindingImpl;
import com.ibm.wsdl.extensions.soap.SOAPBindingSerializer;
import com.ibm.wsdl.extensions.soap.SOAPBodyImpl;
import com.ibm.wsdl.extensions.soap.SOAPBodySerializer;
import com.ibm.wsdl.extensions.soap.SOAPConstants;
import com.ibm.wsdl.extensions.soap.SOAPFaultImpl;
import com.ibm.wsdl.extensions.soap.SOAPFaultSerializer;
import com.ibm.wsdl.extensions.soap.SOAPHeaderFaultImpl;
import com.ibm.wsdl.extensions.soap.SOAPHeaderImpl;
import com.ibm.wsdl.extensions.soap.SOAPHeaderSerializer;
import com.ibm.wsdl.extensions.soap.SOAPOperationImpl;
import com.ibm.wsdl.extensions.soap.SOAPOperationSerializer;

public class Baale {

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

	private static void foo() throws WSDLException {

		Serializer serializer = new Serializer();
		serializer.getDefinition().addNamespace("wsdl", Constants.NS_URI_WSDL);
		serializer.getDefinition().addNamespace("soap", SOAPConstants.NS_URI_SOAP);
		serializer.getDefinition().addNamespace("nsuri", "namespaceURI");

		SOAPAddressSerializer soapAddressSerializer = new SOAPAddressSerializer();
		SOAPBindingSerializer soapBindingSerializer = new SOAPBindingSerializer();
		SOAPBodySerializer soapBodySerializer = new SOAPBodySerializer();
		SOAPFaultSerializer soapFaultSerializer = new SOAPFaultSerializer();
		SOAPHeaderSerializer soapHeaderSerializer = new SOAPHeaderSerializer();
		SOAPOperationSerializer soapOperationSerializer = new SOAPOperationSerializer();

		SOAPAddressImpl soapAddressImpl = new SOAPAddressImpl();
		soapAddressImpl.setRequired(true);
		soapAddressImpl.setLocationURI("locationURI");

		SOAPBindingImpl soapBindingImpl = new SOAPBindingImpl();
		soapBindingImpl.setRequired(true);
		soapBindingImpl.setStyle("style");
		soapBindingImpl.setTransportURI("transportURI");

		List<String> encodingStyles = Arrays.asList(new String[] { "enc1", "enc2" });
		List<String> parts = Arrays.asList(new String[] { "part1", "part2" });

		SOAPBodyImpl soapBodyImpl = new SOAPBodyImpl();
		soapBodyImpl.setEncodingStyles(encodingStyles);
		soapBodyImpl.setNamespaceURI("namespaceURI");
		soapBodyImpl.setParts(parts);
		soapBodyImpl.setRequired(true);
		soapBodyImpl.setUse("use");

		SOAPFaultImpl soapFaultImpl = new SOAPFaultImpl();
		soapFaultImpl.setEncodingStyles(encodingStyles);
		soapFaultImpl.setName("name");
		soapFaultImpl.setNamespaceURI("namespaceURI");
		soapFaultImpl.setRequired(true);
		soapFaultImpl.setUse("use");

		SOAPHeaderFaultImpl soapHeaderFaultImpl = new SOAPHeaderFaultImpl();
		soapHeaderFaultImpl.setEncodingStyles(encodingStyles);
		QName message = new QName("namespaceURI", "message");
		soapHeaderFaultImpl.setMessage(message);
		soapHeaderFaultImpl.setNamespaceURI("namespaceURI");
		soapHeaderFaultImpl.setPart("part");
		soapHeaderFaultImpl.setRequired(true);
		soapHeaderFaultImpl.setUse("use");

		SOAPHeaderImpl soapHeaderImpl = new SOAPHeaderImpl();
		soapHeaderImpl.setEncodingStyles(encodingStyles);
		soapHeaderImpl.setMessage(message);
		soapHeaderImpl.setNamespaceURI("namespaceURI");
		soapHeaderImpl.setPart("part");
		soapHeaderImpl.setRequired(true);
		soapHeaderImpl.setUse("use");
		soapHeaderImpl.addSOAPHeaderFault(soapHeaderFaultImpl);

		SOAPOperationImpl soapOperationImpl = new SOAPOperationImpl();
		soapOperationImpl.setRequired(true);
		soapOperationImpl.setSoapActionURI("soapActionURI");
		soapOperationImpl.setStyle("style");

		System.out.println(serializer.serialize(soapAddressSerializer, soapAddressImpl));
		System.out.println(serializer.serialize(soapBindingSerializer, soapBindingImpl));
		System.out.println(serializer.serialize(soapBodySerializer, soapBodyImpl));
		System.out.println(serializer.serialize(soapFaultSerializer, soapFaultImpl));
		System.out.println(serializer.serialize(soapHeaderSerializer, soapHeaderImpl));
		System.out.println(serializer.serialize(soapOperationSerializer, soapOperationImpl));

	}

	private static void fooConstants() {
		SOAPConstants.class.getName();

		System.out.println("ATTR_ENCODING_STYLE : " + SOAPConstants.ATTR_ENCODING_STYLE);
		System.out.println("ATTR_PART : " + SOAPConstants.ATTR_PART);
		System.out.println("ATTR_PARTS : " + SOAPConstants.ATTR_PARTS);
		System.out.println("ATTR_SOAP_ACTION : " + SOAPConstants.ATTR_SOAP_ACTION);
		System.out.println("ATTR_STYLE : " + SOAPConstants.ATTR_STYLE);
		System.out.println("ATTR_TRANSPORT : " + SOAPConstants.ATTR_TRANSPORT);
		System.out.println("ATTR_USE : " + SOAPConstants.ATTR_USE);
		System.out.println("ELEM_ADDRESS : " + SOAPConstants.ELEM_ADDRESS);
		System.out.println("ELEM_BODY : " + SOAPConstants.ELEM_BODY);
		System.out.println("ELEM_HEADER : " + SOAPConstants.ELEM_HEADER);
		System.out.println("ELEM_HEADER_FAULT : " + SOAPConstants.ELEM_HEADER_FAULT);
		System.out.println("NS_URI_SOAP : " + SOAPConstants.NS_URI_SOAP);
		System.out.println("Q_ELEM_SOAP_ADDRESS : " + qns(SOAPConstants.Q_ELEM_SOAP_ADDRESS));
		System.out.println("Q_ELEM_SOAP_BINDING : " + qns(SOAPConstants.Q_ELEM_SOAP_BINDING));
		System.out.println("Q_ELEM_SOAP_BODY : " + qns(SOAPConstants.Q_ELEM_SOAP_BODY));
		System.out.println("Q_ELEM_SOAP_FAULT : " + qns(SOAPConstants.Q_ELEM_SOAP_FAULT));
		System.out.println("Q_ELEM_SOAP_HEADER : " + qns(SOAPConstants.Q_ELEM_SOAP_HEADER));
		System.out.println("Q_ELEM_SOAP_HEADER_FAULT : " + qns(SOAPConstants.Q_ELEM_SOAP_HEADER_FAULT));
		System.out.println("Q_ELEM_SOAP_OPERATION : " + qns(SOAPConstants.Q_ELEM_SOAP_OPERATION));

	}

	private static String qns(QName qn) {
		StringBuffer buf = new StringBuffer();
		buf.append(qn.getNamespaceURI());
		buf.append(" ");
		buf.append(qn.getPrefix());
		buf.append(" ");
		buf.append(qn.getLocalPart());
		return buf.toString();
	}

	public static void main(String[] args) throws WSDLException {
		foo();
		fooConstants();
	}

}
