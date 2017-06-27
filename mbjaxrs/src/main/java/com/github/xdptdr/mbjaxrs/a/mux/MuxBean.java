package com.github.xdptdr.mbjaxrs.a.mux;

import javax.ws.rs.QueryParam;

public class MuxBean {

	@QueryParam("p")
	private String param;

	public MuxBean() {
	}

	public String getParam() {
		return param;
	}

	public void setParam(String param) {
		this.param = param;
	}

}
