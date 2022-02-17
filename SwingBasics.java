package com.masimba;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import javax.swing.table.AbstractTableModel;
import java.awt.Color;
import javax.swing.JLabel;

public class SwingBasics {

	private JFrame frame;
	private final JTable table = new JTable();
	private int rows = 10;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SwingBasics window = new SwingBasics();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	class TableData extends AbstractTableModel {

		private static final long serialVersionUID = 6275276519011084505L;

		@Override
		public int getRowCount() {
			// TODO Auto-generated method stub
			return rows;
		}

		@Override
		public int getColumnCount() {
			// TODO Auto-generated method stub
			return 7;
		}

		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			// TODO Auto-generated method stub
			return "Hello";
		}
		
	}

	public SwingBasics() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBackground(Color.BLUE);
		frame.getContentPane().setLayout(null);
		
		//TABLE SETUP
		table.setBounds(0, 12, 440, rows*16);
		table.setBorder(new BevelBorder(BevelBorder.LOWERED));
		table.setBackground(Color.MAGENTA);
		//Associate Model with the table
		TableData data = new TableData();
		table.setModel(data);
		frame.getContentPane().add(table);
		
		
		//LABEL SETUP
		JLabel lblNewLabel = new JLabel("Table class");
		lblNewLabel.setBackground(Color.MAGENTA);
		lblNewLabel.setBounds(173, 0, 109, 15);
		frame.getContentPane().add(lblNewLabel);
		
	}
}
