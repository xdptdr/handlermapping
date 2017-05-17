package com.github.xdptdr.jca;

import javax.transaction.xa.Xid;

public class MyXid implements Xid {

	@Override
	public int getFormatId() {
		return 0;
	}

	@Override
	public byte[] getGlobalTransactionId() {
		return new byte[]{};
	}

	@Override
	public byte[] getBranchQualifier() {
		return new byte[]{};
	}

}
