package com.github.xdptdr.ejb;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Singleton;

@Singleton
public class MySingleton {
	@Resource
	SessionContext sessionContext;
	
}
