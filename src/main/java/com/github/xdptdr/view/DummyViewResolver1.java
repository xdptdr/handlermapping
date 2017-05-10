package com.github.xdptdr.view;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

public class DummyViewResolver1 implements ViewResolver, Ordered {

	@Autowired
	private DummyView1 dummyView1;
	
	private int order;

	@Override
	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	@Override
	public View resolveViewName(String viewName, Locale locale) throws Exception {
		return dummyView1;
	}

}
