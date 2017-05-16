package com.github.xdptdr.jca;

import java.util.List;

import javax.resource.spi.work.WorkContext;
import javax.resource.spi.work.WorkContextProvider;

public class MyWorkContextProvider implements WorkContextProvider {

	private static final long serialVersionUID = 1L;

	@Override
	public List<WorkContext> getWorkContexts() {
		return null;
	}

}
