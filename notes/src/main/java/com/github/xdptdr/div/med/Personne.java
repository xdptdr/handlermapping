package com.github.xdptdr.div.med;

public class Personne {

	private Residence residence = new Residence();

	public boolean travaille() {
		return false;
	}

	public Residence residence() {
		return residence;
	}

	public EtatPersonne etat() {
		return null;
	}

}
