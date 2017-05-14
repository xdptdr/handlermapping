package com.github.xdptdr.jmx;

public class ManagedColor {
	private String color;
	private int hits;

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getHits() {
		return hits;
	}

	public void increment() {
		++hits;
		System.out.println("hits " + hits);
	}

}
