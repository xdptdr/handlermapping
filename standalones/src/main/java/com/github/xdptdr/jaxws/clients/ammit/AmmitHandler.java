package com.github.xdptdr.jaxws.clients.ammit;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;

import javax.activation.CommandInfo;
import javax.activation.DataHandler;
import javax.xml.namespace.QName;
import javax.xml.soap.AttachmentPart;
import javax.xml.soap.Detail;
import javax.xml.soap.DetailEntry;
import javax.xml.soap.MimeHeader;
import javax.xml.soap.MimeHeaders;
import javax.xml.soap.Name;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPFault;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

import org.w3c.dom.Document;

public class AmmitHandler implements SOAPHandler<SOAPMessageContext> {

	@SuppressWarnings({ "unused", "rawtypes" })
	@Override
	public boolean handleMessage(SOAPMessageContext context) {

		c("context : ");

		if (context == null) {
			cln("not found");
			return true;
		} else {
			cln("found");

			// doRoles(context);

			SOAPMessage soapMessage = context.getMessage();

			c("context/message : ");
			if (soapMessage == null) {
				cln("not found");
			} else {

				cln("found");

				// doAttachments(soapMessage);
				// doContentDescription(soapMessage);
				// doMimeHeaders(soapMessage);

			}

			if (System.currentTimeMillis() > 0) {
				return true;
			}

			try {
				SOAPBody body = soapMessage.getSOAPBody();
				Document doc = body.extractContentAsDocument();
				if (body.hasFault()) {
					SOAPFault fault = body.getFault();
					Detail d = fault.getDetail();
					Iterator entries = d.getDetailEntries();
					while (entries.hasNext()) {
						DetailEntry entry = (DetailEntry) entries.next();
						entry.getClass();

					}
					fault.getFaultActor();
					fault.getFaultCode();
					Name fn = fault.getFaultCodeAsName();
					QName fqn = fault.getFaultCodeAsQName();
					fault.getFaultNode();
					Iterator frloc = fault.getFaultReasonLocales();
					while (frloc.hasNext()) {
						Locale frl = (Locale) frloc.next();
					}
					Iterator texts = fault.getFaultReasonTexts();
					while (texts.hasNext()) {
						String text = (String) texts.next();

					}
					fault.getFaultRole();
					fault.getFaultString();
					fault.getFaultStringLocale();
					Iterator sc = fault.getFaultSubcodes();
					while (sc.hasNext()) {
						QName scode = (QName) sc.next();
					}
					fault.hasDetail();

				}
			} catch (SOAPException e) {
				e.printStackTrace();
			}
			try {
				SOAPHeader shear = soapMessage.getSOAPHeader();
				Iterator headerments = shear.extractAllHeaderElements();
				while (headerments.hasNext()) {
					Object heament = headerments.next();
					heament.getClass();
				}
			} catch (SOAPException e) {
				e.printStackTrace();
			}
			soapMessage.getSOAPPart();

			return true;
		}
	}

	private void doMimeHeaders(SOAPMessage soapMessage) {
		MimeHeaders mimeHeaders = soapMessage.getMimeHeaders();
		c("context/message/mimeHeaders : ");
		if (mimeHeaders == null) {
			cln("not found");
		} else {
			cln("found");
			@SuppressWarnings("rawtypes")
			Iterator mimeHeadersIt = mimeHeaders.getAllHeaders();
			c("context/message/mimeHeaders/iterator : ");
			if (mimeHeadersIt == null) {
				cln("not found");
			} else {
				cln("found");
				int c = 0;
				while (mimeHeadersIt.hasNext()) {
					MimeHeader header = (MimeHeader) mimeHeadersIt.next();
					c("context/message/mimeHeaders/iterator/" + c + " : ");
					if (header == null) {
						cln("not found");
					} else {
						cln("found");
						String name = header.getName();
						String value = header.getValue();
						c("context/message/mimeHeaders/iterator/" + c + "/name : ");
						if (name == null) {
							cln("not found");
						} else {
							cln("found");
							cln(" >> " + name);
						}
						c("context/message/mimeHeaders/iterator/" + c + "/value : ");
						if (value == null) {
							cln("not found");
						} else {
							cln("found");
							cln(" >> " + value);
						}

					}
					++c;
				}
			}
		}
	}

