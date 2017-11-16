package fr.afpa.GestionnaireBibliothequeGitHubSigrid.UI;

import java.awt.Color;
import java.awt.Font;


import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelPopup extends JPanel {

	private static final long serialVersionUID = 1L;

	private JLabel myLbl;

	public PanelPopup() {
		this.setOpaque(false);
		this.setLayout(null);

		this.myLbl = new JLabel();
		myLbl.setBounds(0, 290, 997, 30);
		myLbl.setText("POPUP");
		myLbl.setFont(new Font("Times New Roman", Font.BOLD, 30));
		myLbl.setForeground(Color.BLACK);
		myLbl.setHorizontalAlignment(JLabel.CENTER);

		this.add(myLbl);
		
	}

	public JLabel getLbl() {
		return myLbl;
	}
	
}
