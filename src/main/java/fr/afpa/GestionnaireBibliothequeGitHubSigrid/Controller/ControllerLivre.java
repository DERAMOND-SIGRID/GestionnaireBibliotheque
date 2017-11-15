package fr.afpa.GestionnaireBibliothequeGitHubSigrid.Controller;

import java.util.ArrayList;

import fr.afpa.GestionnaireBibliothequeGitHubSigrid.DAO.DAOExemplaire;
import fr.afpa.GestionnaireBibliothequeGitHubSigrid.DAO.DAOLivre;
import fr.afpa.GestionnaireBibliothequeGitHubSigrid.Model.Livre;
import fr.afpa.GestionnaireBibliothequeGitHubSigrid.Service.ServiceLivre;
import fr.afpa.GestionnaireBibliothequeGitHubSigrid.UI.FrameMain;
import fr.afpa.GestionnaireBibliothequeGitHubSigrid.UI.PanelLivre;

public class ControllerLivre {

	private ServiceLivre sl;
	
	public ControllerLivre(ControllerManager controller,FrameMain frame) {
		DAOLivre doaL=new DAOLivre();
		DAOExemplaire daoE=new DAOExemplaire();
		
		this.sl=new ServiceLivre(doaL, daoE);
		
		PanelLivre p=new PanelLivre(this);
		
		frame.getDesktopContainer().add(p);
		frame.getDesktopContainer().updateUI();
	}
	
	public ArrayList<Livre> getAll(){
		ArrayList<Livre> myarray=sl.getAll();
		
		return myarray;
	}
	
}
