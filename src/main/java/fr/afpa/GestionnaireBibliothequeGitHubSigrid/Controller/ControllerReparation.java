package fr.afpa.GestionnaireBibliothequeGitHubSigrid.Controller;

import java.util.ArrayList;

import fr.afpa.GestionnaireBibliothequeGitHubSigrid.DAO.DAOExemplaire;
import fr.afpa.GestionnaireBibliothequeGitHubSigrid.Model.Exemplaire;
import fr.afpa.GestionnaireBibliothequeGitHubSigrid.Service.ServiceExemplaire;
import fr.afpa.GestionnaireBibliothequeGitHubSigrid.UI.FrameMain;
import fr.afpa.GestionnaireBibliothequeGitHubSigrid.UI.PanelReparation;

public class ControllerReparation {

	private ServiceExemplaire se;
	
	public ControllerReparation(ControllerManager controller,FrameMain frame) {
		
		DAOExemplaire daoe=new DAOExemplaire();
		
		this.se=new ServiceExemplaire(daoe);
		
		PanelReparation p= new PanelReparation(this);
		
		frame.getDesktopContainer().add(p);
		frame.getDesktopContainer().updateUI();
	}
	
	public ArrayList<Exemplaire> getAll(){
		ArrayList<Exemplaire> myarrayEx=se.getAll();
		
		ArrayList<Exemplaire> myarrayR=new ArrayList<Exemplaire>();
		
		for(int i=0;i<myarrayEx.size();i++){
			if(myarrayEx.get(i).isEst_en_reparation()==true){
				myarrayR.add(myarrayEx.get(i));
			}
		}
		
		return myarrayR;
	}
}
