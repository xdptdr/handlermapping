package com.github.xdptdr.wsdl4j;

import java.io.PrintWriter;
import java.io.StringWriter;

import javax.wsdl.Definition;
import javax.wsdl.WSDLException;
import javax.wsdl.extensions.ExtensibilityElement;
import javax.wsdl.extensions.ExtensionRegistry;
import javax.wsdl.extensions.ExtensionSerializer;
import javax.wsdl.extensions.UnknownExtensibilityElement;
import javax.wsdl.extensions.UnknownExtensionDeserializer;
import javax.wsdl.extensions.UnknownExtensionSerializer;
import javax.wsdl.factory.WSDLFactory;
import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.ibm.wsdl.Constants;
import com.ibm.wsdl.DefinitionImpl;

public class BaalPeor {

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

	private static void fooSer() throws WSDLException, ParserConfigurationException {

		Serializer serializer = new Serializer();

		Element element = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument().createElement("div");

		UnknownExtensibilityElement unknownExtensibilityElement = new UnknownExtensibilityElement();
		unknownExtensibilityElement.setElement(element);
		unknownExtensibilityElement.setElementType(new QName("http://foo", "foo")); // no
																					// effect
		unknownExtensibilityElement.setRequired(true); // no effect

		UnknownExtensionSerializer unknownExtensionSerializer = new UnknownExtensionSerializer();
		System.out.println(serializer.serialize(unknownExtensionSerializer, unknownExtensibilityElement));

	}

	private static void fooDes() throws WSDLException, DOMException, ParserConfigurationException {

		WSDLFactory factory = WSDLFactory.newInstance();
		;

		UnknownExtensionDeserializer unknownExtensionDeserializer = new UnknownExtensionDeserializer();

		Class<?> clazz = null;
		QName elementType = new QName("titi", "toto");
		Definition definition = factory.newDefinition();
		ExtensionRegistry extensionRegistry = factory.newPopulatedExtensionRegistry();
		Element element = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument().createElement("div");
		element.setAttributeNS(Constants.NS_URI_WSDL, Constants.ATTR_REQUIRED, "true");
		ExtensibilityElement extensibilityElement = unknownExtensionDeserializer.unmarshall(clazz, elementType, element,
				definition, extensionRegistry);
		System.out.println(extensibilityElement.getClass().getName());
		azzert(extensibilityElement instanceof UnknownExtensibilityElement);
		System.out.println(extensibilityElement.getRequired());
		System.out.println(qns(extensibilityElement.getElementType()));
	}

	private static String qns(QName qn) {
		StringBuffer buf = new StringBuffer();
		if (qn != null) {
			buf.append(qn.getNamespaceURI());
			buf.append(" ");
			buf.append(qn.getPrefix());
			buf.append(" ");
			buf.append(qn.getLocalPart());
		} else {
			buf.append("!null!");
		}
		return buf.toString();
	}

	private static void azzert(boolean b) {
		if (!b) {
			throw new RuntimeException("Assertion Error");
		}

	}

	public static void main(String[] args) throws WSDLException, ParserConfigurationException {
		fooSer();
		fooDes();
	}

}
