package fr.afpa.GestionnaireBibliothequeGitHubSigrid.Service;

import java.util.ArrayList;

import fr.afpa.GestionnaireBibliothequeGitHubSigrid.DAO.IDAOExemplaire;
import fr.afpa.GestionnaireBibliothequeGitHubSigrid.Model.Exemplaire;

public class ServiceExemplaire implements IServiceExemplaire {

	private IDAOExemplaire daoE;

	////////////////////////////////////////////////////////////////////////

	public ServiceExemplaire(IDAOExemplaire daoexemplaire) {
		this.daoE = daoexemplaire;
	}

	////////////////////////////////////////////////////////////////////////

	public ArrayList<Exemplaire> getAll() {
		ArrayList<Exemplaire> myarray = daoE.getAll();

		return myarray;
	}

	////////////////////////////////////////////////////////////////////////

	public Exemplaire getOneById(int id_exemplaire) {
		Exemplaire myexemplaire = daoE.getOneById(id_exemplaire);

		return myexemplaire;
	}

	////////////////////////////////////////////////////////////////////////

	public Exemplaire getOneByInfo(long isbn) {
		Exemplaire myexemplaire = daoE.getOneByInfo(isbn);

		return myexemplaire;
	}

	////////////////////////////////////////////////////////////////////////

	public void add(long isbn) {
		daoE.add(isbn);
	}

	////////////////////////////////////////////////////////////////////////

	public void updateEmprunter(int id_exemplaire, int id_adherent) {
		daoE.updateEmprunter(id_exemplaire, id_adherent);
	}

	////////////////////////////////////////////////////////////////////////

	public void updateAReparer(int id_exemplaire) {
		daoE.updateAReparer(id_exemplaire);
	}

	////////////////////////////////////////////////////////////////////////

	public void updateRendre(int id_exemplaire) {
		daoE.updateRendre(id_exemplaire);
	}

	////////////////////////////////////////////////////////////////////////

	public void remove(int id_exemplaire) {
		daoE.remove(id_exemplaire);
	}

}
