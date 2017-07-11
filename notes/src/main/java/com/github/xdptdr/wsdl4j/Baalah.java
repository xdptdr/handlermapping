package com.github.xdptdr.wsdl4j;

import javax.sound.sampled.Port;
import javax.wsdl.Binding;
import javax.wsdl.BindingFault;
import javax.wsdl.BindingInput;
import javax.wsdl.BindingOperation;
import javax.wsdl.BindingOutput;
import javax.wsdl.WSDLException;
import javax.wsdl.extensions.ExtensionDeserializer;
import javax.wsdl.extensions.ExtensionRegistry;
import javax.wsdl.extensions.ExtensionSerializer;
import javax.wsdl.extensions.UnknownExtensionDeserializer;
import javax.wsdl.extensions.UnknownExtensionSerializer;
import javax.wsdl.extensions.mime.MIMEPart;
import javax.xml.namespace.QName;

import com.ibm.wsdl.extensions.PopulatedExtensionRegistry;
import com.ibm.wsdl.extensions.http.HTTPAddressSerializer;
import com.ibm.wsdl.extensions.http.HTTPBindingSerializer;
import com.ibm.wsdl.extensions.http.HTTPConstants;
import com.ibm.wsdl.extensions.http.HTTPOperationSerializer;
import com.ibm.wsdl.extensions.http.HTTPUrlEncodedSerializer;
import com.ibm.wsdl.extensions.http.HTTPUrlReplacementSerializer;
import com.ibm.wsdl.extensions.mime.MIMEConstants;
import com.ibm.wsdl.extensions.mime.MIMEContentSerializer;
import com.ibm.wsdl.extensions.mime.MIMEMultipartRelatedSerializer;
import com.ibm.wsdl.extensions.soap.SOAPAddressSerializer;
import com.ibm.wsdl.extensions.soap.SOAPBodySerializer;
import com.ibm.wsdl.extensions.soap.SOAPConstants;
import com.ibm.wsdl.extensions.soap.SOAPFaultSerializer;
import com.ibm.wsdl.extensions.soap.SOAPHeaderSerializer;
import com.ibm.wsdl.extensions.soap.SOAPOperationSerializer;
import com.ibm.wsdl.extensions.soap12.SOAP12AddressSerializer;
import com.ibm.wsdl.extensions.soap12.SOAP12BindingSerializer;
import com.ibm.wsdl.extensions.soap12.SOAP12BodySerializer;
import com.ibm.wsdl.extensions.soap12.SOAP12Constants;
import com.ibm.wsdl.extensions.soap12.SOAP12FaultSerializer;
import com.ibm.wsdl.extensions.soap12.SOAP12HeaderSerializer;
import com.ibm.wsdl.extensions.soap12.SOAP12OperationSerializer;

public class Baalah {

