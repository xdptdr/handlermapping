package com.github.xdptdr.wsdl4j;

import java.io.PrintWriter;

import javax.wsdl.Definition;
import javax.wsdl.WSDLException;
import javax.wsdl.extensions.ExtensibilityElement;
import javax.wsdl.extensions.ExtensionRegistry;
import javax.xml.namespace.QName;

import com.ibm.wsdl.extensions.schema.SchemaConstants;
import com.ibm.wsdl.extensions.schema.SchemaDeserializer;
import com.ibm.wsdl.extensions.schema.SchemaImpl;
import com.ibm.wsdl.extensions.schema.SchemaImportImpl;
import com.ibm.wsdl.extensions.schema.SchemaReferenceImpl;
import com.ibm.wsdl.extensions.schema.SchemaSerializer;

public class BaalBerith {

	private static void fooSer() throws WSDLException {

		SchemaSerializer schemaSerializer = new SchemaSerializer();

		SchemaReferenceImpl schemaReferenceImpl = new SchemaReferenceImpl();

		SchemaImportImpl schemaImportImpl = new SchemaImportImpl();


		SchemaDeserializer schemaDeserializer = new SchemaDeserializer();
		
		SchemaImpl schemaImpl = new SchemaImpl();

		Class<?> parentType = null;
		QName elementType = null;
		PrintWriter pw = null;
		Definition def = null;
		ExtensionRegistry extReg = null;
		schemaSerializer.marshall(parentType, elementType, schemaImpl, pw, def, extReg);

	}

	private static void fooConstants() {
		SchemaConstants.class.getName();
	}

	public static void main(String[] args) throws WSDLException {
		fooSer();
		fooConstants();
	}

}
