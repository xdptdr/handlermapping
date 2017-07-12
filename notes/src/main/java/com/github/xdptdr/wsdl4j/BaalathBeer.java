package com.github.xdptdr.wsdl4j;

import com.ibm.wsdl.extensions.mime.MIMEConstants;
import com.ibm.wsdl.extensions.mime.MIMEContentImpl;
import com.ibm.wsdl.extensions.mime.MIMEContentSerializer;
import com.ibm.wsdl.extensions.mime.MIMEMimeXmlImpl;
import com.ibm.wsdl.extensions.mime.MIMEMimeXmlSerializer;
import com.ibm.wsdl.extensions.mime.MIMEMultipartRelatedImpl;
import com.ibm.wsdl.extensions.mime.MIMEMultipartRelatedSerializer;
import com.ibm.wsdl.extensions.mime.MIMEPartImpl;

public class BaalathBeer {
	private static void foo() {

		MIMEConstants.class.getName();

		MIMEContentSerializer mimeContentSerializer = new MIMEContentSerializer();
		MIMEContentImpl mimeContentImpl = new MIMEContentImpl();

		MIMEMimeXmlSerializer mimeMimeXmlSerializer = new MIMEMimeXmlSerializer();
		MIMEMimeXmlImpl mimeMimeXmlImpl = new MIMEMimeXmlImpl();

		MIMEMultipartRelatedSerializer mimeMultipartRelatedSerializer = new MIMEMultipartRelatedSerializer();
		MIMEMultipartRelatedImpl mimeMultipartRelatedImpl = new MIMEMultipartRelatedImpl();

		MIMEPartImpl mimePartImpl = new MIMEPartImpl();
	}

	public static void main(String[] args) {
		foo();
	}

}
