package com.github.xdptdr.ejb;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Singleton;
import javax.ejb.Timeout;

@Singleton
public class TimerSingleton {

	@Resource
	private SessionContext sessionContext;
	private int counter;

	@PostConstruct
	private void postconstruct() {
		sessionContext.getTimerService().createTimer(1000, 1000, null);
	}

	@Timeout
	private void timeout() {
		++counter;
	}

	public int getCounter() {
		return counter;
	}
}
