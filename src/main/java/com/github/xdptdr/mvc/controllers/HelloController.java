package com.github.xdptdr.mvc.controllers;

import java.io.FileNotFoundException;

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

	@RequestMapping(value = "/helloException1", method = RequestMethod.GET)
	public ModelAndView helloException1() {
		throw new NullPointerException();
	}

	@RequestMapping(value = "/helloException2", method = RequestMethod.GET)
	public ModelAndView helloException2() throws FileNotFoundException {
		throw new FileNotFoundException();
	}
}
