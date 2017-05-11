package com.github.xdptdr.mvc.controllers;

import java.util.Arrays;
import java.util.Collection;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.github.xdptdr.jasper.JasperPerson;

@Controller
public class HelloController {

	@RequestMapping(value = "/hellojasper", method = RequestMethod.GET)
	public ModelAndView hellojasper() {
		ModelAndView mav = new ModelAndView("hellojasper");

		Collection<JasperPerson> data = Arrays.asList(new JasperPerson[] {

				new JasperPerson("foo", "fiFou"),

				new JasperPerson("bar", "fiBar")

		});

		mav.getModel().put("jasperData", data);
		return mav;
	}

	@RequestMapping(value = "/helloxslt", method = RequestMethod.GET)
	public ModelAndView helloxslt() throws ParserConfigurationException {
		ModelAndView mav = new ModelAndView("helloxslt");

		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.newDocument();
		Element root = doc.createElement("root");
		Element bouip1 = doc.createElement("bouip");
		Element bouip2 = doc.createElement("bouip");
		bouip1.appendChild(doc.createTextNode("bouip1"));
		bouip2.appendChild(doc.createTextNode("bouip2"));
		root.appendChild(bouip1);
		root.appendChild(bouip2);
		doc.appendChild(root);

		mav.getModel().put("xml", doc);
		return mav;
	}
}
