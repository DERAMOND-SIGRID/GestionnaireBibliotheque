package fr.afpa.GestionnaireBibliothequeGitHubSigrid.Model;

public class Personne {

	private int id_personne;
	private String nom_personne;
	private String prenom_personne;

	/////////////////////////////////////////////////////////////////

	public Personne(int id, String nom, String prenom) {
		this.id_personne = id;
		this.nom_personne = nom;
		this.prenom_personne = prenom;
	}

	/////////////////////////////////////////////////////////////////

	public int getId_personne() {
		return id_personne;
	}

	public void setId_personne(int id_personne) {
		this.id_personne = id_personne;
	}

	/////////////////////////////////////////////////////////////////

	public String getNom_personne() {
		return nom_personne;
	}

	public void setNom_personne(String nom_personne) {
		this.nom_personne = nom_personne;
	}

	/////////////////////////////////////////////////////////////////

	public String getPrenom_personne() {
		return prenom_personne;
	}

	public void setPrenom_personne(String prenom_personne) {
		this.prenom_personne = prenom_personne;
	}
	
}
