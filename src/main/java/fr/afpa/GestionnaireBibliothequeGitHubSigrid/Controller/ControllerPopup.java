package fr.afpa.GestionnaireBibliothequeGitHubSigrid.Controller;

import java.util.Timer;
import java.util.TimerTask;

import fr.afpa.GestionnaireBibliothequeGitHubSigrid.UI.FrameMain;
import fr.afpa.GestionnaireBibliothequeGitHubSigrid.UI.PanelPopup;

public class ControllerPopup {

	private ControllerManager cm;
	private FrameMain fm;
	
	public ControllerPopup(ControllerManager controller, FrameMain frame,String event){
		this.cm=controller;
		this.fm=frame;
		
		PanelPopup p=new PanelPopup();
		
		frame.getDesktopContainer().add(p);
		frame.getMenuContainer().setVisible(false);
		frame.getDesktopContainer().updateUI();
		
		TimerTask myTask=null;
		
		if("categorie".equals(event)){
			p.getLbl().setText("Désolé, cette catégorie est liée à des livres!");
			
			//timer task
			myTask=new TimerTask(){

				@Override
				public void run() {
					cm.clear();
					fm.getMenuContainer().setVisible(true);
					cm.categorie();
				}
				
			};
	
		}
		
		Timer myTimer=new Timer();
		myTimer.schedule(myTask, 3000);
	}
	
}
