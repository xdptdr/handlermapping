package com.github.xdptdr.notes.wsdl4j;

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
import javax.wsdl.extensions.AttributeExtensible;
import javax.wsdl.extensions.ElementExtensible;
import javax.wsdl.extensions.ExtensibilityElement;
import javax.wsdl.extensions.ExtensionDeserializer;
import javax.wsdl.extensions.ExtensionRegistry;
import javax.wsdl.extensions.ExtensionSerializer;
import javax.wsdl.extensions.UnknownExtensibilityElement;
import javax.wsdl.extensions.UnknownExtensionDeserializer;
import javax.wsdl.extensions.UnknownExtensionSerializer;
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
import javax.wsdl.factory.WSDLFactory;
import javax.wsdl.xml.WSDLLocator;
import javax.wsdl.xml.WSDLReader;
import javax.wsdl.xml.WSDLWriter;

import com.github.xdptdr.notes.N;
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
import com.ibm.wsdl.extensions.PopulatedExtensionRegistry;
import com.ibm.wsdl.extensions.http.HTTPAddressImpl;
import com.ibm.wsdl.extensions.http.HTTPAddressSerializer;
import com.ibm.wsdl.extensions.http.HTTPBindingImpl;
import com.ibm.wsdl.extensions.http.HTTPBindingSerializer;
import com.ibm.wsdl.extensions.http.HTTPConstants;
import com.ibm.wsdl.extensions.http.HTTPOperationImpl;
import com.ibm.wsdl.extensions.http.HTTPOperationSerializer;
import com.ibm.wsdl.extensions.http.HTTPUrlEncodedImpl;
import com.ibm.wsdl.extensions.http.HTTPUrlEncodedSerializer;
import com.ibm.wsdl.extensions.http.HTTPUrlReplacementImpl;
import com.ibm.wsdl.extensions.http.HTTPUrlReplacementSerializer;
import com.ibm.wsdl.extensions.mime.MIMEConstants;
import com.ibm.wsdl.extensions.mime.MIMEContentImpl;
import com.ibm.wsdl.extensions.mime.MIMEContentSerializer;
import com.ibm.wsdl.extensions.mime.MIMEMimeXmlImpl;
import com.ibm.wsdl.extensions.mime.MIMEMimeXmlSerializer;
import com.ibm.wsdl.extensions.mime.MIMEMultipartRelatedImpl;
import com.ibm.wsdl.extensions.mime.MIMEMultipartRelatedSerializer;
import com.ibm.wsdl.extensions.mime.MIMEPartImpl;
import com.ibm.wsdl.extensions.schema.SchemaConstants;
import com.ibm.wsdl.extensions.schema.SchemaDeserializer;
import com.ibm.wsdl.extensions.schema.SchemaImpl;
import com.ibm.wsdl.extensions.schema.SchemaImportImpl;
import com.ibm.wsdl.extensions.schema.SchemaReferenceImpl;
import com.ibm.wsdl.extensions.schema.SchemaSerializer;
import com.ibm.wsdl.extensions.soap.SOAPAddressImpl;
import com.ibm.wsdl.extensions.soap.SOAPAddressSerializer;
import com.ibm.wsdl.extensions.soap.SOAPBindingImpl;
import com.ibm.wsdl.extensions.soap.SOAPBindingSerializer;
import com.ibm.wsdl.extensions.soap.SOAPBodyImpl;
import com.ibm.wsdl.extensions.soap.SOAPBodySerializer;
import com.ibm.wsdl.extensions.soap.SOAPConstants;
import com.ibm.wsdl.extensions.soap.SOAPFaultImpl;
import com.ibm.wsdl.extensions.soap.SOAPFaultSerializer;
import com.ibm.wsdl.extensions.soap.SOAPHeaderFaultImpl;
import com.ibm.wsdl.extensions.soap.SOAPHeaderImpl;
import com.ibm.wsdl.extensions.soap.SOAPHeaderSerializer;
import com.ibm.wsdl.extensions.soap.SOAPOperationImpl;
import com.ibm.wsdl.extensions.soap.SOAPOperationSerializer;
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
import com.ibm.wsdl.factory.WSDLFactoryImpl;
import com.ibm.wsdl.util.IOUtils;
import com.ibm.wsdl.util.ObjectRegistry;
import com.ibm.wsdl.util.StringUtils;
import com.ibm.wsdl.util.xml.DOM2Writer;
import com.ibm.wsdl.util.xml.DOMUtils;
import com.ibm.wsdl.util.xml.QNameUtils;
import com.ibm.wsdl.util.xml.XPathUtils;
import com.ibm.wsdl.xml.WSDLReaderImpl;
import com.ibm.wsdl.xml.WSDLWriterImpl;

