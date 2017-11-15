package fr.afpa.GestionnaireBibliothequeGitHubSigrid.UI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class EditPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private JLabel myLblCategorie;
	private JTextField myTxtCategorie;

	private JLabel myLblAuteur;
	private JTextField myTxtNomAuteur;
	private JTextField myTxtPrenomAuteur;
	private JTextField myTxtJJAuteur;
	private JTextField myTxtMMAuteur;
	private JTextField myTxtAAAAAuteur;

	private JLabel myLblLivre;
	private JTextField myTxtISBNLivre;
	private JTextField myTxtTitreLivre;
	private JTextField myTxtSousTitreLivre;
	private JTextField myTxtAuteurLivre;
	private JComboBox<Object> myComboBoxLivreC;

	private JLabel myLblAdherent;
	private JTextField myTxtNomAdherent;
	private JTextField myTxtPrenomAdherent;

	private JLabel myLblAEmprunt;
	private JComboBox<Object> myComboBoxEmpruntL;
	private JComboBox<Object> myComboBoxEmpruntE;
	private JComboBox<Object> myComboBoxEmpruntAd;

	private JLabel myLblREmprunt;
	private JTextField myTxtEmpruntL;
	private JTextField myTxtEmpruntE;
	private JTextField myTxtEmpruntAd;

	private JLabel myLblARepair;
	private JComboBox<Object> myComboBoxRepairL;
	private JComboBox<Object> myComboBoxRepairE;
	
	private JLabel myLblRRepair;
	private JTextField myTxtRepairL;
	private JTextField myTxtRepairE;

	private JButton myBtValider;
	private JLabel myLblPopup;

	////////////////////////////////////////////////////////////////////////
	
	public EditPanel() {
		this.setOpaque(false);
		this.setLayout(null);

		myBtValider = new JButton();
		myBtValider.setBounds(867, 310, 121, 29);
		myBtValider.setText("Valider");

		this.add(myBtValider);

		myLblPopup = new JLabel();
		myLblPopup.setBounds(10, 350, 847, 30);
		myLblPopup.setHorizontalAlignment(JLabel.CENTER);

		this.add(myLblPopup);

		JButton myBtCancel = new JButton();
		myBtCancel.setBounds(867, 350, 121, 29);
		myBtCancel.setText("Annuler");
		myBtCancel.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

			}
		});

		this.add(myBtCancel);

		//init txtField in function of the event

	}

	////////////////////////////////////////////////////////////////////////
	
	private void initTextFieldCategorie() {
		this.myLblCategorie = new JLabel();
		myLblCategorie.setText("Add / Edit / Remove Catégorie :");
		myLblCategorie.setBounds(10, 270, 978, 30);
		myLblCategorie.setHorizontalAlignment(JLabel.CENTER);

		this.add(myLblCategorie);

		myTxtCategorie = new JTextField();
		myTxtCategorie.setBounds(10, 310, 847, 30);
		myTxtCategorie.setHorizontalAlignment(JTextField.CENTER);
		myTxtCategorie.setText("Entrez une catégorie ex: roman bd manga");

		this.add(myTxtCategorie);
	}

	////////////////////////////////////////////////////////////////////////
	
	private void initTextFieldAuteur() {
		this.myLblAuteur = new JLabel();
		myLblAuteur.setText("Add / Edit / Remove Auteur :");
		myLblAuteur.setBounds(10, 270, 978, 30);
		myLblAuteur.setHorizontalAlignment(JLabel.CENTER);

		this.add(myLblAuteur);

		myTxtNomAuteur = new JTextField();
		myTxtNomAuteur.setBounds(10, 310, 328, 30);
		myTxtNomAuteur.setHorizontalAlignment(JTextField.CENTER);
		myTxtNomAuteur.setText("Nom");

		this.add(myTxtNomAuteur);

		myTxtPrenomAuteur = new JTextField();
		myTxtPrenomAuteur.setBounds(349, 310, 328, 30);
		myTxtPrenomAuteur.setHorizontalAlignment(JTextField.CENTER);
		myTxtPrenomAuteur.setText("Prénom");

		this.add(myTxtPrenomAuteur);

		myTxtJJAuteur = new JTextField();
		myTxtJJAuteur.setBounds(687, 310, 50, 30);
		myTxtJJAuteur.setHorizontalAlignment(JTextField.CENTER);
		myTxtJJAuteur.setText("JJ");

		this.add(myTxtJJAuteur);

		myTxtMMAuteur = new JTextField();
		myTxtMMAuteur.setBounds(747, 310, 50, 30);
		myTxtMMAuteur.setHorizontalAlignment(JTextField.CENTER);
		myTxtMMAuteur.setText("MM");

		this.add(myTxtMMAuteur);

		myTxtAAAAAuteur = new JTextField();
		myTxtAAAAAuteur.setBounds(807, 310, 50, 30);
		myTxtAAAAAuteur.setHorizontalAlignment(JTextField.CENTER);
		myTxtAAAAAuteur.setText("AAAA");

		this.add(myTxtAAAAAuteur);
	}

	////////////////////////////////////////////////////////////////////////
	
	private void initTextFieldLivre() {
		this.myLblLivre = new JLabel();
		myLblLivre.setText("Add / Edit / Remove Livre :");
		myLblLivre.setBounds(10, 270, 978, 30);
		myLblLivre.setHorizontalAlignment(JLabel.CENTER);

		this.add(myLblLivre);

		myTxtISBNLivre = new JTextField();
		myTxtISBNLivre.setBounds(10, 310, 100, 30);
		myTxtISBNLivre.setHorizontalAlignment(JTextField.CENTER);
		myTxtISBNLivre.setText("ISBN");

		this.add(myTxtISBNLivre);

		myTxtTitreLivre = new JTextField();
		myTxtTitreLivre.setBounds(120, 310, 220, 30);
		myTxtTitreLivre.setHorizontalAlignment(JTextField.CENTER);
		myTxtTitreLivre.setText("Titre");

		this.add(myTxtTitreLivre);

		myTxtSousTitreLivre = new JTextField();
		myTxtSousTitreLivre.setBounds(350, 310, 143, 30);
		myTxtSousTitreLivre.setHorizontalAlignment(JTextField.CENTER);
		myTxtSousTitreLivre.setText("Sous Titre");

		this.add(myTxtSousTitreLivre);

		myTxtAuteurLivre = new JTextField();
		myTxtAuteurLivre.setBounds(503, 310, 220, 30);
		myTxtAuteurLivre.setHorizontalAlignment(JTextField.CENTER);
		myTxtAuteurLivre.setText("Auteur");

		this.add(myTxtAuteurLivre);

		DefaultListCellRenderer dlcr = new DefaultListCellRenderer();
		dlcr.setHorizontalAlignment(JLabel.CENTER);

		myComboBoxLivreC = new JComboBox<Object>();
		myComboBoxLivreC.setRenderer(dlcr);
		myComboBoxLivreC.setBounds(733, 310, 124, 31);
		myComboBoxLivreC.setMaximumRowCount(5);

		this.add(myComboBoxLivreC);

		// init data
		ArrayList<String> comboAuteur = new ArrayList<String>();
		comboAuteur.add("Catégorie");
		myComboBoxLivreC.addItem(comboAuteur.get(0));
	}

	////////////////////////////////////////////////////////////////////////
	
	private void initTextFieldAdherent() {
		this.myLblAdherent = new JLabel();
		myLblAdherent.setText("Add / Edit / Remove Adhérent :");
		myLblAdherent.setBounds(10, 270, 978, 30);
		myLblAdherent.setHorizontalAlignment(JLabel.CENTER);

		this.add(myLblAdherent);

		myTxtNomAdherent = new JTextField();
		myTxtNomAdherent.setBounds(10, 310, 418, 30);
		myTxtNomAdherent.setHorizontalAlignment(JTextField.CENTER);
		myTxtNomAdherent.setText("Nom");

		this.add(myTxtNomAdherent);

		myTxtPrenomAdherent = new JTextField();
		myTxtPrenomAdherent.setBounds(439, 310, 418, 30);
		myTxtPrenomAdherent.setHorizontalAlignment(JTextField.CENTER);
		myTxtPrenomAdherent.setText("Prénom");

		this.add(myTxtPrenomAdherent);
	}

	////////////////////////////////////////////////////////////////////////
	
	private void initTextFielAddEmprunt() {
		this.myLblAEmprunt = new JLabel();
		myLblAEmprunt.setText("Add Emprunt :");
		myLblAEmprunt.setBounds(10, 270, 978, 30);
		myLblAEmprunt.setHorizontalAlignment(JLabel.CENTER);

		this.add(myLblAEmprunt);

		DefaultListCellRenderer dlcr = new DefaultListCellRenderer();
		dlcr.setHorizontalAlignment(JLabel.CENTER);

		myComboBoxEmpruntL = new JComboBox<Object>();
		myComboBoxEmpruntL.setRenderer(dlcr);
		myComboBoxEmpruntL.setBounds(10, 310, 530, 31);
		myComboBoxEmpruntL.setMaximumRowCount(5);

		this.add(myComboBoxEmpruntL);

		myComboBoxEmpruntE = new JComboBox<Object>();
		myComboBoxEmpruntE.setRenderer(dlcr);
		myComboBoxEmpruntE.setBounds(550, 310, 100, 31);
		myComboBoxEmpruntE.setMaximumRowCount(5);

		this.add(myComboBoxEmpruntE);

		myComboBoxEmpruntAd = new JComboBox<Object>();
		myComboBoxEmpruntAd.setRenderer(dlcr);
		myComboBoxEmpruntAd.setBounds(660, 310, 197, 31);
		myComboBoxEmpruntAd.setMaximumRowCount(5);

		this.add(myComboBoxEmpruntAd);

		// init data
		ArrayList<String> comboL = new ArrayList<String>();
		comboL.add("Livre");
		myComboBoxEmpruntL.addItem(comboL.get(0));

		ArrayList<String> comboE = new ArrayList<String>();
		comboE.add("Exempl.");
		myComboBoxEmpruntE.addItem(comboE.get(0));

		ArrayList<String> comboAd = new ArrayList<String>();
		comboAd.add("Adhérent");
		myComboBoxEmpruntAd.addItem(comboAd.get(0));
	}

	////////////////////////////////////////////////////////////////////////
	
	private void initTextFielRemoveEmprunt() {
		this.myLblREmprunt = new JLabel();
		myLblREmprunt.setText("Remove Emprunt :");
		myLblREmprunt.setBounds(10, 270, 978, 30);
		myLblREmprunt.setHorizontalAlignment(JLabel.CENTER);

		this.add(myLblREmprunt);

		myTxtEmpruntL = new JTextField();
		myTxtEmpruntL.setBounds(10, 310, 530, 31);
		myTxtEmpruntL.setText("Livre");
		myTxtEmpruntL.setHorizontalAlignment(JTextField.CENTER);
		myTxtEmpruntL.setEnabled(false);
		myTxtEmpruntL.setDisabledTextColor(Color.BLACK);

		this.add(myTxtEmpruntL);

		myTxtEmpruntE = new JTextField();
		myTxtEmpruntE.setBounds(550, 310, 100, 31);
		myTxtEmpruntE.setText("Exemplaire");
		myTxtEmpruntE.setHorizontalAlignment(JTextField.CENTER);
		myTxtEmpruntE.setEnabled(false);
		myTxtEmpruntE.setDisabledTextColor(Color.BLACK);

		this.add(myTxtEmpruntE);

		myTxtEmpruntAd = new JTextField();
		myTxtEmpruntAd.setBounds(660, 310, 197, 31);
		myTxtEmpruntAd.setText("Adhérent");
		myTxtEmpruntAd.setHorizontalAlignment(JTextField.CENTER);
		myTxtEmpruntAd.setEnabled(false);
		myTxtEmpruntAd.setDisabledTextColor(Color.BLACK);

		this.add(myTxtEmpruntAd);
	}

	////////////////////////////////////////////////////////////////////////
	
	private void initTextFielAddRepair() {
		this.myLblARepair = new JLabel();
		myLblARepair.setText("Add Réparation :");
		myLblARepair.setBounds(10, 270, 978, 30);
		myLblARepair.setHorizontalAlignment(JLabel.CENTER);

		this.add(myLblARepair);

		DefaultListCellRenderer dlcr = new DefaultListCellRenderer();
		dlcr.setHorizontalAlignment(JLabel.CENTER);

		myComboBoxRepairL = new JComboBox<Object>();
		myComboBoxRepairL.setRenderer(dlcr);
		myComboBoxRepairL.setBounds(10, 310, 630, 31);
		myComboBoxRepairL.setMaximumRowCount(5);

		this.add(myComboBoxRepairL);

		myComboBoxRepairE = new JComboBox<Object>();
		myComboBoxRepairE.setRenderer(dlcr);
		myComboBoxRepairE.setBounds(650, 310, 207, 31);
		myComboBoxRepairE.setMaximumRowCount(5);

		this.add(myComboBoxRepairE);

		// init data
		ArrayList<String> comboL = new ArrayList<String>();
		comboL.add("Livre");
		myComboBoxRepairL.addItem(comboL.get(0));

		ArrayList<String> comboE = new ArrayList<String>();
		comboE.add("Exempl.");
		myComboBoxRepairE.addItem(comboE.get(0));
	}

	////////////////////////////////////////////////////////////////////////
	
	private void initTextFielRemoveRepair() {
		this.myLblRRepair = new JLabel();
		myLblRRepair.setText("Remove Réparation :");
		myLblRRepair.setBounds(10, 270, 978, 30);
		myLblRRepair.setHorizontalAlignment(JLabel.CENTER);

		this.add(myLblRRepair);

		myTxtRepairL = new JTextField();
		myTxtRepairL.setBounds(10, 310, 630, 31);
		myTxtRepairL.setText("Livre");
		myTxtRepairL.setHorizontalAlignment(JTextField.CENTER);
		myTxtRepairL.setEnabled(false);
		myTxtRepairL.setDisabledTextColor(Color.BLACK);

		this.add(myTxtRepairL);

		myTxtRepairE = new JTextField();
		myTxtRepairE.setBounds(650, 310, 207, 31);
		myTxtRepairE.setText("Exemplaire");
		myTxtRepairE.setHorizontalAlignment(JTextField.CENTER);
		myTxtRepairE.setEnabled(false);
		myTxtRepairE.setDisabledTextColor(Color.BLACK);

		this.add(myTxtRepairE);
	}
}
