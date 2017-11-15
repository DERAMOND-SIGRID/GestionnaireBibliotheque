package fr.afpa.GestionnaireBibliothequeGitHubSigrid.UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel myMenu;
	private JPanel myDesktop;
	
	private JButton myBtAccueil=new JButton();
	private JButton myBtCategorie=new JButton();
	private JButton myBtAuteur=new JButton();
	private JButton myBtLivre=new JButton();
	private JButton myBtAdherent=new JButton();
	private JButton myBtEmprunt=new JButton();
	private JButton myBtReparation=new JButton();

	//////////////////////////////////////////////////////

	public MainFrame() {
		this.setTitle("Gestionnaire de Bibliothèque");
		this.setSize(1024, 768);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		JPanel myGlobalPane = (JPanel) this.getContentPane();
		myGlobalPane.setBackground(Color.GRAY);
		myGlobalPane.setLayout(null);

		myMenu = new JPanel();
		myMenu.setOpaque(false);
		myMenu.setLayout(null);
		myMenu.setBounds(0, 0, 1018, 30);

		myGlobalPane.add(myMenu);

		this.myDesktop = new JPanel();
		myDesktop.setOpaque(false);
		myDesktop.setBorder(BorderFactory.createLineBorder(new Color(220, 220, 220)));
		myDesktop.setLayout(new BorderLayout());
		myDesktop.setBounds(10, 40, 998, 690);

		myGlobalPane.add(myDesktop);

		initMenu();
	}

	//////////////////////////////////////////////////////

	private void initMenu(){
		myBtAccueil.setText("Accueil");
		myBtAccueil.setBounds(0, 0, 146, 30);
		myBtAccueil.setEnabled(false);
		myBtAccueil.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				myBtAccueil.setEnabled(false);
				myBtCategorie.setEnabled(true);
				myBtAuteur.setEnabled(true);
				myBtLivre.setEnabled(true);
				myBtAdherent.setEnabled(true);
				myBtEmprunt.setEnabled(true);
				myBtReparation.setEnabled(true);
			}
			
		});
		
		myMenu.add(myBtAccueil);
		
		myBtCategorie.setText("Catégories");
		myBtCategorie.setBounds(146, 0, 146, 30);
		myBtCategorie.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				myBtAccueil.setEnabled(true);
				myBtCategorie.setEnabled(false);
				myBtAuteur.setEnabled(true);
				myBtLivre.setEnabled(true);
				myBtAdherent.setEnabled(true);
				myBtEmprunt.setEnabled(true);
				myBtReparation.setEnabled(true);
			}
			
		});
		
		myMenu.add(myBtCategorie);
		
		myBtAuteur.setText("Auteurs");
		myBtAuteur.setBounds(292, 0, 146, 30);
		myBtAuteur.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				myBtAccueil.setEnabled(true);
				myBtCategorie.setEnabled(true);
				myBtAuteur.setEnabled(false);
				myBtLivre.setEnabled(true);
				myBtAdherent.setEnabled(true);
				myBtEmprunt.setEnabled(true);
				myBtReparation.setEnabled(true);
			}
			
		});
		
		myMenu.add(myBtAuteur);
		
		myBtLivre.setText("Livres");
		myBtLivre.setBounds(438, 0, 146, 30);
		myBtLivre.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				myBtAccueil.setEnabled(true);
				myBtCategorie.setEnabled(true);
				myBtAuteur.setEnabled(true);
				myBtLivre.setEnabled(false);
				myBtAdherent.setEnabled(true);
				myBtEmprunt.setEnabled(true);
				myBtReparation.setEnabled(true);
			}
			
		});
		
		myMenu.add(myBtLivre);
		
		myBtAdherent.setText("Adhérents");
		myBtAdherent.setBounds(584, 0, 146, 30);
		myBtAdherent.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				myBtAccueil.setEnabled(true);
				myBtCategorie.setEnabled(true);
				myBtAuteur.setEnabled(true);
				myBtLivre.setEnabled(true);
				myBtAdherent.setEnabled(false);
				myBtEmprunt.setEnabled(true);
				myBtReparation.setEnabled(true);
			}
			
		});
		
		myMenu.add(myBtAdherent);
		
		myBtEmprunt.setText("Emprunts");
		myBtEmprunt.setBounds(730, 0, 146, 30);
		myBtEmprunt.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				myBtAccueil.setEnabled(true);
				myBtCategorie.setEnabled(true);
				myBtAuteur.setEnabled(true);
				myBtLivre.setEnabled(true);
				myBtAdherent.setEnabled(true);
				myBtEmprunt.setEnabled(false);
				myBtReparation.setEnabled(true);
			}
			
		});
		
		myMenu.add(myBtEmprunt);
		
		myBtReparation.setText("Réparations");
		myBtReparation.setBounds(876, 0, 142, 30);
		myBtReparation.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				myBtAccueil.setEnabled(true);
				myBtCategorie.setEnabled(true);
				myBtAuteur.setEnabled(true);
				myBtLivre.setEnabled(true);
				myBtAdherent.setEnabled(true);
				myBtEmprunt.setEnabled(true);
				myBtReparation.setEnabled(false);
			}
			
		});
		
		myMenu.add(myBtReparation);
	}
	
	//////////////////////////////////////////////////////

	public JPanel getDesktopContainer() {
		return myDesktop;
	}

}
