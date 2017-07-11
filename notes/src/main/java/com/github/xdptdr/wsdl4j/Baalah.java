package com.github.xdptdr.wsdl4j;

import javax.sound.sampled.Port;
import javax.wsdl.Binding;
import javax.wsdl.BindingFault;
import javax.wsdl.BindingInput;
import javax.wsdl.BindingOperation;
import javax.wsdl.BindingOutput;
import javax.wsdl.Types;
import javax.wsdl.WSDLException;
import javax.wsdl.extensions.ExtensionDeserializer;
import javax.wsdl.extensions.ExtensionRegistry;
import javax.wsdl.extensions.ExtensionSerializer;
import javax.wsdl.extensions.UnknownExtensionDeserializer;
import javax.wsdl.extensions.UnknownExtensionSerializer;
import javax.wsdl.extensions.mime.MIMEMultipartRelated;
import javax.wsdl.extensions.mime.MIMEPart;
import javax.wsdl.extensions.soap.SOAPHeader;
import javax.wsdl.extensions.soap12.SOAP12Header;
import javax.xml.namespace.QName;

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
import com.ibm.wsdl.extensions.schema.SchemaSerializer;
import com.ibm.wsdl.extensions.soap.SOAPAddressImpl;
import com.ibm.wsdl.extensions.soap.SOAPAddressSerializer;
import com.ibm.wsdl.extensions.soap.SOAPBindingImpl;
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

public class Baalah {

