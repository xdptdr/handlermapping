package com.github.xdptdr.mbwar.jaxb;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlList;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class MyThingyLists {
	private List<String> list1 = new ArrayList<>();
	private List<String> list2 = new ArrayList<>();

	public List<String> getList1() {
		return list1;
	}

	public void setList1(List<String> list1) {
		this.list1 = list1;
	}

	@XmlList
	public List<String> getList2() {
		return list2;
	}

	public void setList2(List<String> list2) {
		this.list2 = list2;
	}

}
