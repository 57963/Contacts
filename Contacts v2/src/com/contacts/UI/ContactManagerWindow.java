package com.contacts.UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JEditorPane;

import java.awt.BorderLayout;

import javax.swing.JButton;

import com.contacts.core.Core;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ContactManagerWindow {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ContactManagerWindow window = new ContactManagerWindow();
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
	public ContactManagerWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
		
		Core core = new Core();
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton btnNewMeeting = new JButton("New Meeting");
		btnNewMeeting.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				NewMeetingWindow NewMeetingWindow = new NewMeetingWindow();
				NewMeetingWindow.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnNewMeeting.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		frame.getContentPane().add(btnNewMeeting);
		
		JButton btnViewPrevMeeting = new JButton("View Previous Meeting");
		btnViewPrevMeeting.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ViewPrevMeetingWindow ViewPrevMeetingWindow = new ViewPrevMeetingWindow();
				ViewPrevMeetingWindow.setVisible(true);
				frame.setVisible(false);
				
			}
		});
		frame.getContentPane().add(btnViewPrevMeeting);
		
		JButton btnSearchContacts = new JButton("Search Contacts");
		btnSearchContacts.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				SearchContactWindow SearchContactWindow = new SearchContactWindow(core);
				
				SearchContactWindow.setVisible(true);
				frame.setVisible(false);
			}
		});
		frame.getContentPane().add(btnSearchContacts);
		
		JButton btnNewContact = new JButton("New Contact");
		btnNewContact.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				NewContactWindow NewContactWindow = new NewContactWindow(core);
				NewContactWindow.setVisible(true);
				frame.setVisible(false);
			}
		});
		frame.getContentPane().add(btnNewContact);
	}
	
	public void setVisible(boolean b) {
		if (b){
			frame.setVisible(true);
		}
		
	}

}
