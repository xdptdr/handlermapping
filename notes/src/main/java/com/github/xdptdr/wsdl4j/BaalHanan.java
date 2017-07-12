package com.github.xdptdr.wsdl4j;

import javax.wsdl.Binding;
import javax.wsdl.BindingFault;
import javax.wsdl.BindingInput;
import javax.wsdl.BindingOperation;
import javax.wsdl.BindingOutput;
import javax.wsdl.Definition;
import javax.wsdl.Fault;
import javax.wsdl.Import;
import javax.wsdl.Input;
import javax.wsdl.Message;
import javax.wsdl.Operation;
import javax.wsdl.OperationType;
import javax.wsdl.Output;
import javax.wsdl.Part;
import javax.wsdl.Port;
import javax.wsdl.PortType;
import javax.wsdl.Service;
import javax.wsdl.Types;
import javax.wsdl.WSDLElement;
import javax.wsdl.WSDLException;
import javax.wsdl.extensions.http.HTTPAddress;
import javax.wsdl.extensions.http.HTTPBinding;
import javax.wsdl.extensions.http.HTTPOperation;
import javax.wsdl.extensions.http.HTTPUrlEncoded;
import javax.wsdl.extensions.http.HTTPUrlReplacement;
import javax.wsdl.extensions.mime.MIMEContent;
import javax.wsdl.extensions.mime.MIMEMimeXml;
import javax.wsdl.extensions.mime.MIMEMultipartRelated;
import javax.wsdl.extensions.mime.MIMEPart;
import javax.wsdl.extensions.schema.Schema;
import javax.wsdl.extensions.schema.SchemaImport;
import javax.wsdl.extensions.schema.SchemaReference;
import javax.wsdl.extensions.soap.SOAPAddress;
import javax.wsdl.extensions.soap.SOAPBinding;
import javax.wsdl.extensions.soap.SOAPBody;
import javax.wsdl.extensions.soap.SOAPFault;
import javax.wsdl.extensions.soap.SOAPHeader;
import javax.wsdl.extensions.soap.SOAPHeaderFault;
import javax.wsdl.extensions.soap.SOAPOperation;
import javax.wsdl.extensions.soap12.SOAP12Address;
import javax.wsdl.extensions.soap12.SOAP12Binding;
import javax.wsdl.extensions.soap12.SOAP12Body;
import javax.wsdl.extensions.soap12.SOAP12Fault;
import javax.wsdl.extensions.soap12.SOAP12Header;
import javax.wsdl.extensions.soap12.SOAP12HeaderFault;
import javax.wsdl.extensions.soap12.SOAP12Operation;

import com.ibm.wsdl.BindingFaultImpl;
import com.ibm.wsdl.BindingImpl;
import com.ibm.wsdl.BindingInputImpl;
import com.ibm.wsdl.BindingOperationImpl;
import com.ibm.wsdl.BindingOutputImpl;
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
import com.ibm.wsdl.extensions.http.HTTPAddressImpl;
import com.ibm.wsdl.extensions.http.HTTPBindingImpl;
import com.ibm.wsdl.extensions.http.HTTPOperationImpl;
import com.ibm.wsdl.extensions.http.HTTPUrlEncodedImpl;
import com.ibm.wsdl.extensions.http.HTTPUrlReplacementImpl;
import com.ibm.wsdl.extensions.mime.MIMEContentImpl;
import com.ibm.wsdl.extensions.mime.MIMEMimeXmlImpl;
import com.ibm.wsdl.extensions.mime.MIMEMultipartRelatedImpl;
import com.ibm.wsdl.extensions.mime.MIMEPartImpl;
import com.ibm.wsdl.extensions.schema.SchemaImpl;
import com.ibm.wsdl.extensions.schema.SchemaImportImpl;
import com.ibm.wsdl.extensions.schema.SchemaReferenceImpl;
import com.ibm.wsdl.extensions.soap.SOAPAddressImpl;
import com.ibm.wsdl.extensions.soap.SOAPBindingImpl;
import com.ibm.wsdl.extensions.soap.SOAPBodyImpl;
import com.ibm.wsdl.extensions.soap.SOAPFaultImpl;
import com.ibm.wsdl.extensions.soap.SOAPHeaderFaultImpl;
import com.ibm.wsdl.extensions.soap.SOAPHeaderImpl;
import com.ibm.wsdl.extensions.soap.SOAPOperationImpl;
import com.ibm.wsdl.extensions.soap12.SOAP12AddressImpl;
import com.ibm.wsdl.extensions.soap12.SOAP12BindingImpl;
import com.ibm.wsdl.extensions.soap12.SOAP12BodyImpl;
import com.ibm.wsdl.extensions.soap12.SOAP12FaultImpl;
import com.ibm.wsdl.extensions.soap12.SOAP12HeaderFaultImpl;
import com.ibm.wsdl.extensions.soap12.SOAP12HeaderImpl;
import com.ibm.wsdl.extensions.soap12.SOAP12OperationImpl;

