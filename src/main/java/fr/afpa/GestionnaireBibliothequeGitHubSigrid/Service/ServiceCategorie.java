package fr.afpa.GestionnaireBibliothequeGitHubSigrid.Service;

import java.util.ArrayList;

import fr.afpa.GestionnaireBibliothequeGitHubSigrid.DAO.IDAOCategorie;
import fr.afpa.GestionnaireBibliothequeGitHubSigrid.DAO.IDAOLivre;
import fr.afpa.GestionnaireBibliothequeGitHubSigrid.Model.Categorie;
import fr.afpa.GestionnaireBibliothequeGitHubSigrid.Model.Livre;

public class ServiceCategorie implements IServiceCategorie {

	private IDAOCategorie daoC;
	private IDAOLivre daoL;

	////////////////////////////////////////////////////////////////

	public ServiceCategorie(IDAOCategorie daocategorie, IDAOLivre daolivre) {
		this.daoC = daocategorie;
		this.daoL = daolivre;
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

	////////////////////////////////////////////////////////////////

	public boolean isLinkedToLivre(int id_categorie) {
		boolean isLinked=false;
		
		ArrayList<Livre> myarray=daoL.getAll();
		for(int i=0;i<myarray.size();i++) {
			if(myarray.get(i).getCategorie()!=null && id_categorie==myarray.get(i).getCategorie().getId_categorie()) {
				isLinked=true;
			}
		}
		
		return isLinked;
	}

}
