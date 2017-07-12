package com.github.xdptdr.wsdl4j;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;

import javax.wsdl.Definition;
import javax.wsdl.WSDLException;
import javax.wsdl.extensions.ExtensibilityElement;
import javax.wsdl.extensions.ExtensionRegistry;
import javax.wsdl.extensions.ExtensionSerializer;
import javax.wsdl.extensions.schema.SchemaImport;
import javax.wsdl.extensions.schema.SchemaReference;
import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.ibm.wsdl.DefinitionImpl;
import com.ibm.wsdl.extensions.schema.SchemaConstants;
import com.ibm.wsdl.extensions.schema.SchemaDeserializer;
import com.ibm.wsdl.extensions.schema.SchemaImpl;
import com.ibm.wsdl.extensions.schema.SchemaImportImpl;
import com.ibm.wsdl.extensions.schema.SchemaReferenceImpl;
import com.ibm.wsdl.extensions.schema.SchemaSerializer;

public class BaalBerith {

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

		SchemaImpl schema = new SchemaImpl();

		SchemaImport schemaImport = schema.createImport();
		assert (schemaImport instanceof SchemaImportImpl);

		schemaImport.setNamespaceURI("toto");

		schema.addImport(schemaImport);

		SchemaReference schemaReferenceInclude = schema.createInclude();
		assert (schemaReferenceInclude instanceof SchemaReferenceImpl);

		schemaReferenceInclude.setId("hello");

		schema.addInclude(schemaReferenceInclude);

		SchemaReference schemaReferenceRedefine = schema.createRedefine();
		assert (schemaReferenceRedefine instanceof SchemaReferenceImpl);
		schema.addRedefine(schemaReferenceRedefine);

		schema.setRequired(true);

		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document d = db.newDocument();

		Element element = d.createElement("div");
		schema.setElement(element);

		schema.setDocumentBaseURI("documentBaseURI");

		SchemaSerializer schemaSerializer = new SchemaSerializer();

		System.out.println(serializer.serialize(schemaSerializer, schema));

	}

	private static void fooDes() {
		SchemaDeserializer.class.getName();
	}

	private static void fooConstants() {

		System.out.println("ATTR_ID : " + SchemaConstants.ATTR_ID);
		System.out.println("ATTR_SCHEMA_LOCATION : " + SchemaConstants.ATTR_SCHEMA_LOCATION);
		System.out.println("ELEM_INCLUDE : " + SchemaConstants.ELEM_INCLUDE);
		System.out.println("ELEM_REDEFINE : " + SchemaConstants.ELEM_REDEFINE);
		System.out.println("ELEM_SCHEMA : " + SchemaConstants.ELEM_SCHEMA);
		System.out.println("NS_URI_XSD_1999 : " + SchemaConstants.NS_URI_XSD_1999);
		System.out.println("NS_URI_XSD_2000 : " + SchemaConstants.NS_URI_XSD_2000);
		System.out.println("NS_URI_XSD_2001 : " + SchemaConstants.NS_URI_XSD_2001);

		System.out.println("Q_ELEM_IMPORT_XSD_1999 : " + qns(SchemaConstants.Q_ELEM_IMPORT_XSD_1999));
		System.out.println("Q_ELEM_IMPORT_XSD_2000 : " + qns(SchemaConstants.Q_ELEM_IMPORT_XSD_2000));
		System.out.println("Q_ELEM_IMPORT_XSD_2001 : " + qns(SchemaConstants.Q_ELEM_IMPORT_XSD_2001));
		System.out.println("Q_ELEM_INCLUDE_XSD_1999 : " + qns(SchemaConstants.Q_ELEM_INCLUDE_XSD_1999));
		System.out.println("Q_ELEM_INCLUDE_XSD_2000 : " + qns(SchemaConstants.Q_ELEM_INCLUDE_XSD_2000));
		System.out.println("Q_ELEM_INCLUDE_XSD_2001 : " + qns(SchemaConstants.Q_ELEM_INCLUDE_XSD_2001));
		System.out.println("Q_ELEM_REDEFINE_XSD_1999 : " + qns(SchemaConstants.Q_ELEM_REDEFINE_XSD_1999));
		System.out.println("Q_ELEM_REDEFINE_XSD_2000 : " + qns(SchemaConstants.Q_ELEM_REDEFINE_XSD_2000));
		System.out.println("Q_ELEM_REDEFINE_XSD_2001 : " + qns(SchemaConstants.Q_ELEM_REDEFINE_XSD_2001));
		System.out.println("Q_ELEM_XSD_1999 : " + qns(SchemaConstants.Q_ELEM_XSD_1999));
		System.out.println("Q_ELEM_XSD_2000 : " + qns(SchemaConstants.Q_ELEM_XSD_2000));
		System.out.println("Q_ELEM_XSD_2001 : " + qns(SchemaConstants.Q_ELEM_XSD_2001));

		System.out.println("XSD_IMPORT_QNAME_LIST : " + qnsl(SchemaConstants.XSD_IMPORT_QNAME_LIST));
		System.out.println("XSD_INCLUDE_QNAME_LIST : " + qnsl(SchemaConstants.XSD_INCLUDE_QNAME_LIST));
		System.out.println("XSD_QNAME_LIST : " + qnsl(SchemaConstants.XSD_QNAME_LIST));
		System.out.println("XSD_REDEFINE_QNAME_LIST : " + qnsl(SchemaConstants.XSD_REDEFINE_QNAME_LIST));
	}

	@SuppressWarnings("rawtypes")
	private static String qnsl(List qnl) {
		StringBuffer buf = new StringBuffer();
		boolean sep = false;
		for (Object o : qnl) {
			QName qn = (QName) o;
			if (sep) {
				buf.append(", ");
			}
			buf.append(qns(qn));
			sep = true;

		}
		return buf.toString();
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

	public static void main(String[] args) throws WSDLException, ParserConfigurationException {
		fooSer();
		fooDes();
		fooConstants();
	}

}
