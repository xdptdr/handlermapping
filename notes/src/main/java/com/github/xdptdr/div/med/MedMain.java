package com.github.xdptdr.div.med;

public class MedMain {

	public static void main(String[] args) {

		Medecin medecin = new Medecin();
		medecin.setGeneraliste(true);
		medecin.setSpecialiste(true);
		medecin.setSpecialite(Specialite.CARDIOLOGUE);
		medecin.setSecteur(Secteur.SECTEUR_1);
		MedecinFactMaker medecinFactMaker = new MedecinFactMaker(medecin);
		medecinFactMaker.validate();
		medecinFactMaker.getBaseDeRemboursement();
		medecinFactMaker.getCausePossibleDepassementHonoraires();
		
		Personne personne = new Personne();
		PersonnneFactChecker personnneFactChecker = new PersonnneFactChecker(personne);
		personnneFactChecker.beneficiePriseEnChargeFraisDeSante();
		personnneFactChecker.apprecierActiviteProfessionnelle();
		personnneFactChecker.apprecierConditionsResidence();

	}
}