	private static void checkPopulatedExtensionRegistry() throws WSDLException {

		PopulatedExtensionRegistry per = new PopulatedExtensionRegistry();

		ExtensionRegistry er = per;

		ExtensionDeserializer des = er.getDefaultDeserializer();
		ExtensionSerializer ser = er.getDefaultSerializer();
		assert (des.getClass() == UnknownExtensionDeserializer.class);
		assert (ser.getClass() == UnknownExtensionSerializer.class);

		checkSerialization(er, Port.class, SOAPConstants.Q_ELEM_SOAP_ADDRESS, SOAPAddressSerializer.class);
		checkSerialization(er, Binding.class, SOAPConstants.Q_ELEM_SOAP_BINDING, SOAPAddressSerializer.class);
		checkSerialization(er, BindingInput.class, SOAPConstants.Q_ELEM_SOAP_HEADER, SOAPHeaderSerializer.class);
		checkSerialization(er, BindingOutput.class, SOAPConstants.Q_ELEM_SOAP_HEADER, SOAPHeaderSerializer.class);
		checkSerialization(er, MIMEPart.class, SOAPConstants.Q_ELEM_SOAP_HEADER, SOAPHeaderSerializer.class);
		checkSerialization(er, BindingInput.class, SOAPConstants.Q_ELEM_SOAP_BODY, SOAPBodySerializer.class);
		checkSerialization(er, BindingOutput.class, SOAPConstants.Q_ELEM_SOAP_BODY, SOAPBodySerializer.class);
		checkSerialization(er, MIMEPart.class, SOAPConstants.Q_ELEM_SOAP_BODY, SOAPBodySerializer.class);
		checkSerialization(er, BindingFault.class, SOAPConstants.Q_ELEM_SOAP_FAULT, SOAPFaultSerializer.class);
		checkSerialization(er, BindingOperation.class, SOAPConstants.Q_ELEM_SOAP_OPERATION,
				SOAPOperationSerializer.class);
		checkSerialization(er, Port.class, SOAP12Constants.Q_ELEM_SOAP_ADDRESS, SOAP12AddressSerializer.class);
		checkSerialization(er, Binding.class, SOAP12Constants.Q_ELEM_SOAP_BINDING, SOAP12BindingSerializer.class);
		checkSerialization(er, BindingInput.class, SOAP12Constants.Q_ELEM_SOAP_HEADER, SOAP12HeaderSerializer.class);
		checkSerialization(er, BindingOutput.class, SOAP12Constants.Q_ELEM_SOAP_HEADER, SOAP12HeaderSerializer.class);
		checkSerialization(er, MIMEPart.class, SOAP12Constants.Q_ELEM_SOAP_HEADER, SOAP12HeaderSerializer.class);
		checkSerialization(er, BindingInput.class, SOAP12Constants.Q_ELEM_SOAP_BODY, SOAP12BodySerializer.class);
		checkSerialization(er, BindingOutput.class, SOAP12Constants.Q_ELEM_SOAP_BODY, SOAP12BodySerializer.class);
		checkSerialization(er, MIMEPart.class, SOAP12Constants.Q_ELEM_SOAP_BODY, SOAP12BodySerializer.class);
		checkSerialization(er, BindingFault.class, SOAP12Constants.Q_ELEM_SOAP_FAULT, SOAP12FaultSerializer.class);
		checkSerialization(er, BindingOperation.class, SOAP12Constants.Q_ELEM_SOAP_OPERATION,
				SOAP12OperationSerializer.class);
		checkSerialization(er, Port.class, HTTPConstants.Q_ELEM_HTTP_ADDRESS, HTTPAddressSerializer.class);
		checkSerialization(er, BindingOperation.class, HTTPConstants.Q_ELEM_HTTP_OPERATION,
				HTTPOperationSerializer.class);
		checkSerialization(er, Binding.class, HTTPConstants.Q_ELEM_HTTP_BINDING, HTTPBindingSerializer.class);
		checkSerialization(er, BindingInput.class, HTTPConstants.Q_ELEM_HTTP_URL_ENCODED,
				HTTPUrlEncodedSerializer.class);
		checkSerialization(er, BindingInput.class, HTTPConstants.Q_ELEM_HTTP_URL_REPLACEMENT,
				HTTPUrlReplacementSerializer.class);
		checkSerialization(er, BindingInput.class, MIMEConstants.Q_ELEM_MIME_CONTENT, MIMEContentSerializer.class);
		checkSerialization(er, BindingOutput.class, MIMEConstants.Q_ELEM_MIME_CONTENT, MIMEContentSerializer.class);
		checkSerialization(er, MIMEPart.class, MIMEConstants.Q_ELEM_MIME_CONTENT, MIMEContentSerializer.class);
		checkSerialization(er, BindingInput.class, MIMEConstants.Q_ELEM_MIME_MULTIPART_RELATED,
				MIMEMultipartRelatedSerializer.class);
		checkSerialization(er, BindingInput.class, MIMEConstants.Q_ELEM_MIME_MULTIPART_RELATED,
				MIMEMultipartRelatedSerializer.class);
		checkSerialization(er, MIMEPart.class, MIMEConstants.Q_ELEM_MIME_MULTIPART_RELATED,
				MIMEMultipartRelatedSerializer.class);
		checkSerialization(er, BindingInput.class, MIMEConstants.Q_ELEM_MIME_MIME_XML, MIMEMimeXmlSerializer.class);
		checkSerialization(er, BindingOutput.class, MIMEConstants.Q_ELEM_MIME_MIME_XML, MIMEMimeXmlSerializer.class);
		checkSerialization(er, MIMEPart.class, MIMEConstants.Q_ELEM_MIME_MIME_XML, MIMEMimeXmlSerializer.class);
		checkSerialization(er, Types.class, SchemaConstants.Q_ELEM_XSD_1999, SchemaSerializer.class,
				SchemaDeserializer.class);
		checkSerialization(er, Types.class, SchemaConstants.Q_ELEM_XSD_2000, SchemaSerializer.class,
				SchemaDeserializer.class);
		checkSerialization(er, Types.class, SchemaConstants.Q_ELEM_XSD_2001, SchemaSerializer.class,
				SchemaDeserializer.class);

		checkExtensionType(er, Port.class, SOAPConstants.Q_ELEM_SOAP_ADDRESS, SOAPAddressImpl.class);
		checkExtensionType(er, Binding.class, SOAPConstants.Q_ELEM_SOAP_BINDING, SOAPBindingImpl.class);
		checkExtensionType(er, BindingInput.class, SOAPConstants.Q_ELEM_SOAP_HEADER, SOAPHeaderImpl.class);
		checkExtensionType(er, BindingOutput.class, SOAPConstants.Q_ELEM_SOAP_HEADER, SOAPHeaderImpl.class);
		checkExtensionType(er, SOAPHeader.class, SOAPConstants.Q_ELEM_SOAP_HEADER_FAULT, SOAPHeaderFaultImpl.class);
		checkExtensionType(er, MIMEPart.class, SOAPConstants.Q_ELEM_SOAP_HEADER, SOAPHeaderImpl.class);
		checkExtensionType(er, BindingInput.class, SOAPConstants.Q_ELEM_SOAP_BODY, SOAPBodyImpl.class);
		checkExtensionType(er, BindingOutput.class, SOAPConstants.Q_ELEM_SOAP_BODY, SOAPBodyImpl.class);
		checkExtensionType(er, MIMEPart.class, SOAPConstants.Q_ELEM_SOAP_BODY, SOAPBodyImpl.class);
		checkExtensionType(er, BindingFault.class, SOAPConstants.Q_ELEM_SOAP_FAULT, SOAPFaultImpl.class);
		checkExtensionType(er, BindingOperation.class, SOAPConstants.Q_ELEM_SOAP_OPERATION, SOAPOperationImpl.class);
		checkExtensionType(er, Port.class, SOAP12Constants.Q_ELEM_SOAP_ADDRESS, SOAP12AddressImpl.class);
		checkExtensionType(er, Binding.class, SOAP12Constants.Q_ELEM_SOAP_BINDING, SOAP12BindingImpl.class);
		checkExtensionType(er, BindingInput.class, SOAP12Constants.Q_ELEM_SOAP_HEADER, SOAP12HeaderImpl.class);
		checkExtensionType(er, BindingOutput.class, SOAP12Constants.Q_ELEM_SOAP_HEADER, SOAP12HeaderImpl.class);
		checkExtensionType(er, SOAP12Header.class, SOAP12Constants.Q_ELEM_SOAP_HEADER_FAULT,
				SOAP12HeaderFaultImpl.class);
		checkExtensionType(er, MIMEPart.class, SOAP12Constants.Q_ELEM_SOAP_HEADER, SOAP12HeaderImpl.class);
		checkExtensionType(er, BindingInput.class, SOAP12Constants.Q_ELEM_SOAP_BODY, SOAP12BodyImpl.class);
		checkExtensionType(er, BindingOutput.class, SOAP12Constants.Q_ELEM_SOAP_BODY, SOAP12BodyImpl.class);
		checkExtensionType(er, MIMEPart.class, SOAP12Constants.Q_ELEM_SOAP_BODY, SOAP12BodyImpl.class);
		checkExtensionType(er, BindingFault.class, SOAP12Constants.Q_ELEM_SOAP_FAULT, SOAP12FaultImpl.class);
		checkExtensionType(er, BindingOperation.class, SOAP12Constants.Q_ELEM_SOAP_OPERATION,
				SOAP12OperationImpl.class);
		checkExtensionType(er, Port.class, HTTPConstants.Q_ELEM_HTTP_ADDRESS, HTTPAddressImpl.class);
		checkExtensionType(er, BindingOperation.class, HTTPConstants.Q_ELEM_HTTP_OPERATION, HTTPOperationImpl.class);
		checkExtensionType(er, Binding.class, HTTPConstants.Q_ELEM_HTTP_BINDING, HTTPBindingImpl.class);
		checkExtensionType(er, BindingInput.class, HTTPConstants.Q_ELEM_HTTP_URL_ENCODED, HTTPUrlEncodedImpl.class);
		checkExtensionType(er, BindingInput.class, HTTPConstants.Q_ELEM_HTTP_URL_REPLACEMENT,
				HTTPUrlReplacementImpl.class);
		checkExtensionType(er, BindingInput.class, MIMEConstants.Q_ELEM_MIME_CONTENT, MIMEContentImpl.class);
		checkExtensionType(er, BindingOutput.class, MIMEConstants.Q_ELEM_MIME_CONTENT, MIMEContentImpl.class);
		checkExtensionType(er, MIMEPart.class, MIMEConstants.Q_ELEM_MIME_CONTENT, MIMEContentImpl.class);
		checkExtensionType(er, BindingInput.class, MIMEConstants.Q_ELEM_MIME_MULTIPART_RELATED,
				MIMEMultipartRelatedImpl.class);
		checkExtensionType(er, BindingOutput.class, MIMEConstants.Q_ELEM_MIME_MULTIPART_RELATED,
				MIMEMultipartRelatedImpl.class);
		checkExtensionType(er, MIMEPart.class, MIMEConstants.Q_ELEM_MIME_MULTIPART_RELATED,
				MIMEMultipartRelatedImpl.class);
		checkExtensionType(er, MIMEMultipartRelated.class, MIMEConstants.Q_ELEM_MIME_PART, MIMEPartImpl.class);
		checkExtensionType(er, BindingInput.class, MIMEConstants.Q_ELEM_MIME_MIME_XML, MIMEMimeXmlImpl.class);
		checkExtensionType(er, BindingOutput.class, MIMEConstants.Q_ELEM_MIME_MIME_XML, MIMEMimeXmlImpl.class);
		checkExtensionType(er, MIMEPart.class, MIMEConstants.Q_ELEM_MIME_MIME_XML, MIMEMimeXmlImpl.class);
		checkExtensionType(er, Types.class, SchemaConstants.Q_ELEM_XSD_1999, SchemaImpl.class);
		checkExtensionType(er, Types.class, SchemaConstants.Q_ELEM_XSD_2000, SchemaImpl.class);
		checkExtensionType(er, Types.class, SchemaConstants.Q_ELEM_XSD_2001, SchemaImpl.class);

	}

	private static void checkExtensionType(ExtensionRegistry er, Class<?> clazz, QName qn, Class<?> implClazz)
			throws WSDLException {
		assert (er.createExtension(clazz, qn).getClass() == implClazz);
	}

	private static void checkSerialization(ExtensionRegistry r, Class<?> clazz, QName qn, Class<?> sClazz,
			Class<?> dClazz) throws WSDLException {
		assert (r.querySerializer(clazz, qn).getClass() == sClazz);
		assert (r.queryDeserializer(clazz, qn).getClass() == dClazz);

	}

	private static void checkSerialization(ExtensionRegistry r, Class<?> clazz, QName qn, Class<?> sdClazz)
			throws WSDLException {
		checkSerialization(r, clazz, qn, sdClazz, sdClazz);

	}

	public static void main(String[] args) throws WSDLException {
		checkPopulatedExtensionRegistry();
	}

}
