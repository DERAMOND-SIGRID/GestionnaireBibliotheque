package fr.afpa.GestionnaireBibliothequeGitHubSigrid.Service;

import java.util.ArrayList;

import fr.afpa.GestionnaireBibliothequeGitHubSigrid.DAO.DAOAuteur;
import fr.afpa.GestionnaireBibliothequeGitHubSigrid.Model.Auteur;

public class ServiceAuteur implements IServiceAuteur {

	private DAOAuteur daoAu;

	//////////////////////////////////////////////////////////////////////////////////////////////////

	public ServiceAuteur(DAOAuteur daoauteur) {
		this.daoAu = daoauteur;
	}

	//////////////////////////////////////////////////////////////////////////////////////////////////

	public ArrayList<Auteur> getAll() {
		ArrayList<Auteur> myarray=daoAu.getAll();
		
		return myarray;
	}

	//////////////////////////////////////////////////////////////////////////////////////////////////

	public Auteur getOneById(int id_auteur) {
		Auteur myauteur=daoAu.getOneById(id_auteur);
		
		return myauteur;
	}

	//////////////////////////////////////////////////////////////////////////////////////////////////

	public Auteur getOneByInfo(String nom, String prenom, String dateNaissance) {
		Auteur myauteur=daoAu.getOneByInfo(nom, prenom, dateNaissance);
		
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

}
