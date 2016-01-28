package com.contacts.UI;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import java.awt.GridBagLayout;

import javax.swing.JButton;

import com.contacts.contact.Contact;
import com.contacts.core.Core;

import java.awt.GridBagConstraints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


import java.awt.Insets;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JMenuBar;

public class SearchContactWindow {
	private JFrame frame;
	private JTextField txtSearchvalue;
	Core core;

	public SearchContactWindow(Core core) {
		this.core = core;
		initialize(core);
	}


	
	private void initialize(Core core) {
		initialize();
	}

	private void initialize() {
		ContactManagerWindow ContactManagerWindow = new ContactManagerWindow();
		frame = new JFrame();
		frame.setBounds(100, 100, 500, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Search Contacts");
		ImageIcon img = new ImageIcon("src/contact-icon.png");
		frame.setIconImage(img.getImage());
		frame.getContentPane().setLayout(new GridLayout(0, 1, 0, 0));

		JPanel panel = new JPanel();
		frame.getContentPane().add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 106, 62, 297, 0 };
		gbl_panel.rowHeights = new int[] { 21, 23, 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 1.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 1.0 };
		panel.setLayout(gbl_panel);

		JButton btnBack = new JButton("Back");
		GridBagConstraints gbc_btnBack = new GridBagConstraints();
		gbc_btnBack.insets = new Insets(0, 0, 5, 5);
		gbc_btnBack.gridx = 0;
		gbc_btnBack.gridy = 0;
		panel.add(btnBack, gbc_btnBack);

		JLabel lblSearchValue = new JLabel("Search Name");
		GridBagConstraints gbc_lblSearchValue = new GridBagConstraints();
		gbc_lblSearchValue.anchor = GridBagConstraints.EAST;
		gbc_lblSearchValue.insets = new Insets(0, 0, 5, 5);
		gbc_lblSearchValue.gridx = 1;
		gbc_lblSearchValue.gridy = 0;
		panel.add(lblSearchValue, gbc_lblSearchValue);

		txtSearchvalue = new JTextField();
		GridBagConstraints gbc_txtSearchvalue = new GridBagConstraints();
		gbc_txtSearchvalue.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtSearchvalue.insets = new Insets(0, 0, 5, 0);
		gbc_txtSearchvalue.gridx = 2;
		gbc_txtSearchvalue.gridy = 0;
		panel.add(txtSearchvalue, gbc_txtSearchvalue);
		txtSearchvalue.setColumns(10);

		JButton btnSearch = new JButton("Search");
		btnSearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					ArrayList<Contact> getList = core.getContactList().search(txtSearchvalue.toString());
					for (int x = 0; x > getList.size(); x++) {
						// JMenuItem item = new
						// JMenuItem(getList.get(x).getFirstName());
						// menuBar.add(item);
					}

				} catch (NullPointerException e1) {
					// JMenuItem Error = new JMenuItem("No Contacts Found");
					// menuBar.add(Error);
				}
			}
		});
		GridBagConstraints gbc_btnSearch = new GridBagConstraints();
		gbc_btnSearch.insets = new Insets(0, 0, 5, 0);
		gbc_btnSearch.gridx = 2;
		gbc_btnSearch.gridy = 1;
		panel.add(btnSearch, gbc_btnSearch);

		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));

		JMenuBar menuBar = new JMenuBar();
		panel_1.add(menuBar);

		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ContactManagerWindow.setVisible(true);
				frame.setVisible(false);
			}
		});

	}

	public void setVisible(boolean b) {
		if (b) {
			frame.setVisible(true);
		}

	}

}
