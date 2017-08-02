package com.github.xdptdr.div.med;

public class PersonnneFactChecker {

	private Personne personne;

	public PersonnneFactChecker(Personne personne) {
		this.personne = personne;
	}

	public boolean beneficiePriseEnChargeFraisDeSante() {
		boolean travail = personne.travaille();
		boolean residence = personne.residence().stable() && personne.residence().reguliere();
		boolean etat = personne.etat() == EtatPersonne.MALADIE || personne.etat() == EtatPersonne.MATERNITE;
		boolean priseEnCharge = (travail || residence) && etat;
		if (!priseEnCharge) {
			if (this.limite()) {
				priseEnCharge = true;
			}
		}
		if(!priseEnCharge) {
			
		}
		return priseEnCharge;
	}

	private boolean limite() {
		/*
		 * Un décret en Conseil d'Etat prévoit les conditions dans lesquelles
		 * les personnes qui résident en France et cessent de remplir les autres
		 * conditions mentionnées à l'article L. 111-2-3 bénéficient, dans la
		 * limite d'un an, d'une prolongation du droit à la prise en charge des
		 * frais de santé mentionnée à l'article L. 160-8 et, le cas échéant, à
		 * la couverture complémentaire prévue à l'article L. 861-1.
		 */
		return false;
	}

	public void apprecierActiviteProfessionnelle() {
		// TODO L. 111-2-2 et L. 111-2-3.

	}

	public void apprecierConditionsResidence() {
		// TODO L. 111-2-2 et L. 111-2-3.

	}

}
