package com.github.xdptdr.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

	@RequestMapping(value = "/helloResourceBundle", method = RequestMethod.GET)
	public ModelAndView helloResourceBundle()  {
		ModelAndView mav = new ModelAndView("a");
		return mav;
	}
}
