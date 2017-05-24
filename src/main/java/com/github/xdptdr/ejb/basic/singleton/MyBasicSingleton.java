package com.github.xdptdr.ejb.basic.singleton;

import javax.annotation.Resource;
import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.SessionContext;
import javax.ejb.Singleton;

@Singleton
@Local(MyBasicSingletonLocalI.class)
@Remote(MyBasicSingletonRemoteI.class)
@LocalBean
public class MyBasicSingleton implements MyBasicSingletonLocalI, MyBasicSingletonRemoteI {
	@Resource
	SessionContext sessionContext;
	
}
