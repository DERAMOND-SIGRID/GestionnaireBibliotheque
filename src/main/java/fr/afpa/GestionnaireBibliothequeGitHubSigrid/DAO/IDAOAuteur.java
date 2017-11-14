package fr.afpa.GestionnaireBibliothequeGitHubSigrid.DAO;

import java.util.ArrayList;

import fr.afpa.GestionnaireBibliothequeGitHubSigrid.Model.Auteur;

public interface IDAOAuteur {

	public ArrayList<Auteur> getAll();

	public void add(String nom, String prenom, String dateNaissance);
	
	public void update(int id_auteur,String newNom, String newPrenom, String newDateNaissance);
	
	public void remove(int id_auteur);
	
}
