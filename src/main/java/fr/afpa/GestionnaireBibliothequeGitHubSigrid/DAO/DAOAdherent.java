package fr.afpa.GestionnaireBibliothequeGitHubSigrid.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import fr.afpa.GestionnaireBibliothequeGitHubSigrid.DAOConnect.ConnectToBDD;
import fr.afpa.GestionnaireBibliothequeGitHubSigrid.Model.Adherent;
import fr.afpa.GestionnaireBibliothequeGitHubSigrid.Model.Auteur;

public class DAOAdherent implements IDAOAdherent{

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

	public ArrayList<Adherent> getAll() {
		connect();

		ArrayList<Adherent> myarray = new ArrayList<Adherent>();

		myrequest = "select personne.id_personne, nom_personne, prenom_personne, id_adherent, nb_emprunt_max from personne,adherent where adherent.id_personne=personne.id_personne;";

		try {
			myresult = mystate.executeQuery(myrequest);

			while (myresult.next()) {
				int idP = myresult.getInt("id_personne");
				String nom =myresult.getString("nom_personne");
				String prenom=myresult.getString("prenom_personne");
				int idAd = myresult.getInt("id_adherent");
				int nbEmpruntMax = myresult.getInt("nb_emprunt_max");

				Adherent myadherent = new Adherent(idP, nom, prenom, idAd, nbEmpruntMax);

				myarray.add(myadherent);
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
	
	public Adherent getOneById(int id_adherent){
		connect();
		
		Adherent myadherent=null;
		
		myrequest="select personne.id_personne, nom_personne, prenom_personne, nb_emprunt_max from personne, adherent where personne.id_personne=adherent.id_personne and adherent.id_adherent="+id_adherent+";";
		
		try {
			myresult = mystate.executeQuery(myrequest);

			while (myresult.next()) {
				int idP=myresult.getInt("personne.id_personne");
				String nom=myresult.getString("nom_personne");
				String prenom=myresult.getString("prenom_personne");
				int nbEmpruntMax=myresult.getInt("nb_emprunt_max");;
				
				myadherent=new Adherent(idP, nom, prenom, id_adherent, nbEmpruntMax);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		disconnect();
		
		return myadherent;
	}
	
	/////////////////////////////////////////////////////////////////
	
	public Adherent getOneByInfo(String nom, String prenom){
		connect();
		
		Adherent myadherent=null;
		
		myrequest="select personne.id_personne, adherent.id_adherent, nb_emprunt_max from personne, adherent where personne.id_personne=adherent.id_personne and nom_personne='"+nom+"' and prenom_personne='"+prenom+"';";
		
		try {
			myresult = mystate.executeQuery(myrequest);

			while (myresult.next()) {
				int idP=myresult.getInt("personne.id_personne");
				int idAd=myresult.getInt("adherent.id_adherent");
				int nbEmpruntMax=myresult.getInt("nb_emprunt_max");;
				
				myadherent=new Adherent(idP, nom, prenom, idAd, nbEmpruntMax);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		disconnect();
		
		return myadherent;
	}
	
	/////////////////////////////////////////////////////////////////

	public void add(String nom, String prenom,int nbEmpruntMax) {
		connect();

		myrequest = "insert into personne(nom_personne, prenom_personne) values('"+nom+"','"+prenom+"');";
		
		int idP=0;

		try {
			mystate.executeUpdate(myrequest, Statement.RETURN_GENERATED_KEYS);
			
			myresult = mystate.getGeneratedKeys();
			
            if(myresult.next())
            {
            	idP = myresult.getInt(1);
            	
            	myrequest="insert into adherent(id_personne, nb_emprunt_max) values("+idP+",'"+nbEmpruntMax+"');";
            	
            	mystate.executeUpdate(myrequest);
            }

		} catch (SQLException e) {
			e.printStackTrace();
		}

		disconnect();
	}

	/////////////////////////////////////////////////////////////////

	public void update(int id_adherent, String newNom, String newPrenom, int newNbEmpruntMax) {
		connect();

		myrequest = "update personne,adherent set nom_personne='"+newNom+"',prenom_personne='"+newPrenom+"',nb_emprunt_max=" + newNbEmpruntMax + " where id_adherent=" + id_adherent + " and adherent.id_personne=personne.id_personne;";

		try {
			mystate.executeUpdate(myrequest);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		disconnect();
	}

	/////////////////////////////////////////////////////////////////

	public void remove(int id_adherent) {
		connect();

		String myrequest = "delete from adherent where id_adherent=" + id_adherent + ";";

		try {
			mystate.executeUpdate(myrequest);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		disconnect();
	}
	
}
