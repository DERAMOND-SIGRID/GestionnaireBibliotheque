package fr.afpa.GestionnaireBibliothequeGitHubSigrid.DAO;

import java.util.ArrayList;

import fr.afpa.GestionnaireBibliothequeGitHubSigrid.Model.Categorie;

public interface IDAOCategorie {

public ArrayList<Categorie> getAll();
	
	public void add(String nom_categorie);
	
	public void update(int id_categorie,String newName);
	
	public void remove(int id_categorie);
}
