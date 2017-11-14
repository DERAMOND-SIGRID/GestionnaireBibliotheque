package fr.afpa.GestionnaireBibliothequeGitHubSigrid.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import fr.afpa.GestionnaireBibliothequeGitHubSigrid.DAOConnect.ConnectToBDD;
import fr.afpa.GestionnaireBibliothequeGitHubSigrid.Model.Auteur;

public class DAOAuteur implements IDAOAuteur{

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
			if(myresult!=null){
				myresult.close();
			}
			mystate.close();
			myconnect.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/////////////////////////////////////////////////////////////////

	public ArrayList<Auteur> getAll() {
		connect();

		ArrayList<Auteur> myarray = new ArrayList<Auteur>();

		myrequest = "select personne.id_personne, nom_personne, prenom_personne, id_auteur, date_naissance from personne,auteur where auteur.id_personne=personne.id_personne;";

		try {
			myresult = mystate.executeQuery(myrequest);

			while (myresult.next()) {
				int idP = myresult.getInt("id_personne");
				String nom =myresult.getString("nom_personne");
				String prenom=myresult.getString("prenom_personne");
				int idAu = myresult.getInt("id_auteur");
				String dateN = myresult.getString("date_naissance");
				
				Auteur myauteur = new Auteur(idP, nom, prenom, idAu, dateN);

				myarray.add(myauteur);
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

	public void add(String nom, String prenom, String dateNaissance) {
		connect();

		myrequest = "insert into personne(nom_personne, prenom_personne) values('"+nom+"','"+prenom+"');";

		int idP=0;
		
		try {
			mystate.executeUpdate(myrequest, Statement.RETURN_GENERATED_KEYS);
			
			myresult = mystate.getGeneratedKeys();
			
            if(myresult.next())
            {
            	idP = myresult.getInt(1);
            	
            	myrequest="insert into auteur(id_personne, date_naissance) values("+idP+",'"+dateNaissance+"');";
            	
            	mystate.executeUpdate(myrequest);
            }

		} catch (SQLException e) {
			e.printStackTrace();
		}

		disconnect();
	}

	/////////////////////////////////////////////////////////////////

	public void update(int id_auteur, String newNom, String newPrenom, String newDateNaissance) {
		connect();

		myrequest = "update personne,auteur set nom_personne='"+newNom+"',prenom_personne='"+newPrenom+"',date_naissance='" + newDateNaissance + "' where id_auteur=" + id_auteur + " and auteur.id_personne=personne.id_personne;";

		try {
			mystate.executeUpdate(myrequest);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		disconnect();
	}

	/////////////////////////////////////////////////////////////////

	public void remove(int id_auteur) {
		connect();
		
		myrequest="delete from auteur where id_auteur="+id_auteur+";";
		
		try {
			mystate.executeUpdate(myrequest);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		disconnect();
	}
	
}
