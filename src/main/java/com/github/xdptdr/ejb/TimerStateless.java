package com.github.xdptdr.ejb;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.Timeout;

@Stateless
public class TimerStateless {

	@Resource
	private SessionContext sessionContext;
	private int counter;

	@PostConstruct
	private void postconstruct() {
		// can invoke timers here
		// sessionContext.getTimerService().createTimer(1000, 1000, null);
	}
	
	public void createTimer() {
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
