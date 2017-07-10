package com.github.xdptdr.cxf;

import java.util.Map;

import javax.wsdl.WSDLException;
import javax.wsdl.extensions.ExtensibilityElement;
import javax.wsdl.extensions.ExtensionRegistry;

import org.apache.cxf.wsdl.WSDLExtensibilityPlugin;

public class Aaron {
	public void foo() {
		WSDLExtensibilityPlugin ep = new WSDLExtensibilityPlugin() {

			@Override
			public void setExtensionRegistry(ExtensionRegistry registry) {

			}

			@Override
			public ExtensibilityElement createExtension(Map<String, Object> args) throws WSDLException {
				return null;
			}
		};
	}
}
