package fr.afpa.GestionnaireBibliothequeGitHubSigrid.Service;

import java.util.ArrayList;

import fr.afpa.GestionnaireBibliothequeGitHubSigrid.DAO.IDAOAuteur;
import fr.afpa.GestionnaireBibliothequeGitHubSigrid.DAO.IDAOLivre;
import fr.afpa.GestionnaireBibliothequeGitHubSigrid.Model.Auteur;
import fr.afpa.GestionnaireBibliothequeGitHubSigrid.Model.Livre;

public class ServiceAuteur implements IServiceAuteur {

	private IDAOAuteur daoAu;
	private IDAOLivre daoL;

	//////////////////////////////////////////////////////////////////////////////////////////////////

	public ServiceAuteur(IDAOAuteur daoauteur, IDAOLivre daolivre) {
		this.daoAu = daoauteur;
		this.daoL = daolivre;
	}

	//////////////////////////////////////////////////////////////////////////////////////////////////

	public ArrayList<Auteur> getAll() {
		ArrayList<Auteur> myarray = daoAu.getAll();

		return myarray;
	}

	//////////////////////////////////////////////////////////////////////////////////////////////////

	public Auteur getOneById(int id_auteur) {
		Auteur myauteur = daoAu.getOneById(id_auteur);

		return myauteur;
	}

	//////////////////////////////////////////////////////////////////////////////////////////////////

	public Auteur getOneByInfo(String nom, String prenom, String dateNaissance) {
		Auteur myauteur = daoAu.getOneByInfo(nom, prenom, dateNaissance);

		return myauteur;
	}

	//////////////////////////////////////////////////////////////////////////////////////////////////

	public void add(String nom, String prenom, String dateNaissance) {
		daoAu.add(nom, prenom, dateNaissance);
	}

	//////////////////////////////////////////////////////////////////////////////////////////////////

	public void update(int id_auteur, String newNom, String newPrenom, String newDateNaissance) {
		daoAu.update(id_auteur, newNom, newPrenom, newDateNaissance);
	}

	//////////////////////////////////////////////////////////////////////////////////////////////////

	public void remove(int id_auteur) {
		daoAu.remove(id_auteur);
	}

	////////////////////////////////////////////////////////////////

	public boolean isLinkedToLivre(int id_auteur) {
		boolean isLinked = false;

		ArrayList<Livre> myarray = daoL.getAll();
		for (int i = 0; i < myarray.size(); i++) {
			if (id_auteur == myarray.get(i).getAuteur().getId_auteur()) {
				isLinked = true;
			}
		}

		return isLinked;
	}

}
