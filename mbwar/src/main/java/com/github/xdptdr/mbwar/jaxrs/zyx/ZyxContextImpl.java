package com.github.xdptdr.mbwar.jaxrs.zyx;

public class ZyxContextImpl implements ZyxContext {

	@Override
	public String zyxIt() {
		return "Hello from " + this.getClass().getName();
	}

}
