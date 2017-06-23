package com.github.xdptdr.notes.jee.xpath;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathException;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import javax.xml.xpath.XPathFactoryConfigurationException;
import javax.xml.xpath.XPathFunction;
import javax.xml.xpath.XPathFunctionException;
import javax.xml.xpath.XPathFunctionResolver;
import javax.xml.xpath.XPathVariableResolver;

import com.github.xdptdr.notes.N;

public class Notes {

	private static void notes(N n) {

		n.todo(XPath.class);
		n.todo(XPathConstants.class);
		n.todo(XPathException.class);
		n.todo(XPathException.class);
		n.todo(XPathExpressionException.class);
		n.todo(XPathFactory.class);
		n.todo(XPathFactoryConfigurationException.class);
		n.todo(XPathFunction.class);
		n.todo(XPathFunctionException.class);
		n.todo(XPathFunctionResolver.class);
		n.todo(XPathVariableResolver.class);
		

	}

	public static void main(String[] args) {
		N n = new N();
		notes(n);
		n.sumUp();
	}

}
