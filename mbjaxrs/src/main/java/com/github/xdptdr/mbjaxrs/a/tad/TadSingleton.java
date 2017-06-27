package com.github.xdptdr.mbjaxrs.a.tad;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;

@Singleton
@LocalBean
public class TadSingleton {

	private List<TadEvent> events = new ArrayList<>();

	public void log(String event) {
		events.add(new TadEvent(event));
	}

	public List<TadEvent> getLog() {
		return events;
	}

}
