package com.github.xdptdr.mbwar.transaction.notes;

import javax.transaction.HeuristicCommitException;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.InvalidTransactionException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.Status;
import javax.transaction.Synchronization;
import javax.transaction.SystemException;
import javax.transaction.Transaction;
import javax.transaction.TransactionManager;
import javax.transaction.TransactionRequiredException;
import javax.transaction.TransactionRolledbackException;
import javax.transaction.TransactionScoped;
import javax.transaction.TransactionSynchronizationRegistry;
import javax.transaction.Transactional;
import javax.transaction.TransactionalException;
import javax.transaction.UserTransaction;
import javax.transaction.xa.XAException;
import javax.transaction.xa.XAResource;
import javax.transaction.xa.Xid;

import com.github.xdptdr.notes.N;

public class Notes {

	private static void notes(N n) {
		n.todo(HeuristicCommitException.class);
		n.todo(HeuristicMixedException.class);
		n.todo(HeuristicRollbackException.class);
		n.todo(InvalidTransactionException.class);
		n.todo(NotSupportedException.class);
		n.todo(RollbackException.class);
		n.todo(Status.class);
		n.todo(Synchronization.class);
		n.todo(SystemException.class);
		n.todo(Transaction.class);
		n.todo(Transactional.class);
		n.todo(TransactionalException.class);
		n.todo(TransactionManager.class);
		n.todo(TransactionRequiredException.class);
		n.todo(TransactionRolledbackException.class);
		n.todo(TransactionScoped.class);
		n.todo(TransactionSynchronizationRegistry.class);
		n.todo(UserTransaction.class);

		n.todo(XAException.class);
		n.todo(XAResource.class);
		n.todo(Xid.class);
	}

	public static void main(String[] args) {
		N n = new N();
		notes(n);
		n.sumUp();
	}

}
