package fr.afpa.GestionnaireBibliothequeGitHubSigrid.DAO;

import java.util.ArrayList;

import fr.afpa.GestionnaireBibliothequeGitHubSigrid.Model.Livre;

public interface IDAOLivre {

	public ArrayList<Livre> getAll();
	
	public void add(long isbn, String titre, String sous_titre, int id_categorie, int id_auteur, int isDispo);
	
	public void update(long isbn,String new_titre, String new_sous_titre, int new_id_categorie, int new_id_auteur, int isDispo);
	
	public void remove(long isbn);
	
}
