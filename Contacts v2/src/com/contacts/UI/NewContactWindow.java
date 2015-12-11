package com.contacts.UI;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import java.awt.GridBagLayout;

import javax.swing.JButton;

import java.awt.GridBagConstraints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;

import java.awt.Insets;

import javax.swing.JTextField;

import com.contacts.contact.Contact;
import com.contacts.core.Core;

public class NewContactWindow {

	private JFrame frame;
	private JTextField textFieldFirstName;
	private JTextField textFieldSurname;
	private JTextField textFieldHomeNumber;
	private JTextField textFieldMobileNumber;
	private JTextField textFieldCity;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewContactWindow window = new NewContactWindow();
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
	public NewContactWindow(Core core) {
		initialize(core);
	}
	public NewContactWindow(){
		initialize(null);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Core core) {
		
		ContactManagerWindow ContactManagerWindow = new ContactManagerWindow();
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("New Contact");
		ImageIcon img = new ImageIcon("/Users/CompUser/workspace/Contacts/Contacts v2/src/contact-icon.png");
		frame.setIconImage(img.getImage());
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
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
		
		JLabel lblFirstName = new JLabel("First Name");
		GridBagConstraints gbc_lblFirstName = new GridBagConstraints();
		gbc_lblFirstName.anchor = GridBagConstraints.EAST;
		gbc_lblFirstName.insets = new Insets(0, 0, 5, 5);
		gbc_lblFirstName.gridx = 1;
		gbc_lblFirstName.gridy = 2;
		frame.getContentPane().add(lblFirstName, gbc_lblFirstName);
		
		textFieldFirstName = new JTextField();
		GridBagConstraints gbc_textFieldFirstName = new GridBagConstraints();
		gbc_textFieldFirstName.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldFirstName.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldFirstName.gridx = 2;
		gbc_textFieldFirstName.gridy = 2;
		frame.getContentPane().add(textFieldFirstName, gbc_textFieldFirstName);
		textFieldFirstName.setColumns(10);
		
		JLabel lblSurname = new JLabel("Surname");
		GridBagConstraints gbc_lblSurname = new GridBagConstraints();
		gbc_lblSurname.anchor = GridBagConstraints.EAST;
		gbc_lblSurname.insets = new Insets(0, 0, 5, 5);
		gbc_lblSurname.gridx = 1;
		gbc_lblSurname.gridy = 3;
		frame.getContentPane().add(lblSurname, gbc_lblSurname);
		
		textFieldSurname = new JTextField();
		GridBagConstraints gbc_textFieldSurname = new GridBagConstraints();
		gbc_textFieldSurname.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldSurname.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldSurname.gridx = 2;
		gbc_textFieldSurname.gridy = 3;
		frame.getContentPane().add(textFieldSurname, gbc_textFieldSurname);
		textFieldSurname.setColumns(10);
		
		JLabel lblHomeNumber = new JLabel("Home Number");
		GridBagConstraints gbc_lblHomeNumber = new GridBagConstraints();
		gbc_lblHomeNumber.anchor = GridBagConstraints.EAST;
		gbc_lblHomeNumber.insets = new Insets(0, 0, 5, 5);
		gbc_lblHomeNumber.gridx = 1;
		gbc_lblHomeNumber.gridy = 4;
		frame.getContentPane().add(lblHomeNumber, gbc_lblHomeNumber);
		
		textFieldHomeNumber = new JTextField();
		GridBagConstraints gbc_textFieldHomeNumber = new GridBagConstraints();
		gbc_textFieldHomeNumber.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldHomeNumber.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldHomeNumber.gridx = 2;
		gbc_textFieldHomeNumber.gridy = 4;
		frame.getContentPane().add(textFieldHomeNumber, gbc_textFieldHomeNumber);
		textFieldHomeNumber.setColumns(10);
		
		JLabel lblMobileNumber = new JLabel("Mobile Number");
		GridBagConstraints gbc_lblMobileNumber = new GridBagConstraints();
		gbc_lblMobileNumber.anchor = GridBagConstraints.EAST;
		gbc_lblMobileNumber.insets = new Insets(0, 0, 5, 5);
		gbc_lblMobileNumber.gridx = 1;
		gbc_lblMobileNumber.gridy = 5;
		frame.getContentPane().add(lblMobileNumber, gbc_lblMobileNumber);
		
		textFieldMobileNumber = new JTextField();
		GridBagConstraints gbc_textFieldMobileNumber = new GridBagConstraints();
		gbc_textFieldMobileNumber.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldMobileNumber.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldMobileNumber.gridx = 2;
		gbc_textFieldMobileNumber.gridy = 5;
		frame.getContentPane().add(textFieldMobileNumber, gbc_textFieldMobileNumber);
		textFieldMobileNumber.setColumns(10);
		
		JLabel lblCity = new JLabel("City");
		GridBagConstraints gbc_lblCity = new GridBagConstraints();
		gbc_lblCity.anchor = GridBagConstraints.EAST;
		gbc_lblCity.insets = new Insets(0, 0, 5, 5);
		gbc_lblCity.gridx = 1;
		gbc_lblCity.gridy = 6;
		frame.getContentPane().add(lblCity, gbc_lblCity);
		
		textFieldCity = new JTextField();
		GridBagConstraints gbc_textFieldCity = new GridBagConstraints();
		gbc_textFieldCity.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldCity.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldCity.gridx = 2;
		gbc_textFieldCity.gridy = 6;
		frame.getContentPane().add(textFieldCity, gbc_textFieldCity);
		textFieldCity.setColumns(10);
		
		JButton btnSave = new JButton("Save");
		btnSave.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				core.contactList.add(new Contact());
				core.contactList.getJustAdded().setFirstName(textFieldFirstName.getText());
				core.contactList.getJustAdded().setSurName(textFieldSurname.getText());
				core.contactList.getJustAdded().setHomeNumber(textFieldHomeNumber.getText());
				core.contactList.getJustAdded().setMobileNumber(textFieldMobileNumber.getText());
				core.contactList.getJustAdded().setCity(textFieldCity.getText());
				core.printContact(core.contactList.getJustAdded());

				
				
			}
		});
		GridBagConstraints gbc_btnSave = new GridBagConstraints();
		gbc_btnSave.insets = new Insets(0, 0, 0, 5);
		gbc_btnSave.gridx = 0;
		gbc_btnSave.gridy = 9;
		frame.getContentPane().add(btnSave, gbc_btnSave);
	}
	public void setVisible(boolean b) {
		if (b){
			frame.setVisible(true);
		}
		
	}
}
