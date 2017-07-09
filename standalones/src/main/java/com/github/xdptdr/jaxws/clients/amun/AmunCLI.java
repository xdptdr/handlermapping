package com.github.xdptdr.jaxws.clients.amun;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map.Entry;
import java.util.Scanner;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.xml.namespace.QName;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPConstants;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;
import javax.xml.ws.Dispatch;
import javax.xml.ws.Service;
import javax.xml.ws.Service.Mode;

import com.github.xdptdr.utils.CLI;

public class AmunCLI {

	public static enum Kind {
		SERVICE_NAME, PORT_NAME, WSDL
	}

	private static final String AMUN_NAMESPACE = "http://amun.jaxws.xdptdr.github.com/";

	public static void main(String[] args) {

		Client client = ClientBuilder.newClient();

		Scanner command = new Scanner(System.in);

		System.out.println("Enter command:");

		boolean running = true;

		while (running) {
			String line = command.nextLine();
			Response response = null;
			try {
				args = line.split(" ");

				if (CLI.match("quit", args, 0)) {
					System.out.println("Done.");
					running = false;
				} else if (CLI.match("hello", args, 0)) {
					Dispatch<SOAPMessage> d = getPort();

					MessageFactory mf = MessageFactory.newInstance(SOAPConstants.SOAP_1_1_PROTOCOL);
					SOAPMessage r = mf.createMessage();
					SOAPPart part = r.getSOAPPart();
					SOAPEnvelope env = part.getEnvelope();
					SOAPHeader header = env.getHeader();
					SOAPBody body = env.getBody();
					SOAPElement op = body.addChildElement("hello", "ns2", AMUN_NAMESPACE);

					r.saveChanges();
					SOAPMessage sresponse = d.invoke(r);
					System.out.println(sresponse.getSOAPPart().getEnvelope().getBody().getFirstChild().getFirstChild()
							.getFirstChild().getNodeValue());

					// System.out.println(p.hello());

				} else if (CLI.match("w", args, 0)) {
					String wsdl = foo(Kind.WSDL);
					response = client.target(wsdl).request().get();
				}
				if (response != null) {
					System.out.println(Status.fromStatusCode(response.getStatus()));
					System.out.println(response.getMediaType());
					MultivaluedMap<String, String> headers = response.getStringHeaders();
					for (Entry<String, List<String>> header : headers.entrySet()) {
						for (String value : header.getValue()) {
							System.out.println(header.getKey() + " = " + value);
						}
					}
					if (response.hasEntity()) {
						System.out.println(response.readEntity(String.class));
					}
				}
			} catch (Exception ex) {
				System.out.println(ex.getClass().getName());
				System.out.println(ex.getMessage());
			}

		}

		command.close();

	}

	private static Dispatch<SOAPMessage> getPort() throws MalformedURLException {
		String serviceName = foo(Kind.SERVICE_NAME);
		String portName = foo(Kind.PORT_NAME);
		URL l = new URL(foo(Kind.WSDL));
		QName portQName = new QName(AMUN_NAMESPACE, portName);
		QName serviceQName = new QName(AMUN_NAMESPACE, serviceName);
		Service s = Service.create(l, serviceQName);

		Dispatch<SOAPMessage> d = s.createDispatch(portQName, SOAPMessage.class, Mode.MESSAGE);

		return d;

	}

	private static String foo(Kind kind) {
		switch (kind) {
		case PORT_NAME:
			return "AmunPort";
		case SERVICE_NAME:
			return "AmunService";
		case WSDL:
			return "http://localhost:8080/mbwar/Amun?wsdl";
		default:
			throw new IllegalArgumentException();
		}
	}

}
