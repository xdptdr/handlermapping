package com.github.xdptdr.mbwar.servlet;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MyEntity {

	@Id
	private Long id;

	private String name;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		StringBuffer buf = new StringBuffer();
		if (id == null) {
			buf.append("null");
		} else {
			buf.append(id);
		}
		buf.append(" ; ");
		if (name == null) {
			buf.append("null");
		} else {
			buf.append(name);
		}
		return buf.toString();
	}

}
