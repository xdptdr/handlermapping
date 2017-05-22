package com.github.xdptdr.ejb;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;

@Stateless
public class MyStateless {
	@Resource
	SessionContext sessionContext;
}
