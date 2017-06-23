package com.github.xdptdr.notes.jee.xslt;

import javax.xml.transform.ErrorListener;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.SourceLocator;
import javax.xml.transform.Templates;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.URIResolver;
import javax.xml.transform.dom.DOMLocator;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.sax.SAXSource;
import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.transform.sax.TemplatesHandler;
import javax.xml.transform.sax.TransformerHandler;
import javax.xml.transform.stax.StAXResult;
import javax.xml.transform.stax.StAXSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import com.github.xdptdr.notes.N;

public class Notes {

	private static void notes(N n) {

		n.todo(ErrorListener.class);
		n.todo(OutputKeys.class);
		n.todo(Result.class);
		n.todo(Source.class);
		n.todo(SourceLocator.class);
		n.todo(Templates.class);
		n.todo(Transformer.class);
		n.todo(TransformerConfigurationException.class);
		n.todo(TransformerException.class);
		n.todo(TransformerFactory.class);
		n.todo(TransformerFactoryConfigurationError.class);
		n.todo(URIResolver.class);

		n.todo(DOMLocator.class);
		n.todo(DOMResult.class);
		n.todo(DOMSource.class);

		n.todo(SAXResult.class);
		n.todo(SAXSource.class);
		n.todo(SAXTransformerFactory.class);
		n.todo(TemplatesHandler.class);
		n.todo(TransformerHandler.class);

		n.todo(StAXResult.class);
		n.todo(StAXSource.class);

		n.todo(StreamResult.class);
		n.todo(StreamSource.class);
	}

	public static void main(String[] args) {
		N n = new N();
		notes(n);
		n.sumUp();
	}

}
