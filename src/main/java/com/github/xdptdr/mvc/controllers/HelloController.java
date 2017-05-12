package com.github.xdptdr.mvc.controllers;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.github.xdptdr.jasper.JasperPerson;

@Controller
public class HelloController {

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public ModelAndView hello() {
		ModelAndView mav = new ModelAndView("hellojasper");

		Collection<JasperPerson> data = Arrays.asList(new JasperPerson[] {

				new JasperPerson("foo", "fiFou"),

				new JasperPerson("bar", "fiBar")

		});

		mav.getModel().put("jasperData", data);
		return mav;
	}

	
}
