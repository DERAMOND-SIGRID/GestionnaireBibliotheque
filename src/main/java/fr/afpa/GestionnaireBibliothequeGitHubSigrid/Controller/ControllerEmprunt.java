package fr.afpa.GestionnaireBibliothequeGitHubSigrid.Controller;

import fr.afpa.GestionnaireBibliothequeGitHubSigrid.UI.FrameMain;
import fr.afpa.GestionnaireBibliothequeGitHubSigrid.UI.PanelEmprunt;

public class ControllerEmprunt {

	public ControllerEmprunt(ControllerManager controller,FrameMain frame) {
		PanelEmprunt p=new PanelEmprunt();
		
		frame.getDesktopContainer().add(p);
		frame.getDesktopContainer().updateUI();
	}
}