	private static void foo() throws WSDLException {

		PopulatedExtensionRegistry pr = new PopulatedExtensionRegistry();

		ExtensionRegistry r = pr;

		ExtensionDeserializer des = r.getDefaultDeserializer();
		ExtensionSerializer ser = r.getDefaultSerializer();
		assert (des.getClass() == UnknownExtensionDeserializer.class);
		assert (ser.getClass() == UnknownExtensionSerializer.class);

		q(r, Port.class, SOAPConstants.Q_ELEM_SOAP_ADDRESS, SOAPAddressSerializer.class);
		q(r, Binding.class, SOAPConstants.Q_ELEM_SOAP_BINDING, SOAPAddressSerializer.class);
		q(r, BindingInput.class, SOAPConstants.Q_ELEM_SOAP_HEADER, SOAPHeaderSerializer.class);
		q(r, BindingOutput.class, SOAPConstants.Q_ELEM_SOAP_HEADER, SOAPHeaderSerializer.class);
		q(r, MIMEPart.class, SOAPConstants.Q_ELEM_SOAP_HEADER, SOAPHeaderSerializer.class);
		q(r, BindingInput.class, SOAPConstants.Q_ELEM_SOAP_BODY, SOAPBodySerializer.class);
		q(r, BindingOutput.class, SOAPConstants.Q_ELEM_SOAP_BODY, SOAPBodySerializer.class);
		q(r, MIMEPart.class, SOAPConstants.Q_ELEM_SOAP_BODY, SOAPBodySerializer.class);
		q(r, BindingFault.class, SOAPConstants.Q_ELEM_SOAP_FAULT, SOAPFaultSerializer.class);
		q(r, BindingOperation.class, SOAPConstants.Q_ELEM_SOAP_OPERATION, SOAPOperationSerializer.class);
		q(r, Port.class, SOAP12Constants.Q_ELEM_SOAP_ADDRESS, SOAP12AddressSerializer.class);
		q(r, Binding.class, SOAP12Constants.Q_ELEM_SOAP_BINDING, SOAP12BindingSerializer.class);
		q(r, BindingInput.class, SOAP12Constants.Q_ELEM_SOAP_HEADER, SOAP12HeaderSerializer.class);
		q(r, BindingOutput.class, SOAP12Constants.Q_ELEM_SOAP_HEADER, SOAP12HeaderSerializer.class);
		q(r, MIMEPart.class, SOAP12Constants.Q_ELEM_SOAP_HEADER, SOAP12HeaderSerializer.class);
		q(r, BindingInput.class, SOAP12Constants.Q_ELEM_SOAP_BODY, SOAP12BodySerializer.class);

		q(r, BindingOutput.class, SOAP12Constants.Q_ELEM_SOAP_BODY, SOAP12BodySerializer.class);

		q(r, MIMEPart.class, SOAP12Constants.Q_ELEM_SOAP_BODY, SOAP12BodySerializer.class);

		q(r, BindingFault.class, SOAP12Constants.Q_ELEM_SOAP_FAULT, SOAP12FaultSerializer.class);

		q(r, BindingOperation.class, SOAP12Constants.Q_ELEM_SOAP_OPERATION, SOAP12OperationSerializer.class);

		q(r, Port.class, HTTPConstants.Q_ELEM_HTTP_ADDRESS, HTTPAddressSerializer.class);

		q(r, BindingOperation.class, HTTPConstants.Q_ELEM_HTTP_OPERATION, HTTPOperationSerializer.class);

		q(r, Binding.class, HTTPConstants.Q_ELEM_HTTP_BINDING, HTTPBindingSerializer.class);

		q(r, BindingInput.class, HTTPConstants.Q_ELEM_HTTP_URL_ENCODED, HTTPUrlEncodedSerializer.class);

		q(r, BindingInput.class, HTTPConstants.Q_ELEM_HTTP_URL_REPLACEMENT, HTTPUrlReplacementSerializer.class);

		q(r, BindingInput.class, MIMEConstants.Q_ELEM_MIME_CONTENT, MIMEContentSerializer.class);
		q(r, BindingOutput.class, MIMEConstants.Q_ELEM_MIME_CONTENT, MIMEContentSerializer.class);
		q(r, MIMEPart.class, MIMEConstants.Q_ELEM_MIME_CONTENT, MIMEContentSerializer.class);
		q(r, BindingInput.class, MIMEConstants.Q_ELEM_MIME_MULTIPART_RELATED, MIMEMultipartRelatedSerializer.class);
		// registerSerializer(BindingOutput.class,
		// MIMEConstants.Q_ELEM_MIME_MULTIPART_RELATED,
		// mimeMultipartRelatedSer);
		// registerDeserializer(BindingOutput.class,
		// MIMEConstants.Q_ELEM_MIME_MULTIPART_RELATED,
		// mimeMultipartRelatedSer);
		q(r, BindingInput.class, SOAP12Constants.Q_ELEM_SOAP_BODY, SOAP12BodySerializer.class);
		// registerSerializer(MIMEPart.class,
		// MIMEConstants.Q_ELEM_MIME_MULTIPART_RELATED,
		// mimeMultipartRelatedSer);
		// registerDeserializer(MIMEPart.class,
		// MIMEConstants.Q_ELEM_MIME_MULTIPART_RELATED,
		// mimeMultipartRelatedSer);
		q(r, BindingInput.class, SOAP12Constants.Q_ELEM_SOAP_BODY, SOAP12BodySerializer.class);
		// registerSerializer(BindingInput.class,
		// MIMEConstants.Q_ELEM_MIME_MIME_XML, mimeMimeXmlSer);
		// registerDeserializer(BindingInput.class,
		// MIMEConstants.Q_ELEM_MIME_MIME_XML, mimeMimeXmlSer);
		q(r, BindingInput.class, SOAP12Constants.Q_ELEM_SOAP_BODY, SOAP12BodySerializer.class);
		// registerSerializer(BindingOutput.class,
		// MIMEConstants.Q_ELEM_MIME_MIME_XML, mimeMimeXmlSer);
		// registerDeserializer(BindingOutput.class,
		// MIMEConstants.Q_ELEM_MIME_MIME_XML, mimeMimeXmlSer);
		q(r, BindingInput.class, SOAP12Constants.Q_ELEM_SOAP_BODY, SOAP12BodySerializer.class);
		// registerSerializer(MIMEPart.class,
		// MIMEConstants.Q_ELEM_MIME_MIME_XML, mimeMimeXmlSer);
		// registerDeserializer(MIMEPart.class,
		// MIMEConstants.Q_ELEM_MIME_MIME_XML, mimeMimeXmlSer);
		q(r, BindingInput.class, SOAP12Constants.Q_ELEM_SOAP_BODY, SOAP12BodySerializer.class);
		// registerDeserializer(Types.class, SchemaConstants.Q_ELEM_XSD_1999,
		// new SchemaDeserializer());
		// registerSerializer(Types.class, SchemaConstants.Q_ELEM_XSD_1999, new
		// SchemaSerializer());
		q(r, BindingInput.class, SOAP12Constants.Q_ELEM_SOAP_BODY, SOAP12BodySerializer.class);
		// registerDeserializer(Types.class, SchemaConstants.Q_ELEM_XSD_2000,
		// new SchemaDeserializer());
		// registerSerializer(Types.class, SchemaConstants.Q_ELEM_XSD_2000, new
		// SchemaSerializer());
		q(r, BindingInput.class, SOAP12Constants.Q_ELEM_SOAP_BODY, SOAP12BodySerializer.class);
		// registerDeserializer(Types.class, SchemaConstants.Q_ELEM_XSD_2001,
		// new SchemaDeserializer());
		// registerSerializer(Types.class, SchemaConstants.Q_ELEM_XSD_2001, new
		// SchemaSerializer());
		q(r, BindingInput.class, SOAP12Constants.Q_ELEM_SOAP_BODY, SOAP12BodySerializer.class);
		/*-
				{
					{
						SOAPAddressSerializer soapAddressSer = new SOAPAddressSerializer();
						mapExtensionTypes(Port.class, SOAPConstants.Q_ELEM_SOAP_ADDRESS, SOAPAddressImpl.class);
						SOAPBindingSerializer soapBindingSer = new SOAPBindingSerializer();
						mapExtensionTypes(Binding.class, SOAPConstants.Q_ELEM_SOAP_BINDING, SOAPBindingImpl.class);
						SOAPHeaderSerializer soapHeaderSer = new SOAPHeaderSerializer();
						mapExtensionTypes(BindingInput.class, SOAPConstants.Q_ELEM_SOAP_HEADER, SOAPHeaderImpl.class);
						mapExtensionTypes(BindingOutput.class, SOAPConstants.Q_ELEM_SOAP_HEADER, SOAPHeaderImpl.class);
						mapExtensionTypes(SOAPHeader.class, SOAPConstants.Q_ELEM_SOAP_HEADER_FAULT, SOAPHeaderFaultImpl.class);
						mapExtensionTypes(MIMEPart.class, SOAPConstants.Q_ELEM_SOAP_HEADER, SOAPHeaderImpl.class);
						SOAPBodySerializer soapBodySer = new SOAPBodySerializer();
						mapExtensionTypes(BindingInput.class, SOAPConstants.Q_ELEM_SOAP_BODY, SOAPBodyImpl.class);
						mapExtensionTypes(BindingOutput.class, SOAPConstants.Q_ELEM_SOAP_BODY, SOAPBodyImpl.class);
						mapExtensionTypes(MIMEPart.class, SOAPConstants.Q_ELEM_SOAP_BODY, SOAPBodyImpl.class);
						SOAPFaultSerializer soapFaultSer = new SOAPFaultSerializer();
						mapExtensionTypes(BindingFault.class, SOAPConstants.Q_ELEM_SOAP_FAULT, SOAPFaultImpl.class);
						SOAPOperationSerializer soapOperationSer = new SOAPOperationSerializer();
						mapExtensionTypes(BindingOperation.class, SOAPConstants.Q_ELEM_SOAP_OPERATION, SOAPOperationImpl.class);
						SOAP12AddressSerializer soap12AddressSer = new SOAP12AddressSerializer();
						mapExtensionTypes(Port.class, SOAP12Constants.Q_ELEM_SOAP_ADDRESS, SOAP12AddressImpl.class);
						SOAP12BindingSerializer soap12BindingSer = new SOAP12BindingSerializer();
						mapExtensionTypes(Binding.class, SOAP12Constants.Q_ELEM_SOAP_BINDING, SOAP12BindingImpl.class);
						SOAP12HeaderSerializer soap12HeaderSer = new SOAP12HeaderSerializer();
						mapExtensionTypes(BindingInput.class, SOAP12Constants.Q_ELEM_SOAP_HEADER, SOAP12HeaderImpl.class);
						mapExtensionTypes(BindingOutput.class, SOAP12Constants.Q_ELEM_SOAP_HEADER, SOAP12HeaderImpl.class);
						mapExtensionTypes(SOAP12Header.class, SOAP12Constants.Q_ELEM_SOAP_HEADER_FAULT,
								SOAP12HeaderFaultImpl.class);
						
						mapExtensionTypes(MIMEPart.class, SOAP12Constants.Q_ELEM_SOAP_HEADER, SOAP12HeaderImpl.class);
		
						SOAP12BodySerializer soap12BodySer = new SOAP12BodySerializer();
		
						
						mapExtensionTypes(BindingInput.class, SOAP12Constants.Q_ELEM_SOAP_BODY, SOAP12BodyImpl.class);
						
						mapExtensionTypes(BindingOutput.class, SOAP12Constants.Q_ELEM_SOAP_BODY, SOAP12BodyImpl.class);
						
						mapExtensionTypes(MIMEPart.class, SOAP12Constants.Q_ELEM_SOAP_BODY, SOAP12BodyImpl.class);
		
						SOAP12FaultSerializer soap12FaultSer = new SOAP12FaultSerializer();
		
						
						mapExtensionTypes(BindingFault.class, SOAP12Constants.Q_ELEM_SOAP_FAULT, SOAP12FaultImpl.class);
		
						SOAP12OperationSerializer soap12OperationSer = new SOAP12OperationSerializer();
		
						
						mapExtensionTypes(BindingOperation.class, SOAP12Constants.Q_ELEM_SOAP_OPERATION,
								SOAP12OperationImpl.class);
		
						HTTPAddressSerializer httpAddressSer = new HTTPAddressSerializer();
		
						
						mapExtensionTypes(Port.class, HTTPConstants.Q_ELEM_HTTP_ADDRESS, HTTPAddressImpl.class);
		
						HTTPOperationSerializer httpOperationSer = new HTTPOperationSerializer();
		
						
						mapExtensionTypes(BindingOperation.class, HTTPConstants.Q_ELEM_HTTP_OPERATION, HTTPOperationImpl.class);
		
						HTTPBindingSerializer httpBindingSer = new HTTPBindingSerializer();
		
						
						mapExtensionTypes(Binding.class, HTTPConstants.Q_ELEM_HTTP_BINDING, HTTPBindingImpl.class);
		
						HTTPUrlEncodedSerializer httpUrlEncodedSer = new HTTPUrlEncodedSerializer();
		
						
						mapExtensionTypes(BindingInput.class, HTTPConstants.Q_ELEM_HTTP_URL_ENCODED, HTTPUrlEncodedImpl.class);
		
						HTTPUrlReplacementSerializer httpUrlReplacementSer = new HTTPUrlReplacementSerializer();
		
						
						mapExtensionTypes(BindingInput.class, HTTPConstants.Q_ELEM_HTTP_URL_REPLACEMENT,
								HTTPUrlReplacementImpl.class);
		
						MIMEContentSerializer mimeContentSer = new MIMEContentSerializer();
		
						
						mapExtensionTypes(BindingInput.class, MIMEConstants.Q_ELEM_MIME_CONTENT, MIMEContentImpl.class);
						
						mapExtensionTypes(BindingOutput.class, MIMEConstants.Q_ELEM_MIME_CONTENT, MIMEContentImpl.class);
						
						mapExtensionTypes(MIMEPart.class, MIMEConstants.Q_ELEM_MIME_CONTENT, MIMEContentImpl.class);
		
						MIMEMultipartRelatedSerializer mimeMultipartRelatedSer = new MIMEMultipartRelatedSerializer();
		
						
						mapExtensionTypes(BindingInput.class, MIMEConstants.Q_ELEM_MIME_MULTIPART_RELATED,
								MIMEMultipartRelatedImpl.class);
						
						mapExtensionTypes(BindingOutput.class, MIMEConstants.Q_ELEM_MIME_MULTIPART_RELATED,
								MIMEMultipartRelatedImpl.class);
						
						mapExtensionTypes(MIMEPart.class, MIMEConstants.Q_ELEM_MIME_MULTIPART_RELATED,
								MIMEMultipartRelatedImpl.class);
						mapExtensionTypes(MIMEMultipartRelated.class, MIMEConstants.Q_ELEM_MIME_PART, MIMEPartImpl.class);
		
						MIMEMimeXmlSerializer mimeMimeXmlSer = new MIMEMimeXmlSerializer();
		
						
						mapExtensionTypes(BindingInput.class, MIMEConstants.Q_ELEM_MIME_MIME_XML, MIMEMimeXmlImpl.class);
						
						mapExtensionTypes(BindingOutput.class, MIMEConstants.Q_ELEM_MIME_MIME_XML, MIMEMimeXmlImpl.class);
						
						mapExtensionTypes(MIMEPart.class, MIMEConstants.Q_ELEM_MIME_MIME_XML, MIMEMimeXmlImpl.class);
		
						// Register the schema parser
		
						mapExtensionTypes(Types.class, SchemaConstants.Q_ELEM_XSD_1999, SchemaImpl.class);
						
		
						mapExtensionTypes(Types.class, SchemaConstants.Q_ELEM_XSD_2000, SchemaImpl.class);
						
		
						mapExtensionTypes(Types.class, SchemaConstants.Q_ELEM_XSD_2001, SchemaImpl.class);
						
		
					}
				}
		*/
	}

	private static void q(ExtensionRegistry r, Class<?> clazz, QName qn, Class<?> sdClazz) throws WSDLException {
		assert (r.querySerializer(clazz, qn).getClass() == sdClazz);
		assert (r.queryDeserializer(clazz, qn).getClass() == sdClazz);

	}

	public static void main(String[] args) throws WSDLException {
		foo();
	}

}
