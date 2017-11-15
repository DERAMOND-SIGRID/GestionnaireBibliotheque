package fr.afpa.GestionnaireBibliothequeGitHubSigrid.UI;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

public class AdherentPanel extends JPanel{

	private static final long serialVersionUID = 1L;

	private DefaultTableModel myTableModel;
	
	public AdherentPanel(){
		this.setOpaque(false);
		this.setLayout(null);
		
		JTextField myTxtFieldEmpruntMax=new JTextField();;
		myTxtFieldEmpruntMax.setText("00");
		myTxtFieldEmpruntMax.setEditable(false);
		
		JLabel myLbl=new JLabel();
		myLbl.setBounds(0, 0, 997, 30);
		myLbl.setText("Adhérents");
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
		
		Object[] myObj={"Nom","Prénom"};
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
		
		JLabel myLblEmpruntMax=new JLabel();
		myLblEmpruntMax.setText("<html><center>"+"Nombre"+"<br>"+"Emprunts"+"<br>"+"Maximum"+"</center></html>");
		myLblEmpruntMax.setHorizontalAlignment(JLabel.CENTER);
		myLblEmpruntMax.setBounds(867, 551, 121, 50);
		
		this.add(myLblEmpruntMax);
		
		myTxtFieldEmpruntMax.setHorizontalAlignment(JTextField.CENTER);
		myTxtFieldEmpruntMax.setBounds(906, 609, 50, 30);
		
		this.add(myTxtFieldEmpruntMax);
		
		JButton myBtEditEmpruntMax=new JButton();
		myBtEditEmpruntMax.setText("Editer");
		myBtEditEmpruntMax.setBounds(867, 649, 121, 29);
		
		this.add(myBtEditEmpruntMax);
		
		//init data
		//ArrayList<Adherent> myarray=new ArrayList<Adherent>();
		
	}
}
