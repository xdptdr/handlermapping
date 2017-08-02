package com.github.xdptdr.div.med;

public class Medecin {

	private boolean generaliste;
	private boolean specialiste;
	private Specialite specialite;
	private Secteur secteur;

	public boolean isGeneraliste() {
		return generaliste;
	}

	public void setGeneraliste(boolean generaliste) {
		this.generaliste = generaliste;

	}

	public boolean isSpecialiste() {
		return specialiste;
	}

	public void setSpecialiste(boolean specialiste) {
		this.specialiste = specialiste;

	}

	public void setSpecialite(Specialite specialite) {
		this.specialite = specialite;
	}

	public Secteur getSecteur() {
		return secteur;
	}

	public void setSecteur(Secteur secteur) {
		this.secteur = secteur;
	}

}
