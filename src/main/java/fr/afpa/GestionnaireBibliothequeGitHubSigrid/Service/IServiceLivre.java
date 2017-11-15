package fr.afpa.GestionnaireBibliothequeGitHubSigrid.Service;

import java.util.ArrayList;

import fr.afpa.GestionnaireBibliothequeGitHubSigrid.Model.Livre;

public interface IServiceLivre {

	public ArrayList<Livre> getAll();
	
	public Livre getOneByISBN(long isbn);
	
	public Livre getOneByInfo(String titre, int id_auteur);
	
	public void addWithCategorie(long isbn, String titre, String sous_titre, int id_categorie, int id_auteur);
	
	public void addWithoutCategorie(long isbn, String titre, String sous_titre, int id_auteur);
	
	public void updateInfo(long isbn,String new_titre, String new_sous_titre, int new_id_auteur);
	
	public void updateNewCategorie(long isbn, int id_categorie);
	
	public void updateNoCategorie(long isbn);
	
	public void remove(long isbn);
	
}
