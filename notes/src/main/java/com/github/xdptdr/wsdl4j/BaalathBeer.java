package com.github.xdptdr.wsdl4j;

import java.io.PrintWriter;
import java.io.StringWriter;

import javax.wsdl.Definition;
import javax.wsdl.WSDLException;
import javax.wsdl.extensions.ExtensibilityElement;
import javax.wsdl.extensions.ExtensionRegistry;
import javax.wsdl.extensions.ExtensionSerializer;
import javax.wsdl.extensions.mime.MIMEPart;
import javax.xml.namespace.QName;

import com.ibm.wsdl.Constants;
import com.ibm.wsdl.DefinitionImpl;
import com.ibm.wsdl.extensions.mime.MIMEConstants;
import com.ibm.wsdl.extensions.mime.MIMEContentImpl;
import com.ibm.wsdl.extensions.mime.MIMEContentSerializer;
import com.ibm.wsdl.extensions.mime.MIMEMimeXmlImpl;
import com.ibm.wsdl.extensions.mime.MIMEMimeXmlSerializer;
import com.ibm.wsdl.extensions.mime.MIMEMultipartRelatedImpl;
import com.ibm.wsdl.extensions.mime.MIMEMultipartRelatedSerializer;
import com.ibm.wsdl.extensions.mime.MIMEPartImpl;

public class BaalathBeer {

	public static class Serializer {

		private Class<?> parentType;
		private QName elementType;
		private Definition definition = new DefinitionImpl();
		private ExtensionRegistry extensionRegistry = new ExtensionRegistry();

		public String serialize(ExtensionSerializer extensionSerializer, ExtensibilityElement extensibilityElement)
				throws WSDLException {

			StringWriter stringWriter = new StringWriter();
			PrintWriter printWriter = new PrintWriter(stringWriter);

			extensionSerializer.marshall(parentType, elementType, extensibilityElement, printWriter, definition,
					extensionRegistry);

			return stringWriter.toString();
		}

		public Class<?> getParentType() {
			return parentType;
		}

		public void setParentType(Class<?> parentType) {
			this.parentType = parentType;
		}

		public QName getElementType() {
			return elementType;
		}

		public void setElementType(QName elementType) {
			this.elementType = elementType;
		}

		public ExtensionRegistry getExtensionRegistry() {
			return extensionRegistry;
		}

		public Definition getDefinition() {
			return definition;
		}

	}

	private static void fooSer() throws WSDLException {

		MIMEConstants.class.getName();

		Serializer serializer = new Serializer();
		serializer.getDefinition().addNamespace("mime", MIMEConstants.NS_URI_MIME);
		serializer.getDefinition().addNamespace("wsdl", Constants.NS_URI_WSDL);
		serializer.getExtensionRegistry().registerSerializer(MIMEPart.class, MIMEConstants.Q_ELEM_MIME_CONTENT,
				new MIMEContentSerializer());

		MIMEContentSerializer mimeContentSerializer = new MIMEContentSerializer();
		MIMEContentImpl mimeContentImpl = new MIMEContentImpl();
		mimeContentImpl.setRequired(true);
		mimeContentImpl.setType("type");
		mimeContentImpl.setPart("part");
		System.out.println(serializer.serialize(mimeContentSerializer, mimeContentImpl));

		MIMEPartImpl mimePartImpl = new MIMEPartImpl();
		mimePartImpl.setRequired(true);
		mimePartImpl.addExtensibilityElement(mimeContentImpl);

		MIMEMimeXmlSerializer mimeMimeXmlSerializer = new MIMEMimeXmlSerializer();
		MIMEMimeXmlImpl mimeMimeXmlImpl = new MIMEMimeXmlImpl();
		mimeMimeXmlImpl.setRequired(true);
		mimeMimeXmlImpl.setPart("part");
		System.out.println(serializer.serialize(mimeMimeXmlSerializer, mimeMimeXmlImpl));

		MIMEMultipartRelatedSerializer mimeMultipartRelatedSerializer = new MIMEMultipartRelatedSerializer();
		MIMEMultipartRelatedImpl mimeMultipartRelatedImpl = new MIMEMultipartRelatedImpl();
		mimeMultipartRelatedImpl.setRequired(true);
		mimeMultipartRelatedImpl.addMIMEPart(mimePartImpl);
		System.out.println(serializer.serialize(mimeMultipartRelatedSerializer, mimeMultipartRelatedImpl));

	}

	private static void fooConstants() {
		System.out.println("ATTR_PART : " + MIMEConstants.ATTR_PART);
		System.out.println("ELEM_CONTENT : " + MIMEConstants.ELEM_CONTENT);
		System.out.println("ELEM_MIME_XML : " + MIMEConstants.ELEM_MIME_XML);
		System.out.println("ELEM_MULTIPART_RELATED : " + MIMEConstants.ELEM_MULTIPART_RELATED);
		System.out.println("NS_URI_MIME : " + MIMEConstants.NS_URI_MIME);

		System.out.println("Q_ELEM_MIME_CONTENT : " + qns(MIMEConstants.Q_ELEM_MIME_CONTENT));
		System.out.println("Q_ELEM_MIME_MIME_XML : " + qns(MIMEConstants.Q_ELEM_MIME_MIME_XML));
		System.out.println("Q_ELEM_MIME_MULTIPART_RELATED : " + qns(MIMEConstants.Q_ELEM_MIME_MULTIPART_RELATED));
		System.out.println("Q_ELEM_MIME_PART : " + qns(MIMEConstants.Q_ELEM_MIME_PART));
	}

	private static String qns(QName qn) {
		StringBuffer buf = new StringBuffer();
		buf.append(qn.getNamespaceURI());
		buf.append(" ");
		buf.append(qn.getPrefix());
		buf.append(" ");
		buf.append(qn.getLocalPart());
		return buf.toString();
	}

	public static void main(String[] args) throws WSDLException {
		// fooSer();
		fooConstants();
	}

}
