package com.github.xdptdr.jca;

import javax.resource.cci.Record;

public class MyRecord implements Record {

	private static final long serialVersionUID = 1L;

	private String recordName = "recordName";
	private String recordShortDescription = "recordShortDescription";

	@Override
	public String getRecordName() {
		return recordName;
	}

	@Override
	public void setRecordName(String name) {
		recordName = name;
	}

	@Override
	public void setRecordShortDescription(String description) {
		recordShortDescription = description;
	}

	@Override
	public String getRecordShortDescription() {
		return recordShortDescription;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		return this;
	}
}
