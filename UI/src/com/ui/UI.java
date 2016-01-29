package com.ui;

import com.contacts.*;

import processing.core.PApplet;


public class UI extends PApplet {
	Core core;
	ContactDisplay display;
	public static void main(String _args[]) {
		PApplet.main(new String[] { com.ui.UI.class.getName() });
	}
	
	public void settings(){
		size(1000,700);
	}

	public void setup() {
		core = new Core();
		core.populate(10);
		display = new ContactDisplay(500,500,core.getContactList().getList(),this);
	}

	public void draw() {
		background(255);
		display.draw();
		println(GenTools.isOverRect(mouseX,mouseY,0,0,10,10));
	}
}