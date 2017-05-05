package com.github.xdptdr.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.handler.BeanNameUrlHandlerMapping;
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;
import org.springframework.web.servlet.mvc.annotation.DefaultAnnotationHandlerMapping;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import org.springframework.web.servlet.mvc.support.ControllerBeanNameHandlerMapping;
import org.springframework.web.servlet.mvc.support.ControllerClassNameHandlerMapping;

@Controller
public class HelloController {

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	@ResponseBody
	public String foo() {
		BeanNameUrlHandlerMapping.class.getName();
		SimpleUrlHandlerMapping.class.getName();
		ControllerClassNameHandlerMapping.class.getName();
		RequestMappingHandlerMapping.class.getName();
		ControllerBeanNameHandlerMapping.class.getName();
		DefaultAnnotationHandlerMapping.class.getName();
		
		return "hello";
	}

}
