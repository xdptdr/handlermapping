package com.github.xdptdr.ejb.basic.stateless;

import javax.annotation.Resource;
import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;

@Stateless
@Local(MyBasicStatelessLocalI.class)
@Remote(MyBasicStatelessRemoteI.class)
@LocalBean
public class MyBasicStateless implements MyBasicStatelessLocalI, MyBasicStatelessRemoteI {

	@Resource
	SessionContext sessionContext;


	

}
