package fr.afpa.GestionnaireBibliothequeGitHubSigrid.Service;

import java.util.ArrayList;

import fr.afpa.GestionnaireBibliothequeGitHubSigrid.DAO.IDAOExemplaire;
import fr.afpa.GestionnaireBibliothequeGitHubSigrid.DAO.IDAOLivre;
import fr.afpa.GestionnaireBibliothequeGitHubSigrid.Model.Exemplaire;
import fr.afpa.GestionnaireBibliothequeGitHubSigrid.Model.Livre;

public class ServiceLivre implements IServiceLivre {

	private IDAOLivre daoL;
	private IDAOExemplaire daoE;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public ServiceLivre(IDAOLivre daolivre, IDAOExemplaire daoexemplaire) {
		this.daoL = daolivre;
		this.daoE = daoexemplaire;
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public ArrayList<Livre> getAll() {
		ArrayList<Livre> myarray = daoL.getAll();

		return myarray;
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public Livre getOneByISBN(long isbn) {
		Livre mylivre = daoL.getOneByISBN(isbn);

		return mylivre;
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public Livre getOneByInfo(String titre, int id_auteur) {
		Livre mylivre = daoL.getOneByInfo(titre, id_auteur);

		return mylivre;
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public void addWithCategorie(long isbn, String titre, String sous_titre, int id_categorie, int id_auteur) {
		daoL.addWithCategorie(isbn, titre, sous_titre, id_categorie, id_auteur);
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public void addWithoutCategorie(long isbn, String titre, String sous_titre, int id_auteur) {
		daoL.addWithoutCategorie(isbn, titre, sous_titre, id_auteur);
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public void updateInfo(long isbn, String new_titre, String new_sous_titre, int new_id_auteur) {
		daoL.updateInfo(isbn, new_titre, new_sous_titre, new_id_auteur);
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public void updateNewCategorie(long isbn, int id_categorie) {
		daoL.updateNewCategorie(isbn, id_categorie);
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public void updateNoCategorie(long isbn) {
		daoL.updateNoCategorie(isbn);
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public void remove(long isbn) {
		daoL.remove(isbn);
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public boolean isLinkedToExemplaire(long isbn) {
		boolean isLinked=false;
		
		ArrayList<Exemplaire> myarray=daoE.getAll();
		for(int i=0;i<myarray.size();i++) {
			if(isbn==myarray.get(i).getLivre().getIsbn()) {
				isLinked=true;
			}
		}
		
		return isLinked;
	}
}
