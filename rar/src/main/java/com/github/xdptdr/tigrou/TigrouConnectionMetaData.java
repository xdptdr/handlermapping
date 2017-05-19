package com.github.xdptdr.tigrou;

import javax.resource.ResourceException;

import com.github.xdptdr.jca.base.AbstractConnectionMetaData;

public class TigrouConnectionMetaData extends AbstractConnectionMetaData {

	@Override
	public String getEISProductName() throws ResourceException {
		return "tigrou";
	}

	@Override
	public String getEISProductVersion() throws ResourceException {
		return "1.0";
	}

}
