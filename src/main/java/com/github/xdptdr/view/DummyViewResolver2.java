package com.github.xdptdr.view;

import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

public class DummyViewResolver2 implements ViewResolver {

	@Override
	public View resolveViewName(String viewName, Locale locale) throws Exception {
		if ("dummy2".equals(viewName)) {
			return new View() {

				@Override
				public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response)
						throws Exception {
					response.getWriter().println("Hello from " + DummyViewResolver2.class.getName());
				}

				@Override
				public String getContentType() {
					return "text/plain";
				}
			};
		}
		return null;
	}

}
