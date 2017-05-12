package com.github.xdptdr.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

	@RequestMapping(value = "/hello1", method = RequestMethod.GET)
	public ModelAndView hello1() {
		ModelAndView mav = new ModelAndView("dummy1");
		return mav;
	}

	@RequestMapping(value = "/hello2", method = RequestMethod.GET)
	public ModelAndView hello2() {
		ModelAndView mav = new ModelAndView("dummy2");
		return mav;
	}
}
