package com.github.xdptdr.wsdl4j;

import javax.wsdl.Definition;
import javax.wsdl.WSDLException;
import javax.wsdl.extensions.ExtensionRegistry;
import javax.wsdl.factory.WSDLFactory;
import javax.wsdl.xml.WSDLReader;
import javax.wsdl.xml.WSDLWriter;

import com.ibm.wsdl.Constants;
import com.ibm.wsdl.extensions.PopulatedExtensionRegistry;
import com.ibm.wsdl.xml.WSDLReaderImpl;
import com.ibm.wsdl.xml.WSDLWriterImpl;

public class Baalis {

	private static void fooWrite() throws WSDLException {

		WSDLWriter writer = new WSDLWriterImpl();

		WSDLFactory factory = WSDLFactory.newInstance();
		Definition definition = factory.newDefinition();
		definition.addService(definition.createService());
		writer.writeWSDL(definition, System.out);

	}

	private static void fooRead() throws WSDLException {

		WSDLWriter writer = new WSDLWriterImpl();
		
		String wsdlURI = "http://www.webservicex.net/ConvertAcceleration.asmx?WSDL";
		String contextURI = null;
		String documentBaseURI = null;
		String wsdlDocument = null;
		String definitionsElement = null;
		String inputSource = null;
		String locator = null;

		WSDLReader reader = new WSDLReaderImpl();

		System.out.println(reader.getFeature(Constants.FEATURE_VERBOSE));
		System.out.println(reader.getFeature(Constants.FEATURE_IMPORT_DOCUMENTS));

		azzert(reader.getExtensionRegistry() == null);
		azzert(reader.getFactoryImplName() == null);
		Definition definition = reader.readWSDL(wsdlURI);
		writer.writeWSDL(definition, System.out);
		// definition = reader.readWSDL(contextURI, wsdlURI);
		// definition = reader.readWSDL(documentBaseURI, wsdlDocument);
		// definition = reader.readWSDL(documentBaseURI, definitionsElement);
		// definition = reader.readWSDL(documentBaseURI, inputSource);
		// definition = reader.readWSDL(locator);
		// definition = reader.readWSDL(locator, definitionsElement);

	}

	private static void azzert(boolean b) {
		if (!b) {
			throw new RuntimeException("Assertion error");
		}
	}

	public static void main(String[] args) throws WSDLException {
		fooWrite();
		fooRead();
	}

}
