package fr.afpa.GestionnaireBibliothequeGitHubSigrid.Model;

public class Livre {

	private long isbn;
	private String titre;
	private String sous_titre;
	private Categorie categorie;
	private Auteur auteur;
	private boolean est_dispo;

	/////////////////////////////////////////////////////////////////

	public Livre(long ISBN, String titre, String sous_titre, Categorie categorie, Auteur auteur, boolean estDispo) {
		this.isbn = ISBN;
		this.titre = titre;
		this.sous_titre = sous_titre;
		this.categorie = categorie;
		this.auteur = auteur;
		this.est_dispo = estDispo;
	}

	/////////////////////////////////////////////////////////////////

	public long getIsbn() {
		return isbn;
	}

	public void setIsbn(long ISBN) {
		isbn = ISBN;
	}

	/////////////////////////////////////////////////////////////////

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	/////////////////////////////////////////////////////////////////

	public String getSous_titre() {
		return sous_titre;
	}

	public void setSous_titre(String sous_titre) {
		this.sous_titre = sous_titre;
	}

	/////////////////////////////////////////////////////////////////

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	/////////////////////////////////////////////////////////////////

	public Auteur getAuteur() {
		return auteur;
	}

	public void setAuteur(Auteur auteur) {
		this.auteur = auteur;
	}

	/////////////////////////////////////////////////////////////////

	public boolean isEst_dispo() {
		return est_dispo;
	}

	public void setEst_dispo(boolean est_dispo) {
		this.est_dispo = est_dispo;
	}
	
}
