package fr.afpa.GestionnaireBibliothequeGitHubSigrid.Service;

import java.util.ArrayList;

import fr.afpa.GestionnaireBibliothequeGitHubSigrid.DAO.DAOCategorie;
import fr.afpa.GestionnaireBibliothequeGitHubSigrid.Model.Categorie;

public class ServiceCategorie implements IServiceCategorie {

	private DAOCategorie daoC;

	////////////////////////////////////////////////////////////////

	public ServiceCategorie(DAOCategorie daocategorie) {
		this.daoC = daocategorie;
	}

	////////////////////////////////////////////////////////////////

	public ArrayList<Categorie> getAll() {
		ArrayList<Categorie> myarray = daoC.getAll();

		return myarray;
	}

	////////////////////////////////////////////////////////////////

	public Categorie getOneById(int id_categorie) {
		Categorie mycategorie = daoC.getOneById(id_categorie);

		return mycategorie;
	}

	////////////////////////////////////////////////////////////////

	public Categorie getOneByInfo(String nom_categorie) {
		Categorie mycategorie = daoC.getOneByInfo(nom_categorie);

		return mycategorie;
	}

	////////////////////////////////////////////////////////////////

	public void add(String nom_categorie) {
		daoC.add(nom_categorie);
	}

	////////////////////////////////////////////////////////////////

	public void update(int id_categorie, String newName) {
		daoC.update(id_categorie, newName);
	}

	////////////////////////////////////////////////////////////////

	public void remove(int id_categorie) {
		daoC.remove(id_categorie);
	}

}
