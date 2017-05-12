package com.github.xdptdr.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

	@RequestMapping(value = "/dummy1", method = RequestMethod.GET)
	public ModelAndView dummy1() {
		ModelAndView mav = new ModelAndView("dummy1");
		return mav;
	}

	@RequestMapping(value = "/dummy2", method = RequestMethod.GET)
	public ModelAndView dummy2() {
		ModelAndView mav = new ModelAndView("dummy2");
		return mav;
	}
}
