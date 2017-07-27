package com.github.xdptdr.jse;

import java.util.Locale;

import com.github.xdptdr.notes.N;

public class Locales {
	public static void main(String[] args) {

		N.azzert("fr".equals(Locale.FRANCE.getLanguage()));
		N.azzert("fr".equals(Locale.FRENCH.getLanguage()));

		N.azzert("FR".equals(Locale.FRANCE.getCountry()));
		N.azzert("".equals(Locale.FRENCH.getCountry()));
	}
}
