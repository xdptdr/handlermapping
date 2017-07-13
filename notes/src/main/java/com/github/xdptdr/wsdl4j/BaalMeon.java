package com.github.xdptdr.wsdl4j;

import java.util.HashMap;
import java.util.Map;

import javax.wsdl.Definition;
import javax.wsdl.WSDLException;
import javax.wsdl.factory.WSDLFactory;
import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import com.ibm.wsdl.util.xml.DOM2Writer;
import com.ibm.wsdl.util.xml.DOMUtils;
import com.ibm.wsdl.util.xml.QNameUtils;
import com.ibm.wsdl.util.xml.XPathUtils;

public class BaalMeon {

	private static void foo() throws WSDLException, ParserConfigurationException {

		String systemFileEncoding = System.getProperty("file.encoding");
		System.out.println("systemFileEncoding : " + systemFileEncoding);
		azzert("UTF-8".equals(DOM2Writer.java2XMLEncoding(null)));
		azzert("UTF-8".equals(DOM2Writer.java2XMLEncoding(systemFileEncoding)));
		azzert("UTF-8".equals(DOM2Writer.java2XMLEncoding("UTF8")));
		azzert("UTF-16".equals(DOM2Writer.java2XMLEncoding("UTF-16")));
		azzert("UTF-16".equals(DOM2Writer.java2XMLEncoding("UnicodeBig")));
		azzert("UTF-16".equals(DOM2Writer.java2XMLEncoding("UnicodeLittle")));
		azzert("US-ASCII".equals(DOM2Writer.java2XMLEncoding("ASCII")));
		azzert("ISO-8859-1".equals(DOM2Writer.java2XMLEncoding("ISO8859_1")));
		azzert("ISO-8859-2".equals(DOM2Writer.java2XMLEncoding("ISO8859_2")));
		azzert("ISO-8859-3".equals(DOM2Writer.java2XMLEncoding("ISO8859_3")));
		azzert("ISO-8859-4".equals(DOM2Writer.java2XMLEncoding("ISO8859_4")));
		azzert("ISO-8859-5".equals(DOM2Writer.java2XMLEncoding("ISO8859_5")));
		azzert("ISO-8859-6".equals(DOM2Writer.java2XMLEncoding("ISO8859_6")));
		azzert("ISO-8859-7".equals(DOM2Writer.java2XMLEncoding("ISO8859_7")));
		azzert("ISO-8859-8".equals(DOM2Writer.java2XMLEncoding("ISO8859_8")));
		azzert("ISO-8859-9".equals(DOM2Writer.java2XMLEncoding("ISO8859_9")));
		azzert("ISO-8859-13".equals(DOM2Writer.java2XMLEncoding("ISO8859_13")));
		azzert("ISO-8859-15".equals(DOM2Writer.java2XMLEncoding("ISO8859_15_FDIS")));
		azzert("GBK".equals(DOM2Writer.java2XMLEncoding("GBK")));
		azzert("Big5".equals(DOM2Writer.java2XMLEncoding("Big5")));

		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document d = db.newDocument();
		Element div = d.createElementNS("http://toto", "toto:div");

		Node node = div;
		String nodeString = DOM2Writer.nodeToString(node);
		System.out.println(nodeString);

		Map<String, String> namespaces = new HashMap<>();
		namespaces.put("toto", "http://toto");
		nodeString = DOM2Writer.nodeToString(node, namespaces);
		System.out.println(nodeString);

		// Writer writer = null;
		// DOM2Writer.serializeAsXML(node, writer);
		// DOM2Writer.serializeAsXML(node, namespaces, writer);
		// Element el = null;
		// DOM2Writer.serializeElementAsDocument(el, writer);
		// DOM2Writer.serializeElementAsDocument(el, namespaces, writer);
		//
		// String orig = null;
		// DOMUtils.cleanString(orig);
		// Element elem = null;
		// short nodeType = 0;
		// DOMUtils.countKids(elem, nodeType);
		// String attrName = null;
		// String attrValue = null;
		// DOMUtils.findChildElementWithAttribute(elem, attrName, attrValue);
		// DOMUtils.getAttribute(el, attrName);
		// @SuppressWarnings("rawtypes")
		// List remainingAttrs = null;
		// DOMUtils.getAttribute(el, attrName, remainingAttrs);
		// String namespaceURI = null;
		// String localPart = null;
		// DOMUtils.getAttributeNS(el, namespaceURI, localPart);
		// DOMUtils.getAttributes(el);
		// Element parentEl = null;
		// DOMUtils.getChildCharacterData(parentEl);
		// DOMUtils.getFirstChildElement(elem);
		// Node context = null;
		// String prefix = null;
		// DOMUtils.getNamespaceURIFromPrefix(context, prefix);
		// DOMUtils.getNextSiblingElement(elem);
		// Definition def = null;
		// DOMUtils.getPrefix(namespaceURI, def);
		// String prefixedValue = null;
		// Element contextEl = null;
		// DOMUtils.getQName(prefixedValue, contextEl, def);
		// String elDesc = null;
		// boolean isRequired = false;
		// DOMUtils.getQualifiedAttributeValue(el, attrName, elDesc, isRequired,
		// def);
		// DOMUtils.getQualifiedAttributeValue(el, attrName, elDesc, isRequired,
		// def, remainingAttrs);
		// DOMUtils.getQualifiedValue(namespaceURI, localPart, def);
		// String name = null;
		// String value = null;
		// PrintWriter pw = null;
		// DOMUtils.printAttribute(name, value, pw);
		// QName valueQ = null;
		// QName nameQ = null;
		// DOMUtils.printQualifiedAttribute(nameQ, value, def, pw);
		// DOMUtils.printQualifiedAttribute(name, valueQ, def, pw);

		WSDLFactory factory = WSDLFactory.newInstance();
		Definition def = factory.newDefinition();
		DOMUtils.registerUniquePrefix("toto", "http://toto", def);
		azzert("http://toto".equals(def.getNamespace("toto")));
		DOMUtils.registerUniquePrefix("titi", "http://toto", def);
		azzert(null == def.getNamespace("titi"));

		QName qname = QNameUtils.newQName(node);
		System.out.println(qns(qname));
		qname = new QName("titi", "toto");
		boolean matches = QNameUtils.matches(qname, node);
		System.out.println(matches);

		String xpath = XPathUtils.getXPathExprFromNode(node);
		System.out.println(xpath);

		DOMUtils.throwWSDLException(div);
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

	private static void azzert(boolean b) {
		if (!b) {
			throw new RuntimeException("Assertion error");
		}

	}

	public static void main(String[] args) throws WSDLException, ParserConfigurationException {
		foo();
	}

}
