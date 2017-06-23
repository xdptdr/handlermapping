package com.github.xdptdr.notes.sax;

import org.xml.sax.AttributeList;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.DTDHandler;
import org.xml.sax.DocumentHandler;
import org.xml.sax.EntityResolver;
import org.xml.sax.ErrorHandler;
import org.xml.sax.HandlerBase;
import org.xml.sax.InputSource;
import org.xml.sax.Locator;
import org.xml.sax.Parser;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.SAXNotSupportedException;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLFilter;
import org.xml.sax.XMLReader;
import org.xml.sax.ext.Attributes2;
import org.xml.sax.ext.Attributes2Impl;
import org.xml.sax.ext.DeclHandler;
import org.xml.sax.ext.DefaultHandler2;
import org.xml.sax.ext.EntityResolver2;
import org.xml.sax.ext.LexicalHandler;
import org.xml.sax.ext.Locator2;
import org.xml.sax.ext.Locator2Impl;
import org.xml.sax.helpers.AttributeListImpl;
import org.xml.sax.helpers.AttributesImpl;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.LocatorImpl;
import org.xml.sax.helpers.NamespaceSupport;
import org.xml.sax.helpers.ParserAdapter;
import org.xml.sax.helpers.ParserFactory;
import org.xml.sax.helpers.XMLFilterImpl;
import org.xml.sax.helpers.XMLReaderAdapter;
import org.xml.sax.helpers.XMLReaderFactory;

import com.github.xdptdr.notes.N;

@SuppressWarnings("deprecation")
public class Notes {
	public static void notes(N n) {

		n.todo(AttributeList.class);
		n.todo(Attributes.class);
		n.todo(ContentHandler.class);
		n.todo(DocumentHandler.class);
		n.todo(DTDHandler.class);
		n.todo(EntityResolver.class);
		n.todo(ErrorHandler.class);
		n.todo(HandlerBase.class);
		n.todo(InputSource.class);
		n.todo(Locator.class);
		n.todo(Parser.class);
		n.todo(SAXException.class);
		n.todo(SAXNotRecognizedException.class);
		n.todo(SAXNotSupportedException.class);
		n.todo(SAXParseException.class);
		n.todo(XMLFilter.class);
		n.todo(XMLReader.class);

		n.todo(Attributes2.class);
		n.todo(Attributes2Impl.class);
		n.todo(DeclHandler.class);
		n.todo(DefaultHandler2.class);
		n.todo(EntityResolver2.class);
		n.todo(LexicalHandler.class);
		n.todo(Locator2.class);
		n.todo(Locator2Impl.class);

		n.todo(AttributeListImpl.class);
		n.todo(AttributesImpl.class);
		n.todo(DefaultHandler.class);
		n.todo(LocatorImpl.class);
		n.todo(NamespaceSupport.class);
		n.todo(ParserAdapter.class);
		n.todo(ParserFactory.class);
		n.todo(XMLFilterImpl.class);
		n.todo(XMLReaderAdapter.class);
		n.todo(XMLReaderFactory.class);

	}

	public static void main(String[] args) {
		N n = new N();
		notes(n);
		n.sumUp();
	}
}
