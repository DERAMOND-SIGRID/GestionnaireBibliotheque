package fr.afpa.GestionnaireBibliothequeGitHubSigrid.Model;

public class Auteur extends Personne {

	private int id_auteur;
	private String date_naissance;

	/////////////////////////////////////////////////////////////////

	public Auteur(int id_personne, String nom, String prenom, int id_auteur, String dateN) {
		super(id_personne, nom, prenom);
		this.id_auteur = id_auteur;
		this.date_naissance = dateN;
	}

	/////////////////////////////////////////////////////////////////

	public int getId_auteur() {
		return id_auteur;
	}

	public void setId_auteur(int id_auteur) {
		this.id_auteur = id_auteur;
	}

	/////////////////////////////////////////////////////////////////

	public String getDate_naissance() {
		return date_naissance;
	}

	public void setDate_naissance(String date_naissance) {
		this.date_naissance = date_naissance;
	}
	
}
