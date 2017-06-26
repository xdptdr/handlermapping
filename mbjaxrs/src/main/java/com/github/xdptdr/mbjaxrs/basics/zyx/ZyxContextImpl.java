package com.github.xdptdr.mbjaxrs.basics.zyx;

public class ZyxContextImpl implements ZyxContext {

	@Override
	public String zyxIt() {
		return "Hello from " + this.getClass().getName();
	}

}
