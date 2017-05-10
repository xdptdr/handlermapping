package com.github.xdptdr.view;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.View;


public class DummyView1 implements View {

	@Override
	public String getContentType() {
		return "application/json";
	}

	@Override
	public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		response.getWriter().println("\"Hello from dummy view 1\"");
		
	}

}
