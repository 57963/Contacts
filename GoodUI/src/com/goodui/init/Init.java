package com.goodui.init;

import com.contacts.Core;

import processing.core.*;

public class Init extends PApplet{
	Core core;
	public static void main(String _args[]) {
		PApplet.main(new String[] { goodui.GoodUI.class.getName() });
	}
	
	public void setup() {
		core = new Core();
		noStroke();
	}

	public void settings() {
		size(1000, 700);
	}
	
	public void draw(){
		
	}

}
