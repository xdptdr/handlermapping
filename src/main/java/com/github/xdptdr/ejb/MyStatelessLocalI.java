package com.github.xdptdr.ejb;

import java.util.List;
import java.util.concurrent.Future;

import javax.ejb.Asynchronous;
import javax.ejb.Lock;
import javax.ejb.LockType;

public interface MyStatelessLocalI {
	public String computeLocal(String x);

	@Asynchronous
	public Future<String> computeAsyncLocal(String x);

	@Lock(LockType.READ)
	public String computeReadLocal(String x);

	@Lock(LockType.READ)
	public String computeReadAccessPrivateWrite(String x);

	@Lock(LockType.WRITE)
	public String computeWriteLocal(String x);

	public List<String> getLogs();
	
	public void foo();

}
