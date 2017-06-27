package com.github.xdptdr.mbjaxrs.a.zyx;

public class ZyxContextImpl implements ZyxContext {

	@Override
	public String zyxIt() {
		return "Hello from " + this.getClass().getName();
	}

}
