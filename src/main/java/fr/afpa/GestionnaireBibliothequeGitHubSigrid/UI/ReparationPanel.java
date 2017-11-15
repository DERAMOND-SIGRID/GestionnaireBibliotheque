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
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

public class ReparationPanel extends JPanel{

	private static final long serialVersionUID = 1L;

	private DefaultTableModel myTableModel;
	
	public ReparationPanel(){
		this.setOpaque(false);
		this.setLayout(null);

		JLabel myLbl = new JLabel();
		myLbl.setBounds(0, 0, 997, 30);
		myLbl.setText("Réparations");
		myLbl.setHorizontalAlignment(JLabel.CENTER);

		this.add(myLbl);

		JButton myBtAdd = new JButton();
		myBtAdd.setBounds(867, 60, 121, 29);
		myBtAdd.setText("Ajouter");
		myBtAdd.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
			}

		});

		this.add(myBtAdd);

		Object[] myObj = {"n°Exempl.","ISBN","Titre","Auteur"};
		myTableModel = new DefaultTableModel(myObj, 0) {
			
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int col) {
				return false;
			}
		};

		DefaultTableCellRenderer txtCellCenter = new DefaultTableCellRenderer();
		txtCellCenter.setHorizontalAlignment(JLabel.CENTER);
		
		JTable myTable = new JTable(myTableModel){
			 
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
		
		myTable.setOpaque(false);
		
		myTable.getTableHeader().setBackground(new Color(105,105,105));
		myTable.getTableHeader().setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		myTable.setGridColor(new Color(220,220,220));
		
		JScrollPane myScrollPane = new JScrollPane(myTable);
		myScrollPane.setBounds(10, 40, 847, 637);
		myScrollPane.setOpaque(false);
		myScrollPane.getViewport().setOpaque(false);
		myScrollPane.setBorder(BorderFactory.createLineBorder(new Color(220,220,220)));

		this.add(myScrollPane);

		JButton myBtRemove = new JButton();
		myBtRemove.setBounds(867, 100, 121, 29);
		myBtRemove.setText("Supprimer");
		myBtRemove.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				/*
				if(myTableCategorie.getSelectedRow()!=-1){
					String oldName=(String) myTableModelCategorie.getValueAt(myTableCategorie.getSelectedRow(), 0);
					
				}
				*/
			}

		});

		this.add(myBtRemove);

		// init data
		//ArrayList<Exemplaire> myarray=new ArrayList<Exemplaire>();
		
	}
}
