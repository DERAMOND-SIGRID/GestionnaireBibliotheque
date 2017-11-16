package fr.afpa.GestionnaireBibliothequeGitHubSigrid.Controller;

import java.awt.Color;
import java.util.ArrayList;

import fr.afpa.GestionnaireBibliothequeGitHubSigrid.DAO.DAOCategorie;
import fr.afpa.GestionnaireBibliothequeGitHubSigrid.DAO.DAOLivre;
import fr.afpa.GestionnaireBibliothequeGitHubSigrid.Model.Categorie;
import fr.afpa.GestionnaireBibliothequeGitHubSigrid.Service.ServiceCategorie;
import fr.afpa.GestionnaireBibliothequeGitHubSigrid.UI.FrameMain;
import fr.afpa.GestionnaireBibliothequeGitHubSigrid.UI.PanelEdit;

public class ControllerEdit {

	private ControllerManager cm;
	private PanelEdit p;
	
	private ServiceCategorie sc;
	
	public ControllerEdit(ControllerManager controller,FrameMain frame, String event){
		this.cm=controller;
		
		this.p=new PanelEdit(this, event);
		
		if("addCategorie".equals(event)){
			DAOCategorie daoc=new DAOCategorie();
			DAOLivre daol=new DAOLivre();
			
			this.sc=new ServiceCategorie(daoc, daol);
		}
		
		frame.getDesktopContainer().add(p);
		frame.getDesktopContainer().updateUI();
		
	}
	
	
	
	public ControllerEdit(ControllerManager controller,FrameMain frame, String event, int id){
		this.cm=controller;
		
		this.p=new PanelEdit(this, event, id);

		if("editCategorie".equals(event) || "removeCategorie".equals(event)){
			DAOCategorie daoc=new DAOCategorie();
			DAOLivre daol=new DAOLivre();
			
			this.sc=new ServiceCategorie(daoc, daol);
			
			String oldNomC=sc.getOneById(id).getNom_categorie();
		
			p.getTxtCategorie().setText(oldNomC);
			
			if("removeCategorie".equals(event)){
				p.getTxtCategorie().setEnabled(false);
				p.getTxtCategorie().setDisabledTextColor(Color.BLACK);
			}
		}
		
		frame.getDesktopContainer().add(p);
		frame.getDesktopContainer().updateUI();
				
	}
	
	
	
	public void categorie(){
		cm.clear();
		
		cm.categorie();
	}
	
	public void addCategorie(String nom){
		if(nom.isEmpty() || "Entrez une catégorie ex: roman bd manga".equals(nom)){
			p.getLblPopup().setText("Il y a une erreur de champ!");
		}else{
			nom=nom.toUpperCase();
			
			boolean isExisting=false;
			
			ArrayList<Categorie> myarray=new ArrayList<Categorie>();
			myarray=sc.getAll();
			for(int i=0;i<myarray.size();i++){
				if(nom.equals(myarray.get(i).getNom_categorie())){
					isExisting=true;
				}
			}
			
			if(isExisting==true){
				p.getLblPopup().setText("Désolé, cette catégorie existe déjà!");
			}else{
				sc.add(nom);
				
				categorie();
			}
			
		}
		
	}
	
	public void editCategorie(int id, String nouveauNom){
		String oldName=sc.getOneById(id).getNom_categorie();
		
		if(nouveauNom.isEmpty() || oldName.equals(nouveauNom.toUpperCase())){
			p.getLblPopup().setText("Il y a une erreur de champ!");
		}else{
			nouveauNom=nouveauNom.toUpperCase();
			
			boolean isExisting=false;
			
			ArrayList<Categorie> myarray=new ArrayList<Categorie>();
			myarray=sc.getAll();
			for(int i=0;i<myarray.size();i++){
				if(nouveauNom.equals(myarray.get(i).getNom_categorie())){
					isExisting=true;
				}
			}
			
			if(isExisting==true){
				p.getLblPopup().setText("Désolé, cette catégorie existe déjà!");
			}else{
				sc.update(id, nouveauNom);
				
				categorie();
			}
			
		}
	}
	
	public void removeCategorie(int id){
		sc.remove(id);
		
		categorie();
	}
	
}
