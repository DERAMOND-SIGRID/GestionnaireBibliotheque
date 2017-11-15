package fr.afpa.GestionnaireBibliothequeGitHubSigrid.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import fr.afpa.GestionnaireBibliothequeGitHubSigrid.DAOConnect.ConnectToBDD;
import fr.afpa.GestionnaireBibliothequeGitHubSigrid.Model.Adherent;
import fr.afpa.GestionnaireBibliothequeGitHubSigrid.Model.Auteur;
import fr.afpa.GestionnaireBibliothequeGitHubSigrid.Model.Categorie;
import fr.afpa.GestionnaireBibliothequeGitHubSigrid.Model.Exemplaire;
import fr.afpa.GestionnaireBibliothequeGitHubSigrid.Model.Livre;

public class DAOExemplaire implements IDAOExemplaire {

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

	public ArrayList<Exemplaire> getAll() {
		connect();

		ArrayList<Exemplaire> myarray = new ArrayList<Exemplaire>();

		myrequest = "select id_exemplaire,isbn_livre, livre.titre_livre, livre.sous_titre_livre, livre.id_categorie, categorie.nom_categorie, auteur.id_personne, personneAu.nom_personne, personneAu.prenom_personne, auteur.id_auteur, auteur.date_naissance, livre.est_disponible, adherent.id_personne, personneAd.nom_personne, personneAd.prenom_personne, adherent.id_adherent, adherent.nb_emprunt_max, is_in_repair, exemplaire.est_disponible from exemplaire, livre, categorie, auteur, adherent, personne as personneAu, personne as personneAd where isbn_livre=livre.isbn and livre.id_categorie = categorie.id_categorie and livre.id_auteur= auteur.id_auteur and auteur.id_personne=personneAu.id_personne and exemplaire.id_adherent=adherent.id_adherent and adherent.id_personne=personneAd.id_personne order by id_exemplaire;";

		try {
			myresult = mystate.executeQuery(myrequest);

			while (myresult.next()) {
				int idE=myresult.getInt("id_exemplaire");
				
				Categorie mycategorie = null;

				if (myresult.getInt("id_categorie") != 1) {
					int idC = myresult.getInt("id_categorie");
					String nomC = myresult.getString("nom_categorie");

					mycategorie = new Categorie(idC, nomC);
				}

				Auteur myauteur = null;

				int idAuP = myresult.getInt("id_personne");
				String nomAuP = myresult.getString("personneAu.nom_personne");
				String prenomAuP = myresult.getString("personneAu.prenom_personne");
				int idAu = myresult.getInt("id_auteur");
				String dateN = myresult.getString("date_naissance");

				myauteur = new Auteur(idAuP, nomAuP, prenomAuP, idAu, dateN);

				Livre mylivre = null;

				long isbn = myresult.getLong("isbn_livre");
				String titre = myresult.getString("titre_livre");
				String sous_titre = "";
				if (myresult.getString("sous_titre_livre") != null) {
					sous_titre = myresult.getString("sous_titre_livre");
				}

				String strIsDispoL = myresult.getString("est_disponible");
				boolean isDispoL = false;
				if ("1".equals(strIsDispoL)) {
					isDispoL = true;
				}

				mylivre = new Livre(isbn, titre, sous_titre, mycategorie, myauteur, isDispoL);

				Adherent myadherent = null;
				
				int idAdP=myresult.getInt("adherent.id_personne");
				String nomAdP=myresult.getString("personneAd.nom_personne");
				String prenomAdP=myresult.getString("personneAd.prenom_personne");
				int idAd=myresult.getInt("adherent.id_adherent");
				int nbEmpruntMax=myresult.getInt("adherent.nb_emprunt_max");
				
				myadherent=new Adherent(idAdP, nomAdP, prenomAdP, idAd, nbEmpruntMax);

				String strIsInRepair="";
				boolean isInRepair=false;
				if("1".equals(strIsInRepair)) {
					isInRepair=true;
				}
				
				String strIsDispoE="";
				boolean isDispoE=false;
				if("1".equals(strIsDispoE)) {
					isDispoE=true;
				}
				
				Exemplaire myexemplaire = new Exemplaire(idE, mylivre, myadherent, isInRepair, isDispoE);
				
				myarray.add(myexemplaire);
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
	
	public Exemplaire getOneById(int id_exemplaire){
		connect();
		
		Categorie mycategorie=null;
		Auteur myauteur=null;
		Livre mylivre=null;
		Adherent myadherent=null;
		Exemplaire myexemplaire=null;
		
		myrequest = "select isbn_livre, livre.titre_livre, livre.sous_titre_livre, livre.id_categorie, categorie.nom_categorie, auteur.id_personne, personneAu.nom_personne, personneAu.prenom_personne, auteur.id_auteur, auteur.date_naissance, livre.est_disponible, adherent.id_personne, personneAd.nom_personne, personneAd.prenom_personne, adherent.id_adherent, adherent.nb_emprunt_max, is_in_repair, exemplaire.est_disponible from exemplaire, livre, categorie, auteur, adherent, personne as personneAu, personne as personneAd where isbn_livre=livre.isbn and livre.id_categorie = categorie.id_categorie and livre.id_auteur= auteur.id_auteur and auteur.id_personne=personneAu.id_personne and exemplaire.id_adherent=adherent.id_adherent and adherent.id_personne=personneAd.id_personne and id_exemplaire="+id_exemplaire+";";
		
		try {
			myresult = mystate.executeQuery(myrequest);

			while (myresult.next()) {
				if (myresult.getInt("id_categorie") != 1) {
					int idC = myresult.getInt("id_categorie");
					String nomC = myresult.getString("nom_categorie");

					mycategorie = new Categorie(idC, nomC);
				}

				int idAuP = myresult.getInt("id_personne");
				String nomAuP = myresult.getString("personneAu.nom_personne");
				String prenomAuP = myresult.getString("personneAu.prenom_personne");
				int idAu = myresult.getInt("id_auteur");
				String dateN = myresult.getString("date_naissance");

				myauteur = new Auteur(idAuP, nomAuP, prenomAuP, idAu, dateN);

				long isbn = myresult.getLong("isbn_livre");
				String titre = myresult.getString("titre_livre");
				String sous_titre = "";
				if (myresult.getString("sous_titre_livre") != null) {
					sous_titre = myresult.getString("sous_titre_livre");
				}

				String strIsDispoL = myresult.getString("est_disponible");
				boolean isDispoL = false;
				if ("1".equals(strIsDispoL)) {
					isDispoL = true;
				}

				mylivre = new Livre(isbn, titre, sous_titre, mycategorie, myauteur, isDispoL);

				int idAdP=myresult.getInt("adherent.id_personne");
				String nomAdP=myresult.getString("personneAd.nom_personne");
				String prenomAdP=myresult.getString("personneAd.prenom_personne");
				int idAd=myresult.getInt("adherent.id_adherent");
				int nbEmpruntMax=myresult.getInt("adherent.nb_emprunt_max");
				
				myadherent=new Adherent(idAdP, nomAdP, prenomAdP, idAd, nbEmpruntMax);

				String strIsInRepair="";
				boolean isInRepair=false;
				if("1".equals(strIsInRepair)) {
					isInRepair=true;
				}
				
				String strIsDispoE="";
				boolean isDispoE=false;
				if("1".equals(strIsDispoE)) {
					isDispoE=true;
				}
				
				myexemplaire = new Exemplaire(id_exemplaire, mylivre, myadherent, isInRepair, isDispoE);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		disconnect();
		
		return myexemplaire;
	}
	
	/////////////////////////////////////////////////////////////////
	
	public Exemplaire getOneByInfo(long isbn){
		connect();
		
		Categorie mycategorie=null;
		Auteur myauteur=null;
		Livre mylivre=null;
		Adherent myadherent=null;
		Exemplaire myexemplaire=null;
		
		myrequest = "select id_exemplaire, livre.titre_livre, livre.sous_titre_livre, livre.id_categorie, categorie.nom_categorie, auteur.id_personne, personneAu.nom_personne, personneAu.prenom_personne, auteur.id_auteur, auteur.date_naissance, livre.est_disponible, adherent.id_personne, personneAd.nom_personne, personneAd.prenom_personne, adherent.id_adherent, adherent.nb_emprunt_max, is_in_repair, exemplaire.est_disponible from exemplaire, livre, categorie, auteur, adherent, personne as personneAu, personne as personneAd where isbn_livre=livre.isbn and livre.id_categorie = categorie.id_categorie and livre.id_auteur= auteur.id_auteur and auteur.id_personne=personneAu.id_personne and exemplaire.id_adherent=adherent.id_adherent and adherent.id_personne=personneAd.id_personne and isbn_livre="+isbn+";";
		
		try {
			myresult = mystate.executeQuery(myrequest);

			while (myresult.next()) {
				int idE=myresult.getInt("id_exemplaire");
	
				if (myresult.getInt("id_categorie") != 1) {
					int idC = myresult.getInt("id_categorie");
					String nomC = myresult.getString("nom_categorie");

					mycategorie = new Categorie(idC, nomC);
				}

				int idAuP = myresult.getInt("id_personne");
				String nomAuP = myresult.getString("personneAu.nom_personne");
				String prenomAuP = myresult.getString("personneAu.prenom_personne");
				int idAu = myresult.getInt("id_auteur");
				String dateN = myresult.getString("date_naissance");

				myauteur = new Auteur(idAuP, nomAuP, prenomAuP, idAu, dateN);

				String titre = myresult.getString("titre_livre");
				String sous_titre = "";
				if (myresult.getString("sous_titre_livre") != null) {
					sous_titre = myresult.getString("sous_titre_livre");
				}

				String strIsDispoL = myresult.getString("est_disponible");
				boolean isDispoL = false;
				if ("1".equals(strIsDispoL)) {
					isDispoL = true;
				}

				mylivre = new Livre(isbn, titre, sous_titre, mycategorie, myauteur, isDispoL);

				int idAdP=myresult.getInt("adherent.id_personne");
				String nomAdP=myresult.getString("personneAd.nom_personne");
				String prenomAdP=myresult.getString("personneAd.prenom_personne");
				int idAd=myresult.getInt("adherent.id_adherent");
				int nbEmpruntMax=myresult.getInt("adherent.nb_emprunt_max");
				
				myadherent=new Adherent(idAdP, nomAdP, prenomAdP, idAd, nbEmpruntMax);

				String strIsInRepair="";
				boolean isInRepair=false;
				if("1".equals(strIsInRepair)) {
					isInRepair=true;
				}
				
				String strIsDispoE="";
				boolean isDispoE=false;
				if("1".equals(strIsDispoE)) {
					isDispoE=true;
				}
				
				myexemplaire = new Exemplaire(idE, mylivre, myadherent, isInRepair, isDispoE);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		disconnect();
		
		return myexemplaire;
	}
	
	/////////////////////////////////////////////////////////////////

	public void add(long isbn) {
		connect();
		
		myrequest="insert into exemplaire(isbn_livre, id_adherent, is_in_repair, est_disponible) values("+isbn+", 1, 0, 1);";
		
		try {
			mystate.executeUpdate(myrequest);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		disconnect();
	}

	/////////////////////////////////////////////////////////////////

	public void updateEmprunter(int id_exemplaire, int id_adherent) {
		connect();
		
		myrequest="update exemplaire set id_adherent="+id_adherent+", est_disponible=0 where id_exemplaire="+id_exemplaire+";";
		
		try {
			mystate.executeUpdate(myrequest);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		disconnect();
	}

	/////////////////////////////////////////////////////////////////
	
	public void updateAReparer(int id_exemplaire){
		connect();
		
		myrequest="update exemplaire set is_in_repair=1, est_disponible=0 where id_exemplaire="+id_exemplaire+";";
		
		try {
			mystate.executeUpdate(myrequest);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		disconnect();
	}
	
	/////////////////////////////////////////////////////////////////
	
	public void updateRendre(int id_exemplaire){
		connect();
		
		myrequest="update exemplaire set id_adherent=1, is_in_repair=0, est_disponible=1 where id_exemplaire="+id_exemplaire+";";
		
		try {
			mystate.executeUpdate(myrequest);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		disconnect();
	}
	
	/////////////////////////////////////////////////////////////////

	public void remove(int id_exemplaire) {
		connect();
		
		myrequest="delete from exemplaire where id_exemplaire="+id_exemplaire+";";
		
		try {
			mystate.executeUpdate(myrequest);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		disconnect();
	}

}
