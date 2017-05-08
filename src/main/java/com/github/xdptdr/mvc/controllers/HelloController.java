package com.github.xdptdr.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloController {

	@RequestMapping(value = "/helloFreemarker", method = RequestMethod.GET)
	public String helloFreemarker() {
		return "helloFreemarker";
	}

	@RequestMapping(value = "/helloGroovy", method = RequestMethod.GET)
	public String helloGroovy() {
		return "helloGroovy.tpl";
	}
	
	@RequestMapping(value = "/helloJasper", method = RequestMethod.GET)
	public String helloJasper() {
		return "helloJasper";
	}
}
