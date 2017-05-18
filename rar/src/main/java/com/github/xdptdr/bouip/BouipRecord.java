package com.github.xdptdr.bouip;

import javax.resource.cci.Record;

public class BouipRecord implements Record {

	private static final long serialVersionUID = 1L;
	private String name;
	private String description;

	public BouipRecord(String name, String description) {
		this.name = name;
		this.description = description;
	}

	@Override
	public String getRecordName() {
		return name;
	}

	@Override
	public void setRecordName(String name) {
		this.name = name;
	}

	@Override
	public void setRecordShortDescription(String description) {
		this.description = description;
	}

	@Override
	public String getRecordShortDescription() {
		return description;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		return new BouipRecord(name, description);
	}

}
