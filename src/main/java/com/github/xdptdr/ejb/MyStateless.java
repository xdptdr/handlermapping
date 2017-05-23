package com.github.xdptdr.ejb;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.ejb.AccessTimeout;
import javax.ejb.AfterBegin;
import javax.ejb.AfterCompletion;
import javax.ejb.AsyncResult;
import javax.ejb.BeforeCompletion;
import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.Local;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.PostActivate;
import javax.ejb.PrePassivate;
import javax.ejb.Remote;
import javax.ejb.Remove;
import javax.ejb.Schedule;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

@Stateless
@Local(MyStatelessLocalI.class)
@Remote(MyStatelessRemoteI.class)
@AccessTimeout(value = 1, unit = TimeUnit.NANOSECONDS)
@ConcurrencyManagement(ConcurrencyManagementType.CONTAINER)
@TransactionManagement(TransactionManagementType.CONTAINER)
// @RunAs("toto")
public class MyStateless implements MyStatelessLocalI, MyStatelessRemoteI {

	@Resource
	SessionContext sessionContext;

	private List<String> logs = new ArrayList<>();

	private String compute(String x) {
		if (x == null) {
			return null;
		}
		return x + " " + x;
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public String computeRemote(String x) {
		sessionContext.setRollbackOnly();
		return compute(x);
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public String computeLocal(String x) {
		sessionContext.setRollbackOnly();
		return compute(x);
	}

	@PostConstruct
	private void postconstruct() {
		Timer timer = sessionContext.getTimerService().createTimer(1, 1, null);
		logs.add("postconstruct");
	}

	@AfterBegin
	private void afterbegin() {
		logs.add("afterbegin");
	}

	@BeforeCompletion
	private void beforecompletion() {
		logs.add("beforecompletion");
	}

	@AfterCompletion
	private void aftercompletion(boolean committed) {
		logs.add("aftercompletion" + committed);
	}

	@PreDestroy
	private void predestroy() {
		logs.add("predestroy");
	}

	@PrePassivate
	private void passivate() {
		logs.add("passivate");
	}

	@PostActivate
	private void activate() {
		logs.add("activate");
	}

	@Remove
	public void remove() {
		logs.add("removed");
	}

	@Override
	public Future<String> computeAsyncLocal(String x) {
		return new AsyncResult<String>(compute(x));
	}

	@Override
	public String computeReadLocal(String x) {
		return compute(x);
	}

	@Lock(LockType.WRITE)
	@AccessTimeout(value = 1, unit = TimeUnit.NANOSECONDS)
	private String computePrivateWrite(String x) {
		return compute(x);
	}

	@Override
	@Lock(LockType.READ)
	@AccessTimeout(value = 1, unit = TimeUnit.NANOSECONDS)
	public String computeReadAccessPrivateWrite(String x) {
		System.out.println(x);
		return computePrivateWrite(x);
	}

	@Override
	public String computeWriteLocal(String x) {
		return compute(x);
	}

	@Override
	public List<String> getLogs() {
		return Collections.unmodifiableList(logs);
	}

	@Timeout
	public void foo() {
		System.out.println("Foo !");
	}

}
