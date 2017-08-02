package com.github.xdptdr.div.med;

public class MedecinFactMaker {

	private Medecin medecin;

	public MedecinFactMaker(Medecin medecin) {
		this.medecin = medecin;
	}

	public void validate() {
		if (medecin.isGeneraliste() && medecin.isSpecialiste()) {
			throw new RuntimeException("Un médecin ne peut être à la fois généraliste et spécialiste");
		}
	}

	public BaseRemboursement getBaseDeRemboursement() {
		if (medecin.getSecteur() != null) {
			switch (medecin.getSecteur()) {
			case SECTEUR_1:
				return BaseRemboursement.SECTEUR_1;
			case SECTEUR_2_CAS:
				return BaseRemboursement.SECTEUR_1;
			case SECTEUR_2:
				return BaseRemboursement.SECTEUR_2;
			case NON_CONVENTIONNE:
				return BaseRemboursement.DIT_AUTORITE;
			}
		}
		return null;

	}

	public TypeDepassementHonoraire getCausePossibleDepassementHonoraires() {
		if (medecin.getSecteur() != null) {
			switch (medecin.getSecteur()) {
			case SECTEUR_1:
				return TypeDepassementHonoraire.EXCEPTIONNEL;
			case SECTEUR_2_CAS:
				return TypeDepassementHonoraire.ACTES_CLINIQUES_OU_TECHNIQUES;
			case SECTEUR_2:
				return TypeDepassementHonoraire.LIBRE_MODERE;
			case NON_CONVENTIONNE:
				return TypeDepassementHonoraire.LIBRE;
			}
		}
		return null;
	}

}
