package com.github.xdptdr.jca;

import javax.resource.spi.TransactionSupport;

public class MyTransactionSupport implements TransactionSupport {

	private static final long serialVersionUID = 1L;

	@Override
	public TransactionSupportLevel getTransactionSupport() {
		return null;
	}

}
