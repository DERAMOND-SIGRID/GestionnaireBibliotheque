package fr.afpa.GestionnaireBibliothequeGitHubSigrid.DAO;

import java.util.ArrayList;

import fr.afpa.GestionnaireBibliothequeGitHubSigrid.Model.Exemplaire;

public interface IDAOExemplaire {

	public ArrayList<Exemplaire> getAll();
	
	public Exemplaire getOneById(int id_exemplaire);
	
	public Exemplaire getOneByInfo(long isbn);
	
	public void add(long isbn);
	
	public void updateEmprunter(int id_exemplaire, int id_adherent);
	
	public void updateAReparer(int id_exemplaire);
	
	public void updateRendre(int id_exemplaire);
	
	public void remove(int id_exemplaire);
	
}
