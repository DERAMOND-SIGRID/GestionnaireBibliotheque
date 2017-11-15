package fr.afpa.GestionnaireBibliothequeGitHubSigrid.UI;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import fr.afpa.GestionnaireBibliothequeGitHubSigrid.Controller.ControllerLivre;
import fr.afpa.GestionnaireBibliothequeGitHubSigrid.Model.Livre;

public class PanelLivre extends JPanel{

	private static final long serialVersionUID = 1L;

	private DefaultTableModel myTableModel;
	
	public PanelLivre(ControllerLivre controller){
		this.setOpaque(false);
		this.setLayout(null);
		
		JLabel myLbl=new JLabel();
		myLbl.setBounds(0, 0, 997, 30);
		myLbl.setText("Livres");
		myLbl.setHorizontalAlignment(JLabel.CENTER);
		
		this.add(myLbl);
		
		JButton myBtAdd=new JButton();
		myBtAdd.setBounds(867, 60, 121, 29);
		myBtAdd.setText("Ajouter");
		myBtAdd.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
			}
			
		});
		
		this.add(myBtAdd);
		
		Object[] myObj={"ISBN","Titre","Sous Titre","Auteur","Catégorie","Disponibilité"};
		myTableModel=new DefaultTableModel(myObj,0){
		
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int col){
				return false;
			}
		};
		
		DefaultTableCellRenderer txtCellCenter=new DefaultTableCellRenderer();
		txtCellCenter.setHorizontalAlignment(JLabel.CENTER);
		
		JTable myTable=new JTable(myTableModel){
		
			private static final long serialVersionUID = 1L;

			public Component prepareRenderer(TableCellRenderer renderer, int index_row, int index_col) {
		            Component comp = super.prepareRenderer(renderer, index_row, index_col);
		            //odd col index, selected or not selected
		            if(isCellSelected(index_row, index_col)){
		               comp.setBackground(new Color(170,170,170));  
		            }else {
		                comp.setBackground(Color.GRAY);
		            }
		            return comp;
		        }
		};
		
		DefaultTableColumnModel column=(DefaultTableColumnModel) myTable.getColumnModel();
		column.getColumn(0).setCellRenderer(txtCellCenter);
		column.getColumn(1).setCellRenderer(txtCellCenter);
		column.getColumn(2).setCellRenderer(txtCellCenter);
		column.getColumn(3).setCellRenderer(txtCellCenter);
		column.getColumn(4).setCellRenderer(txtCellCenter);
		column.getColumn(5).setCellRenderer(txtCellCenter);
		
		myTable.setOpaque(false);
		
		myTable.getTableHeader().setBackground(new Color(105,105,105));
		myTable.getTableHeader().setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		myTable.setGridColor(new Color(220,220,220));
		
		JScrollPane myScrollPane=new JScrollPane(myTable);
		myScrollPane.setBounds(10, 40, 847, 637);
		myScrollPane.setOpaque(false);
		myScrollPane.getViewport().setOpaque(false);
		myScrollPane.setBorder(BorderFactory.createLineBorder(new Color(220,220,220)));
		
		this.add(myScrollPane);
		
		JButton myBtEdit=new JButton();
		myBtEdit.setBounds(867, 100, 121, 29);
		myBtEdit.setText("Editer");
		myBtEdit.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				
				
			}
			
		});
		
		this.add(myBtEdit);
		
		JButton myBtRemove=new JButton();
		myBtRemove.setBounds(867, 140, 121, 29);
		myBtRemove.setText("Supprimer");
		myBtRemove.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				
			}
			
		});
		
		this.add(myBtRemove);
		
		JButton myBtListExemplaire=new JButton();
		myBtListExemplaire.setBounds(867, 509, 121, 49);
		myBtListExemplaire.setText("<html><center>"+"Liste"+"<br>"+"Exemplaires"+"</center></html>");
		myBtListExemplaire.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				
			}
			
		});
		
		this.add(myBtListExemplaire);
		
		JButton myBtAddExemplaire=new JButton();
		myBtAddExemplaire.setBounds(867, 569, 121, 49);
		myBtAddExemplaire.setText("<html><center>"+"Ajouter"+"<br>"+"Exemplaire"+"</center></html>");
		myBtAddExemplaire.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				
			}
			
		});
		
		this.add(myBtAddExemplaire);
		
		JButton myBtRemoveExemplaire=new JButton();
		myBtRemoveExemplaire.setBounds(867, 629, 121, 49);
		myBtRemoveExemplaire.setText("<html><center>"+"Supprimer"+"<br>"+"Exemplaire"+"</center></html>");
		myBtRemoveExemplaire.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				
			}
			
		});
		
		this.add(myBtRemoveExemplaire);
		
		//init data
		ArrayList<Livre> myarray=new ArrayList<Livre>();
		myarray=controller.getAll();
		for(int i=0;i<myarray.size();i++) {
			long isbn=myarray.get(i).getIsbn();
			String titre=myarray.get(i).getTitre();
			String Stitre="";
			if(myarray.get(i).getSous_titre()!=null) {
				Stitre=myarray.get(i).getSous_titre();
			}
			String nomAu=myarray.get(i).getAuteur().getNom_personne();
			String prenomAu=myarray.get(i).getAuteur().getPrenom_personne();
			
			String nomC="";
			if(myarray.get(i).getCategorie()!=null) {
				nomC=myarray.get(i).getCategorie().getNom_categorie();
			}
			boolean isDispo=myarray.get(i).isEst_dispo();
			String disponibilite="indisponible";
			if(isDispo==true) {
				disponibilite="disponible";
			}
				
				Object[] myobj= {isbn, titre, Stitre, nomAu+" "+prenomAu, nomC,disponibilite };
			
			myTableModel.addRow(myobj);
		}
		
	}
}
