package com.github.xdptdr.mbwar.soap.notes;

import javax.faces.FactoryFinder;
import javax.xml.soap.AttachmentPart;
import javax.xml.soap.Detail;
import javax.xml.soap.DetailEntry;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.MimeHeader;
import javax.xml.soap.MimeHeaders;
import javax.xml.soap.Name;
import javax.xml.soap.Node;
import javax.xml.soap.SAAJMetaFactory;
import javax.xml.soap.SAAJResult;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPBodyElement;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPConstants;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPElementFactory;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPFactory;
import javax.xml.soap.SOAPFault;
import javax.xml.soap.SOAPFaultElement;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPHeaderElement;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;
import javax.xml.soap.Text;

import com.github.xdptdr.notes.N;

@SuppressWarnings("deprecation")
public class Notes {

	private static void notes(N n) {
		n.todo(AttachmentPart.class);
		n.todo(Detail.class);
		n.todo(DetailEntry.class);
		n.todo(FactoryFinder.class);
		n.todo(MessageFactory.class);
		n.todo(MimeHeader.class);
		n.todo(MimeHeaders.class);
		n.todo(Name.class);
		n.todo(Node.class);
		n.todo(SAAJMetaFactory.class);
		n.todo(SAAJResult.class);
		n.todo(SOAPBody.class);
		n.todo(SOAPBodyElement.class);
		n.todo(SOAPConnection.class);
		n.todo(SOAPConnectionFactory.class);
		n.todo(SOAPConstants.class);
		n.todo(SOAPElement.class);
		n.todo(SOAPElementFactory.class);
		n.todo(SOAPEnvelope.class);
		n.todo(SOAPException.class);
		n.todo(SOAPFactory.class);
		n.todo(SOAPFault.class);
		n.todo(SOAPFaultElement.class);
		n.todo(SOAPHeader.class);
		n.todo(SOAPHeaderElement.class);
		n.todo(SOAPMessage.class);
		n.todo(SOAPPart.class);
		n.todo(Text.class);

	}

	public static void main(String[] args) {
		N n = new N();
		notes(n);
		n.sumUp();
	}

}
