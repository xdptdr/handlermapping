package com.github.xdptdr.wsdl4j;

import javax.wsdl.xml.WSDLLocator;

import org.apache.cxf.tools.wsdlto.frontend.jaxws.wsdl11.CustomizedWSDLLocator;
import org.apache.cxf.wsdl11.CatalogWSDLLocator;
import org.apache.cxf.wsdl11.ResourceManagerWSDLLocator;
import org.xml.sax.InputSource;

public class Baalim {

	@SuppressWarnings("unused")
	private static void foo() throws InstantiationException, IllegalAccessException {

		String parentLocation = null;
		String importLocation = null;

		WSDLLocator locator = WSDLLocator.class.newInstance();
		InputSource baseInputSource = locator.getBaseInputSource();
		String baseURI = locator.getBaseURI();
		InputSource importInputSource = locator.getImportInputSource(parentLocation, importLocation);
		String latestImportURI = locator.getLatestImportURI();

		locator = CatalogWSDLLocator.class.newInstance();
		locator = CustomizedWSDLLocator.class.newInstance();
		locator = ResourceManagerWSDLLocator.class.newInstance();
	}

	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		foo();
	}

}
