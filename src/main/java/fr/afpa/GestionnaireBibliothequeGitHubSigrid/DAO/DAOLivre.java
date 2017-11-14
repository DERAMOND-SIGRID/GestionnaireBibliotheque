package fr.afpa.GestionnaireBibliothequeGitHubSigrid.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import fr.afpa.GestionnaireBibliothequeGitHubSigrid.DAOConnect.ConnectToBDD;
import fr.afpa.GestionnaireBibliothequeGitHubSigrid.Model.Auteur;
import fr.afpa.GestionnaireBibliothequeGitHubSigrid.Model.Categorie;
import fr.afpa.GestionnaireBibliothequeGitHubSigrid.Model.Livre;

public class DAOLivre implements IDAOLivre{

	private Connection myconnect;
	private Statement mystate;
	private ResultSet myresult;
	private String myrequest;

	/////////////////////////////////////////////////////////////////

	public void connect() {
		myconnect = ConnectToBDD.getConnectToBDD();

		try {
			mystate = myconnect.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/////////////////////////////////////////////////////////////////

	public void disconnect() {
		try {
			if (myresult != null) {
				myresult.close();
			}
			mystate.close();
			myconnect.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/////////////////////////////////////////////////////////////////

	public ArrayList<Livre> getAll() {
		connect();
		
		ArrayList<Livre> myarray=new ArrayList<Livre>();
		
		myrequest="select livre.isbn, livre.titre_livre, livre.sous_titre_livre, livre.id_categorie, categorie.nom_categorie, auteur.id_personne, personne.nom_personne, personne.prenom_personne, auteur.id_auteur, auteur.date_naissance, livre.est_disponible from livre join categorie ON categorie.id_categorie  = livre.id_categorie JOIN auteur ON livre.id_auteur= auteur.id_auteur JOIN personne ON personne.id_personne = auteur.id_personne;";
		
		try {
			myresult=mystate.executeQuery(myrequest);
			
			while(myresult.next()){
				long isbn=myresult.getLong("isbn");
				String titre=myresult.getString("titre_livre");
				String sous_titre="";
				if(myresult.getString("sous_titre_livre")!=null){
					sous_titre=myresult.getString("sous_titre_livre");
				}
				
				Categorie mycategorie=null;
				if(myresult.getInt("id_categorie")!=1){
					int idC=myresult.getInt("id_categorie");
					String nomC=myresult.getString("nom_categorie");
					
					mycategorie=new Categorie(idC, nomC);
				}
				
				Auteur myauteur=null;
				int idP=myresult.getInt("id_personne");
				String nomP=myresult.getString("nom_personne");
				String prenomP=myresult.getString("prenom_personne");
				int idAu=myresult.getInt("id_auteur");
				String dateN=myresult.getString("date_naissance");
				
				myauteur=new Auteur(idP, nomP, prenomP, idAu, dateN);
				
				String strIsDispo=myresult.getString("est_disponible");
				boolean isDispo=false;
				if("1".equals(strIsDispo)){
					isDispo=true;
				}
				
				Livre mylivre=new Livre(isbn, titre, sous_titre, mycategorie, myauteur, isDispo);
				
				myarray.add(mylivre);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		disconnect();
		
		if (myarray.isEmpty()) {
			myarray = null;
		}

		return myarray;
	}

	/////////////////////////////////////////////////////////////////

	public void add(long isbn, String titre, String sous_titre, int id_categorie, int id_auteur, int isDispo) {
		connect();
		
		myrequest="insert into livre(isbn, titre_livre, sous_titre_livre, id_categorie, id_auteur, est_disponible) values("+isbn+",'"+titre+"','"+sous_titre+"',"+id_categorie+","+id_auteur+","+isDispo+");";
		
		try {
			mystate.executeUpdate(myrequest);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		disconnect();
	}

	/////////////////////////////////////////////////////////////////

	public void update(long isbn, String new_titre, String new_sous_titre, int new_id_categorie, int new_id_auteur, int isDispo) {
		connect();
		
		myrequest="update livre set titre_livre='"+new_titre+"', sous_titre_livre='"+new_sous_titre+"', id_categorie="+new_id_categorie+", id_auteur="+new_id_auteur+", est_disponible="+isDispo+" where isbn="+isbn+";";
		
		try {
			mystate.executeUpdate(myrequest);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		disconnect();
	}

	/////////////////////////////////////////////////////////////////

	public void remove(long isbn) {
		connect();
		
		myrequest="delete from livre where isbn="+isbn+";";
		
		try {
			mystate.executeUpdate(myrequest);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		disconnect();
	}
	
}
