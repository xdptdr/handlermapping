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

	@RequestMapping(value = "/helloRedirect", method = RequestMethod.GET)
	public ModelAndView helloRedirect() {
		ModelAndView mav = new ModelAndView("redirect:hello");
		return mav;
	}

	@RequestMapping(value = "/helloForward", method = RequestMethod.GET)
	public ModelAndView helloForward() {
		ModelAndView mav = new ModelAndView("forward:hello");
		return mav;
	}
}
