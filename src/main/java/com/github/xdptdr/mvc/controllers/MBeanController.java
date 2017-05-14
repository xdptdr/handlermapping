package com.github.xdptdr.mvc.controllers;

import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.xdptdr.jmx.ManagedColor;

@Controller
public class MBeanController {

	@Autowired
	ApplicationContext applicationContext;

	@RequestMapping(value = "/colorHits", method = RequestMethod.GET)
	@ResponseBody
	public String showHits() {

		Map<String, ManagedColor> mcs = applicationContext.getBeansOfType(ManagedColor.class);

		StringBuffer buf = new StringBuffer();

		for (ManagedColor mc : mcs.values()) {
			buf.append(mc.getColor());
			buf.append(" : ");
			buf.append(mc.getHits());
		}
		
		return buf.toString();
	}
}
