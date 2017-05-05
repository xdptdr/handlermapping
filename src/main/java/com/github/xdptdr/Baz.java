package com.github.xdptdr;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

public class Baz {
	@RequestMapping("/baz")
	@ResponseBody
	public String baz() {
		return "Hello from baz !!!";

	}

}
