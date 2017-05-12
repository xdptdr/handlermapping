package com.github.xdptdr;

import org.springframework.web.servlet.view.ViewResolverComposite;
import org.springframework.web.servlet.view.XmlViewResolver;
import org.springframework.web.servlet.view.script.ScriptTemplateViewResolver;

public class Foo {
	public void foo() {

		ScriptTemplateViewResolver.class.getName();

		XmlViewResolver.class.getName();
		ViewResolverComposite.class.getName();

	}
}
