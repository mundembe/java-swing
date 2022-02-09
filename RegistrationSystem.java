package com;

import java.awt.EventQueue;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.DefaultComboBoxModel;

public class Registration_System{
	
	private JFrame frame;	
	private JPanel lpanel;
	
	//////////////////////////////////////////////-------------Left Panel Arrays--------------------//////////////////////////////////////////
	JLabel[] lLabels = new JLabel[]{
			new JLabel(), new JLabel(), new JLabel(), new JLabel(), new JLabel(),
			new JLabel(), new JLabel(), new JLabel(), new JLabel(),new JLabel()
			
	};
	JTextField[] lTextFields = new JTextField[] {
		new JTextField(), new JTextField(), new JTextField(), new JTextField(), new JTextField(),
		new JTextField(), new JTextField()
	};
	JComboBox[] comboBoxes = new JComboBox[] {
		new JComboBox<Object>(), new JComboBox<Object>(), new JComboBox<Object>()
	};
	DefaultComboBoxModel proofOfID = new DefaultComboBoxModel(new String[] {"Make a Selection", "Study Permit", "Driving Licence", "Pilot Licence", "Passport" } );
	DefaultComboBoxModel membershipType = new DefaultComboBoxModel(new String[] {"Make a Selection", "Monthly", "Quarterly", "Bi-monthly", "Annually" } );
	DefaultComboBoxModel amountPaid = new DefaultComboBoxModel(new String[] {"Make a Selection","R50", "R100", "R500", "R1000" } );
	DefaultComboBoxModel[] modelData = {proofOfID, membershipType, amountPaid};													//-----------------comboBox	
	String[] labelText = {"Reference no.", "First name", "Surname", "Address", "Post Code", "Telephone", "Date reg.", "Proof of ID", "Membership Type", "Amount Paid"};
	////////////////////////////////////////////-------------Left Panel Arrays--------------------/////////////////////////////////////////////

	
	////////////////////////////////////////////------------Bottom Panel Arrays--------------------/////////////////////////////////////////////
	JButton[] bButtons = new JButton[] {
			new JButton(), new JButton(), new JButton(), new JButton(), new JButton()
		};
	////////////////////////////////////////////------------Bottom Panel Arrays--------------------/////////////////////////////////////////////
  
	//Launch the application.
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registration_System window = new Registration_System();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	//Create the application.
	public Registration_System() {
		initialize();
	}

	//Create the frame.
	private void initialize() {
		frame = new JFrame("Registration System");
		frame.setBounds(0, 0, 1400, 750);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel bgpanel = new JPanel();
		bgpanel.setBounds(5, 5, 1360, 700);
		bgpanel.setBorder(new MatteBorder(14, 14, 14, 14, Color.blue));
		bgpanel.setBackground(Color.pink);
		bgpanel.setLayout(null);
		frame.getContentPane().add(bgpanel);
		
		/////////////////////////////////////////--------------TOP PANEL----------------////////////////////////////////////
		JPanel tpanel = new JPanel();
		tpanel.setLayout(null);
		tpanel.setBounds(14, 14, 1332, 50);
		tpanel.setBorder(new MatteBorder(7, 7, 7, 7, Color.red));
		tpanel.setBackground(Color.pink);
		bgpanel.add(tpanel);
		
		JLabel tLabel = new JLabel("Membership Registration System");
		tLabel.setFont(new Font("MathJax_Math", Font.PLAIN, 28));
		tLabel.setBounds(450, 14, 493, 26);
		tpanel.add(tLabel);
		/////////////////////////////////////////--------------LEFT PANEL----------------///////////////////////////////////
		lpanel = new JPanel();
		lpanel.setLayout(null);
		lpanel.setBounds(50, 70, 600, 450);
		lpanel.setBorder(new MatteBorder(7, 7, 7, 7, Color.red));
		lpanel.setBackground(Color.pink);
		bgpanel.add(lpanel);
		
		LeftComponents();
		
		/////////////////////////////////////////--------------RIGHT PANEL----------------//////////////////////////////////
		JPanel rpanel = new JPanel();
		rpanel.setLayout(null);
		rpanel.setBounds(700, 70, 600, 450);
		rpanel.setBorder(new MatteBorder(7, 7, 7, 7, Color.red));
		rpanel.setBackground(Color.pink);
		bgpanel.add(rpanel);
		
		RightTable(rpanel);
		
		/////////////////////////////////////////--------------BOTTOM PANEL----------------/////////////////////////////////
		JPanel btpanel = new JPanel();
		btpanel.setLayout(null);
		btpanel.setBounds(14, 550, 1332, 100);
		btpanel.setBorder(new MatteBorder(7, 7, 7, 7, Color.red));
		btpanel.setBackground(Color.pink);
		bgpanel.add(btpanel);
		
		BottomComponents(btpanel);		
	}
	
