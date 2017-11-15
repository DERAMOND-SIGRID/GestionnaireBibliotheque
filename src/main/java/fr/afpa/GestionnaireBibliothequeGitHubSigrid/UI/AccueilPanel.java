package fr.afpa.GestionnaireBibliothequeGitHubSigrid.UI;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class AccueilPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	public AccueilPanel() {
		this.setOpaque(false);
		this.setLayout(null);

		JLabel myLbl = new JLabel();
		myLbl.setBounds(0, 315, 998, 60);
		myLbl.setText("Bienvenue");
		myLbl.setFont(new Font("Times New Roman", Font.BOLD, 60));
		myLbl.setForeground(Color.BLACK);
		myLbl.setHorizontalAlignment(JLabel.CENTER);

		this.add(myLbl);

	}

}
