package com.github.xdptdr.jca;

import java.util.Set;

import javax.resource.ResourceException;
import javax.resource.spi.ValidatingManagedConnectionFactory;

public class MyValidatingManagedConnectionFactory implements ValidatingManagedConnectionFactory {

	@SuppressWarnings("rawtypes")
	@Override
	public Set getInvalidConnections(Set connectionSet) throws ResourceException {
		return null;
	}

}
