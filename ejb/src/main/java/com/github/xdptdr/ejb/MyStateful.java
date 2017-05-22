package com.github.xdptdr.ejb;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateful;

@Stateful
public class MyStateful {
	@Resource
	SessionContext sessionContext;
}
