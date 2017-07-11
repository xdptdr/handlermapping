package com.github.xdptdr.wsdl4j;

import java.util.List;
import java.util.Map;

import javax.wsdl.Binding;
import javax.wsdl.BindingFault;
import javax.wsdl.BindingInput;
import javax.wsdl.BindingOperation;
import javax.wsdl.BindingOutput;
import javax.wsdl.Fault;
import javax.wsdl.Import;
import javax.wsdl.Input;
import javax.wsdl.Message;
import javax.wsdl.Operation;
import javax.wsdl.Output;
import javax.wsdl.Part;
import javax.wsdl.Port;
import javax.wsdl.PortType;
import javax.wsdl.Service;
import javax.wsdl.Types;
import javax.wsdl.extensions.ExtensibilityElement;
import javax.xml.namespace.QName;

import org.w3c.dom.Element;

import com.ibm.wsdl.AbstractWSDLElement;
import com.ibm.wsdl.BindingFaultImpl;
import com.ibm.wsdl.BindingImpl;
import com.ibm.wsdl.BindingInputImpl;
import com.ibm.wsdl.BindingOperationImpl;
import com.ibm.wsdl.BindingOutputImpl;
import com.ibm.wsdl.Constants;
import com.ibm.wsdl.DefinitionImpl;
import com.ibm.wsdl.FaultImpl;
import com.ibm.wsdl.ImportImpl;
import com.ibm.wsdl.InputImpl;
import com.ibm.wsdl.MessageImpl;
import com.ibm.wsdl.OperationImpl;
import com.ibm.wsdl.OutputImpl;
import com.ibm.wsdl.PartImpl;
import com.ibm.wsdl.PortImpl;
import com.ibm.wsdl.PortTypeImpl;
import com.ibm.wsdl.ServiceImpl;
import com.ibm.wsdl.TypesImpl;

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

	private static void fooConstants() {

		System.out.println("ATTR_BINDING : " + Constants.ATTR_BINDING);
		System.out.println("ATTR_ELEMENT : " + Constants.ATTR_ELEMENT);
		System.out.println("ATTR_LOCATION : " + Constants.ATTR_LOCATION);
		System.out.println("ATTR_MESSAGE : " + Constants.ATTR_MESSAGE);
		System.out.println("ATTR_NAME : " + Constants.ATTR_NAME);
		System.out.println("ATTR_NAMESPACE : " + Constants.ATTR_NAMESPACE);
		System.out.println("ATTR_PARAMETER_ORDER : " + Constants.ATTR_PARAMETER_ORDER);
		System.out.println("ATTR_REQUIRED : " + Constants.ATTR_REQUIRED);
		System.out.println("ATTR_TARGET_NAMESPACE : " + Constants.ATTR_TARGET_NAMESPACE);
		System.out.println("ATTR_TYPE : " + Constants.ATTR_TYPE);
		System.out.println("ATTR_XMLNS : " + Constants.ATTR_XMLNS);
		System.out.println("ELEM_BINDING : " + Constants.ELEM_BINDING);
		System.out.println("ELEM_DEFINITIONS : " + Constants.ELEM_DEFINITIONS);
		System.out.println("ELEM_DOCUMENTATION : " + Constants.ELEM_DOCUMENTATION);
		System.out.println("ELEM_FAULT : " + Constants.ELEM_FAULT);
		System.out.println("ELEM_IMPORT : " + Constants.ELEM_IMPORT);
		System.out.println("ELEM_INPUT : " + Constants.ELEM_INPUT);
		System.out.println("ELEM_MESSAGE : " + Constants.ELEM_MESSAGE);
		System.out.println("ELEM_OPERATION : " + Constants.ELEM_OPERATION);
		System.out.println("ELEM_OUTPUT : " + Constants.ELEM_OUTPUT);
		System.out.println("ELEM_PART : " + Constants.ELEM_PART);
		System.out.println("ELEM_PORT : " + Constants.ELEM_PORT);
		System.out.println("ELEM_PORT_TYPE : " + Constants.ELEM_PORT_TYPE);
		System.out.println("ELEM_SERVICE : " + Constants.ELEM_SERVICE);
		System.out.println("ELEM_TYPES : " + Constants.ELEM_TYPES);
		System.out.println("FEATURE_PARSE_SCHEMA : " + Constants.FEATURE_PARSE_SCHEMA);
		System.out.println("FEATURE_IMPORT_DOCUMENTS : " + Constants.FEATURE_IMPORT_DOCUMENTS);
		System.out.println("FEATURE_VERBOSE : " + Constants.FEATURE_VERBOSE);
		System.out.println("NONE : " + Constants.NONE);
		System.out.println("NS_URI_WSDL : " + Constants.NS_URI_WSDL);
		System.out.println("XML_DECL_DEFAULT : " + Constants.XML_DECL_DEFAULT);
		System.out.println("XML_DECL_START : " + Constants.XML_DECL_START);
		System.out.println("NS_URI_XMLNS : " + Constants.NS_URI_XMLNS);
		System.out.println("XML_DECL_END : " + Constants.XML_DECL_END);

		System.out.println("BINDING_ATTR_NAMES : " + sa(Constants.BINDING_ATTR_NAMES));
		System.out.println("BINDING_FAULT_ATTR_NAMES : " + sa(Constants.BINDING_FAULT_ATTR_NAMES));
		System.out.println("BINDING_INPUT_ATTR_NAMES : " + sa(Constants.BINDING_INPUT_ATTR_NAMES));
		System.out.println("BINDING_OPERATION_ATTR_NAMES : " + sa(Constants.BINDING_OPERATION_ATTR_NAMES));
		System.out.println("BINDING_OUTPUT_ATTR_NAMES : " + sa(Constants.BINDING_OUTPUT_ATTR_NAMES));
		System.out.println("BINDING_OUTPUT_ATTR_NAMES : " + sa(Constants.BINDING_OUTPUT_ATTR_NAMES));
		System.out.println("DEFINITION_ATTR_NAMES : " + sa(Constants.DEFINITION_ATTR_NAMES));
		System.out.println("FAULT_ATTR_NAMES : " + sa(Constants.FAULT_ATTR_NAMES));
		System.out.println("IMPORT_ATTR_NAMES : " + sa(Constants.IMPORT_ATTR_NAMES));
		System.out.println("INPUT_ATTR_NAMES : " + sa(Constants.INPUT_ATTR_NAMES));
		System.out.println("MESSAGE_ATTR_NAMES : " + sa(Constants.MESSAGE_ATTR_NAMES));
		System.out.println("OPERATION_ATTR_NAMES : " + sa(Constants.OPERATION_ATTR_NAMES));
		System.out.println("OUTPUT_ATTR_NAMES : " + sa(Constants.OUTPUT_ATTR_NAMES));
		System.out.println("PART_ATTR_NAMES : " + sa(Constants.PART_ATTR_NAMES));
		System.out.println("PORT_ATTR_NAMES : " + sa(Constants.PORT_ATTR_NAMES));
		System.out.println("PORT_TYPE_ATTR_NAMES : " + sa(Constants.PORT_TYPE_ATTR_NAMES));
		System.out.println("SERVICE_ATTR_NAMES : " + sa(Constants.SERVICE_ATTR_NAMES));
		System.out.println("TYPES_ATTR_NAMES : " + sa(Constants.TYPES_ATTR_NAMES));

		System.out.println("Q_ATTR_REQUIRED : " + sqn(Constants.Q_ATTR_REQUIRED));
		System.out.println("Q_ELEM_BINDING : " + sqn(Constants.Q_ELEM_BINDING));
		System.out.println("Q_ELEM_DEFINITIONS : " + sqn(Constants.Q_ELEM_DEFINITIONS));
		System.out.println("Q_ELEM_DOCUMENTATION : " + sqn(Constants.Q_ELEM_DOCUMENTATION));
		System.out.println("Q_ELEM_FAULT : " + sqn(Constants.Q_ELEM_FAULT));
		System.out.println("Q_ELEM_IMPORT : " + sqn(Constants.Q_ELEM_IMPORT));
		System.out.println("Q_ELEM_INPUT : " + sqn(Constants.Q_ELEM_INPUT));
		System.out.println("Q_ELEM_MESSAGE : " + sqn(Constants.Q_ELEM_MESSAGE));
		System.out.println("Q_ELEM_OPERATION : " + sqn(Constants.Q_ELEM_OPERATION));
		System.out.println("Q_ELEM_OUTPUT : " + sqn(Constants.Q_ELEM_OUTPUT));
		System.out.println("Q_ELEM_PART : " + sqn(Constants.Q_ELEM_PART));
		System.out.println("Q_ELEM_PORT : " + sqn(Constants.Q_ELEM_PORT));
		System.out.println("Q_ELEM_PORT_TYPE : " + sqn(Constants.Q_ELEM_PORT_TYPE));
		System.out.println("Q_ELEM_SERVICE : " + sqn(Constants.Q_ELEM_SERVICE));
		System.out.println("Q_ELEM_TYPES : " + sqn(Constants.Q_ELEM_TYPES));
	}

	private static String sqn(QName qn) {
		StringBuffer sb = new StringBuffer();
		if (qn != null) {
			sb.append(qn.getNamespaceURI());
			sb.append(" ");
			sb.append(qn.getPrefix());
			sb.append(" ");
			sb.append(qn.getLocalPart());
		}
		return sb.toString();
	}

	private static String sa(String[] strs) {
		StringBuffer buf = new StringBuffer();
		if (strs != null) {
			boolean sep = false;
			for (String str : strs) {
				if (sep) {
					buf.append(", ");
				}
				buf.append(str);
				sep = true;
			}
		}
		return buf.toString();

	}

	private static void fooDefinitionImpl() {

		DefinitionImpl d = new DefinitionImpl();
		BindingFault bindingFault = d.createBindingFault();
		Binding binding = d.createBinding();
		BindingInput bindingInput = d.createBindingInput();
		BindingOutput bindingOutput = d.createBindingOutput();
		BindingOperation bindingOperation = d.createBindingOperation();
		Fault fault = d.createFault();
		Import imporT = d.createImport();
		Input input = d.createInput();
		Message message = d.createMessage();
		Operation operation = d.createOperation();
		Output output = d.createOutput();
		Part part = d.createPart();
		Port port = d.createPort();
		PortType portType = d.createPortType();
		Service service = d.createService();
		Types types = d.createTypes();

		System.out.println(bindingFault instanceof BindingFaultImpl);
		System.out.println(binding instanceof BindingImpl);
		System.out.println(bindingInput instanceof BindingInputImpl);
		System.out.println(bindingOutput instanceof BindingOutputImpl);
		System.out.println(bindingOperation instanceof BindingOperationImpl);
		System.out.println(fault instanceof FaultImpl);
		System.out.println(imporT instanceof ImportImpl);
		System.out.println(input instanceof InputImpl);
		System.out.println(message instanceof MessageImpl);
		System.out.println(operation instanceof OperationImpl);
		System.out.println(output instanceof OutputImpl);
		System.out.println(part instanceof PartImpl);
		System.out.println(port instanceof PortImpl);
		System.out.println(portType instanceof PortTypeImpl);
		System.out.println(service instanceof ServiceImpl);
		System.out.println(types instanceof TypesImpl);

		d.addBinding(binding);
		d.addImport(imporT);
		d.addMessage(message);
		d.addNamespace("prf", "http://baal");
		d.addPortType(portType);
		d.addService(service);

		binding.addBindingOperation(bindingOperation);
		binding.setPortType(portType);

		bindingOperation.addBindingFault(bindingFault);
		bindingOperation.setBindingInput(bindingInput);
		bindingOperation.setBindingOutput(bindingOutput);
		bindingOperation.setOperation(operation);

		fault.setMessage(message);

		System.out.println(d.toString());

	}

	public static void main(String[] args) {
		fooDefinitionImpl();
	}

}
