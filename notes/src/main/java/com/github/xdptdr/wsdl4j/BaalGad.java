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
		serializer.getDefinition().addNamespace("wsdl", Constants.NS_URI_WSDL);
		serializer.getDefinition().addNamespace("nsuri", "namespaceURI");

		SOAP12AddressSerializer soap12AddressSerializer = new SOAP12AddressSerializer();
		SOAP12BindingSerializer soap12BindingSerializer = new SOAP12BindingSerializer();
		SOAP12BodySerializer soap12BodySerializer = new SOAP12BodySerializer();
		SOAP12FaultSerializer soap12FaultSerializer = new SOAP12FaultSerializer();
		SOAP12HeaderSerializer soap12HeaderSerializer = new SOAP12HeaderSerializer();
		SOAP12OperationSerializer soap12OperationSerializer = new SOAP12OperationSerializer();

		SOAP12AddressImpl soap12AddressImpl = new SOAP12AddressImpl();
		soap12AddressImpl.setLocationURI("locationURI");
		soap12AddressImpl.setRequired(true);

		SOAP12BindingImpl soap12BindingImpl = new SOAP12BindingImpl();
		soap12BindingImpl.setRequired(true);
		soap12BindingImpl.setStyle("style");
		soap12BindingImpl.setTransportURI("transportURI");

		SOAP12BodyImpl soap12BodyImpl = new SOAP12BodyImpl();
		soap12BodyImpl.setEncodingStyle("encodingStyle");
		soap12BodyImpl.setNamespaceURI("namespaceURI");
		List<String> parts = Arrays.asList(new String[] { "part1", "part2" });
		soap12BodyImpl.setParts(parts);
		soap12BodyImpl.setRequired(true);
		soap12BodyImpl.setUse("use");

		SOAP12FaultImpl soap12FaultImpl = new SOAP12FaultImpl();
		soap12FaultImpl.setEncodingStyle("encodingStyle");
		soap12FaultImpl.setName("name");
		soap12FaultImpl.setNamespaceURI("namespaceURI");
		soap12FaultImpl.setRequired(true);
		soap12FaultImpl.setUse("use");

		SOAP12HeaderFaultImpl soap12HeaderFaultImpl = new SOAP12HeaderFaultImpl();
		soap12HeaderFaultImpl.setEncodingStyle("encodingStyle");
		QName message = new QName("namespaceURI", "localPart", "prefix");
		soap12HeaderFaultImpl.setMessage(message);
		soap12HeaderFaultImpl.setNamespaceURI("namespaceURI");
		soap12HeaderFaultImpl.setPart("part");
		soap12HeaderFaultImpl.setRequired(true);
		soap12HeaderFaultImpl.setUse("use");

		SOAP12HeaderImpl soap12HeaderImpl = new SOAP12HeaderImpl();
		soap12HeaderImpl.setEncodingStyle("encodingStyle");
		soap12HeaderImpl.setMessage(message);
		soap12HeaderImpl.setNamespaceURI("namespaceURI");
		soap12HeaderImpl.setPart("part");
		soap12HeaderImpl.setRequired(true);
		soap12HeaderImpl.setUse("use");
		soap12HeaderImpl.addSOAP12HeaderFault(soap12HeaderFaultImpl);

		SOAP12OperationImpl soap12OperationImpl = new SOAP12OperationImpl();
		soap12OperationImpl.setRequired(true);
		soap12OperationImpl.setSoapActionRequired(true);
		soap12OperationImpl.setSoapActionURI("soapActionURI");
		soap12OperationImpl.setStyle("style");

		System.out.println(serializer.serialize(soap12AddressSerializer, soap12AddressImpl));
		System.out.println(serializer.serialize(soap12BindingSerializer, soap12BindingImpl));
		System.out.println(serializer.serialize(soap12BodySerializer, soap12BodyImpl));
		System.out.println(serializer.serialize(soap12FaultSerializer, soap12FaultImpl));
		System.out.println(serializer.serialize(soap12HeaderSerializer, soap12HeaderImpl));
		System.out.println(serializer.serialize(soap12OperationSerializer, soap12OperationImpl));

	}

	private static void fooConstants() {

		System.out.println("ATTR_ENCODING_STYLE : " + SOAP12Constants.ATTR_ENCODING_STYLE);
		System.out.println("ATTR_PART : " + SOAP12Constants.ATTR_PART);
		System.out.println("ATTR_PARTS : " + SOAP12Constants.ATTR_PARTS);
		System.out.println("ATTR_SOAP_ACTION : " + SOAP12Constants.ATTR_SOAP_ACTION);
		System.out.println("ATTR_SOAP_ACTION_REQUIRED : " + SOAP12Constants.ATTR_SOAP_ACTION_REQUIRED);
		System.out.println("ATTR_STYLE : " + SOAP12Constants.ATTR_STYLE);
		System.out.println("ATTR_TRANSPORT : " + SOAP12Constants.ATTR_TRANSPORT);
		System.out.println("ATTR_USE : " + SOAP12Constants.ATTR_USE);
		System.out.println("ELEM_ADDRESS : " + SOAP12Constants.ELEM_ADDRESS);
		System.out.println("ELEM_BODY : " + SOAP12Constants.ELEM_BODY);
		System.out.println("ELEM_HEADER : " + SOAP12Constants.ELEM_HEADER);
		System.out.println("ELEM_HEADER_FAULT : " + SOAP12Constants.ELEM_HEADER_FAULT);
		System.out.println("NS_URI_SOAP12 : " + SOAP12Constants.NS_URI_SOAP12);
		System.out.println("Q_ELEM_SOAP_ADDRESS : " + qns(SOAP12Constants.Q_ELEM_SOAP_ADDRESS));
		System.out.println("Q_ELEM_SOAP_BINDING : " + qns(SOAP12Constants.Q_ELEM_SOAP_BINDING));
		System.out.println("Q_ELEM_SOAP_BODY : " + qns(SOAP12Constants.Q_ELEM_SOAP_BODY));
		System.out.println("Q_ELEM_SOAP_FAULT : " + qns(SOAP12Constants.Q_ELEM_SOAP_FAULT));
		System.out.println("Q_ELEM_SOAP_HEADER : " + qns(SOAP12Constants.Q_ELEM_SOAP_HEADER));
		System.out.println("Q_ELEM_SOAP_HEADER_FAULT : " + qns(SOAP12Constants.Q_ELEM_SOAP_HEADER_FAULT));
		System.out.println("Q_ELEM_SOAP_OPERATION : " + qns(SOAP12Constants.Q_ELEM_SOAP_OPERATION));
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
		fooSer();
		fooConstants();
	}

}
