package fr.afpa.GestionnaireBibliothequeGitHubSigrid.Model;

public class Exemplaire {

	private int id_exemplaire;
	private Livre livre;
	private Adherent adherent;
	private boolean est_en_reparation;
	private boolean est_disponible;

	/////////////////////////////////////////////////////////////////

	public Exemplaire(int id_exemplaire, Livre livre, Adherent adherent, boolean is_in_repair, boolean is_dispo) {
		this.id_exemplaire = id_exemplaire;
		this.livre = livre;
		this.adherent = adherent;
		this.est_en_reparation = is_in_repair;
		this.est_disponible = is_dispo;
	}

	/////////////////////////////////////////////////////////////////

	public int getId_exemplaire() {
		return id_exemplaire;
	}

	public void setId_exemplaire(int id_exemplaire) {
		this.id_exemplaire = id_exemplaire;
	}

	/////////////////////////////////////////////////////////////////

	public Livre getLivre() {
		return livre;
	}

	public void setLivre(Livre livre) {
		this.livre = livre;
	}

	/////////////////////////////////////////////////////////////////

	public Adherent getAdherent() {
		return adherent;
	}

	public void setAdherent(Adherent adherent) {
		this.adherent = adherent;
	}

	/////////////////////////////////////////////////////////////////

	public boolean isEst_en_reparation() {
		return est_en_reparation;
	}

	public void setEst_en_reparation(boolean est_en_reparation) {
		this.est_en_reparation = est_en_reparation;
	}

	/////////////////////////////////////////////////////////////////

	public boolean isEst_disponible() {
		return est_disponible;
	}

	public void setEst_disponible(boolean est_disponible) {
		this.est_disponible = est_disponible;
	}
	
}
