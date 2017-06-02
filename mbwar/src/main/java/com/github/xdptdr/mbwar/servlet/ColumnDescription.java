package com.github.xdptdr.mbwar.servlet;

public class ColumnDescription {

	String content;
	String type;

	public ColumnDescription(String content, String type) {
		this.content = content;
		this.type = type;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
