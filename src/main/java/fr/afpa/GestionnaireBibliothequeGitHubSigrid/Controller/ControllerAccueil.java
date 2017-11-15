package fr.afpa.GestionnaireBibliothequeGitHubSigrid.Controller;

import fr.afpa.GestionnaireBibliothequeGitHubSigrid.UI.FrameMain;
import fr.afpa.GestionnaireBibliothequeGitHubSigrid.UI.PanelAccueil;

public class ControllerAccueil {

	public ControllerAccueil(ControllerManager controller,FrameMain frame) {
		PanelAccueil p=new PanelAccueil();
		
		frame.getDesktopContainer().add(p);
		frame.getDesktopContainer().updateUI();
	}
}
