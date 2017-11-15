package fr.afpa.GestionnaireBibliothequeGitHubSigrid.DAO;

import java.util.ArrayList;

import fr.afpa.GestionnaireBibliothequeGitHubSigrid.Model.Adherent;

public interface IDAOAdherent {

	public ArrayList<Adherent> getAll();
	
	public Adherent getOneById(int id_adherent);
	
	public Adherent getOneByInfo(String nom, String prenom);
	
	public void add(String nom, String prenom,int newNbEmpruntMax);
	
	public void update(int id_adherent,String newNom, String newPrenom,int newNbEmpruntMax);
	
	public void remove(int id_adherent);
	
}
