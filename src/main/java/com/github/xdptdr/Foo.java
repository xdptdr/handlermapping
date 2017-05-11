package com.github.xdptdr;

import org.springframework.web.servlet.view.BeanNameViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.ViewResolverComposite;
import org.springframework.web.servlet.view.XmlViewResolver;
import org.springframework.web.servlet.view.script.ScriptTemplateViewResolver;

public class Foo {
	public void foo() {

		InternalResourceViewResolver.class.getName();
		ScriptTemplateViewResolver.class.getName();

		XmlViewResolver.class.getName();
		BeanNameViewResolver.class.getName();
		ViewResolverComposite.class.getName();

	}
}
