package fr.afpa.GestionnaireBibliothequeGitHubSigrid.Model;

public class Adherent extends Personne {

	private int id_adherent;
	private int nb_emprunt_max;

	/////////////////////////////////////////////////////////////////

	public Adherent(int id_personne, String nom, String prenom, int id_adherent, int nb_emprunt_max) {
		super(id_personne, nom, prenom);
		this.id_adherent = id_adherent;
		this.nb_emprunt_max = nb_emprunt_max;
	}

	/////////////////////////////////////////////////////////////////

	public int getId_adherent() {
		return id_adherent;
	}

	public void setId_adherent(int id_adherent) {
		this.id_adherent = id_adherent;
	}

	/////////////////////////////////////////////////////////////////

	public int getNb_emprunt_max() {
		return nb_emprunt_max;
	}

	public void setNb_emprunt_max(int nb_emprunt_max) {
		this.nb_emprunt_max = nb_emprunt_max;
	}
	
}
