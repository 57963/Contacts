package com.contacts.UI;


import javax.swing.ImageIcon;
import javax.swing.JFrame;

import com.contacts.core.Core;

import java.awt.GridBagLayout;

import javax.swing.JButton;

import java.awt.GridBagConstraints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ViewPrevMeetingWindow {
	Core core;
	private JFrame frame;


	public ViewPrevMeetingWindow(Core core) {
		this.core = core;
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
		frame.setTitle("View Previous Meeting");
		ImageIcon img = new ImageIcon(
				"src/contact-icon.png");
		frame.setIconImage(img.getImage());
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
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
		gbc_btnBack.gridx = 0;
		gbc_btnBack.gridy = 0;
		frame.getContentPane().add(btnBack, gbc_btnBack);
	}

	public void setVisible(boolean b) {
		if (b) {
			frame.setVisible(true);
		}

	}

}
