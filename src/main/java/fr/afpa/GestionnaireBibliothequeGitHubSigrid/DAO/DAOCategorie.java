package fr.afpa.GestionnaireBibliothequeGitHubSigrid.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import fr.afpa.GestionnaireBibliothequeGitHubSigrid.DAOConnect.ConnectToBDD;
import fr.afpa.GestionnaireBibliothequeGitHubSigrid.Model.Categorie;

public class DAOCategorie implements IDAOCategorie {

	private Connection myconnect;
	private Statement mystate;
	private ResultSet myresult;
	private String myrequest;

	/////////////////////////////////////////////////////////////////

	private void connect() {
		myconnect = ConnectToBDD.getConnectToBDD();

		try {
			mystate = myconnect.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/////////////////////////////////////////////////////////////////

	private void disconnect() {
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

	public ArrayList<Categorie> getAll() {
		connect();

		ArrayList<Categorie> myarray = new ArrayList<Categorie>();

		myrequest = "select * from categorie;";

		try {
			myresult = mystate.executeQuery(myrequest);

			while (myresult.next()) {
				int idC = myresult.getInt("id_categorie");
				String nomC = myresult.getString("nom_categorie");

				Categorie mycategorie = new Categorie(idC, nomC);

				myarray.add(mycategorie);
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

	public Categorie getOneById(int id_categorie) {
		connect();
		
		Categorie mycategorie=null;
		
		myrequest="select nom_categorie from categorie where id_categorie="+id_categorie+";";
		
		try {
			myresult = mystate.executeQuery(myrequest);

			while (myresult.next()) {
				String nomC=myresult.getString("nom_categorie");
				
				mycategorie=new Categorie(id_categorie, nomC);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		disconnect();
		
		return mycategorie;
	}
	
	/////////////////////////////////////////////////////////////////

	public Categorie getOneByInfo(String nom_categorie) {
		connect();
		
		Categorie mycategorie=null;
		
		myrequest="select id_categorie from categorie where nom_categorie='"+nom_categorie+"';";
		
		try {
			myresult = mystate.executeQuery(myrequest);

			while (myresult.next()) {
				int idC=myresult.getInt("id_categorie");
				
				mycategorie=new Categorie(idC, nom_categorie);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		disconnect();
		
		return mycategorie;
	}
	
	/////////////////////////////////////////////////////////////////

	public void add(String nom_categorie) {
		connect();

		myrequest = "insert into categorie(nom_categorie) values('" + nom_categorie + "');";

		try {
			mystate.executeUpdate(myrequest);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		disconnect();

	}

	/////////////////////////////////////////////////////////////////

	public void update(int id_categorie, String newName) {
		connect();

		myrequest = "update categorie set nom_categorie='" + newName + "' where id_categorie=" + id_categorie
				+ ";";

		try {
			mystate.executeUpdate(myrequest);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		disconnect();

	}

	/////////////////////////////////////////////////////////////////

	public void remove(int id_categorie) {
		connect();

		myrequest = "delete from categorie where id_categorie=" + id_categorie + ";";

		try {
			mystate.executeUpdate(myrequest);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		disconnect();

	}
}
