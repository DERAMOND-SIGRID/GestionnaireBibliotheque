package fr.afpa.GestionnaireBibliothequeGitHubSigrid.Service;

import java.util.ArrayList;

import fr.afpa.GestionnaireBibliothequeGitHubSigrid.Model.Adherent;

public interface IServiceAdherent {

	public ArrayList<Adherent> getAll();
	
	public Adherent getOneById(int id_adherent);
	
	public Adherent getOneByInfo(String nom, String prenom);
	
	public void add(String nom, String prenom,int nbEmpruntMax);
	
	public void update(int id_adherent,String newNom, String newPrenom,int newNbEmpruntMax);
	
	public void remove(int id_adherent);
	
	public boolean isLinkedToExemplaire(int id_adherent);
	
}
