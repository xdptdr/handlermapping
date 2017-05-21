package com.github.xdptdr.jee7;

public abstract class Reading {
	
	public static enum RS {
		UNTOUCHED, STARTED, COMPLETED
	}
	
	private String section;

	protected <T> T constructANewInstanceOf(Class<T> clazz) {
		return null;
	}

	public String getSection() {
		return section;
	}

	protected void section(String section, RS readingStatus) {
		this.section = section;
	}

	protected void toReadAgain() {

	}
}
