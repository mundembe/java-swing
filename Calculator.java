package com;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;


public class Calculator {

	JFrame frame;
	int fWidth = 420, fHeight = 550;
	
	JButton[] buttons = {
			new JButton(), new JButton(), new JButton(), new JButton(),
			new JButton(), new JButton(), new JButton(), new JButton(),
			new JButton(), new JButton(), new JButton(), new JButton(),
			new JButton(), new JButton(), new JButton(), new JButton(),
			new JButton(), new JButton(), new JButton(), new JButton()			
	};
	String[] bText = {
			"7", "4", "1", "0", "<--",
			"8", "5", "2", "+", "-", 
			"9", "6", "3", "X", "/", 
			"", "", "", "", ""
	};
	String[] silentButtons = {
			"<--"
	};
	int silentButton_count = 0;
	String screenText = "";
	String answer = "...";
	String term = "";
	String lastTerm;
	boolean RHS_ready = false;
	String operand;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculator window = new Calculator();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Calculator() {
		mkFrame();
	}

	private void mkFrame() {

		JFrame frame = new JFrame();
		frame.setBounds(0, 0, fWidth , fHeight);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

		mkPanel(frame);
		
	}
	
	public void mkPanel(JFrame frame) {
		JPanel bgPanel = new JPanel();
		bgPanel.setLayout(null);
		bgPanel.setBackground(Color.gray);
		bgPanel.setBorder(new MatteBorder(0, 10, 10, 10, Color.pink));
		frame.getContentPane().add(bgPanel);
		
		JTextField ansScreen = new JTextField();
		ansScreen.setBorder(new BevelBorder(BevelBorder.RAISED));
		ansScreen.setBounds(15, 25, fWidth - 40, 60);
		ansScreen.setText(screenText);
		bgPanel.add(ansScreen);
		
		JTextField ansField = new JTextField();
		ansField.setBorder(new BevelBorder(BevelBorder.RAISED));
		ansField.setBounds(255, 5, 120, 50);
		ansField.setBackground(Color.cyan);
		ansField.setText(answer);
		ansScreen.add(ansField);
		
		JPanel keyPad = new JPanel();
		keyPad.setLayout(null);
		keyPad.setBounds(10, 90, fWidth - 30, fHeight - 133 );
		keyPad.setBackground(Color.lightGray);
		bgPanel.add(keyPad);
		
		mkButtons(keyPad);
		processActions(ansScreen, ansField);
		mkTopMenuBar(bgPanel);
		
	}
	
	public void processActions(JTextField ansScreen, JTextField ansField) {

		for (int i = 0; i < buttons.length; i++) {
			
			int buttonPressed = i;
			String  text = bText[i];
			
			for (int j = 0; j < silentButtons.length; j++) {
				if(buttons[i].getText() != silentButtons[j]) {
					buttons[i].addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							screenText = screenText + text;
							ansScreen.setText(screenText);
							toNumStream(text);
							
							switch(buttonPressed) {
								case 8:	
									operand = "+";
									toNumStream(text);
									break;

								case 9:
									operand = "-";
									toNumStream(text);
									break;
								case 19:
									if (operand == "+") {
										toNumStream("+");
										answer = lastTerm.toString();
										
									}
									ansField.setText(answer);
									ansScreen.setText(answer);
									break;
							}
						}	
					});	
				}

			}
				
		}

		buttons[4].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				screenText = screenText.substring(0, screenText.length() - 1);
				ansScreen.setText(screenText);		

			}	
		});		
	}

	public void toNumStream(String text) {

		if (text == "+") {
			if (!RHS_ready) {
				lastTerm = term; 
				term = "";
			}else {
				term = term + lastTerm;
			}
			
			RHS_ready = !RHS_ready;
		}
		
	}
	
	public void mkButtons(JPanel keyPad) {
		
		int w = 70, h = 50, x = 0 - w, y = 20;
		
		for (int i = 0; i < buttons.length; i++) {
			if (i % 5 == 0) {
				x += w + 20;
				y = 20;
			}
			if (i > 14)
				w = 90;
			buttons[i].setBounds(x, y, w, h);
			buttons[i].setBorder(new BevelBorder(BevelBorder.RAISED));
			buttons[i].setBackground(Color.gray);
			buttons[i].setFont(new Font("Ariel", Font.BOLD, 28));
			buttons[i].setText(bText[i]);
			keyPad.add(buttons[i]);
			y += h + 20;
		
		}
	}
	
	public void mkTopMenuBar(JPanel bgPanel) {
		
		JMenuItem aboutMe = new JMenuItem("About Me");
		
		JMenu Menu = new JMenu("Menu");
		Menu.setBounds(0, 0, 100, 20);
		Menu.setBackground(Color.red);
		Menu.add(aboutMe);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(10, 0, fWidth - 10, 20);
		menuBar.setBackground(Color.pink);
		
		menuBar.add(Menu);
		
		bgPanel.add(menuBar);
		
	}
	
	
}
