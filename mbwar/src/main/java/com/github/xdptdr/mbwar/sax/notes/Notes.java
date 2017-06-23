package com.github.xdptdr.mbwar.sax.notes;

import com.github.xdptdr.mbwar.jaxrs.notes.N;

public class Notes {
	public static void notes(N n) {
	}

	public static void main(String[] args) {
		N n = new N();
		notes(n);
		n.sumUp();
	}
}
