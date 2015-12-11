package com.contacts.UI;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;

import javax.swing.JButton;

import java.awt.GridBagConstraints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Insets;

public class NewMeetingWindow {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewMeetingWindow window = new NewMeetingWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public NewMeetingWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		ContactManagerWindow ContactManagerWindow = new ContactManagerWindow();
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("New Meeting");
		ImageIcon img = new ImageIcon("/Users/CompUser/workspace/Contacts/Contacts v2/src/contact-icon.png");
		frame.setIconImage(img.getImage());
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		JButton btnBack = new JButton("Back");
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				ContactManagerWindow.setVisible(true);
				frame.setVisible(false);
			}
		});
		GridBagConstraints gbc_btnBack = new GridBagConstraints();
		gbc_btnBack.insets = new Insets(0, 0, 5, 5);
		gbc_btnBack.gridx = 0;
		gbc_btnBack.gridy = 0;
		frame.getContentPane().add(btnBack, gbc_btnBack);
		
		JButton btnSave = new JButton("Save");
		GridBagConstraints gbc_btnSave = new GridBagConstraints();
		gbc_btnSave.insets = new Insets(0, 0, 0, 5);
		gbc_btnSave.gridx = 0;
		gbc_btnSave.gridy = 8;
		frame.getContentPane().add(btnSave, gbc_btnSave);
	}

	public void setVisible(boolean b) {
		if (b){
			frame.setVisible(true);
		}
		
	}

}
