package fr.afpa.GestionnaireBibliothequeGitHubSigrid.DAO;

import java.util.ArrayList;

import fr.afpa.GestionnaireBibliothequeGitHubSigrid.Model.Exemplaire;

public interface IDAOExemplaire {

	public ArrayList<Exemplaire> getAll();
	
	public void add(long isbn);
	
	public void update(int id_exemplaire, long isbn, int id_adherent, boolean is_in_repair, boolean is_dispo);
	
	public void remove(int id_exemplaire);
	
}
