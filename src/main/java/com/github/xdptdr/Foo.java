package com.github.xdptdr;

import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.BeanNameViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.ResourceBundleViewResolver;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.ViewResolverComposite;
import org.springframework.web.servlet.view.XmlViewResolver;
import org.springframework.web.servlet.view.groovy.GroovyMarkupViewResolver;
import org.springframework.web.servlet.view.jasperreports.JasperReportsViewResolver;
import org.springframework.web.servlet.view.script.ScriptTemplateViewResolver;

public class Foo {
	public void foo() {

		GroovyMarkupViewResolver.class.getName();

		JasperReportsViewResolver.class.getName();

		ViewResolver.class.getName();
		ResourceBundleViewResolver.class.getName();
		UrlBasedViewResolver.class.getName();
		InternalResourceViewResolver.class.getName();
		ScriptTemplateViewResolver.class.getName();

		XmlViewResolver.class.getName();
		BeanNameViewResolver.class.getName();
		ViewResolverComposite.class.getName();

	}
}
