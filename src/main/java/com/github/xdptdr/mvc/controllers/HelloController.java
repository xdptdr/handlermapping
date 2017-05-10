package com.github.xdptdr.mvc.controllers;

import javax.xml.parsers.ParserConfigurationException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

	@RequestMapping(value = "/helloCNVR", method = RequestMethod.GET)
	public ModelAndView helloCNVRJSON() throws ParserConfigurationException {
		ModelAndView mav = new ModelAndView("helloCNVR");
		return mav;
	}

}
