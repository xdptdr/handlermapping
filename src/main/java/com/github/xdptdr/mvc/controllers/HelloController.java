package com.github.xdptdr.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public ModelAndView hello() {
		ModelAndView mav = new ModelAndView("hello");
		return mav;
	}
	
	@RequestMapping(value = "/helloException", method = RequestMethod.GET)
	public ModelAndView helloException() {
		throw new NullPointerException();
	}
}
