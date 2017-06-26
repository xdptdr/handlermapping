package com.github.xdptdr.mbjaxrs.basics.tad;

import java.util.Calendar;

public class TadEvent {

	private String event;
	private Calendar date;

	public TadEvent(String event) {
		this.event = event;
		this.date = Calendar.getInstance();
	}

	public String getEvent() {
		return event;
	}

	public Calendar getDate() {
		return date;
	}

}
