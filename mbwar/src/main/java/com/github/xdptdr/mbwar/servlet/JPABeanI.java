package com.github.xdptdr.mbwar.servlet;

import java.util.Collection;

public interface JPABeanI {

	void create();
	Collection<MyEntity> getAll();

}
