package com.github.xdptdr.jca;

import javax.resource.spi.XATerminator;
import javax.transaction.xa.XAException;
import javax.transaction.xa.Xid;

public class MyXATerminator implements XATerminator {

	@Override
	public void commit(Xid xid, boolean onePhase) throws XAException {

	}

	@Override
	public void forget(Xid xid) throws XAException {

	}

	@Override
	public int prepare(Xid xid) throws XAException {
		return 0;
	}

	@Override
	public Xid[] recover(int flag) throws XAException {
		return new Xid[] { new MyXid() };
	}

	@Override
	public void rollback(Xid xid) throws XAException {

	}

}
