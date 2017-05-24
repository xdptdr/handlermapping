package com.github.xdptdr.ejb.basic.stateful;

import javax.annotation.Resource;
import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.SessionContext;
import javax.ejb.Stateful;

@Stateful
@Local(MyBasicStatefulLocalI.class)
@Remote(MyBasicStatefulRemoteI.class)
@LocalBean
public class MyBasicStateful implements MyBasicStatefulLocalI, MyBasicStatefulRemoteI {
	@Resource
	SessionContext sessionContext;
}
