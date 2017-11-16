package fr.afpa.GestionnaireBibliothequeGitHubSigrid.Controller;

import java.util.ArrayList;

import fr.afpa.GestionnaireBibliothequeGitHubSigrid.DAO.DAOExemplaire;
import fr.afpa.GestionnaireBibliothequeGitHubSigrid.Model.Exemplaire;
import fr.afpa.GestionnaireBibliothequeGitHubSigrid.Service.ServiceExemplaire;
import fr.afpa.GestionnaireBibliothequeGitHubSigrid.UI.FrameMain;
import fr.afpa.GestionnaireBibliothequeGitHubSigrid.UI.PanelEmprunt;

public class ControllerEmprunt {

	private ServiceExemplaire se;
	
	public ControllerEmprunt(ControllerManager controller,FrameMain frame) {
		
		DAOExemplaire daoe=new DAOExemplaire();
		
		this.se=new ServiceExemplaire(daoe);
		
		PanelEmprunt p=new PanelEmprunt(this);
		
		frame.getDesktopContainer().add(p);
		frame.getDesktopContainer().updateUI();
	}
	
	public ArrayList<Exemplaire> getAll(){
		ArrayList<Exemplaire> myarrayEx=se.getAll();
		ArrayList<Exemplaire> myarrayEmp=new ArrayList<Exemplaire>();
		
		for(int i=0;i<myarrayEx.size();i++){
			if(myarrayEx.get(i).getAdherent().getId_adherent()!=1){
				myarrayEmp.add(myarrayEx.get(i));
			}
		}
		
		return myarrayEmp;
	}
}
