package fr.afpa.GestionnaireBibliothequeGitHubSigrid.Service;

import java.util.ArrayList;

import fr.afpa.GestionnaireBibliothequeGitHubSigrid.DAO.DAOAdherent;
import fr.afpa.GestionnaireBibliothequeGitHubSigrid.Model.Adherent;

public class ServiceAdherent implements IServiceAdherent {

	private DAOAdherent daoAd;

	//////////////////////////////////////////////////////////////////////////////////////////////

	public ServiceAdherent(DAOAdherent daoadherent) {
		this.daoAd = daoadherent;
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

}
