package com.github.xdptdr.jca;

import javax.resource.spi.work.ExecutionContext;
import javax.resource.spi.work.Work;
import javax.resource.spi.work.WorkException;
import javax.resource.spi.work.WorkListener;
import javax.resource.spi.work.WorkManager;

public class MyWorkManager implements WorkManager {

	@Override
	public void doWork(Work work) throws WorkException {

	}

	@Override
	public void doWork(Work work, long startTimeout, ExecutionContext execContext, WorkListener workListener)
			throws WorkException {

	}

	@Override
	public long startWork(Work work) throws WorkException {
		return 0;
	}

	@Override
	public long startWork(Work work, long startTimeout, ExecutionContext execContext, WorkListener workListener)
			throws WorkException {
		return 0;
	}

	@Override
	public void scheduleWork(Work work) throws WorkException {

	}

	@Override
	public void scheduleWork(Work work, long startTimeout, ExecutionContext execContext, WorkListener workListener)
			throws WorkException {

	}

}
