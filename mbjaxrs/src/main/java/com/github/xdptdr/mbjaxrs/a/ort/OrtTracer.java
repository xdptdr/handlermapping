package com.github.xdptdr.mbjaxrs.a.ort;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;

@Singleton
@LocalBean
public class OrtTracer {

	List<String> events = new ArrayList<String>();
	
	public void trace(String event) {
		events.add(event);
	}
	
	public List<String> getEvents() {
		return events;
	}
}
