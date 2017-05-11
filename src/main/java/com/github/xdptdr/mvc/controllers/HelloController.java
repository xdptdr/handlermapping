package com.github.xdptdr.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

	@RequestMapping(value = "/hellourl", method = RequestMethod.GET)
	public ModelAndView hellourl() {
		ModelAndView mav = new ModelAndView("hellourl");
		return mav;
	}
	
	@RequestMapping(value = "/hellourlRedirect", method = RequestMethod.GET)
	public ModelAndView hellourlRedirect() {
		ModelAndView mav = new ModelAndView("redirect:hellourl");
		return mav;
	}
	
	@RequestMapping(value = "/hellourlForward", method = RequestMethod.GET)
	public ModelAndView hellourlForward() {
		ModelAndView mav = new ModelAndView("forward:hellourl");
		return mav;
	}
}
