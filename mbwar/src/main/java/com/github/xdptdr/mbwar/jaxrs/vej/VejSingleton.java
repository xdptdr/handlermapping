package com.github.xdptdr.mbwar.jaxrs.vej;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;

@Singleton
@LocalBean
public class VejSingleton {

	private List<String> log = new ArrayList<>();

	public void log(String item) {
		log.add(item);
	}

	public List<String> getLog() {
		return log;
	}

}
