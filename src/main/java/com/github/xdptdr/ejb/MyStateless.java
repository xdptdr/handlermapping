package com.github.xdptdr.ejb;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;

@Stateless
public class MyStateless {

	@Resource
	SessionContext sessionContext;

	public String choupinette(String x) {
		if (x == null) {
			return null;
		}
		return x + " " + x;
	}
}
