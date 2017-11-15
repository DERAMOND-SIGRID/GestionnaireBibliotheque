package fr.afpa.GestionnaireBibliothequeGitHubSigrid.Service;

import java.util.ArrayList;

import fr.afpa.GestionnaireBibliothequeGitHubSigrid.DAO.IDAOAdherent;
import fr.afpa.GestionnaireBibliothequeGitHubSigrid.DAO.IDAOExemplaire;
import fr.afpa.GestionnaireBibliothequeGitHubSigrid.Model.Adherent;
import fr.afpa.GestionnaireBibliothequeGitHubSigrid.Model.Exemplaire;

public class ServiceAdherent implements IServiceAdherent {

	private IDAOAdherent daoAd;
	private IDAOExemplaire daoE;

	//////////////////////////////////////////////////////////////////////////////////////////////

	public ServiceAdherent(IDAOAdherent daoadherent,IDAOExemplaire daoexemplaire) {
		this.daoAd = daoadherent;
		this.daoE=daoexemplaire;
	}

	//////////////////////////////////////////////////////////////////////////////////////////////

	public ArrayList<Adherent> getAll() {
		ArrayList<Adherent> myarray=daoAd.getAll();
		
		return myarray;
	}

	//////////////////////////////////////////////////////////////////////////////////////////////

	public Adherent getOneById(int id_adherent) {
		Adherent myadherent=daoAd.getOneById(id_adherent);
		
		return myadherent;
	}

	//////////////////////////////////////////////////////////////////////////////////////////////

	public Adherent getOneByInfo(String nom, String prenom) {
		Adherent myadherent=daoAd.getOneByInfo(nom, prenom);
		
		return myadherent;
	}

	//////////////////////////////////////////////////////////////////////////////////////////////

	public void add(String nom, String prenom, int nbEmpruntMax) {
		daoAd.add(nom, prenom, nbEmpruntMax);
	}

	//////////////////////////////////////////////////////////////////////////////////////////////

	public void update(int id_adherent, String newNom, String newPrenom, int newNbEmpruntMax) {
		daoAd.update(id_adherent, newNom, newPrenom, newNbEmpruntMax);
	}

	//////////////////////////////////////////////////////////////////////////////////////////////

	public void remove(int id_adherent) {
		daoAd.remove(id_adherent);
	}

	//////////////////////////////////////////////////////////////////////////////////////////////
	
	public boolean isLinkedToExemplaire(int id_adherent) {
		boolean isLinked=false;
		
		ArrayList<Exemplaire> myarray=daoE.getAll();
		for(int i=0;i<myarray.size();i++) {
			if(myarray.get(i).getAdherent().getId_adherent()==id_adherent) {
				isLinked=true;
			}
		}
		
		return isLinked;
	}
	
}
