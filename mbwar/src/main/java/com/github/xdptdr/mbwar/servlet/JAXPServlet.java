package com.github.xdptdr.mbwar.servlet;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class JAXPServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			if (req == null) {
				doStuff(req, resp);
			}
		} catch (ParserConfigurationException | SAXException | TransformerConfigurationException
				| DatatypeConfigurationException e) {
			resp.getWriter().println(e.getMessage());
		}
	}

	private void doStuff(HttpServletRequest req, HttpServletResponse resp) throws ParserConfigurationException,
			SAXException, IOException, TransformerConfigurationException, DatatypeConfigurationException {

		// SAX
		SAXParserFactory parserFactory = SAXParserFactory.newInstance();
		SAXParser parser = parserFactory.newSAXParser();
		String xmlString = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><root></root>";
		parser.parse(new ByteArrayInputStream(xmlString.getBytes()), new MySAXHandler());

		// DOM
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
		Document document = documentBuilder.newDocument();

		// XSLT
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();

		// XPath
		XPathFactory xPathFactory = XPathFactory.newInstance();
		XPath xpath = xPathFactory.newXPath();

		// XML-Schema
		SchemaFactory schemaFactory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
		Schema s = schemaFactory.newSchema();
		Validator v = s.newValidator();
		Source source = null;
		v.validate(source);

		// Data types
		DatatypeFactory datatypeFactory = DatatypeFactory.newInstance();
	}
}
