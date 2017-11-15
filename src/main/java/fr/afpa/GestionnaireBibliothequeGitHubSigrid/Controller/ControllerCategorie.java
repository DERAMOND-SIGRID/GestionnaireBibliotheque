package fr.afpa.GestionnaireBibliothequeGitHubSigrid.Controller;

import java.util.ArrayList;

import fr.afpa.GestionnaireBibliothequeGitHubSigrid.DAO.DAOCategorie;
import fr.afpa.GestionnaireBibliothequeGitHubSigrid.DAO.DAOLivre;
import fr.afpa.GestionnaireBibliothequeGitHubSigrid.Model.Categorie;
import fr.afpa.GestionnaireBibliothequeGitHubSigrid.Service.ServiceCategorie;
import fr.afpa.GestionnaireBibliothequeGitHubSigrid.UI.FrameMain;
import fr.afpa.GestionnaireBibliothequeGitHubSigrid.UI.PanelCategorie;

public class ControllerCategorie {

	private ServiceCategorie sc;
	
	public ControllerCategorie(ControllerManager controller,FrameMain frame) {
		DAOCategorie daoc=new DAOCategorie();
		DAOLivre daol=new DAOLivre();
		
		sc=new ServiceCategorie(daoc, daol);
		
		PanelCategorie p=new PanelCategorie(this);
		
		frame.getDesktopContainer().add(p);
		frame.getDesktopContainer().updateUI();
	}
	
	public ArrayList<Categorie> getAll(){
		ArrayList<Categorie> myarray=sc.getAll();
		
		return myarray;
	}
}