	public void RightTable(JPanel rpanel) {
		
		JTable table = new JTable();
		Object[] columns = {"Reference no.", "First name", "Surname", "Address", "Post Code", "Telephone", "Date reg.", "Proof of ID", "Membership Type", "Amount Paid"};
		DefaultTableModel model = new DefaultTableModel();
				
		
		
		table.setGridColor(Color.red);
		table.setRowHeight(30);
		table.setAutoCreateRowSorter(true);	
		model.setColumnIdentifiers(columns);
		table.setModel(model);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10,10,580,430);
		rpanel.add(scrollPane);
		
		//ADD
		bButtons[0].addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
								
				model.addRow(new Object[] {
					lTextFields[0].getText(),
					lTextFields[1].getText(),
					lTextFields[2].getText(),
					lTextFields[3].getText(),
					lTextFields[4].getText(),
					lTextFields[5].getText(),
					lTextFields[6].getText(),
					comboBoxes[0].getSelectedItem(),
					comboBoxes[1].getSelectedItem(),
					comboBoxes[2].getSelectedItem()
				});
			
			if (table.getSelectedRow() == -1) {
				if (table.getRowCount() == 0) {
					JOptionPane.showMessageDialog(null, "membership update confirmed", "management System", JOptionPane.OK_OPTION);
				}
			}
			
			bButtons[1].doClick();		//RESET left panel
			
			}
		});
				
		//PRINT
		bButtons[2].addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				try {
					table.print();
				}catch(java.awt.print.PrinterException pe){
					System.err.format("Sorry, Print Option Is Unavailable", pe.getMessage());
				}
				
			}
			
		});
				
		//DELETE
		bButtons[3].addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				if (table.getSelectedRow() == -1) {
					if (table.getRowCount() == 0) {
						JOptionPane.showMessageDialog(null, "There are no rows to delete", "TABLE EMPTY", JOptionPane.OK_OPTION);
					}else {
						JOptionPane.showMessageDialog(null, "Please Select A Row", "NO ROW SELECTED", JOptionPane.OK_OPTION);
					}
				}else {
					model.removeRow(table.getSelectedRow());
				}
				
			}
			
			
		});	
	}
	
	@SuppressWarnings("unchecked")
	public void LeftComponents() {
		
		int h = 30;
		int yLabel = 8;
		int yTextField = 8;
		
		
		/////////////-------Declare & define
		for (int i = 0; i < lLabels.length; i++) {
			lLabels[i].setText(labelText[i]);
			lLabels[i].setFont(new Font("MathJax_Math", Font.PLAIN, 25));
			lLabels[i].setBounds(10, yLabel, 300, h);
			lpanel.add(lLabels[i]);
			yLabel += 45;
		}
		for (int i = 0; i < lTextFields.length; i++) {
		lTextFields[i].setFont(new Font("MathJax_Math", Font.PLAIN, 25));
		lTextFields[i].setBounds(250, yTextField, 300, h);
		lpanel.add(lTextFields[i]);
		yTextField += 45;
		}
													//-----------------comboBox
		for (int i = 0; i < comboBoxes.length; i++) {
			comboBoxes[i].setModel(modelData[i]);
			comboBoxes[i].setBounds(250, yTextField, 300, h);

			lpanel.add(comboBoxes[i]);
			yTextField += 45;
		}

	}

	public void BottomComponents(JPanel btpanel) {
		
		int x = 60;
		
		
		String[] buttonText = {"ADD", "RESET","Print", "DELETE", "EXIT"};
		
		for (int i = 0; i < bButtons.length; i++) {
			bButtons[i].setBounds(x, 25, 200, 50);
			bButtons[i].setText(buttonText[i]);
			btpanel.add(bButtons[i]);
			x += 250;
		}
		//RESET
		bButtons[1].addActionListener((ActionListener) new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				for (int i = 0; i < (lTextFields.length + modelData.length); i++) {
					if (i < lTextFields.length) {
						lTextFields[i].setText("");
					}else {
						modelData[i - lTextFields.length].setSelectedItem("Make a Selection");
				}
				}			
			}
			
		});
		
		//EXIT
		bButtons[4].addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				frame = new JFrame();
				if (JOptionPane.showConfirmDialog(frame, "Do you want to exit?", "Registration_System", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
					System.exit(0);
				}
			}
			
		});
		
		
	}
}
