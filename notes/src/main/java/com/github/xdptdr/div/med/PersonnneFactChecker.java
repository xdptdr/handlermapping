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
		 * Un d�cret en Conseil d'Etat pr�voit les conditions dans lesquelles
		 * les personnes qui r�sident en France et cessent de remplir les autres
		 * conditions mentionn�es � l'article L. 111-2-3 b�n�ficient, dans la
		 * limite d'un an, d'une prolongation du droit � la prise en charge des
		 * frais de sant� mentionn�e � l'article L. 160-8 et, le cas �ch�ant, �
		 * la couverture compl�mentaire pr�vue � l'article L. 861-1.
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
