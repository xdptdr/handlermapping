package com.github.xdptdr.mbjaxrs.a.wux;

import javax.ws.rs.ext.ParamConverter;

public class WuxParamConverter implements ParamConverter<WuxParam> {

	@Override
	public WuxParam fromString(String value) {
		return new WuxParam(value == null ? null : value.getBytes());
	}

	@Override
	public String toString(WuxParam value) {
		return new String(value.getBytes());
	}

}