	private void doContentDescription(SOAPMessage soapMessage) {
		String desc = soapMessage.getContentDescription();
		c("context/message/contentDescription : ");
		if (desc == null) {
			cln("not found");
		} else {
			cln("found");
			cln(" >> " + desc);
		}
	}

	private void doAttachments(SOAPMessage soapMessage) {
		int nAttachments = soapMessage.countAttachments();
		c("context/message/attachments : ");
		cln("found " + nAttachments);
		if (nAttachments > 0) {
			if (System.currentTimeMillis() > 0) {
				return;
			}
			Iterator attachements = soapMessage.getAttachments();
			while (attachements.hasNext()) {
				AttachmentPart a = (AttachmentPart) attachements.next();
				Iterator headers = a.getAllMimeHeaders();
				try {
					InputStream c = a.getBase64Content();
				} catch (SOAPException e) {
					e.printStackTrace();
				}
				try {
					Object o = a.getContent();
				} catch (SOAPException e) {
					e.printStackTrace();
				}
				String id = a.getContentId();
				String l = a.getContentLocation();
				String t = a.getContentType();
				try {
					DataHandler handler = a.getDataHandler();
					CommandInfo[] comands = handler.getAllCommands();
					for (CommandInfo com : comands) {
						String clazz = com.getCommandClass();
						String name = com.getCommandName();
					}
					try {
						handler.getContent();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					handler.getContentType();
					handler.getDataSource();
					try {
						handler.getInputStream();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					handler.getName();
					try {
						handler.getOutputStream();
					} catch (IOException e) {
						e.printStackTrace();
					}
					handler.getPreferredCommands();
					DataFlavor[] flavors = handler.getTransferDataFlavors();
					for (DataFlavor flavor : flavors) {
						Class<?> drc = flavor.getDefaultRepresentationClass();
						String drcs = flavor.getDefaultRepresentationClassAsString();
						String hpn = flavor.getHumanPresentableName();
						String fmt = flavor.getMimeType();
						String fpt = flavor.getPrimaryType();
						Class<?> frc = flavor.getRepresentationClass();
						String fst = flavor.getSubType();
						boolean fjflt = flavor.isFlavorJavaFileListType();
						boolean frot = flavor.isFlavorRemoteObjectType();
						boolean fsot = flavor.isFlavorSerializedObjectType();
						boolean ftt = flavor.isFlavorTextType();
						boolean mtso = flavor.isMimeTypeSerializedObject();
						boolean rcbb = flavor.isRepresentationClassByteBuffer();
						boolean rccb = flavor.isRepresentationClassCharBuffer();
						boolean rcis = flavor.isRepresentationClassInputStream();
						boolean rcrr = flavor.isRepresentationClassReader();
						boolean rcre = flavor.isRepresentationClassRemote();
						boolean rcs = flavor.isRepresentationClassSerializable();
						try {
							Object td = handler.getTransferData(flavor);
							td.getClass();

						} catch (UnsupportedFlavorException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					}

				} catch (SOAPException e) {
					e.printStackTrace();
				}
				try {
					InputStream rc = a.getRawContent();
				} catch (SOAPException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					byte[] bytes = a.getRawContentBytes();
				} catch (SOAPException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					int sz = a.getSize();
				} catch (SOAPException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}

	}

	private void doRoles(SOAPMessageContext context) {

		Set<String> roles = context.getRoles();

		c("context/roles : ");
		if (roles == null) {
			cln("not found");
		} else {
			cln("found " + roles.size());
			int c = 0;
			for (String role : roles) {
				c("context/roles/" + c + " : ");
				cln(role);
				++c;
			}
		}

	}

	private void cln(String str) {
		c(str + "\n");

	}

	private void c(String str) {
		for (int i = 0; i < str.length(); ++i) {
			System.out.print(str.charAt(i));
			sleep(50);
		}
		sleep(300);
	}

	private void sleep(int i) {
		try {
			Thread.sleep(i);
		} catch (InterruptedException e) {
		}

	}

	@Override
	public boolean handleFault(SOAPMessageContext context) {
		return true;
	}

	@Override
	public void close(MessageContext context) {
	}

	@Override
	public Set<QName> getHeaders() {
		return new HashSet<>();
	}

}