public class Notes {
	private static void notes(N n) {
		todos(n);
	}

	private static void todos(N n) {

		n.todo(AbstractWSDLElement.class, BindingFaultImpl.class, BindingImpl.class, BindingInputImpl.class,
				BindingOperationImpl.class, BindingOutputImpl.class, Constants.class, DefinitionImpl.class,
				FaultImpl.class, ImportImpl.class, InputImpl.class, MessageImpl.class, OperationImpl.class,
				OutputImpl.class, PartImpl.class, PortImpl.class, PortTypeImpl.class, ServiceImpl.class,
				TypesImpl.class);
		n.todo(PopulatedExtensionRegistry.class);

		n.todo(HTTPAddressImpl.class, HTTPAddressSerializer.class, HTTPBindingImpl.class, HTTPBindingSerializer.class,
				HTTPConstants.class, HTTPOperationImpl.class, HTTPOperationSerializer.class, HTTPUrlEncodedImpl.class,
				HTTPUrlEncodedSerializer.class, HTTPUrlReplacementImpl.class, HTTPUrlReplacementSerializer.class);

		n.todo(MIMEConstants.class, MIMEContentImpl.class, MIMEContentSerializer.class, MIMEMimeXmlImpl.class,
				MIMEMimeXmlSerializer.class, MIMEMultipartRelatedImpl.class, MIMEMultipartRelatedSerializer.class,
				MIMEPartImpl.class);

		n.todo(SchemaConstants.class, SchemaDeserializer.class, SchemaImpl.class, SchemaImportImpl.class,
				SchemaReferenceImpl.class, SchemaSerializer.class);

		n.todo(SOAPAddressImpl.class, SOAPAddressSerializer.class, SOAPBindingImpl.class, SOAPBindingSerializer.class,
				SOAPBodyImpl.class, SOAPBodySerializer.class, SOAPConstants.class, SOAPFaultImpl.class,
				SOAPFaultSerializer.class, SOAPHeaderFaultImpl.class, SOAPHeaderImpl.class, SOAPHeaderSerializer.class,
				SOAPOperationImpl.class, SOAPOperationSerializer.class);

		n.todo(SOAP12AddressImpl.class, SOAP12AddressSerializer.class, SOAP12BindingImpl.class,
				SOAP12BindingSerializer.class, SOAP12BodyImpl.class, SOAP12BodySerializer.class, SOAP12Constants.class,
				SOAP12FaultImpl.class, SOAP12FaultSerializer.class, SOAP12HeaderFaultImpl.class, SOAP12HeaderImpl.class,
				SOAP12HeaderSerializer.class, SOAP12OperationImpl.class, SOAP12OperationSerializer.class);
		n.todo(WSDLFactoryImpl.class);

		n.todo(IOUtils.class, ObjectRegistry.class, StringUtils.class);

		n.todo(DOM2Writer.class, DOMUtils.class, QNameUtils.class, XPathUtils.class);

		n.todo(WSDLReaderImpl.class, WSDLWriterImpl.class);

		n.todo(Binding.class, BindingFault.class, BindingInput.class, BindingOperation.class, BindingOutput.class,
				Definition.class, Fault.class, Import.class, Input.class, Message.class, Operation.class,
				OperationType.class, Output.class, Part.class, Port.class, PortType.class, Service.class, Types.class,
				WSDLElement.class, WSDLException.class);

		n.todo(AttributeExtensible.class, ElementExtensible.class, ExtensibilityElement.class,
				ExtensionDeserializer.class, ExtensionRegistry.class, ExtensionSerializer.class,
				UnknownExtensibilityElement.class, UnknownExtensionDeserializer.class,
				UnknownExtensionSerializer.class);

		n.todo(HTTPAddress.class, HTTPBinding.class, HTTPOperation.class, HTTPUrlEncoded.class,
				HTTPUrlReplacement.class);

		n.todo(MIMEContent.class, MIMEMimeXml.class, MIMEMultipartRelated.class, MIMEPart.class);
		n.todo(Schema.class, SchemaImport.class, SchemaReference.class);

		n.todo(SOAPAddress.class, SOAPBinding.class, SOAPBody.class, SOAPFault.class, SOAPHeader.class,
				SOAPHeaderFault.class, SOAPOperation.class);

		n.todo(SOAP12Address.class, SOAP12Binding.class, SOAP12Body.class, SOAP12Fault.class, SOAP12Header.class,
				SOAP12HeaderFault.class);

		n.todo(WSDLFactory.class);

		n.todo(WSDLLocator.class, WSDLReader.class, WSDLWriter.class, SOAP12Operation.class);
	}

	public static void main(String[] args) {
		N n = new N();
		notes(n);
		n.sumUp(true);
	}

}
