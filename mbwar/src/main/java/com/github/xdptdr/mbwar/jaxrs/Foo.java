package com.github.xdptdr.mbwar.jaxrs;

public class Foo {

	private String firstName;
	private String lastName;

	public Foo() {
	}

	public Foo(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
