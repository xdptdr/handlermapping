package com.github.xdptdr.springweb;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.View;

public class DummyView implements View {

	private boolean isException;

	public DummyView(boolean isException) {
		this.isException = isException;
	}

	@Override
	public String getContentType() {
		return "text/plain";
	}

	@Override
	public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		response.getWriter().println("Hello from " + this.getClass().getName());
		if (isException) {
			response.getWriter().println("An exception occured");
		}

	}

}
