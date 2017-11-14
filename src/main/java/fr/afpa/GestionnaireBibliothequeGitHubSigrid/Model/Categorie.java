package fr.afpa.GestionnaireBibliothequeGitHubSigrid.Model;

public class Categorie {

	private int id_categorie;
	private String nom_categorie;

	/////////////////////////////////////////////////////////////////

	public Categorie(int id, String nom) {
		this.id_categorie = id;
		this.nom_categorie = nom;
	}

	/////////////////////////////////////////////////////////////////
	public int getId_categorie() {
		return id_categorie;
	}

	public void setId_categorie(int id_categorie) {
		this.id_categorie = id_categorie;
	}

	/////////////////////////////////////////////////////////////////
	public String getNom_categorie() {
		return nom_categorie;
	}

	public void setNom_categorie(String nom_categorie) {
		this.nom_categorie = nom_categorie;
	}
	
}