public class BaalHanan {

	private static void fooI() {

		ass(new BindingImpl() instanceof Binding);
		ass(new BindingFaultImpl() instanceof BindingFault);
		ass(new BindingInputImpl() instanceof BindingInput);
		ass(new BindingOperationImpl() instanceof BindingOperation);
		ass(new BindingOutputImpl() instanceof BindingOutput);
		ass(new DefinitionImpl() instanceof Definition);
		ass(new FaultImpl() instanceof Fault);
		ass(new ImportImpl() instanceof Import);
		ass(new InputImpl() instanceof Input);
		ass(new MessageImpl() instanceof Message);
		ass(new OperationImpl() instanceof Operation);
		ass(new OutputImpl() instanceof Output);
		ass(new PartImpl() instanceof Part);
		ass(new PortImpl() instanceof Port);
		ass(new PortTypeImpl() instanceof PortType);
		ass(new ServiceImpl() instanceof Service);
		ass(new TypesImpl() instanceof Types);

		ass(new HTTPAddressImpl() instanceof HTTPAddress);
		ass(new HTTPBindingImpl() instanceof HTTPBinding);
		ass(new HTTPOperationImpl() instanceof HTTPOperation);
		ass(new HTTPUrlEncodedImpl() instanceof HTTPUrlEncoded);
		ass(new HTTPUrlReplacementImpl() instanceof HTTPUrlReplacement);

		ass(new MIMEContentImpl() instanceof MIMEContent);
		ass(new MIMEMimeXmlImpl() instanceof MIMEMimeXml);
		ass(new MIMEMultipartRelatedImpl() instanceof MIMEMultipartRelated);
		ass(new MIMEPartImpl() instanceof MIMEPart);

		ass(new SchemaImpl() instanceof Schema);
		ass(new SchemaImportImpl() instanceof SchemaImport);
		ass(new SchemaReferenceImpl() instanceof SchemaReference);

		ass(new SOAPAddressImpl() instanceof SOAPAddress);
		ass(new SOAPBindingImpl() instanceof SOAPBinding);
		ass(new SOAPBodyImpl() instanceof SOAPBody);
		ass(new SOAPFaultImpl() instanceof SOAPFault);
		ass(new SOAPHeaderImpl() instanceof SOAPHeader);
		ass(new SOAPHeaderFaultImpl() instanceof SOAPHeaderFault);
		ass(new SOAPOperationImpl() instanceof SOAPOperation);

		ass(new SOAP12AddressImpl() instanceof SOAP12Address);
		ass(new SOAP12BindingImpl() instanceof SOAP12Binding);
		ass(new SOAP12BodyImpl() instanceof SOAP12Body);
		ass(new SOAP12FaultImpl() instanceof SOAP12Fault);
		ass(new SOAP12HeaderImpl() instanceof SOAP12Header);
		ass(new SOAP12HeaderFaultImpl() instanceof SOAP12HeaderFault);
		ass(new SOAP12OperationImpl() instanceof SOAP12Operation);

	}

	private static void ass(boolean b) {
		if (!b) {
			throw new RuntimeException("Assertion failed");
		}

	}

	private static void fooO() {
		OperationType notification = OperationType.NOTIFICATION;
		OperationType oneWay = OperationType.ONE_WAY;
		OperationType requestResponse = OperationType.REQUEST_RESPONSE;
		OperationType solicitResponse = OperationType.SOLICIT_RESPONSE;
		System.out.println(notification);
		System.out.println(oneWay);
		System.out.println(requestResponse);
		System.out.println(solicitResponse);

	}

	private static void fooE() {

		ass(new ServiceImpl() instanceof WSDLElement);
		ass(!(new HTTPAddressImpl() instanceof WSDLElement));

		WSDLException.class.getName();
	}

	public static void main(String[] args) {
		fooI();
		fooO();
		fooE();
	}

}
