package fr.afpa.GestionnaireBibliothequeGitHubSigrid.DAOConnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectToBDD {

	public static Connection getConnectToBDD(){
		Connection myConnect=null;
		
		//Load Driver
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		//url BDD
		String urlBDD="jdbc:mysql://localhost:3306/bibliotheque?serverTimezone=UTC";
		
		//count name BDD
		String countNameBDD="root";
		
		//password count BDD
		String passwordBDD="sigrid";
		
		//Connection
		try {
			myConnect=DriverManager.getConnection(urlBDD, countNameBDD, passwordBDD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return myConnect;
		
	}
	
}
