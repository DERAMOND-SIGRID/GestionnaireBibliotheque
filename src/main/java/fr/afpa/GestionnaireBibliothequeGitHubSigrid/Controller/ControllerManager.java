package fr.afpa.GestionnaireBibliothequeGitHubSigrid.Controller;

import fr.afpa.GestionnaireBibliothequeGitHubSigrid.UI.FrameMain;

public class ControllerManager {

	private FrameMain frame;

	private ControllerAccueil ca;
	private ControllerCategorie cc;
	private ControllerAuteur cau;
	private ControllerLivre cl;
	private ControllerAdherent cad;
	private ControllerEmprunt ce;
	private ControllerReparation cr;
	private ControllerEdit ced;
	private ControllerPopup cp;

	/////////////////////////////////////////////////////

	public ControllerManager() {
		frame = new FrameMain(this);

		accueil();

		frame.setVisible(true);
	}

	/////////////////////////////////////////////////////

	public void accueil() {
		ca = new ControllerAccueil(this, frame);
	}

	/////////////////////////////////////////////////////

	public void categorie() {
		cc = new ControllerCategorie(this, frame);
	}

	/////////////////////////////////////////////////////

	public void auteur() {
		cau = new ControllerAuteur(this, frame);
	}

	/////////////////////////////////////////////////////

	public void livre() {
		cl = new ControllerLivre(this, frame);
	}

	/////////////////////////////////////////////////////

	public void adherent() {
		cad = new ControllerAdherent(this, frame);
	}

	/////////////////////////////////////////////////////

	public void emprunt() {
		ce = new ControllerEmprunt(this, frame);
	}

	/////////////////////////////////////////////////////

	public void reparation() {
		cr = new ControllerReparation(this, frame);
	}

	/////////////////////////////////////////////////////

	public void edit(String event) {
		ced = new ControllerEdit(this, frame, event);
	}

	/////////////////////////////////////////////////////

	public void edit(String event, int id) {
		ced = new ControllerEdit(this, frame, event, id);
	}

	/////////////////////////////////////////////////////

	public void popup(String event) {
		cp = new ControllerPopup(this, frame, event);
	}

	/////////////////////////////////////////////////////

	public void clear() {
		frame.getDesktopContainer().removeAll();

		ca = null;
		cc = null;
		cau = null;
		cl = null;
		cad = null;
		ce = null;
		cr = null;
		ced = null;
		cp = null;
	}

}
