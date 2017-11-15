package fr.afpa.GestionnaireBibliothequeGitHubSigrid.Controller;

import fr.afpa.GestionnaireBibliothequeGitHubSigrid.UI.FrameMain;
import fr.afpa.GestionnaireBibliothequeGitHubSigrid.UI.PanelReparation;

public class ControllerReparation {

	public ControllerReparation(ControllerManager controller,FrameMain frame) {
		PanelReparation p= new PanelReparation();
		
		frame.getDesktopContainer().add(p);
		frame.getDesktopContainer().updateUI();
	}
}
