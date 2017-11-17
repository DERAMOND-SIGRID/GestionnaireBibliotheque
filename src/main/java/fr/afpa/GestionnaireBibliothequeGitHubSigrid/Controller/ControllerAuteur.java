package fr.afpa.GestionnaireBibliothequeGitHubSigrid.Controller;

import java.util.ArrayList;

import fr.afpa.GestionnaireBibliothequeGitHubSigrid.DAO.DAOAuteur;
import fr.afpa.GestionnaireBibliothequeGitHubSigrid.DAO.DAOLivre;
import fr.afpa.GestionnaireBibliothequeGitHubSigrid.Model.Auteur;
import fr.afpa.GestionnaireBibliothequeGitHubSigrid.Service.ServiceAuteur;
import fr.afpa.GestionnaireBibliothequeGitHubSigrid.UI.FrameMain;
import fr.afpa.GestionnaireBibliothequeGitHubSigrid.UI.PanelAuteur;

public class ControllerAuteur {

	private ControllerManager cm;
	private ServiceAuteur sau;
	
	/////////////////////////////////////////////////////////////////////////////
	
	public ControllerAuteur(ControllerManager controller,FrameMain frame) {
		this.cm = controller;
		
		DAOAuteur daoau=new DAOAuteur();
		DAOLivre daol=new DAOLivre();
		
		this.sau=new ServiceAuteur(daoau, daol);
		
		PanelAuteur p=new PanelAuteur(this);
		
		frame.getDesktopContainer().add(p);
		frame.getDesktopContainer().updateUI();
	}
	
	/////////////////////////////////////////////////////////////////////////////
	
	public ArrayList<Auteur> getAll(){
		ArrayList<Auteur> myarray=sau.getAll();
		
		return myarray;
	}
	
	/////////////////////////////////////////////////////////////////////////////
	
	public void add() {
		cm.clear();

		cm.edit("addAuteur");
	}
	
}
