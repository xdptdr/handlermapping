package com.github.xdptdr.wsdl4j;

import java.util.List;
import java.util.Map;

import javax.wsdl.BindingOperation;
import javax.wsdl.PortType;
import javax.wsdl.extensions.ExtensibilityElement;
import javax.xml.namespace.QName;

import org.w3c.dom.Element;

import com.ibm.wsdl.AbstractWSDLElement;
import com.ibm.wsdl.BindingFaultImpl;
import com.ibm.wsdl.BindingImpl;

public class Baal {

	@SuppressWarnings({ "rawtypes", "unused" })
	public void fooAbstractWSDLElement() {
		{

			ExtensibilityElement extensibilityElement = null;
			Element element = null;
			List list = null;
			QName qName = null;
			Object object = null;
			Map map = null;

			AbstractWSDLElement abstractWSDLElement = new AbstractWSDLElement() {

				private static final long serialVersionUID = 1L;

				@Override
				public List getNativeAttributeNames() {
					return null;
				}
			};

			abstractWSDLElement.setDocumentationElement(element);
			element = abstractWSDLElement.getDocumentationElement();

			abstractWSDLElement.addExtensibilityElement(extensibilityElement);
			extensibilityElement = abstractWSDLElement.removeExtensibilityElement(extensibilityElement);
			list = abstractWSDLElement.getExtensibilityElements();

			abstractWSDLElement.setExtensionAttribute(qName, object);
			object = abstractWSDLElement.getExtensionAttribute(qName);
			map = abstractWSDLElement.getExtensionAttributes();

			abstractWSDLElement.toString();

		}
	}

	@SuppressWarnings("rawtypes")
	public static void fooBindingFaultImpl() {

		String name = "tigrou";
		List list = null;
		BindingFaultImpl bindingFaultImpl = new BindingFaultImpl();

		bindingFaultImpl.setName(name);
		name = bindingFaultImpl.getName();

		list = bindingFaultImpl.getNativeAttributeNames();
		if (list != null) {
			for (Object o : list) {
				if (o == null) {
					System.out.println("n$");
				} else if (o instanceof String) {
					System.out.println("s$" + o);
				} else {
					System.out.println("c$" + o.getClass().getName());
				}
			}
		}

		System.out.println(bindingFaultImpl.toString());
	}

	@SuppressWarnings({ "rawtypes", "unused" })
	public static void fooBindingImpl() {
		{
			BindingImpl bindingImpl = new BindingImpl();
			List names = bindingImpl.getNativeAttributeNames();
			for (Object n : names) {
				System.out.println(s(n));
			}
		}

		if (t()) {
			return;
		}

		{
			String name = null;
			String inputName = null;
			String outputName = null;
			boolean undefined = false;
			BindingOperation bindingOperation = null;
			PortType portType = null;
			QName qName = null;
			List list = null;

			BindingImpl bindingImpl = new BindingImpl();
			bindingImpl.addBindingOperation(bindingOperation);
			bindingOperation = bindingImpl.getBindingOperation(name, inputName, outputName);
			list = bindingImpl.getBindingOperations();
			list = bindingImpl.getNativeAttributeNames();
			portType = bindingImpl.getPortType();
			qName = bindingImpl.getQName();
			undefined = bindingImpl.isUndefined();
			bindingOperation = bindingImpl.removeBindingOperation(name, inputName, outputName);
			bindingImpl.setPortType(portType);
			bindingImpl.setQName(qName);
			bindingImpl.setUndefined(undefined);
			bindingImpl.toString();
		}

	}

	private static String s(Object o) {
		if (o == null) {
			return "n$";
		} else if (o instanceof String) {
			return (String) o;
		} else {
			return o.getClass().getName();
		}
	}

	public static boolean t() {
		return true;
	}

	public static void main(String[] args) {
		fooBindingImpl();
	}

}
