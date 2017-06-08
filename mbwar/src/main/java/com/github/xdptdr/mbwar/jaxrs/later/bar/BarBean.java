package com.github.xdptdr.mbwar.jaxrs.later.bar;

public class BarBean {

	private String firstname;
	private String lastname;

	public BarBean() {
	}

	public BarBean(String firstname, String lastname) {
		this.firstname = firstname;
		this.lastname = lastname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

}
