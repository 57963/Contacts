package com.contacts.UI;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import java.awt.GridBagLayout;

import javax.swing.JButton;

import com.contacts.core.Core;

import java.awt.GridBagConstraints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JComboBox;

import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JTextPane;
import javax.swing.JScrollBar;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.JTable;

public class SearchContactWindow {

	private JFrame frame;
	private JTextField txtSearchvalue;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchContactWindow window = new SearchContactWindow();
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
	public SearchContactWindow(Core core) {
		initialize(core);
	}
	public SearchContactWindow(){
		initialize(null);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Core core) {
		 String[] fields = { "Firstname", "Surname", "Home Number",
			      "Mobile Number", "City"};
		ContactManagerWindow ContactManagerWindow = new ContactManagerWindow();
		frame = new JFrame();
		frame.setBounds(100, 100, 500, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Search Contacts");
		ImageIcon img = new ImageIcon("/Users/CompUser/workspace/Contacts/Contacts v2/src/contact-icon.png");
		frame.setIconImage(img.getImage());
		frame.getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{106, 62, 297, 0};
		gbl_panel.rowHeights = new int[]{21, 23, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0};
		panel.setLayout(gbl_panel);
		
		JButton btnBack = new JButton("Back");
		GridBagConstraints gbc_btnBack = new GridBagConstraints();
		gbc_btnBack.insets = new Insets(0, 0, 5, 5);
		gbc_btnBack.gridx = 0;
		gbc_btnBack.gridy = 0;
		panel.add(btnBack, gbc_btnBack);
		
		JLabel lblSearchValue = new JLabel("Search Value");
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
		GridBagConstraints gbc_btnSearch = new GridBagConstraints();
		gbc_btnSearch.insets = new Insets(0, 0, 5, 5);
		gbc_btnSearch.gridx = 0;
		gbc_btnSearch.gridy = 1;
		panel.add(btnSearch, gbc_btnSearch);
		
		JLabel lblSearchFor = new JLabel("Search for :");
		GridBagConstraints gbc_lblSearchFor = new GridBagConstraints();
		gbc_lblSearchFor.anchor = GridBagConstraints.EAST;
		gbc_lblSearchFor.insets = new Insets(0, 0, 5, 5);
		gbc_lblSearchFor.gridx = 1;
		gbc_lblSearchFor.gridy = 1;
		panel.add(lblSearchFor, gbc_lblSearchFor);
		
		JComboBox comboBoxSearchCriteria = new JComboBox();
		GridBagConstraints gbc_comboBoxSearchCriteria = new GridBagConstraints();
		gbc_comboBoxSearchCriteria.insets = new Insets(0, 0, 5, 0);
		gbc_comboBoxSearchCriteria.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxSearchCriteria.gridx = 2;
		gbc_comboBoxSearchCriteria.gridy = 1;
		panel.add(comboBoxSearchCriteria, gbc_comboBoxSearchCriteria);
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));
		
		JTextPane txtpnSomeDataAbout = new JTextPane();
		txtpnSomeDataAbout.setText("Some Data about some contact");
		panel_1.add(txtpnSomeDataAbout);
		
		JScrollBar scrollBar = new JScrollBar();
		panel_1.add(scrollBar);
		Object cmboitem = comboBoxSearchCriteria.getSelectedItem();
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ContactManagerWindow.setVisible(true);
				frame.setVisible(false);
			}
		});
		for (int i=0; i < fields.length; i++){
			comboBoxSearchCriteria.addItem(fields[i]);
		}
	    System.out.println(cmboitem);
	}
	public void setVisible(boolean b) {
		if (b){
			frame.setVisible(true);
		}
		
	}
}
