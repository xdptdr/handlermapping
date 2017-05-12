package com.github.xdptdr.mvc.controllers;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public ModelAndView helloInternal() {
		ModelAndView mav = new ModelAndView("hello");
		return mav;
	}

	@RequestMapping(value = "/foo/hello/bar", method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
	@ResponseBody
	public String fooHelloInternalBar() {
		return "Hello from internal";
	}
}
