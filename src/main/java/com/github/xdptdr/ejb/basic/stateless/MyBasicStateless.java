package com.github.xdptdr.ejb.basic.stateless;

import javax.annotation.Resource;
import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;

import com.github.xdptdr.utils.ThreadUtils;

@Stateless
@Local(MyBasicStatelessLocalI.class)
@Remote(MyBasicStatelessRemoteI.class)
@LocalBean
public class MyBasicStateless implements MyBasicStatelessLocalI, MyBasicStatelessRemoteI {

	@Resource
	private SessionContext sessionContext;

	private int counter;

	@Override
	public void remoteIncrement() {
		++counter;
		ThreadUtils.sleep();
	}

	@Override
	public int getRemoteCounter() {
		return counter;
	}

	@Override
	public void localIncrement() {
		++counter;
		ThreadUtils.sleep();
	}

	@Override
	public int getLocalCounter() {
		return counter;
	}

	public void noViewIncrement() {
		++counter;
		ThreadUtils.sleep();
	}

	public int getNoViewCounter() {
		return counter;
	}

}
