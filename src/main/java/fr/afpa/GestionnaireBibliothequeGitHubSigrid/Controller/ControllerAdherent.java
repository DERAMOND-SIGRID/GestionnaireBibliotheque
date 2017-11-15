package fr.afpa.GestionnaireBibliothequeGitHubSigrid.Controller;

import java.util.ArrayList;

import fr.afpa.GestionnaireBibliothequeGitHubSigrid.DAO.DAOAdherent;
import fr.afpa.GestionnaireBibliothequeGitHubSigrid.DAO.DAOExemplaire;
import fr.afpa.GestionnaireBibliothequeGitHubSigrid.Model.Adherent;
import fr.afpa.GestionnaireBibliothequeGitHubSigrid.Service.ServiceAdherent;
import fr.afpa.GestionnaireBibliothequeGitHubSigrid.UI.FrameMain;
import fr.afpa.GestionnaireBibliothequeGitHubSigrid.UI.PanelAdherent;

public class ControllerAdherent {

	private ServiceAdherent sad;
	
	public ControllerAdherent(ControllerManager controller,FrameMain frame) {
		DAOAdherent daoad=new DAOAdherent();
		DAOExemplaire daoe=new DAOExemplaire();
		
		this.sad=new ServiceAdherent(daoad, daoe);
		
		PanelAdherent p=new PanelAdherent(this);
		
		frame.getDesktopContainer().add(p);
		frame.getDesktopContainer().updateUI();
	}
	
	public ArrayList<Adherent> getAll(){
		ArrayList<Adherent> myarray=sad.getAll();
		
		return myarray;
	}
	
}
